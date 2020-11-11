package configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class WebSettings {
    private  String baseUrl;
    private  BrowserSettings chrome;
    private  BrowserSettings firefox;
    private  BrowserSettings edge;
    private  BrowserSettings opera;
    private  BrowserSettings internetExplorer;
    private  BrowserSettings safari;
    private  int elementWaitTimeout;

    public String getBaseUrl() {
        return baseUrl;
    }

    public BrowserSettings getChrome() {
        return chrome;
    }

    public BrowserSettings getFirefox() {
        return firefox;
    }

    public BrowserSettings getEdge() {
        return edge;
    }

    public BrowserSettings getOpera() {
        return opera;
    }

    public BrowserSettings getInternetExplorer() {
        return internetExplorer;
    }

    public BrowserSettings getSafari() {
        return safari;
    }

    public int getElementWaitTimeout() {
        return elementWaitTimeout;
    }

    @Override
    public String toString() {
        return "WebSettings{" +
                "baseUrl='" + baseUrl + '\'' +
                ", chrome=" + chrome +
                ", firefox=" + firefox +
                ", edge=" + edge +
                ", opera=" + opera +
                ", internetExplorer=" + internetExplorer +
                ", safari=" + safari +
                ", elementWaitTimeout=" + elementWaitTimeout +
                '}';
    }
}
