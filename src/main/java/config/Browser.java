package config;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.TextCheck;
import com.codeborne.selenide.WebDriverRunner;
import java.util.List;
import java.util.logging.Level;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class Browser {

  public static void setBrowser() {
    var selenideConfig = new SelenideConfig();
    selenideConfig.browser("chrome");
    selenideConfig.browserSize("1920x1080");
    selenideConfig.pageLoadStrategy("normal");
    selenideConfig.pageLoadTimeout(15000);
    selenideConfig.timeout(10000);
    selenideConfig.textCheck(TextCheck.FULL_TEXT);
    // selenideConfig.remote("http://8.8.8.8:4444/wd/hub"); // Use for Selenoid

    // "Selenide driver" is a container for WebDriver + proxy server + settings
    var selenideDriver = new SelenideDriver(selenideConfig);

    // Tell Selenide use your provided WebDriver instance. Use it if you need a custom logic for creating WebDriver.
    // When using your custom webdriver, you are responsible for closing it. Selenide will not take care of it.
    WebDriverRunner.setWebDriver(selenideDriver.getAndCheckWebDriver());
  }

  public static void closeBrowser() {
    WebDriverRunner.closeWebDriver();
  }

  public static Boolean isVerticalScrollPresent() {
    long pageHeight = Selenide.executeJavaScript("return document.body.scrollHeight");
    long windowHeight = Selenide.executeJavaScript("return window.innerHeight;");
    return pageHeight > windowHeight;
  }

  public static Boolean isHorizontalScrollPresent() {
    long pageWidth = Selenide.executeJavaScript("return document.body.scrollWidth");
    long windowWidth = Selenide.executeJavaScript("return window.innerWidth;");
    return pageWidth > windowWidth;
  }

  public static List<LogEntry> getLogs() {
    return WebDriverRunner.getWebDriver().manage().logs().get(LogType.BROWSER).getAll();
  }

  public static List<LogEntry> getLogsByLevel(Level logLevel) {
    var logs = getLogs();
    return logs.stream().filter(logEntry -> logLevel.equals(logEntry.getLevel())).toList();
  }
}
