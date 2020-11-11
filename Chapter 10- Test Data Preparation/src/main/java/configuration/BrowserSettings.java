package configuration;

public class BrowserSettings {
    private int pageLoadTimeout;
    private int scriptTimeout;

    public int getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public int getScriptTimeout() {
        return scriptTimeout;
    }

    @Override
    public String toString() {
        return "BrowserSettings{" +
                "pageLoadTimeout=" + pageLoadTimeout +
                ", scriptTimeout=" + scriptTimeout +
                '}';
    }
}
