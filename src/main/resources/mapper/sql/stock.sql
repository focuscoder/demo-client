CREATE TABLE `order_demo`.`Untitled`  (
  `id` int(11) NOT NULL,
  `course_id` int(11) DEFAULT NULL COMMENT '课程Id',
  `course_name` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程名称',
  `price` decimal(10, 2) DEFAULT NULL COMMENT '课程价格',
  `stock_num` int(11) DEFAULT 1 COMMENT '库存数量',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `version_flag` bigint(20) DEFAULT NULL COMMENT '版本标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库存表' ROW_FORMAT = Compact;