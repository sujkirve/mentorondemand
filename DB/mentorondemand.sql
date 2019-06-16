-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2019 at 02:45 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simplilearn`
--

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(5),
(5);

-- --------------------------------------------------------

--
-- Table structure for table `mentorcalendar`
--

CREATE TABLE `mentorcalendar` (
  `id` int(11) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `mentor_id` int(11) NOT NULL,
  `training_id` int(11) NOT NULL,
  `training_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `mentordetails`
--

CREATE TABLE `mentordetails` (
  `mentor_id` int(11) NOT NULL,
  `expertise` varchar(255) NOT NULL,
  `experience` float NOT NULL,
  `rating` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mentordetails`
--

INSERT INTO `mentordetails` (`mentor_id`, `expertise`, `experience`, `rating`) VALUES
(1, 'Full Stack Developer', 11, 5),
(2, 'AWS Developer', 10, 5);

-- --------------------------------------------------------

--
-- Table structure for table `mentorskills`
--

CREATE TABLE `mentorskills` (
  `id` int(11) NOT NULL,
  `mentor_id` int(11) NOT NULL,
  `tech_id` int(11) NOT NULL,
  `experience` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mentorskills`
--

INSERT INTO `mentorskills` (`id`, `mentor_id`, `tech_id`, `experience`) VALUES
(1, 1, 1, 10),
(2, 1, 2, 5),
(3, 2, 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `id` int(11) NOT NULL,
  `candidate_id` int(11) NOT NULL,
  `mentor_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `training_id` int(11) NOT NULL,
  `transactionsDate` datetime NOT NULL,
  `transactionsid` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `technologies`
--

CREATE TABLE `technologies` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `technologies`
--

INSERT INTO `technologies` (`id`, `name`) VALUES
(1, 'Core Java'),
(2, 'Spring');

-- --------------------------------------------------------

--
-- Table structure for table `trainings`
--

CREATE TABLE `trainings` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `tech_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `mentor_id` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `trainings`
--

INSERT INTO `trainings` (`id`, `name`, `tech_id`, `start_date`, `end_date`, `mentor_id`, `status`, `email`, `last_date`) VALUES
(1, 'Spring Basics', 2, '2019-06-03', '2019-06-28', 1, 'NOT STARTED', NULL, NULL),
(2, 'Java Basics', 1, '2019-06-03', '2019-06-28', 1, 'NOT STARTED', NULL, NULL),
(3, 'Spring Basics', 2, '2019-06-10', '2019-06-28', 1, 'NOT STARTED', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `is_mentor` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `firstname`, `lastname`, `email`, `password`, `active`, `is_mentor`) VALUES
(1, 'Sujit', 'Kirve', 'sujitkirve@gmail.com', '$2a$10$RLvEeUb1FDGLGw8oJfio8u4I6tz9sdZJeZLd7iw15YOSC2P5S7tFW', 1, 1),
(2, 'Sumit', 'Kirve', 'sumitkirve@gmail.com', '$2a$10$VcoPnJ.JJMbZBZTAh6wGS.C2KAFP4buS.FM.MldI3Dzyb2DQuWr0e', 1, 1),
(3, 'Sunil', 'Kirve', 'sunilkirve@gmail.com', '$2a$10$ma40RVjm5r9ia4BAXOH5juBsNCD4hSUI2dWIs/WFH4B3zETtrI.WS', 1, 0),
(4, 'john', 'Doe', 'john@gmail.com', '$2a$10$iK6Hi8B.W0oBosRtBu7hz.6m9ShIaADzhGLZO6L0Hkr4s/ibly0NC', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mentorcalendar`
--
ALTER TABLE `mentorcalendar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `training_id` (`training_id`),
  ADD KEY `mentorcalendar_ibfk_1` (`mentor_id`);

--
-- Indexes for table `mentordetails`
--
ALTER TABLE `mentordetails`
  ADD PRIMARY KEY (`mentor_id`);

--
-- Indexes for table `mentorskills`
--
ALTER TABLE `mentorskills`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tech_id` (`tech_id`),
  ADD KEY `mentorskills_ibfk_1` (`mentor_id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `training_id` (`training_id`),
  ADD KEY `payments_ibfk_1` (`mentor_id`),
  ADD KEY `payments_ibfk_2` (`candidate_id`);

--
-- Indexes for table `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `technologies`
--
ALTER TABLE `technologies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `trainings`
--
ALTER TABLE `trainings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tech_id` (`tech_id`),
  ADD KEY `trainings_ibfk_2` (`mentor_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `user_role_key` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mentorcalendar`
--
ALTER TABLE `mentorcalendar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `mentorskills`
--
ALTER TABLE `mentorskills`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `technologies`
--
ALTER TABLE `technologies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `trainings`
--
ALTER TABLE `trainings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mentorcalendar`
--
ALTER TABLE `mentorcalendar`
  ADD CONSTRAINT `mentorcalendar_ibfk_1` FOREIGN KEY (`mentor_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `mentorcalendar_ibfk_2` FOREIGN KEY (`training_id`) REFERENCES `trainings` (`id`);

--
-- Constraints for table `mentordetails`
--
ALTER TABLE `mentordetails`
  ADD CONSTRAINT `mentordetails_ibfk_1` FOREIGN KEY (`mentor_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `mentorskills`
--
ALTER TABLE `mentorskills`
  ADD CONSTRAINT `mentorskills_ibfk_1` FOREIGN KEY (`mentor_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `mentorskills_ibfk_2` FOREIGN KEY (`tech_id`) REFERENCES `technologies` (`id`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`mentor_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `payments_ibfk_2` FOREIGN KEY (`candidate_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `payments_ibfk_3` FOREIGN KEY (`training_id`) REFERENCES `trainings` (`id`);

--
-- Constraints for table `trainings`
--
ALTER TABLE `trainings`
  ADD CONSTRAINT `trainings_ibfk_1` FOREIGN KEY (`tech_id`) REFERENCES `technologies` (`id`),
  ADD CONSTRAINT `trainings_ibfk_2` FOREIGN KEY (`mentor_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `role_userrole` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `user_userrole` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
