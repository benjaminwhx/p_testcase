package com.jd.bt.mock;

import org.junit.Assert;
import org.junit.Test;
import static org.powermock.api.mockito.PowerMockito.*;

import org.mockito.Mockito;
import org.mockito.verification.Timeout;
import org.powermock.core.classloader.annotations.PrepareForTest;

/**
 * User: 吴海旭
 * Date: 2016-11-30
 * Time: 下午7:58
 */
@PrepareForTest(Mock.class)
public class VerifyTest extends AbstractMockRunner{

    @Test
    public void testVerify() throws Exception {
        Mock mock = mock(Mock.class);
        when(mock, "getAge").thenAnswer(a -> {
            return 10;
        });
        Assert.assertEquals(10, mock.getAge());

        // 验证getAge方法是否被调用
        Mockito.verify(mock).getAge();

        // 验证getAge方法是否被调用1次
        Mockito.verify(mock, Mockito.times(1)).getAge();

        // 验证getDesc方法是否没有被调用
        Mockito.verify(mock, Mockito.never()).getDesc("");

        // 至少调用1次
        Mockito.verify(mock, Mockito.atLeast(1)).getAge();
        Mockito.verify(mock, Mockito.atLeastOnce()).getAge(); // 同上

        // 至多调用1次
        Mockito.verify(mock, Mockito.atMost(1)).getAge();

        // 可以传入多个参数mock对象作为参数，用来验证传入的这些mock对象是否存在没有验证过的方法
        Mockito.verifyNoMoreInteractions(mock);
        Mockito.verifyZeroInteractions(mock);   // 同上

        // 验证100ms内执行完毕
        Mockito.verify(mock, Mockito.timeout(100)).getAge();
    }
}
