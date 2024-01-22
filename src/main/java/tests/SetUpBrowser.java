package tests;


import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SetUpBrowser {

  private static final String GOOGLE_URL = "https://www.google.com/";
  private final SelenideElement searchInput= $("textarea[type=Search]");

  @BeforeTest
  public void setUpBrowser() {
    Browser.setBrowser();
  }

  @Test
  public void openPage() {
    Selenide.open(GOOGLE_URL);
    searchInput.shouldBe(Condition.visible);
    searchInput.val("Selenide").pressEnter();
  }

  @AfterTest
  public void tearDownBrowser() {
    Browser.closeBrowser();
  }
}