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

package instrumentedcode;

import org.openqa.selenium.By;

public class LogElement extends ElementDecorator {

    protected LogElement(Element element) {
        super(element);
    }

    @Override
    public By getBy() {
        return Element.getBy();
    }

    @Override
    public String getText() {
        System.out.print(String.format("Element Text = %s", Element.getText()));
        return Element.getText();
    }

    @Override
    public Boolean isEnabled() {
        System.out.print(String.format("Element Enabled = %b", Element.isEnabled()));
        return Element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        System.out.print(String.format("Element Displayed = %b", Element.isDisplayed()));
        return Element.isDisplayed();
    }

    @Override
    public void typeText(String text) throws InterruptedException {
        System.out.print(String.format("Type Text = = %s", text));
        Element.typeText(text);
    }

    @Override
    public void click() {
        System.out.print("Element Clicked");
        Element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        System.out.print("Element Clicked");
        return Element.getAttribute(attributeName);
    }
}
