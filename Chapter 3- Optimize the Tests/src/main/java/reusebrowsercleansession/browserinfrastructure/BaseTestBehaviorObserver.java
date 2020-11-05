package reusebrowsercleansession.browserinfrastructure;

import org.testng.ITestResult;

import java.lang.reflect.Method;

public class BaseTestBehaviorObserver implements TestBehaviorObserver {
    private final TestExecutionSubject _testExecutionSubject;

    public BaseTestBehaviorObserver(TestExecutionSubject testExecutionSubject) {
        _testExecutionSubject = testExecutionSubject;
        testExecutionSubject.attach(this);
    }

    @Override
    public void preTestInit(ITestResult testResult, Method memberInfo) {
    }

    @Override
    public void postTestInit(ITestResult testResult, Method memberInfo) {
    }

    @Override
    public void preTestCleanup(ITestResult testResult, Method memberInfo) {
    }

    @Override
    public void postTestCleanup(ITestResult testResult, Method memberInfo) {
    }

    @Override
    public void testInstantiated(Method memberInfo) {
    }
}
