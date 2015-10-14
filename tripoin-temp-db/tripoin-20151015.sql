-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 14, 2015 at 11:56 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
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
-- Table structure for table `mst_employee`
--

CREATE TABLE IF NOT EXISTS `mst_employee` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mst_menu`
--

CREATE TABLE IF NOT EXISTS `mst_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(150) NOT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_status` smallint(6) DEFAULT '1',
  `menu_remarks` varchar(255) DEFAULT NULL,
  `menu_created_by` varchar(150) DEFAULT 'admin',
  `menu_created_ip` varchar(150) DEFAULT '127.0.0.1',
  `menu_created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `menu_modified_by` varchar(150) DEFAULT NULL,
  `menu_modified_ip` varchar(150) DEFAULT NULL,
  `menu_modified_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`),
  UNIQUE KEY `menu_code` (`menu_code`),
  UNIQUE KEY `menu_code_2` (`menu_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

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
(20, 'calendar', 'Calendar', 1, 'Calendar', 'admin', '127.0.0.1', '2015-07-17 08:58:30', NULL, NULL, NULL),
(21, 'forms', 'Forms', 1, 'Forms', 'admin', '127.0.0.1', '2015-07-21 12:13:15', NULL, NULL, NULL),
(22, 'maintainUser', 'User', 1, 'User', 'admin', '127.0.0.1', '2015-09-27 12:42:33', NULL, NULL, NULL),
(23, 'maintainProduct', 'Product', 1, 'Product', 'admin', '127.0.0.1', '2015-09-30 03:51:36', NULL, NULL, NULL),
(24, 'maintainDashboard', 'Dashboard', 1, 'Dashboard', 'admin', '127.0.0.1', '2015-10-01 05:17:51', NULL, NULL, NULL),
(25, 'group', 'Group', 1, 'Group', 'admin', '127.0.0.1', '2015-10-11 07:49:11', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `mst_menu_role`
--

CREATE TABLE IF NOT EXISTS `mst_menu_role` (
  `menu_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`menu_role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

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
(21, 21, 1),
(22, 1, 2),
(23, 2, 2),
(24, 5, 2),
(25, 9, 2),
(26, 15, 2),
(27, 16, 2),
(28, 20, 2),
(29, 22, 1),
(30, 23, 1),
(31, 24, 1),
(32, 22, 3),
(33, 23, 3),
(34, 24, 3),
(35, 1, 3),
(36, 2, 3),
(37, 5, 3),
(38, 9, 3);

-- --------------------------------------------------------

--
-- Table structure for table `sec_profile`
--

CREATE TABLE IF NOT EXISTS `sec_profile` (
  `profile_id` int(11) NOT NULL,
  `profile_email` varchar(255) DEFAULT NULL,
  `profile_name` varchar(255) DEFAULT NULL,
  `profile_sex` varchar(255) DEFAULT NULL,
  `profile_birthplace` varchar(255) DEFAULT NULL,
  `profile_birthdate` date DEFAULT NULL,
  `profile_address` varchar(255) DEFAULT NULL,
  `profile_telp` varchar(255) DEFAULT NULL,
  `profile_photo` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `profile_phone` varchar(255) DEFAULT NULL,
  `profile_bio` text NOT NULL,
  PRIMARY KEY (`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sec_profile`
--

INSERT INTO `sec_profile` (`profile_id`, `profile_email`, `profile_name`, `profile_sex`, `profile_birthplace`, `profile_birthdate`, `profile_address`, `profile_telp`, `profile_photo`, `user_id`, `profile_phone`, `profile_bio`) VALUES
(1, 'sfandrianah@gmail.com', 'Syahrial fandrianah', '-', '-', '2015-10-12', '-', '-', '-', 3, '0', ''),
(2, 'ridla.fadhilah@gmail.com', 'Ridla Fadhilah', '-', '-', '2015-10-12', '-', '-', '-', 1, '0', ''),
(3, 'bangkit.pratolo@gmail.com', 'Bangkit Pratolo', '-', '-', '2015-10-12', '-', '-', '-', 2, '0', '');

-- --------------------------------------------------------

--
-- Table structure for table `sec_role`
--

CREATE TABLE IF NOT EXISTS `sec_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL,
  `role_status` smallint(6) NOT NULL,
  `role_remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_code` (`role_code`)
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
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_username` varchar(20) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_enabled` smallint(6) NOT NULL,
  `user_expired_date` timestamp NULL DEFAULT NULL,
  `user_non_locked` smallint(6) DEFAULT NULL,
  `user_auth` varchar(255) DEFAULT NULL,
  `user_status` smallint(6) NOT NULL,
  `user_remarks` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_fullname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_username` (`user_username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `sec_user`
--

INSERT INTO `sec_user` (`user_id`, `user_username`, `user_password`, `user_enabled`, `user_expired_date`, `user_non_locked`, `user_auth`, `user_status`, `user_remarks`, `role_id`, `user_email`, `user_fullname`) VALUES
(1, 'ridla', 'wWmc8jbo5M9t1mSTHYHzgFb+ju0=', 1, NULL, NULL, NULL, 1, NULL, 1, NULL, NULL),
(2, 'bangkit', '6pzG9pirdnShIOxMaYgSexDkjiE=', 1, '2016-11-16 17:00:00', NULL, NULL, 1, NULL, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `trx_availability`
--

CREATE TABLE IF NOT EXISTS `trx_availability` (
  `availability_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `availability_name` varchar(100) NOT NULL,
  PRIMARY KEY (`availability_id`)
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
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`)
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
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `product_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `product_stock_count` bigint(20) DEFAULT '0',
  `availability_id` bigint(20) NOT NULL DEFAULT '1',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `trx_product`
--

INSERT INTO `trx_product` (`product_id`, `product_name`, `product_price`, `product_stock_count`, `availability_id`) VALUES
(1, 'Beginners guide to ice hockey', 14.70, 0, 1),
(2, 'Being awesome at feeling down', 27.80, 378, 2),
(3, 'Learning the basics of designing tree houses', 28.40, 0, 3),
(4, 'The secrets of dummies', 11.00, 0, 3),
(5, 'Indonesian Dictionary', 2.40, 3, 1),
(6, 'Indonesian Dictionary', 2.40, 3, 1),
(7, 'Indonesian Dictionary', 2.40, 3, 1),
(8, 'Indonesian Dictionary', 2.40, 3, 1),
(9, 'Indonesian Dictionary', 2.40, 3, 1),
(10, 'Indonesian Dictionary', 2.40, 3, 1),
(11, 'Indonesian Dictionary', 2.40, 3, 1),
(12, 'Indonesian Dictionary', 2.40, 3, 1),
(13, 'Indonesian Dictionary', 2.40, 3, 1);

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
(4, 3),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1);

-- --------------------------------------------------------

--
-- Table structure for table `trx_version_filter`
--

CREATE TABLE IF NOT EXISTS `trx_version_filter` (
  `version_filter_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `version_filter_order` date NOT NULL,
  PRIMARY KEY (`version_filter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
