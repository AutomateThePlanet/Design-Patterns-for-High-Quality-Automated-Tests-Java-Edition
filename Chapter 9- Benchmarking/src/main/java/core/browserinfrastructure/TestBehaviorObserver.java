package core.browserinfrastructure;

public interface TestBehaviorObserver {
    void preTestInit(Class<?> currentClass);

    void postTestInit(Class<?> currentClass);

    void preTestCleanup(Class<?> currentClass);

    void postTestCleanup(Class<?> currentClass);

    void testInstantiated(Class<?> currentClass);
}
