-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u1build0.15.04.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 23-03-2016 a las 16:48:56
-- Versión del servidor: 5.6.28-0ubuntu0.15.04.1
-- Versión de PHP: 5.6.4-4ubuntu6.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `knyx`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Computers`
--

CREATE TABLE IF NOT EXISTS `Computers` (
`id` int(11) NOT NULL,
  `cpu_vendor` text NOT NULL,
  `cpu_model` text NOT NULL,
  `cpu_frequency` text NOT NULL,
  `cpu_cores` text NOT NULL,
  `ram` text NOT NULL,
  `hdd` text NOT NULL,
  `os_name` text NOT NULL,
  `os_version` text NOT NULL,
  `mac` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Test`
--

CREATE TABLE IF NOT EXISTS `Test` (
`id` int(11) NOT NULL,
  `computer_id` int(11) NOT NULL,
  `test1` text NOT NULL,
  `test2` text NOT NULL,
  `test3` text NOT NULL,
  `test4` text NOT NULL,
  `test5` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Computers`
--
ALTER TABLE `Computers`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `Test`
--
ALTER TABLE `Test`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Computers`
--
ALTER TABLE `Computers`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Test`
--
ALTER TABLE `Test`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
