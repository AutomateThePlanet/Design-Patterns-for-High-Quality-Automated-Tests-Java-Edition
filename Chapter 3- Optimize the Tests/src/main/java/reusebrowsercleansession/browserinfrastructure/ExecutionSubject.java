package reusebrowsercleansession.browserinfrastructure;

import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExecutionSubject implements TestExecutionSubject {
    private final List<TestBehaviorObserver> _testBehaviorObservers;

    public ExecutionSubject() {
        _testBehaviorObservers = new ArrayList<>();
    }

    @Override
    public void attach(TestBehaviorObserver observer) {
        _testBehaviorObservers.add(observer);
    }

    @Override
    public void detach(TestBehaviorObserver observer) {
        _testBehaviorObservers.remove(observer);
    }

    @Override
    public void preTestInit(ITestResult result, Method memberInfo) {
        for (var currentObserver:_testBehaviorObservers) {
            currentObserver.preTestInit(result, memberInfo);
        }
    }

    @Override
    public void postTestInit(ITestResult result, Method memberInfo) {
        for (var currentObserver:_testBehaviorObservers) {
            currentObserver.postTestInit(result, memberInfo);
        }
    }

    @Override
    public void preTestCleanup(ITestResult result, Method memberInfo) {
        for (var currentObserver:_testBehaviorObservers) {
            currentObserver.preTestCleanup(result, memberInfo);
        }
    }

    @Override
    public void postTestCleanup(ITestResult result, Method memberInfo) {
        for (var currentObserver:_testBehaviorObservers) {
            currentObserver.postTestCleanup(result, memberInfo);
        }
    }

    @Override
    public void testInstantiated(Method memberInfo) {
        for (var currentObserver:_testBehaviorObservers) {
            currentObserver.testInstantiated(memberInfo);
        }
    }
}
