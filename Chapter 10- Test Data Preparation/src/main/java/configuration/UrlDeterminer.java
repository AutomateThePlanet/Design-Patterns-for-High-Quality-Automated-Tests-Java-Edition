package configuration;

import org.apache.hc.core5.net.URIBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class UrlDeterminer {
    public static String getShopUrl(String urlPart) throws IOException, URISyntaxException {
        return contactUrls(ConfigurationService.get(UrlSettings.class).getShopUrl(), urlPart);
    }

    public static String getAccountUrl(String urlPart) throws IOException, URISyntaxException {
        return contactUrls(ConfigurationService.get(UrlSettings.class).getAccountUrl(), urlPart);
    }

    private static String contactUrls(String url, String part) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(url);
        URI uri = uriBuilder.setPath(uriBuilder.getPath() + part)
                .build()
                .normalize();
        return uri.toString();
    }
}
