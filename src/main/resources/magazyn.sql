-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 22 Sty 2021, 10:40
-- Wersja serwera: 10.4.16-MariaDB
-- Wersja PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `magazyn`
--
CREATE DATABASE IF NOT EXISTS `magazyn` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `magazyn`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Zrzut danych tabeli `product`
--

INSERT INTO `product` (`id`, `name`, `quantity`) VALUES
(2, 'Procesor INTEL', 14),
(3, 'Karta Graficzna AMD', 3),
(4, 'Procesor INTEL GX', 11),
(5, 'Plyta Glowna XQ', 13),
(6, 'Obudowa Komputera', 24),
(7, 'Monitor', 8),
(8, 'Sluchawki', 12),
(9, 'Glosniki', 66),
(10, 'Zasilacz', 25),
(11, 'AMD cokolwiek', 1),
(12, 'disc-speed', 15),
(14, 'zupa.romana', 0),
(15, 'aaaaa', 2),
(18, 'bomba', 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pass` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`id`, `login`, `pass`, `role`) VALUES
(1, 'admin', 'admin', 'ADMIN'),
(2, 'user1', 'user1', 'USER'),
(3, 'resup', 'resup', 'RESUPPLIER'),
(4, 'dupa123', 'dupa123', 'USER'),
(5, 'aaaaa', 'aaaaa', 'USER'),
(6, 'bbbbb', 'bbbbb', 'USER'),
(7, 'user2', 'user2', 'USER');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
