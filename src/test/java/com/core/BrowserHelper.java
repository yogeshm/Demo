package com.core;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserHelper {

  public String getBrowserInfo(WebDriver driver) {
    Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
    String b = cap.getBrowserName();
    String os = cap.getPlatform().toString();
    String v = cap.getVersion();
    return String.format("%s v:%s %s", b, v, os);
  }

  public void maximiseBrowser(WebDriver driver) {
    String w = "return screen.availWidth";
    String h = "return screen.availHeight";
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    int width = ((Long) executor.executeScript(w)).intValue();
    int height = ((Long) executor.executeScript(h)).intValue();
    Dimension targetSize = new Dimension(width, height);
    driver.manage().window().setSize(targetSize);
  }

  public void deleteCookies(WebDriver driver) {
    driver.manage().deleteAllCookies();
  }

  public void closeBrowser(){
  driver.close();
  }

}
