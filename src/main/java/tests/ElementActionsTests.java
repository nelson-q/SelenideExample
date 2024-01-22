package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.Browser;
import config.PageUrl;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PaymentPage;
import pages.WikiPage;

public class ElementActionsTests {

  private final PaymentPage paymentPage = new PaymentPage();
  private final WikiPage wikiPage = new WikiPage();
  private static final String PAYMENT_PAGE_URL = PageUrl.PAYMENT_PAGE_1.url;

  @BeforeTest
  public void setUpBrowser() {
    Browser.setBrowser();
  }

  @Test
  public void hoverCvvIconTest() {
    Selenide.open(PAYMENT_PAGE_URL);
    paymentPage.assertIsOpened();
    paymentPage.cvvIcon.hover();
    paymentPage.cvvHint.shouldBe(Condition.visible);
  }

  @Test
  public void langCurrencyTest() {
    Selenide.open(PageUrl.WIKI.url);

    wikiPage.langSelect.selectOptionByValue("uk");
    wikiPage.langSelect.shouldHave(Condition.selectedText("uk"));
  }


  @AfterTest
  public void tearDownBrowser() {
    Browser.closeBrowser();
  }
}
