DROP DATABASE IF exists `cd_store`;
CREATE DATABASE  IF NOT EXISTS `cd_store` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cd_store`;
-- MySQL dump 10.13  Distrib 5.6.17, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: cd_store
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `Address`
--

DROP TABLE IF EXISTS `Address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Address` (
  `address_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `street` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `province` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL,
  `zipcode` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Address`
--

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;
INSERT INTO `Address` VALUES (1,'123 Bank str','Ottawa','ON','Canada','K1E 6T5','613-123-4567');
/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Table structure for table `Band`
--

DROP TABLE IF EXISTS `Band`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Band` (
  `band_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `band` varchar(100) NOT NULL,
  `style` enum('Rock','Jazz','Pop','Metal','Country','Rap','Not known') DEFAULT 'Not known',
  PRIMARY KEY (`band_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Band`
--

LOCK TABLES `Band` WRITE;
/*!40000 ALTER TABLE `Band` DISABLE KEYS */;
INSERT INTO `Band` VALUES (1,'Nickelback','Rock'),(2,'Eminem','Rap'),(3,'Kelly Clarckson','Pop'),(4,'Frank Sinatra','Jazz'),(5,'Brad Paisley','Country');
/*!40000 ALTER TABLE `Band` ENABLE KEYS */;
UNLOCK TABLES;

-- Table for Category

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Category` (
  `categoryID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(100) NOT NULL,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

insert into Category (categoryName) values ('Rock');
insert into Category (categoryName) values ('Rap');
insert into Category (categoryName) values ('Pop');
insert into Category (categoryName) values ('Jazz');
insert into Category (categoryName) values ('Country');

--
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `pass` varchar(45) DEFAULT NULL,
  `confirmation` varchar(45) DEFAULT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address_id` int(10) UNSIGNED NOT NULL, 
  PRIMARY KEY (`account_id`),
  CONSTRAINT `acc_addr_fk` FOREIGN KEY (`address_id`) REFERENCES Address (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account`
--

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
INSERT INTO `Account` VALUES (1, 'ads',NULL,'adasd','asdad','asdad',1);
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `CD`
--

DROP TABLE IF EXISTS `CD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CD` (
  `cd_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL,
  `price` float unsigned NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '0',
  `description` nvarchar(9000) NOT NULL DEFAULT 'NO INFORMATION',
   `link` nvarchar(9000) NOT NULL DEFAULT 'NO INFORMATION',
  `band_id` int(10) unsigned DEFAULT NULL,
  `categoryID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`cd_id`),
  KEY `band_id` (`band_id`),
  CONSTRAINT `cd_ibfk_1` FOREIGN KEY (`band_id`) REFERENCES `Band` (`band_id`),
  CONSTRAINT `cd_category_1` FOREIGN KEY (`categoryID`) REFERENCES `Category` (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CD`
--

LOCK TABLES `CD` WRITE;
/*!40000 ALTER TABLE `CD` DISABLE KEYS */;
INSERT INTO `CD` VALUES (1,'Here and now',15.99,0,'Here and Now is the seventh studio album 
by Canadian rock band Nickelback. The album was released 
on November 21, 2011','http://upload.wikimedia.org/wikipedia/
en/thumb/f/f9/Nickelback_Here_and_Now_170x170-75.jpg/
220px-Nickelback_Here_and_Now_170x170-75.jpg',1,1),
(2,'All the right reasons',8.99,0,'All the Right Reasons is the fifth studio
 album by Canadian rock band Nickelback, released on October
 4, 2005. It is the bands first album with former 3 Doors 
Down drummer Daniel Adair, who replaced Ryan Vikedal in 
January 2005.','http://upload.wikimedia.org/wikipedia/en/
thumb/c/cc/AllTheRightReasons.jpg/220px-AllTheRightReasons.jpg',1,2),
(3,'Dark Horse',10.99,0,'Here and Now is the seventh studio album by Canadian rock band Nickelback. The album was released on November 21, 2011.[2] It is the follow-up to their multi-platinum selling Dark Horse in 2008. On September 26, the band officially released two singles, "When We Stand Together" and "Bottoms Up"','http://upload.wikimedia.org/wikipedia/en/
thumb/d/dd/Dark_Horse_%28Nickelback_album_cover%29.jpg/
220px-Dark_Horse_%28Nickelback_album_cover%29.jpg',1,3),
(4,'8 Mile',1.99,0,' 8 Mile (soundtrack), rap soundtrack album to the film featuring Eminem','http://upload.wikimedia.org/wikipedia/en/3/39/8milecover.jpg',2,4),
(5,'Recovery',15.99,0,'Recovery is the seventh studio album by American rapper Eminem. It was released on June 18, 2010, by Shady Records, Aftermath Entertainment and Interscope Records as the follow-up to Eminems Relapse (2009).',
'http://upload.wikimedia.org/wikipedia/en/thumb/6/60/Recovery_Album_Cover.jpg/220px-Recovery_Album_Cover.jpg',2,5),
(6,'The Slim Shady',13.99,0,'The Slim Shady LP is the second studio album and first major release from the American rapper Eminem. It was released on February 25, 1999, under Interscope Records and Dr. Dres Aftermath Entertainment.',
'http://upload.wikimedia.org/wikipedia/en/thumb/3/35/Eminem_-_The_Slim_Shady_LP_CD_cover.jpg/220px-Eminem_-_The_Slim_Shady_LP_CD_cover.jpg',2,1),
(7,'Wrapped in Red',11.99,0,'Wrapped in Red is the sixth studio album by American recording artist Kelly Clarkson, released on October 25, 2013, by RCA Records.',
'http://upload.wikimedia.org/wikipedia/en/thumb/0/0a/Wrapped_in_Red.png/220px-Wrapped_in_Red.png',3,2),
(8,'Stronger',18.99,0,'Stronger is the fifth studio album by American pop recording artist Kelly Clarkson. 
The album was released on October 21, 2011, in Australia and October 24, 2011, in the United States and the United Kingdom by RCA Records. ',
'http://upload.wikimedia.org/wikipedia/en/thumb/c/ca/Kelly_Clarkson_-_Stronger.jpg/220px-Kelly_Clarkson_-_Stronger.jpg',3,3),
(9,'All I ever wanted',20.99,0,'All I Ever Wanted is the fourth studio album by American pop rock singer-songwriter Kelly Clarkson, 
released on March 6, 2009 in Australia and Germany and the United States on March 10. It was her second album to debut at number one on the Billboard 200. ',
'http://upload.wikimedia.org/wikipedia/en/thumb/4/47/Kelly_Clarkson_-_All_I_Ever_Wanted_%28Official_Album_Cover%29.png/220px-Kelly_Clarkson_-_All_I_Ever_Wanted_%28Official_Album_Cover%29.png',3,4),
(10,'My Way',5.99,0,'My Way is an album by American singer Frank Sinatra, released in 1969.[3]

The album is a collection of contemporary pop songs, such as Simon and Garfunkel\'s "Mrs. Robinson", and The Beatles\' 
"Yesterday", French songs such as "If You Go Away", and of course the anthemic title song "My Way",
 which effectively became Sinatra\'s theme song in this latter stage of his career.','http://upload.wikimedia.org/wikipedia/en/thumb/3/34/SinatraMyWay.
jpg/220px-SinatraMyWay.jpg',4,5),
(11,'Strangers in the night',7.99,0,'Strangers in the Night is a 1966 studio album by Frank Sinatra. It marked Sinatra\'s return to #1 on the pop album charts
 in the mid-1960s, and consolidated the comeback he started in 1966.','http://upload.wikimedia.org/wikipedia/en/4/4b/Strangersinthenight.jpg',4,1),
(12,'That\'s life',8.99,0,'That\'s Life is a 1966 album by Frank Sinatra, supported by a studio orchestra arranged and conducted by Ernie Freeman. 
The album is notable for its title song, "That\'s Life", which proved to be a top five hit for Sinatra in the age of post-Beatles rock music.',
'http://upload.wikimedia.org/wikipedia/en/thumb/6/66/That%27sLife.jpg/220px-That%27sLife.jpg',4,2);
/*!40000 ALTER TABLE `CD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PItem`
--

DROP TABLE IF EXISTS `PItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PItem` (
  `pitem_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `p_id` int(10) unsigned DEFAULT NULL,
  `cd_id` int(10) unsigned NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`pitem_id`),
  KEY `p_id` (`p_id`),
  KEY `cd_id` (`cd_id`),
  CONSTRAINT `pitem_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `Purchase` (`purchase_id`) ON DELETE CASCADE,
  CONSTRAINT `pitem_ibfk_2` FOREIGN KEY (`cd_id`) REFERENCES `CD` (`cd_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PItem`
--

LOCK TABLES `PItem` WRITE;
/*!40000 ALTER TABLE `PItem` DISABLE KEYS */;
INSERT INTO `PItem` VALUES (1,1,1,1),(2,1,2,2),(3,1,3,1),(4,1,5,1),(5,2,4,2),(6,2,5,1),(7,2,6,2),(8,2,9,1),(9,3,7,1),(10,3,8,2),(11,3,9,1),(12,3,1,3),(13,3,2,1);
/*!40000 ALTER TABLE `PItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Purchase`
--

DROP TABLE IF EXISTS `Purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Purchase` (
  `purchase_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT NULL,
  `address_id` int(10) unsigned DEFAULT NULL,
  `date_p` datetime DEFAULT NULL,
  `stat` enum('ORDERED','SHIPPED','DENIED') DEFAULT 'ORDERED',
  PRIMARY KEY (`purchase_id`),
  KEY `user_id` (`user_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`),
  CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `Address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Purchase`
--

LOCK TABLES `Purchase` WRITE;
/*!40000 ALTER TABLE `Purchase` DISABLE KEYS */;
INSERT INTO `Purchase` VALUES (1,1,1,'2014-09-30 00:00:00','SHIPPED'),(2,2,2,'2014-09-30 00:00:00','DENIED'),(3,3,3,'2014-09-30 00:00:00','ORDERED'),(4,3,3,'2014-09-29 00:00:00','DENIED'),(5,2,2,'2014-09-29 00:00:00','DENIED'),(6,4,4,'2014-09-30 00:00:00','SHIPPED'),(7,4,4,'2014-09-28 00:00:00','ORDERED'),(8,4,4,'2014-10-01 00:00:00','SHIPPED'),(9,4,4,'2014-10-01 00:00:00','ORDERED'),(10,4,4,'2014-10-01 00:00:00','ORDERED');
/*!40000 ALTER TABLE `Purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(15) NOT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `confirmation` enum('true','false') DEFAULT 'false',
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'waeal.obidallah','202cb962ac59075b964b07152d234b70','true','Waeal','Obidallah','waeal.obidallah@gmail.com'),(2,'eguse009','202cb962ac59075b964b07152d234b70','true','Ekaterina','Guseva','eguse009@uottawa.ca'),(3,'msafi083','202cb962ac59075b964b07152d234b70','true','Mohamad','Safie','msafi083@uottawa.ca'),(4,'ajrei048','202cb962ac59075b964b07152d234b70','true','Ahmedou','Jreivine','ajrei048@uottawa.ca'),(5,'mertmetin','202cb962ac59075b964b07152d234b70','true','Mert','Metin','mertmetin@outlook.com');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VisitEvent`
--

DROP TABLE IF EXISTS `VisitEvent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VisitEvent` (
  `visit_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `v_date` datetime NOT NULL,
  `cd_id` int(10) unsigned DEFAULT NULL,
  `event_type` enum('VIEW','CART','PURCHASE') NOT NULL,
  PRIMARY KEY (`visit_id`),
  KEY `cd_id` (`cd_id`),
  CONSTRAINT `visitevent_ibfk_1` FOREIGN KEY (`cd_id`) REFERENCES `CD` (`cd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VisitEvent`
--

LOCK TABLES `VisitEvent` WRITE;
/*!40000 ALTER TABLE `VisitEvent` DISABLE KEYS */;
INSERT INTO `VisitEvent` VALUES (1,'2014-09-28 00:00:00',1,'VIEW'),(2,'2014-09-28 00:00:00',8,'CART'),(3,'2014-09-27 00:00:00',7,'PURCHASE'),(4,'2014-09-27 00:00:00',8,'VIEW'),(5,'2014-09-26 00:00:00',3,'CART'),(6,'2014-09-26 00:00:00',2,'PURCHASE'),(7,'2014-09-26 00:00:00',5,'VIEW'),(8,'2014-09-25 00:00:00',3,'CART'),(9,'2014-09-25 00:00:00',3,'PURCHASE');
/*!40000 ALTER TABLE `VisitEvent` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-13 17:55:06
