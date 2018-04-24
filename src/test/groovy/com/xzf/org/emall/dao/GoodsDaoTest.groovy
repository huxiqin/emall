package com.xzf.org.emall.dao

import com.xzf.org.emall.common.ShelveStatus
import com.xzf.org.emall.domain.Goods


Goods goods = new Goods();

goods.id=3
goods.catId = 1000
goods.description="I am goods desc contents"
goods.mainImageIds="1,2,3,4"
goods.price=1200
goods.createdBy="xzf"
goods.shelveStatus=0
goods.title="I am goods title"

//def id = GoodsDao.insert(goods)
//println id

//def updateId = GoodsDao.update(goods)
//println updateId;


//println GoodsDao.queryById(3)

//GoodsDao.shelfGoods(ShelveStatus.DOWN,3)
//Goods result = GoodsDao.queryById(3)
//assert result.shelveStatus == ShelveStatus.DOWN.statusCode

GoodsDao.deleteGoods(3)
Goods result = GoodsDao.queryById(3)
assert result.isDelete == -1