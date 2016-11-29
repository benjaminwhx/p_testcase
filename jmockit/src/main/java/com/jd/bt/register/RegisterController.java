package com.jd.bt.register;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午9:48
 */
public class RegisterController {

    private RedisService redisService = new RedisService();

    /**
     * 用户注册的方法
     * @param registerDTO
     */
    public String register(RegisterDTO registerDTO) {
        // 验证图形二维码
        boolean verifyImageSuccess = verifyImageCode(registerDTO.getImageVerifyCode());
        if (!verifyImageSuccess) {
            System.out.println("图形验证失败");
            return "failed";
        }
        // 验证短信码
        boolean verifyPhoneSuccess = verifyPhoneCode(registerDTO.getPhoneVerifyCode());
        if (!verifyPhoneSuccess) {
            System.out.println("手机码验证失败");
            return "failed";
        }

        // 真正的注册流程
        boolean registerSuccess = register(registerDTO.getUserName(), registerDTO.getPassword());
        if (!registerSuccess) {
            System.out.println("注册失败");
            return "failed";
        }

        return "success";
    }

    public boolean verifyImageCode(String imageCode) {
        // 从redis中拿到imageCode和我传入的进行比对
        // 传入A2be才返回true,否则返回false
        System.out.println("验证图形码");
        return redisService.get().equals(imageCode);
    }

    private boolean verifyPhoneCode(String phoneCode) {
        System.out.println("验证短信码");
        return true;
    }

    private boolean register(String userName, String password) {
        System.out.println("注册");
        return true;
    }
}
