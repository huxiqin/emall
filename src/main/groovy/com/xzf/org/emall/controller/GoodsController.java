package com.xzf.org.emall.controller;

import com.xzf.org.emall.common.ShelveStatus;
import com.xzf.org.emall.dao.GoodsDao;
import com.xzf.org.emall.domain.Goods;
import com.xzf.org.emall.domain.GoodsListQueryReq;
import com.xzf.org.emall.utils.JsonUtils;
import com.xzf.org.emall.utils.Result;
import org.apache.commons.lang3.StringUtils;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;


public class GoodsController {


    /**
     * 添加商品
     */
    public static Route addGoods = (Request request, Response response) -> {
        String data = request.params("data");
        if(StringUtils.isNotEmpty(data)) {
            String id = GoodsDao.insert(JsonUtils.parser(data, Goods.class));
            return Result.of(id);
        }
        return Result.addErr("invalid data");
    };


    /**
     * 根据商品id查询商品（查询商品详情）
     */
    public static Route queryGoodsDetail = (Request request, Response response) -> {
        Integer goodsId = Integer.valueOf(request.params(":goodsId"));
        Goods goods = GoodsDao.queryById(goodsId);
        if(goods!=null){
            return Result.of(goods);
        }
        return Result.addErr("商品不存在");
    };


    /**
     * 查询商品列表
     */
    public static Route queryGoodsList = (Request request, Response response) -> {
        String reqParam = request.params("data");
        GoodsListQueryReq queryReq = JsonUtils.parser(reqParam, GoodsListQueryReq.class);
        List<Goods> goodsList = null;
        return null;
    };



    /**
     * 下架商品
     */
    public static Route downShelveGoods = (Request request, Response response)->{
        Integer goodsId = Integer.valueOf(request.params(":goodsId"));
        Integer resultId = GoodsDao.shelfGoods(ShelveStatus.DOWN,goodsId);
        if(goodsId.intValue() == resultId){
            return Result.of(goodsId);
        }
        return Result.addErr("下架失败");

    };

    /**
     * 上架商品
     */
    public static Route upShelveGoods = (Request request, Response response)->{
        Integer goodsId = Integer.valueOf(request.params(":goodsId"));
        Integer resultId = GoodsDao.shelfGoods(ShelveStatus.UP,goodsId);
        if(goodsId.intValue() == resultId){
            return Result.of(goodsId);
        }
        return Result.addErr("上架失败");

    };

    /**
     * 删除商品
     */
    public static Route deleteGoods = (Request request, Response response)->{
        Integer goodsId = Integer.valueOf(request.params(":goodsId"));
        Integer resultId = GoodsDao.deleteGoods(goodsId);
        if(goodsId.intValue() == resultId){
            return Result.of(goodsId);
        }
        return Result.addErr("删除失败");
    };







}
