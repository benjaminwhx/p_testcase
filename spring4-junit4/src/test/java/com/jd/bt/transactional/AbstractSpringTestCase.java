package com.jd.bt.transactional;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午5:39
 * 抽象出来的测试类
 */
@ContextConfiguration(locations = {"classpath:applicationContext/applicationContext.xml", "classpath:testDao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
// rollback为true测试的时候不会污染数据库
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public abstract class AbstractSpringTestCase {
}
