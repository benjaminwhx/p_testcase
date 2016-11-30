package com.jd.bt.mock;

import com.jd.bt.mock.parent.AbstractMockRunner;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.powermock.api.mockito.PowerMockito.*;

/**
 * User: 吴海旭
 * Date: 2016-12-01
 * Time: 上午01:03
 *
 * @InjectMocks 把mock的对象注入到当前对象中去。
 */
@PrepareForTest({Person.class, Father.class})
public class AnnotationTest extends AbstractMockRunner {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    private Person person;
    @org.mockito.Mock
    private Father father;
    @Spy
    private Mock mock;
    @Captor
    private ArgumentCaptor<String> argumentCaptor;

    @Test
    public void testAnnotation() {
        when(father.getName()).thenCallRealMethod();

        stub(method(Person.class, "hello")).toReturn("aaa");
        // null->0->father
        System.out.println(person.toString());
        // aaa
        System.out.println(person.hello());
    }
}
