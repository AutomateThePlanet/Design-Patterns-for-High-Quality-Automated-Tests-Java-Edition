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

package core.wait;

public class WaitStrategyFactory {
    public ToExistsWaitStrategy exists() {
        return new ToExistsWaitStrategy(30, 2);
    }

    public ToExistsWaitStrategy exists(int timeoutInterval, int sleepInterval) {
        return new ToExistsWaitStrategy(timeoutInterval, sleepInterval);
    }

    public ToBeVisibleWaitStrategy beVisible(int timeoutInterval, int sleepInterval) {
        return new ToBeVisibleWaitStrategy(timeoutInterval, sleepInterval);
    }

    public ToBeVisibleWaitStrategy beVisible() {
        return new ToBeVisibleWaitStrategy(30, 2);
    }

    public ToBeClickableWaitStrategy beClickable(int timeoutInterval, int sleepInterval) {
        return new ToBeClickableWaitStrategy(timeoutInterval, sleepInterval);
    }

    public ToBeClickableWaitStrategy beClickable() {
        return new ToBeClickableWaitStrategy(30, 2);
    }
}
