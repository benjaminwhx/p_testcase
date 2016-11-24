package com.jd.bt.asserts;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * User: 吴海旭
 * Date: 2016-11-24
 * Time: 下午5:55
 */
public class EmployeeEmail {

    public final Map<String, String> emailMap = new HashMap<>();

    public void addEmployeeEmail(String id, String email) {
        if (isValidEmail(email)) {
            emailMap.put(id, email);
        }
    }

    public String getEmailId(Object o) {
        if (!(o instanceof String)) {
            throw new IllegalArgumentException("Object not type of String");
        }
        return emailMap.get(o);
    }

    public boolean isValidEmail(String email) {
        String regex = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
        return Pattern.compile(regex).matcher(email).matches();
    }
}
