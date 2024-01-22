package config;

public enum PageUrl {

  PAYMENT_PAGE_1("https://payment-page.solidgate.com/NRQlMrA"),
  PAYMENT_PAGE_2("https://payment-page.solidgate.com/N69jxYA"),
  PAYMENT_PAGE_3("https://payment-page.solidgate.com/NKdrXXD"),
  PAYMENT_PAGE_4("https://payment-page.solidgate.com/VPwxWKD"),
  PAYMENT_PAGE_5("https://payment-page.solidgate.com/AWXPmMN"),
  PAYMENT_PAGE_6("https://payment-page.solidgate.com/AjdJQpD"),
  PAYMENT_PAGE_7("https://payment-page.solidgate.com/N8Xy45N"),
  PAYMENT_PAGE_8("https://payment-page.solidgate.com/AnB53gA"),
  PAYMENT_PAGE_SUBMITTED("https://payment-page.solidgate.com/AYZWYvN"),
  PAYMENT_FORM_URL("https://qa-webservice.solidgate-management.com/texts/c32671b3-ea0f-4dff-834e-d742cb3cb989"),
  PAYMENT_FORM_CARD_BRAND_URL("https://qa-webservice.solidgate-management.com/texts/c5469748-4ed0-4ffa-af79-334eea5350d5"),
  WIKI("https://www.wikipedia.org/");

  public final String url;

  PageUrl(String url) {
    this.url = url;
  }
}
