package com.jd.bt.theories;

import com.jd.bt.parameterized.EmailUtility;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import static org.junit.Assume.*;

/**
 * User: 吴海旭
 * Date: 2016-11-24
 * Time: 下午7:40
 * Theories：原理或者推测
 * @DataPoints 提供一组数据
 * @DataPoint 提供单个数据
 * Theories会尝试所有类型匹配的参数作为测试方法的入参
 */
@RunWith(Theories.class)
public class TheoriesTest {

    @DataPoints
    public static String[] names() {
        return new String[]{"first", "second", "abc", "123", null};
    }

    @DataPoints
    public static String[] names2 = {"wu", "han"};

    @DataPoint
    public static String name = "mary";

    @DataPoint
    public static String name2() {
        return "benjamin";
    }

    @Theory(nullsAccepted = false)
    public void testCreateEmail(String firstPart, String secondPart) {
        System.out.println(String.format("Test with %s and %s", firstPart, secondPart));
        assumeNotNull(firstPart, secondPart);
        Assert.assertTrue(EmailUtility.isValidEmail(EmailUtility.createEmail(firstPart, secondPart)));
    }
}
