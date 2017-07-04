package util;

import models.ui.Config;
import models.ui.TestData;
import org.yaml.snakeyaml.Yaml;

/**
 * Created by chandanjavaregowda on 03/04/17.
 */
public class YamlReader {
    private String filePath;

    public YamlReader(String filePath) {
        this.filePath = filePath;
    }

    public Config readConfig() {
        return new Yaml().loadAs(FileReader.read(filePath), Config.class);
    }

    public TestData readTestData() {
        return new Yaml().loadAs(FileReader.read(filePath), TestData.class);
    }
}
