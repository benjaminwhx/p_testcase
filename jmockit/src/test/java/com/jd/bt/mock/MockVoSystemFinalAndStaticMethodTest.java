package com.jd.bt.mock;

import mockit.Mocked;
import mockit.StrictExpectations;
import org.junit.Assert;
import org.junit.Test;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:51
 */
public class MockVoSystemFinalAndStaticMethodTest {

    @Test
    public void testCallSystemFinalAndStaticMethod(@Mocked String mockStr) {
        // mockVo system final

        new StrictExpectations() {{
            System.out.println(mockStr);
            mockStr.isEmpty();
            result = true;

        }};

        MockVo mockVo = new MockVo();
        Assert.assertTrue(mockVo.callSystemFinalMethod(mockStr));

    }

    @Test
    public void testName() throws Exception {

        // mockVo system static
        new StrictExpectations(System.class) {{
            System.getProperty("aaa");
            result = "bbb";
            times = 1;// verify 调用了1次

        }};
        MockVo mockVo = new MockVo();
        Assert.assertEquals("bbb", mockVo.callSystemStaticMethod("aaa"));

//        System.getProperty("aaa");

    }
}
