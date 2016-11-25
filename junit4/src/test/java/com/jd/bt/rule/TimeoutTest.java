package com.jd.bt.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午5:46
 * 使用@Test(timeout) 和 使用 Timeout是一样的效果
 */
public class TimeoutTest {

    @Rule
    public Timeout timeout = new Timeout(1, TimeUnit.SECONDS);

    @Test
//    @Test(timeout = 1000)
    public void testTimeout() {
//        try {
//            Thread.sleep(1001);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("test time out");
    }
}
