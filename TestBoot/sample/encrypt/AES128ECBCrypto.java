package com.hjk.testboot.sample.encrypt;


import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;



public class AES128ECBCrypto {

    private String SECRET_KEY = "";
    private String ENCODING = "";
    private static final String ENCRYPTION_IV = "Ae5Sa71fYoT7MFEX";

    public AES128ECBCrypto(String secretKey, String encoding) {
        this.SECRET_KEY = secretKey;
        this.ENCODING = encoding;
    }

    public String encode(String message) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

        if (message == null || message.length() < 1) {
            return "";
        }

        String encodeText = "";
        try {
            byte[] keyData = SECRET_KEY.getBytes(this.ENCODING);
            SecretKey secureKey = new SecretKeySpec(keyData, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secureKey,makeIv());

            byte[] encrypted = cipher.doFinal(message.getBytes(this.ENCODING));
            encodeText = new String(Base64.encodeBase64(encrypted));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println(e.getMessage());
        }
        return encodeText;
    }

    public String decode(String encrypted) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

        if (encrypted == null || encrypted.length() < 1) {
            return "";
        }

        String decodeText = "";
        try {

            byte[] keyData = SECRET_KEY.getBytes(this.ENCODING);
            SecretKey secureKey = new SecretKeySpec(keyData, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secureKey,makeIv());

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
            decodeText = new String(original, this.ENCODING);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println(e.getMessage());
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
