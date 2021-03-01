package org.QaPracticalChallange.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Slf4j
public class SeleniumDriverMethods {

    private static SeleniumDrivers seleniumDrivers;
    private static ConfigFileReader configFileReader = new ConfigFileReader();
    public static WebDriver driver;
    private static SeleniumDrivers.Browsers browserName = configFileReader.getBrowser();

    public static void launchBrowser() throws Exception {
        seleniumDrivers = new SeleniumDrivers(browserName);
        driver = seleniumDrivers.getDriver();
    }

    public static boolean isDisplayedByXpath(final String xpathStr) {
        boolean status = false;
        try {
            WebElement element = driver.findElement(By.xpath(xpathStr));
            status = element.isDisplayed();
            log.info("Element " + xpathStr + " is displayed " + status);
            return status;
        } catch (Exception e) {
            log.info("Unable to Find Element : " + xpathStr);
            return status;
        }
    }

    public static void tearDown() {
        try {
                log.info("Ending Browser Session");
                driver.quit();
                log.info("Browser Session Ended");
        } catch (Exception e) {
            log.info("No webdriver open");
        }
    }

}
