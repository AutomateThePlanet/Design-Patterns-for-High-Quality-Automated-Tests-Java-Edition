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
import org.testng.annotations.*;
import reusebrowser.Driver;
import reusebrowser.LoggingDriver;
import reusebrowser.WebCoreDriver;

public class BaseTest {
    private static final TestExecutionSubject CURRENT_TEST_EXECUTION_SUBJECT;
    private static final Driver DRIVER;
    private ITestResult result;

    static {
        CURRENT_TEST_EXECUTION_SUBJECT = new ExecutionSubject();
        DRIVER = new LoggingDriver(new WebCoreDriver());
        new BrowserLaunchTestBehaviorObserver(CURRENT_TEST_EXECUTION_SUBJECT, DRIVER);
    }

    public String getTestName() {
        return getTestResult().getTestName();
    }

    public void setTestResult(ITestResult result) {
        this.result = result;
    }

    public ITestResult getTestResult() {
        return result;
    }

    public Driver getDriver() {
        return DRIVER;
    }

    @AfterSuite
    public void afterSuite() {
        if (DRIVER != null) {
            DRIVER.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod(ITestResult result) throws NoSuchMethodException, ClassNotFoundException {
        setTestResult(result);
        var testClass = this.getClass();
        var methodInfo = testClass.getMethod(getTestResult().getMethod().getMethodName());
        CURRENT_TEST_EXECUTION_SUBJECT.preTestInit(getTestResult(), methodInfo);
        testInit();
        CURRENT_TEST_EXECUTION_SUBJECT.postTestInit(getTestResult(), methodInfo);
    }

    @AfterMethod
    public void afterMethod() throws NoSuchMethodException {
        var testClass = this.getClass();
        var methodInfo = testClass.getMethod(getTestResult().getMethod().getMethodName());
        CURRENT_TEST_EXECUTION_SUBJECT.preTestCleanup(getTestResult(), methodInfo);
        testCleanup();
        CURRENT_TEST_EXECUTION_SUBJECT.postTestCleanup(getTestResult(), methodInfo);
    }

    protected void testInit()
    {
    }

    protected void testCleanup()
    {
    }
}
