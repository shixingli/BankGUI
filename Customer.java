import java.util.*;

public class Customer extends User {
  String name;
  String id;
  String pwd;
  
  Loan loan;
  List<Account> accounts;
  double totalBalance; // unnecessary?
  List<String> txnHistory;
  
  List<String> collateralItems = Arrays.asList("House", "Business", "Car", "Stocks");
  Stack<String> collateral = new Stack<String>();// make a list of strings that is collateral and each time they take out a loan you remove an item from the list 
  // if the list is empty then we can't take out a loan
  
  /* no arg */
  public Customer() {
    this.totalBalance = 0;
    this.name = "DEFAULT";
    this.id = "username";
    this.pwd = "pwd";
  }
  
  /* adding a default customer w/ account dependent on money in that account */
  public Customer(Account accAdd) {
    this();
    this.totalBalance = accAdd.view_balance();
    this.accounts.add(accAdd);
    this.collateral.addAll(collateralItems);
  }
  
  /* as above, but with name, id, and pwd */
  public Customer(Account accAdd, String name, String uid, String pwd) {
    this(accAdd);
    this.name = name;
    this.id = uid;
    this.pwd = pwd;
  }
  
 /* adding default cust multiple accounts */ 
  public Customer(List<Account> accounts) {
    double bal = 0;
    for (Account account : accounts) {
      this.accounts.add(account);
      bal += account.view_balance();
    }
    this.collateral.addAll(this.collateralItems);
  }
  
  /* as above but with custom name, id, and pwd */
  public Customer(List<Account> accounts, String name, String uid, String pwd) {
    this(accounts);
    this.name = name;
    this.id = uid;
    this.pwd = pwd;
  }
 
  /* only needed if the ACCOUNT creation is dependent on the customer, if not the total amount is determined in the above constructor */
  public Customer(List<Account> accounts, double openAmount) {
    this(accounts);
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
  public boolean setLoan(Loan moneyDue) {
    if (collateral.isEmpty()) {
      return false;
    } else {
      this.loan = moneyDue;
      return true;
    }
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
