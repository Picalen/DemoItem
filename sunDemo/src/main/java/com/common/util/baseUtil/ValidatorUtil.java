package com.common.util.baseUtil;

import java.util.regex.Pattern;

/**
 * @author sc
 * @date 2018/12/3
 */
public class ValidatorUtil {
    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,20}$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * 正则表达式：验证身份证
     */
/*    public static final String REGEX_ID_CARD = "[1-9]{2}[0-9]{4}(19|20)[0-9]{2}"
            + "((0[1-9]{1})|(1[1-2]{1}))((0[1-9]{1})|([1-2]{1}[0-9]{1}|(3[0-1]{1})))"
            + "[0-9]{3}[0-9X]{1}";*/
    public static final String REGEX_ID_CARD = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[A-Z])$";

    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     * 正则表达式：验证组织机构代码
     */
    public static final String REGEX_CREDIT_NO = "^[0-9A-HJ-NPQRTUWXY]{2}\\d{6}[0-9A-HJ-NPQRTUWXY]{10}$";

    /**
     * 正则表达式：VIN 17位大写字母+数字
     */
    public static final String VIN = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{17}$";

    /**
     * 校验用户名
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 校验密码
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 校验手机号
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 校验URL
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * 校验IP地址
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }

    /**
     * 校验组织机构代码
     * @param creditNo
     * @return
     */
    public static boolean isCreditNo(String creditNo) {
        return Pattern.matches(REGEX_CREDIT_NO, creditNo);
    }

    /**
     * 校验车架号
     * @param vin
     * @return
     */
    public static boolean isVINNo(String vin) {
        return Pattern.matches(VIN, vin);
    }

    public static void main(String[] args) {
        System.out.println(ValidatorUtil.isIDCard("130723199210165210"));
        System.out.println(ValidatorUtil.isIDCard("330482199503151518"));
        System.out.println(ValidatorUtil.isIDCard("420984199508192732"));
        System.out.println(ValidatorUtil.isIDCard("429004199409052934"));
        System.out.println(ValidatorUtil.isIDCard("330326199106190736"));
        System.out.println(ValidatorUtil.isIDCard("330724199208266214"));
        System.out.println(ValidatorUtil.isIDCard("33072419840314241X"));
        System.out.println(ValidatorUtil.isIDCard("640323197711303879"));
        System.out.println(ValidatorUtil.isIDCard("230713199208081342"));
        System.out.println(ValidatorUtil.isIDCard("513338198803048134"));
        System.out.println(ValidatorUtil.isIDCard("341023197610114642"));
        System.out.println(ValidatorUtil.isIDCard("441721198509297396"));
        System.out.println(ValidatorUtil.isIDCard("610126198503229763"));
        System.out.println(ValidatorUtil.isIDCard("34180119800709902X"));
        //System.out.println(ValidatorUtil.isMobile("15623979711"));
        //System.out.println(ValidatorUtil.isCreditNo("91330108MA27XKAI0K"));
    }

}
