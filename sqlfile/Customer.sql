USE orchestra_final;

-- -----------------------------------
-- Table structure for concert
-- -----------------------------------

DROP TABLE IF EXISTS `Customer`; #changed attributes !
CREATE TABLE `Customer` (
    `id`        int    NOT NULL    AUTO_INCREMENT ,
    `username`  VARCHAR(15)     CHARACTER SET utf8mb4 NOT NULL ,
    `fname`     VARCHAR(30)     CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NULL        DEFAULT NULL ,
    `lname`     VARCHAR(30)     CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NULL        DEFAULT NULL ,
    `email`     VARCHAR(50)     CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NULL        DEFAULT NULL ,
    `address`   VARCHAR(100)    CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NULL        DEFAULT NULL ,
    `phoneNum`  VARCHAR(30)     CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NULL        DEFAULT NULL ,
    CONSTRAINT customer_PK  PRIMARY KEY (`id`)
);

insert into customer (username, fname, lname, address, phoneNum, email)
    values ('ewetherald0', 'Edik', 'Wetherald', '86 Upham Lane', '(804) 1858429', 'ewetherald0@tmall.com');
insert into customer (username, fname, lname, address, phoneNum, email)
    values ('dsharman1', 'Deni', 'Sharman', '05 5th Place', '(215) 4021800', 'dsharman1@homestead.com');
insert into customer (username, fname, lname, address, phoneNum, email)
    values ('mbrehaut2', 'Malvina', 'Brehaut', '96028 Waubesa Lane', '(407) 5870033', 'mbrehaut2@disqus.com');
insert into customer (username, fname, lname, address, phoneNum, email)
    values ('mswett3', 'Margarethe', 'Swett', '23817 Mayer Lane', '(210) 2080794', 'mswett3@redcross.org');
insert into customer (username, fname, lname, address, phoneNum, email)
    values ('bbessey4', 'Benjamen', 'Bessey', '84133 Pennsylvania Trail', '(508) 6845783', 'bbessey4@github.com');
