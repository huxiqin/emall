package com.xzf.org.emall.dao

import com.xzf.org.emall.domain.Category
import com.xzf.org.emall.utils.JsonUtils
import com.xzf.org.emall.utils.Result


def List<Category> rootCategories = CategoryDao.getRootCategories();

println  JsonUtils.toJson(Result.of(rootCategories))


println "---------->"
rootCategories.each{
    println "${it}"
}


def category = CategoryDao.getCategory(1001)
println category


def categories = CategoryDao.getChildCategories(2000)
categories.each{
    println "${it}"
}
