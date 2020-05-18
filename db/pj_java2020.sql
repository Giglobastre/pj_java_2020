-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 18 mai 2020 à 13:40
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pj_java2020`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `ID_UTILISATEUR` int(11) NOT NULL,
  `ID_COURS` int(11) NOT NULL,
  KEY `ID_UTILISATEUR` (`ID_UTILISATEUR`),
  KEY `ID_COURS` (`ID_COURS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_UTILISATEUR` int(11) NOT NULL,
  `NUMERO` int(11) NOT NULL,
  `ID_GROUPE` int(11) NOT NULL,
  PRIMARY KEY (`ID_UTILISATEUR`),
  KEY `ID_GROUPE` (`ID_GROUPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  `ID_PROMOTION` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_PROMOTION` (`ID_PROMOTION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  `CAPACITE` int(11) NOT NULL,
  `ID_SITE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_SITE` (`ID_SITE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SEMAINE` int(11) NOT NULL,
  `DATE` varchar(255) NOT NULL,
  `HEURE_DEBUT` varchar(255) NOT NULL,
  `HEURE_FIN` varchar(255) NOT NULL,
  `ETAT` int(11) NOT NULL,
  `ID_COURS` int(11) NOT NULL,
  `ID_TYPE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_COURS2` (`ID_COURS`),
  KEY `ID_TYPE2` (`ID_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignant`
--

DROP TABLE IF EXISTS `seance_enseignant`;
CREATE TABLE IF NOT EXISTS `seance_enseignant` (
  `ID_SEANCE` int(11) NOT NULL,
  `ID_ENSEIGNANT` int(11) NOT NULL,
  KEY `ID_SEANCE3` (`ID_SEANCE`),
  KEY `ID_ENSEIGNANT3` (`ID_ENSEIGNANT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupes`
--

DROP TABLE IF EXISTS `seance_groupes`;
CREATE TABLE IF NOT EXISTS `seance_groupes` (
  `ID_SEANCE` int(11) NOT NULL,
  `ID_GROUPE` int(11) NOT NULL,
  KEY `ID_GROUPE2` (`ID_GROUPE`),
  KEY `ID_SEANCE2` (`ID_SEANCE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_salle`
--

DROP TABLE IF EXISTS `seance_salle`;
CREATE TABLE IF NOT EXISTS `seance_salle` (
  `ID_SEANCE` int(11) NOT NULL,
  `ID_SALLE` int(11) NOT NULL,
  KEY `ID_SEANCE4` (`ID_SEANCE`),
  KEY `ID_SALLE4` (`ID_SALLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) NOT NULL,
  `PASSWD` varchar(255) NOT NULL,
  `NOM` int(255) NOT NULL,
  `PRENOM` varchar(255) NOT NULL,
  `DROIT` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `ID_COURS` FOREIGN KEY (`ID_COURS`) REFERENCES `cours` (`ID`),
  ADD CONSTRAINT `ID_UTILISATEUR` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `ID_GROUPE` FOREIGN KEY (`ID_GROUPE`) REFERENCES `groupe` (`ID`),
  ADD CONSTRAINT `ID_UTILISATEUR5` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID`);

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `ID_PROMOTION` FOREIGN KEY (`ID_PROMOTION`) REFERENCES `promotion` (`ID`);

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `ID_SITE` FOREIGN KEY (`ID_SITE`) REFERENCES `site` (`ID`);

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `ID_COURS2` FOREIGN KEY (`ID_COURS`) REFERENCES `cours` (`ID`),
  ADD CONSTRAINT `ID_TYPE2` FOREIGN KEY (`ID_TYPE`) REFERENCES `type_cours` (`ID`);

--
-- Contraintes pour la table `seance_enseignant`
--
ALTER TABLE `seance_enseignant`
  ADD CONSTRAINT `ID_ENSEIGNANT3` FOREIGN KEY (`ID_ENSEIGNANT`) REFERENCES `enseignant` (`ID_UTILISATEUR`),
  ADD CONSTRAINT `ID_SEANCE3` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`);

--
-- Contraintes pour la table `seance_groupes`
--
ALTER TABLE `seance_groupes`
  ADD CONSTRAINT `ID_GROUPE2` FOREIGN KEY (`ID_GROUPE`) REFERENCES `groupe` (`ID`),
  ADD CONSTRAINT `ID_SEANCE2` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`);

--
-- Contraintes pour la table `seance_salle`
--
ALTER TABLE `seance_salle`
  ADD CONSTRAINT `ID_SALLE4` FOREIGN KEY (`ID_SALLE`) REFERENCES `salle` (`ID`),
  ADD CONSTRAINT `ID_SEANCE4` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
