import java.util.*;
import javax.swing.*;

public abstract class Account {
  protected String id;
  protected double balance;
  protected List<Transaction> txns;
  double USD,CAD,Bitcoin;

  public Account() {
  }
  
  public Account(double amount) {
    this.balance = amount;
    this.txns = new LinkedList<Transaction>();
    // *add withdraw to account of opening fee *
  }
  
void withDraw(double amount,String currency){
      this.balance -= amount;
//      this.balance += amount;
//      if(currency.equals("USD")) {
//        USD -= amount;
//      }
//      if(currency.equals("CAD")) {
//        CAD -= amount;
//      }
//      if(currency.equals("Bitcoin")) {
//        Bitcoin -=amount;
//      }
      Withdrawal w = new Withdrawal(amount);
      this.txns.add(w);
    }

void deposit(double amount,String currency){
      this.balance += amount;
//      if(currency.equals("USD")) {
//        USD+= amount;
//      }
//      if(currency.equals("CAD")) {
//        CAD+= amount;
//      }
//      if(currency.equals("Bitcoin")) {
//        Bitcoin+=amount;
//      }
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
  
  public void setBal(double begin) {
    this.balance = begin;
  }
  
  public String toString() {
    return this.id + " account with a current value of $" + this.balance;
  }

  String check_balance() {
      return ("you have "+USD + " USD, " + CAD + " CAD " + "and " + Bitcoin +" Bitcoins!");
  }
  
  <T> void transfer(T account, double amount){
    //transfer money from current account to saving/checking
    //lets not implement right now since it is not required,
  }
  
  
  public static void main(String[] args) {
  }
  
  /*
   * ACCOUNT SUMMARY FRAME  
   */
  public class AccountSummaryFrame extends JFrame {
    // constructor takes in a customer and gets their name for the title and then returns a pretty gridLayout of all txns for the account
    // including total available bal (maybe at the top)
    // take from show all txn history
    // if checking you have to show loans associated with the account
  }
}
