-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 13, 2015 at 09:44 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tripoin`
--

-- --------------------------------------------------------

--
-- Table structure for table `mst_menu`
--

CREATE TABLE IF NOT EXISTS `mst_menu` (
`menu_id` bigint(20) NOT NULL,
  `menu_code` varchar(150) NOT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_status` smallint(6) DEFAULT NULL,
  `menu_remarks` varchar(255) DEFAULT NULL,
  `menu_created_by` varchar(150) DEFAULT 'admin',
  `menu_created_ip` varchar(150) DEFAULT '127.0.0.1',
  `menu_created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `menu_modified_by` varchar(150) DEFAULT NULL,
  `menu_modified_ip` varchar(150) DEFAULT NULL,
  `mneu_modified_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `sec_role`
--

CREATE TABLE IF NOT EXISTS `sec_role` (
`role_id` bigint(20) NOT NULL,
  `role_code` varchar(50) NOT NULL,
  `role_status` smallint(6) NOT NULL,
  `role_remarks` varchar(255) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `sec_role`
--

INSERT INTO `sec_role` (`role_id`, `role_code`, `role_status`, `role_remarks`) VALUES
(1, 'ROLE_SUPERADMIN', 1, 'Role Super Admin'),
(2, 'ROLE_ADMIN', 1, 'Role Admin'),
(3, 'ROLE_USER', 1, 'Role User');

-- --------------------------------------------------------

--
-- Table structure for table `sec_user`
--

CREATE TABLE IF NOT EXISTS `sec_user` (
`user_id` bigint(20) NOT NULL,
  `user_username` varchar(20) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_enabled` smallint(6) NOT NULL,
  `user_expired_date` timestamp NULL DEFAULT NULL,
  `user_non_locked` smallint(6) DEFAULT NULL,
  `user_auth` varchar(255) DEFAULT NULL,
  `user_status` smallint(6) NOT NULL,
  `user_remarks` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `sec_user`
--

INSERT INTO `sec_user` (`user_id`, `user_username`, `user_password`, `user_enabled`, `user_expired_date`, `user_non_locked`, `user_auth`, `user_status`, `user_remarks`, `role_id`) VALUES
(1, 'ridla', 'wWmc8jbo5M9t1mSTHYHzgFb+ju0=', 1, NULL, NULL, NULL, 1, NULL, 1),
(2, 'bangkit', '6pzG9pirdnShIOxMaYgSexDkjiE=', 1, NULL, NULL, NULL, 1, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `trx_availability`
--

CREATE TABLE IF NOT EXISTS `trx_availability` (
`availability_id` bigint(20) NOT NULL,
  `availability_name` varchar(100) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `trx_availability`
--

INSERT INTO `trx_availability` (`availability_id`, `availability_name`) VALUES
(1, 'Coming'),
(2, 'Available'),
(3, 'Discontinued');

-- --------------------------------------------------------

--
-- Table structure for table `trx_category`
--

CREATE TABLE IF NOT EXISTS `trx_category` (
`category_id` bigint(20) NOT NULL,
  `category_name` varchar(100) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `trx_category`
--

INSERT INTO `trx_category` (`category_id`, `category_name`) VALUES
(1, 'Children''s books'),
(2, 'Best sellers'),
(3, 'Romance'),
(4, 'Mystery'),
(5, 'Thriller'),
(6, 'Sci-fi'),
(7, 'Non-fiction'),
(8, 'Cookbooks');

-- --------------------------------------------------------

--
-- Table structure for table `trx_product`
--

CREATE TABLE IF NOT EXISTS `trx_product` (
`product_id` bigint(20) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `product_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `product_stock_count` bigint(20) DEFAULT '0',
  `availability_id` bigint(20) NOT NULL DEFAULT '1'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `trx_product`
--

INSERT INTO `trx_product` (`product_id`, `product_name`, `product_price`, `product_stock_count`, `availability_id`) VALUES
(1, 'Beginners guide to ice hockey', '14.70', 0, 1),
(2, 'Being awesome at feeling down', '27.80', 378, 2),
(3, 'Learning the basics of designing tree houses', '28.40', 0, 3),
(4, 'The secrets of dummies', '11.00', 0, 3);

-- --------------------------------------------------------

--
-- Table structure for table `trx_product_category`
--

CREATE TABLE IF NOT EXISTS `trx_product_category` (
  `product_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trx_product_category`
--

INSERT INTO `trx_product_category` (`product_id`, `category_id`) VALUES
(1, 1),
(2, 8),
(3, 4),
(3, 8),
(4, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mst_menu`
--
ALTER TABLE `mst_menu`
 ADD PRIMARY KEY (`menu_id`), ADD UNIQUE KEY `menu_code` (`menu_code`);

--
-- Indexes for table `sec_role`
--
ALTER TABLE `sec_role`
 ADD PRIMARY KEY (`role_id`), ADD UNIQUE KEY `role_code` (`role_code`);

--
-- Indexes for table `sec_user`
--
ALTER TABLE `sec_user`
 ADD PRIMARY KEY (`user_id`), ADD UNIQUE KEY `user_username` (`user_username`);

--
-- Indexes for table `trx_availability`
--
ALTER TABLE `trx_availability`
 ADD PRIMARY KEY (`availability_id`);

--
-- Indexes for table `trx_category`
--
ALTER TABLE `trx_category`
 ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `trx_product`
--
ALTER TABLE `trx_product`
 ADD PRIMARY KEY (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mst_menu`
--
ALTER TABLE `mst_menu`
MODIFY `menu_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sec_role`
--
ALTER TABLE `sec_role`
MODIFY `role_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `sec_user`
--
ALTER TABLE `sec_user`
MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `trx_availability`
--
ALTER TABLE `trx_availability`
MODIFY `availability_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `trx_category`
--
ALTER TABLE `trx_category`
MODIFY `category_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `trx_product`
--
ALTER TABLE `trx_product`
MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
