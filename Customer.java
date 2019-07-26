import java.util.*;

public class Customer extends User {
  String name;
  String id;
  String pwd;
  
  Loan loan;
  List<Account> accounts;
  double totalBalance; // unnecessary?
  List<String> txnHistory;
  boolean collateral; // maybe this should be info about what their collateral is ??? (like a property or business)
  
  /* no arg */
  public Customer() {
    this.totalBalance = 0;
    this.collateral = false;
    this.name = "DEFAULT";
    this.id = "welcome";
    this.pwd = "0000";
  }
  
  /* adding a default customer w/ account dependent on money in that account and if they can have a loan or not */
  public Customer(Account accAdd, boolean canHaveLoan) {
    this();
    this.totalBalance = accAdd.view_balance();
    this.collateral = canHaveLoan;
    this.accounts.add(accAdd);
  }
  
  /* as above, but with name, id, and pwd */
  public Customer(Account accAdd, boolean canHaveLoan, String name, String uid, String pwd) {
    this(accAdd, canHaveLoan);
    this.name = name;
    this.id = uid;
    this.pwd = pwd;
  }
  
 /* adding default cust multiple accounts and if they can have a loan or not */ 
  public Customer(List<Account> accounts, boolean canHaveLoan) {
    double bal = 0;
    for (Account account : accounts) {
      this.accounts.add(account);
      bal += account.view_balance();
    }
    
    this.collateral = canHaveLoan;
  }
  
  /* as above but with custom name, id, and pwd */
  public Customer(List<Account> accounts, boolean canHaveLoan, String name, String uid, String pwd) {
    this(accounts, canHaveLoan);
    this.name = name;
    this.id = uid;
    this.pwd = pwd;
  }
 
  /* only needed if the ACCOUNT creation is dependent on the customer, if not the total amount is determined in the above constructor */
  public Customer(List<Account> accounts, boolean canHaveLoan, double openAmount) {
    this(accounts, canHaveLoan);
    this.totalBalance = openAmount;
  }

  /* getter for customerName */
  public String getName() {
    return this.name;
  }
  
  /* getter for Loan */
  public Loan getLoan() {
    return this.loan;
  }
  
  /* setter for Loan */
  public void setLoan(Loan moneyDue) {
    this.loan = moneyDue;
  }
  
  /* accesses the accounts for the customer and updates the total balance */
  public void updateBalance() {
    double bal = 0;
    for (Account account : this.accounts) {
      bal += account.view_balance();
    }
    this.totalBalance = bal;
  }
  
  /* returns the total balance for all accounts for a customer */
  public double getTotalBalance() {
    return this.totalBalance;
  }
  
  /* returns all accounts belonging to customer */
  public List<Account> getAccounts() {
    return this.accounts;
  }
  
  public List<String> getHistoryAllAcc() {
    return this.txnHistory;
  }
}
