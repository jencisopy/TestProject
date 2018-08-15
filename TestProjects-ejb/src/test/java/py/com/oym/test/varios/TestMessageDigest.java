/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.varios;

import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.junit.Test;

/**
 *
 * @author JORGE
 */
public class TestMessageDigest {

    @Test
    public void test1() throws Exception {
        byte[] data1 = "0123456789xxxxxxxxá".getBytes("UTF-8");

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] digest = messageDigest.digest(data1);

        System.out.println("SHA-256");
        System.out.println("================================");
        System.out.println(bytesToHex(digest).toUpperCase());
        //8D6B36DB5F36072F05C61735F5160A7E65296B7662519CDA24D9D7D766C69A9D

        messageDigest = MessageDigest.getInstance("SHA-512");
        digest = messageDigest.digest(data1);
        System.out.println("SHA-512");
        System.out.println("================================");
        System.out.println(bytesToHex(digest).toUpperCase());
        //042D830E6E411D0A17D14B8C7297C41F057F98F424A16FEF034C4402F2E974B9F284B6AFEDE3C712373CA48F84193BD4FD18BCA76C1977B7E99EA780F1415826

        messageDigest = MessageDigest.getInstance("MD5");
        digest = messageDigest.digest(data1);
        System.out.println("MD5");
        System.out.println("================================");
        //61A8BC4A8BD1CF4ECFC76D050179A689
        System.out.println(bytesToHex(digest).toUpperCase());

    }

    @Test
    public void digestMAC() throws Exception {
        System.out.println("HMACSHA-256");
        System.out.println("================================");
        
        Mac mac = Mac.getInstance("HmacSHA256");
        //Mac mac = Mac.getInstance("HmacSHA1");
        //Mac mac = Mac.getInstance("HmacSHA512");
        //Mac mac = Mac.getInstance("HmacMD5");
        String keyValue = "abcdeá";
        String algorithm = "RawBytes";
        SecretKeySpec key = new SecretKeySpec(keyValue.getBytes("UTF-8"), algorithm);

        mac.init(key);
        
        byte[] data  = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");
        byte[] macBytes = mac.doFinal(data);        
        System.out.println(bytesToHex(macBytes).toUpperCase());
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte byt : bytes) {
            result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }
}
