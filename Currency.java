public class Currency {
  private String id;
  private double exchangeRate;
  
  public Currency() {
    this.exchangeRate = 1.0;
    this.id = "USD";
  }
  
  public Currency(String countryCode, double rate) { // USD : this value
    this.exchangeRate = rate;
    this.id = countryCode;
  }
  
}
