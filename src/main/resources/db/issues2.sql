/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : issues2

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2017-12-06 19:08:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for issues
-- ----------------------------
DROP TABLE IF EXISTS `issues`;
CREATE TABLE `issues` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（创建，进行中，已完成）',
  `title` varchar(255) DEFAULT NULL COMMENT 'issues 标题',
  `story_point` varchar(255) DEFAULT NULL COMMENT 'story point(单位：小时)',
  `priority` int(11) DEFAULT NULL COMMENT '优先级',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `assigner_id` bigint(20) unsigned DEFAULT NULL COMMENT '分配人id',
  `assigned_user_id` bigint(20) unsigned DEFAULT NULL COMMENT '被分配人id',
  `creater_id` bigint(20) unsigned DEFAULT NULL COMMENT '创建人id',
  `reporter_id` bigint(20) unsigned DEFAULT NULL COMMENT '报告人id',
  `project_id` bigint(20) unsigned DEFAULT NULL COMMENT '所属项目id',
  `delete_flag` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for issues_history
-- ----------------------------
DROP TABLE IF EXISTS `issues_history`;
CREATE TABLE `issues_history` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `event_value` varchar(255) DEFAULT NULL COMMENT '事件值',
  `event_name` varchar(255) DEFAULT NULL COMMENT '事件名称',
  `operater_id` bigint(20) unsigned DEFAULT NULL COMMENT '操作人id',
  `delete_flag` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for issues_label
-- ----------------------------
DROP TABLE IF EXISTS `issues_label`;
CREATE TABLE `issues_label` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `issues_id` bigint(20) unsigned DEFAULT NULL COMMENT 'issues id',
  `label_id` bigint(20) unsigned DEFAULT NULL COMMENT 'label id',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for issues_type
-- ----------------------------
DROP TABLE IF EXISTS `issues_type`;
CREATE TABLE `issues_type` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '标签名',
  `project_id` bigint(20) unsigned DEFAULT NULL COMMENT '所属项目id',
  `system_flag` tinyint(4) DEFAULT NULL COMMENT '是否为系统级别标签',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `description` varchar(255) DEFAULT NULL COMMENT '项目描述',
  `project_key` varchar(50) DEFAULT NULL COMMENT '项目key',
  `owner_id` bigint(20) unsigned DEFAULT NULL COMMENT '拥有者id',
  `delete_flag` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  `creater_id` bigint(20) unsigned DEFAULT NULL COMMENT '创建人id',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for project_user
-- ----------------------------
DROP TABLE IF EXISTS `project_user`;
CREATE TABLE `project_user` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `project_id` bigint(20) unsigned DEFAULT NULL COMMENT '项目id',
  `user_id` bigint(20) unsigned DEFAULT NULL COMMENT '用户id',
  `role` int(10) DEFAULT NULL COMMENT '用户在项目中的角色（创建人，admin，普通人员，观察者）',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sprint
-- ----------------------------
DROP TABLE IF EXISTS `sprint`;
CREATE TABLE `sprint` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `project_id` bigint(20) unsigned DEFAULT NULL COMMENT '项目id',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `delete_flag` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sprint_issues
-- ----------------------------
DROP TABLE IF EXISTS `sprint_issues`;
CREATE TABLE `sprint_issues` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `sprint_id` bigint(20) unsigned DEFAULT NULL COMMENT 'sprint id',
  `issues_id` bigint(20) unsigned DEFAULT NULL COMMENT 'issues id',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `delete_flag` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `user_id` bigint(20) unsigned DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) unsigned DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
