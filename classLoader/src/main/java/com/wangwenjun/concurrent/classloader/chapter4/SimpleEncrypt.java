package com.wangwenjun.concurrent.classloader.chapter4;

/***************************************
 * @author:Alex Wang
 * @Date:2017/4/4 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class SimpleEncrypt {

    private static final String plain = "Hello ClassLoader";

    private static final byte ENCRYPT_FACTOR = (byte) 0xff;


    public static void main(String[] args) {
        byte[] bytes = plain.getBytes();
        byte[] encrypt = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            encrypt[i] = (byte) (bytes[i] ^ ENCRYPT_FACTOR);
        }
        System.out.println(new String(encrypt));

        byte[] decrypt = new byte[encrypt.length];
        for (int i = 0; i < encrypt.length; i++) {
            decrypt[i] = (byte) (encrypt[i] ^ ENCRYPT_FACTOR);
        }
        System.out.println(new String(decrypt));
    }
}