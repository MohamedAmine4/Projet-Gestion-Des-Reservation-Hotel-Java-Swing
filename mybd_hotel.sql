-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 21 mars 2023 à 00:06
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `mybd_hotel`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `idCategorie` int(11) NOT NULL DEFAULT current_timestamp(),
  `Nom` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`idCategorie`, `Nom`) VALUES
(1, 'Simple'),
(2, 'Double'),
(3, 'Suite');

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE `chambre` (
  `numeroCh` int(11) NOT NULL,
  `idCategorie` int(11) DEFAULT NULL,
  `nbLits` int(11) DEFAULT NULL,
  `etage` int(11) DEFAULT NULL,
  `etatCh` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `chambre`
--

INSERT INTO `chambre` (`numeroCh`, `idCategorie`, `nbLits`, `etage`, `etatCh`) VALUES
(1, 1, 1, 1, 'Hors Service'),
(2, 1, 1, 1, 'Hors Service'),
(3, 1, 1, 1, 'Hors Service'),
(4, 1, 1, 1, 'Hors Service'),
(5, 1, 1, 1, 'Hors Service'),
(6, 1, 1, 1, 'Hors Service'),
(7, 1, 1, 1, 'Hors Service'),
(8, 1, 1, 1, 'Hors Service'),
(9, 1, 1, 1, 'Hors Service'),
(10, 1, 1, 1, 'Hors Service'),
(11, 2, 2, 2, 'Hors Service'),
(12, 2, 2, 2, 'Hors Service'),
(13, 2, 2, 2, 'Hors Service'),
(14, 2, 2, 2, 'Hors Service'),
(15, 2, 2, 2, 'Hors Service'),
(16, 2, 2, 2, 'Hors Service'),
(17, 2, 2, 2, 'Hors Service'),
(18, 2, 2, 2, 'Hors Service'),
(19, 2, 2, 2, 'Hors Service'),
(20, 2, 2, 2, 'Hors Service'),
(21, 3, 3, 3, 'Hors Service'),
(22, 3, 3, 3, 'Hors Service'),
(23, 3, 3, 3, 'Hors Service'),
(24, 3, 3, 3, 'Hors Service'),
(25, 3, 3, 3, 'Hors Service'),
(26, 3, 3, 3, 'Hors Service'),
(27, 3, 3, 3, 'Hors Service'),
(28, 3, 3, 3, 'Hors Service'),
(29, 3, 3, 3, 'Hors Service'),
(30, 3, 3, 3, 'Hors Service');

-- --------------------------------------------------------

--
-- Structure de la table `cheque`
--

CREATE TABLE `cheque` (
  `numCheq` varchar(50) NOT NULL,
  `Reference` int(11) DEFAULT NULL,
  `dateValidite` varchar(50) DEFAULT NULL,
  `Montant` double(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `CIN` varchar(50) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `detailreservation`
--

CREATE TABLE `detailreservation` (
  `idReservation` int(11) NOT NULL,
  `numeroRes` int(11) DEFAULT NULL,
  `idCategorie` int(11) DEFAULT current_timestamp(),
  `numeroCh` int(30) NOT NULL,
  `nbAdultes` int(11) DEFAULT NULL,
  `nbEnfants` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `Reference` int(50) NOT NULL,
  `numeroRes` int(11) DEFAULT NULL,
  `dateFacturation` datetime DEFAULT current_timestamp(),
  `prixTotal` double(10,2) DEFAULT NULL,
  `typePayement` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `prixchambre`
--

CREATE TABLE `prixchambre` (
  `idCategorie` int(11) DEFAULT NULL,
  `idSaison` int(11) DEFAULT NULL,
  `numeroCh` int(30) NOT NULL,
  `prixChambre` double(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `numeroRes` int(11) NOT NULL,
  `CIN` varchar(50) DEFAULT NULL,
  `nbChambre` int(11) DEFAULT NULL,
  `nbNuits` int(11) DEFAULT NULL,
  `dateArrivee` date DEFAULT NULL,
  `dateDepart` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `reservationeffectuee`
--

CREATE TABLE `reservationeffectuee` (
  `idReservEff` int(11) NOT NULL,
  `numeroRes` int(11) DEFAULT NULL,
  `numeroCh` int(11) DEFAULT NULL,
  `nbAdultes` int(11) DEFAULT NULL,
  `nbEnfants` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `saison`
--

CREATE TABLE `saison` (
  `idSaison` int(11) NOT NULL,
  `Nom` varchar(50) DEFAULT NULL,
  `dateDebut` date DEFAULT NULL,
  `dateFin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `saison`
--

INSERT INTO `saison` (`idSaison`, `Nom`, `dateDebut`, `dateFin`) VALUES
(1, 'basse-saison', '2023-01-01', '2023-03-31'),
(2, 'moyenne-saison', '2023-04-01', '2023-07-31'),
(3, 'haute-saison', '2023-08-01', '2023-12-31');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`idCategorie`);

--
-- Index pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`numeroCh`),
  ADD KEY `FK_Chambre_appartient` (`idCategorie`);

--
-- Index pour la table `cheque`
--
ALTER TABLE `cheque`
  ADD PRIMARY KEY (`numCheq`),
  ADD KEY `FK_Cheque_correspond` (`Reference`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`CIN`);

--
-- Index pour la table `detailreservation`
--
ALTER TABLE `detailreservation`
  ADD PRIMARY KEY (`idReservation`),
  ADD KEY `FK_DetailReservation_Reservation` (`numeroRes`),
  ADD KEY `FK_DetailReservation_Categorie` (`idCategorie`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`Reference`),
  ADD KEY `FK_Facture_contient` (`numeroRes`);

--
-- Index pour la table `prixchambre`
--
ALTER TABLE `prixchambre`
  ADD KEY `FK_PrixAdultes_Categorie` (`idCategorie`),
  ADD KEY `FK_PrixAdultes_Saison` (`idSaison`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`numeroRes`),
  ADD KEY `FK_Reservation_reserver` (`CIN`);

--
-- Index pour la table `reservationeffectuee`
--
ALTER TABLE `reservationeffectuee`
  ADD PRIMARY KEY (`idReservEff`),
  ADD KEY `FK_ReservationEffectuee_Chambre` (`numeroCh`),
  ADD KEY `FK_ReservationEffectuee_Reservation` (`numeroRes`);

--
-- Index pour la table `saison`
--
ALTER TABLE `saison`
  ADD PRIMARY KEY (`idSaison`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `detailreservation`
--
ALTER TABLE `detailreservation`
  MODIFY `idReservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `Reference` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD CONSTRAINT `FK_Chambre_appartient` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `cheque`
--
ALTER TABLE `cheque`
  ADD CONSTRAINT `FK_Cheque_correspond` FOREIGN KEY (`Reference`) REFERENCES `facture` (`Reference`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `detailreservation`
--
ALTER TABLE `detailreservation`
  ADD CONSTRAINT `FK_DetailReservation_Categorie` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`),
  ADD CONSTRAINT `FK_DetailReservation_Reservation` FOREIGN KEY (`numeroRes`) REFERENCES `reservation` (`numeroRes`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `FK_Facture_contient` FOREIGN KEY (`numeroRes`) REFERENCES `reservation` (`numeroRes`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `prixchambre`
--
ALTER TABLE `prixchambre`
  ADD CONSTRAINT `FK_PrixAdultes_Categorie` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PrixAdultes_Saison` FOREIGN KEY (`idSaison`) REFERENCES `saison` (`idSaison`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK_Reservation_reserver` FOREIGN KEY (`CIN`) REFERENCES `client` (`CIN`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `reservationeffectuee`
--
ALTER TABLE `reservationeffectuee`
  ADD CONSTRAINT `FK_ReservationEffectuee_Chambre` FOREIGN KEY (`numeroCh`) REFERENCES `chambre` (`numeroCh`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_ReservationEffectuee_Reservation` FOREIGN KEY (`numeroRes`) REFERENCES `reservation` (`numeroRes`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
