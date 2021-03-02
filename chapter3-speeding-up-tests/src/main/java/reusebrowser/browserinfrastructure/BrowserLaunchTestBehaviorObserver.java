/*
 * Copyright 2021 Automate The Planet Ltd.
 * Author: Anton Angelov
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package reusebrowser.browserinfrastructure;

import org.testng.ITestResult;
import reusebrowser.Browser;
import reusebrowser.Driver;

import java.lang.reflect.Method;
import java.util.Optional;

public class BrowserLaunchTestBehaviorObserver extends BaseTestBehaviorObserver {
    private final Driver driver;
    private BrowserConfiguration currentBrowserConfiguration;
    private BrowserConfiguration previousBrowserConfiguration;

    public BrowserLaunchTestBehaviorObserver(TestExecutionSubject testExecutionSubject, Driver driver) {
        super(testExecutionSubject);
        this.driver = driver;
    }

    @Override
    public void preTestInit(ITestResult testResult, Method memberInfo) {
        currentBrowserConfiguration = getBrowserConfiguration(memberInfo);

        Boolean shouldRestartBrowser = shouldRestartBrowser(currentBrowserConfiguration);

        if (shouldRestartBrowser) {
            restartBrowser();
        }

        previousBrowserConfiguration = currentBrowserConfiguration;
    }

    @Override
    public void postTestCleanup(ITestResult testResult, Method memberInfo) {
        if (currentBrowserConfiguration.getBrowserBehavior() ==
                BrowserBehavior.RESTART_ON_FAIL && testResult.getStatus() == ITestResult.FAILURE) {
            restartBrowser();
        }
    }

    private void restartBrowser() {
        driver.quit();
        driver.start(currentBrowserConfiguration.getBrowser());
    }

    private Boolean shouldRestartBrowser(BrowserConfiguration browserConfiguration) {
        if (previousBrowserConfiguration == null) {
            return true;
        }

        Boolean shouldRestartBrowser =
                browserConfiguration.getBrowserBehavior() == BrowserBehavior.RESTART_EVERY_TIME || browserConfiguration.getBrowser() == Browser.NOT_SET;

        return shouldRestartBrowser;
    }

    private BrowserConfiguration getBrowserConfiguration(Method memberInfo) {
        BrowserConfiguration result = null;
        var classBrowserType = getExecutionBrowserClassLevel(memberInfo.getDeclaringClass());
        var methodBrowserType = getExecutionBrowserMethodLevel(memberInfo);
        if (methodBrowserType != null) {
            result = methodBrowserType;
        } else if (classBrowserType != null) {
            result = classBrowserType;
        }

        return result;
    }

    // Java 8 Optional
//    private BrowserConfiguration getBrowserConfiguration(Method memberInfo) {
//        return Optional.ofNullable(getExecutionBrowserMethodLevel(memberInfo)).
//                orElse(getExecutionBrowserClassLevel(memberInfo.getDeclaringClass()));
//    }

    private BrowserConfiguration getExecutionBrowserMethodLevel(Method memberInfo) {
        var executionBrowserAnnotation = (ExecutionBrowser) memberInfo.getDeclaredAnnotation(ExecutionBrowser.class);
        if (executionBrowserAnnotation == null) {
            return null;
        }

        return new BrowserConfiguration(executionBrowserAnnotation.browser(), executionBrowserAnnotation.browserBehavior());
    }

    private BrowserConfiguration getExecutionBrowserClassLevel(Class<?> type) {
        var executionBrowserAnnotation = (ExecutionBrowser) type.getDeclaredAnnotation(ExecutionBrowser.class);
        if (executionBrowserAnnotation == null) {
            return null;
        }

        return new BrowserConfiguration(executionBrowserAnnotation.browser(), executionBrowserAnnotation.browserBehavior());
    }
}
