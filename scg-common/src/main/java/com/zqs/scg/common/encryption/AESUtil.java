package com.zqs.scg.common.encryption;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

public class AESUtil
{
  public static void main(String[] args)
    throws Exception
  {
     System.out.println(encrypt("xxxxxxxxxx", "{\"A\":\"123\",\"B\":\"123中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊中户仍爱对方水电费打发打发打发啊\"}"));
     System.out.println(decrypt("xxxxxxxxxx", "A85D8F462AB56C3715DF96ECA1008790DA71907718A5C3C5BBEAF00C8943F2A034C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A0411F84FC4F678E89CB30D2839FDF0AC8A734C8930786215853B571054FBF3E463BD880FE9C6DF6FD02BD0BFD9CC142A041690C35F0C044FD52A7756C15BCBDBFBE"));
  }

  public static String encrypt(String keyStr, String toEncryptString) throws Exception {
     Security.addProvider(new BouncyCastleProvider());
     byte[] input = toEncryptString.getBytes("UTF-8");
     byte[] keyBytes = getKeyBytes(keyStr);

     SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
     Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
     cipher.init(1, key);

     byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
     int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
     ctLength += cipher.doFinal(cipherText, ctLength);

     String c = byte2HexStr(cipherText);

     return c;
  }

  public static byte[] encrypt(String keyStr, byte[] data) throws Exception
  {
     Security.addProvider(new BouncyCastleProvider());
    byte[] keyBytes = getKeyBytes(keyStr);

     SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
     Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
     cipher.init(1, key);

     byte[] cipherText = new byte[cipher.getOutputSize(data.length)];
     int ctLength = cipher.update(data, 0, data.length, cipherText, 0);
     ctLength += cipher.doFinal(cipherText, ctLength);
     return cipherText;
  }

  public static String decrypt(String keyStr, String toDecryptString) throws Exception
  {
     Security.addProvider(new BouncyCastleProvider());
     byte[] toDecrypt = hexStr2Bytes(toDecryptString);
     byte[] keyBytes = getKeyBytes(keyStr);
     SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
     Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
     cipher.init(2, key);

     byte[] cipherText = new byte[cipher.getOutputSize(toDecrypt.length)];
     int ctLength = cipher.update(toDecrypt, 0, toDecrypt.length, cipherText, 0);
     ctLength += cipher.doFinal(cipherText, ctLength);

     String c = new String(cipherText, "UTF-8");

     return c;
  }

  public static byte[] decrypt(String keyStr, byte[] data) throws Exception
  {
     Security.addProvider(new BouncyCastleProvider());
     byte[] keyBytes = getKeyBytes(keyStr);
     SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
     Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
     cipher.init(2, key);

     byte[] cipherText = new byte[cipher.getOutputSize(data.length)];
     int ctLength = cipher.update(data, 0, data.length, cipherText, 0);
     ctLength += cipher.doFinal(cipherText, ctLength);
     return cipherText;
  }

  public static String byte2HexStr(byte[] b)
  {
     String hs = "";
     String stmp = "";
     for (int n = 0; n < b.length; n++) {
       stmp = Integer.toHexString(b[n] & 0xFF);
       if (stmp.length() == 1)
         hs = hs + "0" + stmp;
      else {
         hs = hs + stmp;
      }
    }
     return hs.toUpperCase();
  }

  private static byte[] getKeyBytes(String keyStr)
    throws Exception
  {
     byte[] tmp = keyStr.getBytes("utf-8");

     byte[] arrB = new byte[16];

     for (int i = 0; (i < tmp.length) && (i < arrB.length); i++)
    {
       arrB[i] = tmp[i];
    }
     return arrB;
  }

  private static byte uniteBytes(String src0, String src1) {
     byte b0 = Byte.decode("0x" + src0).byteValue();
     b0 = (byte)(b0 << 4);
     byte b1 = Byte.decode("0x" + src1).byteValue();
     byte ret = (byte)(b0 | b1);
     return ret;
  }

  public static byte[] hexStr2Bytes(String src)
  {
     int m = 0; int n = 0;
     int l = src.length() / 2;
     byte[] ret = new byte[l];
     for (int i = 0; i < l; i++) {
       m = i * 2 + 1;
       n = m + 1;
       ret[i] = uniteBytes(src.substring(i * 2, m), src.substring(m, n));
    }
     return ret;
  }
}

