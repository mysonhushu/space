CREATE TABLE `wait`.`chinese_family_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pinyin` varchar(25) NOT NULL COMMENT 'pinyin',
  `family_name` varchar(10) NOT NULL COMMENT 'first_name',
  `family_first_letter` varchar(6) NOT NULL COMMENT 'family_first_letter',
  PRIMARY KEY (`id`),
  KEY `pinyin_inx` (`pinyin`) USING BTREE,
  KEY `family_first_letter_inx` (`family_first_letter`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


CREATE TABLE `wait`.`chinese_name_pool` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL COMMENT 'name',
  `name_pinyin` varchar(25) NOT NULL COMMENT 'name_pinyin',
  `family_name` varchar(10) NOT NULL COMMENT 'family_name',
  `family_name_pinyin` varchar(6) NOT NULL COMMENT 'family_name_pinyin',
  `last_name` varchar(60) NOT NULL COMMENT 'last_name',
  `last_name_pinyin` varchar(6) NOT NULL COMMENT 'last_name_pinyin',
  PRIMARY KEY (`id`),
  KEY `name_pinyin_inx` (`name_pinyin`) USING BTREE,
  KEY `family_name_pinyin_inx` (`family_name_pinyin`) USING BTREE,
  KEY `last_name_pinyin_inx` (`family_name_pinyin`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


CREATE TABLE `wait`.`poetry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL COMMENT 'name',
  `dynasty` varchar(25) NOT NULL COMMENT 'dynasty',
  `content` TEXT NOT NULL COMMENT 'content',
  PRIMARY KEY (`id`),
  KEY `name_inx` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;



CREATE TABLE `wait`.`poetry_fields` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `poetry_id` bigint(20) NOT NULL COMMENT 'poetry_id',
  `field` varchar(40) NOT NULL COMMENT 'field',
  `pinyin` varchar(40) NOT NULL COMMENT 'pinyin',
  `pinyin_abridge` varchar(20) NOT NULL COMMENT 'pinyin_abridge',
  PRIMARY KEY (`id`),
  KEY `pinyin_inx` (`pinyin`) USING BTREE,
  KEY `pinyin_abridge_inx` (`pinyin_abridge`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;