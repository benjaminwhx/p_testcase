package com.jd.bt.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午9:49
 * ErrorCollector如果存在异常(ErrorCollector.errors.size() > 0),则测试不通过
 */
public class ErrorCollectorTest {

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void testErrorCollector() {
        System.out.println("test error collector");
        errorCollector.addError(new NullPointerException("这是我自定义的空指针异常"));
        errorCollector.addError(new IllegalArgumentException("这是我自定义的非法参数异常"));
    }
}
