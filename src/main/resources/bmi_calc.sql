# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.23)
# Database: bmi_calc
# Generation Time: 2019-05-27 23:37:42 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table bmi_logs
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bmi_logs`;

CREATE TABLE `bmi_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `weight` float NOT NULL,
  `bmi` float NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bmi_logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `bmi_logs` WRITE;
/*!40000 ALTER TABLE `bmi_logs` DISABLE KEYS */;

INSERT INTO `bmi_logs` (`id`, `user_id`, `weight`, `bmi`, `date`)
VALUES
	(3,1,233,70.34,'2019-05-27'),
	(4,1,65,19.62,'2019-05-27'),
	(5,1,123,37.13,'2019-05-27'),
	(6,1,123,37.13,'2019-05-26'),
	(7,1,123,37.13,'2019-05-27'),
	(8,1,123,37.13,'2019-05-27');

/*!40000 ALTER TABLE `bmi_logs` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table meal_logs
# ------------------------------------------------------------

DROP TABLE IF EXISTS `meal_logs`;

CREATE TABLE `meal_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `meal_id` int(11) NOT NULL,
  `date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `userIdIndex` (`user_id`),
  KEY `mealIdIndex` (`meal_id`),
  CONSTRAINT `meal_logs_ibfk_2` FOREIGN KEY (`meal_id`) REFERENCES `meal_plans` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `meal_logs_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table meal_plans
# ------------------------------------------------------------

DROP TABLE IF EXISTS `meal_plans`;

CREATE TABLE `meal_plans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `type` int(11) unsigned NOT NULL,
  `calorie` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `type` (`type`),
  CONSTRAINT `meal_plans_ibfk_1` FOREIGN KEY (`type`) REFERENCES `meal_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `meal_plans` WRITE;
/*!40000 ALTER TABLE `meal_plans` DISABLE KEYS */;

INSERT INTO `meal_plans` (`id`, `name`, `type`, `calorie`)
VALUES
	(7,'C. Salad',7,123);

/*!40000 ALTER TABLE `meal_plans` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table meal_types
# ------------------------------------------------------------

DROP TABLE IF EXISTS `meal_types`;

CREATE TABLE `meal_types` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `meal_types` WRITE;
/*!40000 ALTER TABLE `meal_types` DISABLE KEYS */;

INSERT INTO `meal_types` (`id`, `name`)
VALUES
	(7,'KETO'),
	(8,'HALAL'),
	(9,'KOSHER'),
	(10,'GLUTEN-FREE');

/*!40000 ALTER TABLE `meal_types` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `surname` varchar(50) NOT NULL DEFAULT '',
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `height` float NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `name`, `surname`, `username`, `password`, `height`)
VALUES
	(1,'Shayant','Sital','ssital','123',1.82),
	(2,'Tony','Stark','tstark','123',1.82);

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
