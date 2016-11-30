package com.jd.bt.mock;

import org.junit.Assert;
import org.junit.Test;
import static org.powermock.api.mockito.PowerMockito.*;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

/**
 * User: 吴海旭
 * Date: 2016-12-01
 * Time: 上午00:16
 *
 * 在某些场景中,不光要对方法的返回值和调用进行验证,同时需要验证一系列交互后所传入方法的参数。
 * 那么我们可以用参数捕获器来捕获传入方法的参数进行验证，看它是否符合我们的要求。
 * ArgumentCaptor: 通过ArgumentCaptor对象的forClass(Class<T> clazz)方法来构建ArgumentCaptor对象。
 * 然后便可在验证时对方法的参数进行捕获，最后验证捕获的参数值。如果方法有多个参数都要捕获验证，那就需要创建多个ArgumentCaptor对象处理。
 *
 * argument.capture() 捕获方法参数
 * argument.getValue() 获取方法参数值，如果方法进行了多次调用，它将返回最后一个参数值
 * argument.getAllValues() 方法进行多次调用后，返回多个参数值
 */
@RunWith(MockitoJUnitRunner.class)
public class ArgumentCaptorTest {

    @Test
    public void testArgumentCaptor() {
        List mock = mock(List.class);
        List mock2 = mock(List.class);
        mock.add("John");
        mock2.add("Brian");
        mock2.add("Jim");

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        Mockito.verify(mock).add(argumentCaptor.capture());
        Assert.assertEquals("John", argumentCaptor.getValue());

        Mockito.verify(mock2, Mockito.times(2)).add(argumentCaptor.capture());

        Assert.assertEquals("Jim", argumentCaptor.getValue());
        Assert.assertArrayEquals(new Object[]{"John", "Brian", "Jim"}, argumentCaptor.getAllValues().toArray());
    }
}
