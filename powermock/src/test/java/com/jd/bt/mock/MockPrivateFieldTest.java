package com.jd.bt.mock;

import com.jd.bt.mock.parent.AbstractMockRunner;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;

/**
 * User: 吴海旭
 * Date: 2016-11-30
 * Time: 上午10:18
 */
@PrepareForTest(Mock.class)
public class MockPrivateFieldTest extends AbstractMockRunner {

    @Test
    public void testPrivateField() throws IllegalAccessException {
        Mock mock = new Mock();
        MemberModifier.field(Mock.class, "age").set(mock, 2);

        Assert.assertEquals(mock.getAge(), 2);
    }
}
