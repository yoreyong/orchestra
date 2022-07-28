USE orchestra;

-- -----------------------------------
-- Table structure for concert
-- -----------------------------------
DROP TABLE IF EXISTS `concert`;
CREATE TABLE `concert` (
    `id`            INT             NOT NULL    AUTO_INCREMENT ,
    `concert_name`  VARCHAR(15)     CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NOT NULL ,
    `place`         VARCHAR(30)     CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NOT NULL ,
    `concert_date`  DATE            NOT NULL ,
    `start_time`    TIME            NOT NULL ,
    `description`   VARCHAR(300)    CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NULL ,
    `typeId`        INT ,
    `prices`        DECIMAL(6, 2) ,
    CONSTRAINT concert_PK   PRIMARY KEY (`id`)
);

DESCRIBE `concert`;

-- -----------------------------------
-- Table structure for concert type
-- -----------------------------------
DROP TABLE IF EXISTS `concerttype`;
CREATE TABLE `concerttype` (
    `id`        INT             NOT NULL    AUTO_INCREMENT ,
    `name`      VARCHAR(50)     CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NOT NULL ,
    `parentId`  INT ,
    CONSTRAINT concerttype PRIMARY KEY (`id`)
);

DESCRIBE `concerttype`;

insert into concerttype values (null, 'Private Party', 0);
insert into concerttype values (null, 'Church Concert', 0);
insert into concerttype values (null, 'Outdoor Party', 0);


-- -----------------------------------
-- Table structure for private party
-- -----------------------------------
DROP TABLE IF EXISTS `privateParty`;
CREATE TABLE `privateParty` (
    `id`    INT     NOT NULL    AUTO_INCREMENT ,
    `conId` INT     NOT NULL ,
    `theme` VARCHAR(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ,
    CONSTRAINT privateParty_PK PRIMARY KEY (`id`) ,
    CONSTRAINT privateParty_FK  FOREIGN KEY (`conId`) REFERENCES `concert`(`id`)
                            ON DELETE CASCADE   ON UPDATE CASCADE
);
DESCRIBE `privateParty`;


-- -----------------------------------
-- Table structure for church concert
-- -----------------------------------
DROP TABLE IF EXISTS `churchConcert`;
CREATE TABLE `churchConcert` (
    `id`    INT     NOT NULL    AUTO_INCREMENT ,
    `conId` INT     NOT NULL ,
    `churchName`    VARCHAR(15)    CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ,
    CONSTRAINT churchConcert_PK PRIMARY KEY (`id`) ,
    CONSTRAINT churchConcert_FK  FOREIGN KEY (`conId`) REFERENCES `concert`(`id`)
                             ON DELETE CASCADE  ON UPDATE CASCADE
);
DESCRIBE `churchConcert`;


-- -----------------------------------
-- Table structure for outdoor party
-- -----------------------------------
DROP TABLE IF EXISTS `outdoorParty`;
CREATE TABLE `outdoorParty` (
    `id`    INT     NOT NULL    AUTO_INCREMENT ,
    `conId` INT     NOT NULL ,
    `type`  VARCHAR(15)    CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ,
    CONSTRAINT outdoorParty_PK PRIMARY KEY (`id`) ,
    CONSTRAINT outdoorParty_FK  FOREIGN KEY (`conId`) REFERENCES `concert`(`id`)
                            ON DELETE CASCADE   ON UPDATE CASCADE
);
DESCRIBE `outdoorParty`;