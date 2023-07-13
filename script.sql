CREATE TABLE `dipendenti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `eta` varchar(45) NOT NULL,
  `sesso` varchar(45) NOT NULL,
  `data_nascita` date NOT NULL,
  `email` varchar(100) NOT NULL,
  `numero_telefono` varchar(45) NOT NULL,
  `salario` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci