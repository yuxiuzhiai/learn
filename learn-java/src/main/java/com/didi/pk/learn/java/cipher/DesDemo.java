package com.didi.pk.learn.java.cipher;



import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/**
 * @author pengkai
 * @date 2019-11-01
 */
public class DesDemo {

    public static void main(String[] args) {

        String content = "aaaaaaaabbbbbbbbaaaaaaaa";
        String key = "01234567";

        System.out.println("加密前 "+ byteToHexString(content.getBytes()));

        byte[] encrypted = DES_CBC_Encrypt(content.getBytes(), key.getBytes());
        System.out.println("加密后："+byteToHexString(encrypted));

        byte[] decrypted=DES_CBC_Decrypt(encrypted, key.getBytes());
        System.out.println("解密后："+byteToHexString(decrypted));


        printKey(key.getBytes());


    }

    /**
     * 加密
     * @param bytes
     * @param bytes2
     * @return
     */
    private static byte[] DES_CBC_Encrypt(byte[] content, byte[] keyBytes) {

        try {
            DESKeySpec keySpec = new DESKeySpec(keyBytes);
            String algorithm =  "DES";//指定使什么样的算法
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
            SecretKey key = keyFactory.generateSecret(keySpec);

            String transformation = "DES/CBC/PKCS5Padding"; //用什么样的转型方式
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(keySpec.getKey()));

            byte[] result = cipher.doFinal(content);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    /**
     * 解密
     * @param encrypted
     * @param bytes
     * @return
     */
    private static byte[] DES_CBC_Decrypt(byte[] content, byte[] keyBytes) {

        try {
            DESKeySpec keySpec = new DESKeySpec(keyBytes);


            String algorithm = "DES";
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm );
            SecretKey key = keyFactory.generateSecret(keySpec);

            String transformation = "DES/CBC/PKCS5Padding";
            Cipher cipher = Cipher.getInstance(transformation );
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(keyBytes));
            byte[] result = cipher.doFinal(content);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 二进制转16进制
     * @param bytes
     * @return
     */
    private static String byteToHexString(byte[] bytes) {

        StringBuffer sb = new StringBuffer();
        String sTemp;

        for (int i = 0; i<bytes.length; i++) {

            sTemp = Integer.toHexString(0xFF & bytes[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());

        }


        return sb.toString();
    }

    /**
     *
     * 2、  秘钥的产生。
     这个有点恶心， 我研究了一下 KeyGenerator， KeyPairGenerator，KeyFactory，SecretKeyFactory这四个类，是有区别的。

     根据 Oracle 的 Standard Algorithm Name Documentation 提供的说明：

     KeyGenerator和SecretKeyFactory，都是javax.crypto包的，生成的key主要是提供给AES，DES，3DES，MD5，SHA1等 对称 和 单向 加密算法。

     KeyPairGenerator和KeyFactory，都是java.security包的，生成的key主要是提供给DSA，RSA， EC等 非对称加密算法。
     *
     */
    public static void printKey(byte[] keyBytes){

        try {
            //第一种 Factory
            DESKeySpec keySpec = new DESKeySpec(keyBytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key1 = keyFactory.generateSecret(keySpec);

            //第二种 Grenerator
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56, new SecureRandom(keyBytes));//key为8个字节，实际用了56位； 后面随机数用key作为种子seed生成
            SecretKey key2 = keyGenerator.generateKey();


            SecretKeySpec key3 = new SecretKeySpec(keyBytes, "DES");

            System.out.println("key1： "+byteToHexString(key1.getEncoded()));
            System.out.println("key2： "+byteToHexString(key2.getEncoded()));
            System.out.println("key3： "+byteToHexString(key3.getEncoded()));


        } catch (Exception e) {


        }

    }


}
