package org.QaPracticalChallange.actions;

import lombok.extern.slf4j.Slf4j;
import org.QaPracticalChallange.utils.ConfigFileReader;
import org.QaPracticalChallange.utils.PageObjects;
import org.QaPracticalChallange.utils.SeleniumDriverMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertEquals;

@Slf4j
public final class Actions extends SeleniumDriverMethods {
    private Actions() {

    }

    private static ConfigFileReader configFileReader = new ConfigFileReader();

    public static void Login(String username, String password) {
        try {
            driver.get(configFileReader.getPropertyValue("url"));
            driver.findElement(By.xpath(PageObjects.txt_username)).sendKeys(username);
            driver.findElement(By.xpath(PageObjects.txt_password)).sendKeys(password);
            driver.findElement(By.xpath(PageObjects.btn_login)).click();

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    public static void AddProducts() {
        driver.findElement(By.xpath(PageObjects.btn_addBackpack)).click();
        driver.findElement(By.xpath(PageObjects.btn_addOnsie)).click();
    }

    public static void verifyValueAdded() {
        driver.findElement(By.cssSelector("path")).click();
        try {
            assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath(PageObjects.btn_verifyPro1)).getText());
        } catch (Error e) {
            e.getMessage();
        }
        try {
            assertEquals("Sauce Labs Onesie", driver.findElement(By.xpath(PageObjects.btn_verifyPro2)).getText());
        } catch (Error e) {
            e.getMessage();
        }

        try {
            Thread.sleep(50);
            driver.findElement(By.cssSelector(PageObjects.btn_checkoutI)).click();
            driver.findElement(By.linkText(PageObjects.btn_checkoutII)).click();
        }catch (Exception e){
            e.getMessage();
        }


    }

    public static void enterDetails(String name, String lastname, String postalAddress){
        driver.findElement(By.id(PageObjects.txt_firstname)).sendKeys(name);
        driver.findElement(By.id(PageObjects.txt_lastname)).sendKeys(lastname);
        driver.findElement(By.id(PageObjects.txt_postalcode)).sendKeys(postalAddress);
        driver.findElement(By.xpath(PageObjects.btn_continue)).click();

    }

    public static void assertAndConfirmsOrder() throws Throwable {
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'",driver.findElement(By.xpath(PageObjects.lbl_assertAmount)));
        assertEquals("Total: $41.02", driver.findElement(By.xpath(PageObjects.lbl_assertAmount)).getText());

    }

    public static void finishOrder(){

        driver.findElement(By.linkText(PageObjects.btn_finish)).click();

    }

    public static void finaliseOrder() throws Throwable{

        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'",driver.findElement(By.xpath(PageObjects.lbl_assertOrder)));
        try {
            assertEquals("THANK YOU FOR YOUR ORDER", driver.findElement(By.xpath(PageObjects.lbl_assertOrder)).getText());
        } catch (Error e) {
            e.getMessage();
        }
    }

}
