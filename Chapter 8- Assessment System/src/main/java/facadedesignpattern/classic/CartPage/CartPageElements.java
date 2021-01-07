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

package facadedesignpattern.classic.CartPage;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class CartPageElements {
    private final Driver driver;

    public CartPageElements(Driver driver) {
        this.driver = driver;
    }

    public Element couponCodeTextField() {
        return driver.findElement(By.id("coupon_code"));
    }

    public Element applyCouponButton() {
        return driver.findElement(By.cssSelector("[value*='Apply coupon']"));
    }

    public Element quantityBox() {
        return driver.findElement(By.cssSelector("[class*='input-text qty text']"));
    }

    public Element updateCart() {
        return driver.findElement(By.cssSelector("[value*='Update cart']"));
    }

    public Element messageAlert() {
        return driver.findElement(By.cssSelector("[class*='woocommerce-message']"));
    }

    public Element totalSpan() {
        return driver.findElement(By.xpath("//*[@class='order-total']//span"));
    }

    public Element proceedToCheckout() {
        return driver.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
    }
}
