package com.xzf.org.emall

import com.xzf.org.emall.controller.CategoryController;
import com.xzf.org.emall.controller.GoodsController
import com.xzf.org.emall.utils.JsonTransformer;

import static spark.Spark.get
import static spark.Spark.post
import static spark.Spark.staticFiles;


class Application implements spark.servlet.SparkApplication {

    @Override
    void init() {

        staticFiles.location("/public")

        get("/categories/:catId",CategoryController.getChildCategories,new JsonTransformer())

        get("/categories",CategoryController.getRootCategories,new JsonTransformer())

        post("/goods",GoodsController.addGoods,new JsonTransformer())


    }


    @Override
    public void destroy() {

    }


}
