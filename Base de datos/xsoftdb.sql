-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2015 a las 05:48:06
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `xsoftdb`
--
CREATE DATABASE IF NOT EXISTS `xsoftdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `xsoftdb`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `nombres` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `apellidos` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `numeroId` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `telefonoFijo` varchar(15) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `telefonoMovil` varchar(15) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `email` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `direccion` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `usuarioCrea` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `fechaCreacion` date NOT NULL,
  PRIMARY KEY (`numeroId`),
  KEY `cliente_ibfk_2` (`usuarioCrea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`nombres`, `apellidos`, `numeroId`, `telefonoFijo`, `telefonoMovil`, `email`, `direccion`, `usuarioCrea`, `fechaCreacion`) VALUES
('Pablo Andres', 'Diaz ', '120365485', '125478', '3210214587', 'pandigo@gmail.com', 'calle 89#97-94', '1038481420', '2015-05-30'),
('mario', 'Rojas', '410', '123521459', '47856954', 'Mario@gmail.com', 'calle94 /45', '1038481420', '2015-05-30'),
('Juan ', 'Restrepo', '47885', '42566', '3142563214', 'pandres@gmail.com', 'Sur de Medellin', '1038481420', '2015-05-30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE IF NOT EXISTS `servicios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `descripcion` varchar(300) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`id`, `nombre`, `descripcion`, `valor`) VALUES
(1, 'Desarrollo de sitios web', 'Sitio web estatico para representacion de informacion que requiera el cliente.\r\nContendra 5 secciones: Inicio, Nosotros, Servicios,Clientes,Portafolio,Contacto.', 1200000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `serviciosventa`
--

CREATE TABLE IF NOT EXISTS `serviciosventa` (
  `idservicioVenta` int(11) NOT NULL AUTO_INCREMENT,
  `idservicio` int(11) NOT NULL,
  `idventa` int(11) NOT NULL,
  `totalventa` double NOT NULL,
  `fechaCaducidad` date NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fechaVenta` date NOT NULL,
  PRIMARY KEY (`idservicioVenta`,`idservicio`,`idventa`),
  KEY `idservicio` (`idservicio`),
  KEY `idventa` (`idventa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `nombres` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `apellidos` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `privilegio` int(11) NOT NULL,
  `username` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `numeroId` varchar(20) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `email` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`numeroId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nombres`, `apellidos`, `privilegio`, `username`, `password`, `numeroId`, `email`) VALUES
('Joaquin ', 'Hernández Cárdenas', 1, 'jodaheca', '12345', '1038481420', 'jdavidhc94@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE IF NOT EXISTS `venta` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `idUsuario` varchar(30) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `idCliente` (`idCliente`,`idUsuario`),
  KEY `idUsuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`usuarioCrea`) REFERENCES `usuario` (`numeroId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `serviciosventa`
--
ALTER TABLE `serviciosventa`
  ADD CONSTRAINT `serviciosventa_ibfk_1` FOREIGN KEY (`idservicio`) REFERENCES `servicios` (`id`),
  ADD CONSTRAINT `serviciosventa_ibfk_2` FOREIGN KEY (`idventa`) REFERENCES `venta` (`idVenta`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`numeroId`),
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`numeroId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
