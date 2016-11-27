package com.jd.bt.dao;

import com.jd.bt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午4:59
 */
@Repository("userDao")
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveUser(User user) {
        return this.jdbcTemplate.update("insert into user(name, dept, website, phone) values ('" + user.getName() + "','" + user.getDept() + "','" + user.getWebsite() + "','" + user.getPhone() + "')");
    }
}
