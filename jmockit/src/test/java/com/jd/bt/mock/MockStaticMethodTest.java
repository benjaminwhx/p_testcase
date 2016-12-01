package com.jd.bt.mock;

import mockit.*;
import org.assertj.core.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

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

    /**
     * Mock某个类方法
     * Expectations块里声明的mock方法，是一定要被执行的，如果没有被执行，会认为整个测试case不通过；
     * NonStrictExpectations就没有这个限制
     */
    @Test
    public void testStaticMethod2() {
        // 强制执行不调用的方法
//        new Expectations(MockVo.class) {{
//            MockVo.isMan();
//            result = true;
//            MockVo.getCurrentDateByFormat(2);
//            result = "123";
//        }};

        // 强制执行不调用的方法
//        new StrictExpectations(MockVo.class) {{
//            MockVo.isMan();
//            result = true;
//            MockVo.getCurrentDateByFormat(2);
//            result = "123";
//        }};

        // 不强制执行不调用的方法
        new NonStrictExpectations(MockVo.class) {{
            MockVo.isMan();
            result = true;
            MockVo.getCurrentDateByFormat(2);
            result = "123";
        }};

        Assert.assertTrue(MockVo.isMan());

        new Verifications() {{
            MockVo.isMan();
            times = 1;
        }};
    }

    /**
     * 某个方法根据不同参数返回不同值
     */
    @Test
    public void testStaticMethod3() {
        new Expectations(MockVo.class) {{
            MockVo.getCurrentDateByFormat(anyInt);
            result = new Delegate<MockVo>() {
                public String getCurrentDateByFormat(int type) {
                    if (type == 1) {
                        return "2010/07/22 15:52:55";
                    } else {
                        return "2010-07-22 15:52:55";
                    }
                }
            };
        }};
        Assert.assertEquals("2010-07-22 15:52:55", MockVo.getCurrentDateByFormat(2));
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
