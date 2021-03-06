package com.ibm.mentors.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.ibm.mentors.mapper.MentorSkillsMapper;
import com.ibm.mentors.model.MentorBlockUserResponse;
import com.ibm.mentors.model.MentorBlockUsers;
import com.ibm.mentors.model.MentorDetails;
import com.ibm.mentors.model.MentorProfileDetails;
import com.ibm.mentors.model.MentorSearchRequest;
import com.ibm.mentors.model.MentorSearchResponse;
import com.ibm.mentors.model.MentorSkills;
import com.ibm.mentors.model.User;
import com.ibm.mentors.repository.MentorBlockUserRepository;
import com.ibm.mentors.repository.MentorRepository;
import com.ibm.mentors.repository.MentorSkillsRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Service("mentorService")
public class MentorServiceImpl implements MentorService {

	@Autowired
	private MentorRepository mentorRepository;

	@Autowired
	private MentorSkillsRepository mentorSkillsRepository;
	
	@Autowired
	private MentorSkillsMapper mentorSkillsMapper;
	
	@Autowired
	private MentorBlockUserRepository mentorBlockUserRepository;
	
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;
    
    
	@Override
	public MentorProfileDetails getMentorDetails(int mentorId) {
		
		MentorProfileDetails mentorProfileDetails = new MentorProfileDetails();
		
		Application application = eurekaClient.getApplication("users-api");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "users/" + mentorId;
        System.out.println("URL" + url);
        User mentor = restTemplate.getForObject(url, User.class);
        
		
		//User mentor = userRepository.findById(mentorId);
		
		MentorDetails  mentorDetails = mentorRepository.findByMentorId(mentorId);
		
		List<MentorSkills>  mentorSkills = mentorSkillsRepository.findByMentorId(mentorId);
		
		if(mentorDetails!=null) {
			mentorProfileDetails.setMentorId(String.valueOf(mentor.getId()));
			mentorProfileDetails.setMentorName(mentor.getFirstname()+ mentor.getLastname());
			mentorProfileDetails.setMentorEmail(mentor.getEmail());
			mentorProfileDetails.setExpertise(mentorDetails.getExpertise());
			mentorProfileDetails.setYearOfExp(mentorDetails.getExperience());
			mentorProfileDetails.setMentorSkills(mentorSkillsMapper.mapMentorSkillsResponse(mentorSkills));
		}
		
		return mentorProfileDetails;
	}

	@Override
	public MentorSearchResponse searchMentorsByTechnology(MentorSearchRequest mentorSearchRequest) {
		MentorSearchResponse response = new MentorSearchResponse();
		
		List<MentorProfileDetails> mentorProfileDetails = new ArrayList<MentorProfileDetails>();
		
		if(!CollectionUtils.isEmpty(mentorSearchRequest.getTechnologies())) {
			
			List<Integer> technologies = mentorSearchRequest.getTechnologies();
			
			Set<Integer> mentors = new HashSet<>();
			// Get mentor list by technology
			for(Integer techId :technologies) {
				List<MentorSkills>  mentorSkills = mentorSkillsRepository.findByTechId(techId);
				for(MentorSkills skill:mentorSkills) {
					mentors.add(skill.getMentor().getId());
				}
			}
			// Fetch mentor profile details
			if(!CollectionUtils.isEmpty(mentors)) {
				for(int mentorId :mentors) {
					MentorProfileDetails mentorProfileDetail= getMentorDetails(mentorId);
					mentorProfileDetails.add(mentorProfileDetail);
				}
			}
			
			if(!CollectionUtils.isEmpty(mentorProfileDetails)) {
				response.setMentors(mentorProfileDetails);
			}
		}
		
		return response;
	}

	
	@Override
	public MentorBlockUserResponse blockUserForMentor(int mentorId, int userId) {

		MentorBlockUserResponse response = new MentorBlockUserResponse(); 

		Application application = eurekaClient.getApplication("users-api");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        //Mentor
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "users/" + mentorId;
        System.out.println("URL" + url);
        User mentor = restTemplate.getForObject(url, User.class);
        
        //User
        String user_url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "users/" + userId;
        System.out.println("URL" + user_url);
        User users = restTemplate.getForObject(user_url, User.class);
		
        MentorBlockUsers mentorBlockUsers = new MentorBlockUsers();
        mentorBlockUsers.setMentor(mentor);
        mentorBlockUsers.setUser(users);
        mentorBlockUsers.setBlocked(true);
        mentorBlockUserRepository.save(mentorBlockUsers);
        
        response.setBlocked(true);
        return response;
        
        
        
	}
}
