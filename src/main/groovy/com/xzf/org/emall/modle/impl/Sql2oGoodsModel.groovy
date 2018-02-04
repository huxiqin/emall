package com.xzf.org.emall.modle.impl

import com.xzf.org.emall.domain.Goods
import com.xzf.org.emall.modle.GoodsModel
import org.sql2o.Connection
import org.sql2o.Sql2o


class Sql2oGoodsModel implements GoodsModel{

    private Sql2o sql2o;

    Sql2oGoodsModel(Sql2o sql2o){
        this.sql2o = sql2o
    }

    @Override
    Integer createGoods(Goods goods) {

        Connection connection = sql2o.beginTransaction();
        connection.createQuery("insert into gt_goods(id, goods_name, goods_desc) VALUES (:id, :goods_name, :goods_desc)")
                .addParameter("id", goods.id)
                .addParameter("goods_name", goods.goodsName)
                .addParameter("goods_desc", goods.goodsDesc)
                .executeUpdate();
        connection.commit()
        goods.id

    }


}
