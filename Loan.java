public class Loan {
  private double amount;
  
  public Loan(double howMuch) {
    this.amount = howMuch;
    // add interest from static value or getter method in Bank Manager class
  }
  
  public String toString() {
    return "Loan : $" + this.amount;
  }
}
