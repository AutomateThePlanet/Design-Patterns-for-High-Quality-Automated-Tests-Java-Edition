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

package facadedesignpattern.classic.CheckoutPage;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class CheckoutElements {
    private final Driver _driver;

    public CheckoutElements(Driver driver)
    {
        _driver = driver;
    }

    public Element billingFirstName() {
        return _driver.findElement(By.id("billing_first_name"));
    }

    public Element billingLastName() {
        return _driver.findElement(By.id("billing_last_name"));
    }

    public Element billingCompany() {
        return _driver.findElement(By.id("billing_company"));
    }

    public Element billingCountryWrapper() {
        return _driver.findElement(By.id("select2-billing_country-container"));
    }

    public Element billingCountryFilter() {
        return _driver.findElement(By.className("select2-search__field"));
    }

    public Element billingAddress1() {
        return _driver.findElement(By.id("billing_address_1"));
    }

    public Element billingAddress2() {
        return _driver.findElement(By.id("billing_address_2"));
    }

    public Element billingCity() {
        return _driver.findElement(By.id("billing_city"));
    }

    public Element billingZip() {
        return _driver.findElement(By.id("billing_postcode"));
    }

    public Element billingPhone() {
        return _driver.findElement(By.id("billing_phone"));
    }

    public Element billingEmail() {
        return _driver.findElement(By.id("billing_email"));
    }

    public Element createAccountCheckBox() {
        return _driver.findElement(By.id("createaccount"));
    }

    public Element checkPaymentsRadioButton() {
        return _driver.findElement(By.cssSelector("[for*='payment_method_cheque']"));
    }

    public Element placeOrderButton() {
        return _driver.findElement(By.id("place_order"));
    }

    public Element receivedMessage() {
        return _driver.findElement(By.xpath("//h1"));
    }

    public Element getCountryOptionByName(String countryName) {
        return _driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", countryName)));
    }
}
