package com.xzf.org.emall.dao;

import com.xzf.org.emall.common.ShelveStatus;
import com.xzf.org.emall.domain.Category;
import com.xzf.org.emall.domain.Goods;
import com.xzf.org.emall.domain.GoodsListQueryReq;
import com.xzf.org.emall.utils.DS;
import org.sql2o.Connection;

import java.util.List;


public class GoodsDao {

    private static final String insertGoodsSql = "insert into gt_goods(catId,title,mainImageIds,description,price,shelveStatus,createdBy,createdDate)" +
            "values (:catId,:title,:mainImageIds,:description,:price,:shelveStatus,:createdBy,now())";

    private static final String updateGoodsSql = "update gt_goods set title = :title,mainImageIds = :mainImageIds,description = :description,price =:price" +
                                            ", updatedBy = :updatedBy,updatedDate = now() where id=:id";

    public static String insert(Goods goods){
        try(Connection con = DS.inst().open()){
          return  con.createQuery(insertGoodsSql)
                        .bind(goods)
                        .executeUpdate()
                        .getKey().toString();
        }
    }


    public static Integer update(Goods goods){
        try(Connection con = DS.inst().open()){
            con.createQuery(updateGoodsSql)
                        .addParameter("title",goods.getTitle())
                        .addParameter("mainImageIds",goods.getMainImageIds())
                        .addParameter("description",goods.getDescription())
                        .addParameter("price",goods.getPrice())
                        .addParameter("updatedBy",goods.getUpdatedBy())
                        .addParameter("id",goods.getId())
                        .executeUpdate();
           return goods.getId();
        }
    }

    public static Goods queryById(Integer goodsId){
        try(Connection conn = DS.inst().open()){
            String querySql = "select * from gt_goods where id=:id and isDelete != -1";
            List<Goods> goodsList = conn.createQuery(querySql)
                                        .addParameter("id",goodsId)
                                        .executeAndFetch(Goods.class);
            return goodsList != null ? goodsList.get(0) : null;
        }
    }


    public static Integer shelfGoods(ShelveStatus shelveStatus,Integer goodsId){
        try(Connection conn = DS.inst().open()){
            String updateShelfStatusSql = "update gt_goods set shelveStatus =:shelveStatus where id=:id";
            conn.createQuery(updateShelfStatusSql)
                    .addParameter("shelveStatus",shelveStatus.getStatusCode())
                    .addParameter("id",goodsId)
                    .executeUpdate();
            return goodsId;
        }
    }


    public static Integer deleteGoods(Integer goodsId){
        try(Connection conn = DS.inst().open()){
            String deleteSql = "update gt_goods set isDelete = -1";
            conn.createQuery(deleteSql).executeUpdate();
            return goodsId;
        }
    }



}
