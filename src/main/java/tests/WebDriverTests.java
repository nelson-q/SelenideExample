package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.Browser;
import config.PageUrl;
import java.util.logging.Level;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.PaymentPage;
import org.testng.annotations.Test;

public class WebDriverTests {

  private final PaymentPage paymentPage = new PaymentPage();
  private static final String PAYMENT_PAGE_URL = PageUrl.PAYMENT_PAGE_1.url;

  @BeforeTest
  public void setUpBrowser() {
    Browser.setBrowser();
  }

  @Test
  public void checkPaymentPageUrl() {
    Selenide.open(PAYMENT_PAGE_URL);
    paymentPage.assertIsOpened();
    var currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
    Assert.assertEquals(currentUrl, PAYMENT_PAGE_URL);
  }

  @Test
  public void changePaymentPageCookies() {
    Selenide.open(PAYMENT_PAGE_URL);
    paymentPage.assertIsOpened();

    WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("name", "value"));
    WebDriverRunner.getWebDriver().manage().deleteCookieNamed("name");
    //   WebDriverRunner.getWebDriver().manage().deleteAllCookies();
  }

  @Test
  public void checkBrowserLogs() {
    Selenide.open(PAYMENT_PAGE_URL);
    paymentPage.assertIsOpened();
    paymentPage.cardNumberInput.setValue("4444444444444441");

    // var warningLogs = Browser.getLogsByLevel(Level.WARNING);
    var errorLogs = Browser.getLogsByLevel(Level.SEVERE);
    Assert.assertTrue(errorLogs.isEmpty());
  }

  @AfterTest
  public void tearDownBrowser() {
    Browser.closeBrowser();
  }
}
