package com.jd.bt.parameterized;

import com.jd.bt.AbstractTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * User: 吴海旭
 * Date: 2016-11-24
 * Time: 下午8:07
 * 在提供数据的方法上加上一个@Parameters注解，这个方法必须是静态static的，并且返回一个集合Iterable或Object[]。
 */
@RunWith(Parameterized.class)
public class ParametersTest extends AbstractTest {

    private final int expected;   // 期待的结果值
    private final int input1; // 参数1
    private final int input2; // 参数2
    private final Calculator calculator = new Calculator();

    public ParametersTest(final int expected, final int input1, final int input2) {
        // JUnit会使用准备的测试数据传给构造函数
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Parameterized.Parameters
    public static Collection prepareData() {
        Object[][] objects = {{3, 1, 2}, {-4, -1, -3}, {5, 2, 3}, {4, -4, 8}};
        return Arrays.asList(objects);
    }

    @Test
    public void testAdd() {
        assertEquals(this.expected, calculator.add(input1, input2));
    }
}
