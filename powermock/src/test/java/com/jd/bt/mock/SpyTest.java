package com.jd.bt.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * User: 吴海旭
 * Date: 2016-12-01
 * Time: 上午00:46
 *
 * Mock对象只能调用stubbed方法，调用不了它真实的方法。但Mockito可以监视一个真实的对象，
 * 这时对它进行方法调用时它将调用真实的方法，同时也可以stubbing这个对象的方法让它返回我们的期望值。
 * 另外不论是否是真实的方法调用都可以进行verify验证。和创建mock对象一样，对于final类、匿名类和Java的基本类型是无法进行spy的。
 *
 * 通俗来说, Spy() 是构造一个和原类一样的类出来,方法还是调用原来的。
 */
@RunWith(MockitoJUnitRunner.class)
public class SpyTest {

    @Test
    public void testSpy() {
        List list = new LinkedList();
        List spy = spy(list);   // 这里不能写List.class

        // stub size方法
        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        // one
        System.out.println(spy.get(0));
        // 100
        System.out.println(spy.size());

        // verify add "one" 调用1次
        verify(spy).add("one");
        // verify add "two" 调用2次
        verify(spy).add("two");
    }
}
