package com.jd.bt.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午4:54
 */
@Category({SlowTests.class, FastTests.class})
public class B {

    @Test
    public void c() {
        System.out.println("this is B.c");
    }
}
