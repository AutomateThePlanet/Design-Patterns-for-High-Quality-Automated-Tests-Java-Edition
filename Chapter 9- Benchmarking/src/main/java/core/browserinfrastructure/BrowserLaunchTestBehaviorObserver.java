package core.browserinfrastructure;

import core.Browser;
import core.Driver;

public class BrowserLaunchTestBehaviorObserver extends BaseTestBehaviorObserver {
    private final Driver _driver;
    private BrowserConfiguration _currentBrowserConfiguration;
    private BrowserConfiguration _previousBrowserConfiguration;

    public BrowserLaunchTestBehaviorObserver(TestExecutionSubject testExecutionSubject, Driver driver) {
        super(testExecutionSubject);
        _driver = driver;
    }

    @Override
    public void preTestInit(Class<?> currentClass) {
        _currentBrowserConfiguration = getBrowserConfiguration(currentClass);

        Boolean shouldRestartBrowser = ShouldRestartBrowser(_currentBrowserConfiguration);

        if (shouldRestartBrowser)
        {
            restartBrowser();
        }

        _previousBrowserConfiguration = _currentBrowserConfiguration;
    }

    @Override
    public void postTestCleanup(Class<?> currentClass) {
//        if (_currentBrowserConfiguration.getBrowserBehavior() ==
//                BrowserBehavior.RestartOnFail)
//        {
//            _driver.quit();
//        }
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

    private BrowserConfiguration getBrowserConfiguration(Class<?> currentClass)
    {
        var executionBrowserAnnotation = (ExecutionBrowser)currentClass.getDeclaredAnnotation(ExecutionBrowser.class);
        if (executionBrowserAnnotation == null)
        {
            return null;
        }

        return new BrowserConfiguration(executionBrowserAnnotation.browser(), executionBrowserAnnotation.browserBehavior());
    }
}
