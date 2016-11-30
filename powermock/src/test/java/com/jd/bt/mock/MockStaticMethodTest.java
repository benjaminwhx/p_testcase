package com.jd.bt.mock;

import org.junit.Assert;
import org.junit.Test;
import static org.powermock.api.mockito.PowerMockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:41
 * Mock普通类的静态方法
 */
@PrepareForTest(Mock.class)
public class MockStaticMethodTest extends AbstractMockRunner {

    /**
     * mockStatic方法
     */
    @Test
    public void testStaticMethod() {
        mockStatic(Mock.class);

        when(Mock.isMan()).thenReturn(true);

        Assert.assertTrue(Mock.isMan());
    }

    /**
     * 通过replace方法来替换静态方法
     */
    @Test
    public void testStaticMethod2() {
        replace(method(Mock.class, "isMan")).with((proxy, method, args) -> {
            return true;
        });

        Assert.assertTrue(Mock.isMan());
    }

    /**
     * replace方法
     * 通过相同方法格式的静态方法的来替换原来的方法
     * require1: static method
     * require2: require argument same
     */
    @Test
    public void testMethod3() {
        replace(method(Mock.class, "replaceMethod1")).with(method(Mock.class, "replaceMethod2"));

        Assert.assertEquals("replace2", Mock.replaceMethod1("benjamin"));
    }

    /**
     * spy方法
     */
    @Test
    public void testMethod4() {
        spy(Mock.class);

        when(Mock.isMan()).thenReturn(true);

        Assert.assertTrue(Mock.isMan());
    }

    @Test(expected = RuntimeException.class)
    public void testThrowException() {
        mockStatic(Mock.class);

        System.out.println("prepare throw exception");

        doThrow(new RuntimeException()).when(Mock.isMan());

        Mock.isMan();
    }
}
