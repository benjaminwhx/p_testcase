package com.jd.bt.parameterized;

import java.util.regex.Pattern;

/**
 * User: 吴海旭
 * Date: 2016-11-24
 * Time: 下午7:36
 */
public class EmailUtility {

    public static String createEmail(String firstPart, String secondPart) {
        return firstPart + "." + secondPart + "@testdomain.com";
    }

    public static boolean isValidEmail(String email) {
        String regex = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
        return Pattern.compile(regex).matcher(email).matches();
    }
}
