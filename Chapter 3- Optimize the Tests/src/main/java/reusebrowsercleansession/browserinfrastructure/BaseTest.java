package reusebrowsercleansession.browserinfrastructure;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import reusebrowsercleansession.Driver;
import reusebrowsercleansession.LoggingDriver;
import reusebrowsercleansession.WebCoreDriver;

public class BaseTest {
    private static final TestExecutionSubject CurrentTestExecutionSubject;
    private static Driver _driver;
    private ITestResult _result;

    static {
        CurrentTestExecutionSubject = new ExecutionSubject();
        _driver = new LoggingDriver(new WebCoreDriver());
        new BrowserLaunchTestBehaviorObserver(CurrentTestExecutionSubject, _driver);
    }

    public String getTestName() {
        return getTestResult().getTestName();
    }

    public void setTestResult(ITestResult result) {
        _result = result;
    }

    public ITestResult getTestResult() {
        return _result;
    }

    public Driver getDriver() {
        return _driver;
    }

    @AfterSuite
    public void afterSuite() {
        if (_driver != null) {
            _driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod(ITestResult result) throws NoSuchMethodException, ClassNotFoundException {
        setTestResult(result);
        var testClass = this.getClass();
        var methodInfo = testClass.getMethod(getTestResult().getMethod().getMethodName());
        CurrentTestExecutionSubject.preTestInit(getTestResult(), methodInfo);
        testInit();
        CurrentTestExecutionSubject.postTestInit(getTestResult(), methodInfo);
    }

    @AfterMethod
    public void afterMethod() throws NoSuchMethodException {
        var testClass = this.getClass();
        var methodInfo = testClass.getMethod(getTestResult().getMethod().getMethodName());
        CurrentTestExecutionSubject.preTestCleanup(getTestResult(), methodInfo);
        testCleanup();
        CurrentTestExecutionSubject.postTestCleanup(getTestResult(), methodInfo);
    }

    protected void testInit()
    {
    }

    protected void testCleanup()
    {
    }
}
