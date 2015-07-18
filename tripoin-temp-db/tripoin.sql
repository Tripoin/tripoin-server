-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 18, 2015 at 06:20 PM
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
  `menu_status` smallint(6) DEFAULT '1',
  `menu_remarks` varchar(255) DEFAULT NULL,
  `menu_created_by` varchar(150) DEFAULT 'admin',
  `menu_created_ip` varchar(150) DEFAULT '127.0.0.1',
  `menu_created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `menu_modified_by` varchar(150) DEFAULT NULL,
  `menu_modified_ip` varchar(150) DEFAULT NULL,
  `menu_modified_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `mst_menu`
--

INSERT INTO `mst_menu` (`menu_id`, `menu_code`, `menu_name`, `menu_status`, `menu_remarks`, `menu_created_by`, `menu_created_ip`, `menu_created_time`, `menu_modified_by`, `menu_modified_ip`, `menu_modified_time`) VALUES
(1, 'common', 'Common UI Elements', 1, 'Common UI Elements', 'admin', '127.0.0.1', '2015-07-17 08:31:07', NULL, NULL, NULL),
(2, 'labels', 'Labels', 1, 'Labels', 'admin', '127.0.0.1', '2015-07-17 08:37:11', NULL, NULL, NULL),
(3, 'buttons-and-links', 'Buttons & Links', 1, 'Buttons & Links', 'admin', '127.0.0.1', '2015-07-17 08:37:38', NULL, NULL, NULL),
(4, 'textfields', 'Text Fields', 1, 'Text Fields', 'admin', '127.0.0.1', '2015-07-17 08:47:51', NULL, NULL, NULL),
(5, 'datefields', 'Date Fields', 1, 'Date Fields', 'admin', '127.0.0.1', '2015-07-17 08:48:17', NULL, NULL, NULL),
(6, 'comboboxes', 'Combo Boxes', 1, 'Combo Boxes', 'admin', '127.0.0.1', '2015-07-17 08:48:17', NULL, NULL, NULL),
(7, 'selects', 'Selects', 1, 'Selects', 'admin', '127.0.0.1', '2015-07-17 08:49:22', NULL, NULL, NULL),
(8, 'checkboxes', 'Check Boxes & Option Groups', 1, 'Check Boxes & Option Groups', 'admin', '127.0.0.1', '2015-07-17 08:49:22', NULL, NULL, NULL),
(9, 'sliders', 'Sliders & Progress Bars', 1, 'Sliders & Progress Bars', 'admin', '127.0.0.1', '2015-07-17 08:49:56', NULL, NULL, NULL),
(10, 'colorpickers', 'Color Pickers', 1, 'Color Pickers', 'admin', '127.0.0.1', '2015-07-17 08:49:56', NULL, NULL, NULL),
(11, 'menubars', 'Menu Bars', 1, 'Menu Bars', '', '127.0.0.1', '2015-07-17 08:55:18', NULL, NULL, NULL),
(12, 'trees', 'Trees', 1, 'Trees', 'admin', '127.0.0.1', '2015-07-17 08:55:18', NULL, NULL, NULL),
(13, 'tables', 'Tables', 1, 'Tables', 'admin', '127.0.0.1', '2015-07-17 08:55:53', NULL, NULL, NULL),
(14, 'dragging', 'Drag and Drop', 1, 'Drag and Drop', 'admin', '127.0.0.1', '2015-07-17 08:55:53', NULL, NULL, NULL),
(15, 'panels', 'Panels', 1, 'Panels', 'admin', '127.0.0.1', '2015-07-17 08:57:22', NULL, NULL, NULL),
(16, 'splitpanels', 'Split Panels', 1, 'Split Panels', 'admin', '127.0.0.1', '2015-07-17 08:57:22', NULL, NULL, NULL),
(17, 'tabs', 'Tabs', 1, 'Tabs', 'admin', '127.0.0.1', '2015-07-17 08:58:00', NULL, NULL, NULL),
(18, 'accordions', 'Accordions', 1, 'Accordions', 'admin', '127.0.0.1', '2015-07-17 08:58:00', NULL, NULL, NULL),
(19, 'popupviews', 'Popup Views', 1, 'Popup Views', 'admin', '127.0.0.1', '2015-07-17 08:58:30', NULL, NULL, NULL),
(20, 'forms', 'Forms', 1, 'Forms', 'admin', '127.0.0.1', '2015-07-17 08:58:30', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `mst_menu_role`
--

CREATE TABLE IF NOT EXISTS `mst_menu_role` (
`menu_role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Dumping data for table `mst_menu_role`
--

INSERT INTO `mst_menu_role` (`menu_role_id`, `menu_id`, `role_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1),
(5, 5, 1),
(6, 6, 1),
(7, 7, 1),
(8, 8, 1),
(9, 9, 1),
(10, 10, 1),
(11, 11, 1),
(12, 12, 1),
(13, 13, 1),
(14, 14, 1),
(15, 15, 1),
(16, 16, 1),
(17, 17, 1),
(18, 18, 1),
(19, 19, 1),
(20, 20, 1),
(21, 1, 2),
(22, 2, 2),
(23, 5, 2),
(24, 9, 2),
(25, 15, 2),
(26, 16, 2),
(27, 20, 2);

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
(2, 'bangkit', '6pzG9pirdnShIOxMaYgSexDkjiE=', 1, NULL, NULL, NULL, 1, NULL, 2);

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
 ADD PRIMARY KEY (`menu_id`), ADD UNIQUE KEY `menu_code` (`menu_code`), ADD UNIQUE KEY `menu_code_2` (`menu_code`);

--
-- Indexes for table `mst_menu_role`
--
ALTER TABLE `mst_menu_role`
 ADD PRIMARY KEY (`menu_role_id`);

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
MODIFY `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `mst_menu_role`
--
ALTER TABLE `mst_menu_role`
MODIFY `menu_role_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=28;
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
