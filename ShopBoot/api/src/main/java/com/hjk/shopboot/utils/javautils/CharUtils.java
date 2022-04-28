package com.hjk.shopboot.utils.javautils;

import com.hjk.shopboot.utils.javautils.text.ASCIIStrCache;

public class CharUtils {

    public static boolean isAscii(char ch){
        return ch<128;
    }

    public static boolean isAsciiPrintable(char ch){
        return ch>=32 && ch<127;
    }

    public static boolean isAsciiControl(final char ch) {
        return ch < 32 || ch == 127;
    }

    public static boolean isLetter(char ch){
        return isLetterUpper(ch) || isLetterLower(ch);
    }

    public static boolean isLetterUpper(final char ch){
        return ch>= 'A' && ch <='Z';
    }

    public static boolean isLetterLower(final char ch){
        return ch>='a' && ch<='z';
    }

    public static boolean isNumber(char ch){
        return ch>='0' && ch<='9';
    }

    public static boolean isHexChar(char c) {
        return isNumber(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }

    public static boolean isLetterOrNumber(final char ch){
        return isLetter(ch) || isNumber(ch);
    }

    public static String toString(char c){
        return ASCIIStrCache.toString(c);
    }

    public static boolean isCharClass(Class<?> clazz){
        return clazz==Character.class || clazz==char.class;
    }

    public static boolean isBlankChar(char c) {
        return isBlankChar((int) c);
    }

    public static boolean isBlankChar(int c) {
        return Character.isWhitespace(c)
                || Character.isSpaceChar(c)
                || c == '\ufeff'
                || c == '\u202a'
                || c == '\u0000';
    }

    public static boolean equals(char c1, char c2, boolean ignoreCase) {
        if (ignoreCase) {
            return Character.toLowerCase(c1) == Character.toLowerCase(c2);
        }
        return c1 == c2;
    }

    public static int getType(int c){
        return Character.getType(c);
    }

    public static int digit16(int b) {
        return Character.digit(b, 16);
    }

}
