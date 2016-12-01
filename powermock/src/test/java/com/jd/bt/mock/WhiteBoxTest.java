package com.jd.bt.mock;

import com.jd.bt.mock.parent.AbstractMockRunner;
import org.junit.Assert;
import org.junit.Test;
import static org.powermock.api.mockito.PowerMockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

/**
 * User: 吴海旭
 * Date: 2016-12-01
 * Time: 上午00:29
 *
 * PowerMock内部就是使用WhiteBox来操作的，允许我们直接操作类的
 * 私有成员、私有方法，甚至通过私有构造函数创建实例
 */
@PrepareForTest(Person.class)
public class WhiteBoxTest extends AbstractMockRunner {

    @Test
    public void testWithWhiteBox() throws Exception {
        Person person = new Person();
        // 设置内部成员值
        Whitebox.setInternalState(person, "age", 23);
        // 获取内部成员值
        int age = Whitebox.getInternalState(person, "age");
        Assert.assertEquals(23, age);

        Person personMock = mock(Person.class);
        Whitebox.setInternalState(personMock, "age", 22);
        Whitebox.setInternalState(personMock, "name", "wuhaixu");

        // 从personMock复制相同的属性到person中
        Whitebox.setInternalStateFromContext(person, personMock);
        Assert.assertEquals("wuhaixu", person.getName());
        Assert.assertEquals(22, person.getAge());

        // 调用构造方法
        Person consPerson = Whitebox.invokeConstructor(Person.class);
        Assert.assertNotNull(consPerson);

        // 调用方法
        String result = Whitebox.invokeMethod(person, "hello");
        Assert.assertEquals("world", result);

        // 跳过构造函数直接实例化对象
        Person newInstancePerson = Whitebox.newInstance(Person.class);
        Assert.assertNotNull(newInstancePerson);
    }
}
