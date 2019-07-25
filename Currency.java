public abstract class Currency { // based against USD
  this.exchangeRate;
  
  public Currency() {
    this.exhangeRate = 1.0;
  }
  
  public Currency(rate) { // USD : this value
    this.exchangeRate = rate;
  }
  
}
