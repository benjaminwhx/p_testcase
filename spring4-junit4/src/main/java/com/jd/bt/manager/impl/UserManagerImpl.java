package com.jd.bt.manager.impl;

import com.jd.bt.manager.IUserManager;
import com.jd.bt.model.User;
import org.guzz.dao.GuzzBaseDao;
import org.guzz.orm.se.SearchExpression;
import org.guzz.orm.se.SearchTerm;
import org.guzz.orm.se.Terms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午0:53
 */
@Service
public class UserManagerImpl implements IUserManager {

    @Autowired
    private GuzzBaseDao guzzBaseDao;

    @Override
    public User getUserById(int id) {
        System.out.println("get user by id: " + id);
        SearchExpression se = SearchExpression.forBusiness("user");
        se.and(Terms.eq("id", id));
        return (User) guzzBaseDao.findObject(se);
    }

    @Override
    public boolean insert(User user) {
        try {
            guzzBaseDao.insert(user);
        } catch (Exception e) {
            System.out.println("insert user error, message is " + e.getMessage());
            return false;
        }
        return true;
    }
}
