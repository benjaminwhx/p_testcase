package com.jd.bt.mock;

import mockit.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:44
 * Mock私有方法
 */
public class MockVoPrivateMethodTest {

    @Test
    public void testPrivateMethod() throws Exception {

        MockVo mockInstance = new MockUp<MockVo>() {
            @Mock
            private boolean isPublic(Invocation invocation) {
                return true;
            }
        }.getMockInstance();

        Assert.assertTrue(mockInstance.callPrivateMethod());
    }
}
