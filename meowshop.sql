-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: meowshop
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ordine`
--

DROP TABLE IF EXISTS `ordine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ordine` (
  `numOrdine` int(11) NOT NULL AUTO_INCREMENT,
  `utente` varchar(45) NOT NULL,
  `data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `numeroCarta` varchar(45) NOT NULL,
  `nomeSpedizione` varchar(45) NOT NULL,
  `cognomeSpedizione` varchar(45) NOT NULL,
  `indirizzo` varchar(200) NOT NULL,
  `città` varchar(45) NOT NULL,
  `cap` varchar(45) NOT NULL,
  `provincia` varchar(45) NOT NULL,
  `nomeIntestatario` varchar(45) NOT NULL,
  `cognomeIntestatario` varchar(45) NOT NULL,
  `meseScadenza` int(11) NOT NULL,
  `annoScadenza` int(11) NOT NULL,
  `cvv` int(11) NOT NULL,
  PRIMARY KEY (`numOrdine`),
  KEY `utenteOrdine_idx` (`utente`),
  CONSTRAINT `utenteOrdine` FOREIGN KEY (`utente`) REFERENCES `utente` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordine`
--

LOCK TABLES `ordine` WRITE;
/*!40000 ALTER TABLE `ordine` DISABLE KEYS */;
INSERT INTO `ordine` VALUES (2,'manu@manu.it','2020-02-18 00:00:00','','','','','','','','','',0,0,0),(3,'manu@manu.it','2020-02-18 00:00:00','','','','','','','','','',0,0,0),(4,'ale@capo.it','2020-02-18 00:00:00','','','','','','','','','',0,0,0),(5,'ale@capo.it','2020-02-18 17:33:46','','','','','','','','','',0,0,0),(6,'manu@manu.it','2020-04-25 18:34:31','','','','','','','','','',0,0,0),(7,'ale@capo.it','2020-04-25 18:35:05','','','','','','','','','',0,0,0),(17,'manu@manu.it','2020-04-25 19:48:20','boo','','','','','','','','',0,0,0),(18,'manu@manu.it','2020-04-25 19:49:25','duee','','','','','','','','',0,0,0),(19,'manu@manu.it','2020-04-25 19:53:47','ssss','','','','','','','','',0,0,0),(20,'manu@manu.it','2020-04-26 19:42:33','carta2','','','','','','','','',0,0,0),(21,'manu@manu.it','2020-04-26 19:46:16','aaaaa','','','','','','','','',0,0,0),(22,'manu@manu.it','2020-04-26 19:47:12','aaaaaaaaaaa','','','','','','','','',0,0,0),(23,'manu@manu.it','2020-04-26 23:55:35','manuuu','','','','','','','','',0,0,0),(24,'manu@manu.it','2020-04-26 23:57:31','duee','','','','','','','','',0,0,0),(25,'manu@manu.it','2020-04-27 18:34:43','provaAle','','','','','','','','',0,0,0),(26,'manu@manu.it','2020-04-27 18:35:44','aaaa','','','','','','','','',0,0,0),(27,'manu@manu.it','2020-04-30 19:14:36','666','','','','','','','','',0,0,0),(28,'checco@checco.it','2020-05-01 18:58:26','checco','','','','','','','','',0,0,0),(29,'manu@manu.it','2020-05-18 22:19:14','aa','aaa','aaa','aaa','aaa','aa','aa','aa','aa',1,1,1),(30,'manu@manu.it','2020-05-19 17:02:36','saaaasas','Emanuele','Zito','Via Trotula De Ruggiero 27','sa','84100','Salerno','Emanuele','Zito',9,2020,400),(31,'manu@manu.it','2020-05-19 17:11:53','numerocarta','Emanuele','Zito','indirizo','salerno','84qulks','sa','manu','zio',3,2020,444),(32,'ale@capo.it','2020-06-03 20:13:47','numerocarta','nomesped','cognsped','indir','città','cap','prov','nomeInt','cognomeint',1,2222,333);
/*!40000 ALTER TABLE `ordine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordineprodotto`
--

DROP TABLE IF EXISTS `ordineprodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ordineprodotto` (
  `idProdotto` int(11) NOT NULL,
  `numOrdine` int(11) NOT NULL,
  `quantità` int(11) NOT NULL,
  PRIMARY KEY (`idProdotto`,`numOrdine`),
  KEY `ordine_idx` (`numOrdine`),
  CONSTRAINT `ordine` FOREIGN KEY (`numOrdine`) REFERENCES `ordine` (`numOrdine`),
  CONSTRAINT `prodotto` FOREIGN KEY (`idProdotto`) REFERENCES `prodotto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordineprodotto`
--

LOCK TABLES `ordineprodotto` WRITE;
/*!40000 ALTER TABLE `ordineprodotto` DISABLE KEYS */;
INSERT INTO `ordineprodotto` VALUES (1,3,3),(2,3,3),(3,3,3),(4,17,2),(4,29,1),(4,30,1),(4,32,3),(6,18,2),(8,27,3),(8,32,2),(11,19,2),(11,20,3),(11,21,1),(11,22,2),(11,23,3),(11,26,2),(11,28,2),(11,29,1),(11,31,1),(11,32,1),(12,20,1),(13,30,1),(14,25,2),(15,18,3),(15,20,1),(15,24,1),(15,30,1),(16,27,1),(16,30,1),(16,31,1),(17,30,1);
/*!40000 ALTER TABLE `ordineprodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotto`
--

DROP TABLE IF EXISTS `prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `prodotto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `stock` int(11) NOT NULL,
  `prezzo` float NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `foto` varchar(45) NOT NULL,
  `descrizione` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` VALUES (1,'primo prodotto',100,12.5,'categoria','cuccia4.png',NULL),(2,'secondo prodotto',100,12.5,'categoria','gioco1.png',NULL),(3,'terzo prodotto',100,12.5,'categoria','trasportino10.png',NULL),(4,'Altalettino',20,15,'Zona notte','cuccia1.png','Lettino ad altalena per il tuo gattino'),(5,'LettoTetto',20,29.99,'Zona notte','cuccia2.png','Una vera casa proporzionata per il tuo gatto!'),(6,'SaccaROAR',20,20,'Zona notte','cuccia3.png','Morbida sacca ispirata ad un leoncino'),(7,'MERRYlettino',10,19.99,'Zona notte','cuccia4.png','Merry Christmas!'),(8,'LettoSqualo',20,16.5,'Zona notte','cuccia5.png','Capiente lettino a forma di squalo'),(9,'LettoAntico',15,12.2,'Zona notte','cuccia6.png','Lettino stile rustico'),(10,'KingLetto',20,22.22,'Zona notte','cuccia7.png','Fai sentire il tuo gatto un vero re!'),(11,'CatRuota',20,29.99,'Svago','gioco7.png','Chi ha detto che i gatti non amano le ruote?'),(12,'FaroLaser',20,25.5,'Svago','gioco2.png','Faro che proietta un laser mobile'),(13,'PallaSpirale',10,12.25,'Svago','gioco4.png','Spirale fornita di palline colorate'),(14,'CatTopolini',15,10,'Svago','gioco9.png','Semplicemente 4 morbidi topolini'),(15,'AstroTrasporto',20,35.5,'Trasporto','trasportino8.png','Fai sentire il tuo gatto un vero astronauta!'),(16,'BabyTrasporto',20,24.5,'Trasporto','trasportino1.png','Trasportino dal design delicato'),(17,'TracollaTrasporto',20,35.5,'Trasporto','trasportino9.png','Trasportino a tracolla dalle pareti trasparenti');
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utente` (
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `dataNascita` date NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL DEFAULT 'utente',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('Admin','admin','1994-10-18','admin@admin.it','admin','admin'),('Ale','Capo','1997-12-25','ale@capo.it','ale','utente'),('sadsa','asdasd','2019-10-10','asd@asd.it','asd','utente'),('checco','zito','2004-10-15','checco@checco.it','checco','utente'),('Manu','Zito','1994-10-18','manu@manu.it','manu','utente'),('prova','prova','2020-01-01','prova@prova.it','prova','utente');
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

-- Dump completed on 2020-06-04 17:38:11
