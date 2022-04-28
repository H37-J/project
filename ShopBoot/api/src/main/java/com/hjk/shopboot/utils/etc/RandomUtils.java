package com.hjk.shopboot.utils.etc;

import java.util.Random;

public class RandomUtils {
    
    public static Integer getRandom(int number){
        if(number==0) return null;
        Random random=new Random();
        return random.nextInt(number);
    }   
}
