/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.varios;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.Key;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author JORGE
 */
//[B@4f063c0a
//[B@4f063c0a
public class TextEncript {
    @Test
    public void test1() throws Exception {
        String key = "abcdefghijklmop";
        String clean = "12-0010000-444455";
        
        byte[] encrypted = encrypt_AES_CBC(clean, key);
        System.out.println(new String(encrypted));
        //Assert.assertEquals("?Í¦€éCeçj72[8|˜PU¾ÚÓ?æOD¦:_©—wP?9¬}Tœ90e",new String(encrypted));
        System.out.println(encrypted);        
        String decrypted = decrypt_AES_CBC(encrypted, key);
        System.out.println(decrypted);
    }

    //@Test
    public void test2() throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish");
        String keyStr = "abcdefghijklmop";
        String plainText1 = "100";
        String plainText2 = "200";

        Key key = new SecretKeySpec(keyStr.getBytes(), "Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        cipher.update(plainText1.getBytes("UTF-8"));
        byte[] cipherText2 = cipher.doFinal(plainText2.getBytes("UTF-8"));

        System.out.println(new String(cipherText2));
        //byte[] data3 = "01234567890123456789012345".getBytes("UTF-8");
        //byte[] cipherText3 = cipher.doFinal(data3);    
    }
    
    public byte[] encrypt_AES_CBC(String plainText, String key) throws Exception {
        byte[] clean = plainText.getBytes();

        // Generating IV.
        int ivSize = 16;
        byte[] iv = new byte[ivSize];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        // Hashing key.
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(key.getBytes("UTF-8"));
        byte[] keyBytes = new byte[16];
        System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        // Encrypt.
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(clean);

        // Combine IV and encrypted part.
        byte[] encryptedIVAndText = new byte[ivSize + encrypted.length];
        System.arraycopy(iv, 0, encryptedIVAndText, 0, ivSize);
        System.arraycopy(encrypted, 0, encryptedIVAndText, ivSize, encrypted.length);

        return encryptedIVAndText;
    }
    
    public String decrypt_AES_CBC(byte[] encryptedIvTextBytes, String key) throws Exception {
        int ivSize = 16;
        int keySize = 16;

        // Extract IV.
        byte[] iv = new byte[ivSize];
        System.arraycopy(encryptedIvTextBytes, 0, iv, 0, iv.length);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        // Extract encrypted part.
        int encryptedSize = encryptedIvTextBytes.length - ivSize;
        byte[] encryptedBytes = new byte[encryptedSize];
        System.arraycopy(encryptedIvTextBytes, ivSize, encryptedBytes, 0, encryptedSize);

        // Hash key.
        byte[] keyBytes = new byte[keySize];
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(key.getBytes());
        System.arraycopy(md.digest(), 0, keyBytes, 0, keyBytes.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        // Decrypt.
        Cipher cipherDecrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipherDecrypt.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decrypted = cipherDecrypt.doFinal(encryptedBytes);

        return new String(decrypted);
    }
}

