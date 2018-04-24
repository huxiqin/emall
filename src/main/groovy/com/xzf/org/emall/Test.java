package com.xzf.org.emall;


import edu.xzf.Hello;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private final int test;

    private String name;

    public Test(){
        test = 1;
    }


    public Test(String name){
        this.name = name;
        test =1;
    }




    private List<Object> lists = new ArrayList<>();

    public void test(){
       new Hello(){
           public void invoke(){
               super.test();
           }
       }.invoke();
    }


    public class TestInner{
        public void test(){
            System.out.println("Test Inner");
        }
    }


    public static void main(String[] args) {
        Test test = new Test();
        Test.TestInner inner = test.new TestInner();
        inner.test();
    }


}
