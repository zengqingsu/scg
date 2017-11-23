package com.zqs.scg.common.encryption;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;

public class DESUtil
{
  private static final String DES = "DES";

  public static void main(String[] args)
    throws Exception
  {
     System.out.println("加密：" + encrypt("easymi", "12345678"));

     System.out.println("解密:" + decrypt(encrypt("easymi", "12345678"), "12345678"));
  }

  public static String encrypt(String data, String key)
    throws Exception
  {
     byte[] bt = encrypt(data.getBytes(), key.getBytes());
     String strs = new BASE64Encoder().encode(bt);
     return strs;
  }

  public static String decrypt(String data, String key)
    throws IOException, Exception
  {
     if (data == null)
       return null;

     BASE64Decoder decoder = new BASE64Decoder();
     byte[] buf = decoder.decodeBuffer(data);
     byte[] bt = decrypt(buf, key.getBytes());
     return new String(bt);
  }

  private static byte[] encrypt(byte[] data, byte[] key)
    throws Exception
  {
     SecureRandom sr = new SecureRandom();

     DESKeySpec dks = new DESKeySpec(key);

     SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
     SecretKey securekey = keyFactory.generateSecret(dks);

     Cipher cipher = Cipher.getInstance("DES");

     cipher.init(1, securekey, sr);

     return cipher.doFinal(data);
  }

  private static byte[] decrypt(byte[] data, byte[] key)
    throws Exception
  {
     SecureRandom sr = new SecureRandom();

     DESKeySpec dks = new DESKeySpec(key);

     SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
     SecretKey securekey = keyFactory.generateSecret(dks);

     Cipher cipher = Cipher.getInstance("DES");

     cipher.init(2, securekey, sr);

     return cipher.doFinal(data);
  }
}
