/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.junit.Test;

/**
 *
 * @author JORGE
 */
public class TestEncryptBlowfish {

    @Test
    public void test1() throws Exception {
        String strKey = "xxxxyyyyxxxxyyy";
        String strClearText = "hola que tal";
        String encrypted = encrypt(strClearText, strKey);
        System.out.println(encrypted);
        //
        String decrypted = decrypt(encrypted, strKey);
        System.out.println(decrypted);
    }

    public String encrypt(String clearText, String key) throws Exception{
        SecretKeySpec skeyspec = new SecretKeySpec(key.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
        byte[] encrypted = cipher.doFinal(clearText.getBytes());
        String strData = new String(encrypted);
        return strData;
    }
    
    public String decrypt(String strEncrypted, String strKey) throws Exception {
        String strData = "";

        SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, skeyspec);
        byte[] decrypted = cipher.doFinal(strEncrypted.getBytes());
        strData = new String(decrypted);

        return strData;
    }
}
