public class Customer extends User {
  Loan loan;
  Account[] accounts;
  double totalBalance; // unnecessary?
  String[] transactionHistory;
  boolean collateral;
  
  public Customer() {
  }
 
  // three different constructors dependent on 

  public Loan getLoan() {
    return this.loan;
  }
  
  public void setLoan(Loan moneyDue) {
    this.loan = moneyDue;
  }
  
  /* accesses the accounts for the customer and updates the total balance */
  public void updateBalance() {
    double bal;
    for (Account account : this.accounts) {
//      bal += account.getBalance();
    }
//    this.totalBalance = bal;
  }
  
  /* returns the total balance for all accounts for a customer */
  public double getTotalBalance() {
    return this.totalBalance;
  }
  
  
  // get balance
  // get transaction history

  // if null, throw new illegal argument exception that has to be CAUGHT
  // get savingAccount
  // get checking account
}
