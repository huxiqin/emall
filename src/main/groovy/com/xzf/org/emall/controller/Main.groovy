package com.xzf.org.emall.controller

import com.xzf.org.emall.domain.Goods
import com.xzf.org.emall.modle.GoodsModel
import com.xzf.org.emall.modle.impl.Sql2oGoodsModel
import org.sql2o.Sql2o

import static spark.Spark.*;

Sql2o sql2o = new Sql2o('jdbc:mysql://localhost:3306/emall','root','123456')

GoodsModel goodsModel = new Sql2oGoodsModel(sql2o);

evaluate(new File("Test.groovy"))

post("/goods"){
    req, res ->
        Goods goods = new Goods()
        goods.id = 1
        goods.goodsName="milk"
        goods.goodsDesc="milk is nice."
        goodsModel.createGoods(goods)
};


