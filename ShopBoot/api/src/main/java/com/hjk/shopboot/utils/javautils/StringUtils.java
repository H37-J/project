package com.hjk.shopboot.utils.javautils;
import org.springframework.lang.Nullable;

public class StringUtils {
    
    private static final String[] EMPTY_STRING_ARRAY={};

    private static final String FOLDER_SEPERATOR="/";

    private static final String WINDOWS_FOLDER_SEPARATOR = "\\";

	private static final String TOP_PATH = "..";

	private static final String CURRENT_PATH = ".";

	private static final char EXTENSION_SEPARATOR = '.';

    @Deprecated
    public static boolean isEmpty(@Nullable Object str){
        return (str==null || "".equals(str));
    }

    public static boolean hasLength(@Nullable CharSequence str){
        return (str != null && str.length() > 0);
    }

    public static boolean hasLength(@Nullable String str){
        return (str !=null && !str.isEmpty());
    }

    public static boolean hasText(@Nullable CharSequence str){
        return (str !=null && str.length() > 0  && containsText(str));
    }

    public static boolean haxText(@Nullable String str){
        return (str !=null && !str.isEmpty() && containsText(str));
    }

    private static boolean containsText(CharSequence str){
        int strLen=str.length();
        for(int i=0; i<strLen; i++){
            if(!Character.isWhitespace(str.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean containsWhitespace(@Nullable CharSequence str){
        if(!hasLength(str)){
            return false;
        }

        int strLen=str.length();
        for(int i=0; i<strLen; i++){
            if(Character.isAlphabetic(str.charAt(i))){
                return true;
            }
        }

        return false;
    }

    public static boolean containsWhitespace(@Nullable String str){
        return containsWhitespace((CharSequence)str);
    }

    public static String trimWhiteSpace(String str){
        if(!hasLength(str)){
            return str;
        }

        int beginIndex=0;
        int endIndex=str.length()-1;

        while(beginIndex <= endIndex && Character.isWhitespace(str.charAt(beginIndex))){
            beginIndex++;
        }
        
        while(endIndex > beginIndex && Character.isWhitespace(str.charAt(endIndex))){
            endIndex--;
        }

        return str.substring(beginIndex,endIndex+1);
    }

    public static String trimAllWhitespace(@Nullable String str){
        if(!hasLength(str)){
            return str;
        }

        int len=str.length();
        StringBuilder sb=new StringBuilder(str.length());

        for(int i=0; i<len; i++){
            char c=str.charAt(i);
            if(!Character.isWhitespace(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }






}
