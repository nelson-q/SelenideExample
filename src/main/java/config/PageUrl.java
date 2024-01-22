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
  PAYMENT_FORM_URL("https://qa-webservice.solidgate-management.com/texts/e5260b9b-0fa8-4d0a-9afd-8acfa75395d1"),
  WIKI("https://www.wikipedia.org/");

  public final String url;

  PageUrl(String url) {
    this.url = url;
  }
}
