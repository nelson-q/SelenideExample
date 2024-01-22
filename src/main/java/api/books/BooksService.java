package api.books;

import api.books.SearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksService {

  @GET("/")
  Call<SearchResponse> findBook(@Query("id") Integer id,
                                @Query("q") String q,
                                @Query("query") String bookName);
}
