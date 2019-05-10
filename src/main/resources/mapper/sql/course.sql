CREATE TABLE `order_demo`.`Untitled`  (
  `id` int(11) NOT NULL,
  `course_id` int(8) DEFAULT NULL COMMENT '课程Id',
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程名称',
  `course_type` tinyint(2) DEFAULT 1 COMMENT '课程类型',
  `price` decimal(10, 2) DEFAULT NULL COMMENT '课程单价',
  `status` tinyint(2) DEFAULT 1 COMMENT '课程状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程表' ROW_FORMAT = Compact;