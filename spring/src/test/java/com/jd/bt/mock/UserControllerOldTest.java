package com.jd.bt.mock;

import com.jd.bt.action.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: 吴海旭
 * Date: 2016-11-28
 * Time: 下午4:01
 */
public class UserControllerOldTest {

    private UserController userController;

    @Before
    public void setUp() {
        userController = new UserController();
        //安装userCtroller依赖 比如userService
    }

    @Test
    public void testView() {
        MockHttpServletRequest req = new MockHttpServletRequest();
        ModelAndView mv = userController.view(1L, req);

        ModelAndViewAssert.assertViewName(mv, "user/view");
        ModelAndViewAssert.assertModelAttributeAvailable(mv, "user");

    }
}
