package com.jd.bt.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午4:53
 */
public class A {

    @Test
    public void a() {
        System.out.println("this is A.a");
    }

    @Category(SlowTests.class)
    @Test
    public void b() {
        System.out.println("this is A.b");
    }
}
