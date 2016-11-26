package com.jd.bt.mock;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.File;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:25
 * mock方法内部new出来的对象
 */
public class MockConstructorTest extends AbstractMockRunner {

    @Test
    @PrepareForTest(Mock.class)
    public void testCallInternalInstance() throws Exception {
        // 构造一个mock出来的File对象
        File mockFile = PowerMockito.mock(File.class);

        // 当调用exists方法,始终返回true
        PowerMockito.when(mockFile.exists()).thenReturn(true);

        // 当构造File对象并且参数传的是bbb时,始终返回mock出来的File对象
        PowerMockito.whenNew(File.class).withArguments("bbb").thenReturn(mockFile);

        Mock mock = new Mock();
        boolean mockResult = mock.callInternalInstance("bbb");
        // always return true!
        Assert.assertTrue(mockResult);
    }
}
