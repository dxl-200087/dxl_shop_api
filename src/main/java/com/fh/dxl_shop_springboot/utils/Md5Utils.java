package com.fh.dxl_shop_springboot.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
    public static String getMD5(String md5) {
        String strInfoDigest = "";
        MessageDigest ms;
        try {
            ms = MessageDigest.getInstance("MD5");
            ms.update(md5.getBytes());
            byte[] bs = ms.digest();
            strInfoDigest = byteToHex(bs);
        } catch (NoSuchAlgorithmException e) {

            System.out.println("\u975E\u6CD5\u6458\u8981\u7b97\u6CD5");
        }

        return strInfoDigest.toUpperCase();
    }

    public static String byteToHex(byte[] bs) {
        String s = "";
        String strTemp = "";
        for (int i = 0; i < bs.length; i++) {
            strTemp = Integer.toHexString(bs[i] & 255);
            if (strTemp.length() == 1) {
                s = (new StringBuilder(String.valueOf(s))).append("0").append(strTemp).toString();
            }
            else {
                s = (new StringBuilder(String.valueOf(s))).append(strTemp).toString();
            }
        }
        return s.toUpperCase();
    }
}
