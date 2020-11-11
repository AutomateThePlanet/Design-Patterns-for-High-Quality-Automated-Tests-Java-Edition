package configuration;

public class UrlSettings {
    private String shopUrl;
    private String accountUrl;

    public String getShopUrl() {
        return shopUrl;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    @Override
    public String toString() {
        return "UrlSettings{" +
                "shopUrl='" + shopUrl + '\'' +
                ", accountUrl='" + accountUrl + '\'' +
                '}';
    }
}
