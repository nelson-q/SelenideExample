package api.books;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class BooksRestClient {

  public static final String BASE_URL = "https://api.multisearch.io/";

  public BooksService books;
  private ObjectMapper objectMapper;

  public BooksRestClient() {
    var httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    var client = new OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build();

    var retrofit = new Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .build();

    books = retrofit.create(BooksService.class);
  }
}
