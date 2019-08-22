CREATE TABLE `wait`.`menu_item`
(
  `id`               bigint(20)  NOT NULL AUTO_INCREMENT,
  `name`       varchar(20) NOT NULL COMMENT 'name',
  `icon`        varchar(20) NOT NULL COMMENT 'icon',
  `path`        varchar(200) NOT NULL COMMENT 'path',
  `parent_id`          INTEGER(3)  NOT NULL COMMENT 'parent_id',
  `status`          INTEGER(1)  NOT NULL DEFAULT  0 COMMENT 'status',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;