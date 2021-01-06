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
