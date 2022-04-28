package com.hjk.testboot.sample.encrypt;

import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;


public class Base64Crypto {
    private String ENCODING = "UTF-8";

    public String encode(String str) {

        if (str == null || str.length() < 1) {
            return "";
        }

        String encodeText = "";
        try {
            encodeText = new String(Base64.encodeBase64(str.getBytes(this.ENCODING)));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }

        return encodeText;
    }

    public String decode(String str) {

        if (str == null || str.length() < 1) {
            return "";
        }

        String decodeText = "";
        try {
            decodeText = new String(Base64.decodeBase64(str.getBytes(this.ENCODING)));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }

        return decodeText;
    }
}
