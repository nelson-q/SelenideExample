package api.imdb;

import api.books.SearchResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ImdbService {

  @GET("chart/top")
  @Headers({"user-agent: Mozilla/5.0"})
  Call<ResponseBody> getTopChart();
}
