USE orchestra_final;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` int(255) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
DESCRIBE `user`;

INSERT INTO `user` VALUES (1, 'super', '123', 1);
INSERT INTO `user` VALUES (2, 'admin', 'admin', 1);
INSERT INTO `user` VALUES (3, 'laowang', 'hehe', 0);