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

package facadedesignpattern.templatemethods.CheckoutPage;

import org.testng.Assert;

public class CheckoutAssertions {
    private final CheckoutElements elements;

    public CheckoutAssertions(CheckoutElements elements) {
        this.elements = elements;
    }

    public void assertOrderReceived() {
        Assert.assertEquals(elements.receivedMessage().getText(), "Order received");
    }
}
