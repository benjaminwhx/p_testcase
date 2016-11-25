package com.jd.bt.rule;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午5:38
 * TestWatcher定义了五个触发点，分别是测试开始，测试成功，测试跳过，测试失败，测试完成，能让我们在每个触发点执行自己的逻辑
 */
public class TestWatcherTest {

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println(description.getDisplayName() + " Succeed");
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(description.getDisplayName() + " Failed");
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            System.out.println(description.getDisplayName() + " Skipped");
        }

        @Override
        protected void starting(Description description) {
            System.out.println(description.getDisplayName() + " Starting");
        }

        @Override
        protected void finished(Description description) {
            System.out.println(description.getDisplayName() + " Finished");
        }
    };

    @Test
    public void testTestWatcher() {
        System.out.println("Test invoked");
    }
}
