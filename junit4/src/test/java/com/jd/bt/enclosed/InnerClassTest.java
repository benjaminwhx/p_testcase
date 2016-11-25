package com.jd.bt.enclosed;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午4:30
 * 运行所有不是abstract的内部类里的测试方法
 */
@RunWith(Enclosed.class)
public class InnerClassTest {

    public static class MyInnserClass {
        @Test
        public void testInnerClassMethod() {
            System.out.println("this is inner class method");
        }
    }

    public static class MyInnserClass2 {
        @Test
        public void testInnerClassMethod2() {
            System.out.println("this is inner class method2");
        }
    }

    public static class MyInnserClass3 {
        @Test
        public void testInnerClassMethod3() {
            System.out.println("this is inner class method3");
        }
    }
}
