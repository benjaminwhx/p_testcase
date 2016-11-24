package com.jd.bt.parameterized;

/**
 * User: 吴海旭
 * Date: 2016-11-24
 * Time: 下午8:06
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) throws Exception {
        if (0 == b) {
            throw new Exception("除数不能为0");
        }
        return a / b;
    }
}
