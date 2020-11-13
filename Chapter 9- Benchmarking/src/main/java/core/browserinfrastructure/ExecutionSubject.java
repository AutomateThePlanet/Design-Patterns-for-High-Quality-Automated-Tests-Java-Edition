package core.browserinfrastructure;

import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExecutionSubject implements TestExecutionSubject{
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
    public void preTestInit(Class<?> currentClass) {
        for (var currentObserver:_testBehaviorObservers) {
            currentObserver.preTestInit(currentClass);
        }
    }

    @Override
    public void postTestInit(Class<?> currentClass) {
        for (var currentObserver:_testBehaviorObservers) {
            currentObserver.postTestInit(currentClass);
        }
    }

    @Override
    public void preTestCleanup(Class<?> currentClass) {
        for (var currentObserver:_testBehaviorObservers) {
            currentObserver.preTestCleanup(currentClass);
        }
    }

    @Override
    public void postTestCleanup(Class<?> currentClass) {
        for (var currentObserver:_testBehaviorObservers) {
            currentObserver.postTestCleanup(currentClass);
        }
    }

    @Override
    public void testInstantiated(Class<?> currentClass) {
        for (var currentObserver:_testBehaviorObservers) {
            currentObserver.testInstantiated(currentClass);
        }
    }
}
