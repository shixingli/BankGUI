public class Withdrawal extends Transaction {

  public Withdrawal(double toWithdraw){
    super(toWithdraw);
    this.id = "Withdrawal at " + this.time();
  }

}
