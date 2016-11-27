package com.jd.bt.junit4.transactional;

import com.jd.bt.dao.UserDao;
import com.jd.bt.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午5:04
 */
public class UserDaoTest extends AbstractSpringTestCase {

    @Autowired
    private UserDao userDao;

    @Test
//    @Rollback
    public void testSaveUser() {
        User user = new User();
        user.setDept("defffffsdfsdfsdf");
        user.setName("car");
        user.setPhone("18888888888");
        user.setWebsite("car.jd.com");
        userDao.saveUser(user);
    }
}
