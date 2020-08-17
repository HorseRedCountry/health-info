package com.wipe.healty.common.utils;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;


/**
 * 基础加密算法类?当前支持des,md5码?
 * @author huhaopeng
 *
 */
public class EncryptUtil {

    /**
     * MD5值计码?p>
     * MD5的算法在RFC1321 中定码?
     * 在RFC 1321中，给出了Test suite用来码?码码你的实现是否正确码?
     * MD5 ("") = d41d8cd98f00b204e9800998ecf8427e
     * MD5 ("a") = 0cc175b9c0f1b6a831c399e269772661
     * MD5 ("abc") = 900150983cd24fb0d6963f7d28e17f72
     * MD5 ("message digest") = f96b697d7cb7938d525a2f31aaf161d0
     * MD5 ("abcdefghijklmnopqrstuvwxyz") = c3fcd3d76192e4007dfb496cca67e13b
     *
     * @param str 源字符串
     * @return md5码?
     */
    public final static byte[] md5(String str) {
        try {
            byte[] res=str.getBytes("UTF-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5".toUpperCase());
            mdTemp.update(res);
            byte[] hash = mdTemp.digest();
            return hash;
        } catch (Exception e) {
            return null;
        }
    }

    //hex repr. of md5
    public final static String MD5Hex (String input) {
        String s = null;
        char hexDigits[] = { // 用来将字节转换成 16 进制表示的字码?
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
                'e', 'f' };
        try {
            MessageDigest md = MessageDigest
                    .getInstance("MD5");
            md.update(input.getBytes("utf-8"));
            byte tmp[] = md.digest();

            char str[] = new char[16 * 2];

            int k = 0;
            for (int i = 0; i < 16; i++) {

                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    // 加密后解码?
    public static String JM(byte[] inStr) {
        String newStr=new String(inStr);
        char[] a = newStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String k = new String(a);
        return k;
    }


    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String BASE64Encrypt(byte[] key) {
        String edata = null;
        try {
            edata = (new BASE64Encoder()).encodeBuffer(key).trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return edata;
    }


    /**
     * BASE64解密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] BASE64Decrypt(String data) {
        if(data==null)return null;
        byte[] edata = null;
        try {
            edata = (new BASE64Decoder()).decodeBuffer(data);
            return edata;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param key 24位密码?
     * @param str 源字符串
     * @return
     * @throws java.security.NoSuchAlgorithmException
     * @throws javax.crypto.NoSuchPaddingException
     * @throws java.security.InvalidKeyException
     * @throws java.io.UnsupportedEncodingException
     * @throws java.security.spec.InvalidKeySpecException
     * @throws javax.crypto.IllegalBlockSizeException
     * @throws javax.crypto.BadPaddingException
     */
    public static byte[] des3Encrypt(String key, String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {

        byte[] newkey=key.getBytes();

        SecureRandom sr = new SecureRandom();

        DESedeKeySpec dks = new DESedeKeySpec(newkey);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");

        SecretKey securekey = keyFactory.generateSecret(dks);

        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        byte[] bt = cipher.doFinal(str.getBytes("utf-8"));

        return bt;
    }

    public static String des3EncryptWithString(String key, String str) {
        try {
            return Base64.encodeBase64String(des3Encrypt(key, str));
        } catch (Exception e) {

        }
        return null;
    }

    public static String des3DecryptWithString(byte[] edata, String key) {
        try {
            byte[] bytes = Base64.decodeBase64(edata);
            return des3Decrypt(bytes, key);
        } catch (Exception e) {

        }
        return null;
    }


    /**
     * 解密
     *
     * @param edata
     * @param key
     * @return
     * @throws Exception
     */
    public static String des3Decrypt(byte[] edata, String key) {
        String data="";
        try {
            if(edata!=null){
                byte[] newkey=key.getBytes();
                DESedeKeySpec dks = new DESedeKeySpec(newkey);
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
                SecretKey securekey = keyFactory.generateSecret(dks);
                Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, securekey, new SecureRandom());
                byte[] bb=cipher.doFinal(edata);
                data = new String(bb,"UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    public final static String taoBaoMD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = s.getBytes("GBK");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
//        String s1 = "a4fa284e65f13c83c844c2d15b2f2679consume_type2item_title清江画廊A线 产品测试 表拍methodsendmobile18824624703num1num_iid41118197840order_id1355579045701125seller_nick湖北聚游旅游专营店send_type2sku_properties门票种类:标准票;门票类型:电子票sms_template验证码$code.您已成功订购湖北聚游旅游专营店提供的清江画廊A线 产品测试 表拍,有效期2015/10/27至2015/10/27,消费时请出示本短信以验证.如有疑问,请联系卖家.sub_method1sub_outer_iid24taobao_sid2195030302timestamp2015-10-27 12:06:34token50f6a5ab610c0059b33d36f7b653392ftotal_fee1.0type2valid_ends2015-10-27 23:59:59valid_start2015-10-27 00:00:00weeks[1,2,3,4,5,6,7]";
//        String s2 = "a4fa284e65f13c83c844c2d15b2f2679consume_type2item_title清江画廊A线 产品测试 表拍methodsendmobile18824624703num1num_iid41118197840order_id1355579045701125seller_nick湖北聚游旅游专营店send_type2sku_properties门票种类:标准票;门票类型:电子票sms_template验证码$code.您已成功订购湖北聚游旅游专营店提供的清江画廊A线 产品测试 表拍,有效期2015/10/27至2015/10/27,消费时请出示本短信以验证.如有疑问,请联系卖家.sub_method1sub_outer_iid24taobao_sid2195030302timestamp2015-10-27 12:06:34token50f6a5ab610c0059b33d36f7b653392ftotal_fee1.0type2valid_ends2015-10-27 23:59:59valid_start2015-10-27 00:00:00weeks[1,2,3,4,5,6,7]";
//        System.out.println(s1.equals(s2));
        System.out.println(EncryptUtil.MD5Hex("12345678"));
    }
}

