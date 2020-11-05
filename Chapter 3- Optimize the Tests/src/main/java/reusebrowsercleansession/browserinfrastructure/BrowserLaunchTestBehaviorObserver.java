package reusebrowsercleansession.browserinfrastructure;

import org.testng.ITestResult;
import reusebrowsercleansession.Browser;
import reusebrowsercleansession.Driver;

import java.lang.reflect.Method;

public class BrowserLaunchTestBehaviorObserver extends BaseTestBehaviorObserver {
    private final Driver _driver;
    private BrowserConfiguration _currentBrowserConfiguration;
    private BrowserConfiguration _previousBrowserConfiguration;

    public BrowserLaunchTestBehaviorObserver(TestExecutionSubject testExecutionSubject, Driver driver) {
        super(testExecutionSubject);
        _driver = driver;
    }

    @Override
    public void preTestInit(ITestResult testResult, Method memberInfo) {
        _currentBrowserConfiguration = getBrowserConfiguration(memberInfo);

        Boolean shouldRestartBrowser = ShouldRestartBrowser(_currentBrowserConfiguration);

        if (shouldRestartBrowser)
        {
            restartBrowser();
        }
        else
        {
            _driver.deleteAllCookies();
        }

        _previousBrowserConfiguration = _currentBrowserConfiguration;
    }

    @Override
    public void postTestCleanup(ITestResult testResult, Method memberInfo) {
        if (_currentBrowserConfiguration.getBrowserBehavior() ==
                BrowserBehavior.RestartOnFail && testResult.getStatus() == ITestResult.FAILURE)
        {
            restartBrowser();
        }
        else
        {
            _driver.deleteAllCookies();
        }
    }

    private void restartBrowser()
    {
        _driver.quit();
        _driver.start(_currentBrowserConfiguration.getBrowser());
    }

    private Boolean ShouldRestartBrowser(BrowserConfiguration browserConfiguration)
    {
        if (_previousBrowserConfiguration == null)
        {
            return true;
        }

        Boolean shouldRestartBrowser =
                browserConfiguration.getBrowserBehavior() == BrowserBehavior.RestartEveryTime || browserConfiguration.getBrowser() == Browser.NotSet;

        return shouldRestartBrowser;
    }

    private BrowserConfiguration getBrowserConfiguration(Method memberInfo)
    {
        BrowserConfiguration result = null;
        var classBrowserType = getExecutionBrowserClassLevel(memberInfo.getDeclaringClass());
        var methodBrowserType = getExecutionBrowserMethodLevel(memberInfo);
        if (methodBrowserType != null)
        {
            result = methodBrowserType;
        }
        else if (classBrowserType != null)
        {
            result = classBrowserType;
        }

        return result;
    }

    private BrowserConfiguration getExecutionBrowserMethodLevel(Method memberInfo)
    {
        var executionBrowserAnnotation = (ExecutionBrowser)memberInfo.getDeclaredAnnotation(ExecutionBrowser.class);
        if (executionBrowserAnnotation == null)
        {
            return null;
        }

        return new BrowserConfiguration(executionBrowserAnnotation.browser(), executionBrowserAnnotation.browserBehavior());
    }

    private BrowserConfiguration getExecutionBrowserClassLevel(Class<?> type)
    {
        var executionBrowserAnnotation = (ExecutionBrowser)type.getDeclaredAnnotation(ExecutionBrowser.class);
        if (executionBrowserAnnotation == null)
        {
            return null;
        }

        return new BrowserConfiguration(executionBrowserAnnotation.browser(), executionBrowserAnnotation.browserBehavior());
    }
}
