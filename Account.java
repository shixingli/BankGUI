abstract class Account {
    double balance;
    String[] txns;
    
    public Account(double amount) {
      this.balance = amount;
    }
    
    void withDraw(double amount){
      this.balance -= amount;
    }
    
    void deposit(double amount){
      this.balance += amount;
    }
    
    double view_balance() {
      return balance;
    }
    
    String view_txns() {
      return "";
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
