package example;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class YakabooPage {

  public SelenideElement searchInput = $x("//input[@type='search']");
  public SelenideElement someElement = $x("//div[@class='cl-widget-f8519v8519']");
  public SelenideElement dialogIconButton = $x("//div[@class='cl-dialog-close-icon']");
  public SelenideElement someButton = $x("//div[@class='ui-search-form-input']//button[@class='ui-btn-primary']");
  public SelenideElement someSecondButton = $x("//div[@class='category-card category-layout expanded'][1]");
  public SelenideElement availabilityStatus =
      $x("//section[@class='side']//div[@class='ui-shipment-status available']");
  public SelenideElement paperBookPrice = $x("//section[@class='side']//div[@class='ui-price-display__main']");
  public SelenideElement secondStatus = $x("//section[@class='side']//div[@class='status__format']");
  public SelenideElement ebookPrice = $x("//div[@class='side__box']//div[@class='ui-price-display__main']");

  public void open() {
    Selenide.open("https://www.yakaboo.ua/");
    searchInput.shouldBe(Condition.visible);
  }

  public void closeDialogModal() {
    if (someElement.is(Condition.visible)) {
      dialogIconButton.click();
    }
  }

  public void checkBookAvailability() {
    if (availabilityStatus.text().contains("В наявності")) {
      System.out.println("Ціна паперової книги: " + paperBookPrice.text());
    } else if (secondStatus.text().contains("Електронна книга")) {
      System.out.println("Ціна електронної книги: " + ebookPrice.text());
    } else {
      System.out.println("Паперової та електронної книги нема в наявності");
    }
  }
}
