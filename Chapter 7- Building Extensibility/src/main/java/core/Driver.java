package core;

import core.interfaces.*;
import core.locators.FindStrategy;
import org.openqa.selenium.By;

import java.util.List;

public abstract class Driver implements NavigationService, BrowserService, CookiesService, ElementFindService, DialogService {
    public abstract void start(Browser browser);
    public abstract void quit();
    public abstract void goToUrl(String url);
    public abstract void waitForAjax();
    public abstract void waitUntilPageLoadsCompletely();

    public abstract Element findById(String id);
    public abstract Element findByXPath(String xpath);
    public abstract Element findByTag(String tag);
    public abstract Element findByClass(String cssClass);
    public abstract Element findByCss(String css);
    public abstract Element findByLinkText(String linkText);
    public abstract List<Element> findAllById(String id);
    public abstract List<Element> findAllByXPath(String xpath);
    public abstract List<Element> findAllByTag(String tag);
    public abstract List<Element> findAllByClass(String cssClass);
    public abstract List<Element> findAllByCss(String css);
    public abstract List<Element> findAllByLinkText(String linkText);

    public abstract List<Element> findAll(FindStrategy findStrategy);
    public abstract Element find(FindStrategy findStrategy);
}
