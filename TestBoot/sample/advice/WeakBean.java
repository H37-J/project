package com.hjk.testboot.sample.advice;

public class WeakBean {
    
    public static void doSome(int time){
        for(int i=0; i<time; i++){
            work();
        }
    }

    public static void work(){
        System.out.println("work");
    }
}
