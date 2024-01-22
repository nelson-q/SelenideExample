package tests;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.Browser;
import config.PageUrl;
import java.util.List;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PaymentFormPage;

public class PaymentFormTests {

  private static final String FORM_URL = PageUrl.PAYMENT_FORM_URL.url;
  private final PaymentFormPage paymentFormPage = new PaymentFormPage();

  @BeforeTest
  public void setUpBrowser() {
    Browser.setBrowser();
  }

  @Test
  public void openPaymentFormIframeTest() {
    //  paymentFormPage.open(FORM_URL);

    Selenide.open(FORM_URL);
    paymentFormPage.paymentFormIframe.shouldBe(visible);
    switchTo().frame(paymentFormPage.paymentFormIframe);
    paymentFormPage.assertIsOpened();
    //  paymentFormPage.paymentFormIframe.is(visible);

    switchTo().defaultContent();
    // paymentFormPage.paymentFormIframe.is(visible);
  }

  @Test
  public void paymentFormCardBrandTest() {
    var expectedCardBrands = List.of("visa", "mastercard", "maestro");

    Selenide.open(FORM_URL);
    paymentFormPage.switchToFormIframe();
    //size P.S. start from 1
    paymentFormPage.cardBrands.shouldHave(CollectionCondition.size(3));

    //filter
    var onlyVisa = paymentFormPage.cardBrands.filter(attribute("class", "visa"));
    onlyVisa.shouldHave(CollectionCondition.size(1));

    //shouldHave
    paymentFormPage.cardBrands.first().shouldHave(Condition.attribute("class", "visa"));
    paymentFormPage.cardBrands.shouldHave(CollectionCondition.attributes("class", "visa", "mastercard", "maestro"));
 //   paymentFormPage.cardBrands.shouldHave(CollectionCondition.attributes("class", expectedCardBrands));
  }

  @AfterTest
  public void tearDownBrowser() {
    Browser.closeBrowser();
  }
}
