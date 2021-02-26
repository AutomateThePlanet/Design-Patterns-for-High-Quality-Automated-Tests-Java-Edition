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

package reusebrowsercleansession.browserinfrastructure;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import reusebrowsercleansession.Driver;
import reusebrowsercleansession.LoggingDriver;
import reusebrowsercleansession.WebCoreDriver;

//public class BaseTest {
//    private static final TestExecutionSubject executionSubject;
//    private static final Driver driver;
//    private ITestResult result;
//
//    static {
//        executionSubject = new ExecutionSubject();
//        driver = new LoggingDriver(new WebCoreDriver());
//        new BrowserLaunchTestBehaviorObserver(executionSubject, driver);
//    }
//
//    public String getTestName() {
//        return getTestResult().getTestName();
//    }
//
//    public void setTestResult(ITestResult result) {
//        this.result = result;
//    }
//
//    public ITestResult getTestResult() {
//        return result;
//    }
//
//    public Driver getDriver() {
//        return driver;
//    }
//
//    @AfterSuite
//    public void afterSuite() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    @BeforeMethod
//    public void beforeMethod(ITestResult result) throws NoSuchMethodException, ClassNotFoundException {
//        setTestResult(result);
//        var testClass = this.getClass();
//        var methodInfo = testClass.getMethod(getTestResult().getMethod().getMethodName());
//        executionSubject.preTestInit(getTestResult(), methodInfo);
//        testInit();
//        executionSubject.postTestInit(getTestResult(), methodInfo);
//    }
//
//    @AfterMethod
//    public void afterMethod() throws NoSuchMethodException {
//        var testClass = this.getClass();
//        var methodInfo = testClass.getMethod(getTestResult().getMethod().getMethodName());
//        executionSubject.preTestCleanup(getTestResult(), methodInfo);
//        testCleanup();
//        executionSubject.postTestCleanup(getTestResult(), methodInfo);
//    }
//
//    protected void testInit() {
//    }
//
//    protected void testCleanup() {
//    }
//}

// Thread-safe version.
public class BaseTest {
    private static final ThreadLocal<TestExecutionSubject> executionSubject;
    private static final ThreadLocal<Driver> driver;
    private ITestResult result;

    static {
        executionSubject = new ThreadLocal<>();
        executionSubject.set(new ExecutionSubject());
        driver = new ThreadLocal<>();
        driver.set(new LoggingDriver(new WebCoreDriver()));
        new BrowserLaunchTestBehaviorObserver(executionSubject.get(), driver.get());
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
        return driver.get();
    }

    @AfterSuite
    public void afterSuite() {
        if (driver.get() != null) {
            driver.get().quit();
        }
    }

    @BeforeMethod
    public void beforeMethod(ITestResult result) throws NoSuchMethodException, ClassNotFoundException {
        setTestResult(result);
        var testClass = this.getClass();
        var methodInfo = testClass.getMethod(getTestResult().getMethod().getMethodName());
        executionSubject.get().preTestInit(getTestResult(), methodInfo);
        testInit();
        executionSubject.get().postTestInit(getTestResult(), methodInfo);
    }

    @AfterMethod
    public void afterMethod() throws NoSuchMethodException {
        var testClass = this.getClass();
        var methodInfo = testClass.getMethod(getTestResult().getMethod().getMethodName());
        executionSubject.get().preTestCleanup(getTestResult(), methodInfo);
        testCleanup();
        executionSubject.get().postTestCleanup(getTestResult(), methodInfo);
    }

    protected void testInit() {
    }

    protected void testCleanup() {
    }
}
