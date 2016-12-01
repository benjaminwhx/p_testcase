package com.jd.bt.mock;

import com.jd.bt.mock.parent.AbstractMockRunner;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * User: 吴海旭
 * Date: 2016-12-01
 * Time: 上午01:27
 *
 * 没有stubbing的方法的处理策略,有5种,这里讲典型的两种
 */
@PrepareForTest(Person.class)
public class UnStubbedTest extends AbstractMockRunner {

    /**
     * RETURNS_SMART_NULLS
     * 在创建mock对象时，有的方法我们没有进行stubbing，所以在调用的时候有时会返回Null
     * 这样在进行处理时就很可能抛出NullPointerException。
     * 如果通过RETURNS_SMART_NULLS参数来创建的mock对象在调用没有stubbed的方法时他将返回SmartNull。
     */
    @Test
    public void returnsSmartNullsTest() {
        Person mock = mock(Person.class, Mockito.RETURNS_SMART_NULLS);

        // 这里不会是Null
        // SmartNull returned by this unstubbed method call on a mock:
        // person.getObj();
        System.out.println(mock.getFather());
    }

    /**
     * RETURNS_DEEP_STUBS
     * 深层调用
     */
    @Test
    public void testDeepStubs() {
        Person mock = mock(Person.class, Mockito.RETURNS_DEEP_STUBS);

        when(mock.getFather().getName()).thenReturn("deep");

        // 输出deep
        System.out.println(mock.getFather().getName());
    }
}
