-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: localcookit
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cognome` varchar(100) DEFAULT NULL,
  `dataNascita` date DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `ruolo` varchar(50) DEFAULT NULL,
  `lista` text,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('elisa.ferrari@example.com','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8','Elisa','Ferrari','1992-02-18','https://www.focus.it/site_stored/imgs/0005/019/shutterstock_574518058.1020x680.jpg','0','8','0'),('filippo@email.com','03f1615b2d6ad19e6987f393ac93ad194e9b5bb5','Filippo','Curcio','1987-04-05','https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Duke_of_Edinburgh_33_Allan_Warren.jpg/202px-Duke_of_Edinburgh_33_Allan_Warren.jpg','2','4','0'),('laura.bianchi@example.com','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8','Laura','Bianchi','1990-04-23','https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg','2','6','0'),('luigi.verdi@example.com','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8','Luigi','Verdi','1988-11-30','https://wellteca.it/wp-content/uploads/2024/03/8-segni-che-dimostrano-che-sei-una-persona-veramente-autentica.jpg','0','7','0'),('mario.rossi@example.com','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8','Mario','Rossi','1995-07-15','https://img.freepik.com/free-photo/portrait-beautiful-young-woman-standing-grey-wall_231208-10760.jpg','2','5','0'),('mattia.maucioni@paspa.it','8ed80d31ad8e744c02ca39146a858e2675d76d9d','Mattia','Maucioni','1999-11-09','https://media.licdn.com/dms/image/D4D03AQFHAQ0o-oBA7w/profile-displayphoto-shrink_200_200/0/1678866192132?e=2147483647&v=beta&t=AzvOQOxzkii2OdNAuOVzCl3ZrXe_RpWCR3ZcfZVl3J4','0','0','0'),('simone.russo@example.com','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8','Simone','Russo','1985-09-09','https://st3.depositphotos.com/3776273/31936/i/450/depositphotos_319362956-stock-photo-man-pointing-showing-copy-space.jpg','0','9','0');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-18 15:15:23
