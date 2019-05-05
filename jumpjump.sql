/*
 Navicat Premium Data Transfer

 Source Server         : jump
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 47.107.239.34:3306
 Source Schema         : jumpjump

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 05/05/2019 20:30:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `admin_id` int(2) NOT NULL,
  `admin_login_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `admin_login_password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `admin_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `admin_phone` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for comments_info
-- ----------------------------
DROP TABLE IF EXISTS `comments_info`;
CREATE TABLE `comments_info` (
  `comments_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(10) NOT NULL,
  `game_id` int(10) NOT NULL,
  `comments_content` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `comments_time` date DEFAULT NULL,
  `is_recommend` int(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`comments_id`),
  KEY `u_id` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for game_community
-- ----------------------------
DROP TABLE IF EXISTS `game_community`;
CREATE TABLE `game_community` (
  `game_community_id` int(255) NOT NULL AUTO_INCREMENT,
  `game_community_image` varchar(255) DEFAULT NULL,
  `game_id` int(11) DEFAULT NULL,
  `game_community_posting_num` int(10) DEFAULT '0',
  PRIMARY KEY (`game_community_id`) USING BTREE,
  KEY `image` (`game_community_image`)
) ENGINE=InnoDB AUTO_INCREMENT=703 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for game_community_posting
-- ----------------------------
DROP TABLE IF EXISTS `game_community_posting`;
CREATE TABLE `game_community_posting` (
  `game_community_posting_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_community_posting_title` varchar(255) DEFAULT NULL,
  `game_community_posting_content` varchar(255) DEFAULT NULL,
  `game_community_posting_uid` int(11) DEFAULT NULL,
  `game_community_posting_time` date DEFAULT NULL,
  `game_community_posting_game_community_id` int(11) DEFAULT NULL,
  `game_community_posting_evaluate_num` int(10) DEFAULT '0',
  PRIMARY KEY (`game_community_posting_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for game_community_posting_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `game_community_posting_evaluate`;
CREATE TABLE `game_community_posting_evaluate` (
  `game_community_posting_evaluate_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_community_posting_evaluate_content` varchar(255) DEFAULT NULL,
  `game_community_posting_evaluate_uid` int(11) DEFAULT NULL,
  `game_community_posting_evaluate_posting_id` int(11) DEFAULT NULL,
  `game_community_posting_evaluate_time` date DEFAULT NULL,
  PRIMARY KEY (`game_community_posting_evaluate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for game_info
-- ----------------------------
DROP TABLE IF EXISTS `game_info`;
CREATE TABLE `game_info` (
  `game_id` int(10) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(255) NOT NULL,
  `game_comments_num` int(3) DEFAULT '0',
  `game_content` longtext,
  `game_type_id` int(10) DEFAULT NULL,
  `game_publisher` varchar(255) DEFAULT NULL,
  `game_score` int(2) DEFAULT '0',
  `game_image` varchar(255) DEFAULT NULL,
  `game_publish_time` date DEFAULT NULL,
  PRIMARY KEY (`game_id`),
  KEY `game_image` (`game_image`),
  KEY `game_type_id` (`game_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=705 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for game_publisher_info
-- ----------------------------
DROP TABLE IF EXISTS `game_publisher_info`;
CREATE TABLE `game_publisher_info` (
  `game_publisher_id` int(10) NOT NULL AUTO_INCREMENT,
  `game_publisher_name` varchar(255) DEFAULT NULL,
  `game_publisher_image` varchar(255) DEFAULT NULL,
  `game_publisher_num` int(10) DEFAULT '0',
  PRIMARY KEY (`game_publisher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for game_type_info
-- ----------------------------
DROP TABLE IF EXISTS `game_type_info`;
CREATE TABLE `game_type_info` (
  `game_type_id` int(10) NOT NULL AUTO_INCREMENT,
  `game_type_name` varchar(255) DEFAULT NULL,
  `game_type_num` int(10) DEFAULT '0',
  PRIMARY KEY (`game_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `title` text,
  `content` longtext,
  `module_id` int(10) DEFAULT NULL,
  `game_publisher` varchar(255) DEFAULT NULL,
  `game_score` int(2) DEFAULT '0',
  `game_image` varchar(255) DEFAULT NULL,
  `news_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `game_image` (`game_image`),
  KEY `game_type_id` (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=705 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for news_spider
-- ----------------------------
DROP TABLE IF EXISTS `news_spider`;
CREATE TABLE `news_spider` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `content` longtext,
  `module_id` int(10) NOT NULL,
  `news_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `url` text,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=705 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for newslogs
-- ----------------------------
DROP TABLE IF EXISTS `newslogs`;
CREATE TABLE `newslogs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `news_id` bigint(20) NOT NULL,
  `view_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `prefer_degree` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `news_id` (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for newsmodules
-- ----------------------------
DROP TABLE IF EXISTS `newsmodules`;
CREATE TABLE `newsmodules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for recommend_info
-- ----------------------------
DROP TABLE IF EXISTS `recommend_info`;
CREATE TABLE `recommend_info` (
  `recommend_id` int(2) NOT NULL AUTO_INCREMENT,
  `game_id` int(2) NOT NULL,
  `user_id` int(2) NOT NULL,
  `recommend_content` longtext,
  `recommend_image` varchar(255) DEFAULT NULL,
  `status` int(2) DEFAULT '0',
  PRIMARY KEY (`recommend_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for recommendations
-- ----------------------------
DROP TABLE IF EXISTS `recommendations`;
CREATE TABLE `recommendations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `news_id` bigint(20) NOT NULL,
  `derive_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `feedback` bit(1) DEFAULT NULL,
  `derive_algorithm` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `news_id` (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rotation_chart
-- ----------------------------
DROP TABLE IF EXISTS `rotation_chart`;
CREATE TABLE `rotation_chart` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `pageId` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_focus_community
-- ----------------------------
DROP TABLE IF EXISTS `user_focus_community`;
CREATE TABLE `user_focus_community` (
  `focus_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `game_community_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`focus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `u_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_openid` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `u_gender` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `u_nickname` varchar(255) DEFAULT NULL,
  `u_country` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `u_avatarurl` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `u_canComment` int(2) DEFAULT '1',
  `u_lastLoginTime` datetime DEFAULT NULL,
  `u_registerTime` datetime DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `pref_list` text CHARACTER SET utf8 NOT NULL,
  `latest_log_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;
