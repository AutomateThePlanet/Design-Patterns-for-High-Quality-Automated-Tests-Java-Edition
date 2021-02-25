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

import core.Driver;
import core.WebCoreDriver;
import org.openjdk.jmh.annotations.*;

@State(Scope.Thread)
public class BaseBenchmark {
    private Class<?> currentClass;

    @State(Scope.Thread)
    public static class PluginState {
        private static TestExecutionSubject _currentTestExecutionSubject;
        private static Driver _driver;

        @Setup(Level.Trial)
        public void doSetup() {
            _currentTestExecutionSubject = new ExecutionSubject();
            //_driver = new LoggingDriver(new WebCoreDriver());
            _driver = new WebCoreDriver();
            new BrowserLaunchTestBehaviorObserver(_currentTestExecutionSubject, _driver);
        }

        @TearDown(Level.Trial)
        public void doTearDown() {
            if (getDriver() != null) {
                System.out.println("Do TearDown");
                getDriver().quit();
            }
        }

        public static TestExecutionSubject getCurrentTestExecutionSubject() {
            return _currentTestExecutionSubject;
        }

        public static Driver getDriver() {
            return _driver;
        }
    }

    public void setCurrentClass(Class<?> currentClass) {
        this.currentClass = currentClass;
    }

    @Setup(Level.Invocation)
    public void setup(PluginState pluginState) throws NoSuchMethodException, ClassNotFoundException {
        PluginState.getCurrentTestExecutionSubject().preTestInit(currentClass);
        init(PluginState.getDriver());
        PluginState.getCurrentTestExecutionSubject().postTestInit(currentClass);
    }

    @TearDown(Level.Invocation)
    public void tearDown(PluginState pluginState) {
        PluginState.getCurrentTestExecutionSubject().preTestCleanup(currentClass);
        cleanup(PluginState.getDriver());
        PluginState.getCurrentTestExecutionSubject().postTestCleanup(currentClass);
    }

    public void init(Driver driver) {
    }

    public void cleanup(Driver driver) {
    }
}
