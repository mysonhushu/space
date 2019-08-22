CREATE TABLE `wait`.`family_name`
(
  `id`                  bigint(20)  NOT NULL AUTO_INCREMENT,
  `pinyin`              varchar(10) NOT NULL COMMENT 'pinyin',
  `pinyin_letter`       varchar(10) NOT NULL COMMENT 'pinyin',
  `family_name`         varchar(10) NOT NULL COMMENT 'first_name',
  `family_first_letter` varchar(4)  NOT NULL COMMENT 'family_first_letter',
  PRIMARY KEY (`id`),
  KEY `pinyin_letter_inx` (`pinyin_letter`) USING BTREE,
  KEY `family_first_letter_inx` (`family_first_letter`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;


CREATE TABLE `wait`.`name_pool`
(
  `id`           bigint(20)  NOT NULL AUTO_INCREMENT,
  `name`         varchar(60) NOT NULL COMMENT 'name',
  `name_pinyin`  varchar(25) DEFAULT NULL COMMENT 'name_pinyin',
  `name_letter`  varchar(25) DEFAULT NULL COMMENT 'name_letter',
  `first_word`   varchar(10) NOT NULL COMMENT 'first_word',
  `second_word`  varchar(10) DEFAULT NULL COMMENT 'second_word',
  `third_word`   varchar(10) DEFAULT NULL COMMENT 'third_word',
  `fourth_word`  varchar(10) DEFAULT NULL COMMENT 'fourth_word',
  `frequency`    INTEGER(5)  NOT NULL COMMENT 'frequency',
  `family_names` TEXT        NOT NULL COMMENT 'family_names',
  PRIMARY KEY (`id`),
  KEY `name_pinyin_inx` (`name_pinyin`) USING BTREE,
  KEY `name_letter_inx` (`name_letter`) USING BTREE,
  KEY `first_word_inx` (`first_word`) USING BTREE,
  KEY `second_word_inx` (`second_word`) USING BTREE,
  KEY `third_word_inx` (`third_word`) USING BTREE,
  KEY `fourth_word_inx` (`fourth_word`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;


CREATE TABLE `wait`.`poetry`
(
  `id`      bigint(20)  NOT NULL AUTO_INCREMENT,
  `name`    varchar(60) NOT NULL COMMENT 'name',
  `dynasty` varchar(25) NOT NULL COMMENT 'dynasty',
  `content` TEXT        NOT NULL COMMENT 'content',
  PRIMARY KEY (`id`),
  KEY `name_inx` (`name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;


CREATE TABLE `wait`.`word`
(
  `id`            bigint(20)   NOT NULL AUTO_INCREMENT,
  `word`          varchar(20)  NOT NULL COMMENT 'word',
  `first_letter`  varchar(4)   NOT NULL COMMENT 'first_letter',
  `pinyin`        varchar(10)  NOT NULL COMMENT 'pinyin',
  `pinyin_letter` varchar(10)  NOT NULL COMMENT 'pinyin_letter',
  `strokes`       INTEGER(2)   NOT NULL COMMENT 'strokes',
  `radicals`      varchar(8)   NOT NULL COMMENT 'radicals',
  `explanation`   varchar(200) NOT NULL COMMENT 'explanation',
  `more`          varchar(200) NOT NULL COMMENT 'explanation',
  PRIMARY KEY (`id`),
  KEY `word_pinyin_letter_inx` (`pinyin_letter`) USING BTREE,
  KEY `word_first_letter_inx` (`first_letter`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;


CREATE TABLE `wait`.`word_frequency`
(
  `id`             bigint(20)  NOT NULL AUTO_INCREMENT,
  `word_id`        bigint(20)  NOT NULL COMMENT 'word_id',
  `word`           varchar(20) NOT NULL COMMENT 'word',
  `sensitive_type` varchar(20) NOT NULL COMMENT 'sensitive_type',
  `frequency`      INTEGER(5)  NOT NULL COMMENT 'frequency',
  `status`         varchar(10) NOT NULL COMMENT 'status',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;


CREATE TABLE `wait`.`poetry_index`
(
  `id`              bigint(20)  NOT NULL AUTO_INCREMENT,
  `first_word`      varchar(10) NOT NULL COMMENT 'first_word',
  `second_word`     varchar(10) DEFAULT NULL COMMENT 'second_word',
  `third_word`      varchar(10) DEFAULT NULL COMMENT 'third_word',
  `fourth_word`     varchar(10) DEFAULT NULL COMMENT 'fourth_word',
  `words`           varchar(20) NOT NULL COMMENT 'words',
  `words_pinyin`    varchar(40) DEFAULT NULL COMMENT 'words_pinyin',
  `words_letter`    varchar(40) DEFAULT NULL COMMENT 'words_letter',
  `poetry_ids`      TEXT        NOT NULL COMMENT 'poetry_ids',
  `poetry_ids_size` INTEGER(5)  NOT NULL COMMENT 'poetry_ids_size',
  `is_name`            tinyint(1)  default 0 COMMENT 'is_name',
  PRIMARY KEY (`id`),
  KEY `words_letter_inx` (`words_letter`) USING BTREE,
  KEY `first_word_inx` (`first_word`) USING BTREE,
  KEY `second_word_inx` (`second_word`) USING BTREE,
  KEY `third_word_inx` (`third_word`) USING BTREE,
  KEY `fourth_word_inx` (`fourth_word`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;



CREATE TABLE `wait`.`calendar`
(
  `id`               bigint(20)  NOT NULL AUTO_INCREMENT,
  `solar_full`       varchar(60) NOT NULL COMMENT 'solar_full',
  `lunar`            varchar(20) NOT NULL COMMENT 'lunar',
  `lunar_year`       INTEGER(5)  NOT NULL COMMENT 'lunar_year',
  `lunar_month`      INTEGER(2)  NOT NULL COMMENT 'lunar_month',
  `lunar_day`        INTEGER(2)  NOT NULL COMMENT 'lunar_day',
  `week`             varchar(20) NOT NULL COMMENT 'week',
  `terms`            varchar(20) DEFAULT NULL COMMENT 'terms',
  `lunar_year_name`  varchar(10) DEFAULT NULL COMMENT 'lunar_year_name',
  `lunar_month_name` varchar(10) DEFAULT NULL COMMENT 'lunar_month_name',
  `lunar_day_name`   varchar(10) NOT NULL COMMENT 'lunar_day_name',
  `lunar_year_number`  INTEGER(2)  NOT NULL COMMENT 'lunar_year_number',
  `lunar_month_number`  INTEGER(2)  NOT NULL COMMENT 'lunar_month_number',
  `lunar_day_number`  INTEGER(2)  NOT NULL COMMENT 'lunar_day_number',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;

CREATE TABLE `wait`.`dictionary`
(
  `id`               bigint(20)  NOT NULL AUTO_INCREMENT,
  `code_point`       varchar(20) NOT NULL COMMENT 'code_point',
  `hash_code`        varchar(20) NOT NULL COMMENT 'hash_code',
  `word`        varchar(60) NOT NULL COMMENT 'character',
  `strokes`          INTEGER(3)  NOT NULL COMMENT 'strokes',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;



















