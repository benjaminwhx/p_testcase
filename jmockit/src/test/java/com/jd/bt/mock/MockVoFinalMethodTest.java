package com.jd.bt.mock;

import mockit.Mocked;
import mockit.StrictExpectations;
import org.junit.Assert;
import org.junit.Test;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:30
 * Mock普通对象的final方法
 */
public class MockVoFinalMethodTest {

    @Test
    public void testCallFinalMethod(@Mocked MockVo mockVo) {

        new StrictExpectations() {{
            mockVo.isAlive();

//            withArgThat(new )
            result = true;
        }};

        Assert.assertTrue(mockVo.isAlive());
    }
}
