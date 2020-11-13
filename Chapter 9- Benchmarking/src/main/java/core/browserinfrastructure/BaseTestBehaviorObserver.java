package core.browserinfrastructure;

import org.testng.ITestResult;

import java.lang.reflect.Method;

public class BaseTestBehaviorObserver implements TestBehaviorObserver{
    private final TestExecutionSubject _testExecutionSubject;

    public BaseTestBehaviorObserver(TestExecutionSubject testExecutionSubject) {
        _testExecutionSubject = testExecutionSubject;
        testExecutionSubject.attach(this);
    }

    @Override
    public void preTestInit(Class<?> currentClass) {
    }

    @Override
    public void postTestInit(Class<?> currentClass) {
    }

    @Override
    public void preTestCleanup(Class<?> currentClass) {
    }

    @Override
    public void postTestCleanup(Class<?> currentClass) {
    }

    @Override
    public void testInstantiated(Class<?> currentClass) {
    }
}
