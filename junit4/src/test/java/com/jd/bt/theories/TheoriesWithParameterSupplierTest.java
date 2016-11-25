package com.jd.bt.theories;

import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午0:15
 */
@RunWith(Theories.class)
public class TheoriesWithParameterSupplierTest {

    @Theory
    public void testNameAndAge(@ParametersSuppliedBy(NameSupplier.class) String name,
                               @ParametersSuppliedBy(AgeSupplier.class) int age) {
        System.out.println(String.format("%s's age is %s", name, age));
    }
}
