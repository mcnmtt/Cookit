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
-- Table structure for table `commento`
--

DROP TABLE IF EXISTS `commento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `testo` text,
  `voto` int DEFAULT NULL,
  `ricetta` int DEFAULT NULL,
  `utente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ricettaCommento_idx` (`ricetta`),
  KEY `utenteCommento_idx` (`utente`),
  CONSTRAINT `ricettaCommento` FOREIGN KEY (`ricetta`) REFERENCES `ricetta` (`id`),
  CONSTRAINT `utenteCommento` FOREIGN KEY (`utente`) REFERENCES `utente` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commento`
--

LOCK TABLES `commento` WRITE;
/*!40000 ALTER TABLE `commento` DISABLE KEYS */;
INSERT INTO `commento` VALUES (6,'Questo è uno schifo',0,18,'filippo@email.com'),(7,'Molto gustoso!',4,13,'elisa.ferrari@example.com'),(8,'Una delizia assoluta.',5,14,'filippo@email.com'),(9,'Semplice ma buonissimo.',3,15,'laura.bianchi@example.com'),(10,'Consigliato a tutti.',3,16,'luigi.verdi@example.com'),(11,'Da leccarsi i baffi!',4,17,'mario.rossi@example.com'),(12,'Fantastico, lo rifarò sicuramente.',4,18,'mattia.maucioni@paspa.it'),(13,'Un piatto davvero eccellente.',5,19,'simone.russo@example.com'),(14,'Buono ma migliorabile.',2,20,'elisa.ferrari@example.com'),(15,'Non male, ma ho assaggiato di meglio.',2,21,'filippo@email.com'),(16,'Semplicemente delizioso!',5,13,'laura.bianchi@example.com'),(17,'Ottima scelta di ingredienti.',3,14,'luigi.verdi@example.com'),(18,'Molto soddisfacente.',3,15,'mario.rossi@example.com'),(19,'Da provare assolutamente.',4,16,'mattia.maucioni@paspa.it'),(20,'Non male per essere fatto in casa.',3,17,'simone.russo@example.com'),(21,'Qualche piccolo miglioramento è necessario.',1,18,'elisa.ferrari@example.com'),(22,'Gusto un po\' troppo delicato.',2,19,'filippo@email.com'),(23,'Piacevole ma non eccezionale.',2,20,'laura.bianchi@example.com'),(24,'Non mi ha convinto del tutto.',1,21,'luigi.verdi@example.com'),(25,'Semplice e buono.',4,13,'mario.rossi@example.com'),(26,'Da ripetere sicuramente.',3,14,'mattia.maucioni@paspa.it');
/*!40000 ALTER TABLE `commento` ENABLE KEYS */;
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
