package configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigurationService {
    private static String _environment;

    public static <T> T get(Class<T> configSection) throws IOException {
        if (_environment == null) {
            String environmentOverride = System.getProperty("environment");
            if (environmentOverride == null) {
                InputStream input = ConfigurationService.class.getResourceAsStream("/application.properties");
                var p = new Properties();
                p.load(input);
                _environment = p.getProperty("environment");
            }
           else {
                _environment =environmentOverride;
            }
        }

        String fileName = String.format("testFrameworkSettings.%s.json", _environment);
        String jsonFileContent = getFileAsString(fileName);
        String sectionName = getSectionName(configSection);


        var jsonObject = JsonParser.parseString(jsonFileContent).getAsJsonObject().get(sectionName).toString();

        Gson gson = new Gson();
        T mappedObject = null;
        try {
            mappedObject= gson.fromJson(jsonObject, configSection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mappedObject;
    }

    public static String getSectionName(Class<?> configSection)
    {
        StringBuilder sb = new StringBuilder(configSection.getSimpleName());
        sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
        return sb.toString();
    }

    public static String getFileAsString(String fileName) {
        try {
            InputStream input = ConfigurationService.class.getResourceAsStream("/" + fileName);
            return IOUtils.toString(input, StandardCharsets.UTF_8);
        } catch (IOException e) {
            // TODO Do all that you need to do if couldn't read a file
            return null;
        }
    }
}