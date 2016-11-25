package com.jd.bt.category;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午4:57
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTests.class)
@Categories.ExcludeCategory(FastTests.class)
@Suite.SuiteClasses({A.class, B.class})
public class CategoryTest2 {
    // will run A.b, but not A.a or B.c
}
