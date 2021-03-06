/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 20/07/2020 14:09:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for manage_article
-- ----------------------------
DROP TABLE IF EXISTS `manage_article`;
CREATE TABLE `manage_article`  (
  `article_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章ID',
  `article_title` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章标题',
  `article_release_date` datetime(0) DEFAULT NULL COMMENT '发布日期',
  `article_content_html` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容-html',
  `article_content_markdown` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容-markdown',
  `article_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章描述',
  `article_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发表文章的作者ID',
  `article_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '文章状态',
  `article_release_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '发布状态（0 未发布 1 已发布）',
  `article_image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章图片',
  `article_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '文章类型',
  `audit_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '审核状态 0 未审核 2 审核中 4 已审核',
  `top_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '置顶状态 0 未置顶 1 已置顶',
  `draft_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否草稿 0 是草稿 1 不是草稿',
  `comment_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '评论开启状态 0 未开启 1 已开启',
  `fine_note_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '是否精帖 0 不是精帖 1 是精帖',
  `enable` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '停用/启用 0 停用 1 启用',
  `create_time` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime(6) DEFAULT NULL COMMENT '修改时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_article
-- ----------------------------
INSERT INTO `manage_article` VALUES ('1', 'Spring Boot 实战', '2020-04-19 02:22:54', '<blockquote><p><i>当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。我们竟哈哈大笑。</i></p></blockquote>\\r\\n', '## 当我走出第一步，有一种叫悲哀的东西漫过心底；\r\n```\r\n我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？<br/>\r\n曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，\r\n```\r\n> 曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。<br/>\r\n &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？<br/>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，\r\n## 有一种叫悲哀的东西漫过心底\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。<br/>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？<br/>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。我们竟哈哈大笑。', '这是一段描述', '8e20ed1dc3084825800957a89d2061d2', '0', '1', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '0', NULL, '0', NULL, '0', '0', '1', '2020-04-19 02:23:34.000000', '8e20ed1dc3084825800957a89d2061d2', NULL, NULL);

-- ----------------------------
-- Table structure for manage_article_label
-- ----------------------------
DROP TABLE IF EXISTS `manage_article_label`;
CREATE TABLE `manage_article_label`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `article_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文章id',
  `label_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签id',
  `c_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章标签中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manage_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `manage_article_tag`;
CREATE TABLE `manage_article_tag`  (
  `article_tag_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `article_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tag_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`article_tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章标签中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_article_tag
-- ----------------------------
INSERT INTO `manage_article_tag` VALUES ('1', '1', '7fc67dd5f442406986c787898e952e5e', NULL, NULL, NULL, NULL);
INSERT INTO `manage_article_tag` VALUES ('2', '1', '851c42c8507145b5a69bc743feefec5b', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for manage_category
-- ----------------------------
DROP TABLE IF EXISTS `manage_category`;
CREATE TABLE `manage_category`  (
  `category_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `category_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sort` int(50) DEFAULT NULL,
  `category_belong_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `category_belong_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `enable` int(10) DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_category
-- ----------------------------
INSERT INTO `manage_category` VALUES ('20200109210000000000000000000005', '测试分类1', 2, '2', '123', '2020-02-09 21:32:27', NULL, '2020-02-09 21:37:09', NULL, 0);

-- ----------------------------
-- Table structure for manage_comment
-- ----------------------------
DROP TABLE IF EXISTS `manage_comment`;
CREATE TABLE `manage_comment`  (
  `comment_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '评论内容',
  `comment_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论者的用户id',
  `comment_parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父id',
  `comment_belong_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论所属id',
  `comment_time` datetime(0) DEFAULT NULL COMMENT '评论时间',
  `approves` bigint(20) DEFAULT 0 COMMENT '点赞数',
  `enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '停用/启用',
  `create_time` datetime(0) DEFAULT NULL,
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manage_dept
-- ----------------------------
DROP TABLE IF EXISTS `manage_dept`;
CREATE TABLE `manage_dept`  (
  `dept_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门id',
  `dept_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '部门名称',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '上级部门名称',
  `enable` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '启用/停用',
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `c_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '员工部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_dept
-- ----------------------------
INSERT INTO `manage_dept` VALUES ('20200304230000000000000000004945', '华中分部', '20200312200000000000000000005086', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:10:21', NULL, '2020-04-12 20:10:21', '2020-04-12 20:10:21');
INSERT INTO `manage_dept` VALUES ('20200304230000000000000000004946', '华东分部', '20200312200000000000000000005086', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:10:39', NULL, '2020-04-12 20:10:38', '2020-04-12 20:10:38');
INSERT INTO `manage_dept` VALUES ('20200304230000000000000000004949', '销售部', '20200304230000000000000000004945', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:14:54', NULL, '2020-04-12 20:14:54', '2020-04-12 20:14:54');
INSERT INTO `manage_dept` VALUES ('20200304230000000000000000004952', '华南分部', '20200312200000000000000000005086', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:10:35', NULL, '2020-04-12 20:10:34', '2020-04-12 20:10:34');
INSERT INTO `manage_dept` VALUES ('20200304230000000000000000004981', '华北分部', '20200312200000000000000000005086', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:10:30', NULL, '2020-04-12 20:10:29', '2020-04-12 20:10:29');
INSERT INTO `manage_dept` VALUES ('20200304230000000000000000004987', '技术部', '20200304230000000000000000004945', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:14:45', NULL, '2020-04-12 20:14:44', '2020-04-12 20:14:44');
INSERT INTO `manage_dept` VALUES ('20200304230000000000000000004995', '人事部', '20200304230000000000000000004946', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:15:17', NULL, '2020-04-12 20:15:17', '2020-04-12 20:15:17');
INSERT INTO `manage_dept` VALUES ('20200304230000000000000000004997', '人事部', '20200304230000000000000000004945', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:13:55', NULL, '2020-04-12 20:13:55', '2020-04-12 20:13:55');
INSERT INTO `manage_dept` VALUES ('20200304230000000000000000004998', '财务部', '20200304230000000000000000004945', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:14:33', NULL, '2020-04-12 20:14:33', '2020-04-12 20:14:33');
INSERT INTO `manage_dept` VALUES ('20200304230000000000000000005008', '人事部', '20200304230000000000000000004952', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:15:24', NULL, '2020-04-12 20:15:24', '2020-04-12 20:15:24');
INSERT INTO `manage_dept` VALUES ('20200312200000000000000000005034', '财务部', '20200304230000000000000000004981', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:20:37', NULL, '2020-04-12 20:20:37', '2020-04-12 20:20:37');
INSERT INTO `manage_dept` VALUES ('20200312200000000000000000005086', '公司总部', NULL, '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:27:10', NULL, '2020-04-12 20:27:10', '2020-04-12 20:27:10');

-- ----------------------------
-- Table structure for manage_iamge
-- ----------------------------
DROP TABLE IF EXISTS `manage_iamge`;
CREATE TABLE `manage_iamge`  (
  `iamge_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `image_url` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片路径',
  `image_description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片描述',
  `iamge_belong` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片所属',
  PRIMARY KEY (`iamge_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manage_im_message
-- ----------------------------
DROP TABLE IF EXISTS `manage_im_message`;
CREATE TABLE `manage_im_message`  (
  `im_message_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `receive_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接收人',
  `receive_time` datetime(0) DEFAULT NULL COMMENT '接收时间',
  `send_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送人id',
  `send_time` datetime(0) DEFAULT NULL COMMENT '发送时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送内容',
  `message_type` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型 1：回复 2：@ 3：赞 4：系统 5：私信 6：我的消息',
  `read_status` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '1 已读 0 未读',
  PRIMARY KEY (`im_message_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manage_job
-- ----------------------------
DROP TABLE IF EXISTS `manage_job`;
CREATE TABLE `manage_job`  (
  `job_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位id',
  `job_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '岗位名称',
  `dept_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '部门id',
  `enable` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '启用/停用',
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `c_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '员工岗位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_job
-- ----------------------------
INSERT INTO `manage_job` VALUES ('20200312200000000000000000005025', '后端开发', '20200304230000000000000000004987', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:30:17', NULL, '2020-04-13 00:30:16', '2020-04-13 00:30:16');
INSERT INTO `manage_job` VALUES ('20200312200000000000000000005053', '招聘专员', '20200304230000000000000000004995', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:32:04', NULL, '2020-04-13 00:32:03', '2020-04-13 00:32:03');
INSERT INTO `manage_job` VALUES ('20200312200000000000000000005060', '前端开发', '20200304230000000000000000004987', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:30:10', NULL, '2020-04-13 00:30:10', '2020-04-13 00:30:10');
INSERT INTO `manage_job` VALUES ('20200312200000000000000000005061', '人工客服', '20200304230000000000000000004949', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:31:04', NULL, '2020-04-13 00:31:03', '2020-04-13 00:31:03');
INSERT INTO `manage_job` VALUES ('20200312200000000000000000005067', '招聘专员', '20200304230000000000000000004997', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:32:09', NULL, '2020-04-13 00:32:09', '2020-04-13 00:32:09');
INSERT INTO `manage_job` VALUES ('20200312200000000000000000005082', '电话销售', '20200304230000000000000000004949', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:30:50', NULL, '2020-04-13 00:30:50', '2020-04-13 00:30:50');
INSERT INTO `manage_job` VALUES ('20200312200000000000000000005085', '招聘专员', '20200304230000000000000000005008', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:32:14', NULL, '2020-04-13 00:32:14', '2020-04-13 00:32:14');
INSERT INTO `manage_job` VALUES ('20200312200000000000000000005095', '产品经理', '20200304230000000000000000004987', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:29:43', NULL, '2020-04-13 00:29:43', '2020-04-13 00:29:43');

-- ----------------------------
-- Table structure for manage_log
-- ----------------------------
DROP TABLE IF EXISTS `manage_log`;
CREATE TABLE `manage_log`  (
  `log_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日志id',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `request_method` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求方式',
  `request_path` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求路径',
  `method_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求方法名称',
  `request_params` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '请求参数',
  `ip_address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求ip地址',
  `address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求地址',
  `operating_time` datetime(0) DEFAULT NULL COMMENT '操作时间',
  `result_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '结果（1： 成功 ；0：失败）',
  `browser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '浏览器',
  `result_operation` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '结果描述',
  `time_consuming` int(11) DEFAULT NULL COMMENT '消耗时间',
  `operating_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台系统操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manage_menu
-- ----------------------------
DROP TABLE IF EXISTS `manage_menu`;
CREATE TABLE `manage_menu`  (
  `menu_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单code',
  `parent_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上级菜单code',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `component` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '组件',
  `sort` bigint(20) DEFAULT NULL COMMENT '排序',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图标',
  `path` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接地址',
  `hidden` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '隐藏',
  `component_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '-' COMMENT '组件名称',
  `permission` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限',
  `type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单或按钮(MENU :菜单，BUTTON：按钮)',
  `i_frame` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否外链',
  `cache` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建日期',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`menu_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统菜单' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of manage_menu
-- ----------------------------
INSERT INTO `manage_menu` VALUES ('10396d3cc11941c7b4931b5637eb1ac1', NULL, '系统管理', NULL, 1, 'system', 'system', '0', '', NULL, '0', '0', '0', '2020-03-29 01:42:56', NULL, NULL, NULL);
INSERT INTO `manage_menu` VALUES ('10396d3cc11941c7b4931b5637eb2ac2', '10396d3cc11941c7b4931b5637eb1ac1', '用户管理', 'system/user/index', 1, 'peoples', 'user', '0', 'User', 'user:list', '1', '0', '0', '2020-03-30 01:42:53', NULL, NULL, NULL);
INSERT INTO `manage_menu` VALUES ('10396d3cc11941c7b4931b5637eb3ac3', '10396d3cc11941c7b4931b5637eb1ac1', '角色管理', 'system/role/index', 2, 'role', 'role', '0', 'Role', 'roles:list', '1', '0', '0', '2020-03-31 01:42:50', NULL, NULL, NULL);
INSERT INTO `manage_menu` VALUES ('10396d3cc11941c7b4931b5637eb4ac4', NULL, '系统监控', NULL, 10, 'monitor', 'monitor', '0', '', NULL, '0', '0', '0', '2020-03-31 12:13:30', NULL, NULL, NULL);
INSERT INTO `manage_menu` VALUES ('10396d3cc11941c7b4931b5637eb5ac5', '10396d3cc11941c7b4931b5637eb4ac4', '操作日志', 'monitor/log/index', 11, 'log', 'logs', '0', 'Log', NULL, '1', '0', '0', '2020-03-31 12:15:17', NULL, NULL, NULL);
INSERT INTO `manage_menu` VALUES ('10396d3cc11941c7b4931b5637eb5ac6', '10396d3cc11941c7b4931b5637eb1ac1', '菜单管理', 'system/menu/index', 5, 'menu', 'menu', '0', 'Menu', 'menu:list', '1', '0', '0', '2020-03-31 15:30:57', NULL, NULL, NULL);
INSERT INTO `manage_menu` VALUES ('10396d3cc11941c7b4931b5637eb5ac7', '10396d3cc11941c7b4931b5637eb2ac2', '用户新增', NULL, 2, NULL, NULL, '0', '', 'user:add', '2', '0', '0', '2020-04-01 00:23:07', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for manage_role
-- ----------------------------
DROP TABLE IF EXISTS `manage_role`;
CREATE TABLE `manage_role`  (
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `role_describe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色编号',
  `enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '启用/停用',
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_role
-- ----------------------------
INSERT INTO `manage_role` VALUES ('36c9ae4c53ed41519aa6a67f36d55654', '普通用户', '12312', 'string', '0', '0c3740672f6a4afbaa1af705e4b66c47', 'null', '2020-04-01 12:28:14', '2020-04-01 12:28:14');
INSERT INTO `manage_role` VALUES ('36c9ae4c53ed41519aa6a67f36d5565a', '超级管理员', '所有权限', 'admin', '1', '0c3740672f6a4afbaa1af705e4b66c47', 'null', '2020-04-01 12:28:14', '2020-04-01 12:28:14');
INSERT INTO `manage_role` VALUES ('86548586a46f422aa6f9e702bbbd04c5', '游客', '123', '123', '1', '0c3740672f6a4afbaa1af705e4b66c47', 'null', '2020-04-01 12:28:14', '2020-04-01 12:28:14');

-- ----------------------------
-- Table structure for manage_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `manage_role_dept`;
CREATE TABLE `manage_role_dept`  (
  `role_dept_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色部门关联id',
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色id',
  `dept_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '部门id',
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `c_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`role_dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manage_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `manage_role_menu`;
CREATE TABLE `manage_role_menu`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色id',
  `menu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单id',
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_role_menu
-- ----------------------------
INSERT INTO `manage_role_menu` VALUES ('16b8bd029cf2484aaef1ccbcad917c7f', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb1ac1', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `manage_role_menu` VALUES ('3ce9e9a11c654672a0ead83b57d02b13', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb2ac2', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `manage_role_menu` VALUES ('3ce9e9a11c654672a0ead83b57d02b14', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb3ac3', NULL, '2020-04-01 11:02:36', NULL, NULL);
INSERT INTO `manage_role_menu` VALUES ('3ce9e9a11c654672a0ead83b57d02b15', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb4ac4', NULL, '2020-04-01 11:02:34', NULL, NULL);
INSERT INTO `manage_role_menu` VALUES ('3ce9e9a11c654672a0ead83b57d02b16', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb5ac5', NULL, '2020-04-01 11:02:52', NULL, NULL);
INSERT INTO `manage_role_menu` VALUES ('3ce9e9a11c654672a0ead83b57d02b17', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb6ac6', NULL, '2020-04-01 11:02:52', NULL, NULL);
INSERT INTO `manage_role_menu` VALUES ('3ce9e9a11c654672a0ead83b57d02b18', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb5ac7', NULL, '2020-04-01 11:02:52', NULL, NULL);

-- ----------------------------
-- Table structure for manage_tag
-- ----------------------------
DROP TABLE IF EXISTS `manage_tag`;
CREATE TABLE `manage_tag`  (
  `tag_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tag_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签名称',
  `tag_category_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签所属类别',
  `enable` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '启用/禁用',
  `create_time` datetime(0) DEFAULT NULL,
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_tag
-- ----------------------------
INSERT INTO `manage_tag` VALUES ('7fc67dd5f442406986c787898e952e5e', 'linux', NULL, '1', '2019-07-25 14:03:46', 'null', NULL, NULL);
INSERT INTO `manage_tag` VALUES ('851c42c8507145b5a69bc743feefec5b', 'spring boot', NULL, '1', '2019-07-25 14:03:04', 'null', NULL, NULL);
INSERT INTO `manage_tag` VALUES ('b6ccb2bb7efb4d73b7466fd4d1521820', 'Java', NULL, '1', '2019-07-25 14:02:49', 'null', NULL, NULL);

-- ----------------------------
-- Table structure for manage_user
-- ----------------------------
DROP TABLE IF EXISTS `manage_user`;
CREATE TABLE `manage_user`  (
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆密码',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个性签名',
  `dept_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门id',
  `job_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '岗位id',
  `login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆ip',
  `last_login_time` datetime(0) DEFAULT NULL COMMENT '上一次登陆时间',
  `enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '停用/启用（0，停用；1，启用）',
  `create_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建日期',
  `update_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_user
-- ----------------------------
INSERT INTO `manage_user` VALUES ('8e20ed1dc3084825800957a89d2061d2', 'admin', '$2a$10$RJxDZ4bZaelml3Kfzjnv9ep110tbKE4BD5Zmi5kSUj5Vn1fwvHTGq', '超级管理员', '1', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'string', 'string@163.com', 'string', NULL, NULL, '0:0:0:0:0:0:0:1', '2020-06-17 22:47:52', '1', 'null', '2019-07-22 13:42:54', '8e20ed1dc3084825800957a89d2061d2', '2020-06-17 22:47:52');
INSERT INTO `manage_user` VALUES ('8e20ed1dc3084825800957a89d2061d3', 'test', '$2a$10$RJxDZ4bZaelml3Kfzjnv9ep110tbKE4BD5Zmi5kSUj5Vn1fwvHTGq', '123', '2', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '123', 'string@163.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '8e20ed1dc3084825800957a89d2061d2', '2020-04-04 23:30:02');

-- ----------------------------
-- Table structure for manage_user_role
-- ----------------------------
DROP TABLE IF EXISTS `manage_user_role`;
CREATE TABLE `manage_user_role`  (
  `user_role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户id',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_user_role
-- ----------------------------
INSERT INTO `manage_user_role` VALUES ('20200304220000000000000000004950', '86548586a46f422aa6f9e702bbbd04c5', '8e20ed1dc3084825800957a89d2061d3', '8e20ed1dc3084825800957a89d2061d2', '2020-04-04 23:50:03', NULL, NULL);
INSERT INTO `manage_user_role` VALUES ('20200304230000000000000000004950', '36c9ae4c53ed41519aa6a67f36d55654', '8e20ed1dc3084825800957a89d2061d3', '8e20ed1dc3084825800957a89d2061d2', '2020-04-04 23:30:02', NULL, NULL);
INSERT INTO `manage_user_role` VALUES ('50d2aba60d004998bb8bd1295fae6d33', '36c9ae4c53ed41519aa6a67f36d5565a', '8e20ed1dc3084825800957a89d2061d2', '0c3740672f6a4afbaa1af705e4b66c47', '2019-07-17 18:00:39', NULL, NULL);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for portal_article
-- ----------------------------
DROP TABLE IF EXISTS `portal_article`;
CREATE TABLE `portal_article`  (
  `article_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章ID',
  `article_title` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章标题',
  `article_release_date` datetime(0) DEFAULT NULL COMMENT '发布日期',
  `article_content_html` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容-html',
  `article_content_markdown` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容-markdown',
  `article_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章描述',
  `article_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发表文章的作者ID',
  `article_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '文章状态',
  `article_release_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '发布状态（0 未发布 1 已发布）',
  `article_image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章图片',
  `article_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '文章类型',
  `audit_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '审核状态 0 未审核 2 审核中 4 已审核',
  `top_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '置顶状态 0 未置顶 1 已置顶',
  `draft_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否草稿 0 是草稿 1 不是草稿',
  `comment_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '评论开启状态 0 未开启 1 已开启',
  `fine_note_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '是否精帖 0 不是精帖 1 是精帖',
  `enable` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '停用/启用 0 停用 1 启用',
  `create_time` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime(6) DEFAULT NULL COMMENT '修改时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_article
-- ----------------------------
INSERT INTO `portal_article` VALUES ('1', 'Spring Boot 实战', '2020-04-19 02:22:54', '<blockquote><p><i>当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。我们竟哈哈大笑。</i></p></blockquote>\\r\\n', '## 当我走出第一步，有一种叫悲哀的东西漫过心底；\r\n```\r\n我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？<br/>\r\n曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，\r\n```\r\n> 曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。<br/>\r\n &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？<br/>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，\r\n## 有一种叫悲哀的东西漫过心底\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。<br/>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？<br/>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。我们竟哈哈大笑。', '这是一段描述', '8e20ed1dc3084825800957a89d2061d2', '0', '1', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '0', NULL, '0', NULL, '0', '0', '1', '2020-04-19 02:23:34.000000', '8e20ed1dc3084825800957a89d2061d2', NULL, NULL);

-- ----------------------------
-- Table structure for portal_article_category
-- ----------------------------
DROP TABLE IF EXISTS `portal_article_category`;
CREATE TABLE `portal_article_category`  (
  `article_category_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章分类id',
  `article_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文章id',
  `category_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分类id',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `c_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`article_category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章分类中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for portal_article_info
-- ----------------------------
DROP TABLE IF EXISTS `portal_article_info`;
CREATE TABLE `portal_article_info`  (
  `article_info_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章相关信息id',
  `article_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章id',
  `approve_number` bigint(20) DEFAULT 0 COMMENT '点赞数',
  `comments_number` bigint(20) DEFAULT 0 COMMENT '评论数',
  `like_number` bigint(20) DEFAULT 0 COMMENT '热度',
  `read_number` bigint(20) DEFAULT 0 COMMENT '浏览人数',
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `c_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`article_info_id`) USING BTREE,
  INDEX `inde_article_id`(`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章相关信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_article_info
-- ----------------------------
INSERT INTO `portal_article_info` VALUES ('02da9663f04646a2a3fc6868be920c60', '1', 11, 12, 13, 14, NULL, NULL, '2020-04-19 21:38:55', NULL, '2020-04-19 21:38:49', '2020-04-19 21:38:49');

-- ----------------------------
-- Table structure for portal_article_label
-- ----------------------------
DROP TABLE IF EXISTS `portal_article_label`;
CREATE TABLE `portal_article_label`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `article_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文章id',
  `label_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签id',
  `c_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章标签中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for portal_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `portal_article_tag`;
CREATE TABLE `portal_article_tag`  (
  `article_tag_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章标签id',
  `article_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文章id',
  `tag_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分类id',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`article_tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章标签中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_article_tag
-- ----------------------------
INSERT INTO `portal_article_tag` VALUES ('1', '1', '7fc67dd5f442406986c787898e952e5e', NULL, NULL, NULL, NULL);
INSERT INTO `portal_article_tag` VALUES ('2', '1', '851c42c8507145b5a69bc743feefec5b', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for portal_category
-- ----------------------------
DROP TABLE IF EXISTS `portal_category`;
CREATE TABLE `portal_category`  (
  `category_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类id',
  `category_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  `sort` int(10) NOT NULL COMMENT '排序',
  `category_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类类型',
  `enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '启用/禁用',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '分类信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for portal_comment
-- ----------------------------
DROP TABLE IF EXISTS `portal_comment`;
CREATE TABLE `portal_comment`  (
  `comment_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `comment_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论者的用户id',
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父id',
  `article_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属文章id',
  `comment_time` datetime(0) NOT NULL COMMENT '评论时间',
  `approves` bigint(20) DEFAULT 0 COMMENT '点赞数',
  `enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '启用/禁用',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_comment
-- ----------------------------
INSERT INTO `portal_comment` VALUES ('04591d96601f4b3cbf10bb55c975437f', '齐人未尝赂秦，终继五国迁灭，何哉？与嬴而不助五国也。五国既丧，齐亦不免矣。燕赵之君，始有远略，能守其土，义不赂秦。是故燕虽小国而后亡，斯用兵之效也。至丹以荆卿为计，始速祸焉。赵尝五战于秦，二败而三胜。后秦击赵者再，李牧连却之。洎牧以谗诛，邯郸为郡，惜其用武而不终也。且燕赵处秦革灭殆尽之际，可谓智力孤危，战败而亡，诚不得已。向使三国各爱其地，齐人勿附于秦，刺客不行，良将犹在，则胜负之数，存亡之理，当与秦相较，或未易量。', '8e20ed1dc3084825800957a89d2061d2', '1', '1', '2019-05-12 18:26:10', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('1', '当我走出第一步，有一种叫悲哀的东西漫过心底', '8e20ed1dc3084825800957a89d2061d2', '', '1', '2019-05-11 23:28:40', 10, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('1a4d47163a5a486b88cd8648205a21e0', '我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？', '8e20ed1dc3084825800957a89d2061d2', NULL, '02da9663f04646a2a3fc6868be920c65', '2019-05-12 00:49:08', 20, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('20d5fe3c2cba410780a5f2299cc420f5', '123123', '8e20ed1dc3084825800957a89d2061d2', '04591d96601f4b3cbf10bb55c975437f', '1', '2019-07-31 17:17:15', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('30901f28494049d8b8705b4dcf536571', '关关雎鸠，在河之洲。窈窕淑女，君子好逑。', '8e20ed1dc3084825800957a89d2061d2', NULL, '02da9663f04646a2a3fc6868be920c65', '2019-05-12 00:50:51', 30, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('3950cc3e519b445b8c85aedd60c388f2', '这个是回复', '8e20ed1dc3084825800957a89d2061d2', '04591d96601f4b3cbf10bb55c975437f', '1', '2019-07-31 16:42:22', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('3b0732c1644e4e098e697cc164946515', '123', '8e20ed1dc3084825800957a89d2061d2', 'fb1c6d7c0fc94d1', '1', '2019-07-31 17:48:32', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('49b2e394839b4f9d95ea38ed8536da51', '123', '8e20ed1dc3084825800957a89d2061d2', 'fb1c6d7c0fc94d1', '1', '2019-07-31 16:44:23', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('5d5135dd339647c88836a2f4683eaabc', '是日也，天朗气清，惠风和畅，仰观宇宙之大，俯察品类之盛，所以游目骋怀，足以极视听之娱，信可乐也。', '8e20ed1dc3084825800957a89d2061d2', '8e914e14e2774172bac35bcac20fec1d', '1', '2019-05-12 18:31:47', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('5e4e6906582f45b5932e5b1c6dbb2bb9', '123', '8e20ed1dc3084825800957a89d2061d2', '887844d7ae3649589339042b04287583', '02da9663f04646a2a3fc6868be920c65', '2019-07-31 17:06:16', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('5fb5b8922e8844d8bb9b8d1bef093cc5', '曾几何时', '8e20ed1dc3084825800957a89d2061d2', 'fb1c6d7c0fc94d1', '1', '2019-07-31 17:48:38', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('6a6eda7bdf7542f386a7fbddd6e75ded', '参差荇菜，左右采之。窈窕淑女，琴瑟友之。', '8e20ed1dc3084825800957a89d2061d2', NULL, '02da9663f04646a2a3fc6868be920c65', '2019-05-12 00:51:32', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('6b5fd9c23ebb4cbb8b6155c9d3e9f6fd', '永和九年，岁在癸丑，暮春之初，会于会稽山阴之兰亭，修禊事也。群贤毕至，少长咸集。此地有崇山峻岭，茂林修竹；又有清流激湍，映带左右，引以为流觞曲水，列坐其次。虽无丝竹管弦之盛，一觞一咏，亦足以畅叙幽情。', '8e20ed1dc3084825800957a89d2061d2', '8e914e14e2774172bac35bcac20fec1d', '1', '2019-05-12 18:30:21', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('82d7a8ed2b8a4d3d94ef14b4bd98da3e', '夫人之相与，俯仰一世，或取诸怀抱，悟言一室之内；或因寄所托，放浪形骸之外。虽趣舍万殊，静躁不同，当其欣于所遇，暂得于己，快然自足，不知老之将至。及其所之既倦，情随事迁，感慨系之矣。向之所欣，俯仰之间，已为陈迹，犹不能不以之兴怀。况修短随化，终期于尽。古人云：“死生亦大矣。”岂不痛哉！(不知老之将至 一作：曾不知老之将至)', '8e20ed1dc3084825800957a89d2061d2', '8e914e14e2774172bac35bcac20fec1d', '1', '2019-05-12 18:38:55', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('887844d7ae3649589339042b04287583', '六国破灭，非兵不利 ，战不善，弊在赂秦。赂秦而力亏，破灭之道也。或曰：六国互丧，率赂秦耶？曰：不赂者以赂者丧，盖失强援，不能独完。故曰：弊在赂秦也。', '8e20ed1dc3084825800957a89d2061d2', 'a996e5be251a4d578806bac22739b1a7', '02da9663f04646a2a3fc6868be920c65', '2019-05-12 17:57:34', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('8e914e14e2774172bac35bcac20fec1d', '我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？', '8e20ed1dc3084825800957a89d2061d2', NULL, '1', '2019-05-12 00:47:09', 40, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('90ddedd3708049c28617e7b8074e44e5', '123', '8e20ed1dc3084825800957a89d2061d2', '887844d7ae3649589339042b04287583', '02da9663f04646a2a3fc6868be920c65', '2019-07-31 17:06:04', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('95d7bfb9bee94e34b1c0509b5d6b8cac', '我们的爱情路只剩下九十九步', '8e20ed1dc3084825800957a89d2061d2', NULL, '1', '2019-05-12 00:47:44', 50, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('9a4cc05db9d079c5b', '曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑', '8e20ed1dc3084825800957a89d2061d2', '1', '1', '2019-05-12 16:30:49', 10, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('a47cc3f39c7544ddbc8fe24b1de59056', '求之不得，寤寐思服。悠哉悠哉，辗转反侧。', '8e20ed1dc3084825800957a89d2061d2', NULL, '02da9663f04646a2a3fc6868be920c65', '2019-05-12 00:48:22', 60, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('a5fcd52ac3a1480ca58d9ec7b215e412', '测试评论1', '8e20ed1dc3084825800957a89d2061d2', NULL, '1', '2020-07-19 01:33:09', 0, '0', '1', '2020-07-19 01:33:09', NULL, NULL);
INSERT INTO `portal_comment` VALUES ('a7ba01cf7a204864a43b2999cfd85833', '参差荇菜，左右芼之。窈窕淑女，钟鼓乐之。', '8e20ed1dc3084825800957a89d2061d2', NULL, '02da9663f04646a2a3fc6868be920c65', '2019-05-12 00:59:37', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('a7d871d575df403898d0603292f16d5c', '123123', '8e20ed1dc3084825800957a89d2061d2', '04591d96601f4b3cbf10bb55c975437f', '1', '2019-07-31 17:23:15', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('a996e5be251a4d578806bac22739b1a7', '123', '8e20ed1dc3084825800957a89d2061d2', '95d7bfb9bee94e34b1c0509b5d6b8cac', '1', '2019-05-12 17:47:43', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('b7624fbf3c894da0bdb54856dedbb035', '六国破灭，非兵不利 ，战不善，弊在赂秦。赂秦而力亏，破灭之道也。或曰：六国互丧，率赂秦耶？曰：不赂者以赂者丧，盖失强援，不能独完。故曰：弊在赂秦也。', '8e20ed1dc3084825800957a89d2061d2', '95d7bfb9bee94e34b1c0509b5d6b8cac', '1', '2019-05-12 18:08:12', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('c7261c9948c84abeb9fbd688b2f02b62', '123', '8e20ed1dc3084825800957a89d2061d2', '887844d7ae3649589339042b04287583', '02da9663f04646a2a3fc6868be920c65', '2019-07-31 17:07:09', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('c8e53a11f5aa4dc4879eed4ce62671c9', '12', '8e20ed1dc3084825800957a89d2061d2', '3950cc3e519b445b8c85aedd60c388f2', '1', '2019-07-31 17:01:51', 0, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('fb1c6d7c0fc94d1', '曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷', '8e20ed1dc3084825800957a89d2061d2', '', '1', '2019-05-12 16:30:11', 20, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('fb1c6d7c0fc94d19a4cc05db9d079c5b', '参差荇菜，左右流之。窈窕淑女，寤寐求之。', '8e20ed1dc3084825800957a89d2061d2', NULL, '02da9663f04646a2a3fc6868be920c65', '2019-05-12 00:51:04', 70, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_comment` VALUES ('fb47aae25b0f41f08ac020024469496f', '秦以攻取之外，小则获邑，大则得城。较秦之所得，与战胜而得者，其实百倍；诸侯之所亡，与战败而亡者，其实亦百倍。则秦之所大欲，诸侯之所大患，固不在战矣。思厥先祖父，暴霜露，斩荆棘，以有尺寸之地。子孙视之不甚惜，举以予人，如弃草芥。今日割五城，明日割十城，然后得一夕安寝。起视四境，而秦兵又至矣。然则诸侯之地有限，暴秦之欲无厌，奉之弥繁，侵之愈急。故不战而强弱胜负已判矣。至于颠覆，理固宜然。古人云：“以地事秦，犹抱薪救火，薪不尽，火不灭。”此言得之。', '8e20ed1dc3084825800957a89d2061d2', '95d7bfb9bee94e34b1c0509b5d6b8cac', '1', '2020-04-22 18:17:20', 0, '1', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for portal_iamge
-- ----------------------------
DROP TABLE IF EXISTS `portal_iamge`;
CREATE TABLE `portal_iamge`  (
  `iamge_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `image_url` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片路径',
  `image_description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片描述',
  `iamge_belong` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片所属',
  PRIMARY KEY (`iamge_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for portal_im_message
-- ----------------------------
DROP TABLE IF EXISTS `portal_im_message`;
CREATE TABLE `portal_im_message`  (
  `im_message_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `receive_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接收人',
  `receive_time` datetime(0) DEFAULT NULL COMMENT '接收时间',
  `send_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送人id',
  `send_time` datetime(0) DEFAULT NULL COMMENT '发送时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送内容',
  `message_type` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型 1：回复 2：@ 3：赞 4：系统 5：私信 6：我的消息',
  `read_status` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '1 已读 0 未读',
  PRIMARY KEY (`im_message_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for portal_log
-- ----------------------------
DROP TABLE IF EXISTS `portal_log`;
CREATE TABLE `portal_log`  (
  `log_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日志id',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `request_method` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求方式',
  `request_path` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求路径',
  `method_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求方法名称',
  `request_params` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '请求参数',
  `ip_address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求ip地址',
  `operating_time` datetime(0) DEFAULT NULL COMMENT '操作时间',
  `result_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '结果（1： 成功 ；0：失败）',
  `result_operation` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '结果描述',
  `time_consuming` int(11) DEFAULT NULL COMMENT '消耗时间',
  `operating_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台系统操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_log
-- ----------------------------
INSERT INTO `portal_log` VALUES ('0006cf1f7fe240fd8a7699524b615d2b', '分页查询文章信息', 'GET', '/portal/article/query', 'com.blog.core.article.controller.PortalArticleController.queryArticleByPage()', NULL, '127.0.0.1', '2019-10-27 22:56:19', '成功', '成功返回', 0, NULL);
INSERT INTO `portal_log` VALUES ('4fe1a71e90a44c2bb9dc0a59ec166f23', '分页查询文章信息', 'GET', '/portal/article/query', 'com.blog.core.article.controller.PortalArticleController.queryArticleByPage()', NULL, '127.0.0.1', '2019-10-27 22:56:39', '成功', '成功返回', 0, NULL);
INSERT INTO `portal_log` VALUES ('631f74ac9d8d45668daa866245befe83', '分页查询文章信息', 'GET', '/portal/article/query', 'com.blog.core.article.controller.PortalArticleController.queryArticleByPage()', NULL, '127.0.0.1', '2019-10-27 22:58:37', '成功', '成功返回', 0, NULL);
INSERT INTO `portal_log` VALUES ('a7a51318bc7c45ec8d2641b440de6c22', '分页查询文章信息', 'GET', '/portal/article/query', 'com.blog.core.article.controller.PortalArticleController.queryArticleByPage()', NULL, '127.0.0.1', '2019-10-27 22:56:12', '成功', '成功返回', 10, NULL);
INSERT INTO `portal_log` VALUES ('cd7d98959e224bc9925d89f23e6d790d', '分页查询文章信息', 'GET', '/portal/article/query', 'com.blog.core.article.controller.PortalArticleController.queryArticleByPage()', NULL, '127.0.0.1', '2019-10-20 15:54:19', '成功', '成功返回', 0, NULL);
INSERT INTO `portal_log` VALUES ('fd9e0f84228a4f36835cce5331ff1ccd', '分页查询文章信息', 'GET', '/portal/article/query', 'com.blog.core.article.controller.PortalArticleController.queryArticleByPage()', NULL, '127.0.0.1', '2019-10-20 15:45:47', '失败', '\r\n### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Table \'blog.sys_base_tag\' doesn\'t exist\r\n### The error may exist in file [D:\\Users\\myBlog\\blog\\free-blog\\free-blog-portal\\target\\classes\\mapper\\tag\\PortalTagMapper.xml]\r\n### The error may involve com.blog.core.tag.dao.PortalTagMapper.selectTagByArticleId-Inline\r\n### The error occurred while setting parameters\r\n### SQL: SELECT             tag.id,             tag.tag_name tagName,             tag.tag_category_id,             tag.create_time createTime         FROM             sys_base_tag tag             LEFT JOIN sys_base_article_tag sbat ON tag.id = sbat.tag_id             LEFT JOIN sys_base_article article ON article.id = sbat.article_id         WHERE article.id = ?         ORDER BY tag.create_time DESC\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Table \'blog.sys_base_tag\' doesn\'t exist\n; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Table \'blog.sys_base_tag\' doesn\'t exist', 0, NULL);

-- ----------------------------
-- Table structure for portal_menu
-- ----------------------------
DROP TABLE IF EXISTS `portal_menu`;
CREATE TABLE `portal_menu`  (
  `menu_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单code',
  `parent_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单父code',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `web_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '返回给前端的标识（如新增 add）',
  `menu_url` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'url地址',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'icon',
  `menu_sort` int(10) DEFAULT NULL COMMENT '菜单排序号(越小在前面)',
  `menu_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单或按钮(MENU :菜单，BUTTON：按钮)',
  `perms` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限标识',
  `enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '状态(0:停用;1:启用)',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`menu_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_menu
-- ----------------------------
INSERT INTO `portal_menu` VALUES ('0180e48befdc4f5ba8fedc84d834714d', 'bb6438503ab5490199e9e5949dc58888', '后台操作日志', 'string', 'operation/managelog', 'wulianwang', 2, '0', NULL, '1', '2019-07-22 12:03:49', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('10396d3cc11941c7b4931b5637eb5a88', '0', '系统管理', '', '', 'config', 2, '0', NULL, '1', '2019-07-14 20:51:32', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('244aa6e940244b6aa8789bac9f6d7d33', 'bb6438503ab5490199e9e5949dc58888', '前台操作日志', 'string', 'operation/portallog', 'wulianwang-', 1, '0', NULL, '1', '2019-07-22 14:35:42', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('3a4576442e7e4a4181f3257539c2274d', 'b41f1ca52d404944ae03497b033e5378', '博文列表', '', '/portal/article/query', 'list', 1, '1', NULL, '1', '2019-07-14 21:00:45', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('3fcf1e63c6e34fe3acd9431ee9fc34a4', 'b41f1ca52d404944ae03497b033e5378', '新增博文', '', 'article/article-add-or-update', 'add', 0, '1', NULL, '1', '2019-07-14 21:01:15', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('4b32fcb4f6a442f9a00d49c9bfd27537', '0', '相册', 'string', 'string', 'image', 10, '0', NULL, '1', '2019-06-29 10:41:41', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('5a1c74a1ac7c42ac92de23c700860749', '0', '视频', 'string', 'string', 'config', 11, '0', NULL, '1', '2019-06-29 10:41:47', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('79613f0e27084a4f8ad8f10418614fe2', '0', '文章', 'string', 'string', 'config', 8, '0', NULL, '1', '2019-06-29 10:41:28', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('a5a7983e82324eb8841453e3991f85c6', '0', '心情', 'string', 'string', 'config', 9, '0', NULL, '1', '2019-06-29 10:41:36', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('b41f1ca52d404944ae03497b033e5378', '0', '博文管理', '', '', 'article', 1, '0', NULL, '1', '2019-07-14 21:00:03', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('bb6438503ab5490199e9e5949dc58888', '0', '日志管理', '', '', 'rizhi', 3, '0', NULL, '1', '2019-07-22 12:03:36', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('be19194325ec4f1597ff7b3e3da01e6b', '10396d3cc11941c7b4931b5637eb5a88', '角色管理', '', 'sys/role', 'admin', 0, '1', NULL, '1', '2019-07-14 20:57:04', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('e0ec81922b7c42378273dd2a452c447b', '10396d3cc11941c7b4931b5637eb5a88', '管理员列表', '', 'sys/user', 'admin', 0, '1', NULL, '1', '2019-07-14 20:56:06', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('e6ccb87ffb1940adbfdb09fdd3ae4f70', '10396d3cc11941c7b4931b5637eb5a88', '菜单管理', '', 'sys/menu', 'menu', 0, '1', NULL, '1', '2019-07-14 20:57:26', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('e6ccb87ffb7840adbf123db09fdd34df', 'e6ccb87ffb7840adbfag09fdd3ae4f70', '标签', NULL, 'operation/tag', 'menu', 1, '1', NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `portal_menu` VALUES ('e6ccb87ffb7840adbfag09fdd3ae4f70', '0', '标签管理', NULL, NULL, 'menu', 0, '0', NULL, '1', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for portal_role
-- ----------------------------
DROP TABLE IF EXISTS `portal_role`;
CREATE TABLE `portal_role`  (
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `role_describe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色编号',
  `enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '启用/停用',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_role
-- ----------------------------
INSERT INTO `portal_role` VALUES ('36c9ae4c53ed41519aa6a67f36d55654', '管理员', '12312', 'ROLE_ADMIN', '0', '2019-12-22 23:30:57', '2019-12-22 23:30:57', '0c3740672f6a4afbaa1af705e4b66c47', 'null');
INSERT INTO `portal_role` VALUES ('36c9ae4c53ed41519aa6a67f36d5565a', 'admin', '所有权限', 'ROLE_ADMIN', '1', '2019-12-22 23:31:36', '2019-12-22 23:31:36', '0c3740672f6a4afbaa1af705e4b66c47', 'null');
INSERT INTO `portal_role` VALUES ('86548586a46f422aa6f9e702bbbd04c5', '123', '123', '123', '1', '2019-07-22 13:41:21', '2019-07-22 13:41:21', '0c3740672f6a4afbaa1af705e4b66c47', NULL);

-- ----------------------------
-- Table structure for portal_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `portal_role_menu`;
CREATE TABLE `portal_role_menu`  (
  `role_menu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色id',
  `menu_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单id',
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_role_menu
-- ----------------------------
INSERT INTO `portal_role_menu` VALUES ('16b8bd029cf2484aaef1ccbcad917c7f', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb1ac1', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('3ce9e9a11c654672a0ead83b57d02b13', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb2ac2', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('47dc414cd1c9491d8c3719e1981b2b45', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb3ac3', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('5c9517d438934b4db37ab9772c01fe96', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb4ac4', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('786879d1901e4685b0f1e24ebe271abf', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb5ac5', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('81c40ff8ac6d46808f5cae70a1c575f0', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb5ac6', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('92d8fdb358da4e7da27586fd1811d0f7', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb5ac7', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('9b714f1547974ce0956acc48d0ce71f3', '36c9ae4c53ed41519aa6a67f36d5565a', '79613f0e27084a4f8ad8f10418614fe2', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('af8df698eff04a3bb53f8b01a17ec44c', '36c9ae4c53ed41519aa6a67f36d5565a', 'be19194325ec4f1597ff7b3e3da01e6b', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('d32c92c0c12b4bc7961fa94fb1728a74', '36c9ae4c53ed41519aa6a67f36d5565a', 'e0ec81922b7c42378273dd2a452c447b', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('ddb6074a02fd49b5bd33651732e0b2e4', '36c9ae4c53ed41519aa6a67f36d5565a', '244aa6e940244b6aa8789bac9f6d7d33', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('e8799e83df8d4008b161e0574012ee0f', '36c9ae4c53ed41519aa6a67f36d5565a', '10396d3cc11941c7b4931b5637eb5a88', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('f06276c512a14e60b3d380423398945d', '36c9ae4c53ed41519aa6a67f36d5565a', 'b41f1ca52d404944ae03497b033e5378', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('f06asd76c512a14e60b3d3804233945d', '36c9ae4c53ed41519aa6a67f36d5565a', 'e6ccb87ffb7840adbf123db09fdd34df', NULL, NULL, NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('fc79b1191ad0435d8acc27e0v5160cb2', '36c9ae4c53ed41519aa6a67f36d5565a', 'e6ccb87ffb7840adbfdb09fdd3ae4f70', NULL, NULL, NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('fc79b1191ad044d8acc27e0d5160cb2e', '36c9ae4c53ed41519aa6a67f36d5565a', '5a1c74a1ac7c42ac92de23c700860749', 'null', '2019-07-23 16:31:00', NULL, NULL);
INSERT INTO `portal_role_menu` VALUES ('fc79b1191ad044d8acc27e0v5160cb2e', '36c9ae4c53ed41519aa6a67f36d5565a', '244aa6e940244b6aa8789bac9f6d7d33', NULL, '2019-07-23 16:33:48', NULL, NULL);

-- ----------------------------
-- Table structure for portal_tag
-- ----------------------------
DROP TABLE IF EXISTS `portal_tag`;
CREATE TABLE `portal_tag`  (
  `tag_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tag_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签名称',
  `tag_category_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签所属类别',
  `enable` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '启用/禁用',
  `create_time` datetime(0) DEFAULT NULL COMMENT '創建時間',
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_tag
-- ----------------------------
INSERT INTO `portal_tag` VALUES ('7fc67dd5f442406986c787898e952e5e', 'linux', NULL, '1', '2019-07-25 14:03:46', 'null', NULL, NULL);
INSERT INTO `portal_tag` VALUES ('851c42c8507145b5a69bc743feefec5b', 'spring boot', NULL, '1', '2019-07-25 14:03:04', 'null', NULL, NULL);
INSERT INTO `portal_tag` VALUES ('b6ccb2bb7efb4d73b7466fd4d1521820', 'Java', NULL, '1', '2019-07-25 14:02:49', 'null', NULL, NULL);

-- ----------------------------
-- Table structure for portal_user
-- ----------------------------
DROP TABLE IF EXISTS `portal_user`;
CREATE TABLE `portal_user`  (
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆密码',
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '盐',
	  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `last_login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆ip',
  `last_login_time` datetime(0) DEFAULT NULL COMMENT '上一次登陆时间',
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个性签名',
  `attention_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关注的用户id',
  `enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '停用/启用（0，停用；1，启用）',
	`create_time` datetime(0) DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改日期',
  `create_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_user
-- ----------------------------
INSERT INTO `portal_user` VALUES ('8e20ed1dc3084825800957a89d2061d2', 'admin', '$2a$10$Q2ky3hZ8o92f0RhgHGC8RumuaOvKxevSR7HFpjxCYIRe7D0z/7Gvu', 'PiMMmezOxBmDa2zvWF4E', '1','超级管理员', 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png', '12131412', '12345@1363.com', '127.0.0.1', '2019-07-22 13:42:54', '个性签名',  '1', '1', '2019-07-22 13:42:54', NULL, '1', '1');

-- ----------------------------
-- Table structure for portal_user_attention
-- ----------------------------
DROP TABLE IF EXISTS `portal_user_attention`;
CREATE TABLE `portal_user_attention`  (
  `attention_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户关注id',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `attention_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关注的用户id',
  `attention_time` datetime(0) NOT NULL COMMENT '关注时间',
  `c_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间（数据库自己维护）',
  `u_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间（数据库自己维护）',
  PRIMARY KEY (`attention_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户关注信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for portal_user_role
-- ----------------------------
DROP TABLE IF EXISTS `portal_user_role`;
CREATE TABLE `portal_user_role`  (
  `user_role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户id',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_user_role
-- ----------------------------
INSERT INTO `portal_user_role` VALUES ('50d2aba60d004998bb8bd1295fae6d33', '36c9ae4c53ed41519aa6a67f36d5565a', '8e20ed1dc3084825800957a89d2061d2', '0c3740672f6a4afbaa1af705e4b66c47', '2019-07-17 18:00:39', NULL, NULL);

-- ----------------------------
-- Table structure for sys_oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_oauth_client_details`;
CREATE TABLE `sys_oauth_client_details`  (
  `client_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键，用于唯一标识每一个客户端(client)',
  `resource_ids` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户端所能访问的资源id集合,多个资源时用逗号(,)分隔,如: \"unity-resource,mobile-resource\".',
  `client_secret` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用于指定客户端(client)的访问密匙',
  `scope` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '指定客户端申请的权限范围,可选值包括read,write,trust;',
  `authorized_grant_types` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '指定客户端支持的grant_type,可选值包括authorization_code,password,refresh_token,implicit,client_credentials,',
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户端的重定向URI,可为空',
  `authorities` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '指定客户端所拥有的Spring Security的权限值,可选',
  `access_token_validity` int(11) DEFAULT NULL COMMENT '设定客户端的access_token的有效时间值(单位:秒),',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT '设定客户端的refresh_token的有效时间值(单位:秒),可选,',
  `additional_information` varchar(4096) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '这是一个预留的字段,在Oauth的流程中没有实际的使用,可选',
  `autoapprove` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设置用户是否自动Approval操作',
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oauth_client_details
-- ----------------------------
INSERT INTO `sys_oauth_client_details` VALUES ('freeBlog', NULL, '$2a$10$CwIutywnbs9bifHaY3Ezu.gYkWi4Zano8gVPq08hXjal6.uj.Yzuy', 'sever', 'password,refresh_token,authorization_code,implicit,mobile', NULL, NULL, NULL, NULL, NULL, 'true');

SET FOREIGN_KEY_CHECKS = 1;
