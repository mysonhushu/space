CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(25) NOT NULL COMMENT 'user phone',
  `status` varchar(60) NOT NULL COMMENT 'user status',
  `data_status` varchar(2) NOT NULL COMMENT 'data status',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create date',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update date',
  PRIMARY KEY (`id`),
  KEY `phone_index` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


CREATE TABLE `user_credential` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT 'user_id',
  `credential_value` varchar(200) NOT NULL COMMENT 'user credential value',
  `credential_type` varchar(30) NOT NULL COMMENT 'credential type',
  `status` varchar(60) NOT NULL COMMENT 'user status',
  `salt` varchar(60) NOT NULL COMMENT 'salt',
  `data_status` varchar(2) NOT NULL COMMENT 'data status',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create date',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update date',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

CREATE TABLE `user_identity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT 'user_id',
  `status` varchar(60) NOT NULL COMMENT 'identity status',
  `identity_type` varchar(30) NOT NULL COMMENT 'identity type',
  `identity_value` varchar(120) NOT NULL COMMENT 'identity value',
  `company_id` bigint(20) NOT NULL  COMMENT 'company id',
  `department_id` bigint(20) NOT NULL  COMMENT 'department id',
  `data_status` varchar(2) NOT NULL COMMENT 'data status',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create date',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update date',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_user_id` bigint(20) NOT NULL COMMENT 'create_user_id',
  `create_user_name` varchar(120) NOT NULL COMMENT 'create_user_name',
  `status` varchar(60) NOT NULL COMMENT 'company status',
  `company_name` varchar(120) NOT NULL COMMENT 'company_name',
  `area_id` bigint(20) NOT NULL COMMENT 'area_id',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create date',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update date',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(120) DEFAULT NULL COMMENT 'department name',
  `area_id` bigint(20) DEFAULT NULL COMMENT 'area_id',
  `status` varchar(60) NOT NULL COMMENT 'department status',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create date',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update date',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


CREATE TABLE `user_queue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT 'user_id',
  `phone` varchar(25) NOT NULL COMMENT 'user phone',
  `department_id` bigint(20) NOT NULL COMMENT 'department_id',
  `company_id` bigint(20) NOT NULL COMMENT 'company_id',
  `status` varchar(60) NOT NULL COMMENT 'department status',
  `logic_delete` varchar(2) NOT NULL COMMENT 'logic_delete status',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create date',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update date',
  `queue_date` datetime DEFAULT NULL COMMENT 'queue date',
  `missed_date` datetime DEFAULT NULL COMMENT 'missed date',
  `missed_times` bigint(20) NOT NULL COMMENT 'missed times',
  `end_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'end date',
  `time_consuming` bigint(20) NOT NULL COMMENT 'time_consuming',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
