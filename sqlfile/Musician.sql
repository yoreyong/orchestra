USE orchestra_final;

-- -----------------------------------
-- Table structure for musician
-- -----------------------------------
DROP TABLE IF EXISTS `musician`;
CREATE TABLE `musician`
(
    `SSN`       VARCHAR(20) CHARACTER SET utf8mb4   NOT NULL,
    `accountId` INT ,
    `fname`     VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ,
    `lname`     VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ,
    `gender`    VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ,
    `phoneNum`  VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ,
    `state`     VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ,
    `city`      VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ,
    `address`   VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ,
    `zip`       VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ,
    `pic`       VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci ,
    CONSTRAINT musician_PK PRIMARY KEY (`SSN`)
);

DESCRIBE `musician`;

insert into musician (SSN, fname, address, phoneNum, zip, state, lname, gender, city, accountId, pic)
    values ('249-97-3699', 'Eveline', '99281 Gulseth Park', '713-865-5229', 77288, 'Texas', 'Isoldi', 'F', 'Houston', 0, null);
insert into musician (SSN, fname, address, phoneNum, zip, state, lname, gender, city, accountId, pic)
    values ('166-70-7528', 'Auberta', '60106 Sundown Trail', '817-572-6831', 76210, 'Texas', 'Taaffe', 'F', 'Denton', 0, null);
insert into musician (SSN, fname, address, phoneNum, zip, state, lname, gender, city, accountId, pic)
    values ('866-86-4244', 'Wilton', '4 Lighthouse Bay Road', '713-981-8035', 77250, 'Texas', 'Dollard', 'M', 'Houston', 0, null);
insert into musician (SSN, fname, address, phoneNum, zip, state, lname, gender, city, accountId, pic)
    values ('265-60-9328', 'Janna', '63 Oakridge Drive', '512-994-1638', 78710, 'Texas', 'Cordaroy', 'F', 'Austin', 0, null);
insert into musician (SSN, fname, address, phoneNum, zip, state, lname, gender, city, accountId, pic)
    values ('122-39-7652', 'Patten', '31842 Westridge Center', '281-984-2427', 77346, 'Texas', 'Dayley', 'M', 'Humble', 0, null);
