package configuration;

import java.io.Serializable;

public class User implements Serializable {
    private long id;
    private String id_str;
    private String name;
    private String description;
    private String screen_name;
    private String url;
    private String location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", id_str='" + id_str + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", screen_name='" + screen_name + '\'' +
                ", url='" + url + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
