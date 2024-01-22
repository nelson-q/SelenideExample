package tests;

import api.books.models.BooksApi;
import api.imdb.ImdbApi;
import java.io.IOException;
import org.testng.annotations.Test;

public class WebApiTests {

  private final BooksApi booksApi = new BooksApi();
  private final ImdbApi imdbApi = new ImdbApi();

  @Test
  public void findBookTest() throws Exception {
    var bookName = "Василь Симоненко: Задивляюсь у твої зіниці";
    var searchResult = booksApi.searchBooksByName(bookName);

    var item = searchResult.results.itemGroups.stream()
        .filter(result -> result.items.stream().findFirst().get().get(0).name.equals(bookName)).findFirst()
        .orElseThrow(() -> new AssertionError(bookName + "not present"));
  }

  @Test
  public void imdbTop100ChartTest() throws IOException {
    var top100 = imdbApi.getTop100Films();
  }
}
