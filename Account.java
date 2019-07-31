import java.util.*;
import javax.swing.*;

public abstract class Account {
  protected String id;
  protected double balance;
  protected List<Transaction> txns;
  double USD,CAD,Bitcoin;

  public Account() {
    this.balance = 0.0;
    this.txns = new LinkedList<Transaction>();
  }

  public Account(double amount) {
    this.balance = amount;
    this.txns = new LinkedList<Transaction>();
    // *add withdraw to account of opening fee *
  }

void withDraw(double amount,String currency) throws Exception{
	double fee = Manager.getWithdrawFee();
    for (Currency curr : Bank.currencies) {
      if (curr.getCountry().equals(currency)) {
        double rate = curr.getRate();
        double newAmount = amount * rate;
        if(this.balance<newAmount || this.balance<fee) {
        	throw new Exception("low balance");
        }
        this.balance -= newAmount;
        this.balance -= fee;
        Withdrawal w = new Withdrawal(amount);
        this.txns.add(w);
        break;
      }
//      this.balance += amount;
//     if(currency.equals("USD")) {
//       USD -= amount;
//     }
//      if(currency.equals("CAD")) {
//        CAD -= amount;
//      }
//      if(currency.equals("Bitcoin")) {
//        Bitcoin -=amount;
//      }
    }
}

void deposit(double amount,String currency){
	double fee = Manager.getWithdrawFee();
  for (Currency curr : Bank.currencies) {
    String country = curr.getCountry();
    if (country.equals(currency)) {
      double rate = curr.getRate();
      double newAmount = amount * rate;
      this.balance += newAmount;
      if(this.getType().equals("Checking")) {
          this.balance -= fee;
      }
      Deposit d = new Deposit(newAmount);
      this.txns.add(d);
      break;
    }
  }
//  this.balance += amount;
//     if(currency.equals("USD")) {
//       USD+= amount;
//     }
//      if(currency.equals("CAD")) {
//        CAD+= amount;
//      }
//      if(currency.equals("Bitcoin")) {
//        Bitcoin+=amount;
//      }


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
      return ("you have "+balance);
  }

  <T> void transfer(T account, double amount){
    //transfer money from current account to saving/checking
    //lets not implement right now since it is not required,
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
