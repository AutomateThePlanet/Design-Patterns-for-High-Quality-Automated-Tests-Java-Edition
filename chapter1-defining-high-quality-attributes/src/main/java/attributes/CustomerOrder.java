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
    private final Logger logger;

    public CustomerOrder(Logger logger)
    {
        this.logger = logger;
    }

    public void create() throws IOException {
        try {
            // Database code goes here
        } catch (Exception ex) {
            logger.createLogEntry(ex.getLocalizedMessage());
        }
    }

    public void create(OrderType orderType) throws IOException {
        try {
            // Database code goes here
        } catch (Exception ex) {
            switch (orderType)
            {
                case NORMAL:
                    new SmsLogger().createLogEntry(ex.getMessage());
                    break;
                case SILVER:
                case GOLD:
                    new EmailLogger().createLogEntry(ex.getMessage());
                    break;
                case PLATINUM:
                    new FileLogger().createLogEntry(ex.getMessage());
                    break;
            }

            fileLogger.createLogEntry(ex.getLocalizedMessage());
        }
    }
}
