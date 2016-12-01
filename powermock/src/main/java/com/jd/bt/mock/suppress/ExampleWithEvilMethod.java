package com.jd.bt.mock.suppress;

/**
 * User: 吴海旭
 * Date: 2016-12-01
 * Time: 上午10:44
 */
public class ExampleWithEvilMethod {

    private final String message;

    public ExampleWithEvilMethod(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageAndLibraryName() {
        return message + getLibraryName();
    }

    private String getLibraryName() {
        System.loadLibrary("evil.dll");
        return "evil.dll";
    }
}
