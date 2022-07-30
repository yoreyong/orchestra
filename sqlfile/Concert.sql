USE orchestra_final;

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
    `price`         DECIMAL(6, 2) ,
    CONSTRAINT concert_PK   PRIMARY KEY (`id`)
);

DESCRIBE `concert`;

insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (1, 'Veribet', '9218 Northwestern Center', '2022-02-24', '20:54', null, 1, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (2, 'Vagram', '29 Sugar Parkway', '2022-04-27', '14:17', null, 2, 23.21);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (3, 'Fixflex', '57329 Ohio Place', '2021-04-30', '14:50', null, 3, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (4, 'Tempsoft', '85 Old Shore Point', '2021-04-24', '23:23', null, 2, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (5, 'Otcom', '7810 Miller Plaza', '2021-05-02', '7:29', null, 3, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (6, 'Zamit', '619 Moose Lane', '2021-07-26', '6:36', null, 1, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (7, 'Y-Solowarm', '260 Dryden Parkway', '2021-10-29', '3:57', null, 2, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (8, 'Pannier', '3421 Express Drive', '2022-01-20', '0:02', null, 3, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (9, 'Keylex', '12 Lindbergh Trail', '2021-06-01', '4:17', null, 3, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (10, 'Veribet', '86 Walton Crossing', '2021-04-02', '19:21', null, 2, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (11, 'Ventosanzap', '1249 West Road', '2021-10-05', '10:52', null, 1, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (12, 'Namfix', '83465 Debra Terrace', '2021-01-17', '3:25', null, 1, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (13, 'Y-Solowarm', '9 Fieldstone Trail', '2021-03-02', '17:09', null, 2, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (14, 'Bytecard', '250 Sunbrook Street', '2021-02-07', '9:41', null, 3, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (15, 'Matsoft', '1 Pankratz Point', '2021-12-17', '6:55', null, 2, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (16, 'Daltfresh', '767 Sage Park', '2021-02-13', '7:18', null, 3, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (17, 'Kanlam', '719 Lawn Crossing', '2021-10-15', '4:46', null, 1, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (18, 'Keylex', '154 Duke Circle', '2022-01-15', '16:34', null, 3, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (19, 'Matsoft', '634 Pleasure Terrace', '2021-07-30', '23:10', null, 2, 40.45);
insert into concert (id, concert_name, place, concert_date, start_time, description, typeId, price)
    values (20, 'Duobam', '6443 Weeping Birch Hill', '2021-10-24', '6:05', null, 1, 40.45);

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
    CONSTRAINT privateParty_PK PRIMARY KEY (`id`) ,
    CONSTRAINT privateParty_FK  FOREIGN KEY (`conId`) REFERENCES `concert`(`id`)
                            ON DELETE CASCADE   ON UPDATE CASCADE
);
DESCRIBE `privateParty`;

insert into privateParty (id, conId) values (1, 9);
insert into privateParty (id, conId) values (2, 19);
insert into privateParty (id, conId) values (3, 11);
insert into privateParty (id, conId) values (4, 14);
insert into privateParty (id, conId) values (5, 15);
insert into privateParty (id, conId) values (6, 5);
insert into privateParty (id, conId) values (7, 14);
insert into privateParty (id, conId) values (8, 3);
insert into privateParty (id, conId) values (9, 2);
insert into privateParty (id, conId) values (10, 8);


-- -----------------------------------
-- Table structure for church concert
-- -----------------------------------
DROP TABLE IF EXISTS `churchConcert`;
CREATE TABLE `churchConcert` (
    `id`    INT     NOT NULL    AUTO_INCREMENT ,
    `conId` INT     NOT NULL ,
    CONSTRAINT churchConcert_PK PRIMARY KEY (`id`) ,
    CONSTRAINT churchConcert_FK  FOREIGN KEY (`conId`) REFERENCES `concert`(`id`)
                             ON DELETE CASCADE  ON UPDATE CASCADE
);
DESCRIBE `churchConcert`;

insert into churchConcert (id, conId) values (1, 18);
insert into churchConcert (id, conId) values (2, 11);
insert into churchConcert (id, conId) values (3, 13);
insert into churchConcert (id, conId) values (4, 16);
insert into churchConcert (id, conId) values (5, 4);
insert into churchConcert (id, conId) values (6, 17);
insert into churchConcert (id, conId) values (7, 11);
insert into churchConcert (id, conId) values (8, 20);
insert into churchConcert (id, conId) values (9, 1);
insert into churchConcert (id, conId) values (10, 16);

-- -----------------------------------
-- Table structure for outdoor party
-- -----------------------------------
DROP TABLE IF EXISTS `outdoorParty`;
CREATE TABLE `outdoorParty` (
    `id`    INT     NOT NULL    AUTO_INCREMENT ,
    `conId` INT     NOT NULL ,
    CONSTRAINT outdoorParty_PK PRIMARY KEY (`id`) ,
    CONSTRAINT outdoorParty_FK  FOREIGN KEY (`conId`) REFERENCES `concert`(`id`)
                            ON DELETE CASCADE   ON UPDATE CASCADE
);
DESCRIBE `outdoorParty`;

insert into outdoorParty (id, conId) values (1, 16);
insert into outdoorParty (id, conId) values (2, 16);
insert into outdoorParty (id, conId) values (3, 6);
insert into outdoorParty (id, conId) values (4, 7);
insert into outdoorParty (id, conId) values (5, 2);
insert into outdoorParty (id, conId) values (6, 1);
insert into outdoorParty (id, conId) values (7, 18);
insert into outdoorParty (id, conId) values (8, 9);
insert into outdoorParty (id, conId) values (9, 5);
insert into outdoorParty (id, conId) values (10, 16);


-- -----------------------------------
-- Relationship table
-- Table structure for repertoire
-- -----------------------------------
DROP TABLE IF EXISTS `repertoire`;
CREATE TABLE `repertoire` (
    `id`                INT     NOT NULL    AUTO_INCREMENT ,
    `concertId`         INT     NOT NULL ,
    `musicalWorkId`     INT     NOT NULL ,
    CONSTRAINT repertoire_PK PRIMARY KEY (`id`) ,
);

DESCRIBE `repertoire`;

insert into repertoire (concertId, musicalWorkId) values (2, 1);
insert into repertoire (concertId, musicalWorkId) values (1, 5);
insert into repertoire (concertId, musicalWorkId) values (1, 7);
insert into repertoire (concertId, musicalWorkId) values (3, 11);
insert into repertoire (concertId, musicalWorkId) values (2, 11);
insert into repertoire (concertId, musicalWorkId) values (2, 5);
insert into repertoire (concertId, musicalWorkId) values (3, 5);
insert into repertoire (concertId, musicalWorkId) values (1, 5);
insert into repertoire (concertId, musicalWorkId) values (3, 6);
insert into repertoire (concertId, musicalWorkId) values (2, 2);