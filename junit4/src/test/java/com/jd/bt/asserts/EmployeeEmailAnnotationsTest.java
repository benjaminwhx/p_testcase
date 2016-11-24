package com.jd.bt.asserts;

import com.jd.bt.AbstractTest;
import org.junit.Ignore;
import org.junit.Test;

/**
 * User: 吴海旭
 * Date: 2016-11-24
 * Time: 下午6:53
 */
public class EmployeeEmailAnnotationsTest extends AbstractTest {

    private EmployeeEmail employeeEmail;

    @Override
    public void setUp() {
        employeeEmail = new EmployeeEmail();
        employeeEmail.addEmployeeEmail("emp01", "abc@qq.com");
        employeeEmail.addEmployeeEmail("emp02", "def@qq.com");
    }

    @Override
    public void destroy() {
        employeeEmail.emailMap.clear();
    }

    /**
     * 设置超时时间为100ms
     * 超时访问throws java.lang.InterruptedException: sleep interrupted
     */
    @Test(timeout = 100)
    public void testDataAccessTimeout() {
        employeeEmail.getEmailId("emp2");
    }

    /**
     * 当运行整个测试类的时候，会忽略测试，只会输出 @Ignore的value值
     */
    @Test
    @Ignore("Test Code not ready")
    public void testWithIgnore() {
        /* */
    }

    /**
     * expected: 预期抛出的异常类，如果没抛出异常会throws java.lang.AssertionError: Expected exception: java.lang.IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testForException() {
        // expected argue is String, but input 1
        employeeEmail.getEmailId(1);
    }
}
