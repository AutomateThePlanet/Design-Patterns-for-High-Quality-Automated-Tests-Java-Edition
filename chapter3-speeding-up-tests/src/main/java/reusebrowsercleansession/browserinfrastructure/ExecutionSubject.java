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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExecutionSubject implements TestExecutionSubject {
    private final List<TestBehaviorObserver> testBehaviorObservers;

    public ExecutionSubject() {
        testBehaviorObservers = new ArrayList<>();
    }

    @Override
    public void attach(TestBehaviorObserver observer) {
        testBehaviorObservers.add(observer);
    }

    @Override
    public void detach(TestBehaviorObserver observer) {
        testBehaviorObservers.remove(observer);
    }

    @Override
    public void preTestInit(ITestResult result, Method memberInfo) {
        // Java 8 using streams.
        // testBehaviorObservers.forEach(o -> o.preTestInit(result, memberInfo));
        for (var currentObserver : testBehaviorObservers) {
            currentObserver.preTestInit(result, memberInfo);
        }
    }

    @Override
    public void postTestInit(ITestResult result, Method memberInfo) {
        for (var currentObserver : testBehaviorObservers) {
            currentObserver.postTestInit(result, memberInfo);
        }
    }

    @Override
    public void preTestCleanup(ITestResult result, Method memberInfo) {
        for (var currentObserver : testBehaviorObservers) {
            currentObserver.preTestCleanup(result, memberInfo);
        }
    }

    @Override
    public void postTestCleanup(ITestResult result, Method memberInfo) {
        for (var currentObserver : testBehaviorObservers) {
            currentObserver.postTestCleanup(result, memberInfo);
        }
    }

    @Override
    public void testInstantiated(Method memberInfo) {
        for (var currentObserver : testBehaviorObservers) {
            currentObserver.testInstantiated(memberInfo);
        }
    }
}
