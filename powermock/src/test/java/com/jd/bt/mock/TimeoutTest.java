package com.jd.bt.mock;

import com.jd.bt.mock.parent.AbstractMockRunner;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

/**
 * User: 吴海旭
 * Date: 2016-11-30
 * Time: 下午11:14
 */
@PrepareForTest(Mock.class)
public class TimeoutTest extends AbstractMockRunner {

    @org.mockito.Mock
    private Mock mock;

    private final Runnable asyncOperation = () -> {
        try {
            Thread.sleep(1000);
            mock.getAge();
        } catch (InterruptedException e) {
        }
    };

    @Test
    public void testMockitoConcurrentTimeoutSucceeds() {
        new Thread(asyncOperation).start();
        // 从verify起得2000ms内有没有执行getAge方法,执行为true,不执行为false
        Mockito.verify(mock, Mockito.timeout(2000)).getAge();
    }

    @Test
    public void testMockitoConcurrentTimeoutFails() {
        new Thread(asyncOperation).start();
        Mockito.verify(mock, Mockito.timeout(200)).getAge();
    }
}
