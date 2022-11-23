-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-11-2022 a las 14:39:56
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_tp_integral_poo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `nro_legajo` int(11) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `cuit` int(11) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `sueldo_basico` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`nro_legajo`, `apellido`, `cuit`, `fecha_nacimiento`, `nombre`, `sueldo_basico`) VALUES
(1, 'Acho', 299292, '3920-03-02', 'Javier', 9999),
(2, 'Palacios', 32883, '2000-01-01', 'Lucas', 1000),
(3, 'Ramos', 2745, '3790-04-09', 'Lucio', 10000),
(4, 'Pablo', 4732, '3890-04-09', 'Pedro', 9999),
(6, 'Toro', 2345, '3890-09-08', 'Yamil', 28382),
(7, 'Messi', 263, '3900-03-09', 'Leo', 39483),
(8, 'Martinez', 2732, '3780-10-09', 'Lautaro', 48585),
(9, 'Mamani', 39383, '3899-04-09', 'Matias', 27373),
(10, 'Ac', 46474, '3910-05-03', 'Marcelo', 38388),
(11, 'Meloso', 2833, '3899-10-05', 'Paco', 33929),
(12, 'Tevez', 3883, '3919-03-09', 'Carlos', 20202),
(13, 'Marino', 383, '3888-04-02', 'Angel', 32834),
(14, 'Robles', 2222, '3799-06-04', 'Maximo', 23233),
(100, 'Acho', 343, '2134-04-03', 'Javier', 35252),
(283, 'Farfan', 388484, '3780-07-04', 'Marisa', 29332),
(384, 'Lampa ', 484, '3920-04-03', 'Lucas ', 26333);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE `proyectos` (
  `codigo` int(11) NOT NULL,
  `fecha_finalizacion` date NOT NULL,
  `fecha_inicio` date NOT NULL,
  `integrantes` varchar(50) NOT NULL,
  `monto` float NOT NULL,
  `nom_proyecto` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`codigo`, `fecha_finalizacion`, `fecha_inicio`, `integrantes`, `monto`, `nom_proyecto`) VALUES
(1, '3901-02-01', '3900-02-01', '1', 10000, 'poyecto1'),
(2, '3903-03-02', '3902-03-02', '2', 2000, 'proyecto2'),
(3, '3918-09-08', '3916-09-08', '3', 3000, 'proyecto3'),
(4, '3921-03-02', '3900-05-03', '4', 9999, 'proyecto4'),
(5, '3950-03-03', '3921-08-09', '', 3884, 'proyecto5');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`nro_legajo`);

--
-- Indices de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
