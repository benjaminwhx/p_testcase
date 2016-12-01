package com.jd.bt.mock.suppress;

/**
 * User: 吴海旭
 * Date: 2016-12-01
 * Time: 上午10:44
 */
public class ExampleWithEvilParent extends EvilParent {

    private final String message;

    public ExampleWithEvilParent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
