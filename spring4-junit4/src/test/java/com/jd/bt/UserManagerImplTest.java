package com.jd.bt;

import com.jd.bt.manager.IUserManager;
import com.jd.bt.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午3:59
 */
public class UserManagerImplTest extends AbstractSpringTestCase {

    @Autowired
    private IUserManager userManagerImpl;

    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setDept("abc");
        user.setName("ben");
        user.setPhone("18888888888");
        user.setWebsite("ben.jd.com");
        userManagerImpl.insert(user);
    }

}