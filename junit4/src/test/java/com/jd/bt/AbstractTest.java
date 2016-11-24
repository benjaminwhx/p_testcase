package com.jd.bt;

import org.junit.*;

/**
 * User: 吴海旭
 * Date: 2016-11-24
 * Time: 下午6:17
 * 抽象测试类，继承Assert，便于在继承类中使用assert相关断言。
 */
public abstract class AbstractTest extends Assert {

    @BeforeClass
    public static void onTimeSetUp() {
        System.out.println("JUnit @BeforeClass onTimeSetUp");
    }

    @Before
    public void setUp() {
        System.out.println("JUnit @Before setup");
    }

    @After
    public void destroy() {
        System.out.println("JUnit @After destroy");
    }

    @AfterClass
    public static void onTimeDestroy() {
        System.out.println("JUnit @AfterClass destroy");
    }
}
