package demo;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

/**
 * @author sc
 * @date 2019-02-24$
 * @description 单元测试$
 *
 * 单元测试类执行顺序为： @BeforeClass –> @Before –> @Test –> @After –> @AfterClass
 */
public class UnitTest {

    @BeforeClass
    public static void testBeforeClass(){
        System.out.println("@BeforeClass");
    }
    @Before
    public void testBefore(){
        System.out.println("@Before");
    }
    @Test
    public void testTest(){
        System.out.println("@Test");
    }
    @After
    public void testAfter(){
        System.out.println("@After");
    }
    @AfterClass
    public static void testAfterClass(){
        System.out.println("@AfterClass");
    }
    @Ignore
    public void testIgnore(){
        System.out.println("@Ignore");
    }

    public void printName(String name){
        System.out.println(name);
    }

    public static void main(){

        UnitTest unitTest = new UnitTest();
        unitTest.printName("陆小凤");

    }
}
