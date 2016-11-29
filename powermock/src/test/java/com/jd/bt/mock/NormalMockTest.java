package com.jd.bt.mock;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.File;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:17
 * 普通mock:mock参数传递对象
 * 不需要加@Runwith和@PrepareForTest
 */
public class NormalMockTest {

    @Test
    public void testCallArguementInstance() {
        File mockFile = PowerMockito.mock(File.class);

        // 只要调用mock出来的File里的exists方法,都返回true
        PowerMockito.when(mockFile.exists()).thenReturn(true);

        Mock mock = new Mock();
        boolean mockResult = mock.callArguementInstance(mockFile);
        Assert.assertTrue(mockResult);
    }

    /**
     * 测试没有返回值的方法
     */
    @Test
    public void testNoReturnMethod() throws Exception {
        Mock mock = PowerMockito.mock(Mock.class);
        PowerMockito.doNothing().when(mock, "doNothing");
    }
}
