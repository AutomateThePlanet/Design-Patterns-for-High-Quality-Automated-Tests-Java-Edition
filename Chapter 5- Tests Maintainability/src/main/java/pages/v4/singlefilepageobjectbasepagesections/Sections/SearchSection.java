package pages.v4.singlefilepageobjectbasepagesections.Sections;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class SearchSection {
    private final Driver _driver;

    public SearchSection(Driver driver) {
        _driver = driver;
    }

    private Element searchField() {
        return _driver.findElement(By.id("woocommerce-product-search-field-0"));
    }

    public void searchForItem(String searchText) throws InterruptedException {
        searchField().typeText(searchText);
    }
}
