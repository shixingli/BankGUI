public abstract class Currency { // based against USD
  private double exchangeRate;
  
  public Currency() {
    this.exchangeRate = 1.0;
  }
  
  public Currency(int rate) { // USD : this value
    this.exchangeRate = rate;
  }
  
}
