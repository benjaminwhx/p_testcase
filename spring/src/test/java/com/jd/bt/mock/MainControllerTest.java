package com.jd.bt.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * User: 吴海旭
 * Date: 2016-11-27
 * Time: 下午6:38
 * https://github.com/zhangkaitao/spring4-showcase/blob/master/spring-mvc-test/src/test/java/com/sishuok/mvc/controller/ServerControllerTest.java
 * http://jinnianshilongnian.iteye.com/blog/2004660
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:applicationContext/applicationContext.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:applicationContext/applicationContext-servlet.xml")
})
public class MainControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Test
    public void test1() {
        Assert.assertNotNull(wac);
    }
}
