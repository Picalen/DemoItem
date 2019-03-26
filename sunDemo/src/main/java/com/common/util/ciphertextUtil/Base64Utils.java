package com.common.util.ciphertextUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.HashMap;
import java.util.Map;

/**
 * base64加密解密工具类
 *
 * @author sunchao
 * @date 2019/1/8
 */


public class Base64Utils {
    private static Logger logger = LoggerFactory.getLogger(Base64Utils.class);
    private static final BASE64Encoder encoder = new BASE64Encoder();
    private static final BASE64Decoder decoder = new BASE64Decoder();

    /**
     * 加密字符串
     * @return String
     */
    public static String encodedStr(String arg){
        try {
            byte[] textByte = arg.getBytes("UTF-8");
            return  encoder.encodeBuffer(textByte);
        }catch (Exception e){
            logger.info("加密字符串----"+arg+"---失败，原因---"+e.getMessage());
            return null;
        }
    }

    /**
     * 解密字符串
     * @return String
     */
    public static String decodedStr(String arg){
        try {
            return  new String(decoder.decodeBuffer(arg), "UTF-8");
        }catch (Exception e){
            logger.info("解密字符串----"+arg+"---失败，原因---"+e.getMessage());
            return null;
        }
    }

    /**
     * 加密Map
     * @return Map<String,Object>
     */
    public static Map<String,Object> encodedMap(Map<String,Object> map){
        Map<String,Object> result = new HashMap<>();
        try {
            for (Map.Entry<String, Object> param : map.entrySet()) {
                byte[] textByte1 = String.valueOf(param.getKey()).getBytes("UTF-8");
                byte[] textByte2 = String.valueOf(param.getValue()).getBytes("UTF-8");
                result.put(encoder.encodeBuffer(textByte1),encoder.encodeBuffer(textByte2));
            }
            return  result;
        }catch (Exception e){
            logger.info("加密Map----"+map.toString()+"---失败，原因---"+e.getMessage());
            return null;
        }
    }

    /**
     * 解密Map
     * @return Map<String,Object>
     */
    public static Map<String,Object> decodedMap(Map<String,Object> map){
        Map<String,Object> result = new HashMap<>();
        try {
            for (Map.Entry<String, Object> param : map.entrySet()) {
                result.put(new String(decoder.decodeBuffer(String.valueOf(param.getKey())), "UTF-8"),new String(decoder.decodeBuffer(String.valueOf(param.getValue())), "UTF-8"));
            }
            return  result;
        }catch (Exception e){
            logger.info("解密Map----"+map.toString()+"---失败，原因---"+e.getMessage());
            return null;
        }
    }

    public static void main(String[] args){
//        System.out.println(encodedStr("123456"));
        String str ="eyJ0cmFuc19zZXJpYWwiOiJMQzIwMTkwMjIxMTAyMDE5MjQ4MyIsImVycm9yX25vIjoiMjAwIiwiZXJyb3JfaW5mbyI6IuWnlOaJmOaUr+S7mOaOiOadg+aIkOWKnyIsImJvcnJvd19jb25maXJtX3VybCI6Imh0dHA6Ly93d3cuZ3pqa3AycC5uZXQuY24vbW9iaWxlYnhiYW5rL21vYmlsZS9ib3Jyb3dJ"+
                "bmZvL2JvcnJvd0NvbmZpcm1HYXRlV2F5LmFjdGlvbiIsImFwcGx5X25vIjoiR0pBTjIwMTkwMjE1MTc0OTI5MzUwOCJ9";
        System.out.println(decodedStr(str));
    }
}
