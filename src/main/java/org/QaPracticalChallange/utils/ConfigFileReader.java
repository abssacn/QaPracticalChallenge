package org.QaPracticalChallange.utils;

import lombok.NonNull;

import java.util.Optional;
import java.util.ResourceBundle;

public class ConfigFileReader {

    private ResourceBundle rb = ResourceBundle.getBundle("configuration");
    private static ConfigFileReader configFileReader = new ConfigFileReader();

    /**
     * Retrieve value from properties file
     *
     * @param propertyKey
     *            key to search for in the properties file
     * @return keys value
     */
    public String getPropertyValue(final @NonNull String propertyKey) {
        String value = rb.getString(propertyKey);
        Optional<String> propertyValue = Optional.of(value);
        return propertyValue.filter(c -> !propertyValue.get().isEmpty()).get();

    }

    /**
     * Get preferred browser
     *
     * @return preferred browser
     */
    public SeleniumDrivers.Browsers getBrowser() {
        String browserName = getPropertyValue("browser");
        switch (browserName) {
        case "chrome":
            return SeleniumDrivers.Browsers.Chrome;

        case "firefox":
            return SeleniumDrivers.Browsers.Firefox;

        case "iexplorer":
            return SeleniumDrivers.Browsers.InternetExplorer;

        case "safari":
            return SeleniumDrivers.Browsers.Safari;

        case "edge":
            return SeleniumDrivers.Browsers.Edge;

        case "headless":
            return SeleniumDrivers.Browsers.Headless;

        default:
            throw new IllegalArgumentException("Invalid browser selected");

        }

    }
    public String getReportConfigPath(){
        String reportConfigPath = configFileReader.getPropertyValue("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

}
