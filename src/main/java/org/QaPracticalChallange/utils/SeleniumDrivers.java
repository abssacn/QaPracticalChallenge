package org.QaPracticalChallange.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

public class SeleniumDrivers {
    public enum Browsers {
        Firefox, Chrome, InternetExplorer, Safari, Edge, Headless
    }

    // this is the driver that will be used for all selenium actions
    public static WebDriver driver;
    private ConfigFileReader configFileReader = new ConfigFileReader();

    // constructor, determining which browser to start with
    public SeleniumDrivers(final Browsers browser) throws Exception {
        switch (browser) { // check our browser
        case Firefox:
            System.setProperty("webdriver.gecko.driver", configFileReader.getPropertyValue("browserDriversPath") + "geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().window().fullscreen();
            break;
        case Chrome:
            if (configFileReader.getPropertyValue("os").equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", configFileReader.getPropertyValue("browserDriversPath") + "chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                options.addArguments("--disable-extensions");
                options.addArguments("test-type");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
                driver.manage().window().fullscreen();
            } else if (configFileReader.getPropertyValue("os").equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", configFileReader.getPropertyValue("browserDriversPath") + "chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            break;

        case Headless:
            // Set the chrome driver
            System.setProperty("webdriver.chrome.driver", configFileReader.getPropertyValue("browserDriversPath") + "chromedriver");
            // Create Object of ChromeOption Class
            ChromeOptions option = new ChromeOptions();
            // Set the setHeadless is equal to true which will run test in Headless mode
            option.setHeadless(true);
            // pass the option object in ChromeDriver constructor
            driver = new ChromeDriver(option);
            break;

        case InternetExplorer:
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            break;
        // if our browser is not listed, throw an error
        default:
            throw new Exception();

        }
        // open a new driver instance to our application URL
    }

    public static void navigateToURL(final String appURL) {
        driver.get(appURL);
    }

    // a method to allow retrieving our driver instance
    public WebDriver getDriver() {
        return driver;
    }
}
