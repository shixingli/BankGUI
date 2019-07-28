import java.util.*;

public abstract class Account {
  protected String id;
  protected double balance;
  protected List<Transaction> txns;
  
  public Account(double amount) {
    this.balance = amount;
    this.txns = new LinkedList<Transaction>();
  }
  
  void withDraw(double amount){
    this.balance -= amount;
    Withdrawal w = new Withdrawal(amount);
    this.txns.add(w);
  }
  
  void deposit(double amount){
    this.balance += amount;
    Deposit d = new Deposit(amount);
    this.txns.add(d);
  }
  
  public String getType() {
    return this.id;
  }
  
  double view_balance() {
    return balance;
  }
  
  List<Transaction> view_txns() {
    return this.txns;
  }
  
  public String toString() {
    return this.id + " account with a current value of $" + this.balance;
  }
  
  <T> void transfer(T account, double amount){
    //transfer money from current account to saving/checking
    //lets not implement right now since it is not required,
  }
  
  
  public static void main(String[] args) {
    AccountFrame window = new AccountFrame();
    window.accountframe.setVisible(true);
  }
  
  
  
  
}
