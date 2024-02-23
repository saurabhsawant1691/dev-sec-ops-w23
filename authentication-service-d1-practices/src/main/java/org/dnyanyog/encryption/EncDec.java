package org.dnyanyog.encryption;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncDec {

	public static SecretKey generateAESKey() throws NoSuchAlgorithmException {
		
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	
		keyGenerator.init(256);
		
		return keyGenerator.generateKey();
	}
	
	public static String encrypt(String plainText, SecretKey key) throws Exception {
		
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] plainTextByte = plainText.getBytes(StandardCharsets.UTF_8);
		byte[] encryptBytes = cipher.doFinal(plainTextByte);
		
		String encryptedDataInString = Base64.getEncoder().encodeToString(encryptBytes);
		
		return encryptedDataInString;
	}
	
	public static String decrypt(String encryptedData, SecretKey key) throws Exception {
		
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		
		byte[] encryptedByteArrayData = Base64.getDecoder().decode(encryptedData);
		byte[] decryptedBytes = cipher.doFinal(encryptedByteArrayData);
		
		return new String(decryptedBytes, StandardCharsets.UTF_8);
	}
	
	public static void main(String[] args) throws Exception {
		
		SecretKey key = generateAESKey();
		
		String plainText = "Test@123";
		
		System.out.println("KEY:-"+ key);
		
		String encryptedText = encrypt(plainText, key);
		System.out.println("Encrypted:- "+ encryptedText);
		
		String decryptText = decrypt(encryptedText, key);
		System.out.println("Decrypted:- "+ decryptText);
	}
}
