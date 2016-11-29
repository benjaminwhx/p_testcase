package com.jd.bt.systemrules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by zhangkai9@jd.com on 16-11-29.
 */
public class SystemOutTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testName() throws Exception {

        System.out.println("hello world~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~hello world");
        assertThat(systemOutRule.getLog()).contains("hello world~~~~~~~~~~~~~~~~~~~~~~");
        assertEquals(1,1);
    }
}
