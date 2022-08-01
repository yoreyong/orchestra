USE orchestra_final;

-- -----------------------------------
-- Table structure for musicalwork
-- -----------------------------------
DROP TABLE IF EXISTS `musicalWork`;
CREATE TABLE `musicalWork` (
    `id`        INT             NOT NULL    AUTO_INCREMENT ,
    `name`      VARCHAR(50)     CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NOT NULL ,
    `author`    VARCHAR(50)     CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NOT NULL ,
    `desc`      VARCHAR(200)    CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ,
    `typeId`    INT ,
    CONSTRAINT musicalWork_PK PRIMARY KEY (`id`)
);

DESCRIBE `musicalWork`;

insert into musicalWork (id, `name`, author, `desc`) values (1, 'RomanianDances', 'Brier Woodburne', null);
insert into musicalWork (id, `name`, author, `desc`) values (2, 'Tildi', 'Tildi Gouldstraw', null);
insert into musicalWork (id, `name`, author, `desc`) values (3, 'Violin Concerto', 'Dorette Hincks', null);
insert into musicalWork (id, `name`, author, `desc`) values (4, 'Freddi', 'Freddi Seer', null);
insert into musicalWork (id, `name`, author, `desc`) values (5, 'Fee', 'Fee Bellfield', null);
insert into musicalWork (id, `name`, author, `desc`) values (6, 'Symphony No.1', 'Annabel Aynold', null);
insert into musicalWork (id, `name`, author, `desc`) values (7, 'Rena', 'Rena Hardage', null);
insert into musicalWork (id, `name`, author, `desc`) values (8, 'Symphony No.7', 'Lucinda Eddison', null);
insert into musicalWork (id, `name`, author, `desc`) values (9, 'Imagined Forest', 'Dell Cluitt', null);
insert into musicalWork (id, `name`, author, `desc`) values (10, 'Kynthia', 'Kynthia Godden', null);
insert into musicalWork (id, `name`, author, `desc`) values (11, 'Piano Concerto No.3', 'Joeann Ossulton', null);
insert into musicalWork (id, `name`, author, `desc`) values (12, 'Garv', 'Garv Mallen', null);
insert into musicalWork (id, `name`, author, `desc`) values (13, 'Valentina', 'Valentina Metzig', null);
insert into musicalWork (id, `name`, author, `desc`) values (14, 'Concerto', 'Donella Weyland', null);
insert into musicalWork (id, `name`, author, `desc`) values (15, 'Kleon', 'Kleon Dyton', null);
insert into musicalWork (id, `name`, author, `desc`) values (16, 'Cello Concerto', 'Brier Woodburne', null);
insert into musicalWork (id, `name`, author, `desc`) values (17, 'Piano Concerto ', 'Tildi Gouldstraw', null);
insert into musicalWork (id, `name`, author, `desc`) values (18, 'Symphony No.4', 'Dorette Hincks', null);
insert into musicalWork (id, `name`, author, `desc`) values (49, ' Damascus', 'Freddi Seer', null);
insert into musicalWork (id, `name`, author, `desc`) values (20, 'Winter Daydreams', 'Fee Bellfield', null);
insert into musicalWork (id, `name`, author, `desc`) values (21, 'Villanelle', 'Annabel Aynold', null);
insert into musicalWork (id, `name`, author, `desc`) values (22, 'Horn Sonata ', 'Rena Hardage', null);
insert into musicalWork (id, `name`, author, `desc`) values (23, 'Symphony No.7', 'Lucinda Eddison', null);
insert into musicalWork (id, `name`, author, `desc`) values (24, 'The Rock', 'Dell Cluitt', null);
insert into musicalWork (id, `name`, author, `desc`) values (25, 'Pohjola’s Daughter', 'Kynthia Godden', null);
insert into musicalWork (id, `name`, author, `desc`) values (26, 'La Mer No.3', 'Joeann Ossulton', null);
insert into musicalWork (id, `name`, author, `desc`) values (27, 'La Valse', 'Garv Mallen', null);
insert into musicalWork (id, `name`, author, `desc`) values (28, 'Marie-Angea', 'Valentina Metzig', null);
insert into musicalWork (id, `name`, author, `desc`) values (29, 'Concerto', 'Donella Weyland', null);
insert into musicalWork (id, `name`, author, `desc`) values (30, 'Percussion and Celesta', 'Kleon Dyton', null);


-- -----------------------------------
-- Table structure for musical work type
-- -----------------------------------
DROP TABLE IF EXISTS `musicalworktype`;
CREATE TABLE `musicalworktype` (
    `id`        INT             NOT NULL    AUTO_INCREMENT ,
    `name`      VARCHAR(50)     CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NOT NULL ,
    `parentId`  INT ,
    CONSTRAINT musicalWork_PK PRIMARY KEY (`id`)
);

DESCRIBE `musicalworktype`;

insert into musicalworktype values (null, 'German Folk', 0);
insert into musicalworktype values (null, 'Classical', 0);
insert into musicalworktype values (null, 'Swedish Folk', 0);


