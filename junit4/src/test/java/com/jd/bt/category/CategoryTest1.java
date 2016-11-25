package com.jd.bt.category;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午4:55
 * 利用category来对进行测试的类进行分类测试。相当于是对suite的一个细化吧。
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTests.class)
@Suite.SuiteClasses({A.class, B.class})
public class CategoryTest1 {
    // will run A.b and B.c, but not A.a
}
