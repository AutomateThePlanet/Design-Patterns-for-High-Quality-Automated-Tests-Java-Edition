package pages.v9.multifilepageobjectpagesectionsapp.MainPage;

import core.Element;
import core.ElementFindService;
import org.openqa.selenium.By;

public class MainPageElements {
    private final ElementFindService _elementFindService;

    public MainPageElements(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    public Element addToCartFalcon9() {
        return _elementFindService.findElement(By.cssSelector("[data-product_id*='28']"));
    }

    public Element viewCartButton() {
        return _elementFindService.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
    }

    public Element getProductBoxByName(String name)
    {
        return _elementFindService.findElement(By.xpath(String.format("//h2[text()='%s']/parent::a[1]", name)));
    }
}
