package com.jd.bt.mock;

import com.jd.bt.mock.parent.AbstractMockRunner;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static org.powermock.api.mockito.PowerMockito.*;

/**
 * User: 吴海旭
 * Date: 2016-11-30
 * Time: 下午4:42
 */
@PrepareForTest(Mock.class)
public class MockPublicMethodTest extends AbstractMockRunner {

    /**
     * 使用mock when then的通用方式处理
     */
    @Test
    public void testMethod1() {
        Mock mock = mock(Mock.class);
        when(mock.getDesc("benjamin")).thenReturn("My name is Benjamin");
        Assert.assertEquals("My name is Benjamin", mock.getDesc("benjamin"));
    }

    @Test
    public void testSendEmail() {
        Mock mock = mock(Mock.class);
        when(mock.sendEmail("aa", "bb")).thenCallRealMethod();
        Assert.assertTrue(mock.sendEmail("aa", "bb"));
    }

    /**
     * stub方法
     */
    @Test
    public void testMethod2() {
        stub(method(Mock.class, "getDesc")).toReturn("test");
        Mock mock = new Mock();
        Assert.assertEquals("test", mock.getDesc("benjamin"));
    }

    /**
     * replace方法
     * 通过自定义InvocationHandler来处理方法拦截
     */
    @Test
    public void testMethod3() {
        replace(method(Mock.class, "getDesc")).with(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (args[0].equals("benjamin")) {
                    return "My name is Benjamin";
                } else {
                    return method.invoke(proxy, args);
                }
            }
        });
        Mock mock = new Mock();
        Assert.assertEquals("My name is Benjamin", mock.getDesc("benjamin"));
    }

    /**
     * 使用spy来保留类的大多数真实内容
     * spy的意思是你可以修改某个真实对象的某些方法的行为特征，而不改变他的基本行为特征
     * 这种策略和AOP有点类似。
     */
    @Test
    public void testMethod4() throws Exception {
        Mock mock = new Mock();
        Mock spy = spy(mock);
        when(spy.getDesc("benjamin")).thenReturn("test");

        Assert.assertEquals("test", spy.getDesc("benjamin"));
    }

}
