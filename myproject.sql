-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2016 at 05:34 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `drugs`
--

CREATE TABLE `drugs` (
  `id` int(11) NOT NULL,
  `drugName` varchar(25) NOT NULL,
  `commonName` varchar(25) DEFAULT NULL,
  `drugDescription` varchar(200) NOT NULL,
  `drugSideEffects` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `drugs`
--

INSERT INTO `drugs` (`id`, `drugName`, `commonName`, `drugDescription`, `drugSideEffects`) VALUES
(1, 'gentamicin', NULL, 'antibiotic. used to cure both gram-negative\nand gram-positive bacterial infections.', 'may lead to gram negative endotoxemia\nwith some gram-ve bacteria.'),
(2, 'L-Dopa', NULL, 'This drug is used in the management\nof Parkinson''s disease.\nIt can penetrate the blood-brain barrier.', 'Loss of interest, drowsiness, tinnitus.'),
(3, 'Warfarin', NULL, 'This an anticoagulant used to manage\nthrombotic conditions.', 'Excess bleeding.'),
(4, 'Imipenem (Primaxin)', NULL, 'An intravenous beta-lactam antibiotic.\nEffective against drug-resistant\ngram-negative bacteria.', 'Nausea and vomiting.');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `fName` varchar(25) NOT NULL,
  `lName` varchar(25) NOT NULL,
  `age` int(2) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `passWord` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `fName`, `lName`, `age`, `userName`, `passWord`) VALUES
(1, 'Ken', 'Walubengo', 21, 'ken', 'ken123'),
(2, 'Nick', 'Walubengo', 21, 'Nick', 'ken123'),
(3, 'Nicks', 'Walubengo', 21, 'Nicks', 'nix123'),
(4, 'Dan', 'Diego', 1991, 'Dan1991', ''),
(6, 'Fred', 'Obachi', 34, 'Fred34', ''),
(8, 'Allan', 'Kip', 56, 'Allan56', ''),
(10, 'Samuel', 'Omulo', 23, 'Samuel23', ''),
(11, 'Otonglo', 'Times', 18, 'Otonglo18', '1234'),
(12, 'Kaput', 'Zosky', 23, 'Kaput23', '1234'),
(14, 'Chedi', 'Olela', 27, 'Chedi27', '1234'),
(15, 'Edith', 'Achieng''', 19, 'Edith19', '1234'),
(16, 'John', 'Nderitu', 18, 'John18', '1234'),
(17, 'John', 'Otieno', 22, 'John22', '1234'),
(18, 'Raila', 'Odinga', 67, 'Raila67', '1234'),
(19, 'Samson', 'Ochieng', 22, 'Samson22', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `drugs`
--
ALTER TABLE `drugs`
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `drugName` (`drugName`),
  ADD UNIQUE KEY `commonName` (`commonName`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`,`userName`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `userName` (`userName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `drugs`
--
ALTER TABLE `drugs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
