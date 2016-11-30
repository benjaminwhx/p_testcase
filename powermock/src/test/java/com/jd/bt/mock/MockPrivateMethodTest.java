package com.jd.bt.mock;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberMatcher;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:44
 * Mock私有方法
 */
@PrepareForTest(Mock.class)
public class MockPrivateMethodTest extends AbstractMockRunner {

    @Test
    public void testPrivateMethod() throws Exception {
        Mock mock = PowerMockito.mock(Mock.class);

        PowerMockito.when(mock, "isPublic").thenReturn(true);
        // 如果调用callPrivateMethod时,去调用原方法
        PowerMockito.when(mock.callPrivateMethod()).thenCallRealMethod();

        Assert.assertTrue(mock.callPrivateMethod());
    }

}
