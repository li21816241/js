-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017-09-18 15:28:51
-- 服务器版本： 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- 表的结构 `app_infos`
--

CREATE TABLE `app_infos` (
  `id` varchar(20) NOT NULL,
  `termid` varchar(20) NOT NULL,
  `masterkey` varchar(32) NOT NULL,
  `pinkey` varchar(32) NOT NULL,
  `mackey` varchar(32) NOT NULL,
  `whitecardcount` int(3) NOT NULL,
  `version` varchar(20) NOT NULL,
  `serviceaddr` varchar(20) NOT NULL,
  `monitoraddr` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `device_infos`
--

CREATE TABLE `device_infos` (
  `id` varchar(20) NOT NULL,
  `company` varchar(100) NOT NULL,
  `model` varchar(20) NOT NULL,
  `devices` int(11) NOT NULL,
  `mechanism` varchar(30) NOT NULL,
  `descript` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `term_infos`
--

CREATE TABLE `term_infos` (
  `id` varchar(20) NOT NULL,
  `ip` varchar(16) NOT NULL,
  `devid` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `descript` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `transrecords`
--

CREATE TABLE `transrecords` (
  `id` int(11) NOT NULL,
  `appid` varchar(20) NOT NULL,
  `requistid` int(11) NOT NULL,
  `responseid` int(11) NOT NULL,
  `transtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `transtype` int(11) NOT NULL,
  `cardno` int(11) NOT NULL,
  `psasn` varchar(20) NOT NULL,
  `atc` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `transrecroeds`
--

CREATE TABLE `transrecroeds` (
  `id` int(11) NOT NULL,
  `appid` varchar(20) NOT NULL,
  `requistid` int(11) NOT NULL,
  `responseid` int(11) NOT NULL,
  `transtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `transtype` int(11) NOT NULL,
  `cardno` int(11) NOT NULL,
  `psasn` varchar(20) NOT NULL,
  `atc` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `app_infos`
--
ALTER TABLE `app_infos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `device_infos`
--
ALTER TABLE `device_infos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `term_infos`
--
ALTER TABLE `term_infos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transrecords`
--
ALTER TABLE `transrecords`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transrecroeds`
--
ALTER TABLE `transrecroeds`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
