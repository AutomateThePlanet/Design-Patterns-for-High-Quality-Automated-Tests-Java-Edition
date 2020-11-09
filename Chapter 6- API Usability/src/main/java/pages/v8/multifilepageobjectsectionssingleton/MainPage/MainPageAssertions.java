package pages.v8.multifilepageobjectsectionssingleton.MainPage;

import org.testng.Assert;

public class MainPageAssertions {
    private final MainPageElements _elements;

    public MainPageAssertions(MainPageElements mainPageElements) {
        _elements = mainPageElements;
    }

    public void assertProductBoxLink(String name, String expectedLink)
    {
        var actualLink = _elements.getProductBoxByName(name).getAttribute("href");
        Assert.assertEquals(actualLink, expectedLink);
    }
}
