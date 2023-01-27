import io.restassured.response.Response;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import static org.junit.Assert.assertEquals;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MathTest {
    private static ExtentReports extent;
    private ExtentTest test;

    @Rule public TestName testName = new TestName();

    @BeforeClass
    public static void setupClass(){
        // create an instance of the ExtentReports class
        MathTest.extent = new ExtentReports();
        // configure the report
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extent.html");
        extent.attachReporter(htmlReporter);
    }

    @AfterClass
    public static void cleanUpClass(){
        MathTest.extent.flush();
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
            test = MathTest.extent.createTest(description.getMethodName());
            test.info("Test Started");
        }

//        @Override
//        protected void finished(Description description) {
//            test.info("Test finished");
//        }
    };

    @Test
    public void testGetUserPost() {
        PostApi api = new PostApi();
        Response response = api.getPosts();
        assertEquals(200, response.getStatusCode());
        assertEquals("quidem molestiae enim", response.jsonPath().get("title"));
    }

    @Test
    public void sub(){
        assertEquals(21, 23-2);
    }
}
