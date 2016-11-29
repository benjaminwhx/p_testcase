package com.jd.bt.register;

import mockit.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午10:00
 */
public class MockVoRegisterTest {

    @Tested
    RegisterController mockController;


    @Test
    public void testRegister() {
        RegisterDTO registerDTO = constructInstance();

        // 使用局部mock,这个例子中我只要mock verifyImageCode这个方法,其他的方法还是按我定义的来走。
        new MockUp<RegisterController>(){
            @Mock
            public boolean verifyImageCode(String imageCode) {
                assertEquals("1234", imageCode);
                System.out.println("验证图形码成功");
                return true;
            }
        };

        String result = mockController.register(registerDTO);
        assertEquals("success", result);
    }


    private RegisterDTO constructInstance() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setUserName("benjamin");
        registerDTO.setPassword("123456");
        registerDTO.setPhoneVerifyCode("6523");
        registerDTO.setImageVerifyCode("1234");
        return registerDTO;
    }
}
