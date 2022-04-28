package com.hjk.shopboot.utils.javautils;

public class CharSequenceUtil {


    public static final int INDEX_NOT_FOUND=-1;

    public static final String NULL="null";

    public static final String EMPTY="";

    public static final String SPACE=" ";

    public static boolean isBlank(CharSequence str){
        int length;

        if((str==null) || ((length=str.length())==0)){
            return true;
        }

        for (int i = 0; i < length; i++) {

            if (!CharUtils.isBlankChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasBlank(CharSequence... strs){
        if(ArrayUtils.isEmpty(strs)){
            return true;
        }

        for(CharSequence str:strs){
            if(isBlank(str)){
                return true;
            }
        }
        return false;
    }

    public static boolean isAllBlank(CharSequence... strs){
        if(ArrayUtils.isEmpty(strs)){
            return true;
        }

        for(CharSequence str:strs){
            if(!isBlank(str)){
                return false;
            }
        }

        return true;
    }

    public static boolean isEmpty(CharSequence str){
        return str==null || str.length()==0;
    }

    public static boolean isNotEmpty(CharSequence str) {
        return false == isEmpty(str);
    }

    public static String emptyIfNull(CharSequence str){
        return nullToEmpty(str);
    }

    public static String nullToEmpty(CharSequence str){
        return nullToDefault(str,EMPTY);
    }

    public static String nullToDefault(CharSequence str,String defaultStr){
        return (str==null) ? defaultStr : str.toString();
    }

    public static String blankToDefault(CharSequence str, String defaultStr) {
        return isBlank(str) ? defaultStr : str.toString();
    }

    public static String emptyToNull(CharSequence str) {
        return isEmpty(str) ? null : str.toString();
    }


    public static boolean hasEmpty(CharSequence... strs){
        if(ArrayUtils.isEmpty(strs)){
            return true;
        }

        for(CharSequence str:strs){
            if(isEmpty(str)){
                return true;
            }
        }
        return false;
    }
}
