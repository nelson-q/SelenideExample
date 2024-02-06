package example;

import org.testng.annotations.Test;

public class ExampleTest {

  private final YakabooPage yakabooPage = new YakabooPage();
  private static final String BOOK_NAME = "Маленький принц";
      /*
        Маленький принц - паперова
        Острів скарбів - електронна
        Сяйво свідомого я - нема в наявності
        */

  @Test
  public void searchBook() {
    yakabooPage.open();
    yakabooPage.searchInput.setValue(BOOK_NAME);
    yakabooPage.closeDialogModal();

    yakabooPage.someButton.click();
    yakabooPage.someSecondButton.click();
    yakabooPage.checkBookAvailability();
  }
}
