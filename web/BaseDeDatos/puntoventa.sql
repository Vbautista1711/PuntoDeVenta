-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-08-2022 a las 19:17:41
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `puntoventa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `Codigo` int(11) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`Codigo`, `Nombre`) VALUES
(6, 'Herramientas electricas'),
(7, 'Herramientas manuales'),
(8, 'Material elÃ©ctrico'),
(9, 'Iluminacion'),
(10, 'TuberÃ­as PVC'),
(11, 'Pinturas'),
(12, 'Abrasivos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `Codigo` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `ApellidoPaterno` varchar(20) NOT NULL,
  `ApellidoMaterno` varchar(20) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Telefono` int(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`Codigo`, `Nombre`, `ApellidoPaterno`, `ApellidoMaterno`, `Direccion`, `Telefono`) VALUES
(1, 'Susano', 'Moras', 'Gatica', 'Chilapa de Alvarez Guerrero', 561159532),
(2, 'Victor', 'Bautista', 'Bautista', 'Chilapa de Ãlvarez Guerrero', 561175451),
(9, 'Jorge', 'Morelos', 'Bautista', 'Chilapa de ÃÂlvarez Guerrero', 756127303),
(11, 'Luis', 'Bautista', 'Bautista', 'Chilapa de ÃÂÃÂlvarez Guerrero', 561175154);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `Codigo` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Precio` int(11) NOT NULL,
  `Descripcion` varchar(20) NOT NULL,
  `Cantidad` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`Codigo`, `Nombre`, `Precio`, `Descripcion`, `Cantidad`) VALUES
(11, 'Pala', 100, 'Pala marca truper', 10),
(13, 'Brocas', 50, 'Hechas para acero', 10),
(14, 'Brocas', 50, 'Hechas para madera', 10),
(15, 'Brocas', 50, 'Brocas para tuvo pvc', 30),
(16, 'Pijas', 2, 'Para concreto de 1/2', 100),
(17, 'Pijas', 2, 'Para concreto de 1/4', 100),
(18, 'Pijas', 2, 'Para concreto de 1/8', 100),
(19, 'Pijas', 2, 'Para concreto de 1\"', 100),
(20, 'Pijas', 2, 'Para concreto de 3/8', 100),
(21, 'Pijas', 2, 'Para madera de 1/2\"', 100),
(22, 'Pijas', 2, 'Para madera de 1/4\"', 100),
(23, 'Pijas', 2, 'Para madera de 1/8\"', 100),
(24, 'Pijas', 2, 'Para madera de 1\"', 100),
(25, 'Pijas', 2, 'Para madera de 3/8\"', 100),
(26, 'Brocas', 50, 'Hechas para madera', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Codigo` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `ApellidoPaterno` varchar(50) NOT NULL,
  `ApellidoMaterno` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` tinytext NOT NULL,
  `Usuario` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Codigo`, `Nombre`, `ApellidoPaterno`, `ApellidoMaterno`, `Email`, `Password`, `Usuario`) VALUES
(1, 'Victor', 'Bautista', 'Bautista', 'vbautista1711@gmail.com', 'bvfv', 'Victor');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
