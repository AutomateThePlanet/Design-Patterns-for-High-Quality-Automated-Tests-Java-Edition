package reusebrowsercleansession.browserinfrastructure;

import org.testng.ITestResult;

import java.lang.reflect.Method;

public interface TestBehaviorObserver {
    void preTestInit(ITestResult testResult, Method memberInfo);

    void postTestInit(ITestResult testResult, Method memberInfo);

    void preTestCleanup(ITestResult testResult, Method memberInfo);

    void postTestCleanup(ITestResult testResult, Method memberInfo);

    void testInstantiated(Method memberInfo);
}
