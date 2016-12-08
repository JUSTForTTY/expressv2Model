/*
 * 
 */
package com.hundsun.jresplus.quickstart.utils;

import java.security.MessageDigest;

/**
 * 
 * @author chengy
 *
 */
public class MD5utils {
    /**
     * 
     * @param sourceString
     * @return
     */
    public static String MD5Encode(String sourceString) {
        String resultString = "";
        try {
            resultString = new String(sourceString);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byte2hexString(md.digest(resultString.getBytes()));
        } catch (Exception ex) {
        }
        return resultString;
    }

    private static final String byte2hexString(byte[] bytes) {
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buf.toString();
    }

}
