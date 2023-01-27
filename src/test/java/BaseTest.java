import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

    private static ExtentReports extent;
    protected ExtentTest test;

    @BeforeClass
    public static void setupClass(){

        // create an instance of the ExtentReports class
        BaseTest.extent = new ExtentReports();
        // configure the report
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extent.html");
        extent.attachReporter(htmlReporter);
    }

    @AfterClass
    public static void cleanUpClass(){
        BaseTest.extent.flush();
    }


    @Before
    public void setUp() {
    }

    @After
    public void cleanUp(){
    }

    @Rule
    public TestWatcher watcher = new TestWatcher() {

        @Override
        protected void failed(Throwable e, Description description) {
            //test.fail("Test failed -> " + description.getMethodName() + e.getMessage());
            test.fail(  e.getMessage());
        }

        @Override
        protected void succeeded(Description description) {
            //test.pass("Test passed" + description.getMethodName());
            test.pass("Test passed");
        }

        @Override
        protected void starting(Description description) {
            test = BaseTest.extent.createTest(description.getMethodName());
            test.info("Test Started");
        }

//        @Override
//        protected void finished(Description description) {
//            test.info("Test finished");
//        }


    };

}
