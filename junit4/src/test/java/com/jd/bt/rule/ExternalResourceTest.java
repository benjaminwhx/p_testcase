package com.jd.bt.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午5:51
 * ExternalResource是用来在操作前打开一些数据库连接或者流等操作，然后执行完后关闭。
 */
public class ExternalResourceTest {

    @Rule
    public ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            System.out.println("打开input流");
        }

        @Override
        protected void after() {
            System.out.println("关闭input流");
        }
    };

    @Test
    public void testExternalResource() {
        System.out.println("test ExternalResource");
    }
}
