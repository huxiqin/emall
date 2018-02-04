package com.xzf.org.emall.controller;

import spark.Request;
import spark.Response;
import spark.Route;


public class GoodsController {


    public static Route goodsTest = (Request request, Response response) -> {
        return "hello goods";
    };

    public static Route helloTest = (Request request, Response response) -> {
        return "hello goods";
    };


}
