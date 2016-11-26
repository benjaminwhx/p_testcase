package com.jd.bt.flow;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.Closeable;
import java.io.IOException;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午3:07
 */
public class FlowTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public TestRule testRule = new TestRuleValueImpl();

    @Rule
    public TestRule testRuleMethod() {
        System.out.println();
        System.out.println("@Rule Method");
        return new TestRuleMethodImpl();
    }
    @ClassRule
    public static TestRule testClassRuleMethod() {
        System.out.println("@ClassRule Method");
        return new TestRuleMethodImpl();
    }

    static class TestRuleValueImpl implements TestRule{
        @Override
        public Statement apply(Statement base, Description description) {
            System.out.println("@Rule property--TestRuleValueImpl execute apply()");
            return new StatementValueImpl(base);
        }
    }

    static class StatementValueImpl extends Statement {
        Statement base;
        StatementValueImpl(Statement base) {
            this.base = base;
        }
        @Override
        public void evaluate() throws Throwable {
            System.out.println("@Rule property--StatementValueImpl execute evaluate()");
            base.evaluate();
        }

    }
    static class TestRuleMethodImpl implements TestRule{
        @Override
        public Statement apply(Statement base, Description description) {
            System.out.println("@Rule method--TestRuleMethodImpl execute apply()");
            return new StatementMethodImpl(base);
        }

    }

    static class StatementMethodImpl extends Statement {
        Statement base;
        StatementMethodImpl(Statement base) {
            this.base = base;
        }
        @Override
        public void evaluate() throws Throwable {
            System.out.println("@Rule Method--StatementMethodImpl execute evaluate()");
            base.evaluate();
        }

    }
    static class ExpensiveManagedResource implements Closeable {
        @Override
        public void close() throws IOException {
        }
    }

    static class ManagedResource implements Closeable {
        @Override
        public void close() throws IOException {
        }
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("@BeforeClass setUpClass");
        myExpensiveManagedResource = new ExpensiveManagedResource();
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
        System.out.println("@AfterClass tearDownClass");
        myExpensiveManagedResource.close();
        myExpensiveManagedResource = null;
    }

    private ManagedResource myManagedResource;
    private static ExpensiveManagedResource myExpensiveManagedResource;

    private void println(String string) {
        System.out.println(string);
    }

    @Before
    public void setUp() {
        this.println("@Before setUp");
        this.myManagedResource = new ManagedResource();
    }

    @After
    public void tearDown() throws IOException {
        this.println("@After tearDown");
        this.myManagedResource.close();
        this.myManagedResource = null;
        this.println("   ");
    }

    @Test
    public void test1() {
        this.println("   @Test test1() begin");
        this.println("   @Test test1() execute during evaluate()");
        this.println("   @Test test1() finished");
    }

    @Test
    public void test2() {
        this.println("   @Test test2() begin");
        this.println("   @Test test2() execute during evaluate()");
        this.println("   @Test test2() finished");
    }

    @Test
    public void test3() {
        this.println("   @Test test3() begin");
        String hi = "   @Test test3() execute during evaluate()";
        expectedException.expect(Exception.class);
        expectedException.expectMessage("ddd");
        this.println(hi);
        this.println("   @Test test3() finished.");
    }
}
