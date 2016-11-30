package com.jd.bt.mock.parent;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:31
 */
@RunWith(PowerMockRunner.class)
public class AbstractMockRunner {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
}
