package com.xzf.org.emall.utils

import groovy.transform.CompileStatic
import org.sql2o.Sql2o

@CompileStatic
class DS {

   private static Sql2o sql2o =  new org.sql2o.Sql2o('jdbc:mysql://localhost:3306/emall','root','123456');

   static Sql2o inst(){
       sql2o
   }

}
