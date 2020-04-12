/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 02/04/2020 00:10:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for manage_article
-- ----------------------------
DROP TABLE IF EXISTS `manage_article`;
CREATE TABLE `manage_article`  (
  `article_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  `article_title` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章标题',
  `article_release_date` datetime(6) DEFAULT NULL COMMENT '发布日期',
  `article_content_html` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容-html',
  `article_content_markdown` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容-markdown',
  `article_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发表文章的作者ID',
  `article_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '文章状态（0 草稿 2 待审核 4 审核中 6 审核成功）',
  `article_release_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '发布状态（0 未发布 1 已发布）',
  `article_images` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章图片',
  `article_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '文章类型',
  `article_top_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '置顶状态 0 未置顶 1 已置顶',
  `article_comment_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '评论开启状态 0 未开启 1 已开启',
  `article_fine_note_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '是否精帖 0 不是精帖 1 是精帖',
  `comments_number` bigint(20) DEFAULT 0 COMMENT '评论数',
  `approves_number` bigint(20) DEFAULT 0 COMMENT '点赞数',
  `like_number` bigint(20) DEFAULT 0 COMMENT '喜欢数',
  `read_number` bigint(20) DEFAULT 0 COMMENT '浏览数',
  `is_enable` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '停用/启用 0 停用 1 启用',
  `create_time` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime(6) DEFAULT NULL COMMENT '修改时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_article
-- ----------------------------
INSERT INTO `manage_article` VALUES ('1', '当爱情只剩下一百步', '2020-02-10 17:51:37.000000', '<blockquote><p><i>当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。我们竟哈哈大笑。</i></p></blockquote>\\r\\n', NULL, '1', '0', '0', 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', '0', '0', '0', '0', 0, 0, 0, 0, '1', '2020-02-10 17:52:23.000000', '8e20ed1dc3084825800957a89d2061d2', NULL, NULL);

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
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `article_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tag_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
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
  `is_enable` int(10) DEFAULT NULL,
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
  `is_parent` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否为父级',
  `comment_time` datetime(0) DEFAULT NULL COMMENT '评论时间',
  `approves` bigint(20) DEFAULT 0 COMMENT '点赞数',
  `is_enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '是否删除',
  `create_time` datetime(0) DEFAULT NULL,
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_comment
-- ----------------------------
INSERT INTO `manage_comment` VALUES ('1', '当我走出第一步，有一种叫悲哀的东西漫过心底', '8e20ed1dc3084825800957a89d2061d2', NULL, '1', '0', '2019-05-11 23:28:40', 10, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('12312', '齐人未尝赂秦，终继五国迁灭，何哉？与嬴而不助五国也。五国既丧，齐亦不免矣。燕赵之君，始有远略，能守其土，义不赂秦。是故燕虽小国而后亡，斯用兵之效也。至丹以荆卿为计，始速祸焉。赵尝五战于秦，二败而三胜。后秦击赵者再，李牧连却之。洎牧以谗诛，邯郸为郡，惜其用武而不终也。且燕赵处秦革灭殆尽之际，可谓智力孤危，战败而亡，诚不得已。向使三国各爱其地，齐人勿附于秦，刺客不行，良将犹在，则胜负之数，存亡之理，当与秦相较，或未易量。', '8e20ed1dc3084825800957a89d2061d2', '1', '1', '1', '2019-05-12 18:26:10', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('1a4d47163a5a486b88cd8648205a21e0', '我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？', '8e20ed1dc3084825800957a89d2061d2', NULL, '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-05-12 00:49:08', 20, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('20d5fe3c2cba410780a5f2299cc420f5', '123123', 'null', '04591d96601f4b3cbf10bb55c975437f', '1', '0', '2019-07-31 17:17:15', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('30901f28494049d8b8705b4dcf536571', '关关雎鸠，在河之洲。窈窕淑女，君子好逑。', '8e20ed1dc3084825800957a89d2061d2', NULL, '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-05-12 00:50:51', 30, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('3950cc3e519b445b8c85aedd60c388f2', '这个是回复', 'null', '04591d96601f4b3cbf10bb55c975437f', '1', '0', '2019-07-31 16:42:22', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('3b0732c1644e4e098e697cc164946515', '123', 'null', 'fb1c6d7c0fc94d1', '1', '0', '2019-07-31 17:48:32', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('49b2e394839b4f9d95ea38ed8536da51', '123', 'null', 'fb1c6d7c0fc94d1', '1', '0', '2019-07-31 16:44:23', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('5d5135dd339647c88836a2f4683eaabc', '是日也，天朗气清，惠风和畅，仰观宇宙之大，俯察品类之盛，所以游目骋怀，足以极视听之娱，信可乐也。', '8e20ed1dc3084825800957a89d2061d2', '8e914e14e2774172bac35bcac20fec1d', '1', '1', '2019-05-12 18:31:47', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('5e4e6906582f45b5932e5b1c6dbb2bb9', '123', 'null', '887844d7ae3649589339042b04287583', '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-07-31 17:06:16', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('5fb5b8922e8844d8bb9b8d1bef093cc5', '曾几何时', 'null', 'fb1c6d7c0fc94d1', '1', '0', '2019-07-31 17:48:38', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('6a6eda7bdf7542f386a7fbddd6e75ded', '参差荇菜，左右采之。窈窕淑女，琴瑟友之。', '8e20ed1dc3084825800957a89d2061d2', NULL, '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-05-12 00:51:32', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('6b5fd9c23ebb4cbb8b6155c9d3e9f6fd', '永和九年，岁在癸丑，暮春之初，会于会稽山阴之兰亭，修禊事也。群贤毕至，少长咸集。此地有崇山峻岭，茂林修竹；又有清流激湍，映带左右，引以为流觞曲水，列坐其次。虽无丝竹管弦之盛，一觞一咏，亦足以畅叙幽情。', '8e20ed1dc3084825800957a89d2061d2', '8e914e14e2774172bac35bcac20fec1d', '1', '1', '2019-05-12 18:30:21', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('82d7a8ed2b8a4d3d94ef14b4bd98da3e', '夫人之相与，俯仰一世，或取诸怀抱，悟言一室之内；或因寄所托，放浪形骸之外。虽趣舍万殊，静躁不同，当其欣于所遇，暂得于己，快然自足，不知老之将至。及其所之既倦，情随事迁，感慨系之矣。向之所欣，俯仰之间，已为陈迹，犹不能不以之兴怀。况修短随化，终期于尽。古人云：“死生亦大矣。”岂不痛哉！(不知老之将至 一作：曾不知老之将至)', '8e20ed1dc3084825800957a89d2061d2', '8e914e14e2774172bac35bcac20fec1d', '1', '1', '2019-05-12 18:38:55', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('887844d7ae3649589339042b04287583', '六国破灭，非兵不利 ，战不善，弊在赂秦。赂秦而力亏，破灭之道也。或曰：六国互丧，率赂秦耶？曰：不赂者以赂者丧，盖失强援，不能独完。故曰：弊在赂秦也。', '8e20ed1dc3084825800957a89d2061d2', 'a996e5be251a4d578806bac22739b1a7', '06b71ff5cb46438ca38e9b5e9a155779', '1', '2019-05-12 17:57:34', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('8e914e14e2774172bac35bcac20fec1d', '我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？', '8e20ed1dc3084825800957a89d2061d2', NULL, '1', '0', '2019-05-12 00:47:09', 40, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('90ddedd3708049c28617e7b8074e44e5', '123', 'null', '887844d7ae3649589339042b04287583', '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-07-31 17:06:04', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('95d7bfb9bee94e34b1c0509b5d6b8cac', '我们的爱情路只剩下九十九步', '8e20ed1dc3084825800957a89d2061d2', NULL, '1', '0', '2019-05-12 00:47:44', 50, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('9a4cc05db9d079c5b', '曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑', '8e20ed1dc3084825800957a89d2061d2', '1', '1', '1', '2019-05-12 16:30:49', 10, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('a47cc3f39c7544ddbc8fe24b1de59056', '求之不得，寤寐思服。悠哉悠哉，辗转反侧。', '8e20ed1dc3084825800957a89d2061d2', NULL, '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-05-12 00:48:22', 60, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('a7ba01cf7a204864a43b2999cfd85833', '参差荇菜，左右芼之。窈窕淑女，钟鼓乐之。', '8e20ed1dc3084825800957a89d2061d2', NULL, '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-05-12 00:59:37', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('a7d871d575df403898d0603292f16d5c', '123123', 'null', '04591d96601f4b3cbf10bb55c975437f', '1', '0', '2019-07-31 17:23:15', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('a996e5be251a4d578806bac22739b1a7', '123', '8e20ed1dc3084825800957a89d2061d2', '95d7bfb9bee94e34b1c0509b5d6b8cac', '1', '1', '2019-05-12 17:47:43', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('b7624fbf3c894da0bdb54856dedbb035', '六国破灭，非兵不利 ，战不善，弊在赂秦。赂秦而力亏，破灭之道也。或曰：六国互丧，率赂秦耶？曰：不赂者以赂者丧，盖失强援，不能独完。故曰：弊在赂秦也。', '8e20ed1dc3084825800957a89d2061d2', '95d7bfb9bee94e34b1c0509b5d6b8cac', '1', '1', '2019-05-12 18:08:12', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('c7261c9948c84abeb9fbd688b2f02b62', '123', 'null', '887844d7ae3649589339042b04287583', '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-07-31 17:07:09', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('c8e53a11f5aa4dc4879eed4ce62671c9', '12', 'null', '3950cc3e519b445b8c85aedd60c388f2', '1', '0', '2019-07-31 17:01:51', 0, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('fb1c6d7c0fc94d1', '曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷', '8e20ed1dc3084825800957a89d2061d2', '1', '1', '1', '2019-05-12 16:30:11', 20, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('fb1c6d7c0fc94d19a4cc05db9d079c5b', '参差荇菜，左右流之。窈窕淑女，寤寐求之。', '8e20ed1dc3084825800957a89d2061d2', NULL, '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-05-12 00:51:04', 70, '1', NULL, NULL);
INSERT INTO `manage_comment` VALUES ('fb47aae25b0f41f08ac020024469496f', '秦以攻取之外，小则获邑，大则得城。较秦之所得，与战胜而得者，其实百倍；诸侯之所亡，与战败而亡者，其实亦百倍。则秦之所大欲，诸侯之所大患，固不在战矣。思厥先祖父，暴霜露，斩荆棘，以有尺寸之地。子孙视之不甚惜，举以予人，如弃草芥。今日割五城，明日割十城，然后得一夕安寝。起视四境，而秦兵又至矣。然则诸侯之地有限，暴秦之欲无厌，奉之弥繁，侵之愈急。故不战而强弱胜负已判矣。至于颠覆，理固宜然。古人云：“以地事秦，犹抱薪救火，薪不尽，火不灭。”此言得之。', '8e20ed1dc3084825800957a89d2061d2', '95d7bfb9bee94e34b1c0509b5d6b8cac', '1', '1', '2019-05-12 18:17:20', 0, '1', NULL, NULL);

-- ----------------------------
-- Table structure for manage_iamge
-- ----------------------------
DROP TABLE IF EXISTS `manage_iamge`;
CREATE TABLE `manage_iamge`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `image_url` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片路径',
  `image_description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片描述',
  `iamge_belong` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片所属',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manage_im_message
-- ----------------------------
DROP TABLE IF EXISTS `manage_im_message`;
CREATE TABLE `manage_im_message`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `receive_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接收人',
  `receive_time` datetime(0) DEFAULT NULL COMMENT '接收时间',
  `send_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送人id',
  `send_time` datetime(0) DEFAULT NULL COMMENT '发送时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送内容',
  `message_type` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型 1：回复 2：@ 3：赞 4：系统 5：私信 6：我的消息',
  `read_status` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '1 已读 0 未读',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `result_operation` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '结果描述',
  `time_consuming` int(11) DEFAULT NULL COMMENT '消耗时间',
  `operating_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台系统操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_log
-- ----------------------------
INSERT INTO `manage_log` VALUES ('20200231020000000000000000000025', '分页查询后台系统操作日志信息', 'GET', '/log/all', 'com.blog.core.log.controller.ManageLogController.queryLogByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 02:35:19', '成功', '成功返回', 4, NULL);
INSERT INTO `manage_log` VALUES ('20200231020000000000000000000026', '分页查询后台系统操作日志信息', 'GET', '/log/all', 'com.blog.core.log.controller.ManageLogController.queryLogByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 02:35:22', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231020000000000000000000027', '分页查询后台系统操作日志信息', 'GET', '/log/all', 'com.blog.core.log.controller.ManageLogController.queryLogByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 02:39:01', '成功', '成功返回', 3, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231020000000000000000000028', '分页查询后台系统操作日志信息', 'GET', '/log/all', 'com.blog.core.log.controller.ManageLogController.queryLogByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 02:40:27', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231020000000000000000000029', '分页查询后台系统操作日志信息', 'GET', '/log/all', 'com.blog.core.log.controller.ManageLogController.queryLogByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 02:40:36', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231020000000000000000000030', '分页查询后台系统操作日志信息', 'GET', '/log/all', 'com.blog.core.log.controller.ManageLogController.queryLogByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 02:45:12', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231020000000000000000000031', '分页查询后台系统操作日志信息', 'GET', '/log/all', 'com.blog.core.log.controller.ManageLogController.queryLogByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 02:45:21', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231110000000000000000000032', '分页查询后台系统操作日志信息', 'GET', '/log/all', 'com.blog.core.log.controller.ManageLogController.queryLogByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 11:37:12', '成功', '成功返回', 2, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231130000000000000000000033', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 13:17:55', '失败', NULL, 5, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231130000000000000000000034', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 13:17:55', '失败', NULL, 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000035', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:47:36', '成功', '成功返回', 15, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000036', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:47:37', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000037', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:55:39', '成功', '成功返回', 2, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000038', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:55:39', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000039', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:56:33', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000040', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:56:33', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000041', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:56:47', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000042', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:56:47', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000043', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:56:50', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000044', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:56:51', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000045', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:57:45', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000046', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:57:45', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000047', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:57:59', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000048', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:57:59', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000049', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:58:02', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000050', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:58:02', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000051', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:58:36', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000052', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:58:36', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000053', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:58:40', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000054', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:58:40', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000055', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:59:31', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000056', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:59:31', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231140000000000000000000057', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 14:59:33', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000058', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:01:26', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000059', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:01:26', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000060', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:07:23', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000061', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:07:23', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000062', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:10:32', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000063', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:11:54', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000064', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:11:54', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000065', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:13:03', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000066', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:14:18', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000067', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:14:20', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000068', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:14:20', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000069', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:14:22', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000070', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:14:23', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000071', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:14:24', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000072', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:14:29', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000073', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:14:29', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000074', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:18:18', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000075', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:31:15', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231150000000000000000000076', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 15:31:15', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000077', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:03:33', '成功', '成功返回', 6, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000078', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:06:29', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000079', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:18:03', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000080', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:18:03', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000081', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:18:08', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000082', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:18:15', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000083', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:20:58', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000084', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:21:06', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000085', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:21:19', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000086', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:21:30', '失败', NULL, 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000087', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:21:30', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000088', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:21:30', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000089', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:21:38', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000090', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:22:02', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000091', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:22:23', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000092', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:22:23', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000093', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:22:32', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000094', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:22:32', '失败', NULL, 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000095', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:22:32', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000096', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:22:35', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000097', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:23:22', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000098', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:27:18', '成功', '成功返回', 9, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000099', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:30:27', '失败', NULL, 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000100', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:30:27', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000101', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:30:27', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000102', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:30:29', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000103', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:30:29', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231160000000000000000000104', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 16:30:42', '成功', '成功返回', 0, '8e20ed1dc3084825800957a89d2061d2');
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000105', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:39:17', '成功', '成功返回', 3, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000106', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:39:58', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000107', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:40:06', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000108', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:41:44', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000109', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:42:31', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000110', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:42:40', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000111', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:46:35', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000112', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:48:32', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000113', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:48:57', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000114', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:53:50', '成功', '成功返回', 3, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000115', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:54:12', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000116', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:54:12', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000117', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:54:12', '成功', '成功返回', 1, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000118', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:54:45', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000119', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:54:50', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000120', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:54:50', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200231230000000000000000000121', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-03-31 23:54:51', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301000000000000000000000122', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 00:23:58', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301000000000000000000000123', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 00:23:58', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301000000000000000000000124', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 00:23:58', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301010000000000000000000125', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 01:15:10', '成功', '成功返回', 3, NULL);
INSERT INTO `manage_log` VALUES ('20200301010000000000000000000126', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 01:15:10', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301010000000000000000000127', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 01:15:11', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301010000000000000000000128', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 01:15:11', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301010000000000000000000129', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 01:15:16', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301100000000000000000000125', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 10:25:01', '成功', '成功返回', 3, NULL);
INSERT INTO `manage_log` VALUES ('20200301100000000000000000000126', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 10:25:46', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301100000000000000000000127', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 10:28:19', '成功', '成功返回', 5, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000128', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:08', '成功', '成功返回', 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000129', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:12', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000130', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:12', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000131', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:12', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000132', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:24', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000133', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:26', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000134', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:26', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000135', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:26', '成功', '成功返回', 1, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000136', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:45', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000137', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:45', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000138', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:48', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000139', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:50', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000140', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:50', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000141', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:07:50', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000142', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:10:27', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000143', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:10:27', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000144', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:10:27', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000145', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:12:08', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000146', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:12:08', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000147', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:12:08', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000148', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:12:55', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000149', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:12:55', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000150', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:12:55', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000151', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:13:02', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000152', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:13:03', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000153', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:13:03', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000154', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:17:04', '失败', NULL, 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000155', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:17:05', '成功', '成功返回', 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000156', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:17:05', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000157', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:17:17', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000158', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:17:19', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000159', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:17:22', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000160', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:17:26', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000161', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:17:30', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000162', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:17:33', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000163', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:17:38', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000164', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:17:41', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000165', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:21:37', '成功', '成功返回', 3, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000166', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:21:46', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000167', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:21:49', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000168', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:22:01', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000169', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:22:05', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000170', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:25:27', '成功', '成功返回', 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000171', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:25:51', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000172', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:25:58', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000173', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:27:27', '成功', '成功返回', 3, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000174', '分页查询菜单信息', 'GET', '/api/menu/all', 'com.blog.core.system.menu.controller.ManageMenuController.queryManageMenuByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:29:23', '成功', '成功返回', 4, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000175', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:29:41', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000176', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:29:41', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000177', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:29:41', '成功', '成功返回', 1, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000178', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:29:44', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000179', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:30:03', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000180', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:30:52', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000181', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:32:00', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000182', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:33:23', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000183', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:33:23', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000184', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:33:23', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000185', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:33:24', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000186', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:37:12', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000187', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:37:13', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000188', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:37:13', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000189', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:37:14', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000190', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:37:14', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000191', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:37:38', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000192', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:37:39', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000193', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:37:44', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000194', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:37:44', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000195', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:37:44', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000196', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:37:45', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000197', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:37:45', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000198', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:38:31', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000199', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:38:31', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000200', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:38:39', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000201', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:38:39', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000202', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:43:38', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000203', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:43:38', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000204', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:43:38', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000205', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:47:21', '失败', NULL, 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000206', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:47:21', '成功', '成功返回', 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000207', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:47:22', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000208', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:47:23', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000209', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:47:23', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000210', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO()', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:47:35', '成功', '修改用户信息成功！', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000211', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:47:35', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000212', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:51:14', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000213', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:51:14', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000214', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:51:20', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000215', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:51:20', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000216', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:51:20', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000217', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:51:23', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000218', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:51:23', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000219', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO()', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:51:39', '成功', '修改用户信息成功！', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000220', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:51:39', '成功', '成功返回', 1, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000221', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:53:56', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000222', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:54:01', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000223', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:54:01', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000224', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:54:55', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000225', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:54:55', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000226', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:56:13', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000227', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:56:13', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000228', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:56:13', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000229', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:56:16', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000230', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:56:16', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000231', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:56:20', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000232', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:56:20', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000233', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:56:28', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301110000000000000000000234', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 11:56:28', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000235', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:00:55', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000236', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:00:55', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000237', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:00:55', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000238', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:00:58', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000239', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:00:58', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000240', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:01:26', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000241', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:01:26', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000242', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:01:29', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000243', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:01:32', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000244', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:01:32', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000245', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO()', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:01:41', '成功', '修改用户信息成功！', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000246', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:01:41', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000247', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:12', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000248', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:12', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000249', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:12', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000250', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:20', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000251', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:20', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000252', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:20', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000253', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:22', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000254', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:22', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000255', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:25', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000256', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:25', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000257', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:25', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000258', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:26', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000259', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:27', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000260', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO()', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:31', '成功', '修改用户信息成功！', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000261', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:31', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000262', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:57', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000263', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:03:57', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000264', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:04:02', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000265', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:04:02', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000266', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO()', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:04:05', '成功', '修改用户信息成功！', 1, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000267', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:04:05', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000268', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:07:09', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000269', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:07:09', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000270', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO()', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:07:13', '成功', '修改用户信息成功！', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000271', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:07:13', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000272', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:48:41', '成功', '成功返回', 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000273', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:48:50', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000274', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:48:51', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000275', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:48:51', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000276', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:48:55', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301120000000000000000000277', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 12:48:55', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000278', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d2, userName=admin, nickName=超级管理员, gender=1, telephone=string, email=string@163.com, roles=[ManageRoleIdDTO(roleId=null), ManageRoleIdDTO(roleId=null), ManageRoleIdDTO(roleId=null), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d55654), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d5565a)])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:00:45', '失败', '\r\n### Error updating database.  Cause: java.sql.SQLException: SQL String cannot be empty\r\n### The error may exist in file [E:\\Users\\blog\\free\\free-blog\\free-blog-manage\\target\\classes\\mapper\\system\\user\\ManageUserMapper.xml]\r\n### The error may involve com.blog.core.system.user.dao.ManageUserMapper.updateManageUser\r\n### The error occurred while executing an update\r\n### SQL: \r\n### Cause: java.sql.SQLException: SQL String cannot be empty\n; SQL String cannot be empty; nested exception is java.sql.SQLException: SQL String cannot be empty', 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000279', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:00:46', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000280', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:01:07', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000281', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:01:07', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000282', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:04:49', '失败', NULL, 3, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000283', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:04:50', '成功', '成功返回', 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000284', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d2, userName=admin, nickName=超级管理员, gender=1, telephone=string, email=string@163.com, roles=[ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d55654), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d5565a), ManageRoleIdDTO(roleId=86548586a46f422aa6f9e702bbbd04c5)])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:05:21', '失败', '\r\n### Error updating database.  Cause: java.sql.SQLException: SQL String cannot be empty\r\n### The error may exist in file [E:\\Users\\blog\\free\\free-blog\\free-blog-manage\\target\\classes\\mapper\\system\\user\\ManageUserMapper.xml]\r\n### The error may involve com.blog.core.system.user.dao.ManageUserMapper.updateManageUser\r\n### The error occurred while executing an update\r\n### SQL: \r\n### Cause: java.sql.SQLException: SQL String cannot be empty\n; SQL String cannot be empty; nested exception is java.sql.SQLException: SQL String cannot be empty', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000285', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:05:21', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000286', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:14:03', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000287', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:14:03', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000288', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d2, userName=admin, nickName=超级管理员, gender=1, telephone=string, email=string@163.com, roles=[ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d5565a), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d55654), ManageRoleIdDTO(roleId=86548586a46f422aa6f9e702bbbd04c5)])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:14:22', '失败', '\r\n### Error updating database.  Cause: java.sql.SQLException: SQL String cannot be empty\r\n### The error may exist in file [E:\\Users\\blog\\free\\free-blog\\free-blog-manage\\target\\classes\\mapper\\system\\user\\ManageUserMapper.xml]\r\n### The error may involve com.blog.core.system.user.dao.ManageUserMapper.updateManageUser\r\n### The error occurred while executing an update\r\n### SQL: \r\n### Cause: java.sql.SQLException: SQL String cannot be empty\n; SQL String cannot be empty; nested exception is java.sql.SQLException: SQL String cannot be empty', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000289', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:14:22', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000290', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:16:16', '失败', NULL, 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000291', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:16:17', '成功', '成功返回', 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000292', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d2, userName=admin, nickName=超级管理员, gender=1, telephone=string, email=string@163.com, roles=[ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d55654), ManageRoleIdDTO(roleId=86548586a46f422aa6f9e702bbbd04c5), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d5565a)])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:16:46', '失败', 'nested exception is org.apache.ibatis.reflection.ReflectionException: There is no getter for property named \'gender\' in \'class com.blog.core.system.user.entity.ManageUser\'', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000293', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:16:46', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000294', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:17:51', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000295', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:17:51', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000296', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d2, userName=admin, nickName=超级管理员, gender=1, telephone=string, email=string@163.com, roles=[])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:18:04', '失败', 'nested exception is org.apache.ibatis.reflection.ReflectionException: There is no getter for property named \'gender\' in \'class com.blog.core.system.user.entity.ManageUser\'', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301130000000000000000000297', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 13:18:04', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000298', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:08:06', '成功', '成功返回', 43, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000299', '获取验证码', 'GET', '/auth/code', 'com.blog.core.system.auth.controller.AuthController.getCode()', '', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:08:07', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000300', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:09:33', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000301', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:09:34', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000302', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:09:34', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000303', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:09:37', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000304', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:09:37', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000305', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d2, userName=admin, nickName=超级管理员, gender=1, telephone=string, email=string@163.com, roles=[ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d55654), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d5565a)])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:10:08', '失败', 'nested exception is org.apache.ibatis.reflection.ReflectionException: There is no getter for property named \'gender\' in \'class com.blog.core.system.user.entity.ManageUser\'', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000306', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:10:08', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000307', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:34:08', '失败', NULL, 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000308', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:34:09', '成功', '成功返回', 8, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000309', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:36:03', '失败', NULL, 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000310', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:36:04', '成功', '成功返回', 2, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000311', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d3, userName=test, nickName=3132213, gender=1, telephone=123123, email=string@163.com, roles=[ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d5565a), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d55654), ManageRoleIdDTO(roleId=86548586a46f422aa6f9e702bbbd04c5)])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:36:25', '失败', 'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'manageUserRoleList\' not found. Available parameters are [collection, list]', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000312', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:36:25', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000313', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:37:10', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000314', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:37:10', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000315', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:38:19', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000316', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:38:19', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000317', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d3, userName=test, nickName=123, gender=1, telephone=123, email=string@163.com, roles=[ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d55654), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d5565a), ManageRoleIdDTO(roleId=86548586a46f422aa6f9e702bbbd04c5)])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:39:20', '失败', 'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'manageUserRoleList\' not found. Available parameters are [collection, list]', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000318', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:39:20', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000319', '分页查询后台系统操作日志信息', 'GET', '/log/all', 'com.blog.core.log.controller.ManageLogController.queryLogByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:41:39', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000320', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:44:47', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000321', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:44:53', '成功', '成功返回', 7, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000322', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:44:53', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000323', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:44:58', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000324', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:44:58', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000325', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d3, userName=test, nickName=123, gender=1, telephone=321, email=string@163.com, roles=[ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d55654), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d5565a), ManageRoleIdDTO(roleId=86548586a46f422aa6f9e702bbbd04c5)])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:45:22', '失败', 'nested exception is org.apache.ibatis.reflection.ReflectionException: There is no getter for property named \'reateTime\' in \'class com.blog.core.system.role.entity.ManageUserRole\'', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000326', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:45:23', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000327', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:45:29', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000328', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:45:29', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000329', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '192.168.1.102', '内网IP', '2020-04-01 23:47:28', '失败', NULL, 4, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000330', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '192.168.1.102', '内网IP', '2020-04-01 23:47:29', '成功', '成功返回', 4, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000331', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '192.168.1.102', '内网IP', '2020-04-01 23:47:29', '成功', '成功返回', 1, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000332', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:47:32', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000333', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:47:32', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000334', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d3, userName=test, nickName=123, gender=1, telephone=123, email=string@163.com, roles=[ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d55654), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d5565a), ManageRoleIdDTO(roleId=86548586a46f422aa6f9e702bbbd04c5)])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:47:41', '失败', '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'INSERT INTO manage_user_role\n            (id,\n            role_id,\n            u\' at line 14\r\n### The error may exist in file [E:\\Users\\blog\\free\\free-blog\\free-blog-manage\\target\\classes\\mapper\\system\\role\\ManageUserRoleMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO manage_user_role             (id,             role_id,             user_id,             create_id,             create_time)             VALUES             (?,             ?,             ?,             ?,             ?)          ;              INSERT INTO manage_user_role             (id,             role_id,             user_id,             create_id,             create_time)             VALUES             (?,             ?,             ?,             ?,             ?)          ;              INSERT INTO manage_user_role             (id,             role_id,             user_id,             create_id,             create_time)             VALUES             (?,             ?,             ?,             ?,             ?)\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'INSERT INTO manage_user_role\n            (id,\n            role_id,\n            u\' at line 14\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'INSERT INTO manage_user_role\n            (id,\n            role_id,\n            u\' at line 14', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000335', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:47:42', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000336', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:58:37', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000337', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:58:25', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000338', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d3, userName=test, nickName=123, gender=2, telephone=213, email=string@163.com, roles=[ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d55654), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d5565a), ManageRoleIdDTO(roleId=86548586a46f422aa6f9e702bbbd04c5)])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:59:36', '失败', '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'INSERT INTO manage_user_role\n            (id,\n            role_id,\n            u\' at line 14\r\n### The error may exist in file [E:\\Users\\blog\\free\\free-blog\\free-blog-manage\\target\\classes\\mapper\\system\\role\\ManageUserRoleMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO manage_user_role             (id,             role_id,             user_id,             create_id,             create_time)             VALUES             (?,             ?,             ?,             ?,             ?)          ;              INSERT INTO manage_user_role             (id,             role_id,             user_id,             create_id,             create_time)             VALUES             (?,             ?,             ?,             ?,             ?)          ;              INSERT INTO manage_user_role             (id,             role_id,             user_id,             create_id,             create_time)             VALUES             (?,             ?,             ?,             ?,             ?)\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'INSERT INTO manage_user_role\n            (id,\n            role_id,\n            u\' at line 14\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'INSERT INTO manage_user_role\n            (id,\n            role_id,\n            u\' at line 14', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000339', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:59:37', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000340', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:59:42', '失败', NULL, 0, NULL);
INSERT INTO `manage_log` VALUES ('20200301230000000000000000000341', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-01 23:59:42', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200302000000000000000000000342', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d3, userName=test, nickName=123, gender=1, telephone=123, email=string@163.com, roles=[ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d55654), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d5565a), ManageRoleIdDTO(roleId=86548586a46f422aa6f9e702bbbd04c5)])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-02 00:01:58', '失败', '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'INSERT INTO manage_user_role\n            (id,\n            role_id,\n            u\' at line 14\r\n### The error may exist in file [E:\\Users\\blog\\free\\free-blog\\free-blog-manage\\target\\classes\\mapper\\system\\role\\ManageUserRoleMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO manage_user_role             (id,             role_id,             user_id,             create_id,             create_time)             VALUES             (?,             ?,             ?,             ?,             ?)          ;              INSERT INTO manage_user_role             (id,             role_id,             user_id,             create_id,             create_time)             VALUES             (?,             ?,             ?,             ?,             ?)          ;              INSERT INTO manage_user_role             (id,             role_id,             user_id,             create_id,             create_time)             VALUES             (?,             ?,             ?,             ?,             ?)\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'INSERT INTO manage_user_role\n            (id,\n            role_id,\n            u\' at line 14\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'INSERT INTO manage_user_role\n            (id,\n            role_id,\n            u\' at line 14', 1, NULL);
INSERT INTO `manage_log` VALUES ('20200302000000000000000000000343', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-02 00:02:03', '成功', '成功返回', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200302000000000000000000000344', '分页查询部门信息', 'GET', '/api/dept', 'com.blog.core.system.dept.controller.ManageDeptController.queryManageDeptByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-02 00:04:23', '失败', NULL, 3, NULL);
INSERT INTO `manage_log` VALUES ('20200302000000000000000000000346', '分页查询角色信息', 'GET', '/api/role/all', 'com.blog.core.system.role.controller.ManageRoleController.queryRoleByPage()', '  queryRequest: \"QueryRequest{pageSize=0, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-02 00:04:41', '成功', '成功返回', 3, NULL);
INSERT INTO `manage_log` VALUES ('20200302000000000000000000000347', '修改用户信息', 'PUT', '/api/user/edit', 'com.blog.core.system.user.controller.ManageUserController.editUser()', '  manageUserEditDTO: ManageUserEditDTO(userId=8e20ed1dc3084825800957a89d2061d3, userName=test, nickName=41, gender=2, telephone=12312, email=string@163.com, roles=[ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d55654), ManageRoleIdDTO(roleId=36c9ae4c53ed41519aa6a67f36d5565a), ManageRoleIdDTO(roleId=86548586a46f422aa6f9e702bbbd04c5)])', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-02 00:05:33', '失败', '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'INSERT INTO manage_user_role\n            (id,\n            role_id,\n            u\' at line 14\r\n### The error may exist in file [E:\\Users\\blog\\free\\free-blog\\free-blog-manage\\target\\classes\\mapper\\system\\role\\ManageUserRoleMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO manage_user_role             (id,             role_id,             user_id,             create_id,             create_time)             VALUES             (?,             ?,             ?,             ?,             ?)          ;              INSERT INTO manage_user_role             (id,             role_id,             user_id,             create_id,             create_time)             VALUES             (?,             ?,             ?,             ?,             ?)          ;              INSERT INTO manage_user_role             (id,             role_id,             user_id,             create_id,             create_time)             VALUES             (?,             ?,             ?,             ?,             ?)\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'INSERT INTO manage_user_role\n            (id,\n            role_id,\n            u\' at line 14\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'INSERT INTO manage_user_role\n            (id,\n            role_id,\n            u\' at line 14', 0, NULL);
INSERT INTO `manage_log` VALUES ('20200302000000000000000000000348', '分页查询用户信息', 'GET', '/api/user/all', 'com.blog.core.system.user.controller.ManageUserController.queryUserByPage()', '  queryRequest: \"QueryRequest{pageSize=10, pageNum=0}\"', '0:0:0:0:0:0:0:1', '内网IP', '2020-04-02 00:05:34', '成功', '成功返回', 0, NULL);

-- ----------------------------
-- Table structure for manage_menu
-- ----------------------------
DROP TABLE IF EXISTS `manage_menu`;
CREATE TABLE `manage_menu`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'menu_id',
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上级菜单ID',
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
  PRIMARY KEY (`id`) USING BTREE
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
  `is_enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '启用/停用',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_role
-- ----------------------------
INSERT INTO `manage_role` VALUES ('36c9ae4c53ed41519aa6a67f36d55654', '普通用户', '12312', 'string', '0', '2020-04-01 12:28:14', '2020-04-01 12:28:14', '0c3740672f6a4afbaa1af705e4b66c47', 'null');
INSERT INTO `manage_role` VALUES ('36c9ae4c53ed41519aa6a67f36d5565a', '超级管理员', '所有权限', 'admin', '1', '2020-04-01 12:28:06', '2020-04-01 12:28:06', '0c3740672f6a4afbaa1af705e4b66c47', 'null');
INSERT INTO `manage_role` VALUES ('86548586a46f422aa6f9e702bbbd04c5', '游客', '123', '123', '1', '2020-04-01 12:28:17', '2020-04-01 12:28:17', '0c3740672f6a4afbaa1af705e4b66c47', NULL);

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
  `is_enable` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '启用/禁用',
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
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆密码',
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '盐',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `is_enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '停用/启用（0，停用；1，启用）',
  `login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆ip',
  `last_login_time` datetime(0) DEFAULT NULL COMMENT '上一次登陆时间',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改日期',
  `create_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个性签名',
  `comments` bigint(200) DEFAULT 0 COMMENT '发布评论数',
  `article_total` bigint(200) DEFAULT 0 COMMENT '文章数',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `attention_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关注的用户id',
  `is_supper` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否超级管理员',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_user
-- ----------------------------
INSERT INTO `manage_user` VALUES ('8e20ed1dc3084825800957a89d2061d2', 'admin', '$2a$10$RJxDZ4bZaelml3Kfzjnv9ep110tbKE4BD5Zmi5kSUj5Vn1fwvHTGq', 'PiMMmezOxBmDa2zvWF4E', '超级管理员', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'string', 'string@163.com', '1', NULL, NULL, '2019-07-22 13:42:54', NULL, 'null', NULL, 'string', 0, 0, '1', NULL, '1');
INSERT INTO `manage_user` VALUES ('8e20ed1dc3084825800957a89d2061d3', 'test', '$2a$10$RJxDZ4bZaelml3Kfzjnv9ep110tbKE4BD5Zmi5kSUj5Vn1fwvHTGq', NULL, NULL, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', NULL, 'string@163.com', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for manage_user_role
-- ----------------------------
DROP TABLE IF EXISTS `manage_user_role`;
CREATE TABLE `manage_user_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户id',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage_user_role
-- ----------------------------
INSERT INTO `manage_user_role` VALUES ('50d2aba60d004998bb8bd1295fae6d33', '36c9ae4c53ed41519aa6a67f36d5565a', '8e20ed1dc3084825800957a89d2061d2', '0c3740672f6a4afbaa1af705e4b66c47', '2019-07-17 18:00:39', NULL, NULL);

-- ----------------------------
-- Table structure for portal_article
-- ----------------------------
DROP TABLE IF EXISTS `portal_article`;
CREATE TABLE `portal_article`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  `ARTICLE_TITLE` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `RELEASE_DATE` datetime(6) DEFAULT NULL COMMENT '发布日期',
  `ARTICLE_CONTENT_HTML` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容-html',
  `ARTICLE_CONTENT` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容-markdown',
  `ARTICLE_USER_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发表文章的作者ID',
  `IS_ENABLE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '删除标识',
  `article_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章状态',
  `RELEASE_STATUS` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发布状态',
  `article_tag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ARTICLE_IMAGES` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章图片',
  `COMMENTS` bigint(20) DEFAULT 0 COMMENT '评论数',
  `APPROVES` bigint(20) DEFAULT 0 COMMENT '点赞数',
  `LIKE_number` bigint(20) DEFAULT NULL COMMENT '喜欢',
  `read_number` bigint(20) DEFAULT 0 COMMENT '浏览人数',
  `category_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属分类ID',
  `ARTICLE_TYPE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章的模式',
  `ARTICLE_TOP` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '是否置顶',
  `COMMENT_STATUS` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '是否开启评论',
  `ARTICLE_FINE_NOTE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '是否精帖',
  `tag_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标签ID',
  `COMMENT_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论id',
  `recommend_Status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CREATE_TIME` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `CREATE_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime(6) DEFAULT NULL COMMENT '修改时间',
  `UPDATE_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_article
-- ----------------------------
INSERT INTO `portal_article` VALUES ('02da9663f04646a2a3fc6868be920c65', 'Spring Boot 实战', '2019-07-27 15:02:05.000000', NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 23, 3, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:25:03.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('06b71ff5cb46438ca38e9b5e9a155779', 'Spring Boot 实战', '2019-07-27 15:02:28.000000', NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 13, 7, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:25:30.000000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('1', '当爱情只剩下一百步', '2019-05-09 21:58:40.000000', NULL, '<blockquote><p><i>当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。当我走出第一步，有一种叫悲哀的东西漫过心底；我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷，曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑。我们竟哈哈大笑。</i></p></blockquote>\r\n', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', 0, NULL, 112, 117, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:48.000000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('121a6ea1ab3f4adaae5498848346737b', 'Spring Boot 实战', '2019-07-27 15:02:18.000000', NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:33.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('14d40bc539a84865ba79805d76c131c9', 'Spring Boot 实战', '2019-07-27 15:02:21.000000', NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:25:12.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('1b19468a6c734de6bca20c90ae1d5b1a', 'Spring Boot 实战', '2019-07-27 15:02:25.000000', NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:42.000000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('281c3db87a414340bf1ca5330de5b9b1', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:25:24.000000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('3367198e68704d67a3844accd58e87b7', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:27.000000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('39624834dd314c7390b25c6b71e22bcb', 'Spring Boot 实战1', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:30.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('3e60f2ec9eea4c9f84187581693bb74a', 'Spring Boot 实战2', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:18.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('3f04a1a33cda4b529baa40f12cf9d5f9', 'Spring Boot 实战3', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:36.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('4b6d9ed4962e427f8ea429c28853edb0', 'Spring Boot 实战4', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:15.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('504f26b4a4f5447ba3bef94ae1a68e96', 'Spring Boot 实战5', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:25:27.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('620385314da24ea3b865bba8881fcae6', 'Spring Boot 实战6', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:48.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('642a6b9f77824853a244eb4d4a7f6bf3', 'Spring Boot 实战7', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:25:21.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('7a604fe2f6ef49c1957a321ca75c05a8', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:57.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('872ac2e25e1740aebaedb025b0c657fa', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:12.000000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('8ee4d90cc8e24ebeb694e4ec0d526d0e', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:21.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('93905e17980a4454baa584b10826ccd9', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:39.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('9fcb3596b29f4b04b631d8b4065b87d4', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:25:15.000000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('a1a8c9458e634778911a6e01dab42f14', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:51.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('b9322f49089940b4af7b69a249f12222', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:25:18.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('b9c755410928497eb104de14ffa1c1f8', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:45.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('bb5aa335593f413a95e72bd2b9ce088b', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:25:33.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('d1b554b5d8eb43ea8ef034e7d0a515c3', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:25:09.002000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('dc6e4761a5bf403699c14c7c5cfa7840', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:54.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('df81b36cecd54ac5946e70535dffc192', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:25:06.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('e8975e147a63439aaa1714c42114d5de', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:24.001000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('ec977e50a4c844679d9283d105d9ce04', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:24:09.934000', NULL, NULL, NULL);
INSERT INTO `portal_article` VALUES ('f4da31dedf254c98833da552b991e257', 'Spring Boot 实战', NULL, NULL, '这是关于Spring Boot 实战的文章！', '8e20ed1dc3084825800957a89d2061d2', '1', '0', '1', NULL, 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png', NULL, NULL, 10, 0, NULL, NULL, '0', '0', '1', NULL, NULL, NULL, '2019-05-11 00:25:00.002000', NULL, NULL, NULL);

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
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `article_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tag_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
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
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `category_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sort` int(10) DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_enable` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for portal_comment
-- ----------------------------
DROP TABLE IF EXISTS `portal_comment`;
CREATE TABLE `portal_comment`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '评论内容',
  `comment_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论者的用户id',
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父id',
  `article_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属文章id',
  `is_parent` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否为父级',
  `comment_time` datetime(0) DEFAULT NULL COMMENT '评论时间',
  `approves` bigint(20) DEFAULT 0 COMMENT '点赞数',
  `is_enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_comment
-- ----------------------------
INSERT INTO `portal_comment` VALUES ('04591d96601f4b3cbf10bb55c975437f', '齐人未尝赂秦，终继五国迁灭，何哉？与嬴而不助五国也。五国既丧，齐亦不免矣。燕赵之君，始有远略，能守其土，义不赂秦。是故燕虽小国而后亡，斯用兵之效也。至丹以荆卿为计，始速祸焉。赵尝五战于秦，二败而三胜。后秦击赵者再，李牧连却之。洎牧以谗诛，邯郸为郡，惜其用武而不终也。且燕赵处秦革灭殆尽之际，可谓智力孤危，战败而亡，诚不得已。向使三国各爱其地，齐人勿附于秦，刺客不行，良将犹在，则胜负之数，存亡之理，当与秦相较，或未易量。', '8e20ed1dc3084825800957a89d2061d2', '1', '1', '1', '2019-05-12 18:26:10', 0, '1');
INSERT INTO `portal_comment` VALUES ('1', '当我走出第一步，有一种叫悲哀的东西漫过心底', '8e20ed1dc3084825800957a89d2061d2', '', '1', '0', '2019-05-11 23:28:40', 10, '1');
INSERT INTO `portal_comment` VALUES ('1a4d47163a5a486b88cd8648205a21e0', '我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？', '8e20ed1dc3084825800957a89d2061d2', NULL, '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-05-12 00:49:08', 20, '1');
INSERT INTO `portal_comment` VALUES ('20d5fe3c2cba410780a5f2299cc420f5', '123123', 'null', '04591d96601f4b3cbf10bb55c975437f', '1', '0', '2019-07-31 17:17:15', 0, '1');
INSERT INTO `portal_comment` VALUES ('30901f28494049d8b8705b4dcf536571', '关关雎鸠，在河之洲。窈窕淑女，君子好逑。', '8e20ed1dc3084825800957a89d2061d2', NULL, '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-05-12 00:50:51', 30, '1');
INSERT INTO `portal_comment` VALUES ('3950cc3e519b445b8c85aedd60c388f2', '这个是回复', 'null', '04591d96601f4b3cbf10bb55c975437f', '1', '0', '2019-07-31 16:42:22', 0, '1');
INSERT INTO `portal_comment` VALUES ('3b0732c1644e4e098e697cc164946515', '123', 'null', 'fb1c6d7c0fc94d1', '1', '0', '2019-07-31 17:48:32', 0, '1');
INSERT INTO `portal_comment` VALUES ('49b2e394839b4f9d95ea38ed8536da51', '123', 'null', 'fb1c6d7c0fc94d1', '1', '0', '2019-07-31 16:44:23', 0, '1');
INSERT INTO `portal_comment` VALUES ('5d5135dd339647c88836a2f4683eaabc', '是日也，天朗气清，惠风和畅，仰观宇宙之大，俯察品类之盛，所以游目骋怀，足以极视听之娱，信可乐也。', '8e20ed1dc3084825800957a89d2061d2', '8e914e14e2774172bac35bcac20fec1d', '1', '1', '2019-05-12 18:31:47', 0, '1');
INSERT INTO `portal_comment` VALUES ('5e4e6906582f45b5932e5b1c6dbb2bb9', '123', 'null', '887844d7ae3649589339042b04287583', '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-07-31 17:06:16', 0, '1');
INSERT INTO `portal_comment` VALUES ('5fb5b8922e8844d8bb9b8d1bef093cc5', '曾几何时', 'null', 'fb1c6d7c0fc94d1', '1', '0', '2019-07-31 17:48:38', 0, '1');
INSERT INTO `portal_comment` VALUES ('6a6eda7bdf7542f386a7fbddd6e75ded', '参差荇菜，左右采之。窈窕淑女，琴瑟友之。', '8e20ed1dc3084825800957a89d2061d2', NULL, '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-05-12 00:51:32', 0, '1');
INSERT INTO `portal_comment` VALUES ('6b5fd9c23ebb4cbb8b6155c9d3e9f6fd', '永和九年，岁在癸丑，暮春之初，会于会稽山阴之兰亭，修禊事也。群贤毕至，少长咸集。此地有崇山峻岭，茂林修竹；又有清流激湍，映带左右，引以为流觞曲水，列坐其次。虽无丝竹管弦之盛，一觞一咏，亦足以畅叙幽情。', '8e20ed1dc3084825800957a89d2061d2', '8e914e14e2774172bac35bcac20fec1d', '1', '1', '2019-05-12 18:30:21', 0, '1');
INSERT INTO `portal_comment` VALUES ('82d7a8ed2b8a4d3d94ef14b4bd98da3e', '夫人之相与，俯仰一世，或取诸怀抱，悟言一室之内；或因寄所托，放浪形骸之外。虽趣舍万殊，静躁不同，当其欣于所遇，暂得于己，快然自足，不知老之将至。及其所之既倦，情随事迁，感慨系之矣。向之所欣，俯仰之间，已为陈迹，犹不能不以之兴怀。况修短随化，终期于尽。古人云：“死生亦大矣。”岂不痛哉！(不知老之将至 一作：曾不知老之将至)', '8e20ed1dc3084825800957a89d2061d2', '8e914e14e2774172bac35bcac20fec1d', '1', '1', '2019-05-12 18:38:55', 0, '1');
INSERT INTO `portal_comment` VALUES ('887844d7ae3649589339042b04287583', '六国破灭，非兵不利 ，战不善，弊在赂秦。赂秦而力亏，破灭之道也。或曰：六国互丧，率赂秦耶？曰：不赂者以赂者丧，盖失强援，不能独完。故曰：弊在赂秦也。', '8e20ed1dc3084825800957a89d2061d2', 'a996e5be251a4d578806bac22739b1a7', '06b71ff5cb46438ca38e9b5e9a155779', '1', '2019-05-12 17:57:34', 0, '1');
INSERT INTO `portal_comment` VALUES ('8e914e14e2774172bac35bcac20fec1d', '我们的爱情路只剩下九十九步，我们怎么走到了今天这一步？', '8e20ed1dc3084825800957a89d2061d2', NULL, '1', '0', '2019-05-12 00:47:09', 40, '1');
INSERT INTO `portal_comment` VALUES ('90ddedd3708049c28617e7b8074e44e5', '123', 'null', '887844d7ae3649589339042b04287583', '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-07-31 17:06:04', 0, '1');
INSERT INTO `portal_comment` VALUES ('95d7bfb9bee94e34b1c0509b5d6b8cac', '我们的爱情路只剩下九十九步', '8e20ed1dc3084825800957a89d2061d2', NULL, '1', '0', '2019-05-12 00:47:44', 50, '1');
INSERT INTO `portal_comment` VALUES ('9a4cc05db9d079c5b', '曾几何时，我们在雪天里呼着热气吃冰淇凌，当人们投来惊异的目光时，我们竟哈哈大笑', '8e20ed1dc3084825800957a89d2061d2', '1', '1', '1', '2019-05-12 16:30:49', 10, '1');
INSERT INTO `portal_comment` VALUES ('a47cc3f39c7544ddbc8fe24b1de59056', '求之不得，寤寐思服。悠哉悠哉，辗转反侧。', '8e20ed1dc3084825800957a89d2061d2', NULL, '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-05-12 00:48:22', 60, '1');
INSERT INTO `portal_comment` VALUES ('a7ba01cf7a204864a43b2999cfd85833', '参差荇菜，左右芼之。窈窕淑女，钟鼓乐之。', '8e20ed1dc3084825800957a89d2061d2', NULL, '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-05-12 00:59:37', 0, '1');
INSERT INTO `portal_comment` VALUES ('a7d871d575df403898d0603292f16d5c', '123123', 'null', '04591d96601f4b3cbf10bb55c975437f', '1', '0', '2019-07-31 17:23:15', 0, '1');
INSERT INTO `portal_comment` VALUES ('a996e5be251a4d578806bac22739b1a7', '123', '8e20ed1dc3084825800957a89d2061d2', '95d7bfb9bee94e34b1c0509b5d6b8cac', '1', '1', '2019-05-12 17:47:43', 0, '1');
INSERT INTO `portal_comment` VALUES ('b7624fbf3c894da0bdb54856dedbb035', '六国破灭，非兵不利 ，战不善，弊在赂秦。赂秦而力亏，破灭之道也。或曰：六国互丧，率赂秦耶？曰：不赂者以赂者丧，盖失强援，不能独完。故曰：弊在赂秦也。', '8e20ed1dc3084825800957a89d2061d2', '95d7bfb9bee94e34b1c0509b5d6b8cac', '1', '1', '2019-05-12 18:08:12', 0, '1');
INSERT INTO `portal_comment` VALUES ('c7261c9948c84abeb9fbd688b2f02b62', '123', 'null', '887844d7ae3649589339042b04287583', '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-07-31 17:07:09', 0, '1');
INSERT INTO `portal_comment` VALUES ('c8e53a11f5aa4dc4879eed4ce62671c9', '12', 'null', '3950cc3e519b445b8c85aedd60c388f2', '1', '0', '2019-07-31 17:01:51', 0, '1');
INSERT INTO `portal_comment` VALUES ('fb1c6d7c0fc94d1', '曾几何时，我们一起在雨中漫步，衣服湿了也不觉得冷', '8e20ed1dc3084825800957a89d2061d2', '1', '1', '1', '2019-05-12 16:30:11', 20, '1');
INSERT INTO `portal_comment` VALUES ('fb1c6d7c0fc94d19a4cc05db9d079c5b', '参差荇菜，左右流之。窈窕淑女，寤寐求之。', '8e20ed1dc3084825800957a89d2061d2', NULL, '06b71ff5cb46438ca38e9b5e9a155779', '0', '2019-05-12 00:51:04', 70, '1');
INSERT INTO `portal_comment` VALUES ('fb47aae25b0f41f08ac020024469496f', '秦以攻取之外，小则获邑，大则得城。较秦之所得，与战胜而得者，其实百倍；诸侯之所亡，与战败而亡者，其实亦百倍。则秦之所大欲，诸侯之所大患，固不在战矣。思厥先祖父，暴霜露，斩荆棘，以有尺寸之地。子孙视之不甚惜，举以予人，如弃草芥。今日割五城，明日割十城，然后得一夕安寝。起视四境，而秦兵又至矣。然则诸侯之地有限，暴秦之欲无厌，奉之弥繁，侵之愈急。故不战而强弱胜负已判矣。至于颠覆，理固宜然。古人云：“以地事秦，犹抱薪救火，薪不尽，火不灭。”此言得之。', '8e20ed1dc3084825800957a89d2061d2', '95d7bfb9bee94e34b1c0509b5d6b8cac', '1', '1', '2019-05-12 18:17:20', 0, '1');

-- ----------------------------
-- Table structure for portal_iamge
-- ----------------------------
DROP TABLE IF EXISTS `portal_iamge`;
CREATE TABLE `portal_iamge`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `image_url` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片路径',
  `image_description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片描述',
  `iamge_belong` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片所属',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for portal_im_message
-- ----------------------------
DROP TABLE IF EXISTS `portal_im_message`;
CREATE TABLE `portal_im_message`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `receive_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接收人',
  `receive_time` datetime(0) DEFAULT NULL COMMENT '接收时间',
  `send_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送人id',
  `send_time` datetime(0) DEFAULT NULL COMMENT '发送时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送内容',
  `message_type` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型 1：回复 2：@ 3：赞 4：系统 5：私信 6：我的消息',
  `read_status` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '1 已读 0 未读',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for portal_log
-- ----------------------------
DROP TABLE IF EXISTS `portal_log`;
CREATE TABLE `portal_log`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日志id',
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
  PRIMARY KEY (`id`) USING BTREE
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
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单id',
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '菜单父id',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `web_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '返回给前端的标识（如新增 add）',
  `menu_url` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'url地址',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'icon',
  `menu_sort` int(10) DEFAULT NULL COMMENT '菜单排序号(越小在前面)',
  `menu_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单或按钮(MENU :菜单，BUTTON：按钮)',
  `perms` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限标识',
  `is_enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '状态(0:停用;1:启用)',
  `is_web` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标识(1:前端;2:后台)',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_menu
-- ----------------------------
INSERT INTO `portal_menu` VALUES ('0180e48befdc4f5ba8fedc84d834714d', 'bb6438503ab5490199e9e5949dc58888', '后台操作日志', 'string', 'operation/managelog', 'wulianwang-', 2, '0', NULL, '1', NULL, '2019-07-22 12:03:49', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('10396d3cc11941c7b4931b5637eb5a88', '0', '系统管理', '', '', 'config', 2, '0', NULL, '1', NULL, '2019-07-14 20:51:32', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('244aa6e940244b6aa8789bac9f6d7d33', 'bb6438503ab5490199e9e5949dc58888', '前台操作日志', 'string', 'operation/portallog', 'wulianwang-', 1, '0', NULL, '1', NULL, '2019-07-22 14:35:42', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('3a4576442e7e4a4181f3257539c2274d', 'b41f1ca52d404944ae03497b033e5378', '博文列表', '', '/portal/article/query', 'list', 1, '1', NULL, '1', NULL, '2019-07-14 21:00:45', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('3fcf1e63c6e34fe3acd9431ee9fc34a4', 'b41f1ca52d404944ae03497b033e5378', '新增博文', '', 'article/article-add-or-update', 'add', 0, '1', NULL, '1', NULL, '2019-07-14 21:01:15', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('4b32fcb4f6a442f9a00d49c9bfd27537', '0', '相册', 'string', 'string', 'image', 10, '0', NULL, '1', NULL, '2019-06-29 10:41:41', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('5a1c74a1ac7c42ac92de23c700860749', '0', '视频', 'string', 'string', 'config', 11, '0', NULL, '1', NULL, '2019-06-29 10:41:47', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('79613f0e27084a4f8ad8f10418614fe2', '0', '文章', 'string', 'string', 'config', 8, '0', NULL, '1', NULL, '2019-06-29 10:41:28', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('a5a7983e82324eb8841453e3991f85c6', '0', '心情', 'string', 'string', 'config', 9, '0', NULL, '1', NULL, '2019-06-29 10:41:36', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('b41f1ca52d404944ae03497b033e5378', '0', '博文管理', '', '', 'article', 1, '0', NULL, '1', NULL, '2019-07-14 21:00:03', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('bb6438503ab5490199e9e5949dc58888', '0', '日志管理', '', '', 'rizhi', 3, '0', NULL, '1', NULL, '2019-07-22 12:03:36', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('be19194325ec4f1597ff7b3e3da01e6b', '10396d3cc11941c7b4931b5637eb5a88', '角色管理', '', 'sys/role', 'admin', 0, '1', NULL, '1', NULL, '2019-07-14 20:57:04', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('e0ec81922b7c42378273dd2a452c447b', '10396d3cc11941c7b4931b5637eb5a88', '管理员列表', '', 'sys/user', 'admin', 0, '1', NULL, '1', NULL, '2019-07-14 20:56:06', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('e6ccb87ffb1940adbfdb09fdd3ae4f70', '10396d3cc11941c7b4931b5637eb5a88', '菜单管理', '', 'sys/menu', 'menu', 0, '1', NULL, '1', NULL, '2019-07-14 20:57:26', 'null', NULL, NULL);
INSERT INTO `portal_menu` VALUES ('e6ccb87ffb7840adbf123db09fdd34df', 'e6ccb87ffb7840adbfag09fdd3ae4f70', '标签', NULL, 'operation/tag', 'menu', 1, '1', NULL, '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `portal_menu` VALUES ('e6ccb87ffb7840adbfag09fdd3ae4f70', '0', '标签管理', NULL, NULL, 'menu', 0, '0', NULL, '1', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for portal_role
-- ----------------------------
DROP TABLE IF EXISTS `portal_role`;
CREATE TABLE `portal_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `role_describe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色编号',
  `is_enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '启用/停用',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
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
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tag_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签名称',
  `tag_category_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签所属类别',
  `is_enable` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '启用/禁用',
  `create_time` datetime(0) DEFAULT NULL,
  `create_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  `update_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
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
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆密码',
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '盐',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `is_enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '停用/启用（0，停用；1，启用）',
  `last_login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆ip',
  `last_login_time` datetime(0) DEFAULT NULL COMMENT '上一次登陆时间',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改日期',
  `create_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个性签名',
  `comments` bigint(200) DEFAULT 0 COMMENT '发布评论数',
  `article_total` bigint(200) DEFAULT 0 COMMENT '文章数',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `attention_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关注的用户id',
  `is_supper` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否超级管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of portal_user
-- ----------------------------
INSERT INTO `portal_user` VALUES ('8e20ed1dc3084825800957a89d2061d2', 'admin', '$2a$10$Q2ky3hZ8o92f0RhgHGC8RumuaOvKxevSR7HFpjxCYIRe7D0z/7Gvu', 'PiMMmezOxBmDa2zvWF4E', '超级管理员', 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png', 'string', 'string', '1', NULL, NULL, '2019-07-22 13:42:54', NULL, 'null', NULL, 'string', 0, 0, '1', NULL, '1');

-- ----------------------------
-- Table structure for portal_user_role
-- ----------------------------
DROP TABLE IF EXISTS `portal_user_role`;
CREATE TABLE `portal_user_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户id',
  `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
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


CREATE TABLE `manage_dept`  (
  `dept_id` varchar(32)  NOT NULL COMMENT '部门id',
  `dept_name` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '上级部门名称',
  `is_enable` varchar(32) DEFAULT '1' COMMENT '启用/停用',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `c_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '员工部门表' ROW_FORMAT = Dynamic;

INSERT INTO `blog`.`manage_dept`(`dept_id`, `dept_name`, `parent_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200304230000000000000000004945', '华中分部', '20200312200000000000000000005086', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:10:21', NULL);
INSERT INTO `blog`.`manage_dept`(`dept_id`, `dept_name`, `parent_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200304230000000000000000004946', '华东分部', '20200312200000000000000000005086', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:10:39', NULL);
INSERT INTO `blog`.`manage_dept`(`dept_id`, `dept_name`, `parent_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200304230000000000000000004949', '销售部', '20200304230000000000000000004945', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:14:54', NULL);
INSERT INTO `blog`.`manage_dept`(`dept_id`, `dept_name`, `parent_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200304230000000000000000004952', '华南分部', '20200312200000000000000000005086', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:10:35', NULL);
INSERT INTO `blog`.`manage_dept`(`dept_id`, `dept_name`, `parent_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200304230000000000000000004981', '华北分部', '20200312200000000000000000005086', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:10:30', NULL);
INSERT INTO `blog`.`manage_dept`(`dept_id`, `dept_name`, `parent_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200304230000000000000000004987', '技术部', '20200304230000000000000000004945', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:14:45', NULL);
INSERT INTO `blog`.`manage_dept`(`dept_id`, `dept_name`, `parent_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200304230000000000000000004995', '人事部', '20200304230000000000000000004946', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:15:17', NULL);
INSERT INTO `blog`.`manage_dept`(`dept_id`, `dept_name`, `parent_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200304230000000000000000004997', '人事部', '20200304230000000000000000004945', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:13:55', NULL);
INSERT INTO `blog`.`manage_dept`(`dept_id`, `dept_name`, `parent_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200304230000000000000000004998', '财务部', '20200304230000000000000000004945', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:14:33', NULL);
INSERT INTO `blog`.`manage_dept`(`dept_id`, `dept_name`, `parent_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200304230000000000000000005008', '人事部', '20200304230000000000000000004952', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:15:24', NULL);
INSERT INTO `blog`.`manage_dept`(`dept_id`, `dept_name`, `parent_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200312200000000000000000005034', '财务部', '20200304230000000000000000004981', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:20:37', NULL);
INSERT INTO `blog`.`manage_dept`(`dept_id`, `dept_name`, `parent_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200312200000000000000000005086', '公司总部', NULL, '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-12 20:27:10', NULL);



CREATE TABLE `manage_job`  (
  `job_id` varchar(32)  NOT NULL COMMENT '岗位id',
  `job_name` varchar(32) DEFAULT NULL COMMENT '岗位名称',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '部门id',
  `is_enable` varchar(32) DEFAULT '1' COMMENT '启用/停用',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `c_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '员工岗位表' ROW_FORMAT = Dynamic;

INSERT INTO `blog`.`manage_job`(`job_id`, `job_name`, `dept_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200312200000000000000000005025', '后端开发', '20200304230000000000000000004987', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:30:17', NULL);
INSERT INTO `blog`.`manage_job`(`job_id`, `job_name`, `dept_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200312200000000000000000005053', '招聘专员', '20200304230000000000000000004995', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:32:04', NULL);
INSERT INTO `blog`.`manage_job`(`job_id`, `job_name`, `dept_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200312200000000000000000005060', '前端开发', '20200304230000000000000000004987', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:30:10', NULL);
INSERT INTO `blog`.`manage_job`(`job_id`, `job_name`, `dept_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200312200000000000000000005061', '人工客服', '20200304230000000000000000004949', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:31:04', NULL);
INSERT INTO `blog`.`manage_job`(`job_id`, `job_name`, `dept_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200312200000000000000000005067', '招聘专员', '20200304230000000000000000004997', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:32:09', NULL);
INSERT INTO `blog`.`manage_job`(`job_id`, `job_name`, `dept_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200312200000000000000000005082', '电话销售', '20200304230000000000000000004949', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:30:50', NULL);
INSERT INTO `blog`.`manage_job`(`job_id`, `job_name`, `dept_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200312200000000000000000005085', '招聘专员', '20200304230000000000000000005008', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:32:14', NULL);
INSERT INTO `blog`.`manage_job`(`job_id`, `job_name`, `dept_id`, `is_enable`, `create_id`, `update_id`, `create_time`, `update_time`) VALUES ('20200312200000000000000000005095', '产品经理', '20200304230000000000000000004987', '1', '8e20ed1dc3084825800957a89d2061d2', NULL, '2020-04-13 00:29:43', NULL);



CREATE TABLE `manage_role_dept`  (
  `id` varchar(32)  NOT NULL COMMENT '角色部门关联id',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色id',
	`dept_id` varchar(32) DEFAULT '1' COMMENT '部门id',
	`create_id` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
	`c_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `u_time` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色部门关联表' ROW_FORMAT = Dynamic;
