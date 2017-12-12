/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : cimdb

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 12/12/2017 10:14:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for contract_order
-- ----------------------------
DROP TABLE IF EXISTS `contract_order`;
CREATE TABLE `contract_order`  (
  `contract_order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '合同订单表id自增',
  `contract_order_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号(自动生成)',
  `contract_order_end_date` datetime(0) NOT NULL COMMENT '交付时间',
  `contract_order_state` int(11) NOT NULL COMMENT '是否交付(0:未,1:已)',
  `contract_order_start_date` datetime(0) NOT NULL COMMENT '下单时间',
  `order_contract_id` int(11) NOT NULL COMMENT '合同id外键',
  `user_id` int(11) NOT NULL COMMENT '用户表id(确认人)',
  `contract_order_remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`contract_order_id`) USING BTREE,
  INDEX `Fk_order_order_contract`(`order_contract_id`) USING BTREE,
  INDEX `Fk_order_user`(`user_id`) USING BTREE,
  CONSTRAINT `Fk_order_order_contract` FOREIGN KEY (`order_contract_id`) REFERENCES `order_contract` (`order_contract_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contract_order_term
-- ----------------------------
DROP TABLE IF EXISTS `contract_order_term`;
CREATE TABLE `contract_order_term`  (
  `contract_order_term_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '合同订单项主键自增',
  `menu_id` int(11) NOT NULL COMMENT '菜品id外键',
  `menu_number` int(11) NOT NULL COMMENT '菜品数量',
  `complete_number` int(11) NOT NULL COMMENT '完成数量',
  `contract_order_term_state` int(11) NOT NULL COMMENT '完成状态(0:未,1:已)',
  `product_batch` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品批次(自动生成)',
  `contract_order_id` int(11) NOT NULL COMMENT '合同订单Id外键',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`contract_order_term_id`) USING BTREE,
  INDEX `Fk_contract_order_term_menu`(`menu_id`) USING BTREE,
  INDEX `contract_order_term_contract_order`(`contract_order_id`) USING BTREE,
  CONSTRAINT `Fk_contract_order_term_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `contract_order_term_contract_order` FOREIGN KEY (`contract_order_id`) REFERENCES `contract_order` (`contract_order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contract_production_distribution
-- ----------------------------
DROP TABLE IF EXISTS `contract_production_distribution`;
CREATE TABLE `contract_production_distribution`  (
  `contract_production_distribution_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '合同订单生产任务分配主键',
  `contract_production_plan_item_id` int(11) NOT NULL COMMENT '计划订单项id',
  `working_id` int(11) NOT NULL COMMENT '工序表id',
  `user_id` int(11) NOT NULL COMMENT '工序负责人',
  `start_date` datetime(0) NOT NULL COMMENT '预计生产开始时间',
  `end_date` datetime(0) NOT NULL COMMENT '预计结束时间',
  `people_number` int(11) NOT NULL COMMENT '配置人数',
  `production_line_id` int(11) NOT NULL COMMENT '生产线id外键',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `next_working_number` int(11) NOT NULL COMMENT '进入下一工序数量',
  PRIMARY KEY (`contract_production_distribution_id`) USING BTREE,
  INDEX `Fk_distribution_contract_production_plan_item`(`contract_production_plan_item_id`) USING BTREE,
  INDEX `Fk_distribution_working`(`working_id`) USING BTREE,
  INDEX `Fk_distribution_user`(`user_id`) USING BTREE,
  INDEX `Fk_distribution_production_line`(`production_line_id`) USING BTREE,
  CONSTRAINT `Fk_distribution_contract_production_plan_item` FOREIGN KEY (`contract_production_plan_item_id`) REFERENCES `contract_production_plan_item` (`contract_production_plan_item_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_distribution_production_line` FOREIGN KEY (`production_line_id`) REFERENCES `production_line` (`production_line_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_distribution_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_distribution_working` FOREIGN KEY (`working_id`) REFERENCES `working` (`working_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contract_production_plan
-- ----------------------------
DROP TABLE IF EXISTS `contract_production_plan`;
CREATE TABLE `contract_production_plan`  (
  `contract_production_plan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '合同订单生产计划表主键',
  `contract_order_id` int(11) NOT NULL COMMENT '合同订单id外键',
  `production_batch` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产批次',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `date` date NOT NULL COMMENT '日期',
  PRIMARY KEY (`contract_production_plan_id`) USING BTREE,
  INDEX `Fk_plan_contract_order`(`contract_order_id`) USING BTREE,
  CONSTRAINT `Fk_plan_contract_order` FOREIGN KEY (`contract_order_id`) REFERENCES `contract_order` (`contract_order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contract_production_plan_item
-- ----------------------------
DROP TABLE IF EXISTS `contract_production_plan_item`;
CREATE TABLE `contract_production_plan_item`  (
  `contract_production_plan_item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '合同订单生产计划订单项主键',
  `menu_id` int(11) NOT NULL COMMENT '菜品id外键',
  `menu_number` int(11) NOT NULL COMMENT '菜品数量',
  `contract_production_plan_id` int(11) NOT NULL COMMENT '生产计划id外键',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`contract_production_plan_item_id`) USING BTREE,
  INDEX `Fk_contract_production_plan_item_menu`(`menu_id`) USING BTREE,
  INDEX `Fk_contract_production_plan_item_contract_production_plan`(`contract_production_plan_id`) USING BTREE,
  CONSTRAINT `Fk_contract_production_plan_item_contract_production_plan` FOREIGN KEY (`contract_production_plan_id`) REFERENCES `contract_production_plan` (`contract_production_plan_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_contract_production_plan_item_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contract_progress
-- ----------------------------
DROP TABLE IF EXISTS `contract_progress`;
CREATE TABLE `contract_progress`  (
  `contract_progress_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '合同订单任务进度记录主键',
  `contract_production_distribution_id` int(11) NOT NULL COMMENT '合同订单生产任务分配id',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注（必填）',
  `start_date` datetime(0) NOT NULL COMMENT '实际生产开始时间',
  `end_date` datetime(0) NOT NULL COMMENT '实际结束时间',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`contract_progress_id`) USING BTREE,
  INDEX `Fk_contract_progress_contract_production_distribution`(`contract_production_distribution_id`) USING BTREE,
  CONSTRAINT `Fk_contract_progress_contract_production_distribution` FOREIGN KEY (`contract_production_distribution_id`) REFERENCES `contract_production_distribution` (`contract_production_distribution_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `equipment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备表主键',
  `production_line_id` int(11) NOT NULL COMMENT '所属生产线id外键',
  `working_id` int(11) NOT NULL COMMENT '所属工序id外键\r\n',
  `user_id` int(11) NOT NULL COMMENT '设备负责人id',
  `start_date` date NOT NULL COMMENT '启用时间',
  `equipment_type_id` int(11) NOT NULL COMMENT '设备状态外键',
  `maintenance_cycle` int(11) NOT NULL COMMENT '保养周期(天)',
  `inspection_cycle` int(11) NOT NULL COMMENT '检查周期(天)',
  `equipment_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备名称',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`equipment_id`) USING BTREE,
  INDEX `Fk_equipment_production_line`(`production_line_id`) USING BTREE,
  INDEX `Fk_equipment_working`(`working_id`) USING BTREE,
  INDEX `Fk_equipment_user`(`user_id`) USING BTREE,
  INDEX `Fk_equipment_equipment_type`(`equipment_type_id`) USING BTREE,
  CONSTRAINT `Fk_equipment_equipment_type` FOREIGN KEY (`equipment_type_id`) REFERENCES `equipment_type` (`equipment_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_equipment_production_line` FOREIGN KEY (`production_line_id`) REFERENCES `production_line` (`production_line_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_equipment_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_equipment_working` FOREIGN KEY (`working_id`) REFERENCES `working` (`working_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equipment_report
-- ----------------------------
DROP TABLE IF EXISTS `equipment_report`;
CREATE TABLE `equipment_report`  (
  `equipment_report_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '异常报告主键自增',
  `equipment_report_reason` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停用原因\r\n',
  `maintenance_plan` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '维修计划\r\n',
  `end_date` datetime(0) NOT NULL COMMENT '预计恢复时间',
  `user_id` int(11) NOT NULL COMMENT '登记人',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `equipment_id` int(11) NOT NULL COMMENT '设备外键',
  PRIMARY KEY (`equipment_report_id`) USING BTREE,
  INDEX `Fk_equipment_report_user`(`user_id`) USING BTREE,
  INDEX `Fk_equipment_report_equipment`(`equipment_id`) USING BTREE,
  CONSTRAINT `Fk_equipment_report_equipment` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`equipment_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_equipment_report_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equipment_type
-- ----------------------------
DROP TABLE IF EXISTS `equipment_type`;
CREATE TABLE `equipment_type`  (
  `equipment_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备状态主键',
  `equipment_type_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`equipment_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment_type
-- ----------------------------
INSERT INTO `equipment_type` VALUES (1, '正常', 0);
INSERT INTO `equipment_type` VALUES (2, '维修中', 0);
INSERT INTO `equipment_type` VALUES (3, '检修', 0);
INSERT INTO `equipment_type` VALUES (4, '损坏', 0);

-- ----------------------------
-- Table structure for everyday_purchasing_plan
-- ----------------------------
DROP TABLE IF EXISTS `everyday_purchasing_plan`;
CREATE TABLE `everyday_purchasing_plan`  (
  `everyday_purchasing_plan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '每日采购计划表id主键自增',
  `everyday_purchasing_plan_no` int(11) NOT NULL COMMENT '采购批次',
  `everyday_purchasing_plan_date` datetime(0) NOT NULL COMMENT '采购时间',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`everyday_purchasing_plan_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for everyday_purchasing_plan_term
-- ----------------------------
DROP TABLE IF EXISTS `everyday_purchasing_plan_term`;
CREATE TABLE `everyday_purchasing_plan_term`  (
  `everyday_purchasing_plan_term_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '每日采购计划项主键',
  `materiel_id` int(11) NOT NULL COMMENT '物料id外键',
  `materiel_number` int(11) NOT NULL COMMENT '数量',
  `unit_price` double NOT NULL COMMENT '预计采购单价',
  `price_float` double NOT NULL COMMENT '价格允许浮动范围\r\n',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注\r\n',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `everyday_purchasing_plan_id` int(11) NOT NULL COMMENT '所属计划,计划表id\r\n',
  PRIMARY KEY (`everyday_purchasing_plan_term_id`) USING BTREE,
  INDEX `Fk_everyday_materiel`(`materiel_id`) USING BTREE,
  INDEX `Fk_everyday_purchasing_plan`(`everyday_purchasing_plan_id`) USING BTREE,
  CONSTRAINT `Fk_everyday_materiel` FOREIGN KEY (`materiel_id`) REFERENCES `materiel` (`materiel_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_everyday_purchasing_plan` FOREIGN KEY (`everyday_purchasing_plan_id`) REFERENCES `everyday_purchasing_plan` (`everyday_purchasing_plan_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for function
-- ----------------------------
DROP TABLE IF EXISTS `function`;
CREATE TABLE `function`  (
  `function_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '功能表主键',
  `function_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '功能名称',
  `function_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '功能url',
  `jurisdiction_id` int(11) NOT NULL COMMENT '权限id',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `type` int(11) NOT NULL,
  PRIMARY KEY (`function_id`) USING BTREE,
  INDEX `Fk_function_jurisdiction`(`jurisdiction_id`) USING BTREE,
  CONSTRAINT `Fk_function_jurisdiction` FOREIGN KEY (`jurisdiction_id`) REFERENCES `jurisdiction` (`jurisdiction_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of function
-- ----------------------------
INSERT INTO `function` VALUES (1, '菜谱管理', 'menulist.do', 1, 0, 0);
INSERT INTO `function` VALUES (4, '新增菜谱', '###', 1, 0, 1);
INSERT INTO `function` VALUES (5, '物料管理', 'materiellist.do', 1, 0, 0);
INSERT INTO `function` VALUES (6, '工艺管理', 'technology.do', 1, 0, 0);
INSERT INTO `function` VALUES (7, '新增物料', 'addMateriel.do', 1, 0, 1);
INSERT INTO `function` VALUES (8, '删除物料', 'delmateriel.do', 1, 0, 1);
INSERT INTO `function` VALUES (9, '新增工艺', 'addTechnology.do', 1, 0, 1);
INSERT INTO `function` VALUES (10, '删除工艺', 'delTechnology.do', 1, 0, 1);
INSERT INTO `function` VALUES (11, '修改菜谱', '###', 1, 0, 1);
INSERT INTO `function` VALUES (12, '删除菜谱', '###', 1, 0, 1);
INSERT INTO `function` VALUES (13, '修改物料', '###', 1, 0, 1);
INSERT INTO `function` VALUES (14, '修改工艺', '###', 1, 0, 1);
INSERT INTO `function` VALUES (15, '门店管理', 'store/index.do', 2, 0, 0);
INSERT INTO `function` VALUES (17, '添加门店', 'store/add.do', 2, 0, 1);
INSERT INTO `function` VALUES (18, '门店修改', '/store/edit.do', 2, 0, 1);
INSERT INTO `function` VALUES (19, '门店详细信息查询', 'store/toView.do', 2, 0, 1);
INSERT INTO `function` VALUES (20, '删除门店', 'store/delete.do\r\n', 2, 0, 1);
INSERT INTO `function` VALUES (21, '临时订单管理', 'temporary/order/index.do', 2, 0, 0);
INSERT INTO `function` VALUES (23, '添加临时订单', '/temporary/order/add.do', 2, 0, 1);
INSERT INTO `function` VALUES (24, '临时订单详细信息查询', '/temporary/order/toView.do', 2, 0, 1);

-- ----------------------------
-- Table structure for goods_shelve
-- ----------------------------
DROP TABLE IF EXISTS `goods_shelve`;
CREATE TABLE `goods_shelve`  (
  `goods_shelve_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '货架表id自增',
  `goods_shelve_no` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '货架编号',
  `materiel_id` int(11) NOT NULL COMMENT '当前所放物料外键',
  `materiel_number` int(11) NOT NULL COMMENT '当前数量',
  `materiel_shelf_life_end_date` date NOT NULL COMMENT '到期时间',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `warehouse_region_id` int(11) NOT NULL COMMENT '仓库区域表外键',
  PRIMARY KEY (`goods_shelve_id`) USING BTREE,
  INDEX `Fk_goods_shelve_materiel`(`materiel_id`) USING BTREE,
  INDEX `Fk_goods_shelve_warehouse_region`(`warehouse_region_id`) USING BTREE,
  CONSTRAINT `Fk_goods_shelve_materiel` FOREIGN KEY (`materiel_id`) REFERENCES `materiel` (`materiel_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_goods_shelve_warehouse_region` FOREIGN KEY (`warehouse_region_id`) REFERENCES `warehouse_region` (`warehouse_region_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_shelve
-- ----------------------------
INSERT INTO `goods_shelve` VALUES (1, '013001', 1, 200, '2017-12-12', 0, 1);
INSERT INTO `goods_shelve` VALUES (2, '013002', 2, 100, '2017-12-12', 0, 2);
INSERT INTO `goods_shelve` VALUES (3, '013003', 3, 250, '2017-12-12', 0, 3);
INSERT INTO `goods_shelve` VALUES (4, '013004', 4, 270, '2017-12-12', 0, 1);
INSERT INTO `goods_shelve` VALUES (5, '013005', 5, 230, '2017-12-12', 0, 2);
INSERT INTO `goods_shelve` VALUES (6, '013006', 6, 300, '2017-12-12', 0, 3);
INSERT INTO `goods_shelve` VALUES (7, '013007', 7, 600, '2017-12-12', 0, 1);
INSERT INTO `goods_shelve` VALUES (8, '013008', 8, 700, '2017-12-12', 0, 2);
INSERT INTO `goods_shelve` VALUES (9, '013009', 9, 290, '2017-12-12', 0, 3);
INSERT INTO `goods_shelve` VALUES (10, '013020', 10, 120, '2017-12-12', 0, 1);

-- ----------------------------
-- Table structure for jurisdiction
-- ----------------------------
DROP TABLE IF EXISTS `jurisdiction`;
CREATE TABLE `jurisdiction`  (
  `jurisdiction_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id自增',
  `jurisdiction_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `jurisdiction_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'url',
  `status` int(50) NOT NULL COMMENT '删除伪列',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`jurisdiction_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jurisdiction
-- ----------------------------
INSERT INTO `jurisdiction` VALUES (1, '研发管理', '#', 0, 'icon-book-open');
INSERT INTO `jurisdiction` VALUES (2, '订单管理', '#', 0, 'fa fa-shopping-cart');
INSERT INTO `jurisdiction` VALUES (3, '信息计划管理', '#', 0, 'fa fa-send-o (alias)');
INSERT INTO `jurisdiction` VALUES (4, '采购管理', '#', 0, 'fa fa-truck');
INSERT INTO `jurisdiction` VALUES (5, '库存管理', '#', 0, 'ti-layout-grid3-alt');
INSERT INTO `jurisdiction` VALUES (6, '生产管理', '#', 0, 'icon-fire');
INSERT INTO `jurisdiction` VALUES (7, '质量控制管理', '#', 0, 'ti-html5');
INSERT INTO `jurisdiction` VALUES (8, '设备管理', '#', 0, 'ti-anchor');
INSERT INTO `jurisdiction` VALUES (9, '数据监控', '#', 0, 'fa fa-signal');
INSERT INTO `jurisdiction` VALUES (10, '管理员管理', '#', 0, 'icon-people');

-- ----------------------------
-- Table structure for materiel
-- ----------------------------
DROP TABLE IF EXISTS `materiel`;
CREATE TABLE `materiel`  (
  `materiel_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物料表主键自增',
  `materiel_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物料名称',
  `materiel_type_level_b_id` int(11) NOT NULL COMMENT '类别二级分类id外键',
  `materiel_unit_id` int(11) NOT NULL COMMENT '单位id外键',
  `materiel_yield` double NOT NULL COMMENT '出成率(0-1)',
  `materiel__shelf_life` int(11) NOT NULL COMMENT '保质期',
  `materiel_min_warning` int(11) NOT NULL COMMENT '最低库存预警',
  `materiel_remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`materiel_id`) USING BTREE,
  INDEX `Fk_materiel_type_level_b`(`materiel_type_level_b_id`) USING BTREE,
  INDEX `Fk_materiel_unit`(`materiel_unit_id`) USING BTREE,
  CONSTRAINT `Fk_materiel_type_level_b` FOREIGN KEY (`materiel_type_level_b_id`) REFERENCES `materiel_type_level_b` (`materiel_type_level_b_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_materiel_unit` FOREIGN KEY (`materiel_unit_id`) REFERENCES `materiel_unit` (`materiel_unit_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of materiel
-- ----------------------------
INSERT INTO `materiel` VALUES (1, '五花肉', 1, 1, 0.5, 30, 100, '快用', 0);
INSERT INTO `materiel` VALUES (2, '猪头', 1, 1, 0.5, 29, 200, '快用', 0);
INSERT INTO `materiel` VALUES (3, '前腿肉', 1, 1, 0.5, 28, 100, '快用', 0);
INSERT INTO `materiel` VALUES (4, '里脊皮肉', 1, 1, 0.5, 17, 300, '快用', 0);
INSERT INTO `materiel` VALUES (5, '后腿肉', 1, 1, 0.5, 56, 100, '快用', 0);
INSERT INTO `materiel` VALUES (6, '后肘', 1, 1, 0.5, 10, 200, '快用', 0);
INSERT INTO `materiel` VALUES (7, '后脚', 1, 1, 0.5, 9, 50, '快用', 0);
INSERT INTO `materiel` VALUES (8, '猪尾巴', 1, 1, 0.22, 1, 60, '快用', 0);
INSERT INTO `materiel` VALUES (9, '正宝肋', 1, 1, 0.5, 52, 70, '快用', 0);
INSERT INTO `materiel` VALUES (10, '奶脯肉', 1, 1, 0.5, 32, 90, '快用', 0);
INSERT INTO `materiel` VALUES (11, '青椒', 7, 1, 0.5, 20, 100, NULL, 0);
INSERT INTO `materiel` VALUES (12, '腌制调料', 1, 1, 0.5, 20, 100, NULL, 0);
INSERT INTO `materiel` VALUES (13, '保鲜膜', 11, 7, 1, 999, 100, NULL, 0);
INSERT INTO `materiel` VALUES (14, '冷却器具', 12, 7, 1, 999, 100, '', 0);
INSERT INTO `materiel` VALUES (15, '芹菜', 8, 1, 0.5, 30, 100, '芹菜', 0);
INSERT INTO `materiel` VALUES (16, '雪菜', 7, 1, 0.2, 120, 120, '雪菜', 0);
INSERT INTO `materiel` VALUES (17, '菠菜', 8, 1, 0.5, 120, 120, '阿萨德阿萨德', 0);
INSERT INTO `materiel` VALUES (18, '鸡腿肉', 4, 1, 1, 120, 200, '鸡腿肉', 0);

-- ----------------------------
-- Table structure for materiel_type_level_a
-- ----------------------------
DROP TABLE IF EXISTS `materiel_type_level_a`;
CREATE TABLE `materiel_type_level_a`  (
  `materiel_type_level_a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物料一级类id自增',
  `materiel_type_level_a_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`materiel_type_level_a_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of materiel_type_level_a
-- ----------------------------
INSERT INTO `materiel_type_level_a` VALUES (1, '肉奶蛋类', 0);
INSERT INTO `materiel_type_level_a` VALUES (2, '蔬果类', 0);
INSERT INTO `materiel_type_level_a` VALUES (3, '水产品', 0);
INSERT INTO `materiel_type_level_a` VALUES (4, '配料', 0);
INSERT INTO `materiel_type_level_a` VALUES (5, '包材', 0);
INSERT INTO `materiel_type_level_a` VALUES (6, '工具类', 0);
INSERT INTO `materiel_type_level_a` VALUES (7, '清洁类', 0);
INSERT INTO `materiel_type_level_a` VALUES (8, '化学品', 0);
INSERT INTO `materiel_type_level_a` VALUES (9, '设备', 0);
INSERT INTO `materiel_type_level_a` VALUES (10, '服务', 0);

-- ----------------------------
-- Table structure for materiel_type_level_b
-- ----------------------------
DROP TABLE IF EXISTS `materiel_type_level_b`;
CREATE TABLE `materiel_type_level_b`  (
  `materiel_type_level_b_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物料二级类id自增',
  `materiel_type_level_b_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `materiel_type_level_a_id` int(11) NOT NULL COMMENT '一级分类id',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`materiel_type_level_b_id`) USING BTREE,
  INDEX `Fk_b_type_a`(`materiel_type_level_a_id`) USING BTREE,
  CONSTRAINT `Fk_b_type_a` FOREIGN KEY (`materiel_type_level_a_id`) REFERENCES `materiel_type_level_a` (`materiel_type_level_a_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of materiel_type_level_b
-- ----------------------------
INSERT INTO `materiel_type_level_b` VALUES (1, '猪肉', 1, 0);
INSERT INTO `materiel_type_level_b` VALUES (2, '牛肉', 1, 0);
INSERT INTO `materiel_type_level_b` VALUES (3, '羊肉', 1, 0);
INSERT INTO `materiel_type_level_b` VALUES (4, '禽类', 1, 0);
INSERT INTO `materiel_type_level_b` VALUES (5, '蛋类', 1, 0);
INSERT INTO `materiel_type_level_b` VALUES (6, '乳制品', 1, 0);
INSERT INTO `materiel_type_level_b` VALUES (7, '绿叶菜', 2, 0);
INSERT INTO `materiel_type_level_b` VALUES (8, '根茎类', 2, 0);
INSERT INTO `materiel_type_level_b` VALUES (9, '瓜果类', 2, 0);
INSERT INTO `materiel_type_level_b` VALUES (10, '河生鲜', 3, 0);
INSERT INTO `materiel_type_level_b` VALUES (11, '保鲜膜', 5, 0);
INSERT INTO `materiel_type_level_b` VALUES (12, '冷却工具', 6, 0);

-- ----------------------------
-- Table structure for materiel_unit
-- ----------------------------
DROP TABLE IF EXISTS `materiel_unit`;
CREATE TABLE `materiel_unit`  (
  `materiel_unit_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '单位表id自增',
  `materiel_unit_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位名称',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`materiel_unit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of materiel_unit
-- ----------------------------
INSERT INTO `materiel_unit` VALUES (1, '斤', 0);
INSERT INTO `materiel_unit` VALUES (2, '箱', 0);
INSERT INTO `materiel_unit` VALUES (3, '桶', 0);
INSERT INTO `materiel_unit` VALUES (4, '盒', 0);
INSERT INTO `materiel_unit` VALUES (5, '公斤', 0);
INSERT INTO `materiel_unit` VALUES (6, '只', 0);
INSERT INTO `materiel_unit` VALUES (7, '扎', 0);
INSERT INTO `materiel_unit` VALUES (8, '瓶', 0);
INSERT INTO `materiel_unit` VALUES (9, '条', 0);
INSERT INTO `materiel_unit` VALUES (10, '头', 0);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜谱表id主键,自增',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜谱名称',
  `menu_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜谱编码',
  `menu_type_id` int(11) NOT NULL COMMENT '菜谱类别id外键',
  `menu_weight` double NOT NULL COMMENT '净重',
  `menu_cost` double NOT NULL COMMENT '成本',
  `menu_image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径',
  `menu_store_max` int(11) NOT NULL COMMENT '储存条件(最高温度)',
  `menu_store_min` int(11) NOT NULL COMMENT '储存条件(最低温度)',
  `menu_shelf_life` int(11) NOT NULL COMMENT '保质期',
  `menu_create_date` datetime(0) NOT NULL COMMENT '创建时间',
  `menu_state_id` int(11) NOT NULL COMMENT '状态id外键',
  `menu_release_date` datetime(0) NOT NULL COMMENT '发布时间',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `menu_remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE,
  INDEX `Fk_meun_type`(`menu_type_id`) USING BTREE,
  INDEX `Fk_menu_state`(`menu_state_id`) USING BTREE,
  CONSTRAINT `Fk_menu_state` FOREIGN KEY (`menu_state_id`) REFERENCES `menu_state` (`menu_state_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_meun_type` FOREIGN KEY (`menu_type_id`) REFERENCES `menu_type` (`menu_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '青椒肉丝', '12345678911', 1, 20.1, 5, 'qingjiaorousi.jpg', 0, -10, 20, '2017-10-21 00:00:00', 1, '2017-11-21 00:00:00', 0, '储存时间较短');
INSERT INTO `menu` VALUES (2, '蒸羊羔', '51711001', 1, 21.1, 5, 'zhengyanggao.jpg', 0, -10, 20, '2017-10-21 00:00:00', 2, '2017-11-21 00:00:00', 0, '储存时间较短');
INSERT INTO `menu` VALUES (3, '烧雏鸡儿', '517112001', 1, 22.1, 5, 'shaochuji.jpg', 0, -10, 20, '2017-10-21 00:00:00', 3, '2017-11-21 00:00:00', 0, '储存时间较短');
INSERT INTO `menu` VALUES (4, '烧花鸭', '517111001', 1, 22.1, 5, 'shaohuaya.jpg', 0, -10, 20, '2017-10-21 00:00:00', 1, '2017-11-21 00:00:00', 0, '储存时间较短');
INSERT INTO `menu` VALUES (5, '罐儿野鸡', '517112101', 1, 23.1, 5, 'shaochuji.jpg', 0, -10, 20, '2017-10-21 00:00:00', 1, '2017-11-21 00:00:00', 0, '储存时间较短');
INSERT INTO `menu` VALUES (6, '炝虾仁儿', '517112102', 1, 24.1, 5, 'qiangxiaren.jpg', 0, -10, 20, '2017-10-21 00:00:00', 2, '2017-11-21 00:00:00', 0, '储存时间较短');
INSERT INTO `menu` VALUES (7, '什锦苏盘', '517112103', 2, 25.1, 5, 'shenjin.jpg', 0, -10, 20, '2017-10-21 00:00:00', 3, '2017-11-21 00:00:00', 0, '储存时间较短');
INSERT INTO `menu` VALUES (8, '麻酥油卷儿', '517112104', 5, 26.1, 5, 'su.jpg', 20, -10, 20, '2017-10-21 00:00:00', 1, '2017-11-21 00:00:00', 0, '储存时间较短');
INSERT INTO `menu` VALUES (9, '糖熘饹炸儿', '517112105', 5, 27.1, 5, '20171128151183181253810588875.jpg', 20, -10, 20, '2017-10-21 00:00:00', 3, '2017-11-21 00:00:00', 0, '储存时间较短');
INSERT INTO `menu` VALUES (10, '烩鳗鱼', '517112106', 1, 30, 5, 'yu.jpg', 0, -10, 20, '2017-10-21 00:00:00', 3, '2017-11-21 00:00:00', 0, '储存时间较短');

-- ----------------------------
-- Table structure for menu_flow
-- ----------------------------
DROP TABLE IF EXISTS `menu_flow`;
CREATE TABLE `menu_flow`  (
  `menu_flow_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品制作流程表id自增',
  `menu_materiel_id` int(11) NOT NULL COMMENT '菜物关系表id外键',
  `working_id` int(11) NOT NULL COMMENT '工序表id外键',
  `technology_id` int(11) NOT NULL COMMENT '工艺表id外键',
  `menu_flow_describe` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `menu_flow_hour` double(11, 2) NOT NULL COMMENT '耗时(H)',
  `menu_flow_image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`menu_flow_id`) USING BTREE,
  INDEX `Fk_flow_menu_materiel`(`menu_materiel_id`) USING BTREE,
  INDEX `Fk_flow_working`(`working_id`) USING BTREE,
  INDEX `Fk_flow_technology`(`technology_id`) USING BTREE,
  CONSTRAINT `Fk_flow_menu_materiel` FOREIGN KEY (`menu_materiel_id`) REFERENCES `menu_materiel` (`menu_materiel_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_flow_technology` FOREIGN KEY (`technology_id`) REFERENCES `technology` (`technology_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_flow_working` FOREIGN KEY (`working_id`) REFERENCES `working` (`working_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_flow
-- ----------------------------
INSERT INTO `menu_flow` VALUES (1, 1, 1, 6, '解冻温度6℃-10℃ 1小时', 1.00, '...', 0);
INSERT INTO `menu_flow` VALUES (2, 2, 1, 1, '浸泡清洗,水温控制在5℃-7℃', 0.10, '...', 0);
INSERT INTO `menu_flow` VALUES (3, 3, 1, 11, '将调料搅拌均匀', 0.10, '...', 0);
INSERT INTO `menu_flow` VALUES (4, 1, 2, 3, '将五花肉切成丝 3cm-4cm', 0.10, '...', 0);
INSERT INTO `menu_flow` VALUES (5, 2, 2, 2, '将青椒切片', 0.10, '...', 0);
INSERT INTO `menu_flow` VALUES (7, 1, 3, 13, '将肉爆炒', 0.10, '...', 0);
INSERT INTO `menu_flow` VALUES (8, 2, 3, 13, '出现肉香后倒入辣椒混合烹饪', 0.22, '...', 0);
INSERT INTO `menu_flow` VALUES (9, 3, 3, 13, '与辣椒一起倒入', 0.22, '...', 0);
INSERT INTO `menu_flow` VALUES (12, 5, 4, 14, '使用冷却器具冷却半小时', 0.50, '...', 0);
INSERT INTO `menu_flow` VALUES (13, 4, 5, 9, '保鲜膜包装', 0.10, '...', 0);
INSERT INTO `menu_flow` VALUES (14, 1, 1, 10, '将水控干净包证肉质', 0.50, '...', 0);

-- ----------------------------
-- Table structure for menu_materiel
-- ----------------------------
DROP TABLE IF EXISTS `menu_materiel`;
CREATE TABLE `menu_materiel`  (
  `menu_materiel_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜谱物料关系表id自增',
  `menu_id` int(11) NOT NULL COMMENT '菜谱id',
  `materiel_id` int(11) NOT NULL COMMENT '物料id',
  `menu_materiel_type` int(11) NOT NULL COMMENT '类别(0-3)主,辅,配,耗材',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`menu_materiel_id`) USING BTREE,
  INDEX `Fk_materiel_menu_id`(`menu_id`) USING BTREE,
  INDEX `Fk_materiel_id`(`materiel_id`) USING BTREE,
  CONSTRAINT `Fk_materiel_id` FOREIGN KEY (`materiel_id`) REFERENCES `materiel` (`materiel_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_materiel_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_materiel
-- ----------------------------
INSERT INTO `menu_materiel` VALUES (1, 1, 1, 0, 0);
INSERT INTO `menu_materiel` VALUES (2, 1, 11, 1, 0);
INSERT INTO `menu_materiel` VALUES (3, 1, 12, 2, 0);
INSERT INTO `menu_materiel` VALUES (4, 1, 13, 3, 0);
INSERT INTO `menu_materiel` VALUES (5, 1, 14, 3, 0);

-- ----------------------------
-- Table structure for menu_state
-- ----------------------------
DROP TABLE IF EXISTS `menu_state`;
CREATE TABLE `menu_state`  (
  `menu_state_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜谱状态主键自增',
  `menu_state_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态名称',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`menu_state_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_state
-- ----------------------------
INSERT INTO `menu_state` VALUES (1, '研发中', 0);
INSERT INTO `menu_state` VALUES (2, '已发布', 0);
INSERT INTO `menu_state` VALUES (3, '暂时停售', 0);

-- ----------------------------
-- Table structure for menu_type
-- ----------------------------
DROP TABLE IF EXISTS `menu_type`;
CREATE TABLE `menu_type`  (
  `menu_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜谱类别主键自增',
  `menu_type_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型名称',
  `menu_type_no` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类编码',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`menu_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_type
-- ----------------------------
INSERT INTO `menu_type` VALUES (1, '大荤', '0001', 0);
INSERT INTO `menu_type` VALUES (2, '素食', '0002', 0);
INSERT INTO `menu_type` VALUES (3, '汤', '0003', 0);
INSERT INTO `menu_type` VALUES (4, '粥', '0004', 0);
INSERT INTO `menu_type` VALUES (5, '零食', '0005', 0);

-- ----------------------------
-- Table structure for order_contract
-- ----------------------------
DROP TABLE IF EXISTS `order_contract`;
CREATE TABLE `order_contract`  (
  `order_contract_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单合同表id自增',
  `order_contract_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合同名称',
  `order_contract_image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单图片路径',
  `order_contract_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合同号',
  `order_contract_date` date NOT NULL COMMENT '合同签订时间',
  `store_id` int(11) NOT NULL COMMENT '所属用户id外键',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`order_contract_id`) USING BTREE,
  INDEX `Fk_contract_store`(`store_id`) USING BTREE,
  CONSTRAINT `Fk_contract_store` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_goods_shelve
-- ----------------------------
DROP TABLE IF EXISTS `product_goods_shelve`;
CREATE TABLE `product_goods_shelve`  (
  `product_goods_shelve_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成品货架表id自增',
  `product_goods_shelve_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '货架编号',
  `menu_id` int(11) NOT NULL COMMENT '当前所放菜品外键',
  `menu_number` int(11) NOT NULL COMMENT '当前数量',
  `materiel_shelf_life_end_date` date NOT NULL COMMENT '到期时间',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `product_warehouse_region_id` int(11) NOT NULL COMMENT '成品仓库区域表外键',
  PRIMARY KEY (`product_goods_shelve_id`) USING BTREE,
  INDEX `Fk_product_goods_shelve_menu`(`menu_id`) USING BTREE,
  INDEX `Fk_product_warehouse_region`(`product_warehouse_region_id`) USING BTREE,
  CONSTRAINT `Fk_product_goods_shelve_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_product_warehouse_region` FOREIGN KEY (`product_warehouse_region_id`) REFERENCES `product_warehouse_region` (`product_warehouse_region_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_goods_shelve
-- ----------------------------
INSERT INTO `product_goods_shelve` VALUES (1, 'c01001', 1, 200, '2017-12-12', 0, 1);
INSERT INTO `product_goods_shelve` VALUES (2, 'c01002', 2, 200, '2017-12-12', 0, 2);
INSERT INTO `product_goods_shelve` VALUES (3, 'c01003', 3, 200, '2017-12-12', 0, 3);
INSERT INTO `product_goods_shelve` VALUES (4, 'c01004', 4, 200, '2017-12-12', 0, 4);
INSERT INTO `product_goods_shelve` VALUES (5, 'c01005', 5, 200, '2017-12-12', 0, 5);
INSERT INTO `product_goods_shelve` VALUES (8, 'c01006', 6, 200, '2017-12-12', 0, 1);
INSERT INTO `product_goods_shelve` VALUES (9, 'c01007', 7, 200, '2017-12-12', 0, 2);
INSERT INTO `product_goods_shelve` VALUES (10, 'c01008', 8, 200, '2017-12-12', 0, 3);
INSERT INTO `product_goods_shelve` VALUES (11, 'c01009', 9, 200, '2017-12-12', 0, 4);
INSERT INTO `product_goods_shelve` VALUES (12, 'c01010', 10, 200, '2017-12-12', 0, 5);

-- ----------------------------
-- Table structure for product_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `product_warehouse`;
CREATE TABLE `product_warehouse`  (
  `product_warehouse_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成品仓库表主键自增',
  `product_warehouse_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`product_warehouse_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_warehouse
-- ----------------------------
INSERT INTO `product_warehouse` VALUES (1, '第一成品仓库', '备注每日发货', 0);
INSERT INTO `product_warehouse` VALUES (2, '第二成品仓库', '备注阶段发货', 0);
INSERT INTO `product_warehouse` VALUES (3, '第三成品仓库', '备注合同发货', 0);

-- ----------------------------
-- Table structure for product_warehouse_out_register
-- ----------------------------
DROP TABLE IF EXISTS `product_warehouse_out_register`;
CREATE TABLE `product_warehouse_out_register`  (
  `product_warehouse_out_register_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成品库出库登记表主键',
  `product_warehouse_out_register_end_date` datetime(0) NOT NULL COMMENT '出库时间',
  `user_id` int(11) NOT NULL COMMENT '用户表id外键领料人',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`product_warehouse_out_register_id`) USING BTREE,
  INDEX `Fk_product_warehouse_out_register_user`(`user_id`) USING BTREE,
  CONSTRAINT `Fk_product_warehouse_out_register_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_warehouse_out_register_item
-- ----------------------------
DROP TABLE IF EXISTS `product_warehouse_out_register_item`;
CREATE TABLE `product_warehouse_out_register_item`  (
  `product_warehouse_out_register_item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成品库出库登记表项主键',
  `menu_id` int(11) NOT NULL COMMENT '菜品id外键',
  `product_goods_shelve_id` int(11) NOT NULL COMMENT '货架id',
  `menu_number` int(11) NOT NULL COMMENT '出库数量',
  `product_warehouse_out_register_id` int(11) NOT NULL COMMENT '成品出口登记表外键',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`product_warehouse_out_register_item_id`) USING BTREE,
  INDEX `Fk_product_register_item_menu`(`menu_id`) USING BTREE,
  INDEX `Fk_product_register_item_product_goods_shelve`(`product_goods_shelve_id`) USING BTREE,
  INDEX `Fk_product_register_item_product_warehouse_out_register`(`product_warehouse_out_register_id`) USING BTREE,
  CONSTRAINT `Fk_product_register_item_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_product_register_item_product_goods_shelve` FOREIGN KEY (`product_goods_shelve_id`) REFERENCES `product_goods_shelve` (`product_goods_shelve_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_product_register_item_product_warehouse_out_register` FOREIGN KEY (`product_warehouse_out_register_id`) REFERENCES `product_warehouse_out_register` (`product_warehouse_out_register_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_warehouse_region
-- ----------------------------
DROP TABLE IF EXISTS `product_warehouse_region`;
CREATE TABLE `product_warehouse_region`  (
  `product_warehouse_region_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成品仓库区域表id自增',
  `product_warehouse_region_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区域编号',
  `menu_type_id` int(11) NOT NULL COMMENT '菜品类型id(规定)外键',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(11) NOT NULL COMMENT '删除伪劣',
  `product_warehouse_id` int(11) NOT NULL COMMENT '成品仓库id外键',
  PRIMARY KEY (`product_warehouse_region_id`) USING BTREE,
  INDEX `Fk_product_warehouse_region_menu_type`(`menu_type_id`) USING BTREE,
  INDEX `Fk_product_warehouse_region_product_warehouse`(`product_warehouse_id`) USING BTREE,
  CONSTRAINT `Fk_product_warehouse_region_menu_type` FOREIGN KEY (`menu_type_id`) REFERENCES `menu_type` (`menu_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_product_warehouse_region_product_warehouse` FOREIGN KEY (`product_warehouse_id`) REFERENCES `product_warehouse` (`product_warehouse_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_warehouse_region
-- ----------------------------
INSERT INTO `product_warehouse_region` VALUES (1, '01001', 1, '...', 0, 1);
INSERT INTO `product_warehouse_region` VALUES (2, '01002', 2, '...', 0, 1);
INSERT INTO `product_warehouse_region` VALUES (3, '01003', 3, '...', 0, 1);
INSERT INTO `product_warehouse_region` VALUES (4, '01004', 4, '...', 0, 1);
INSERT INTO `product_warehouse_region` VALUES (5, '02001', 5, '...', 0, 2);
INSERT INTO `product_warehouse_region` VALUES (7, '02002', 1, '...', 0, 2);
INSERT INTO `product_warehouse_region` VALUES (8, '02003', 2, '...', 0, 2);
INSERT INTO `product_warehouse_region` VALUES (9, '02004', 3, '...', 0, 2);
INSERT INTO `product_warehouse_region` VALUES (10, '03001', 4, '...', 0, 3);
INSERT INTO `product_warehouse_region` VALUES (11, '03002', 5, '...', 0, 3);

-- ----------------------------
-- Table structure for product_warehouse_register
-- ----------------------------
DROP TABLE IF EXISTS `product_warehouse_register`;
CREATE TABLE `product_warehouse_register`  (
  `product_warehouse_register_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成品库入库登记表主键',
  `production_batch` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产批次(不用设置外键)',
  `product_warehouse_register_date` datetime(0) NOT NULL COMMENT '入库时间\r\n',
  `user_id` int(11) NOT NULL COMMENT '入库人用户表外键\r\n',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`product_warehouse_register_id`) USING BTREE,
  INDEX `Fk_product_warehouse_register_user`(`user_id`) USING BTREE,
  CONSTRAINT `Fk_product_warehouse_register_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_warehouse_register_item
-- ----------------------------
DROP TABLE IF EXISTS `product_warehouse_register_item`;
CREATE TABLE `product_warehouse_register_item`  (
  `product_warehouse_register_item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成品库入库登记记录项主键',
  `menu_id` int(11) NOT NULL COMMENT '菜品id外键',
  `product_goods_shelve_id` int(11) NOT NULL COMMENT '成品货架id',
  `menu_number` int(11) NOT NULL COMMENT '入库数量',
  `product_warehouse_register_id` int(11) NOT NULL COMMENT '成品入库记录id外键',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`product_warehouse_register_item_id`) USING BTREE,
  INDEX `Fk_product_item_menu`(`menu_id`) USING BTREE,
  INDEX `Fk_product_item_product_goods_shelve`(`product_goods_shelve_id`) USING BTREE,
  INDEX `Fk_product_item_product_warehouse_register`(`product_warehouse_register_id`) USING BTREE,
  CONSTRAINT `Fk_product_item_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_product_item_product_goods_shelve` FOREIGN KEY (`product_goods_shelve_id`) REFERENCES `product_goods_shelve` (`product_goods_shelve_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_product_item_product_warehouse_register` FOREIGN KEY (`product_warehouse_register_id`) REFERENCES `product_warehouse_register` (`product_warehouse_register_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for production_line
-- ----------------------------
DROP TABLE IF EXISTS `production_line`;
CREATE TABLE `production_line`  (
  `production_line_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '生产线表主键',
  `production_line_no` int(11) NOT NULL COMMENT '生产线编号',
  `production_line_state` int(11) NOT NULL COMMENT '生产线状态',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`production_line_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for production_standard
-- ----------------------------
DROP TABLE IF EXISTS `production_standard`;
CREATE TABLE `production_standard`  (
  `production_standard_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '生产品控主键自增',
  `production_batch` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '生产批次(不用设外键\r\n',
  `standard_a_type` int(11) NOT NULL COMMENT '标准a类型\r\n',
  `standard_a_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标准a名称\r\n',
  `standard_b_type` int(11) NULL DEFAULT NULL COMMENT '标准b类型\r\n',
  `standard_b_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标准b名称\r\n',
  `standard_c_type` int(11) NULL DEFAULT NULL COMMENT '标准c类型\r\n',
  `standard_c_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标准c名称\r\n',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注\r\n',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`production_standard_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for production_standard_record
-- ----------------------------
DROP TABLE IF EXISTS `production_standard_record`;
CREATE TABLE `production_standard_record`  (
  `production_standard_record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物料品控评估记录主键',
  `production_standard_id` int(11) NOT NULL COMMENT '标准id',
  `standard_a_score` int(11) NOT NULL COMMENT '标准a评分',
  `standard_b_score` int(11) NULL DEFAULT NULL COMMENT '标准b评分',
  `standard_c_score` int(11) NULL DEFAULT NULL COMMENT '标准c评分',
  `conclusion` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '结论',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`production_standard_record_id`) USING BTREE,
  INDEX `Fk_production_standard_record_production_standard`(`production_standard_id`) USING BTREE,
  CONSTRAINT `Fk_production_standard_record_production_standard` FOREIGN KEY (`production_standard_id`) REFERENCES `production_standard` (`production_standard_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase`  (
  `purchase_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购表id自增',
  `everyday_purchasing_plan_id` int(11) NOT NULL COMMENT '每日采购计划id外键',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `purchase_date` date NOT NULL COMMENT '采购时间',
  `user_id` int(11) NOT NULL COMMENT '用户表id外键(采购人)',
  PRIMARY KEY (`purchase_id`) USING BTREE,
  INDEX `Fk_purchase_user`(`user_id`) USING BTREE,
  INDEX `Fk_purchase_everyday_purchasing_plan`(`everyday_purchasing_plan_id`) USING BTREE,
  CONSTRAINT `Fk_purchase_everyday_purchasing_plan` FOREIGN KEY (`everyday_purchasing_plan_id`) REFERENCES `everyday_purchasing_plan` (`everyday_purchasing_plan_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_purchase_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for purchase_item
-- ----------------------------
DROP TABLE IF EXISTS `purchase_item`;
CREATE TABLE `purchase_item`  (
  `purchase_item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购项id自增',
  `materiel_id` int(11) NOT NULL COMMENT '物料id外键',
  `materiel_number` int(11) NOT NULL COMMENT '数量',
  `unit_price` double NOT NULL COMMENT '采购单价',
  `supplier_id` int(11) NOT NULL COMMENT '供应商id外键',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `purchase_id` int(11) NOT NULL COMMENT '采购表id',
  PRIMARY KEY (`purchase_item_id`) USING BTREE,
  INDEX `Fk_purchase_materiel`(`materiel_id`) USING BTREE,
  INDEX `Fk_purchase_supplier`(`supplier_id`) USING BTREE,
  INDEX `Fk_purchase_purchase`(`purchase_id`) USING BTREE,
  CONSTRAINT `Fk_purchase_materiel` FOREIGN KEY (`materiel_id`) REFERENCES `materiel` (`materiel_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_purchase_purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`purchase_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_purchase_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for purchase_standard
-- ----------------------------
DROP TABLE IF EXISTS `purchase_standard`;
CREATE TABLE `purchase_standard`  (
  `purchase_standard_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购品控主键自增',
  `purchase_id` int(11) NOT NULL COMMENT '采购表id外键\r\n',
  `standard_a_type` int(11) NOT NULL COMMENT '标准a类型\r\n',
  `standard_a_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标准a名称\r\n',
  `standard_b_type` int(11) NULL DEFAULT NULL COMMENT '标准b类型\r\n',
  `standard_b_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标准b名称\r\n',
  `standard_c_type` int(11) NULL DEFAULT NULL COMMENT '标准c类型\r\n',
  `standard_c_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标准c名称\r\n',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注\r\n',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`purchase_standard_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for purchase_standard_record
-- ----------------------------
DROP TABLE IF EXISTS `purchase_standard_record`;
CREATE TABLE `purchase_standard_record`  (
  `purchase_standard_record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购品控评估记录主键',
  `purchase_standard_id` int(11) NOT NULL COMMENT '标准id',
  `standard_a_score` int(11) NOT NULL COMMENT '标准a评分',
  `standard_b_score` int(11) NULL DEFAULT NULL COMMENT '标准b评分',
  `standard_c_score` int(11) NULL DEFAULT NULL COMMENT '标准c评分',
  `conclusion` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '结论',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`purchase_standard_record_id`) USING BTREE,
  INDEX `Fk_purchase_standard_record_purchase_standard`(`purchase_standard_id`) USING BTREE,
  CONSTRAINT `Fk_purchase_standard_record_purchase_standard` FOREIGN KEY (`purchase_standard_id`) REFERENCES `purchase_standard` (`purchase_standard_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色表主键',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '信息计划专员', 0);
INSERT INTO `role` VALUES (2, '订单专员', 0);
INSERT INTO `role` VALUES (3, '设备主管', 0);
INSERT INTO `role` VALUES (4, '研发主管', 0);
INSERT INTO `role` VALUES (5, '数据监控主管', 0);
INSERT INTO `role` VALUES (6, '库存主管', 0);
INSERT INTO `role` VALUES (7, '质量主管', 0);
INSERT INTO `role` VALUES (8, '采购主管', 0);
INSERT INTO `role` VALUES (9, '采购专员', 0);
INSERT INTO `role` VALUES (10, '生产专员', 0);
INSERT INTO `role` VALUES (11, '研发部专员', 0);

-- ----------------------------
-- Table structure for role_function
-- ----------------------------
DROP TABLE IF EXISTS `role_function`;
CREATE TABLE `role_function`  (
  `role_function_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户功能表主键',
  `role_id` int(11) NOT NULL COMMENT '用户id',
  `function_id` int(11) NOT NULL COMMENT '功能id',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`role_function_id`) USING BTREE,
  INDEX `Fk_role_function_role`(`role_id`) USING BTREE,
  INDEX `Fk_role_function_function`(`function_id`) USING BTREE,
  CONSTRAINT `Fk_role_function_function` FOREIGN KEY (`function_id`) REFERENCES `function` (`function_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_role_function_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_function
-- ----------------------------
INSERT INTO `role_function` VALUES (1, 1, 1, 0);
INSERT INTO `role_function` VALUES (2, 1, 4, 0);
INSERT INTO `role_function` VALUES (3, 1, 5, 0);
INSERT INTO `role_function` VALUES (4, 1, 6, 0);
INSERT INTO `role_function` VALUES (15, 1, 7, 0);
INSERT INTO `role_function` VALUES (16, 1, 8, 0);
INSERT INTO `role_function` VALUES (17, 1, 9, 0);
INSERT INTO `role_function` VALUES (18, 1, 10, 0);
INSERT INTO `role_function` VALUES (19, 1, 11, 0);
INSERT INTO `role_function` VALUES (20, 1, 12, 0);
INSERT INTO `role_function` VALUES (21, 1, 13, 0);
INSERT INTO `role_function` VALUES (22, 1, 14, 0);
INSERT INTO `role_function` VALUES (23, 1, 15, 0);
INSERT INTO `role_function` VALUES (24, 1, 17, 0);
INSERT INTO `role_function` VALUES (25, 1, 18, 0);
INSERT INTO `role_function` VALUES (26, 1, 19, 0);
INSERT INTO `role_function` VALUES (27, 1, 20, 0);
INSERT INTO `role_function` VALUES (28, 1, 21, 0);
INSERT INTO `role_function` VALUES (31, 1, 23, 0);
INSERT INTO `role_function` VALUES (32, 1, 24, 0);
INSERT INTO `role_function` VALUES (33, 2, 1, 0);

-- ----------------------------
-- Table structure for role_jurisdiction
-- ----------------------------
DROP TABLE IF EXISTS `role_jurisdiction`;
CREATE TABLE `role_jurisdiction`  (
  `role_jurisdiction_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户权限id自增',
  `role_id` int(11) NOT NULL COMMENT '用户id',
  `jurisdiction_id` int(11) NOT NULL COMMENT '权限id',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`role_jurisdiction_id`) USING BTREE,
  INDEX `Fk_role_jurisdiction_role`(`role_id`) USING BTREE,
  INDEX `Fk_jurisdiction`(`jurisdiction_id`) USING BTREE,
  CONSTRAINT `Fk_jurisdiction` FOREIGN KEY (`jurisdiction_id`) REFERENCES `jurisdiction` (`jurisdiction_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_role_jurisdiction_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_jurisdiction
-- ----------------------------
INSERT INTO `role_jurisdiction` VALUES (1, 1, 1, 0);
INSERT INTO `role_jurisdiction` VALUES (2, 1, 2, 0);
INSERT INTO `role_jurisdiction` VALUES (3, 1, 3, 0);
INSERT INTO `role_jurisdiction` VALUES (4, 1, 4, 0);
INSERT INTO `role_jurisdiction` VALUES (5, 1, 5, 0);
INSERT INTO `role_jurisdiction` VALUES (6, 1, 6, 0);
INSERT INTO `role_jurisdiction` VALUES (7, 1, 7, 0);
INSERT INTO `role_jurisdiction` VALUES (8, 1, 8, 0);
INSERT INTO `role_jurisdiction` VALUES (9, 1, 9, 0);
INSERT INTO `role_jurisdiction` VALUES (10, 1, 10, 0);
INSERT INTO `role_jurisdiction` VALUES (11, 2, 1, 0);

-- ----------------------------
-- Table structure for stage_purchasing_plan
-- ----------------------------
DROP TABLE IF EXISTS `stage_purchasing_plan`;
CREATE TABLE `stage_purchasing_plan`  (
  `stage_purchasing_plan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '阶段采购计划表id自增',
  `stage_purchasing_plan_cycle` int(11) NOT NULL COMMENT '周期(周)',
  `stage_purchasing_plan_remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
  `user_id` int(11) NOT NULL COMMENT '制定人用户表外键',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`stage_purchasing_plan_id`) USING BTREE,
  INDEX `Fk_stage_purchasing_plan_user`(`user_id`) USING BTREE,
  CONSTRAINT `Fk_stage_purchasing_plan_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stage_purchasing_plan_term
-- ----------------------------
DROP TABLE IF EXISTS `stage_purchasing_plan_term`;
CREATE TABLE `stage_purchasing_plan_term`  (
  `stage_purchasing_plan_term_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '阶段采购计划项主键自增',
  `materiel_id` int(11) NOT NULL COMMENT '物料id外键',
  `materiel_number` int(11) NOT NULL COMMENT '数量',
  `unit_price` double NOT NULL COMMENT '预计采购单价',
  `supplier_id` int(11) NOT NULL COMMENT '供应商id外键',
  `price_float` double NOT NULL COMMENT '价格允许浮动范围',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `stage_purchasing_plan_id` int(11) NOT NULL COMMENT '所属计划,计划表id',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`stage_purchasing_plan_term_id`) USING BTREE,
  INDEX `Fk_stage_purchasing_plan_term_materiel`(`materiel_id`) USING BTREE,
  INDEX `Fk_stage_purchasing_plan_term_supplier`(`supplier_id`) USING BTREE,
  INDEX `Fk_stage_purchasing_plan_term_stage`(`stage_purchasing_plan_id`) USING BTREE,
  CONSTRAINT `Fk_stage_purchasing_plan_term_materiel` FOREIGN KEY (`materiel_id`) REFERENCES `materiel` (`materiel_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_stage_purchasing_plan_term_stage` FOREIGN KEY (`stage_purchasing_plan_id`) REFERENCES `stage_purchasing_plan` (`stage_purchasing_plan_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_stage_purchasing_plan_term_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `store_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '门店用户表id自增',
  `store_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户/门店名称',
  `store_type` int(11) NOT NULL COMMENT '门店/用户类别(1合同用户0散户',
  `store_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `store_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `store_order_number` int(11) NOT NULL COMMENT '下单项数量',
  `store_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '门店编号',
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`store_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (1, '矿大店', 1, '解放路186号', '18752105664', 0, '500', '10001', 0);
INSERT INTO `store` VALUES (2, '和平路店', 1, '和平路186号', '18752105664', 0, '500', '10002', 0);
INSERT INTO `store` VALUES (3, '凤凰路店', 1, '凤凰路186号', '18752105664', 0, '500', '10003', 0);
INSERT INTO `store` VALUES (4, '皇后大道店', 1, '皇后路186号', '18752105664', 0, '500', '10004', 0);
INSERT INTO `store` VALUES (5, '六中店', 1, '和平路16号', '18752105664', 0, '500', '10005', 0);
INSERT INTO `store` VALUES (6, '二院店', 1, '医学路186号', '18752105664', 0, '500', '10006', 0);
INSERT INTO `store` VALUES (7, '四院店', 1, '医院路86号', '18752105664', 0, '500', '10007', 0);
INSERT INTO `store` VALUES (8, '建筑学院店', 0, '解放路186号', '18752105664', 0, '500', '10008', 0);
INSERT INTO `store` VALUES (9, '师范学院店', 0, '解放路186号', '18752105664', 0, '500', '10009', 0);
INSERT INTO `store` VALUES (10, '海云店', 1, '解放路186号', '18752105664', 0, '500', '10010', 0);

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `supplier_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商主键自增',
  `supplier_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商名称',
  `supplier_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `supplier_image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '营业执照路径',
  `supplier_charter_image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '特许经营许可路径',
  `materiel_type_level_b_id` int(11) NOT NULL COMMENT '物料二级类型id(供货类型)',
  `supplier_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `supplier_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `cooperation_start_date` date NOT NULL COMMENT '合作开始时间',
  `status` int(11) NOT NULL COMMENT '删除伪劣',
  `supplier_remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `supplier_state` int(11) NOT NULL COMMENT '状态',
  PRIMARY KEY (`supplier_id`) USING BTREE,
  INDEX `Fk_supplier_materiel_type_level_b`(`materiel_type_level_b_id`) USING BTREE,
  CONSTRAINT `Fk_supplier_materiel_type_level_b` FOREIGN KEY (`materiel_type_level_b_id`) REFERENCES `materiel_type_level_b` (`materiel_type_level_b_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, '猪肉供应商', '01171121001', '营业...', '特许...', 1, '徐州解放路152号', '18752105664', '2016-12-12', 0, '挺好', 0);
INSERT INTO `supplier` VALUES (2, '猪肉供应商', '01171121001', '营业...', '特许...', 2, '徐州解放路152号', '18752105664', '2016-12-12', 0, '挺好', 1);
INSERT INTO `supplier` VALUES (3, '猪肉供应商', '01171121001', '营业...', '特许...', 3, '徐州解放路152号', '18752105664', '2016-12-12', 0, '挺好', 2);
INSERT INTO `supplier` VALUES (4, '猪肉供应商', '01171121001', '营业...', '特许...', 4, '徐州解放路152号', '18752105664', '2016-12-12', 0, '挺好', 0);
INSERT INTO `supplier` VALUES (5, '猪肉供应商', '01171121001', '营业...', '特许...', 5, '徐州解放路152号', '18752105664', '2016-12-12', 0, '挺好', 3);
INSERT INTO `supplier` VALUES (6, '猪肉供应商', '01171121001', '营业...', '特许...', 6, '徐州解放路152号', '18752105664', '2016-12-12', 0, '挺好', 2);
INSERT INTO `supplier` VALUES (7, '猪肉供应商', '01171121001', '营业...', '特许...', 7, '徐州解放路152号', '18752105664', '2016-12-12', 0, '挺好', 1);
INSERT INTO `supplier` VALUES (8, '猪肉供应商', '01171121001', '营业...', '特许...', 8, '徐州解放路152号', '18752105664', '2016-12-12', 0, '挺好', 1);
INSERT INTO `supplier` VALUES (9, '猪肉供应商', '01171121001', '营业...', '特许...', 9, '徐州解放路152号', '18752105664', '2016-12-12', 0, '挺好', 0);
INSERT INTO `supplier` VALUES (10, '猪肉供应商', '01171121001', '营业...', '特许...', 10, '徐州解放路152号', '18752105664', '2016-12-12', 0, '挺好', 0);

-- ----------------------------
-- Table structure for supplier_contract
-- ----------------------------
DROP TABLE IF EXISTS `supplier_contract`;
CREATE TABLE `supplier_contract`  (
  `supplier_contract_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商合同表id自增',
  `supplier_contract_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合同名称',
  `supplier_contract_date` date NOT NULL COMMENT '签订时间',
  `supplier_contract_image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合同图片路径',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `supplier_id` int(11) NOT NULL COMMENT '供应商外键',
  PRIMARY KEY (`supplier_contract_id`) USING BTREE,
  INDEX `Fk_supplier_contract_supplier`(`supplier_id`) USING BTREE,
  CONSTRAINT `Fk_supplier_contract_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for technology
-- ----------------------------
DROP TABLE IF EXISTS `technology`;
CREATE TABLE `technology`  (
  `technology_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '工艺id自增',
  `technology_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `working_id` int(11) NOT NULL COMMENT '预设工序',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`technology_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of technology
-- ----------------------------
INSERT INTO `technology` VALUES (1, '清洗', 1, 0);
INSERT INTO `technology` VALUES (2, '切片', 2, 0);
INSERT INTO `technology` VALUES (3, '切块', 2, 0);
INSERT INTO `technology` VALUES (4, '去壳', 1, 0);
INSERT INTO `technology` VALUES (5, '摘叶', 1, 0);
INSERT INTO `technology` VALUES (6, '解冻', 1, 0);
INSERT INTO `technology` VALUES (7, '浸泡', 1, 0);
INSERT INTO `technology` VALUES (8, '磨粉', 1, 0);
INSERT INTO `technology` VALUES (9, '包装', 5, 0);
INSERT INTO `technology` VALUES (10, '沥干水', 1, 0);
INSERT INTO `technology` VALUES (11, '搅匀', 1, 0);
INSERT INTO `technology` VALUES (12, '切丝', 2, 0);
INSERT INTO `technology` VALUES (13, '混合烹饪', 3, 0);
INSERT INTO `technology` VALUES (14, '冷却', 4, 0);
INSERT INTO `technology` VALUES (16, '炒', 3, 0);

-- ----------------------------
-- Table structure for temporary_order
-- ----------------------------
DROP TABLE IF EXISTS `temporary_order`;
CREATE TABLE `temporary_order`  (
  `temporary_order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '临时订单id自增',
  `temporary_order_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号(自动生成)',
  `temporary_order_end_date` datetime(0) NOT NULL COMMENT '交付时间',
  `temporary_order_state_id` int(11) NOT NULL COMMENT '状态id外键',
  `temporary_order_start_date` datetime(0) NOT NULL COMMENT '下单时间',
  `temporary_order_remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `store_id` int(11) NOT NULL COMMENT '门店用户id外键',
  `user_id` int(11) NOT NULL COMMENT '用户表id(确认人)',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`temporary_order_id`) USING BTREE,
  INDEX `Fk_temporary_order_state`(`temporary_order_state_id`) USING BTREE,
  INDEX `Fk_temporary_store`(`store_id`) USING BTREE,
  INDEX `Fk_temporary_user`(`user_id`) USING BTREE,
  CONSTRAINT `Fk_temporary_order_state` FOREIGN KEY (`temporary_order_state_id`) REFERENCES `temporary_order_state` (`temporary_order_state_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_temporary_store` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_temporary_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for temporary_order_state
-- ----------------------------
DROP TABLE IF EXISTS `temporary_order_state`;
CREATE TABLE `temporary_order_state`  (
  `temporary_order_state_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '临时订单状态表主键自增',
  `temporary_order_state_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态名',
  `status` int(11) NOT NULL COMMENT '删除伪劣',
  PRIMARY KEY (`temporary_order_state_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for temporary_order_term
-- ----------------------------
DROP TABLE IF EXISTS `temporary_order_term`;
CREATE TABLE `temporary_order_term`  (
  `temporary_order_term_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '临时订单项主键自增',
  `menu_id` int(11) NOT NULL COMMENT '菜品id外键',
  `menu_number` int(11) NOT NULL COMMENT '菜品数量',
  `complete_number` int(11) NOT NULL COMMENT '完成数量',
  `temporary_order_term_state` int(11) NOT NULL COMMENT '完成状态(0:未,1:已)',
  `product_batch` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品批次(自动生成',
  `temporary_order_id` int(11) NOT NULL COMMENT '临时订单Id外键',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`temporary_order_term_id`) USING BTREE,
  INDEX `Fk_temporary_order_term_menu`(`menu_id`) USING BTREE,
  INDEX `Fk_temporary_order_term_temporary_order`(`temporary_order_id`) USING BTREE,
  CONSTRAINT `Fk_temporary_order_term_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_temporary_order_term_temporary_order` FOREIGN KEY (`temporary_order_id`) REFERENCES `temporary_order` (`temporary_order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for temporary_production_distribution
-- ----------------------------
DROP TABLE IF EXISTS `temporary_production_distribution`;
CREATE TABLE `temporary_production_distribution`  (
  `temporary_production_distribution_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '临时订单生产任务主键自增',
  `temporary_production_plan_item_id` int(11) NOT NULL COMMENT '临时订单项id',
  `working_id` int(11) NOT NULL COMMENT '工序表id',
  `user_id` int(11) NOT NULL COMMENT '工序负责人',
  `people_number` int(11) NOT NULL COMMENT '配置人数',
  `production_line_id` int(11) NOT NULL COMMENT '生产线id外键',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `next_working_number` int(11) NOT NULL COMMENT '进入下一工序数量',
  `start_date` datetime(0) NOT NULL COMMENT '预计生产开始时间',
  `end_date` datetime(0) NOT NULL COMMENT '预计结束时间',
  PRIMARY KEY (`temporary_production_distribution_id`) USING BTREE,
  INDEX `Fk_distribution_temporary_production_plan_item`(`temporary_production_plan_item_id`) USING BTREE,
  INDEX `Fk_temporary_distribution_working`(`working_id`) USING BTREE,
  INDEX `Fk_temporary_distribution_user`(`user_id`) USING BTREE,
  INDEX `Fk_temporary_distribution_production_line`(`production_line_id`) USING BTREE,
  CONSTRAINT `Fk_distribution_temporary_production_plan_item` FOREIGN KEY (`temporary_production_plan_item_id`) REFERENCES `temporary_production_plan_item` (`temporary_production_plan_item_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_temporary_distribution_production_line` FOREIGN KEY (`production_line_id`) REFERENCES `production_line` (`production_line_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_temporary_distribution_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_temporary_distribution_working` FOREIGN KEY (`working_id`) REFERENCES `working` (`working_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for temporary_production_plan
-- ----------------------------
DROP TABLE IF EXISTS `temporary_production_plan`;
CREATE TABLE `temporary_production_plan`  (
  `temporary_production_plan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '临时订单生产计划表ID自增',
  `temporary_order_id` int(11) NOT NULL COMMENT '临时订单id外键',
  `production_batch` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产批次',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `date` datetime(0) NOT NULL COMMENT '日期',
  PRIMARY KEY (`temporary_production_plan_id`) USING BTREE,
  INDEX `Fk_temporary_production_plan_order`(`temporary_order_id`) USING BTREE,
  CONSTRAINT `Fk_temporary_production_plan_order` FOREIGN KEY (`temporary_order_id`) REFERENCES `temporary_order` (`temporary_order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for temporary_production_plan_item
-- ----------------------------
DROP TABLE IF EXISTS `temporary_production_plan_item`;
CREATE TABLE `temporary_production_plan_item`  (
  `temporary_production_plan_item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '临时订单生产计划订单项id自增',
  `menu_id` int(11) NOT NULL COMMENT '菜品id外键',
  `menu_number` int(11) NOT NULL COMMENT '菜品数量',
  `temporary_production_plan_id` int(11) NOT NULL COMMENT '临时生产计划id外键',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`temporary_production_plan_item_id`) USING BTREE,
  INDEX `Fk_temporary_production_plan_item_menu`(`menu_id`) USING BTREE,
  INDEX `Fk_item_temporary_production_plan`(`temporary_production_plan_id`) USING BTREE,
  CONSTRAINT `Fk_item_temporary_production_plan` FOREIGN KEY (`temporary_production_plan_id`) REFERENCES `temporary_production_plan` (`temporary_production_plan_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_temporary_production_plan_item_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for temporary_progress
-- ----------------------------
DROP TABLE IF EXISTS `temporary_progress`;
CREATE TABLE `temporary_progress`  (
  `temporary_progress_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '临时订单任务进度记录主键',
  `temporary_production_distribution_id` int(11) NOT NULL COMMENT '临时订单生产任务分配id',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注(必填)',
  `start_date` datetime(0) NOT NULL COMMENT '实际生产开始时间',
  `end_date` datetime(0) NOT NULL COMMENT '实际结束时间',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`temporary_progress_id`) USING BTREE,
  INDEX `Fk_temporary_progress_temporary_production_distribution`(`temporary_production_distribution_id`) USING BTREE,
  CONSTRAINT `Fk_temporary_progress_temporary_production_distribution` FOREIGN KEY (`temporary_production_distribution_id`) REFERENCES `temporary_production_distribution` (`temporary_production_distribution_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键自增',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `user_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话(登陆账号)',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '华中昊', '123', '18752105664', 0);
INSERT INTO `user` VALUES (2, '孙天奇', '123', '18752105664', 0);
INSERT INTO `user` VALUES (3, '张振国', '123', '18752105664', 0);
INSERT INTO `user` VALUES (4, '甄立', '123', '18752105664', 0);
INSERT INTO `user` VALUES (5, '王傲翔', '123', '18752105664', 0);
INSERT INTO `user` VALUES (6, '刘长乐', '123', '18752105664', 0);
INSERT INTO `user` VALUES (7, '郑庆坤', '123', '18752105664', 0);
INSERT INTO `user` VALUES (8, '倪四城', '123', '18752105664', 0);
INSERT INTO `user` VALUES (9, '李金伟', '123', '18752105664', 0);
INSERT INTO `user` VALUES (10, '郭旭', '123', '18752105664', 0);
INSERT INTO `user` VALUES (11, '索志文', '123', '18752105664', 0);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色id自增',
  `role_id` int(11) NOT NULL COMMENT '角色表外键',
  `user_id` int(11) NOT NULL COMMENT '用户表外键',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`user_role_id`) USING BTREE,
  INDEX `Fk_user_role`(`role_id`) USING BTREE,
  INDEX `Fk_user_role_user`(`user_id`) USING BTREE,
  CONSTRAINT `Fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_user_role_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1, 0);
INSERT INTO `user_role` VALUES (2, 2, 2, 0);
INSERT INTO `user_role` VALUES (3, 3, 3, 0);
INSERT INTO `user_role` VALUES (4, 4, 4, 0);
INSERT INTO `user_role` VALUES (5, 5, 5, 0);
INSERT INTO `user_role` VALUES (6, 6, 6, 0);
INSERT INTO `user_role` VALUES (7, 7, 7, 0);
INSERT INTO `user_role` VALUES (8, 8, 8, 0);
INSERT INTO `user_role` VALUES (9, 9, 9, 0);
INSERT INTO `user_role` VALUES (10, 10, 10, 0);

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `warehouse_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库表id自增',
  `warehouse_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  `user_id` int(11) NOT NULL COMMENT '仓库管理员用户表外键',
  PRIMARY KEY (`warehouse_id`) USING BTREE,
  INDEX `Fk_warehouse_user`(`user_id`) USING BTREE,
  CONSTRAINT `Fk_warehouse_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (1, '第一仓库', '主放冷藏', 0, 6);
INSERT INTO `warehouse` VALUES (2, '第二仓库', '主放蔬果', 0, 6);
INSERT INTO `warehouse` VALUES (3, '第三仓库', '主放蛋奶', 0, 6);

-- ----------------------------
-- Table structure for warehouse_out_register
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_out_register`;
CREATE TABLE `warehouse_out_register`  (
  `warehouse_out_register_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库登记表主键自增',
  `warehouse_out_register_end_date` datetime(0) NOT NULL COMMENT '出库时间',
  `user_id` int(11) NOT NULL COMMENT '用户表id外键领料人',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`warehouse_out_register_id`) USING BTREE,
  INDEX `Fk_warehouse_out_register_user`(`user_id`) USING BTREE,
  CONSTRAINT `Fk_warehouse_out_register_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for warehouse_out_register_item
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_out_register_item`;
CREATE TABLE `warehouse_out_register_item`  (
  `warehouse_out_register_item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库登记表项主键自增',
  `materiel_id` int(11) NOT NULL COMMENT '物料id外键',
  `goods_shelve_id` int(11) NOT NULL COMMENT '货架id',
  `materiel_number` int(11) NOT NULL COMMENT '出库数量',
  `warehouse_out_register_id` int(11) NOT NULL COMMENT '出口登记表外键',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`warehouse_out_register_item_id`) USING BTREE,
  INDEX `Fk_warehouse_out_register_item_materiel`(`materiel_id`) USING BTREE,
  INDEX `Fk_warehouse_out_register_item_goods_shelve`(`goods_shelve_id`) USING BTREE,
  INDEX `FK_item_warehouse_out_register`(`warehouse_out_register_id`) USING BTREE,
  CONSTRAINT `FK_item_warehouse_out_register` FOREIGN KEY (`warehouse_out_register_id`) REFERENCES `warehouse_out_register` (`warehouse_out_register_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_warehouse_out_register_item_goods_shelve` FOREIGN KEY (`goods_shelve_id`) REFERENCES `goods_shelve` (`goods_shelve_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_warehouse_out_register_item_materiel` FOREIGN KEY (`materiel_id`) REFERENCES `materiel` (`materiel_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for warehouse_region
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_region`;
CREATE TABLE `warehouse_region`  (
  `warehouse_region_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库区域表id自增',
  `warehouse_region_no` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区域编号',
  `materiel_type_level_b_id` int(11) NOT NULL COMMENT '物料二级分类(规定)外键',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '删除伪列',
  `warehouse_id` int(11) NOT NULL COMMENT '仓库id外键',
  PRIMARY KEY (`warehouse_region_id`) USING BTREE,
  INDEX `Fk_warehouse_materiel_type_level_b`(`materiel_type_level_b_id`) USING BTREE,
  INDEX `Fkwarehouse_region_warehouse`(`warehouse_id`) USING BTREE,
  CONSTRAINT `Fk_warehouse_materiel_type_level_b` FOREIGN KEY (`materiel_type_level_b_id`) REFERENCES `materiel_type_level_b` (`materiel_type_level_b_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fkwarehouse_region_warehouse` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`warehouse_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse_region
-- ----------------------------
INSERT INTO `warehouse_region` VALUES (1, '01171122013', 1, '冷鲜猪肉区', '0', 1);
INSERT INTO `warehouse_region` VALUES (2, '01171122014', 2, '冷鲜牛肉区', '0', 1);
INSERT INTO `warehouse_region` VALUES (3, '01171122015', 3, '冷鲜羊肉区', '0', 1);
INSERT INTO `warehouse_region` VALUES (4, '01171122016', 4, '冷鲜禽肉区', '0', 1);
INSERT INTO `warehouse_region` VALUES (5, '01171122017', 5, '蛋类区', '0', 1);
INSERT INTO `warehouse_region` VALUES (6, '01171122018', 6, '易碎', '0', 1);
INSERT INTO `warehouse_region` VALUES (7, '01171122019', 7, '冷鲜种植', '0', 1);
INSERT INTO `warehouse_region` VALUES (8, '01171122020', 8, '常温', '0', 1);

-- ----------------------------
-- Table structure for warehouse_register
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_register`;
CREATE TABLE `warehouse_register`  (
  `warehouse_register_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库登记表主键自增',
  `everyday_purchasing_plan_id` int(11) NOT NULL COMMENT '每日采购计划id外键',
  `warehouse_register_date` datetime(0) NOT NULL COMMENT '入库时间',
  `user_id` int(11) NOT NULL COMMENT '入库人用户表外键',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`warehouse_register_id`) USING BTREE,
  INDEX `Fk_warehouse_register_everyday_purchasing_plan`(`everyday_purchasing_plan_id`) USING BTREE,
  INDEX `Fk_warehouse_register_everyday__user`(`user_id`) USING BTREE,
  CONSTRAINT `Fk_warehouse_register_everyday__user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_warehouse_register_everyday_purchasing_plan` FOREIGN KEY (`everyday_purchasing_plan_id`) REFERENCES `everyday_purchasing_plan` (`everyday_purchasing_plan_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for warehouse_register_item
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_register_item`;
CREATE TABLE `warehouse_register_item`  (
  `warehouse_register_item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库登记记录项主键自增',
  `materiel_id` int(11) NOT NULL COMMENT '物料id外键',
  `goods_shelve_id` int(11) NOT NULL COMMENT '货架id',
  `materiel_number` int(11) NOT NULL COMMENT '入库数量',
  `warehouse_register_id` int(11) NOT NULL COMMENT '入库记录id外键',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`warehouse_register_item_id`) USING BTREE,
  INDEX `Fk_warehouse_register_item_materiel`(`materiel_id`) USING BTREE,
  INDEX `Fk_warehouse_register_item_goods_shelve`(`goods_shelve_id`) USING BTREE,
  INDEX `Fk_warehouse_register_item_warehouse_register`(`warehouse_register_id`) USING BTREE,
  CONSTRAINT `Fk_warehouse_register_item_goods_shelve` FOREIGN KEY (`goods_shelve_id`) REFERENCES `goods_shelve` (`goods_shelve_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_warehouse_register_item_materiel` FOREIGN KEY (`materiel_id`) REFERENCES `materiel` (`materiel_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_warehouse_register_item_warehouse_register` FOREIGN KEY (`warehouse_register_id`) REFERENCES `warehouse_register` (`warehouse_register_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for working
-- ----------------------------
DROP TABLE IF EXISTS `working`;
CREATE TABLE `working`  (
  `working_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '工序表id',
  `working_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `status` int(11) NOT NULL COMMENT '删除伪列',
  PRIMARY KEY (`working_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of working
-- ----------------------------
INSERT INTO `working` VALUES (1, '初加工', 0);
INSERT INTO `working` VALUES (2, '精加工', 0);
INSERT INTO `working` VALUES (3, '烹饪', 0);
INSERT INTO `working` VALUES (4, '冷却', 0);
INSERT INTO `working` VALUES (5, '包装', 0);

SET FOREIGN_KEY_CHECKS = 1;
