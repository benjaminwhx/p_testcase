package com.jd.bt.mock.suppress;

/**
 * User: 吴海旭
 * Date: 2016-12-01
 * Time: 上午10:44
 */
public class ExampleWithEvilStaticInit {

    static {
        System.loadLibrary("evil.dll");
    }

    private final String message;

    public ExampleWithEvilStaticInit(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
