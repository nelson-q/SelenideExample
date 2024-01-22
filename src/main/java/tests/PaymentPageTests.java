package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.Browser;
import config.PageUrl;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PaymentPage;

public class PaymentPageTests {

  private final PaymentPage paymentPage = new PaymentPage();
  private static final String PAYMENT_PAGE_URL = PageUrl.PAYMENT_PAGE_1.url;

  @BeforeTest
  public void setUpBrowser() {
    Browser.setBrowser();
  }

  @Test
  public void openPaymentPageTest() {
    Selenide.open(PAYMENT_PAGE_URL);
    paymentPage.assertIsOpened();
  }

  @Test
  public void openPaymentPageAndRefreshPage() {
    Selenide.open(PAYMENT_PAGE_URL);
    paymentPage.assertIsOpened();
    Selenide.refresh();
    paymentPage.assertIsOpened();
  }

  @Test
  public void openTwoPaymentPageAndCloseWindow() {
    Selenide.open(PAYMENT_PAGE_URL);
    paymentPage.assertIsOpened();

    Selenide.webdriver().driver().switchTo().newWindow(WindowType.TAB);
    Selenide.open(PAYMENT_PAGE_URL);
    paymentPage.assertIsOpened();

    Selenide.closeWindow();
    // Selenide.switchTo().window(0); // Не забувайте повертатись назад на свою вкладку
    paymentPage.assertIsOpened();
  }

  @Test
  public void openPageAndEditLocalStorage() {
    Selenide.open(PAYMENT_PAGE_URL);
    paymentPage.assertIsOpened();

    Selenide.executeJavaScript("localStorage.setItem('key', 'value')");
    Selenide.executeJavaScript("localStorage.clear()");

//    Selenide.localStorage().setItem("key", "value");
//    Selenide.localStorage().clear();
  }

  @Test
  public void openPageAndEditSessionStorage() {
    Selenide.open(PAYMENT_PAGE_URL);
    paymentPage.assertIsOpened();

    Selenide.executeJavaScript("sessionStorage.setItem('key', 'value')");
    Selenide.executeJavaScript("sessionStorage.clear()");

//    Selenide.sessionStorage().setItem("key", "value");
//    Selenide.sessionStorage().clear();
  }

  @Test
  public void makePaymentPageScreenshot() {
    Selenide.open(PAYMENT_PAGE_URL);
    paymentPage.assertIsOpened();

    var screenshot = Selenide.screenshot("paymentPageScreenshot");
    Selenide.open(screenshot);
  }

  @Test(dependsOnMethods = "openPaymentPageTest")
  public void makeSuccessPayment() {
    paymentPage.cardNumberInput.val("5329777445319300");
    paymentPage.cardExpiryInput.val("12/29");
    paymentPage.cardCvvInput.val("312");
    paymentPage.submitButton.click();
    paymentPage.statusPageTitle.shouldHave(Condition.text("Success"));
  }

  @Test(dependsOnMethods = "openPaymentPageTest")
  public void makeSuccessPaymentSecond() {
    paymentPage.fillCardDataAndSubmit("5329777445319300", "12/29", "312");
    paymentPage.assertSuccessPageIsOpened("Оплата пройшла успішно");
    //  paymentPage.assertSuccessPageIsOpened("Оплата"); // Впевніться, що відображається потрібний текст
  }

  @Test
  public void assertSuccessStatusPage() {
    Selenide.open(PageUrl.PAYMENT_PAGE_SUBMITTED.url);
    paymentPage.statusPageTitle.shouldHave(Condition.text("Оплата пройшла успішно"));
    paymentPage.statusPageTitle.shouldHave(Condition.partialText("Оплата пройшла успішно"));
    paymentPage.statusPageTitle.shouldHave(Condition.exactText("Оплата пройшла успішно"));

  }

  @AfterTest
  public void tearDownBrowser() {
    Browser.closeBrowser();
  }
}
