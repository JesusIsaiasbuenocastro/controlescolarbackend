package com.proyecto.control.escolar.controlescolar.serviceImpl;
 
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import com.proyecto.control.escolar.controlescolar.service.LoginService;

 
@Service
public class LoginServiceImpl implements LoginService{
	 

	@Override
	public String encryptPassword(String password){
		String privateKey = "124343";
		try 
        {
            String text = "Hello World";
            String key = "Bar12345Bar12345"; // 128 bit key 
            
            String encryptedText = Encrypt(password,key);
            System.out.println(encryptedText);
            String decriptedText  = Decrypt(encryptedText, key);
            System.out.println(decriptedText);
           
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
		return null;  
		
	}

	@Override
	public void decryptPassword(String password) {
		// TODO Auto-generated method stub
		
	}
	public static String Encrypt(String text, String key )  
    {   
		String encodedString = "";
		try {
			
			/* byte[] CIPHER_KEY = "12989eji292iek23092i9eik9k3e091k".getBytes(StandardCharsets.UTF_8);
		  byte[] IV = "1234567890ABCDEF".getBytes(StandardCharsets.UTF_8);
		    char PADDING_CHAR = '\034';
			
		    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
	        SecretKeySpec keySpec = new SecretKeySpec(CIPHER_KEY, "AES");
	        cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(IV));
	        int paddingSize = 16 - text.length() % 16;
	        String padding = String.format("%0" + paddingSize + "d", 0).replace('0', PADDING_CHAR);
	        String padded = text + padding;
	        //byte[] encrypted = cipher.doFinal(padded.getBytes(StandardCharsets.UTF_8));
	        //return Base64.getEncoder().encodeToString(encrypted);
	        */
	        return null;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
        return encodedString;        
    }   
	
	 
	public static String Decrypt(String encryptedText, String key )  
    {   
		String decrypted = "";
		try {
			
			/* byte[] CIPHER_KEY = "12989eji292iek23092i9eik9k3e091k".getBytes(StandardCharsets.UTF_8);
			    byte[] IV = "1234567890ABCDEF".getBytes(StandardCharsets.UTF_8);
			    char PADDING_CHAR = '\034';
				
			
			 Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
		        SecretKeySpec keySpec = new SecretKeySpec(CIPHER_KEY, "AES");
		        cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(IV));
		        byte[] encrypted = Base64.getDecoder().decode(encryptedText);
		        String padded = new String(cipher.doFinal(encrypted), StandardCharsets.UTF_8);
		        return padded.replaceAll(PADDING_CHAR + "+$", "");*/
	        
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
        return decrypted;        
    }   
	 

}
