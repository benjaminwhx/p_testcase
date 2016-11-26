package com.jd.bt.mock;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:41
 * Mock普通类的静态方法
 */
@PrepareForTest(Mock.class)
public class MockStaticMethodTest extends AbstractMockRunner {

    @Test
    public void testStaticMethod() {
        PowerMockito.mockStatic(Mock.class);

        PowerMockito.when(Mock.isMan()).thenReturn(true);

        Assert.assertTrue(Mock.isMan());
    }

    @Test(expected = RuntimeException.class)
    public void testThrowException() {
        PowerMockito.mockStatic(Mock.class);

        System.out.println("prepare throw exception");

        PowerMockito.doThrow(new RuntimeException()).when(Mock.isMan());

        Mock.isMan();
    }
}
