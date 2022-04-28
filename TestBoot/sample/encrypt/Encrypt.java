package com.hjk.testboot.sample.encrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Encrypt {
    // 4E]uMr6Uag8L*MGu
    private final String SECRET_KEY = "ab12395990123922";
    // 인코딩 (고정값)
    private static final String ENCODING = "UTF-8";

    public static void main(String[] args) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException  {
        String plainText = "K20110740@@@###1";
        
        Encrypt en=new Encrypt();


        String c=en.encrypt(plainText);
        System.out.println(c);


        String md=en.md5(plainText);
        System.out.println(md);
    }

    public String encrypt(String plainText) throws  java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        return new AES128ECBCrypto(SECRET_KEY, ENCODING).encode(plainText);
    }

    public String decrypt(String plainText) throws  java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        return new AES128ECBCrypto(SECRET_KEY, ENCODING).decode(plainText);
    }

 

    public static String md5(String pwd) {
	    String MD5 = "";
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(pwd.getBytes());
	        byte byteData[] = md.digest();
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        MD5 = sb.toString();
	 
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	        MD5 = null;
	    }
	    return MD5;
	}
}

