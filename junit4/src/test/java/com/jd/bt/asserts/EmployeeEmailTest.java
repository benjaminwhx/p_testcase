package com.jd.bt.asserts;

import com.jd.bt.AbstractTest;
import org.junit.Test;

import java.util.Map;

/**
 * User: 吴海旭
 * Date: 2016-11-24
 * Time: 下午6:03
 * @assertEquals @assertNotEquals {@link #addEmployeeEmailId()}
 * @assertNull @assertNotNull {@link #getEmailId()}
 * @assertTrue @assertFalse {@link #isValidEmail()}
 * @assertSame {@link #testIfObjectsAreSame()}
 * @assertNotSame {@link #testIfObjectsAreNotSame()}
 */
public class EmployeeEmailTest extends AbstractTest {

    @Test
    public void addEmployeeEmailId() throws Exception {
        EmployeeEmail employeeEmail = new EmployeeEmail();
        employeeEmail.addEmployeeEmail("emp1", "abc@qq.com");
        employeeEmail.addEmployeeEmail("emp2", "def@qq.com");

        assertEquals("Incorrect Collection Size ", 2, employeeEmail.emailMap.size());

        // add duplicate key, size not change
        employeeEmail.addEmployeeEmail("emp2", "ghi@qq.com");

        assertNotEquals("Duplicate key in collection", 3, employeeEmail.emailMap.size());
    }

    @Test
    public void getEmailId() throws Exception {
        EmployeeEmail employeeEmail = new EmployeeEmail();
        employeeEmail.addEmployeeEmail("emp1", "abc@qq.com");
        employeeEmail.addEmployeeEmail("emp2", "def@qq.com");

        String notNullVal = employeeEmail.getEmailId("emp2");
        assertNotNull("Returned null for existing employee", notNullVal);

        String nullVal = employeeEmail.getEmailId("emp5");
        assertNull("Failed to return null for non existing employee", nullVal);
    }

    @Test
    public void isValidEmail() throws Exception {
        EmployeeEmail employeeEmail = new EmployeeEmail();
        // valid email
        boolean isValid1 = employeeEmail.isValidEmail("abc@qq.com");
        assertTrue(isValid1);
        // invalid email
        boolean isInvalid1 = employeeEmail.isValidEmail("abc@sdfsdf");
        assertFalse(isInvalid1);
        boolean isInvalid2 = employeeEmail.isValidEmail("234234$&*(@sina.com");
        assertFalse(isInvalid2);
    }

    @Test
    public void testIfObjectsAreSame() throws Exception {
        EmployeeEmail empEmail1=new EmployeeEmail();
        empEmail1.addEmployeeEmail("emp1","peter@testdomain.com");
        EmployeeEmail empEmail2=new EmployeeEmail();
        empEmail1.addEmployeeEmail("emp2", "mary@testdomain.com");

        Map map1=empEmail1.emailMap;
        Map map2=empEmail2.emailMap;
        map1= map2;

        assertSame("Failed because objects are not same ", map1, map2);
    }

    @Test
    public void testIfObjectsAreNotSame() throws Exception {
        EmployeeEmail empEmail1=new EmployeeEmail();
        empEmail1.addEmployeeEmail("emp1","peter@testdomain.com");
        EmployeeEmail empEmail2=new EmployeeEmail();
        empEmail1.addEmployeeEmail("emp2", "mary@testdomain.com");

        Map map1=empEmail1.emailMap;
        Map map2=empEmail2.emailMap;

        assertNotSame("Failed because objects are same ", map1, map2);
    }
}