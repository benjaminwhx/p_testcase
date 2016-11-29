package com.jd.bt.mock;

import mockit.Mocked;
import mockit.StrictExpectations;
import org.junit.Assert;
import org.junit.Test;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:41
 * Mock普通类的静态方法
 */
public class MockStaticMethodTest {

    @Test
    public void testStaticMethod(@Mocked MockVo mockVo) {
        new StrictExpectations() {{
            mockVo.isMan();
            result = true;
        }};

        Assert.assertTrue(MockVo.isMan());
    }

    @Test(expected = RuntimeException.class)
    public void testThrowException(@Mocked MockVo mockVo) {
//        PowerMockito.mockStatic(MockVo.class);

        System.out.println("prepare throw exception");

        new StrictExpectations() {{
            mockVo.isMan();
            result = new RuntimeException();
        }};

//        PowerMockito.doThrow(new RuntimeException()).when(MockVo.isMan());

        MockVo.isMan();
    }
}
