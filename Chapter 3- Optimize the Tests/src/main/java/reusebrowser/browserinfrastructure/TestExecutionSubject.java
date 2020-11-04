package reusebrowser.browserinfrastructure;

import org.testng.ITestResult;
import java.lang.reflect.Method;

public interface TestExecutionSubject {
    void attach(TestBehaviorObserver observer);

    void detach(TestBehaviorObserver observer);

    void preTestInit(ITestResult result, Method memberInfo);

    void postTestInit(ITestResult result, Method memberInfo);

    void preTestCleanup(ITestResult result, Method memberInfo);

    void postTestCleanup(ITestResult result, Method memberInfo);

    void testInstantiated(Method memberInfo);
}
