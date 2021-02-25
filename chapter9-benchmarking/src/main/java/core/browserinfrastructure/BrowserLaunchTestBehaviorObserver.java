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

package core.browserinfrastructure;

import core.Browser;
import core.Driver;

public class BrowserLaunchTestBehaviorObserver extends BaseTestBehaviorObserver {
    private final Driver driver;
    private BrowserConfiguration currentBrowserConfiguration;
    private BrowserConfiguration previousBrowserConfiguration;

    public BrowserLaunchTestBehaviorObserver(TestExecutionSubject testExecutionSubject, Driver driver) {
        super(testExecutionSubject);
        this.driver = driver;
    }

    @Override
    public void preTestInit(Class<?> currentClass) {
        currentBrowserConfiguration = getBrowserConfiguration(currentClass);

        Boolean shouldRestartBrowser = ShouldRestartBrowser(currentBrowserConfiguration);

        if (shouldRestartBrowser) {
            restartBrowser();
        }

        previousBrowserConfiguration = currentBrowserConfiguration;
    }

    @Override
    public void postTestCleanup(Class<?> currentClass) {
//        if (_currentBrowserConfiguration.getBrowserBehavior() ==
//                BrowserBehavior.RestartOnFail)
//        {
//            _driver.quit();
//        }
    }

    private void restartBrowser() {
        driver.quit();
        driver.start(currentBrowserConfiguration.getBrowser());
    }

    private Boolean ShouldRestartBrowser(BrowserConfiguration browserConfiguration) {
        if (previousBrowserConfiguration == null) {
            return true;
        }

        Boolean shouldRestartBrowser =
                browserConfiguration.getBrowserBehavior() == BrowserBehavior.RESTART_EVERY_TIME || browserConfiguration.getBrowser() == Browser.NOT_SET;

        return shouldRestartBrowser;
    }

    private BrowserConfiguration getBrowserConfiguration(Class<?> currentClass) {
        var executionBrowserAnnotation = (ExecutionBrowser) currentClass.getDeclaredAnnotation(ExecutionBrowser.class);
        if (executionBrowserAnnotation == null) {
            return null;
        }

        return new BrowserConfiguration(executionBrowserAnnotation.browser(), executionBrowserAnnotation.browserBehavior());
    }
}
