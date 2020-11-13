package core.browserinfrastructure;

import org.testng.ITestResult;

import java.lang.reflect.Method;

public interface TestExecutionSubject {
    void attach(TestBehaviorObserver observer);

    void detach(TestBehaviorObserver observer);

    void preTestInit(Class<?> currentClass);

    void postTestInit(Class<?> currentClass);

    void preTestCleanup(Class<?> currentClass);

    void postTestCleanup(Class<?> currentClass);

    void testInstantiated(Class<?> currentClass);
}
