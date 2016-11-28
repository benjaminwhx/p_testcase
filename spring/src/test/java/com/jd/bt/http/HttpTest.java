package com.jd.bt.http;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: 吴海旭
 * Date: 2016-11-27
 * Time: 下午6:25
 */
public class HttpTest {

    @Test
    public void testGetUserById() {
        String url = "http://localhost:8080/main/1";
        String result = HttpClientUtils.sendGetRequest(url);
        Assert.assertNotNull(result);
        // {"id":1,"name":"yiibai","dept":"Tech","website":"http://www.yiibai.com","phone":"13800009988"}
        System.out.println(result);
    }
}
