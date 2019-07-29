public class Loan {
  private double amount;
  
  public Loan(double howMuch) {
    this.amount = howMuch;
  }
  
  public double moneyBack() {
    double interest = Manager.getInterest();
    double val = this.amount * interest;
    return this.amount - val;
  }
  public String toString() {
    return "Loan : $" + this.amount;
  }
}