-- -----------------------------------
-- Table structure for german folk
-- -----------------------------------
DROP TABLE IF EXISTS `germanFolk`;
CREATE TABLE `germanFolk` (
    `id`            INT     NOT NULL    AUTO_INCREMENT ,
    `musicalId`     INT     NOT NULL ,
    CONSTRAINT germanFolk_PK PRIMARY KEY (`id`) ,
    CONSTRAINT germanFolk_FK FOREIGN KEY (`musicalId`) REFERENCES `musicalWork`(`id`)
                          ON DELETE CASCADE     ON UPDATE CASCADE
);

DESCRIBE `germanFolk`;

insert into germanFolk (id, musicalID) values (1, 1);
insert into germanFolk (id, musicalID) values (2, 12);
insert into germanFolk (id, musicalID) values (3, 6);
insert into germanFolk (id, musicalID) values (4, 2);
insert into germanFolk (id, musicalID) values (5, 11);
insert into germanFolk (id, musicalID) values (6, 13);
insert into germanFolk (id, musicalID) values (7, 5);
insert into germanFolk (id, musicalID) values (8, 7);
insert into germanFolk (id, musicalID) values (9, 10);
insert into germanFolk (id, musicalID) values (10, 10);
insert into germanFolk (id, musicalID) values (11, 14);
insert into germanFolk (id, musicalID) values (12, 11);
insert into germanFolk (id, musicalID) values (13, 13);
insert into germanFolk (id, musicalID) values (14, 5);
insert into germanFolk (id, musicalID) values (15, 12);



-- -----------------------------------
-- Table structure for classical
-- -----------------------------------
DROP TABLE IF EXISTS `classical`;
CREATE TABLE `classical` (
    `id`            INT     NOT NULL    AUTO_INCREMENT ,
    `musicalId`     INT     NOT NULL ,
    CONSTRAINT classical_PK PRIMARY KEY (`id`) ,
    CONSTRAINT classical_FK FOREIGN KEY (`musicalId`) REFERENCES `musicalWork`(`id`)
                          ON DELETE CASCADE     ON UPDATE CASCADE
);

DESCRIBE `classical`;

insert into classical (id, musicalID) values (1, 18);
insert into classical (id, musicalID) values (2, 22);
insert into classical (id, musicalID) values (3, 22);
insert into classical (id, musicalID) values (4, 23);
insert into classical (id, musicalID) values (5, 23);
insert into classical (id, musicalID) values (6, 25);
insert into classical (id, musicalID) values (7, 18);
insert into classical (id, musicalID) values (8, 24);
insert into classical (id, musicalID) values (9, 23);
insert into classical (id, musicalID) values (10, 24);
insert into classical (id, musicalID) values (11, 22);
insert into classical (id, musicalID) values (12, 16);
insert into classical (id, musicalID) values (13, 25);
insert into classical (id, musicalID) values (14, 20);
insert into classical (id, musicalID) values (15, 25);


-- -----------------------------------
-- Table structure for swedish folk
-- -----------------------------------
DROP TABLE IF EXISTS `swedishFolk`;
CREATE TABLE `swedishFolk` (
    `id`            INT     NOT NULL    AUTO_INCREMENT ,
    `musicalId`     INT     NOT NULL ,
    CONSTRAINT swedishFolk_PK PRIMARY KEY (`id`) ,
    CONSTRAINT swedishFolk_FK FOREIGN KEY (`musicalId`) REFERENCES `musicalWork`(`id`)
                          ON DELETE CASCADE     ON UPDATE CASCADE
);

DESCRIBE `swedishFolk`;

insert into swedishFolk (id, musicalID) values (1, 30);
insert into swedishFolk (id, musicalID) values (2, 26);
insert into swedishFolk (id, musicalID) values (3, 27);
insert into swedishFolk (id, musicalID) values (4, 29);
insert into swedishFolk (id, musicalID) values (5, 29);
insert into swedishFolk (id, musicalID) values (6, 30);
insert into swedishFolk (id, musicalID) values (7, 28);
insert into swedishFolk (id, musicalID) values (8, 29);
insert into swedishFolk (id, musicalID) values (9, 27);
insert into swedishFolk (id, musicalID) values (10, 29);
insert into swedishFolk (id, musicalID) values (11, 27);
insert into swedishFolk (id, musicalID) values (12, 26);
insert into swedishFolk (id, musicalID) values (13, 29);
insert into swedishFolk (id, musicalID) values (14, 26);
insert into swedishFolk (id, musicalID) values (15, 28);

-- ----------------------------
-- Relationship table
-- Table structure for require
-- ----------------------------
DROP TABLE IF EXISTS `require`;
CREATE TABLE `require` (
    `id`            INT     NOT NULL    AUTO_INCREMENT ,
    `settingNum`    INT     NOT NULL ,
    `MWorkNum`      INT     NOT NULL ,
    CONSTRAINT require_PK PRIMARY KEY (`id`)
);


