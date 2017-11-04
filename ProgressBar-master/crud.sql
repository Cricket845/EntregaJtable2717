-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2017 a las 23:11:41
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `crud`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agencia`
--

CREATE TABLE `agencia` (
  `IdAgencia` int(11) NOT NULL,
  `IdUsuario` int(11) NOT NULL,
  `Nombre` varchar(200) NOT NULL,
  `Estado` varchar(200) NOT NULL,
  `Direccion` varchar(200) NOT NULL,
  `Telefono` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `agencia`
--

INSERT INTO `agencia` (`IdAgencia`, `IdUsuario`, `Nombre`, `Estado`, `Direccion`, `Telefono`) VALUES
(1, 8, 'Chocolate.inc', 'Ciudad de Tabasco', 'Gustavo Baz', '01800553556');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodico`
--

CREATE TABLE `periodico` (
  `IdPeriodico` int(11) NOT NULL,
  `IdUsuario` int(11) NOT NULL,
  `Nombre` varchar(200) NOT NULL,
  `Estado` varchar(200) NOT NULL,
  `Tipo` varchar(200) NOT NULL,
  `Precio` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `periodico`
--

INSERT INTO `periodico` (`IdPeriodico`, `IdUsuario`, `Nombre`, `Estado`, `Tipo`, `Precio`) VALUES
(2, 2, 'La Paz', 'Puebla', 'Estandar', '105.00'),
(4, 2, 'Tabasco Hoy', 'Cd Tabasco', 'tabloide', '113.59'),
(5, 2, 'Sol de Chilpancingo', 'Chilpancingo', 'Tabloide', '150.00'),
(7, 6, 'pop', 'po', 'poo', 'poooo'),
(9, 4, 'pop', 'pop', 'pop', 'pop'),
(10, 2, 'El sol de Acapulco', 'Acapulco Grro', 'tabloide', '59.69'),
(11, 8, 'El diario de las HUstecas', '65.00', 'Tabloide', '65.00'),
(12, 2, 'El Mañana de Valles', 'San Luis Potosi', 'Estandar', '159.00'),
(13, 9, 'Prensa de Reynosa', 'Reynosa', 'Estandar', '9'),
(14, 2, 'El metro', 'mexico', 'tabloide', '129.90'),
(15, 10, 'Metro', 'Quintana Roo', 'estandar', '5'),
(16, 12, 'El  Peninsular', 'Baja California Sur', 'Estandar', '94.35'),
(17, 8, 'Esto de Veracruz', 'Jalapa Veracruz', 'Tabloide', '35.22'),
(18, 12, 'El Sudcalifornianno', 'Baja California Sur', 'Estandar', '39.13'),
(19, 12, 'Gentes de Balsas', 'Michoacan', 'Estandar', '39.13'),
(20, 8, 'tr', 'tytr', 'ytyt', 'ytyt');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `IdUsuario` int(11) NOT NULL,
  `Usuario` varchar(200) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `Nombre` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`IdUsuario`, `Usuario`, `Password`, `Nombre`) VALUES
(2, 'Carlos852', '123', 'Carlos'),
(4, 'R', 'Rtt', 'R'),
(6, 'ja', '23', 'pepe'),
(7, 'yote123', '789', 'Jose'),
(8, '34por', '456', 'Antonio Sandoval'),
(9, 'ew43', '4568', 'Daniel'),
(10, 'Cobol', '452', 'Jesus'),
(11, '987Rox', '963', 'Rocio'),
(12, 'Poquet', '2586L', 'Cristian'),
(13, 'rock', '9678', 'Esteban');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `agencia`
--
ALTER TABLE `agencia`
  ADD PRIMARY KEY (`IdAgencia`),
  ADD KEY `IdUsuario` (`IdUsuario`);

--
-- Indices de la tabla `periodico`
--
ALTER TABLE `periodico`
  ADD PRIMARY KEY (`IdPeriodico`),
  ADD KEY `IdAuto` (`IdUsuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`IdUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `agencia`
--
ALTER TABLE `agencia`
  MODIFY `IdAgencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `periodico`
--
ALTER TABLE `periodico`
  MODIFY `IdPeriodico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `IdUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `agencia`
--
ALTER TABLE `agencia`
  ADD CONSTRAINT `agencia_ibfk_1` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`IdUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `periodico`
--
ALTER TABLE `periodico`
  ADD CONSTRAINT `periodico_ibfk_1` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`IdUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
