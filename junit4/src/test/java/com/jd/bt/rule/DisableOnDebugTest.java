package com.jd.bt.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午9:30
 * 当我们以debug模式运行测试类时,会忽略测试方法,因为debug模式会在jvm启动前增加一个参数 "-agentlib:jdwp..."
 * 这时候junit会监测到是以debug启动的。
 */
public class DisableOnDebugTest {

    @Rule
    public DisableOnDebug timeoutRule = new DisableOnDebug(new Timeout(1000, TimeUnit.MILLISECONDS));

    @Test
    public void testDisableOnDebug() {
        try {
            Thread.sleep(1001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("this is disable on debug mode");
    }
}
