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
-- Table structure for table `ricetta`
--

DROP TABLE IF EXISTS `ricetta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ricetta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `foto` longtext,
  `kcal` int DEFAULT NULL,
  `tempoPrep` int DEFAULT NULL,
  `tempoCott` int DEFAULT NULL,
  `dosi` int DEFAULT NULL,
  `procedimento` text,
  `utente` varchar(100) DEFAULT NULL,
  `etnia` varchar(100) DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  `voto` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `utente_idx` (`utente`),
  CONSTRAINT `utente` FOREIGN KEY (`utente`) REFERENCES `utente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricetta`
--

LOCK TABLES `ricetta` WRITE;
/*!40000 ALTER TABLE `ricetta` DISABLE KEYS */;
INSERT INTO `ricetta` VALUES (13,'Spaghetti al pomodoro','https://www.giallozafferano.it/images/221-22163/Spaghetti-al-pomodoro_650x433_wm.jpg',400,20,30,4,'Metti a bollire dell\'acqua salata in una pentola. Nel frattempo, scaldare l\'olio in una padella e aggiungere l\'aglio tritato. Aggiungere i pomodori pelati e cuocere per 10 minuti. Cuocere gli spaghetti nell\'acqua bollente fino a quando sono al dente. Scolare gli spaghetti e aggiungerli alla salsa di pomodoro. Mescolare bene e servire caldo.','mattia.maucioni@paspa.it','1','1',4),(14,'Pollo alla griglia','https://www.donnamoderna.com/content/uploads/2021/04/petto-di-pollo-alla-griglia.jpg',350,15,25,2,'Marinare il pollo con olio d\'oliva, succo di limone, aglio tritato, sale e pepe. Accendere la griglia e cuocere il pollo fino a quando è ben cotto su entrambi i lati. Servire caldo con una spruzzata di prezzemolo fresco e fette di limone.','simone.russo@example.com','1','1',3),(15,'Insalata mista','https://www.unmondodisapori.it/wp-content/uploads/2020/05/insalata.jpg',200,10,0,2,'Lavare e tagliare la lattuga, i pomodori e le carote. Mettere gli ingredienti in una ciotola grande. Condire con olio d\'oliva, aceto balsamico, sale e pepe. Mescolare bene e servire fresco.','mario.rossi@example.com','1','1',3),(16,'Risotto ai funghi','https://www.tavolartegusto.it/wp/wp-content/uploads/2019/09/Risotto-ai-Funghi-Ricetta-Risotto-ai-funghi-.jpg',500,25,30,4,'In una pentola, far bollire il brodo di pollo. In una padella, soffriggere la cipolla tritata con il burro fino a che diventi trasparente. Aggiungere il riso e tostare leggermente. Aggiungere gradualmente il brodo caldo al riso, mescolando continuamente fino a quando il riso è cotto. Aggiungere i funghi trifolati e il formaggio grattugiato. Mescolare bene e servire caldo.','laura.bianchi@example.com','1','1',4),(17,'Tiramisù','https://www.giallozafferano.it/images/173-17354/Tiramisu_650x433_wm.jpg',600,20,0,6,'Preparare il caffè e lasciarlo raffreddare. In una ciotola, mescolare i tuorli d\'uovo con lo zucchero fino a ottenere una crema chiara e spumosa. Aggiungere il mascarpone e mescolare fino a ottenere una crema liscia. In un\'altra ciotola, montare gli albumi a neve ferma. Incorporare gli albumi montati nella crema al mascarpone. Inzuppare i savoiardi nel caffè e adagiarli in uno stampo da tiramisù. Coprire con uno strato di crema al mascarpone. Ripetere il processo fino a esaurimento degli ingredienti. Spolverare con cacao in polvere e lasciare riposare in frigorifero per almeno 4 ore prima di servire.','elisa.ferrari@example.com','1','1',3),(18,'Pizza Margherita','https://upload.wikimedia.org/wikipedia/commons/c/c8/Pizza_Margherita_stu_spivack.jpg',700,30,20,1,'Preparare la base della pizza stendendo l\'impasto su una teglia. Spalmare il pomodoro sulla base della pizza. Aggiungere il formaggio mozzarella a fette e le foglie di basilico. Condire con un filo di olio d\'oliva e una spolverata di sale. Infornare a 220°C per circa 20 minuti o fino a quando la pizza è dorata e croccante.','luigi.verdi@example.com','1','1',2),(19,'Hamburger con patatine fritte','https://www.soniaperonaci.it/wp-content/uploads/2017/03/Cheeseburger-2-1.jpg',800,40,30,2,'Formare l\'hamburger con la carne macinata, aggiungendo sale e pepe. Cuocere l\'hamburger su una griglia ben calda fino a quando è cotto a puntino. Nel frattempo, tagliare le patate a fette e friggerle in olio caldo fino a quando sono dorate e croccanti. Assemblare l\'hamburger con l\'insalata, il pomodoro, il formaggio e la maionese. Servire caldo con le patatine fritte.','laura.bianchi@example.com','1','1',3),(20,'Sushi assortiti','https://www.todis.it/wp-content/uploads/2023/05/sushi-fatto-in-casa.jpg',600,45,0,2,'Preparare il sushi rice seguendo le istruzioni sulla confezione. Tagliare il pesce a fette sottili. Disporre il sushi rice su un tappetino di bambù e aggiungere una striscia di pesce su ciascun pezzo di sushi rice. Arrotolare delicatamente il sushi utilizzando il tappetino di bambù. Tagliare il rotolo di sushi in pezzi e servire con salsa di soia e wasabi.','luigi.verdi@example.com','1','1',2),(21,'Lasagne al forno','https://www.cucina-naturale.it/wp-content/uploads/2021/09/lasagne-al-ragu%CC%80-senza-lattosio5.jpg',750,60,45,6,'Preparare la besciamella sciogliendo il burro in una pentola, aggiungere la farina e cuocere per alcuni minuti. Gradualmente aggiungere il latte caldo, mescolando continuamente fino a ottenere una crema liscia. In una teglia da forno, alternare strati di pasta per lasagne, ragù di carne e besciamella. Terminare con uno strato di besciamella e formaggio grattugiato. Infornare a 180°C per circa 45 minuti o fino a quando è dorata e bubbole. Lasciare riposare per qualche minuto prima di servire.','simone.russo@example.com','1','1',1);
/*!40000 ALTER TABLE `ricetta` ENABLE KEYS */;
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
