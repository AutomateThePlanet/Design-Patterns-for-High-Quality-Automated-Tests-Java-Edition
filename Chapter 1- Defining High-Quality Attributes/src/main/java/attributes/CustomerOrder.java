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

package main.java.attributes;

import java.io.IOException;

public class CustomerOrder {
    private final FileLogger fileLogger = new FileLogger();

    public void create() throws IOException {
        try {
            // Database code goes here
        } catch (Exception ex) {
            fileLogger.createLogEntry(ex.getLocalizedMessage());
        }
    }
}
