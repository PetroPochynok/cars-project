CREATE DATABASE  IF NOT EXISTS `carsprojectdb`;
USE `carsprojectdb`;

-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: carsprojectdb
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `seats` int DEFAULT NULL,
  `fuel_type` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `mileage` double DEFAULT NULL,
  `price` int DEFAULT NULL,
  CONSTRAINT `car_PK` PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'Mitsubishi','Outlander Sport 2.0 ES','Labrador Black Pearl',4,'Gasoline','BOUGHT CAR',2,19315),(2,'Hyundai','Tucson Ultimate','Dusk Blue',4,'Gasoline','NEW CAR ON SALE',10,28057),(3,'Tesla','75D','Black',5,'Electric','USED CAR ON SALE',12.328,52500),(4,'Toyota','RAV4','Classic Silver Metallic',4,'Gasoline','BOUGHT CAR',88.889,13995),(5,'Nissan','Maxima 3.5 SV','Gun Metallic',4,'Gasoline','USED CAR ON SALE',18.364,26995),(6,'GMC','Sierra 1500 SLT','Summit White',4,'Gasoline','USED CAR ON SALE',10.441,48990),(7,'Chevrolet','Traverse LT Cloth','Mosaic Black Metallic',4,'Gasoline','BOUGHT CAR',3,34225),(8,'Kia','K5 GT-Line','Passion Red',4,'Gasoline','BOUGHT CAR',5,26291),(9,'Jeep','Grand Cherokee SRT','Bright White Clearcoat',5,'Gasoline','RETURNED CAR',74.401,37000),(10,'Toyota','Corolla LE','Silver',5,'Gasoline','CAR TO RENT ON SALE',16.911,15291),(11,'Subaru','Forester Limited','Crimson Red Pearl',5,'Gasoline','IN RENT',13.656,28911),(12,'Acura','MDX 3.5L','Crystal Black Pearl',5,'Gasoline','IN RENT',13.264,32925),(13,'Ford','Bronco Sport Badlands','Blue',5,'Gasoline','NEW CAR ON SALE',2,34710),(14,'Jeep','Cherokee Latitude Lux','Velvet Red Pearlcoat',5,'Gasoline','NEW CAR ON SALE',8,27089),(15,'Kia','Forte GT-Line','Snow White Pearl',5,'Gasoline','NEW CAR ON SALE',0,21750),(16,'Kia','Seltos EX','Cherry Black',4,'Gasoline','NEW CAR ON SALE',12,26340),(17,'Cadillac','XT6 Sport AWD','Red Horizon Tintcoat',5,'Gasoline','NEW CAR ON SALE',12,46845),(18,'Toyota','Corolla Hatchback XSE','Midnight Black Metallic',4,'Gasoline','NEW CAR ON SALE',2,25732),(19,'Ford','Mustang GT','Silver',4,'Gasoline','NEW CAR ON SALE',5,38000),(20,'Ford','Edge ST Line','Blue',5,'Gasoline','NEW CAR ON SALE',1,42485),(21,'Chevrolet','Equinox Premier','Iridescent Pearl Tricoat',5,'Gasoline','NEW CAR ON SALE',6,29815),(22,'Honda','Civic LX','Aegean Blue Metallic',5,'Gasoline','NEW CAR ON SALE',1,19584),(23,'Kia','Rio LX','Clear White',4,'Gasoline','BOUGHT CAR',5,9897),(24,'Kia','Forte LXS','Silky Silver',5,'Gasoline','BOUGHT CAR',10,13976),(25,'Nissan','Versa 1.6 SV','Black',4,'Gasoline','NEW CAR ON SALE',10,15142),(26,'Acura','TLX FWD','Majestic Black Pearl',5,'Gasoline','USED CAR ON SALE',20.713,21970),(27,'Chevrolet','Suburban LS','Black',5,'E85 Flex Fuel','USED CAR ON SALE',133.386,14995),(28,'Volkswagen','Golf TDI S 4-Door','Red',5,'Diesel','USED CAR ON SALE',48.328,11999),(29,'Acura','MDX 3.7L Technology','Graphite Luster Metallic',5,'Gasoline','BOUGHT CAR',97.271,14991),(30,'Cadillac','Escalade Luxury','Crystal White Tri-Coat',4,'Gasoline','USED CAR ON SALE',43.894,52765),(31,'Volkswagen','Tiguan 2.0T S','Pure White',5,'Gasoline','BOUGHT CAR',13.455,15999),(32,'Nissan','370Z Touring','Pearl White',2,'Gasoline','USED CAR ON SALE',64.541,16999),(33,'Mercedes Benz','C 300 4MATIC','Polar White',4,'Gasoline','USED CAR ON SALE',34.51,29999),(34,'Chevrolet','Camaro 1LT','Blue',4,'Gasoline','USED CAR ON SALE',13.061,24335),(35,'Mazda','CX-5 Grand Touring','Jet Black Mica',5,'Gasoline','USED CAR ON SALE',20.051,26229),(36,'Nissan','Altima 2.5 SL','Storm Blue Metallic',5,'Gasoline','USED CAR ON SALE',19.501,18995),(37,'Lincoln','MKC Premiere','Ingot Silver Metallic',5,'Gasoline','CAR TO RENT ON SALE',46.07,19400),(38,'Dodge','Journey GT','Billet Clearcoat',5,'Gasoline','IN RENT',23.36,22995),(39,'Toyota','Tundra SR5','Magnetic Gray Metallic',5,'Gasoline','RETURNED CAR',98.847,29992),(40,'INFINITI','QX80 Luxe','Liquid Platinum',4,'Gasoline','CAR TO RENT ON SALE',55.414,39995),(41,'Volkswagen','Atlas 2.0T SEL','Platinum Gray Metallic',5,'Gasoline','RETURNED CAR',11.908,36989),(42,'Toyota','4Runner Limited','Classic Silver Metallic',5,'Gasoline','CAR TO RENT ON SALE',18.848,42897),(43,'Lexus','RX 450h','Blue',4,'Hybrid','CAR TO RENT ON SALE',28.583,39900),(44,'Nissan','Versa S','Brilliant Silver Metallic',4,'Gasoline','CAR TO RENT ON SALE',14.433,14500),(45,'BMW','X6 xDrive35i','Jet Black',4,'Gasoline','CAR TO RENT ON SALE',88.271,26895),(46,'Mazda','CX-9 Grand Touring','Deep Crystal Blue Mica',4,'Gasoline','CAR TO RENT ON SALE',12.739,37987),(47,'Lexus','NX 300 Base','Nebula Gray Pearl',5,'Gasoline','IN RENT',10.623,38987),(48,'Porsche','Taycan Turbo','Dolomite Silver Metallic',4,'Electric','NEW CAR ON SALE',2.1,169850),(49,'BMW','ALPINA B7 xDrive','Mineral White Metallic',4,'Gasoline','NEW CAR ON SALE',20,154745),(50,'Audi','RS 7 4.0T quattro','Sebring Black Crystal Effect',5,'Gasoline','NEW CAR ON SALE',13,134770),(51,'Porsche','Taycan 4S','White',4,'Electric','NEW CAR ON SALE',5,119820),(52,'Jaguar','F-TYPE R','Firenze Red',2,'Gasoline','NEW CAR ON SALE',12,112080),(53,'Maserati','Levante GranSport','Grigio',5,'Gasoline','NEW CAR ON SALE',25,99185),(54,'Chevrolet','Corvette Stingray w/2LT','Silver Flare Metallic',2,'Gasoline','NEW CAR ON SALE',12,84270),(55,'Porsche','718 Cayman GTS 4.0','Chalk',2,'Gasoline','NEW CAR ON SALE',5,105300),(56,'GMC','Sierra 2500 Denali','Onyx Black',4,'Diesel','NEW CAR ON SALE',2,77815),(57,'Ford','F-150 Platinum','Black',5,'Gasoline','NEW CAR ON SALE',25,71904),(58,'RAM','2500 Laramie','Diamond Black',5,'Diesel','NEW CAR ON SALE',4,64929),(59,'Porsche','Cayenne AWD','Black',5,'Gasoline','NEW CAR ON SALE',8,91330),(60,'Lincoln','Corsair Reserve','Silver Radiance',5,'Gasoline','NEW CAR ON SALE',3,53750),(61,'Chevrolet','Spark LS','Nightfall Gray',4,'Gasoline','NEW CAR ON SALE',0,11440),(62,'Aston Martin','DB11 V12','Magnetic Silver',2,'Gasoline','USED CAR ON SALE',24.742,145999),(63,'Ferrari','California T','White',2,'Gasoline','NEW CAR ON SALE',13,137225),(64,'Ferrari','328 GTS','Tan',2,'Gasoline','USED CAR ON SALE',29.069,135000),(65,'Dodge','Challenger SRT Demon','Pitch Black Clearcoat',2,'Gasoline','USED CAR ON SALE',35.229,128000),(66,'Land Rover','5.0L V8 Supercharged Autobiography','Fuji White',4,'Gasoline','USED CAR ON SALE',16.52,122350),(67,'Nissan','GT-R Premium','Pearl White Tri-Coat',2,'Gasoline','USED CAR ON SALE',52,117250),(68,'Chevrolet','Corvette Stingray w/2LT','Torch Red',2,'Gasoline','USED CAR ON SALE',68,109000),(69,'Porsche','911 Carrera','Night Blue Metallic',2,'Gasoline','USED CAR ON SALE',33.776,97650),(70,'Mercedes Benz','AMG GLE 53 Base','Designo Diamond White Metallic',5,'Gasoline','USED CAR ON SALE',21.232,91210),(71,'Lincoln','Navigator Reserve','Silver Radiance',5,'Gasoline','USED CAR ON SALE',15.005,85000),(72,'Land Rover','Defender 110 S','Tasman Blue',5,'Gasoline','USED CAR ON SALE',67,66250),(73,'BMW','X3 PHEV xDrive30e','Black Sapphire Metallic',5,'Hybrid','CAR TO RENT ON SALE',67,49500),(74,'Cadillac','XT5 Sport','Manhattan Noir Metallic',4,'Gasoline','CAR TO RENT ON SALE',85,42750),(75,'Ford','Escape Titanium Hybrid','Blue Metallic',4,'Hybrid','IN RENT',6,32000),(76,'Chevrolet','Blazer 2LT','Summit White',5,'Gasoline','CAR TO RENT ON SALE',105,27500),(77,'Subaru','Crosstrek Sport','Cool Gray Khaki',5,'Gasoline','CAR TO RENT ON SALE',15,26227),(78,'Mitsubishi','Eclipse Cross SE','Diamond Red',4,'Gasoline','CAR TO RENT ON SALE',25,21500),(79,'Kia','K5 LX','Ebony Black',5,'Gasoline','CAR TO RENT ON SALE',27.571,22647),(80,'Honda','Civic LX','Sonic Gray Pearl',5,'Gasoline','CAR TO RENT ON SALE',104,23150),(81,'Hyundai','Kona NIGHT','Galactic Gray',4,'Gasoline','CAR TO RENT ON SALE',150,19550);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info`
--

DROP TABLE IF EXISTS `info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(20) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `paid_days` int DEFAULT NULL,
  `car_id` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `car_id` (`car_id`),
  CONSTRAINT `info_user_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `info_car_FK` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info`
