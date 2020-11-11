package configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Props {

    @Value("${host}")
    private String host;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    public String getHost() { return host; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }
}
