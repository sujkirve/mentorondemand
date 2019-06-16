package com.ibm.mentors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.mentors.model.User;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
 
 User findByEmail(String email);
 User findById(int id);
}