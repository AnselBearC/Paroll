/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : payroll

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2020-06-19 17:04:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for py_order_form
-- ----------------------------
DROP TABLE IF EXISTS `py_order_form`;
CREATE TABLE `py_order_form` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(20) DEFAULT NULL,
  `style_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '款号',
  `style_description` varchar(30) DEFAULT NULL COMMENT '款式名称',
  `cutting_number` int(10) DEFAULT NULL COMMENT '裁单数量',
  `actual_number` int(10) DEFAULT NULL COMMENT '实际数量',
  `is_complete` int(1) DEFAULT NULL COMMENT '是否完成?1：完成0：未完成',
  `start_date` date DEFAULT NULL,
  `ending_date` date DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of py_order_form
-- ----------------------------
INSERT INTO `py_order_form` VALUES ('3', '2223', '3333', '444', '44', '44', '0', '2020-06-11', '2020-06-12', '', null, '2020-06-19', null);
INSERT INTO `py_order_form` VALUES ('4', '43434', '4343', '4', '4', '4', '0', '2020-06-01', '2020-07-01', '4', null, '2020-06-19', null);
INSERT INTO `py_order_form` VALUES ('5', '海石服装有限公司', '53453543', '453543', '44', '44', '0', '2020-06-09', '2020-06-26', '', null, '2020-06-19', null);

-- ----------------------------
-- Table structure for py_order_process_relation
-- ----------------------------
DROP TABLE IF EXISTS `py_order_process_relation`;
CREATE TABLE `py_order_process_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `process_id` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL COMMENT '工序单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of py_order_process_relation
-- ----------------------------

-- ----------------------------
-- Table structure for py_payroll
-- ----------------------------
DROP TABLE IF EXISTS `py_payroll`;
CREATE TABLE `py_payroll` (
  `id` int(11) NOT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `staff_name` varchar(20) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of py_payroll
-- ----------------------------

-- ----------------------------
-- Table structure for py_payroll_detail
-- ----------------------------
DROP TABLE IF EXISTS `py_payroll_detail`;
CREATE TABLE `py_payroll_detail` (
  `id` int(11) NOT NULL,
  `payroll_id` int(11) NOT NULL,
  `order_name` varchar(20) DEFAULT NULL,
  `process_name` varchar(20) DEFAULT NULL,
  `amount` varchar(10) DEFAULT NULL,
  `unit` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `total_prices` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of py_payroll_detail
-- ----------------------------

-- ----------------------------
-- Table structure for py_process
-- ----------------------------
DROP TABLE IF EXISTS `py_process`;
CREATE TABLE `py_process` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process_name` varchar(30) DEFAULT NULL COMMENT '工序名称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of py_process
-- ----------------------------
INSERT INTO `py_process` VALUES ('1', '贴胸标', null, '2020-06-10 16:46:44', '');
INSERT INTO `py_process` VALUES ('2', '贴门襟', '2020-06-10 16:44:58', null, '');
INSERT INTO `py_process` VALUES ('4', '订领', null, '2020-06-11 15:35:42', '');
INSERT INTO `py_process` VALUES ('5', '拉肩', '2020-06-11 15:37:04', '2020-06-11 15:38:03', '');

-- ----------------------------
-- Table structure for py_staff
-- ----------------------------
DROP TABLE IF EXISTS `py_staff`;
CREATE TABLE `py_staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of py_staff
-- ----------------------------
INSERT INTO `py_staff` VALUES ('18', '小茗同学', '1', '0', '22', '1', null, '2020-06-08 14:20:55', null, null);
INSERT INTO `py_staff` VALUES ('19', '小明同学', '2', '0', '4', '222', null, '2020-06-04 16:34:52', null, null);
INSERT INTO `py_staff` VALUES ('20', '444', '3', '0', '10', '13', null, '2020-06-04 17:05:45', null, null);
INSERT INTO `py_staff` VALUES ('21', 'string', '0', '1', '11111', 'string', null, '2020-06-05 09:31:30', null, null);
INSERT INTO `py_staff` VALUES ('22', '1', '1', '0', '42575375412', '1', null, '2020-06-05 09:24:55', null, null);
INSERT INTO `py_staff` VALUES ('23', '1', '1', '0', '1', '1', null, '2020-06-04 17:21:23', null, null);
INSERT INTO `py_staff` VALUES ('24', '2', '2', '0', '2', '2', null, '2020-06-04 17:23:14', null, null);
INSERT INTO `py_staff` VALUES ('25', '1', '1', '0', '1', '1', null, '2020-06-04 17:28:33', null, null);
INSERT INTO `py_staff` VALUES ('26', '1', '1', '0', '1', '1', null, '2020-06-04 17:28:40', null, null);
INSERT INTO `py_staff` VALUES ('28', '1', '1', '0', '1', '', null, '2020-06-04 17:29:36', null, null);
INSERT INTO `py_staff` VALUES ('29', '11', '1', '0', '1', '', null, '2020-06-04 17:30:44', null, null);
INSERT INTO `py_staff` VALUES ('30', '1', '1', '0', '1', '1', null, '2020-06-04 17:36:53', null, null);
INSERT INTO `py_staff` VALUES ('31', '1', '1', '0', '1', '1', '2020-06-03 17:45:08', null, null, null);
INSERT INTO `py_staff` VALUES ('32', '你好你好', '11', '0', '1', '1', '2020-06-03 17:45:08', '2020-06-05 09:45:18', null, null);
INSERT INTO `py_staff` VALUES ('33', '444444', '443', '0', '44444', '', null, '2020-06-05 09:44:03', null, null);
INSERT INTO `py_staff` VALUES ('34', '222@@', '2', '0', '22', '22', null, '2020-06-04 17:39:16', null, null);
INSERT INTO `py_staff` VALUES ('35', '444', '2', '0', '2', '22', null, '2020-06-04 17:42:39', null, null);
INSERT INTO `py_staff` VALUES ('36', '小茗同学', '11', '0', '1', '1', '2020-06-05 09:22:34', null, null, null);
INSERT INTO `py_staff` VALUES ('37', '林少', '25', '1', '3232', '', null, '2020-06-09 10:58:12', null, null);
INSERT INTO `py_staff` VALUES ('38', '2', '2', '0', '2', '2', '2020-06-05 17:07:15', null, null, null);
INSERT INTO `py_staff` VALUES ('39', '林少', '11', '1', '11', '1', '2020-06-09 10:57:57', null, null, null);
