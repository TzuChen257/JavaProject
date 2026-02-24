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
-- Table structure for table `access`
--

DROP TABLE IF EXISTS `access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `access` (
  `id` int NOT NULL AUTO_INCREMENT,
  `access_level` int DEFAULT NULL,
  `access` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `access`
--

LOCK TABLES `access` WRITE;
/*!40000 ALTER TABLE `access` DISABLE KEYS */;
INSERT INTO `access` VALUES (1,1,'管理者'),(2,2,'行政人員'),(3,3,'客戶端'),(4,4,'鎖帳號');
/*!40000 ALTER TABLE `access` ENABLE KEYS */;
UNLOCK TABLES;

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
  `access_level` int DEFAULT NULL,
  `online_user` varchar(45) DEFAULT NULL,
  `online_password` varchar(45) DEFAULT NULL,
  `balance` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `national_id` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'13246546546','541234',3,'tom','05145',557000,'Tom','77.04.05','S156515451','Tainan','0913245674'),(2,'88145649511','482212',3,'yam','44551',440000,'Yam','97.04.05','D156515451','HsinChu','0913254587'),(3,'13245646546','123456',3,'wendy','44410',310000,'Wendy','87.04.05','A156515451','Taipei','0987445514'),(5,'88145849511','123456',4,'sam','02356',800000,'Sam','54.02.05','D123456789','TaiChoung','0987451236'),(6,'2026020610001','123461',3,'dau','1245',7000,'chen','74.01.20','D154221141','Taipei','0987451245');
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
  `access_level` int DEFAULT NULL,
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
-- Table structure for table `tradeact`
--

DROP TABLE IF EXISTS `tradeact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tradeact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `trade_id` int DEFAULT NULL,
  `trade_act` varchar(45) DEFAULT NULL,
  `in_out` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tradeact`
--

LOCK TABLES `tradeact` WRITE;
/*!40000 ALTER TABLE `tradeact` DISABLE KEYS */;
INSERT INTO `tradeact` VALUES (1,1,'提款',2),(2,2,'存款',1),(3,3,'轉出',2),(4,4,'轉入',1);
/*!40000 ALTER TABLE `tradeact` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_detail`
--

LOCK TABLES `transaction_detail` WRITE;
/*!40000 ALTER TABLE `transaction_detail` DISABLE KEYS */;
INSERT INTO `transaction_detail` VALUES (10,'13246546546',1,NULL,5000,200000,'ATM','2026/02/03 07:24:02'),(11,'13245646546',2,10000,NULL,310000,'ATM','2026/02/03 07:33:36'),(12,'88145649511',3,NULL,30000,470000,'13246546546','2026/02/03 07:40:09'),(13,'13246546546',4,0,NULL,230000,'88145649511','2026/02/03 07:40:09'),(14,'88145649511',3,NULL,30000,440000,'13246546546','2026/02/03 07:41:12'),(15,'13246546546',4,30000,NULL,260000,'88145649511','2026/02/03 07:41:12'),(16,'13246546546',3,NULL,3000,257000,'2026020610001','2026/02/06 16:35:27'),(17,'2026020610001',4,3000,NULL,4000,'13246546546','2026/02/06 16:35:46'),(18,'13246546546',3,NULL,3000,254000,'2026020610001','2026/02/06 16:41:02'),(19,'2026020610001',4,3000,NULL,7000,'13246546546','2026/02/06 16:41:14'),(20,'13246546546',2,300000,NULL,554000,'ATM','2026/02/06 16:43:30'),(21,'13246546546',2,3000,NULL,557000,'ATM','2026/02/06 16:49:38');
/*!40000 ALTER TABLE `transaction_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view01`
--

DROP TABLE IF EXISTS `view01`;
/*!50001 DROP VIEW IF EXISTS `view01`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view01` AS SELECT 
 1 AS `id`,
 1 AS `subject_account`,
 1 AS `o_act`,
 1 AS `in_out`,
 1 AS `income`,
 1 AS `expenses`,
 1 AS `balance_now`,
 1 AS `trading_time`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view01`
--

/*!50001 DROP VIEW IF EXISTS `view01`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view01` AS select `transaction_detail`.`id` AS `id`,`transaction_detail`.`subject_account` AS `subject_account`,concat_ws(`tradeact`.`trade_act`,`transaction_detail`.`object_account`,`transaction_detail`.`income`,`transaction_detail`.`expenses`) AS `o_act`,`tradeact`.`in_out` AS `in_out`,`transaction_detail`.`income` AS `income`,`transaction_detail`.`expenses` AS `expenses`,`transaction_detail`.`balance_now` AS `balance_now`,`transaction_detail`.`trading_time` AS `trading_time` from (`tradeact` join `transaction_detail` on((`transaction_detail`.`trading_activity` = `tradeact`.`trade_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-06 18:39:10
