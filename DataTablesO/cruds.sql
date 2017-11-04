-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-11-2017 a las 01:09:59
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cruds`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos`
--

CREATE TABLE `datos` (
  `IdDatos` int(11) NOT NULL,
  `IdUsuario` int(11) NOT NULL,
  `Carrera` varchar(200) NOT NULL,
  `Grupo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `datos`
--

INSERT INTO `datos` (`IdDatos`, `IdUsuario`, `Carrera`, `Grupo`) VALUES
(1, 0, 'Ingenieria en Software', '2717IS'),
(2, 0, 'Ingenieria en Finanzas', '1717IF'),
(3, 0, 'Ingenieria Mecanica Automotriz', '2717IMA'),
(4, 0, 'Ingenieria en Softaware', '2717IS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `info`
--

CREATE TABLE `info` (
  `IdUsuario` int(11) NOT NULL,
  `Edad` varchar(200) NOT NULL,
  `Direccion` varchar(200) NOT NULL,
  `IdInfo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `info`
--

INSERT INTO `info` (`IdUsuario`, `Edad`, `Direccion`, `IdInfo`) VALUES
(0, '20', 'Ecatepec', 1),
(0, '20', 'Tecamac', 2),
(0, '20', 'Tizayuca', 3),
(0, '21', 'Ecatepec', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `IdMateria` int(11) NOT NULL,
  `IdUsuario` int(11) NOT NULL,
  `Materia` varchar(200) NOT NULL,
  `Profesor` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`IdMateria`, `IdUsuario`, `Materia`, `Profesor`) VALUES
(1, 0, 'Base de Datos', 'Rene Dominguez'),
(2, 0, 'Finanzas', 'Maria'),
(3, 0, 'Programacion', 'Alicia'),
(4, 0, 'Base de Datos', 'Rene Dominguez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `IdUsuario` int(11) NOT NULL,
  `Nombre` varchar(200) NOT NULL,
  `Correo` varchar(200) NOT NULL,
  `Telefono` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`IdUsuario`, `Nombre`, `Correo`, `Telefono`) VALUES
(1, 'Natalia', 'vnmm1997@hotmail.com', '5529828763'),
(2, 'Andrea', 'andy48@gmail.com', '5578452101'),
(3, 'Antonio', 'antony@gmail.com', '5521012015'),
(4, 'Rodrigo', 'rodri@gmal.com', '5545201201');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `datos`
--
ALTER TABLE `datos`
  ADD PRIMARY KEY (`IdDatos`),
  ADD KEY `IdUsuario` (`IdUsuario`);

--
-- Indices de la tabla `info`
--
ALTER TABLE `info`
  ADD PRIMARY KEY (`IdInfo`),
  ADD KEY `IdUsuario` (`IdUsuario`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`IdMateria`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`IdUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `datos`
--
ALTER TABLE `datos`
  MODIFY `IdDatos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `info`
--
ALTER TABLE `info`
  MODIFY `IdInfo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `IdMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `IdUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
