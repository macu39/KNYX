-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u1build0.15.04.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 13-06-2016 a las 02:44:36
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
  `cpu_frequency` int(11) NOT NULL,
  `cpu_cores` int(11) NOT NULL,
  `ram` int(11) NOT NULL,
  `hdd` float NOT NULL,
  `os_name` text NOT NULL,
  `os_version` text NOT NULL,
  `mac` varchar(17) NOT NULL,
  `owner` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Computers`
--

INSERT INTO `Computers` (`id`, `cpu_vendor`, `cpu_model`, `cpu_frequency`, `cpu_cores`, `ram`, `hdd`, `os_name`, `os_version`, `mac`, `owner`) VALUES
(4, 'Intel', 'Intel Core(TM) i7-2820QM CPU @ 2.30GHz', 2295, 8, 8086, 201.85, 'Windows 10', 'Windows 10 10.0', '0A-00-27-00-00-00', ''),
(5, 'Intel', 'Intel Core(TM) i7-6500U CPU @ 2.50GHz', 2592, 4, 8091, 255.25, 'Windows 10', 'Windows 10 10.0', '0A-00-27-00-00-03', ''),
(6, 'Intel', 'Intel Core(TM) i7-6700HQ CPU @ 2.60GHz', 2592, 8, 16238, 497.91, 'Windows 10', 'Windows 10 10.0', '0A-00-27-00-00-0A', 'admin'),
(9, 'Intel', 'Intel MacBookPro11,1', 2800, 4, 8192, 249.77, 'Mac OS X', 'Mac OS X 10.11.4', '6C-40-08-A2-75-AE', ''),
(14, 'AMD', 'AMD FX(tm)-8350 Eight-Core Processor', 3991, 8, 12242, 119.93, 'Windows 7', 'Windows 7 6.1', 'D0-50-99-22-6F-21', ''),
(16, 'Intel', 'Intel Core(TM) i7-2600K CPU @ 3.40GHz', 3400, 8, 8073, 511.08, 'Windows 8.1', 'Windows 8.1 6.3', 'BC-5F-F4-8E-BB-8F', ''),
(19, 'Intel', 'Intel Xeon', 2933, 6, 8191, 68.61, 'Windows 7', 'Windows 7 6.1', '00-0C-29-AF-5A-D5', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Scores`
--

CREATE TABLE IF NOT EXISTS `Scores` (
`id` int(11) NOT NULL,
  `mac` text NOT NULL,
  `score` double NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Scores`
--

INSERT INTO `Scores` (`id`, `mac`, `score`, `date`) VALUES
(4, '0A-00-27-00-00-00', 7.6574, '0000-00-00'),
(5, '0A-00-27-00-00-03', 8.0658, '0000-00-00'),
(6, '0A-00-27-00-00-0A', 8.173201, '0000-00-00'),
(7, '0A-00-27-00-00-0A', 8.286201, '0000-00-00'),
(8, '0A-00-27-00-00-0A', 8.2066, '0000-00-00'),
(9, '6C-40-08-A2-75-AE', 24.26389, '0000-00-00'),
(15, '0A-00-27-00-00-0A', 8.2904, '0000-00-00'),
(16, 'D0-50-99-22-6F-21', 8.1064, '0000-00-00'),
(17, 'D0-50-99-22-6F-21', 8.033199, '0000-00-00'),
(18, 'BC-5F-F4-8E-BB-8F', 7.0964003, '0000-00-00'),
(19, 'D0-50-99-22-6F-21', 8.0178, '0000-00-00'),
(20, 'BC-5F-F4-8E-BB-8F', 7.0776, '0000-00-00'),
(21, '00-0C-29-AF-5A-D5', 7.5861998, '0000-00-00'),
(22, 'BC-5F-F4-8E-BB-8F', 7.2125998, '2016-06-13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Users`
--

CREATE TABLE IF NOT EXISTS `Users` (
`id` int(11) NOT NULL,
  `name` text NOT NULL,
  `password` text NOT NULL,
  `rights` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Users`
--

INSERT INTO `Users` (`id`, `name`, `password`, `rights`) VALUES
(1, 'admin', '12345678', 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Computers`
--
ALTER TABLE `Computers`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `mac` (`mac`);

--
-- Indices de la tabla `Scores`
--
ALTER TABLE `Scores`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `Users`
--
ALTER TABLE `Users`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Computers`
--
ALTER TABLE `Computers`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT de la tabla `Scores`
--
ALTER TABLE `Scores`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT de la tabla `Users`
--
ALTER TABLE `Users`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
