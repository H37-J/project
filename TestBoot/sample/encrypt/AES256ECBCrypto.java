package com.hjk.testboot.sample.encrypt;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;



public class AES256ECBCrypto {

    private String SECRET_KEY = "";
    private String ENCODING = "";
    private static final String ENCRYPTION_IV = "4e5Wa71fYoT7MFEX";

    public AES256ECBCrypto(String secretKey, String encoding)  {
        this.SECRET_KEY = secretKey;
        this.ENCODING = encoding;
    }

    // 암호화
    public String encode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

        if (str == null || str.length() < 1) {
            return "";
        }

        String encodeText = "";
        try {
            byte[] keyData = SECRET_KEY.getBytes(this.ENCODING);

            SecretKey secureKey = new SecretKeySpec(keyData, "AES");
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, secureKey,makeIv());

            byte[] encrypted = c.doFinal(str.getBytes(this.ENCODING));
            encodeText = new String(Base64.encodeBase64(encrypted));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
            System.out.println(e);
        }
        return encodeText;
    }

    // 복호화
    public String decode(String str) throws  java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

        if (str == null || str.length() < 1) {
            return "";
        }

        String decodeText = "";
        try {
            byte[] keyData = SECRET_KEY.getBytes();
            SecretKey secureKey = new SecretKeySpec(keyData, "AES");
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

            c.init(Cipher.DECRYPT_MODE, secureKey,makeIv());
            byte[] byteStr = Base64.decodeBase64(str.getBytes(this.ENCODING));
            decodeText = new String(c.doFinal(byteStr), this.ENCODING);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
            System.out.println(e);
        }

        return decodeText;
    }

    static AlgorithmParameterSpec makeIv() {
		try {
			return new IvParameterSpec(ENCRYPTION_IV.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
