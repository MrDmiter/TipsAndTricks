package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;

public class YamlParser {
    /**
     * Parse yaml file
     *
     * @return
     */
    public static YamlFile getYamlFile() {
        YamlFile file = null;
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            file = mapper.readValue(new File("src/main/resources/data.yaml"), YamlFile.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
