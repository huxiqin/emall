package com.xzf.org.emall.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.CompileStatic

@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
class Category {

    Integer id

    String catName

    Integer isLeaf


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", catName='" + catName + '\'' +
                ", isLeaf=" + isLeaf +
                '}';
    }
}
