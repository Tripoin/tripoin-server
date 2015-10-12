/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : tripoin

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-10-12 11:50:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mst_employee
-- ----------------------------
DROP TABLE IF EXISTS `mst_employee`;
CREATE TABLE `mst_employee` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mst_employee
-- ----------------------------

-- ----------------------------
-- Table structure for mst_menu
-- ----------------------------
DROP TABLE IF EXISTS `mst_menu`;
CREATE TABLE `mst_menu` (
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mst_menu
-- ----------------------------
INSERT INTO `mst_menu` VALUES ('1', 'common', 'Common UI Elements', '1', 'Common UI Elements', 'admin', '127.0.0.1', '2015-07-17 15:31:07', null, null, null);
INSERT INTO `mst_menu` VALUES ('2', 'labels', 'Labels', '1', 'Labels', 'admin', '127.0.0.1', '2015-07-17 15:37:11', null, null, null);
INSERT INTO `mst_menu` VALUES ('3', 'buttons-and-links', 'Buttons & Links', '1', 'Buttons & Links', 'admin', '127.0.0.1', '2015-07-17 15:37:38', null, null, null);
INSERT INTO `mst_menu` VALUES ('4', 'textfields', 'Text Fields', '1', 'Text Fields', 'admin', '127.0.0.1', '2015-07-17 15:47:51', null, null, null);
INSERT INTO `mst_menu` VALUES ('5', 'datefields', 'Date Fields', '1', 'Date Fields', 'admin', '127.0.0.1', '2015-07-17 15:48:17', null, null, null);
INSERT INTO `mst_menu` VALUES ('6', 'comboboxes', 'Combo Boxes', '1', 'Combo Boxes', 'admin', '127.0.0.1', '2015-07-17 15:48:17', null, null, null);
INSERT INTO `mst_menu` VALUES ('7', 'selects', 'Selects', '1', 'Selects', 'admin', '127.0.0.1', '2015-07-17 15:49:22', null, null, null);
INSERT INTO `mst_menu` VALUES ('8', 'checkboxes', 'Check Boxes & Option Groups', '1', 'Check Boxes & Option Groups', 'admin', '127.0.0.1', '2015-07-17 15:49:22', null, null, null);
INSERT INTO `mst_menu` VALUES ('9', 'sliders', 'Sliders & Progress Bars', '1', 'Sliders & Progress Bars', 'admin', '127.0.0.1', '2015-07-17 15:49:56', null, null, null);
INSERT INTO `mst_menu` VALUES ('10', 'colorpickers', 'Color Pickers', '1', 'Color Pickers', 'admin', '127.0.0.1', '2015-07-17 15:49:56', null, null, null);
INSERT INTO `mst_menu` VALUES ('11', 'menubars', 'Menu Bars', '1', 'Menu Bars', '', '127.0.0.1', '2015-07-17 15:55:18', null, null, null);
INSERT INTO `mst_menu` VALUES ('12', 'trees', 'Trees', '1', 'Trees', 'admin', '127.0.0.1', '2015-07-17 15:55:18', null, null, null);
INSERT INTO `mst_menu` VALUES ('13', 'tables', 'Tables', '1', 'Tables', 'admin', '127.0.0.1', '2015-07-17 15:55:53', null, null, null);
INSERT INTO `mst_menu` VALUES ('14', 'dragging', 'Drag and Drop', '1', 'Drag and Drop', 'admin', '127.0.0.1', '2015-07-17 15:55:53', null, null, null);
INSERT INTO `mst_menu` VALUES ('15', 'panels', 'Panels', '1', 'Panels', 'admin', '127.0.0.1', '2015-07-17 15:57:22', null, null, null);
INSERT INTO `mst_menu` VALUES ('16', 'splitpanels', 'Split Panels', '1', 'Split Panels', 'admin', '127.0.0.1', '2015-07-17 15:57:22', null, null, null);
INSERT INTO `mst_menu` VALUES ('17', 'tabs', 'Tabs', '1', 'Tabs', 'admin', '127.0.0.1', '2015-07-17 15:58:00', null, null, null);
INSERT INTO `mst_menu` VALUES ('18', 'accordions', 'Accordions', '1', 'Accordions', 'admin', '127.0.0.1', '2015-07-17 15:58:00', null, null, null);
INSERT INTO `mst_menu` VALUES ('19', 'popupviews', 'Popup Views', '1', 'Popup Views', 'admin', '127.0.0.1', '2015-07-17 15:58:30', null, null, null);
INSERT INTO `mst_menu` VALUES ('20', 'calendar', 'Calendar', '1', 'Calendar', 'admin', '127.0.0.1', '2015-07-17 15:58:30', null, null, null);
INSERT INTO `mst_menu` VALUES ('21', 'forms', 'Forms', '1', 'Forms', 'admin', '127.0.0.1', '2015-07-21 19:13:15', null, null, null);
INSERT INTO `mst_menu` VALUES ('22', 'maintainUser', 'User', '1', 'User', 'admin', '127.0.0.1', '2015-09-27 19:42:33', null, null, null);
INSERT INTO `mst_menu` VALUES ('23', 'maintainProduct', 'Product', '1', 'Product', 'admin', '127.0.0.1', '2015-09-30 10:51:36', null, null, null);
INSERT INTO `mst_menu` VALUES ('24', 'maintainDashboard', 'Dashboard', '1', 'Dashboard', 'admin', '127.0.0.1', '2015-10-01 12:17:51', null, null, null);
INSERT INTO `mst_menu` VALUES ('25', 'group', 'Group', '1', 'Group', 'admin', '127.0.0.1', '2015-10-11 14:49:11', null, null, null);

-- ----------------------------
-- Table structure for mst_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `mst_menu_role`;
CREATE TABLE `mst_menu_role` (
  `menu_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`menu_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mst_menu_role
-- ----------------------------
INSERT INTO `mst_menu_role` VALUES ('1', '1', '1');
INSERT INTO `mst_menu_role` VALUES ('2', '2', '1');
INSERT INTO `mst_menu_role` VALUES ('3', '3', '1');
INSERT INTO `mst_menu_role` VALUES ('4', '4', '1');
INSERT INTO `mst_menu_role` VALUES ('5', '5', '1');
INSERT INTO `mst_menu_role` VALUES ('6', '6', '1');
INSERT INTO `mst_menu_role` VALUES ('7', '7', '1');
INSERT INTO `mst_menu_role` VALUES ('8', '8', '1');
INSERT INTO `mst_menu_role` VALUES ('9', '9', '1');
INSERT INTO `mst_menu_role` VALUES ('10', '10', '1');
INSERT INTO `mst_menu_role` VALUES ('11', '11', '1');
INSERT INTO `mst_menu_role` VALUES ('12', '12', '1');
INSERT INTO `mst_menu_role` VALUES ('13', '13', '1');
INSERT INTO `mst_menu_role` VALUES ('14', '14', '1');
INSERT INTO `mst_menu_role` VALUES ('15', '15', '1');
INSERT INTO `mst_menu_role` VALUES ('16', '16', '1');
INSERT INTO `mst_menu_role` VALUES ('17', '17', '1');
INSERT INTO `mst_menu_role` VALUES ('18', '18', '1');
INSERT INTO `mst_menu_role` VALUES ('19', '19', '1');
INSERT INTO `mst_menu_role` VALUES ('20', '20', '1');
INSERT INTO `mst_menu_role` VALUES ('21', '21', '1');
INSERT INTO `mst_menu_role` VALUES ('22', '1', '2');
INSERT INTO `mst_menu_role` VALUES ('23', '2', '2');
INSERT INTO `mst_menu_role` VALUES ('24', '5', '2');
INSERT INTO `mst_menu_role` VALUES ('25', '9', '2');
INSERT INTO `mst_menu_role` VALUES ('26', '15', '2');
INSERT INTO `mst_menu_role` VALUES ('27', '16', '2');
INSERT INTO `mst_menu_role` VALUES ('28', '20', '2');
INSERT INTO `mst_menu_role` VALUES ('29', '22', '1');
INSERT INTO `mst_menu_role` VALUES ('30', '23', '1');
INSERT INTO `mst_menu_role` VALUES ('31', '24', '1');
INSERT INTO `mst_menu_role` VALUES ('32', '22', '3');
INSERT INTO `mst_menu_role` VALUES ('33', '23', '3');
INSERT INTO `mst_menu_role` VALUES ('34', '24', '3');
INSERT INTO `mst_menu_role` VALUES ('35', '1', '3');
INSERT INTO `mst_menu_role` VALUES ('36', '2', '3');
INSERT INTO `mst_menu_role` VALUES ('37', '5', '3');
INSERT INTO `mst_menu_role` VALUES ('38', '9', '3');

-- ----------------------------
-- Table structure for sec_profile
-- ----------------------------
DROP TABLE IF EXISTS `sec_profile`;
CREATE TABLE `sec_profile` (
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
  PRIMARY KEY (`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_profile
-- ----------------------------
INSERT INTO `sec_profile` VALUES ('1', 'sfandrianah@gmail.com', 'Syahrial fandrianah', '-', '-', '2015-10-12', '-', '-', '-', '3', '0');
INSERT INTO `sec_profile` VALUES ('2', 'ridla.fadhilah@gmail.com', 'Ridla Fadhilah', '-', '-', '2015-10-12', '-', '-', '-', '1', '0');
INSERT INTO `sec_profile` VALUES ('3', 'bangkit.pratolo@gmail.com', 'Bangkit Pratolo', '-', '-', '2015-10-12', '-', '-', '-', '2', '0');

-- ----------------------------
-- Table structure for sec_role
-- ----------------------------
DROP TABLE IF EXISTS `sec_role`;
CREATE TABLE `sec_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL,
  `role_status` smallint(6) NOT NULL,
  `role_remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_code` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_role
-- ----------------------------
INSERT INTO `sec_role` VALUES ('1', 'ROLE_SUPERADMIN', '1', 'Role Super Admin');
INSERT INTO `sec_role` VALUES ('2', 'ROLE_ADMIN', '1', 'Role Admin');
INSERT INTO `sec_role` VALUES ('3', 'ROLE_USER', '1', 'Role User');

-- ----------------------------
-- Table structure for sec_user
-- ----------------------------
DROP TABLE IF EXISTS `sec_user`;
CREATE TABLE `sec_user` (
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_user
-- ----------------------------
INSERT INTO `sec_user` VALUES ('1', 'ridla', 'wWmc8jbo5M9t1mSTHYHzgFb+ju0=', '1', null, null, null, '1', null, '1', 'ridla.fadhilah@gmail.com', 'Ridla fadhilah');
INSERT INTO `sec_user` VALUES ('2', 'bangkit', '6pzG9pirdnShIOxMaYgSexDkjiE=', '1', null, null, null, '1', null, '2', null, null);
INSERT INTO `sec_user` VALUES ('3', 'admin', 'wWmc8jbo5M9t1mSTHYHzgFb+ju0=', '1', '2015-11-30 04:02:40', null, '', '1', '', '3', 'sfandrianah2@gmail.com', 'Syahrial Fandrianah');

-- ----------------------------
-- Table structure for trx_availability
-- ----------------------------
DROP TABLE IF EXISTS `trx_availability`;
CREATE TABLE `trx_availability` (
  `availability_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `availability_name` varchar(100) NOT NULL,
  PRIMARY KEY (`availability_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of trx_availability
-- ----------------------------
INSERT INTO `trx_availability` VALUES ('1', 'Coming');
INSERT INTO `trx_availability` VALUES ('2', 'Available');
INSERT INTO `trx_availability` VALUES ('3', 'Discontinued');

-- ----------------------------
-- Table structure for trx_category
-- ----------------------------
DROP TABLE IF EXISTS `trx_category`;
CREATE TABLE `trx_category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of trx_category
-- ----------------------------
INSERT INTO `trx_category` VALUES ('1', 'Children\'s books');
INSERT INTO `trx_category` VALUES ('2', 'Best sellers');
INSERT INTO `trx_category` VALUES ('3', 'Romance');
INSERT INTO `trx_category` VALUES ('4', 'Mystery');
INSERT INTO `trx_category` VALUES ('5', 'Thriller');
INSERT INTO `trx_category` VALUES ('6', 'Sci-fi');
INSERT INTO `trx_category` VALUES ('7', 'Non-fiction');
INSERT INTO `trx_category` VALUES ('8', 'Cookbooks');

-- ----------------------------
-- Table structure for trx_product
-- ----------------------------
DROP TABLE IF EXISTS `trx_product`;
CREATE TABLE `trx_product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `product_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `product_stock_count` bigint(20) DEFAULT '0',
  `availability_id` bigint(20) NOT NULL DEFAULT '1',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of trx_product
-- ----------------------------
INSERT INTO `trx_product` VALUES ('1', 'Beginners guide to ice hockey', '14.70', '0', '1');
INSERT INTO `trx_product` VALUES ('2', 'Being awesome at feeling down', '27.80', '378', '2');
INSERT INTO `trx_product` VALUES ('3', 'Learning the basics of designing tree houses', '28.40', '0', '3');
INSERT INTO `trx_product` VALUES ('4', 'The secrets of dummies', '11.00', '0', '3');
INSERT INTO `trx_product` VALUES ('5', 'Indonesian Dictionary', '2.40', '3', '1');
INSERT INTO `trx_product` VALUES ('6', 'Indonesian Dictionary', '2.40', '3', '1');
INSERT INTO `trx_product` VALUES ('7', 'Indonesian Dictionary', '2.40', '3', '1');
INSERT INTO `trx_product` VALUES ('8', 'Indonesian Dictionary', '2.40', '3', '1');
INSERT INTO `trx_product` VALUES ('9', 'Indonesian Dictionary', '2.40', '3', '1');
INSERT INTO `trx_product` VALUES ('10', 'Indonesian Dictionary', '2.40', '3', '1');
INSERT INTO `trx_product` VALUES ('11', 'Indonesian Dictionary', '2.40', '3', '1');
INSERT INTO `trx_product` VALUES ('12', 'Indonesian Dictionary', '2.40', '3', '1');
INSERT INTO `trx_product` VALUES ('13', 'Indonesian Dictionary', '2.40', '3', '1');

-- ----------------------------
-- Table structure for trx_product_category
-- ----------------------------
DROP TABLE IF EXISTS `trx_product_category`;
CREATE TABLE `trx_product_category` (
  `product_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of trx_product_category
-- ----------------------------
INSERT INTO `trx_product_category` VALUES ('1', '1');
INSERT INTO `trx_product_category` VALUES ('2', '8');
INSERT INTO `trx_product_category` VALUES ('3', '4');
INSERT INTO `trx_product_category` VALUES ('3', '8');
INSERT INTO `trx_product_category` VALUES ('4', '3');
INSERT INTO `trx_product_category` VALUES ('5', '1');
INSERT INTO `trx_product_category` VALUES ('6', '1');
INSERT INTO `trx_product_category` VALUES ('7', '1');
INSERT INTO `trx_product_category` VALUES ('8', '1');
INSERT INTO `trx_product_category` VALUES ('9', '1');
INSERT INTO `trx_product_category` VALUES ('10', '1');
INSERT INTO `trx_product_category` VALUES ('11', '1');
INSERT INTO `trx_product_category` VALUES ('12', '1');
INSERT INTO `trx_product_category` VALUES ('13', '1');
