CREATE TABLE `order_demo`.`Untitled`  (
  `id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL COMMENT '订单Id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户Id',
  `course_id` int(8) DEFAULT NULL COMMENT '课程Id',
  `order_price` decimal(10, 2) DEFAULT NULL COMMENT '订单金额',
  `num` int(11) DEFAULT 1 COMMENT '课程数量',
  `order_status` tinyint(2) DEFAULT 1 COMMENT '订单状态',
  `status` tinyint(2) DEFAULT 1 COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Compact;