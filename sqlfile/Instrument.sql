USE orchestra_final;

-- -----------------------------------
-- Table structure for instrument
-- -----------------------------------
DROP TABLE IF EXISTS `instrument`;
CREATE TABLE `instrument` (
    `id`        INT             NOT NULL    AUTO_INCREMENT ,
    `name`      VARCHAR(15)     CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NOT NULL ,
    `type`      VARCHAR(15)     CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    NOT NULL ,
    `status`    BOOLEAN         NOT NULL    DEFAULT TRUE ,
    CONSTRAINT instrument_PK PRIMARY KEY (`id`)
);

DESCRIBE `instrument`;

insert into instrument (id, name, type, status) values (1, 'guitar', 'strings', true);
insert into instrument (id, name, type, status) values (2, 'cello', 'strings', true);
insert into instrument (id, name, type, status) values (3, 'electric bass', 'strings', false);
insert into instrument (id, name, type, status) values (4, 'piano', 'keyboards', false);
insert into instrument (id, name, type, status) values (5, 'trumpet', 'Brass', false);
insert into instrument (id, name, type, status) values (6, 'piano', 'keyboards', true);
insert into instrument (id, name, type, status) values (7, 'violin', 'strings', true);
insert into instrument (id, name, type, status) values (8, 'electrophones', 'keyboards', true);
insert into instrument (id, name, type, status) values (9, 'bass drum', 'percussion', false);
insert into instrument (id, name, type, status) values (10, 'gongs', 'percussion', true);