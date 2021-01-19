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
import facadedesignpattern.classic.EShopPage;
import facadedesignpattern.classic.PurchaseInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends EShopPage {

    public CheckoutPage(Driver driver)
    {
        super(driver);
    }

    public CheckoutElements elements() {
        return new CheckoutElements(driver);
    }

    public CheckoutAssertions assertions() {
        return new CheckoutAssertions(elements());
    }

    public void fillBillingInfo(PurchaseInfo purchaseInfo) throws InterruptedException {
        elements().billingFirstName().typeText(purchaseInfo.getFirstName());
        elements().billingLastName().typeText(purchaseInfo.getLastName());
        elements().billingCompany().typeText(purchaseInfo.getCompany());
        elements().billingCountryWrapper().click();
        elements().billingCountryFilter().typeText(purchaseInfo.getCountry());
        elements().getCountryOptionByName(purchaseInfo.getCountry()).click();
        elements().billingAddress1().typeText(purchaseInfo.getAddress1());
        elements().billingAddress2().typeText(purchaseInfo.getAddress2());
        elements().billingCity().typeText(purchaseInfo.getCity());
        elements().billingZip().typeText(purchaseInfo.getZip());
        elements().billingPhone().typeText(purchaseInfo.getPhone());
        elements().billingEmail().typeText(purchaseInfo.getEmail());
        if (purchaseInfo.getShouldCreateAccount()) {
            waitForBlockUiOverlayNotDisplayed();
            elements().createAccountCheckBox().click();
        }

        if (purchaseInfo.getShouldCheckPayment()) {
            waitForBlockUiOverlayNotDisplayed();
            elements().checkPaymentsRadioButton().click();
        }

        driver.waitForAjax();
        waitForBlockUiOverlayNotDisplayed();
        elements().placeOrderButton().click();
        driver.waitForAjax();
    }

    private void waitForBlockUiOverlayNotDisplayed() {
        driver.getBrowserWait().until(ExpectedConditions.invisibilityOfElementLocated(elements().blockUiOverlay().getBy()));
    }
}
