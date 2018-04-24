package com.xzf.org.emall.dao;

import com.xzf.org.emall.domain.Category;
import com.xzf.org.emall.utils.DS;
import org.sql2o.Connection;

import java.util.List;

public class CategoryDao {

    final static String queryRootCats = "select id,catName,isLeaf from gt_cat where `parentId` = 0";

    final static String queryChildCats = "select id,catName,isLeaf from gt_cat where `parentId` = :parentId";

    public static List<Category> getRootCategories(){
        try(Connection con = DS.inst().open()){
            return con.createQuery(queryRootCats)
                    .executeAndFetch(Category.class);
        }
    }


    public static List<Category> getChildCategories(Integer catId){
        try(Connection con = DS.inst().open()){
            return con.createQuery(queryChildCats)
                    .addParameter("parentId",catId)
                    .executeAndFetch(Category.class);
        }
    }

    public static Category getCategory(Integer catId){
        try(Connection con = DS.inst().open()){
            String queryStr = "select id,catName,isLeaf from gt_cat where id = :catId";
            return con.createQuery(queryStr)
                    .addParameter("catId",catId)
                    .executeAndFetchFirst(Category.class);

        }

    }



}
