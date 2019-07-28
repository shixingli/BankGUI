public class Loan {
  private double amount;
  
  public Loan(double howMuch) {
    this.amount = howMuch;
  }
  
  public double moneyBack() {
    //this.amount - interest
     // add interest from static value or getter method in Bank Manager class
    return 0.0;
  }
  public String toString() {
    return "Loan : $" + this.amount;
  }
}
