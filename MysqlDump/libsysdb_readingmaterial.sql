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
-- Table structure for table `readingmaterial`
--

DROP TABLE IF EXISTS `readingmaterial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `readingmaterial` (
  `materialId` int(11) NOT NULL AUTO_INCREMENT,
  `materialType` varchar(45) NOT NULL,
  `deweyLocation` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `year` varchar(45) NOT NULL,
  `tags` varchar(45) NOT NULL,
  `status` int(11) NOT NULL,
  `dateReserve` datetime NOT NULL,
  `dateReturn` datetime NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`materialId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `readingmaterial`
--

LOCK TABLES `readingmaterial` WRITE;
/*!40000 ALTER TABLE `readingmaterial` DISABLE KEYS */;
INSERT INTO `readingmaterial` VALUES (1,'book','dewey','JK Rowling','Narra','2015','Books, Best',0,'2015-01-01 00:00:00','2015-01-31 00:00:00','Harry Potter'),(2,'magazine','dewey','sport author','ABS','2017','Magazine, gainz',1,'2015-01-01 00:00:00','2015-01-31 00:00:00','Health'),(3,'thesis','dewey','gramp','lasalle','2011','Best thesis',1,'2000-01-30 00:00:00','2000-01-30 00:00:00','tech');
/*!40000 ALTER TABLE `readingmaterial` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-05  3:56:58
