# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     db_jobseekers
# Server version:               5.0.51b-community-nt
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2020-05-15 14:22:17
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for db_jobseekers
CREATE DATABASE IF NOT EXISTS `db_jobseekers` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_jobseekers`;


# Dumping structure for table db_jobseekers.table_assigned_jobs
CREATE TABLE IF NOT EXISTS `table_assigned_jobs` (
  `freelancer_email` varchar(25) NOT NULL,
  `job_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table db_jobseekers.table_job_details
CREATE TABLE IF NOT EXISTS `table_job_details` (
  `job_id` int(10) NOT NULL auto_increment,
  `title` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `payment` double(10,2) unsigned NOT NULL,
  `keywords` varchar(150) NOT NULL,
  `added_user` varchar(25) NOT NULL,
  `status` varchar(25) NOT NULL,
  `assigned_email` varchar(25) NOT NULL,
  PRIMARY KEY  (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table db_jobseekers.table_user
CREATE TABLE IF NOT EXISTS `table_user` (
  `user_id` int(10) NOT NULL auto_increment,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `user_role` varchar(25) NOT NULL,
  `skills` varchar(200) NOT NULL,
  `message` varchar(200) NOT NULL,
  `balance` double(10,2) unsigned NOT NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
