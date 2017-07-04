-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: libsysdb
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `accountid` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `middleName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `passWord` varchar(45) NOT NULL,
  `eMail` varchar(45) NOT NULL,
  `idNumber` varchar(45) NOT NULL,
  `birthDay` varchar(45) NOT NULL,
  `sQuestion` varchar(45) NOT NULL,
  `sAnswer` varchar(45) NOT NULL,
  `accountType` int(11) NOT NULL,
  `passwordExpire` date NOT NULL,
  `isChanged` int(11) NOT NULL,
  `isActive` int(11) NOT NULL,
  PRIMARY KEY (`accountid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Glenn','Montes','Matias','meatloaf','1234','glenn_matias@dlsu.edu.ph','11326174','june','What is the name of my dog?','Creamo',1,'2000-01-30',1,1),(2,'Han','Kyung','Ju','han123','4566','han_ju@dlsu.edu.ph','11312345','january','What is the name of my car?','Stinger',1,'2000-01-30',1,1),(3,'Jan ','Allen','Gapuz','janGapuz','7890','jan_Gapuz@dlsu.edu.ph','11378971','Feb','What is the name of my shirt?','Killer',1,'2000-01-30',1,1),(4,'adminname','adminmiddle','adminlast','admin','1234','admin@google.com','113','jan','none','none',4,'2000-01-30',1,1),(8,'staffname','staffmiddle','stafflastname','staff','1234','staff@yahoo.com','113','jun','wala','walarin',2,'2000-01-30',1,1),(9,'w','w','w','staff3','1234','nj','jnjn','jnjn','jnj','jnj',3,'2000-01-30',1,1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-05  3:56:59
