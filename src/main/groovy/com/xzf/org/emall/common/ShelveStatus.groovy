package com.xzf.org.emall.common

import groovy.transform.CompileStatic

@CompileStatic
enum ShelveStatus {

    UP(1,"上架"),

    DOWN(0,"下架")

    Integer statusCode

    String statusDesc

    private ShelveStatus(Integer statusCode,String statusDesc) {
        this.statusCode = statusCode
        this.statusDesc = statusDesc
    }

}