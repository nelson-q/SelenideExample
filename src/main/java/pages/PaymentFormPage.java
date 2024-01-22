package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class PaymentFormPage {

  public SelenideElement paymentFormIframe = $("[id*=payment-form-iframe]");
  public SelenideElement cardNumberInput = $("[name=cardNumber]");
  public ElementsCollection cardBrands = $$("[class=card_brands] i");

  public void open(String url) {
    Selenide.open(url);
    switchToFormIframe();
    assertIsOpened();
  }

  public void switchToFormIframe() {
    paymentFormIframe.shouldBe(visible);
    switchTo().frame(paymentFormIframe);
  }

  public void assertIsOpened() {
    cardNumberInput.shouldBe(visible);
  }
}
