package earth.mail.send;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EmailSenderData {
    private Properties hostEmailData;

    public EmailSenderData(String configFile) {
        hostEmailData = new Properties();
        loadConfigFile(configFile);
    }

    private void loadConfigFile(String configFile) {
        File propsFile = new File(configFile);
        FileInputStream fis;
        try {
            fis = new FileInputStream(propsFile);
            hostEmailData.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSmpt() {
        return getProperty("mailServerHost");
    }

    public String getMailServerPort() {
        return getProperty("mailServerPort");
    }

    public String getFromAddress() {
        return getProperty("fromAddress");
    }

    private String getProperty(String key) {
        String value = hostEmailData.getProperty(key);
        if (value == null) {
            value = "";
        }
        return value;
    }

}
