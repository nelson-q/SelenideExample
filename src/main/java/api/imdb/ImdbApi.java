package api.imdb;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class ImdbApi {

  public final ImdbRestClient client = new ImdbRestClient();

  public ResponseBody getTopChartResponse() throws IOException {
    return client.books.getTopChart().execute().body();
  }

  public LinkedHashMap<String, String> getTopChart() throws IOException {
    var htmlString = getTopChartResponse().string();
    var document = Jsoup.parse(htmlString);
    var ipcTitleElements = document.select(".ipc-title");

    var allFilms = new LinkedHashMap<String, String>();

    for (Element ipcTitleElement : ipcTitleElements) {
      var aTag = ipcTitleElement.select("a").first();
      if (aTag != null) {
        var href = aTag.attr("href");
        var h3Text = aTag.select("h3").text();
        var link = ImdbRestClient.BASE_URL + href;
        allFilms.put(h3Text, link);
      }
    }
    return allFilms;
  }

  public List<Map.Entry<String, String>> getTop100Films() throws IOException {
    return getTopChart().entrySet().stream().limit(100).toList();
  }

}
