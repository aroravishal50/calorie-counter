/**
 * File - Encryption.java 
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 **/
package com.cc.utilities;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;


public class Encryption {
	 private static byte[] uniquePrivateKey = {
	            0x67, 0x66, 0x65, 0x71, 0x72, 0x73, 0x50, 0x51, 0x52, 0x53, 0x54, 0x55, 0x56, 0x33, 0x14, 0x63
	    };
	 // 0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79
	 public static String encrypt(String passwordEncrypt)
	    {
	        try
	        {
	            Cipher cipherKey = Cipher.getInstance("AES/ECB/PKCS5Padding");
	            
	            final SecretKeySpec privateKey = new SecretKeySpec(uniquePrivateKey, "AES");
	            
	            cipherKey.init(Cipher.ENCRYPT_MODE, privateKey);
	            
	            final String privateEncryptedString = Base64.encodeBase64String(cipherKey.doFinal(passwordEncrypt.getBytes()));
	            
	            return privateEncryptedString;
	        }
	        catch (Exception e)
	        {
	       
	        }
	        return null;

	    }

	
}
