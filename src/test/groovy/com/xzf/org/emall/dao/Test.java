package com.xzf.org.emall.dao;

public class Test {


    private static int [] a ={2,4,9,8,7};


    private static void sort(int []a,int left,int right){

        int i = left;
        int j = right;

        if(right < left) return;

        int temp = a[left];

        int t;

        while(i != j){

            while(i<j && a[j]>temp){
                j--;
            }
            while(i<j && a[i]<temp){
                i++;
            }

            if(i<j){
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        sort(a,i+1,right);
        sort(a,left,i-1);

    }


    public static void main(String[] args) {

        sort(a,0,4);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }


}
