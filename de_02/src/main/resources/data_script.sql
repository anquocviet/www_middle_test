/*
 Navicat Premium Data Transfer

 Source Server         : MariaDB
 Source Server Type    : MariaDB
 Source Server Version : 110502 (11.5.2-MariaDB-ubu2404)
 Source Host           : localhost:3306
 Source Schema         : www_middle_test_02

 Target Server Type    : MariaDB
 Target Server Version : 110502 (11.5.2-MariaDB-ubu2404)
 File Encoding         : 65001

 Date: 15/10/2024 14:59:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of candidate
-- ----------------------------
BEGIN;
INSERT INTO `candidate` (`can_id`, `email`, `full_name`, `phone`) VALUES (1, 'daict@outlook.com', 'Takeuchi Daichi', '312-828-2831');
INSERT INTO `candidate` (`can_id`, `email`, `full_name`, `phone`) VALUES (2, 'rui5@mail.com', 'Hao Rui', '312-574-8864');
INSERT INTO `candidate` (`can_id`, `email`, `full_name`, `phone`) VALUES (3, 'nakamorihi@gmail.com', 'Nakamori Hina', '718-655-3305');
COMMIT;

-- ----------------------------
-- Records of experience
-- ----------------------------
BEGIN;
INSERT INTO `experience` (`exp_id`, `company`, `from_date`, `role`, `to_date`, `work_desc`, `can_id`) VALUES (1, 'Liu Kee Company Limited', '2022-05-26', 1, '2017-12-14', 'Information security analyst', 2);
INSERT INTO `experience` (`exp_id`, `company`, `from_date`, `role`, `to_date`, `work_desc`, `can_id`) VALUES (2, 'Ryan LLC', '2001-08-09', 4, '2013-05-07', 'Operations manager', 3);
INSERT INTO `experience` (`exp_id`, `company`, `from_date`, `role`, `to_date`, `work_desc`, `can_id`) VALUES (3, 'Wing Suen Electronic Limited', '2018-01-17', 2, '2018-08-21', 'Doctor', 1);
INSERT INTO `experience` (`exp_id`, `company`, `from_date`, `role`, `to_date`, `work_desc`, `can_id`) VALUES (4, 'Yang Kee Pharmaceutical Company Limited', '2024-08-24', 3, '2015-04-18', 'Operations manager', 1);
INSERT INTO `experience` (`exp_id`, `company`, `from_date`, `role`, `to_date`, `work_desc`, `can_id`) VALUES (5, 'Wai San Communications Limited', '2020-10-17', 4, '2019-01-02', 'Groomer', 3);
INSERT INTO `experience` (`exp_id`, `company`, `from_date`, `role`, `to_date`, `work_desc`, `can_id`) VALUES (6, 'Matsui Corporation', '2023-04-19', 1, '2020-12-09', 'Financial planner', 3);
INSERT INTO `experience` (`exp_id`, `company`, `from_date`, `role`, `to_date`, `work_desc`, `can_id`) VALUES (7, 'Nancy Logistic Inc.', '2008-09-13', 3, '2024-01-30', 'Technical support', 1);
INSERT INTO `experience` (`exp_id`, `company`, `from_date`, `role`, `to_date`, `work_desc`, `can_id`) VALUES (8, 'Woods Brothers Technology LLC', '2020-07-05', 4, '2004-08-16', 'Client services manager', 2);
INSERT INTO `experience` (`exp_id`, `company`, `from_date`, `role`, `to_date`, `work_desc`, `can_id`) VALUES (9, 'Momoka Food Corporation', '2018-06-12', 3, '2019-01-19', 'Financial planner', 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
