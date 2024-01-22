package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class PaymentPage {

  public SelenideElement cardNumberInput = $("[data-testid=cardNumber]");
  public SelenideElement cardExpiryInput = $("[data-testid=cardExpiryDate]");
  public SelenideElement cardCvvInput = $("[data-testid=cardCvv]");
  public SelenideElement cvvIcon = $("[data-testid=hint-cvv]");
  public SelenideElement cvvHint = $("[data-testid=hint-cvv] img");
  public SelenideElement submitButton = $("[data-testid=submit]");
  public SelenideElement cardNumberError = $("#cardNumber_error-text");
  public SelenideElement statusPageTitle = $("[data-testid=status-title]").as("Status page title");

  public void assertIsOpened() {
    cardNumberInput.shouldBe(Condition.visible);
    submitButton.shouldBe(Condition.visible);
  }

  public void fillCardData(String cardNumber, String cardExpiry, String cardCvv) {
    cardNumberInput.val(cardNumber);
    cardExpiryInput.val(cardExpiry);
    cardCvvInput.val(cardCvv);
  }

  public void fillCardDataAndSubmit(String cardNumber, String cardExpiry, String cardCvv) {
    fillCardData(cardNumber, cardExpiry, cardCvv);
    submitButton.click();
  }

  public void assertSuccessPageIsOpened(String title) {
    statusPageTitle.shouldHave(Condition.text(title));
  }
}
