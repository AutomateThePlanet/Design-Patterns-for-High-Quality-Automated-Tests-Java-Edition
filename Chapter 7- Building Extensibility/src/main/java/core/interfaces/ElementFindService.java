package core.interfaces;

import core.Element;
import org.openqa.selenium.By;

import java.util.List;

public interface ElementFindService {
    Element findElement(By locator);
    List<Element> findElements(By locator);
}
