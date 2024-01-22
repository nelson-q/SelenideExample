package api.books.models;

import api.books.BooksRestClient;
import api.books.SearchResponse;
import java.io.IOException;

public class BooksApi {

  private final BooksRestClient client = new BooksRestClient();

  public SearchResponse searchBooksByName(String bookName) throws IOException {
    return client.books.findBook(11908, "pyjnw8", bookName).execute().body();
  }
}
