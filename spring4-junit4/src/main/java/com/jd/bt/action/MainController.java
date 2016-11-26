package com.jd.bt.action;

import com.jd.bt.manager.IUserManager;
import com.jd.bt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午0:50
 */
@Controller
public class MainController {

    @Autowired
    private IUserManager userManagerImpl;

    @RequestMapping("/user")
    public String getUserName(Model model) {
        User user = userManagerImpl.getUserById(1);
        model.addAttribute(user);
        return "user";
    }
}
