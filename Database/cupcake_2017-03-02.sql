# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.16)
# Database: cupcake
# Generation Time: 2017-03-02 22:35:00 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table bottoms
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bottoms`;

CREATE TABLE `bottoms` (
  `botid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`botid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `bottoms` WRITE;
/*!40000 ALTER TABLE `bottoms` DISABLE KEYS */;

INSERT INTO `bottoms` (`botid`, `name`, `price`)
VALUES
	(1,'Chocolate',5.00),
	(2,'Vanilla',5.00),
	(3,'Nutmeg',5.00),
	(4,'Pistacio',6.00),
	(5,'Almond',7.00);

/*!40000 ALTER TABLE `bottoms` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table customer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `cname` varchar(25) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `balance` decimal(10,2) DEFAULT '100.00',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `customer_email_uindex` (`email`),
  UNIQUE KEY `customer_username_uindex` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;

INSERT INTO `customer` (`userid`, `username`, `password`, `cname`, `email`, `balance`)
VALUES
	(1,'tester','1234','testuser','test@live.dk',100.00),
	(10,'GladeAnso','flÃ¸debolle123','Anso','anso@gmail.com',100.00),
	(11,'ollitheorange','1234','Oliver','oliver@loye.dk',100.00),
	(31,'dsad','dasdas','dasddsa','redasddasghthergwf',100.00),
	(32,'df','asda','dasf','nyemail@dk.dk',100.00),
	(33,'jlkdasnflam','fdfdfsdfsd','djsakdjkl','dsfdsflÃ¦mcsalÃ¦c@fdsf',100.00),
	(34,'sad','asdsad','sadasd','asdasd',100.00),
	(35,'dsa','das','dasd','123215fsdf',100.00),
	(36,'dkasld','mlkasl','tester','mkldamfodifjalmdnfdfjalnanfaoa',100.00),
	(37,'Ã¦jflkdaÃ¦Ã¦askdÃ¦','nldaskaskÃ¦sadmpa','daskdasj','12938174skdÃ¦sakmd',100.00),
	(38,'ohoj','12345678','ohoj','ohoj@ohoj.dk',100.00),
	(39,'torsdag','1234','torsdag','torsdag',100.00);

/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table toppings
# ------------------------------------------------------------

DROP TABLE IF EXISTS `toppings`;

CREATE TABLE `toppings` (
  `topid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`topid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `toppings` WRITE;
/*!40000 ALTER TABLE `toppings` DISABLE KEYS */;

INSERT INTO `toppings` (`topid`, `name`, `price`)
VALUES
	(1,'Chocolate',5.00),
	(2,'Blueberry',5.00),
	(3,'Rasberry',5.00),
	(4,'Crispy',6.00),
	(5,'Strawberry',6.00),
	(6,'Rum/Raisin',7.00),
	(7,'Orange',8.00),
	(8,'Lemon',8.00),
	(9,'Blue cheese',9.00);

/*!40000 ALTER TABLE `toppings` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
