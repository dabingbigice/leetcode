package com.note;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048); // 密钥长度2048位
        KeyPair keyPair = keyPairGen.generateKeyPair();

        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        // 1. 打印算法
        System.out.println("Public Key Algorithm: " + publicKey.getAlgorithm());
        System.out.println("Private Key Algorithm: " + privateKey.getAlgorithm());
        System.out.println("------------------------");

        // 2. 打印Base64编码的公钥（标准形式）
        String base64PublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String base64PrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        System.out.println("Public Key (Base64 X.509 Format):");
        System.out.println("-----BEGIN PUBLIC KEY-----");
        // 每64个字符换行，更美观
        for (int i = 0; i < base64PublicKey.length(); i += 64) {
            System.out.println(base64PublicKey.substring(i, Math.min(i + 64, base64PublicKey.length())));
        }
        System.out.println("-----END PUBLIC KEY-----");
        System.out.println("------------------------");
        System.out.println("base64PrivateKey:"+base64PrivateKey);
        // 3. 打印内部参数
        System.out.println("Public Key Modulus (N, hex):\n" + publicKey.getModulus().toString(16));
        System.out.println("Public Exponent (E): " + publicKey.getPublicExponent());
    }
}
