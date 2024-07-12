-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Pát 12. čec 2024, 16:48
-- Verze serveru: 10.4.32-MariaDB
-- Verze PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáze: `bankingdatabase`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `product_definition`
--

CREATE TABLE `product_definition` (
  `product_id` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `pay_rate_value` int(11) NOT NULL,
  `product_key` varchar(255) NOT NULL,
  `product_type` tinyint(4) NOT NULL,
  `rate` float NOT NULL,
  `unit` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `product_definition`
--

INSERT INTO `product_definition` (`product_id`, `description`, `pay_rate_value`, `product_key`, `product_type`, `rate`, `unit`) VALUES
(1, 'consumer loan', 3, 'TEST01', 1, 0.12, 1),
(2, 'personal account', 14, 'TEST02', 0, 150, 0);

-- --------------------------------------------------------

--
-- Struktura tabulky `product_entity`
--

CREATE TABLE `product_entity` (
  `id` int(11) NOT NULL,
  `amount_borrowed` int(11) DEFAULT NULL,
  `balance` float NOT NULL,
  `created` date DEFAULT NULL,
  `fixed_rate` int(11) DEFAULT NULL,
  `i_ban` varchar(255) DEFAULT NULL,
  `next_billing_date` date NOT NULL,
  `number_of_payments_remaining` int(11) DEFAULT NULL,
  `total_number_of_payments` int(11) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `product_definition_product_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `product_entity`
--

INSERT INTO `product_entity` (`id`, `amount_borrowed`, `balance`, `created`, `fixed_rate`, `i_ban`, `next_billing_date`, `number_of_payments_remaining`, `total_number_of_payments`, `owner_id`, `product_definition_product_id`) VALUES
(1, 100000000, 100000000, '1980-01-01', 100, 'CZ00000000000110010', '1980-01-01', 50, 50, 1, 1),
(2, NULL, 100000000, '1980-01-01', NULL, 'CZ00000000000110010', '1980-01-01', NULL, NULL, 1, 2);

-- --------------------------------------------------------

--
-- Struktura tabulky `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `user`
--

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`, `phone_number`, `user_id`) VALUES
(1, 'test@test.com', 'test', 'testovic', 'password', '+420123456789', '123456/1234');

--
-- Indexy pro exportované tabulky
--

--
-- Indexy pro tabulku `product_definition`
--
ALTER TABLE `product_definition`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexy pro tabulku `product_entity`
--
ALTER TABLE `product_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjubhj1gx9308ahar0yhvuwccb` (`owner_id`),
  ADD KEY `FKg6qe7ncgcnsgysrjsuthh876f` (`product_definition_product_id`);

--
-- Indexy pro tabulku `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `product_definition`
--
ALTER TABLE `product_definition`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pro tabulku `product_entity`
--
ALTER TABLE `product_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pro tabulku `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Omezení pro exportované tabulky
--

--
-- Omezení pro tabulku `product_entity`
--
ALTER TABLE `product_entity`
  ADD CONSTRAINT `FKg6qe7ncgcnsgysrjsuthh876f` FOREIGN KEY (`product_definition_product_id`) REFERENCES `product_definition` (`product_id`),
  ADD CONSTRAINT `FKjubhj1gx9308ahar0yhvuwccb` FOREIGN KEY (`owner_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
