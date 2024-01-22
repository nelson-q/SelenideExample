package api.books;

import java.util.List;

public class SearchResponse {
  public String query;
  public Integer total;
  public Results results;

  public static class Results {
    public List<ItemGroup> itemGroups;
    public List<Category> categories;
  }

  public static class ItemGroup {
    public Category category;
    public List<List<Item>> items;
  }

  public static class Category {
    public String url;
    public String name;
    public String id;
    public int count;
  }

  public static class Item {
    public String id;
    public String oldPrice;
    public String url;
    public Boolean isPresence;
    public String name;
    public String presence;
    public String picture;
    public String brand;
    public String price;
    public String currency;
    public ParamsData paramsData;
    public List<String> offerType;
  }

  public static class ParamsData {
  }
}
