# Host: localhost  (Version: 5.5.34)
# Date: 2020-05-10 11:20:41
# Generator: MySQL-Front 5.3  (Build 3.22)

/*!40101 SET NAMES utf8 */;

USE `evs`;

#
# Source for table "evs_tbl_election"
#

DROP TABLE IF EXISTS `evs_tbl_election`;
CREATE TABLE `evs_tbl_election` (
  `election_id` int(6) NOT NULL DEFAULT '0',
  `Name` varchar(15) NOT NULL DEFAULT '',
  `election_date` date NOT NULL DEFAULT '0000-00-00',
  `District` varchar(15) NOT NULL DEFAULT '',
  `Constituency` varchar(15) NOT NULL DEFAULT '',
  `counting_date` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`election_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "evs_tbl_election"
#


#
# Source for table "evs_tbl_eo"
#

DROP TABLE IF EXISTS `evs_tbl_eo`;
CREATE TABLE `evs_tbl_eo` (
  `electoralofficer_id` int(6) NOT NULL DEFAULT '0',
  `Consituency` varchar(25) NOT NULL DEFAULT '',
  PRIMARY KEY (`electoralofficer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "evs_tbl_eo"
#


#
# Source for table "evs_tbl_party"
#

DROP TABLE IF EXISTS `evs_tbl_party`;
CREATE TABLE `evs_tbl_party` (
  `party_id` int(6) NOT NULL DEFAULT '0',
  `Name` varchar(20) NOT NULL DEFAULT '',
  `Leader` varchar(20) NOT NULL DEFAULT '',
  `Symbol` varchar(40) NOT NULL DEFAULT '',
  `election_id` int(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`party_id`),
  KEY `evs_tbl_party_fk` (`election_id`),
  CONSTRAINT `evs_tbl_party_fk` FOREIGN KEY (`election_id`) REFERENCES `evs_tbl_election` (`election_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "evs_tbl_party"
#


#
# Source for table "evs_tbl_candidate"
#

DROP TABLE IF EXISTS `evs_tbl_candidate`;
CREATE TABLE `evs_tbl_candidate` (
  `candidate_id` int(6) NOT NULL DEFAULT '0',
  `Name` varchar(20) NOT NULL DEFAULT '',
  `election_id` int(6) NOT NULL DEFAULT '0',
  `party_id` int(6) NOT NULL DEFAULT '0',
  `District` varchar(20) NOT NULL DEFAULT '',
  `Constituency` varchar(20) NOT NULL DEFAULT '',
  `date_of_birth` date NOT NULL DEFAULT '0000-00-00',
  `mobile_no` int(10) NOT NULL DEFAULT '0',
  `Address` varchar(50) NOT NULL DEFAULT '',
  `email_id` varchar(20) DEFAULT '',
  PRIMARY KEY (`candidate_id`),
  KEY `evs_tbl_candidate_fk` (`election_id`),
  KEY `evs_tbl_candidate_fk_1` (`party_id`),
  CONSTRAINT `evs_tbl_candidate_fk_1` FOREIGN KEY (`party_id`) REFERENCES `evs_tbl_party` (`party_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evs_tbl_candidate_fk` FOREIGN KEY (`election_id`) REFERENCES `evs_tbl_election` (`election_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "evs_tbl_candidate"
#


#
# Source for table "evs_tbl_result"
#

DROP TABLE IF EXISTS `evs_tbl_result`;
CREATE TABLE `evs_tbl_result` (
  `serial_no` int(6) NOT NULL DEFAULT '0',
  `election_id` int(6) NOT NULL DEFAULT '0',
  `candidate_id` int(6) NOT NULL DEFAULT '0',
  `vote_count` int(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`serial_no`),
  KEY `evs_tbl_result_fk` (`candidate_id`),
  KEY `evs_tbl_result_fk_1` (`election_id`),
  CONSTRAINT `evs_tbl_result_fk` FOREIGN KEY (`candidate_id`) REFERENCES `evs_tbl_candidate` (`candidate_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evs_tbl_result_fk_1` FOREIGN KEY (`election_id`) REFERENCES `evs_tbl_election` (`election_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "evs_tbl_result"
#


#
# Source for table "evs_tbl_user_profile"
#

DROP TABLE IF EXISTS `evs_tbl_user_profile`;
CREATE TABLE `evs_tbl_user_profile` (
  `user_id` int(6) NOT NULL DEFAULT '0',
  `first_name` varchar(15) NOT NULL DEFAULT '',
  `last_name` varchar(15) NOT NULL DEFAULT '',
  `date_of_birth` date NOT NULL DEFAULT '0000-00-00',
  `Gender` varchar(7) NOT NULL DEFAULT '',
  `Street` varchar(30) NOT NULL DEFAULT '',
  `Constituency` varchar(15) NOT NULL DEFAULT '',
  `City` varchar(15) NOT NULL DEFAULT '',
  `State` varchar(15) NOT NULL DEFAULT '',
  `Pincode` int(6) NOT NULL DEFAULT '0',
  `mobile_no` int(10) NOT NULL DEFAULT '0',
  `email_id` varchar(30) DEFAULT NULL,
  `Password` varchar(20) NOT NULL DEFAULT '',
  `user_type` varchar(1) NOT NULL DEFAULT '',
  `login_status` int(1) unsigned DEFAULT NULL,
  `session_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "evs_tbl_user_profile"
#

INSERT INTO `evs_tbl_user_profile` VALUES (1,'Apeksha11','Kumari11','2020-03-24','Female','nowgain','sangrampur1','sangrampur','bihar',123456,1234567891,'name@gmail.com','appy12','A',1,'Unaw0l'),(2,'Apeksha11','Kumari11','2020-03-24','Female','nowgain','sangrampur1','sangrampur','bihar',123456,1234567890,'name@gmail.com','appy123','V',1,'aSBg1y'),(3,'Apeksha11','Kumari11','2020-03-24','Female','nowgain','sangrampur1','sangrampur','bihar',123456,1234567890,'name@gmail.com','appy1234','E',0,NULL);

#
# Source for table "evs_tbl_application"
#

DROP TABLE IF EXISTS `evs_tbl_application`;
CREATE TABLE `evs_tbl_application` (
  `user_id` int(6) NOT NULL DEFAULT '0',
  `Constituency` varchar(15) NOT NULL DEFAULT '',
  `passed_status` int(1) unsigned NOT NULL DEFAULT '0',
  `approved_status` int(1) unsigned NOT NULL DEFAULT '0',
  `voter_id` varchar(8) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`),
  CONSTRAINT `evs_tbl_application_fk_1` FOREIGN KEY (`user_id`) REFERENCES `evs_tbl_user_profile` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "evs_tbl_application"
#


#
# Source for table "evs_tbl_voter_details"
#

DROP TABLE IF EXISTS `evs_tbl_voter_details`;
CREATE TABLE `evs_tbl_voter_details` (
  `serial_no` int(6) NOT NULL DEFAULT '0',
  `candidate_id` int(6) NOT NULL DEFAULT '0',
  `election_id` int(6) NOT NULL DEFAULT '0',
  `voter_id` varchar(8) NOT NULL DEFAULT '',
  `Vote` int(1) DEFAULT '0',
  PRIMARY KEY (`serial_no`),
  KEY `evs_tbl_voter_details_fk` (`election_id`),
  KEY `evs_tbl_voter_details_fk_1` (`candidate_id`),
  KEY `evs_tbl_voter_details_fk_2` (`voter_id`),
  CONSTRAINT `evs_tbl_voter_details_fk_1` FOREIGN KEY (`candidate_id`) REFERENCES `evs_tbl_candidate` (`candidate_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "evs_tbl_voter_details"
#


#
# Source for table "hibernate_sequence"
#

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "hibernate_sequence"
#

INSERT INTO `hibernate_sequence` VALUES (4);
