package facades.CheckoutPage;

import core.Driver;
import facades.EShopPage;
import facades.PurchaseInfo;

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
        if (purchaseInfo.getShouldCreateAccount())
        {
            elements().createAccountCheckBox().click();
        }

        if (purchaseInfo.getShouldCheckPayment())
        {
            elements().checkPaymentsRadioButton().click();
        }

        elements().placeOrderButton().click();
        driver.waitForAjax();
    }
}
