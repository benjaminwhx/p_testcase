package com.jd.bt.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午5:30
 */
public class VerifierTest {

    private String result = "";

    @Rule
    public Verifier verifier = new Verifier() {
        @Override
        protected void verify() throws Throwable {
            // result不是success抛出异常，test失败
            if (!"Success".equals(result)) {
                throw new Exception("Test fail.");
            }
        }
    };

    @Test
    public void testVerify() {
        System.out.println("begin verify");
        result = "fail";
        System.out.println("finish verify");
    }
}
