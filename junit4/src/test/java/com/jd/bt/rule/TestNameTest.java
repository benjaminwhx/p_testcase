package com.jd.bt.rule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午5:49
 * TestName会在测试方法执行前得到该方法的方法名。是TestWatcher的一个扩展
 */
public class TestNameTest {

    @Rule
    public TestName name = new TestName();

    @Test
    public void testTestName() {
        System.out.println("test TestName");
        Assert.assertEquals("testTestName", name.getMethodName());
    }
}
