package com.jd.bt.register;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午9:51
 */
public class RedisService {

    // 这里我们模拟随机生成4位验证码(这里写死了)
    private String tempImageCode = "A2be";

    /**
     * 随机生成一个图形二维码
     */
    public void generate() {
        System.out.println("生成图形验证码: " + tempImageCode);
        // 放入redis中
        put(tempImageCode);
    }

    /**
     * 把生成的图形码放入redis中
     * @param imageCode
     */
    public void put(String imageCode) {
        System.out.println("图形验证码放入redis中: " + imageCode);
    }

    /**
     * 返回之前生成的图形二维码
     * @return
     */
    public String get() {
        System.out.println("返回redis中的图形验证码: " + tempImageCode);

        return tempImageCode;
    }
}
