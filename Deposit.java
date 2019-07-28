public class Deposit extends Transaction {
  
  public Deposit(double toDeposit){
    super(toDeposit);
    this.id = "Deposit on " + this.time();
  }
}
