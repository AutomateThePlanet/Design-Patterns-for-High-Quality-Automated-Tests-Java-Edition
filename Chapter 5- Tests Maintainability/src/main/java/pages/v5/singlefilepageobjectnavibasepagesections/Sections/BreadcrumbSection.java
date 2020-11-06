package pages.v5.singlefilepageobjectnavibasepagesections.Sections;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class BreadcrumbSection {
    private final Driver _driver;

    public BreadcrumbSection(Driver driver) {
        _driver = driver;
    }

    private Element breadcrumb() {
        return _driver.findElement(By.className("woocommerce-breadcrumb"));
    }

    public void openBreadcrumbItem(String itemToOpen)
    {
        breadcrumb().findElement(By.linkText(itemToOpen)).click();
    }
}
