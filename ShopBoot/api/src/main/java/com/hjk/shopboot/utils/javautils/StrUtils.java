package com.hjk.shopboot.utils.javautils;

public class StrUtils extends CharSequenceUtil {

    public static String reverse(String str){
        return new String(ArrayUtils.reverse(str.toCharArray()));
    }

    public static String[] toLowercase(String[] strArr){
        if(strArr==null) return null;
        String[] res=new String[strArr.length];
        for(int i=0; i<strArr.length; i++){
            res[i]=strArr[i].toLowerCase();
        }
        return res;
    }

    public static boolean contains(String str,String[] strArr){
        if(strArr==null) return false;

        for(String arrStr:strArr){
            if(str.contains(arrStr)){
                return true;
            }
        }
        return false;
    }

}
