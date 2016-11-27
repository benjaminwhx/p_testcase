package com.jd.bt.manager;

import com.jd.bt.model.User;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午0:53
 */
public interface IUserManager {

    User getUserById(int id);

    boolean insert(User user);
}