--

LOCK TABLES `info` WRITE;
/*!40000 ALTER TABLE `info` DISABLE KEYS */;
INSERT INTO `info` VALUES (1,'BOUGHT CAR',2,0,1,'2021-03-30'),(2,'BOUGHT CAR',2,0,8,'2021-03-30'),(3,'CAR IN RENT',2,7,12,'2021-03-30'),(4,'BOUGHT CAR',3,0,29,'2021-03-30'),(5,'BOUGHT CAR',3,0,31,'2021-03-30'),(6,'RETURNED CAR',3,0,39,'2021-03-30'),(7,'RETURNED CAR',3,0,41,'2021-03-30'),(8,'CAR IN RENT',4,4,47,'2021-03-30'),(9,'BOUGHT CAR',5,0,4,'2021-03-30'),(10,'BOUGHT CAR',6,0,7,'2021-03-30'),(11,'BOUGHT CAR',6,0,24,'2021-03-30'),(12,'CAR IN RENT',6,7,11,'2021-03-30'),(13,'CAR IN RENT',1,14,38,'2021-03-30'),(14,'BOUGHT CAR',1,0,23,'2021-04-04'),(15,'CAR IN RENT',1,4,75,'2021-04-05'),(16,'RETURNED CAR',1,0,9,'2021-04-08');
/*!40000 ALTER TABLE `info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  CONSTRAINT `role_PK` PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `email` varchar(128) NOT NULL,
  `money` double NOT NULL,
  CONSTRAINT `user_PK` PRIMARY KEY (`id`),
  CONSTRAINT `user_username_UQ` UNIQUE KEY (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$Gw2dtczhdzF8TfQxfCxZvuXQ9aaZslyBLEwDMR8AueALms2e8GLhe','Petro','Pochynok','Male','petro.pochynok@gmail.com',10173),(2,'james','$2a$10$J/C3DuEbYXLXs5gESt8qZOF9RXK/OIzugP237/Gvcb31wNRWO/WU2','James','Edmond','Male','james.edmond@gmail.com',18670),(3,'john','$2a$10$qo6K3YoHtEgVU/nCEArNdekXNTYgNe4w8N79O05oIII.36ExMMMW2','John','Smith','Male','john.smith@gmail.com',3419),(4,'robert','$2a$10$sFIyhVGKyvMrf7hdjood5e9M0H8uGm63JsCgXH2KAbzbinGlFTriW','Robert','Brown','Male','robert.brown@gmail.com',1348),(5,'anna','$2a$10$78UFEAa8QPReUoosqc7whuV6ouKXpI5qt8vB91Jj5fqMlrO51HOpO','Anna','Williams','Female','anna.williams@gmail.com',1005),(6,'olivia','$2a$10$fpWVMZ41LsEpqSRmtnIjcOoJDY2Lc.EHWq2jxxZL4tRqrZqlBEaCK','Olivia','Garcia','Female','olivia.garcia@gmail.com',7603);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `users_roles_role_FK` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `users_roles_user_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (2,1),(3,1),(4,1),(5,1),(6,1),(1,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-09 12:18:04
