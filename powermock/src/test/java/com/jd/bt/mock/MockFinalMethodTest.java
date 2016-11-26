package com.jd.bt.mock;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:30
 * Mock普通对象的final方法
 */
public class MockFinalMethodTest extends AbstractMockRunner {

    @Test
    @PrepareForTest(Mock.class)
    public void testCallFinalMethod() {
        Mock mock = PowerMockito.mock(Mock.class);

        PowerMockito.when(mock.isAlive()).thenReturn(true);

        Assert.assertTrue(mock.isAlive());
    }
}
