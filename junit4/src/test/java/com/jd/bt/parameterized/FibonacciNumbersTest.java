package com.jd.bt.parameterized;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * User: 吴海旭
 * Date: 2016-11-29
 * Time: 下午4:34
 * 通过Parameterized来计算斐波那契数列
 */
@RunWith(Parameterized.class)
public class FibonacciNumbersTest {

    public static Collection<Integer[]> data() {
        return Arrays.asList(new Integer[][]{
                {0, 0}, {1, 1}, {2, 1},
                {3, 2}, {4, 3}, {5, 5},
                {6, 8}});
    }

    private int value;
    private int expected;

    public FibonacciNumbersTest(int input, int expected) {
        value = input;
        this.expected = expected;
    }

    @Test
    public void fibonacciNumberCall() {
        System.out.println("expected " + expected + " fib(value) " + fib(value));
        Assert.assertEquals(expected, fib(value));
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}