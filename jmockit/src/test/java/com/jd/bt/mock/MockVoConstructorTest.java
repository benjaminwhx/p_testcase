package com.jd.bt.mock;

import mockit.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:25
 * mock方法内部new出来的对象
 */
public class MockVoConstructorTest {

    @Tested
    MockVo mockVo;

    @Test
    public void testCallInternalInstance() throws Exception {

        new MockUp<File>() {
            // 当构造File对象并且参数传的是bbb时,始终返回mock出来的File对象
            @mockit.Mock
            public void $init(String name)
            {
                assertEquals("bbb", name);
                System.out.println("init,name:"+name);
            }

            // 当调用exists方法,始终返回true
            @mockit.Mock
            public boolean exists(){
                return true;
            }
        };

        boolean mockResult = mockVo.callInternalInstance("bbb");
        // always return true!
        Assert.assertTrue(mockResult);
    }
}
