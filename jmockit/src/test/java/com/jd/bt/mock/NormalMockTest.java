package com.jd.bt.mock;

import mockit.Mocked;
import mockit.StrictExpectations;
import org.junit.Assert;
import org.junit.Test;

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
    public void testCallArguementInstance(@Mocked File mockFile) {
//        File mockFile = PowerMockito.mockVo(File.class);

        new StrictExpectations() {{
            // 只要调用mock出来的File里的exists方法,都返回true
            mockFile.exists();
            result = true;
        }};


        MockVo mockVo = new MockVo();
        boolean mockResult = mockVo.callArguementInstance(mockFile);
        Assert.assertTrue(mockResult);
    }
}
