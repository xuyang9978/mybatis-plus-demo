/*
 Navicat Premium Data Transfer

 Source Server         : local-xuyang
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : mybatisplusdemo

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 14/07/2020 22:10:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '邮箱',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次更新时间',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁\r\n',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除，删除为1，未删除为0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1282908865892995077 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 'Tom', 17, 'test3@baomidou.com', NULL, NULL, 1, 1);
INSERT INTO `user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', NULL, NULL, 1, 0);
INSERT INTO `user` VALUES (5, 'Billie', 20, 'test5@baomidou.com', NULL, NULL, 1, 0);
INSERT INTO `user` VALUES (1282908865892995075, 'test01', 17, 'xuyang9978@gamil.com', NULL, NULL, 1, 1);
INSERT INTO `user` VALUES (1282908865892995076, 'test02', 30, 'xuyang9978@gamil.com', '2020-07-14 14:04:05', '2020-07-14 14:04:05', 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
