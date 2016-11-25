package com.jd.bt.suit;

import com.jd.bt.asserts.EmployeeEmailAnnotationsTest;
import com.jd.bt.asserts.EmployeeEmailTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午0:34
 * 测试集合，可以把需要测试的类放在Suite里面
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({EmployeeEmailAnnotationsTest.class, EmployeeEmailTest.class})
public class SuiteTest {
}
