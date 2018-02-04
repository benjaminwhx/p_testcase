package com.jd.bt.junit4.transactional;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午5:39
 * 抽象出来的测试类（spring-test 4.2版本之后使用）
 */
@ContextConfiguration(locations = {"classpath:applicationContext/applicationContext.xml", "classpath:testDao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(transactionManager = "transactionManager")
// rollback为true测试的时候不会污染数据库
@Rollback(value = true)
public abstract class AbstractSpringTestCase2 {
}
