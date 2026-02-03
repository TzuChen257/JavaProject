CREATE DATABASE  IF NOT EXISTS `hw2_bank` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hw2_bank`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: hw2_bank
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bank_account` varchar(45) DEFAULT NULL,
  `trans_password` varchar(45) DEFAULT NULL,
  `online_user` varchar(45) DEFAULT NULL,
  `online_password` varchar(45) DEFAULT NULL,
  `balance` int DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `national_id` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'13246546546','541234','tom','05145',260000,'77.04.05','S156515451','Tainan','09132456748'),(2,'88145649511','482212','yam','44551',440000,'97.04.05','D156515451','HsinChu','09132545878'),(3,'13245646546','123456','wendy','44410',310000,'87.04.05','A156515451','Taipei','09874455148');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `id` int NOT NULL AUTO_INCREMENT,
  `online_user` varchar(45) DEFAULT NULL,
  `online_password` varchar(45) DEFAULT NULL,
  `access` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (1,'root','1234',1),(2,'admin','0000',2);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_detail`
--

DROP TABLE IF EXISTS `transaction_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `subject_account` varchar(45) DEFAULT NULL,
  `trading_activity` int DEFAULT NULL,
  `income` int DEFAULT NULL,
  `expenses` int DEFAULT NULL,
  `balance_now` int DEFAULT NULL,
  `object_account` varchar(45) DEFAULT NULL,
  `trading_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_detail`
--

LOCK TABLES `transaction_detail` WRITE;
/*!40000 ALTER TABLE `transaction_detail` DISABLE KEYS */;
INSERT INTO `transaction_detail` VALUES (1,'13246546546',2,NULL,NULL,NULL,NULL,'2026/01/31 20:09:00'),(2,'13245646546',1,NULL,NULL,NULL,NULL,'2026/01/31 20:09:00'),(3,'88145649511',3,NULL,NULL,NULL,'13246546546','2026/01/31 20:09:00'),(4,'13246546546',2,NULL,NULL,NULL,NULL,'2026/01/31 20:52:06'),(5,'13245646546',1,NULL,NULL,NULL,NULL,'2026/01/31 20:52:06'),(6,'13246546546',2,NULL,NULL,NULL,NULL,'2026/01/31 20:53:40'),(7,'13245646546',1,NULL,NULL,NULL,NULL,'2026/01/31 20:53:40'),(8,'88145649511',3,NULL,NULL,NULL,'13246546546','2026/01/31 20:53:40'),(9,'13246546546',1,NULL,0,0,NULL,'2026/02/03 07:19:34'),(10,'13246546546',1,NULL,5000,200000,NULL,'2026/02/03 07:24:02'),(11,'13245646546',2,10000,NULL,310000,NULL,'2026/02/03 07:33:36'),(12,'88145649511',3,NULL,30000,470000,'13246546546','2026/02/03 07:40:09'),(13,'13246546546',4,0,NULL,230000,'88145649511','2026/02/03 07:40:09'),(14,'88145649511',3,NULL,30000,440000,'13246546546','2026/02/03 07:41:12'),(15,'13246546546',4,30000,NULL,260000,'88145649511','2026/02/03 07:41:12');
/*!40000 ALTER TABLE `transaction_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-04  7:20:19
