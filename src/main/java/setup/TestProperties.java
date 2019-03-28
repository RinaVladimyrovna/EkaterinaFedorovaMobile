package setup;

import entities.PropertySets;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private Properties currentProps = new Properties();
    private String fileName;

    private Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    protected String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) {
            currentProps = getCurrentProps();
        }

        return currentProps.getProperty(propKey, null);

    }

    TestProperties(PropertySets set) {
        this.fileName = set.toString();
    }

}

