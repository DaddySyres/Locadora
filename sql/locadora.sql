
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `cliente` (
  `cId` int(3) NOT NULL,
  `cNome` varchar(255) NOT NULL,
  `cCPF` varchar(255) NOT NULL,
  `cEmail` varchar(255) NOT NULL,
  `cTelefone` varchar(255) NOT NULL,
  `cEndereco` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `filme` (
  `idFilme` int(11) NOT NULL,
  `titulo` varchar(50) DEFAULT NULL,
  `tempo` int(11) DEFAULT NULL,
  `imagem3d` tinyint(4) DEFAULT NULL,
  `dublado` tinyint(4) DEFAULT NULL,
  `sinopse` varchar(500) DEFAULT NULL,
  `categoria` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cId`);

ALTER TABLE `filme`
  ADD PRIMARY KEY (`idFilme`);

ALTER TABLE `cliente`
  MODIFY `cId` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `filme`
  MODIFY `idFilme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;
