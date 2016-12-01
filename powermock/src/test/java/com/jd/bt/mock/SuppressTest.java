package com.jd.bt.mock;

import com.jd.bt.mock.parent.AbstractMockRunner;
import com.jd.bt.mock.suppress.EvilParent;
import com.jd.bt.mock.suppress.ExampleWithEvilMethod;
import com.jd.bt.mock.suppress.ExampleWithEvilParent;
import com.jd.bt.mock.suppress.ExampleWithEvilStaticInit;
import org.junit.Assert;
import org.junit.Test;
import static org.powermock.api.mockito.PowerMockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.reflect.Whitebox;

/**
 * User: 吴海旭
 * Date: 2016-12-01
 * Time: 上午10:42
 *
 * Suppress：有的时候需要跳特定的构造函数、方法、静态初始化代码才能保证单元测试
 * 正常执行。这时候suppress就派上用场了。
 */
@PrepareForTest({ExampleWithEvilParent.class, ExampleWithEvilMethod.class})
@SuppressStaticInitializationFor("com.jd.bt.mock.suppress.ExampleWithEvilStaticInit")
public class SuppressTest extends AbstractMockRunner {

    /**
     * 跳过父类过构造方法
     */
    @Test
    public void testSuppressParentConstructor() {
        suppress(constructor(EvilParent.class));
        final String message = "myMessage";
        ExampleWithEvilParent tested = new ExampleWithEvilParent(message);
        Assert.assertEquals(message, tested.getMessage());
    }

    /**
     * 跳过自身的构造方法
     */
    @Test
    public void testSuppressSelfConstructor() {
        ExampleWithEvilParent exampleWithEvilParent = Whitebox.newInstance(ExampleWithEvilParent.class);
        Assert.assertNotNull(exampleWithEvilParent);
    }

    /**
     * 跳过指定的方法
     */
    @Test
    public void testSuppressMethod() {
        suppress(method(ExampleWithEvilMethod.class, "getLibraryName"));
        final String message = "myMessage";
        ExampleWithEvilMethod tested = new ExampleWithEvilMethod(message);
        Assert.assertEquals(message + null, tested.getMessageAndLibraryName());
    }

    /**
     * 在类上加上注解 @SuppressStaticInitializationFor来跳过静态初始化代码段
     */
    @Test
    public void testSuppressStaticInit() {
        final String message = "myMessage";
        ExampleWithEvilStaticInit tested = new ExampleWithEvilStaticInit(message);
        Assert.assertEquals(message, tested.getMessage());
    }
}
