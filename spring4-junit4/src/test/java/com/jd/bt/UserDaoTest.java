package com.jd.bt;

import com.jd.bt.dao.UserDao;
import com.jd.bt.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
