package com.xzf.org.emall.controller;


import com.xzf.org.emall.dao.CategoryDao;
import com.xzf.org.emall.domain.Category;
import com.xzf.org.emall.utils.Result;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class CategoryController {


    public static Route getRootCategories = (Request request, Response response) -> {

        List<Category> rootCategories = CategoryDao.getRootCategories();

        return Result.of(rootCategories);
    };

    public static Route getChildCategories = (Request request,Response response) ->{
        Integer catId = Integer.valueOf(request.params(":catId"));

        List<Category> childCategories = CategoryDao.getChildCategories(catId);

        return Result.of(childCategories);
    };


}
