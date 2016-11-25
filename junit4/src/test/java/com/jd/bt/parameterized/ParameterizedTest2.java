package com.jd.bt.parameterized;

import com.jd.bt.AbstractTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

/**
 * User: 吴海旭
 * Date: 2016-11-24
 * Time: 下午7:40
 * 使用自定义参数RunnerFactory
 */
@RunWith(Parameterized.class)
@Parameterized.UseParametersRunnerFactory(MyRunnerFactory.class)
public class ParameterizedTest2 extends AbstractTest {

    private final String email;
    private final boolean expected;

    public ParameterizedTest2(String email, boolean expected) {
        this.email = email;
        this.expected = expected;
    }

    // name 我暂时没发现有什么用，如果有用可以给我提issue
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
