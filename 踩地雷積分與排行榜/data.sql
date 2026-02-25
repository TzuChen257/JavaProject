CREATE DATABASE  IF NOT EXISTS `hw3_bomp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hw3_bomp`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: hw3_bomp
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
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `time_spend` varchar(45) DEFAULT NULL,
  `time_now` varchar(45) DEFAULT NULL,
  `map_level` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (5,'dgf','00:19','2026/02/12-09:18:17',1),(6,'dgf','00:23','2026/02/12 15:01:26',1),(7,'abc','00:38','2026/02/12 15:03:19',1),(8,'abc','00:36','2026/02/20 20:54:03',1),(9,'abc','00:19','2026/02/20 20:55:25',1),(10,'abc','00:38','2026/02/20 20:58:52',1),(11,'abc','00:34','2026/02/21 16:40:16',1),(12,'abc','00:25','2026/02/21 16:41:11',1),(13,'abc','00:30','2026/02/22 12:10:11',1),(14,'abc','00:33','2026/02/22 12:13:57',1),(15,'abc','00:22','2026/02/22 12:56:05',1),(16,'abc','00:20','2026/02/22 14:07:10',1),(17,'admin','00:24','2026/02/17 17:13:00',1),(18,'abc','00:28','2026/02/23 06:02:34',1),(19,'dgf','02:56','2026/02/20 11:16:18',1),(20,'admin','00:59','2026/02/19 12:54:33',2),(21,'abc','01:25','2026/02/24 09:48:56',2),(22,'dgf','02:29','2026/02/12 13:50:44',2),(23,'admin','01:26','2026/02/13 11:25:56',3),(24,'abc','00:44','2026/02/21 23:45:06',3),(25,'dgf','02:40','2026/02/22 14:00:12',3),(26,'admin','02:20','2026/02/23 10:37:45',1),(27,'abc','02:27','2026/02/16 05:16:51',1),(28,'admin','02:54','2026/02/14 00:09:30',1),(29,'admin','00:44','2026/02/13 12:16:23',1),(30,'abc','01:46','2026/02/22 03:03:09',1),(31,'admin','00:41','2026/02/19 17:58:57',1),(32,'abc','02:30','2026/02/13 13:47:09',1),(33,'admin','00:22','2026/02/12 18:42:13',1),(34,'abc','01:27','2026/02/12 10:43:14',1),(35,'admin','01:20','2026/02/20 12:23:42',2),(36,'dgf','00:37','2026/02/15 22:47:51',2),(37,'abc','00:10','2026/02/20 15:05:18',2),(38,'abc','02:48','2026/02/21 00:31:29',2),(39,'abc','02:46','2026/02/19 12:09:25',2),(40,'admin','02:18','2026/02/22 07:53:51',2),(41,'abc','01:32','2026/02/15 22:13:00',2),(42,'abc','01:49','2026/02/18 17:28:53',2),(43,'abc','01:28','2026/02/18 15:03:46',2),(44,'dgf','00:47','2026/02/21 01:15:13',3),(45,'admin','02:18','2026/02/19 09:10:37',3),(46,'abc','02:33','2026/02/21 21:56:03',3),(47,'abc','00:15','2026/02/14 18:12:14',3),(48,'admin','00:43','2026/02/14 12:57:36',3),(49,'admin','02:16','2026/02/14 16:49:28',3),(50,'dgf','02:58','2026/02/17 12:56:17',3),(51,'abc','00:35','2026/02/17 21:15:25',3),(52,'dgf','01:18','2026/02/11 21:06:18',3),(53,'abc','00:46','2026/02/24 14:24:09',1),(54,'abc','03:14','2026/02/24 14:30:47',2);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `level` int DEFAULT NULL,
  `score` int DEFAULT '0',
  `latest_checkin` varchar(45) DEFAULT NULL,
  `checkin_week` varchar(10) DEFAULT NULL,
  `checkin_count` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','0000',4,520,'2026/02/01','2026-W04',0),(2,'abc','123',5,726,'2026/02/24','2026-W09',1),(3,'dgf','123',4,476,'2026/02/24','2026-W09',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-24 23:37:27
