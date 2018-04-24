

CREATE TABLE `gt_cat` (
  `id` int(8) unsigned NOT NULL COMMENT '类目id',
  `cat_name` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '类目名称',
  `parent_id` int(8) unsigned NOT NULL DEFAULT '0' COMMENT '父类目id',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `level` smallint(6) NOT NULL COMMENT '类目等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


insert into `gt_cat` (`id`,`cat_name`,`parent_id`,`level`,`created_date`) values (2001,"沙发",2000,2,now());

insert into `gt_cat` (`id`,`cat_name`,`parent_id`,`level`,`created_date`) values (2002,"凳子",2000,2,now());


CREATE TABLE `gt_goods` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `catId` int(8) unsigned NOT NULL COMMENT '类目ID',
  `title` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '商品标题',
  `mainImageIds` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品主图',
  `description` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品描述',
  `price` decimal(20,2) DEFAULT NULL COMMENT '商品价格',
  `isDelete` smallint(6) NOT NULL DEFAULT '0' COMMENT '是否删除；0:正常；-1:删除',
  `shelveStatus` smallint(6) NOT NULL DEFAULT '0' COMMENT '上下架状态；1:上架；0:下架',
  `createdDate` datetime NOT NULL COMMENT '创建时间',
  `createdBy` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `updatedDate` datetime DEFAULT NULL COMMENT '更新时间',
  `updatedBy` varchar(50) COLLATE utf8mb4_bin DEFAULT 'sys' COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;