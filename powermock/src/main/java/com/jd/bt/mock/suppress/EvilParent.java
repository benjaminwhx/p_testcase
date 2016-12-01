package com.jd.bt.mock.suppress;

/**
 * User: 吴海旭
 * Date: 2016-12-01
 * Time: 上午10:43
 */
public class EvilParent {

    public EvilParent() {
        System.out.println("start to load system library");
        // 加载native lib
        System.loadLibrary("evil.dll");
    }
}
