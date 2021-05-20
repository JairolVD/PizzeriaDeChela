-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-04-2021 a las 05:59:11
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pizzeriadechela`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante`
--

CREATE TABLE `comprobante` (
  `Id` int(11) NOT NULL,
  `PedidoId` int(11) DEFAULT NULL,
  `Fecha` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `DNI` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Contrasena` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Tipo` tinyint(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`DNI`, `Contrasena`, `Tipo`) VALUES
('75493038', '159753', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_perfil`
--

CREATE TABLE `cuenta_perfil` (
  `DNI_C` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Nombres` varchar(40) DEFAULT NULL,
  `Apellido_Paterno` varchar(30) DEFAULT NULL,
  `Apellido_Materno` varchar(30) DEFAULT NULL,
  `Distrito` varchar(30) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Celular` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuenta_perfil`
--

INSERT INTO `cuenta_perfil` (`DNI_C`, `Nombres`, `Apellido_Paterno`, `Apellido_Materno`, `Distrito`, `Direccion`, `Celular`) VALUES
('75493038', 'Fernando', 'Quiñones', 'Flores', 'Comas', 'Av. Los partidos', '123456789');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `Id` int(11) NOT NULL,
  `DNI_C` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `DNI_V` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PizzaId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pizzas`
--

CREATE TABLE `pizzas` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `Descripcion` varchar(150) DEFAULT NULL,
  `ImagenUrl` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `fk_comprobante_pedido_Id` (`PedidoId`);

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`DNI`),
  ADD UNIQUE KEY `DNI` (`DNI`);

--
-- Indices de la tabla `cuenta_perfil`
--
ALTER TABLE `cuenta_perfil`
  ADD PRIMARY KEY (`DNI_C`),
  ADD UNIQUE KEY `DNI_C` (`DNI_C`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `DNI_C` (`DNI_C`),
  ADD UNIQUE KEY `DNI_V` (`DNI_V`);

--
-- Indices de la tabla `pizzas`
--
ALTER TABLE `pizzas`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pizzas`
--
ALTER TABLE `pizzas`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD CONSTRAINT `fk_comprobante_pedidoId` FOREIGN KEY (`PedidoId`) REFERENCES `pedidos` (`Id`),
  ADD CONSTRAINT `fk_comprobante_pedido_Id` FOREIGN KEY (`PedidoId`) REFERENCES `pedidos` (`Id`);

--
-- Filtros para la tabla `cuenta_perfil`
--
ALTER TABLE `cuenta_perfil`
  ADD CONSTRAINT `fk_cuenta_perfil_cuentas_DNI` FOREIGN KEY (`DNI_C`) REFERENCES `cuentas` (`DNI`) ON DELETE CASCADE;

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `fk_pedidos_cuentas_DNI_C` FOREIGN KEY (`DNI_C`) REFERENCES `cuentas` (`DNI`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_pedidos_cuentas_DNI_V` FOREIGN KEY (`DNI_V`) REFERENCES `cuentas` (`DNI`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
