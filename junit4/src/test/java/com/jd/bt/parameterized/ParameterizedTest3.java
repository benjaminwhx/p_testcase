package com.jd.bt.parameterized;

import com.jd.bt.AbstractTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

/**
 * User: 吴海旭
 * Date: 2016-11-24
 * Time: 下午7:40
 */
@RunWith(Parameterized.class)
public class ParameterizedTest3 extends AbstractTest {

    @Parameterized.Parameter
    public String email;
    @Parameterized.Parameter(1)
    public boolean expected;

    // name属性我暂时没发现有什么用，如果有用可以给我提issue
    @Parameterized.Parameters(name = "{index}: isValid({0})={1}")
    public static Iterable<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                        {"mary@testdomain.com", true},
                        {"mary.smith@testdomain.com", true},
                        {"mary_smith123@testdomain.com", true},
                        {"mary@testdomaindotcom", false},
                        {"mary-smith@testdomain", false},
                        {"testdomain.com", false}
                }
        );
    }

    @Test
    public void testValidEmail() throws Exception {
        boolean actual = EmailUtility.isValidEmail(email);
        assertThat(actual, is(equalTo(expected)));
    }
}
