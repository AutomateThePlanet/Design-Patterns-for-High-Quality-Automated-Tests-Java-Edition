package configuration;

import core.Browser;
import multifilepageobjectpagesectionsappfluent.App;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppInitializer {
    @Bean
    public App getApp() {
        return new App(Browser.Chrome);
    }

    @Bean
    public Props getProps() {
        return new Props();
    }
}
