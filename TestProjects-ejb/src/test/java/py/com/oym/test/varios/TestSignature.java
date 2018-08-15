/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.varios;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.javabeanstack.util.Fn;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author JORGE
 */
public class TestSignature {
    @Test
    public void test1() throws Exception{
        Signature signature = Signature.getInstance("SHA256WithDSA");
        
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        signature.initSign(keyPair.getPrivate(), secureRandom);        
        
        byte[] data = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");
        signature.update(data);

        byte[] digitalSignature = signature.sign();
        
        // Verificar
        byte[] data2 = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");        
        Signature signature2 = Signature.getInstance("SHA256WithDSA");
        signature2.initVerify(keyPair.getPublic());        
        signature2.update(data2);
        Assert.assertTrue(signature2.verify(digitalSignature));        
        
        System.out.println(keyPair.getPublic().toString());
    }
    
    @Test
    public void test2() throws Exception{
        Signature signature = Signature.getInstance("SHA512WithRSA");
        
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        signature.initSign(keyPair.getPrivate(), secureRandom);   
        System.out.println("Private key");
        System.out.println("===============================");
        System.out.println(Fn.bytesToBase64(keyPair.getPrivate().getEncoded()));
        
        byte[] data = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");
        signature.update(data);

        byte[] digitalSignature = signature.sign();
        String digitalSignature64 = Fn.bytesToBase64(digitalSignature);
        byte[] digitalSignature2 = Fn.base64ToBytes(digitalSignature64);        
        Assert.assertArrayEquals(digitalSignature, digitalSignature2);
        
        // Verificar
        byte[] data2 = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");        
        Signature signature2 = Signature.getInstance("SHA512WithRSA");
        signature2.initVerify(keyPair.getPublic());        
        signature2.update(data2);
        Assert.assertTrue(signature2.verify(digitalSignature));        
        
        // solo para probar 
        byte[] keyPrivate = keyPair.getPrivate().getEncoded();
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyPrivate);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey keyPrivate2 = kf.generatePrivate(spec);
        Assert.assertEquals(keyPair.getPrivate(), keyPrivate2);
        
        // Verificar         
        String keyPublic = Fn.bytesToBase64(keyPair.getPublic().getEncoded());
        PublicKey keyPublic2 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Fn.base64ToBytes(keyPublic)));
        
        byte[] data3 = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");        
        Signature signature3 = Signature.getInstance("SHA512WithRSA");
        signature3.initVerify(keyPublic2);        
        signature3.update(data3);
        
        Assert.assertTrue(signature3.verify(digitalSignature2));                
        //Assert.assertTrue(signature3.verify(digitalSignature));        

    }
}
