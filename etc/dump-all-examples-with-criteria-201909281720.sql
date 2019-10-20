-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: all-examples-with-criteria
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `HEAD_OF_DEPARTMENT`
--

DROP TABLE IF EXISTS `HEAD_OF_DEPARTMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HEAD_OF_DEPARTMENT` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teaching_department_id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `HEAD_OF_DEPARTMENT_UNIQUE_TD` (`teaching_department_id`),
  CONSTRAINT `HEAD_OF_DEPARTMENT_TEACHING_DEPARTMENTS_FK` FOREIGN KEY (`teaching_department_id`) REFERENCES `TEACHING_DEPARTMENTS` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HEAD_OF_DEPARTMENT`
--

LOCK TABLES `HEAD_OF_DEPARTMENT` WRITE;
/*!40000 ALTER TABLE `HEAD_OF_DEPARTMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `HEAD_OF_DEPARTMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STUDENTS`
--

DROP TABLE IF EXISTS `STUDENTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STUDENTS` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STUDENTS`
--

LOCK TABLES `STUDENTS` WRITE;
/*!40000 ALTER TABLE `STUDENTS` DISABLE KEYS */;
/*!40000 ALTER TABLE `STUDENTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STUDENTS_TO_TEACHERS`
--

DROP TABLE IF EXISTS `STUDENTS_TO_TEACHERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STUDENTS_TO_TEACHERS` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) NOT NULL,
  `teacher_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `STUDENTS_TO_TEACHERS_STUDENTS_FK` (`student_id`),
  KEY `STUDENTS_TO_TEACHERS_TEACHERS_FK` (`teacher_id`),
  CONSTRAINT `STUDENTS_TO_TEACHERS_STUDENTS_FK` FOREIGN KEY (`student_id`) REFERENCES `STUDENTS` (`id`) ON DELETE CASCADE,
  CONSTRAINT `STUDENTS_TO_TEACHERS_TEACHERS_FK` FOREIGN KEY (`teacher_id`) REFERENCES `TEACHERS` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STUDENTS_TO_TEACHERS`
--

LOCK TABLES `STUDENTS_TO_TEACHERS` WRITE;
/*!40000 ALTER TABLE `STUDENTS_TO_TEACHERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `STUDENTS_TO_TEACHERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TEACHERS`
--

DROP TABLE IF EXISTS `TEACHERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TEACHERS` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `teaching_department_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `TEACHERS_TEACHING_DEPARTMENTS_FK` (`teaching_department_id`),
  CONSTRAINT `TEACHERS_TEACHING_DEPARTMENTS_FK` FOREIGN KEY (`teaching_department_id`) REFERENCES `TEACHING_DEPARTMENTS` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TEACHERS`
--

LOCK TABLES `TEACHERS` WRITE;
/*!40000 ALTER TABLE `TEACHERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `TEACHERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TEACHING_DEPARTMENTS`
--

DROP TABLE IF EXISTS `TEACHING_DEPARTMENTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TEACHING_DEPARTMENTS` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TEACHING_DEPARTMENTS`
--

LOCK TABLES `TEACHING_DEPARTMENTS` WRITE;
/*!40000 ALTER TABLE `TEACHING_DEPARTMENTS` DISABLE KEYS */;
/*!40000 ALTER TABLE `TEACHING_DEPARTMENTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'all-examples-with-criteria'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-28 17:20:44
