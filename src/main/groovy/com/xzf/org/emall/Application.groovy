package com.xzf.org.emall;

import com.xzf.org.emall.controller.GoodsController;

import static spark.Spark.get;


class Application implements spark.servlet.SparkApplication {


    @Override
    public void init() {
        get("/goods", GoodsController.goodsTest);
        get("/hello",GoodsController.helloTest);
    }


    @Override
    public void destroy() {

    }


}
