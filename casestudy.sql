-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: casestudy
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `attach_service`
--

DROP TABLE IF EXISTS `attach_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attach_service` (
  `attach_service_id` bigint NOT NULL AUTO_INCREMENT,
  `attach_service_cost` double NOT NULL,
  `attach_service_name` varchar(255) NOT NULL,
  `attach_service_status` varchar(255) DEFAULT NULL,
  `attach_service_unit` bigint NOT NULL,
  PRIMARY KEY (`attach_service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attach_service`
--

LOCK TABLES `attach_service` WRITE;
/*!40000 ALTER TABLE `attach_service` DISABLE KEYS */;
INSERT INTO `attach_service` VALUES (1,10000,'Karaoke','tiện nghi, hiện tại',1),(2,10000,'Thuê xe máy','hỏng 1 xe',1),(3,20000,'Thuê xe đạp','tốt',1),(4,15000,'Buffet buổi sáng','đầy đủ đồ ăn, tráng miệng',1),(5,90000,'Buffet buổi trưa','đầy đủ đồ ăn, tráng miệng',1),(6,16000,'Buffet buổi tối','đầy đủ đồ ăn, tráng miệng',1);
/*!40000 ALTER TABLE `attach_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `contract_id` bigint NOT NULL AUTO_INCREMENT,
  `contract_deposit` double NOT NULL,
  `contract_end_date` datetime NOT NULL,
  `contract_start_date` datetime NOT NULL,
  `contract_total_money` double NOT NULL,
  `customer_id` bigint NOT NULL,
  `employee_id` bigint NOT NULL,
  `service_id` bigint NOT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `FKktqycfixv99wjj20vcpt1c0ki` (`customer_id`),
  KEY `FKfyc3e2a29od7f529743csxxhd` (`employee_id`),
  KEY `FKgamkf6mre7km9lksltwudm27t` (`service_id`),
  CONSTRAINT `FKfyc3e2a29od7f529743csxxhd` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FKgamkf6mre7km9lksltwudm27t` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`),
  CONSTRAINT `FKktqycfixv99wjj20vcpt1c0ki` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,50000,'2001-02-23 00:00:00','2000-02-23 00:00:00',6000,1,1,5),(3,8989,'2022-01-01 00:00:00','2011-01-01 00:00:00',79799,1,1,3),(4,10000,'2010-07-07 00:00:00','2005-07-07 00:00:00',20000,4,1,3);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_detail`
--

DROP TABLE IF EXISTS `contract_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_detail` (
  `contract_detail_id` bigint NOT NULL AUTO_INCREMENT,
  `quality` bigint NOT NULL,
  `attach_service_id` bigint NOT NULL,
  `contract_id` bigint NOT NULL,
  PRIMARY KEY (`contract_detail_id`),
  KEY `FK1naid9qgk07vwgq67b7y2eowg` (`contract_id`),
  KEY `FK7cbwupicl8f762x3kulehjhf8` (`attach_service_id`),
  CONSTRAINT `FK1naid9qgk07vwgq67b7y2eowg` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`contract_id`),
  CONSTRAINT `FK7cbwupicl8f762x3kulehjhf8` FOREIGN KEY (`attach_service_id`) REFERENCES `attach_service` (`attach_service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_detail`
--

LOCK TABLES `contract_detail` WRITE;
/*!40000 ALTER TABLE `contract_detail` DISABLE KEYS */;
INSERT INTO `contract_detail` VALUES (1,1,1,1),(2,2,1,1),(3,2,2,1);
/*!40000 ALTER TABLE `contract_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT,
  `customer_address` varchar(255) DEFAULT NULL,
  `customer_birthday` date NOT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customer_gender` tinyint NOT NULL,
  `customer_id_card` varchar(255) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `customer_phone` varchar(255) NOT NULL,
  `customer_type_id` bigint NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `FK3gh83bnoitnpmccp0yi21vjro` (`customer_type_id`),
  CONSTRAINT `FK3gh83bnoitnpmccp0yi21vjro` FOREIGN KEY (`customer_type_id`) REFERENCES `customer_type` (`customer_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'scvxcvxcv','1992-02-23','nguyenthanhdong2302@gmail.com',1,'9123123','Dong','0923123',5),(2,'1115 Huỳnh Văn Lũy, Phú Mỹ, Thủ Dầu Một','1995-02-23','nguyenthanhdong2302@gmail.com',0,'9123123','test','0905132541',3),(4,'asdzxcxzczxc','1996-02-23','asdzc@gmail.com',1,'23123123131','Nhung','09213123',4);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_type`
--

DROP TABLE IF EXISTS `customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_type` (
  `customer_type_id` bigint NOT NULL AUTO_INCREMENT,
  `customer_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_type`
--

LOCK TABLES `customer_type` WRITE;
/*!40000 ALTER TABLE `customer_type` DISABLE KEYS */;
INSERT INTO `customer_type` VALUES (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');
/*!40000 ALTER TABLE `customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `division` (
  `division_id` bigint NOT NULL AUTO_INCREMENT,
  `division_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`division_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` VALUES (1,'Sale – Marketing'),(2,'Hành Chính'),(3,'Phục vụ'),(4,'Quản lý');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_degree`
--

DROP TABLE IF EXISTS `education_degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education_degree` (
  `education_degree_id` bigint NOT NULL AUTO_INCREMENT,
  `education_degree_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`education_degree_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_degree`
--

LOCK TABLES `education_degree` WRITE;
/*!40000 ALTER TABLE `education_degree` DISABLE KEYS */;
INSERT INTO `education_degree` VALUES (1,'Trung cấp'),(2,'Cao đẳng'),(3,'Đại học'),(4,'Sau đại học');
/*!40000 ALTER TABLE `education_degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` bigint NOT NULL AUTO_INCREMENT,
  `employee_adress` varchar(255) DEFAULT NULL,
  `employee_birthday` date NOT NULL,
  `employee_email` varchar(255) DEFAULT NULL,
  `employee_id_card` varchar(255) NOT NULL,
  `employee_name` varchar(255) NOT NULL,
  `employee_phone` varchar(255) NOT NULL,
  `employee_salary` double NOT NULL,
  `division_id` bigint NOT NULL,
  `education_degree_id` bigint NOT NULL,
  `position_id` bigint NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FK734h7j779fis8j0ffoslkc5rl` (`division_id`),
  KEY `FKcwcr31o5ihbewyrbvytmwj0dt` (`education_degree_id`),
  KEY `FK7tknxvg2w7in1sm3bdhs39hre` (`position_id`),
  KEY `FKphvte159mf9stx78t1fj1kmwr` (`username`),
  CONSTRAINT `FK734h7j779fis8j0ffoslkc5rl` FOREIGN KEY (`division_id`) REFERENCES `division` (`division_id`),
  CONSTRAINT `FK7tknxvg2w7in1sm3bdhs39hre` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`),
  CONSTRAINT `FKcwcr31o5ihbewyrbvytmwj0dt` FOREIGN KEY (`education_degree_id`) REFERENCES `education_degree` (`education_degree_id`),
  CONSTRAINT `FKphvte159mf9stx78t1fj1kmwr` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'1115 Huỳnh Văn Lũy, Phú Mỹ, Thủ Dầu Một','1999-02-23','nguyenthanhdong2302@gmail.com','091231','test','0905132541',66000,1,1,1,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `position_id` bigint NOT NULL AUTO_INCREMENT,
  `position_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Lễ tân'),(2,'Phục vụ'),(3,'Chuyên viên'),(4,'Giám sát'),(5,'Quản lý'),(6,'Giám đốc');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent_type`
--

DROP TABLE IF EXISTS `rent_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent_type` (
  `rent_type_id` bigint NOT NULL AUTO_INCREMENT,
  `rent_type_cost` double DEFAULT NULL,
  `rent_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rent_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_type`
--

LOCK TABLES `rent_type` WRITE;
/*!40000 ALTER TABLE `rent_type` DISABLE KEYS */;
INSERT INTO `rent_type` VALUES (1,100000,'year'),(2,10000,'month'),(3,150000,'day'),(4,80000,'hour');
/*!40000 ALTER TABLE `rent_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `service_id` bigint NOT NULL AUTO_INCREMENT,
  `description_other_convenience` varchar(255) DEFAULT NULL,
  `number_of_floors` bigint DEFAULT NULL,
  `pool_area` double DEFAULT NULL,
  `service_area` bigint DEFAULT NULL,
  `service_cost` double NOT NULL,
  `service_max_people` bigint DEFAULT NULL,
  `service_name` varchar(255) NOT NULL,
  `standard_room` varchar(255) DEFAULT NULL,
  `rent_type_id` bigint NOT NULL,
  `service_type_id` bigint NOT NULL,
  PRIMARY KEY (`service_id`),
  KEY `FKoywlclgfa4wf6cye3xgeuvhku` (`rent_type_id`),
  KEY `FK22mjc4v33uueav0w2au7ag3rv` (`service_type_id`),
  CONSTRAINT `FK22mjc4v33uueav0w2au7ag3rv` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`service_type_id`),
  CONSTRAINT `FKoywlclgfa4wf6cye3xgeuvhku` FOREIGN KEY (`rent_type_id`) REFERENCES `rent_type` (`rent_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'Có hồ bơi',4,500,25000,10000000,10,'Villa Beach Front','vip',3,1),(2,'Có thêm bếp nướng',3,0,14000,5000000,7,'House Princess 01','vip',2,2),(3,'Có tivi',0,0,5000,1000000,2,'Room Twin 01','normal',1,3),(4,'Có hồ bơi',3,300,22000,9000000,8,'Villa No Beach Front','normal',1,1),(5,'Có thêm bếp nướng',2,0,10000,4000000,5,'House Princess 02','normal',1,2),(6,'Có tivi',0,0,3000,900000,2,'Room Twin 02','normal',1,3);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type`
--

DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_type` (
  `service_type_id` bigint NOT NULL AUTO_INCREMENT,
  `service_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`service_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES (1,'Villa'),(2,'House'),(3,'Room');
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `username` varchar(255) NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`,`username`),
  KEY `FKmoky64x3seevyg69x2f2toj3q` (`username`),
  CONSTRAINT `FK7ir6hi5jr98lclgjgbyxafneu` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FKmoky64x3seevyg69x2f2toj3q` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-03 11:31:39
