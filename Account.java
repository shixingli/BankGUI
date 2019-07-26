abstract class Account {
    double balance;
    String[] txns;

    void withDraw(double amount){
  	    this.balance -= amount;
  	  }

	  void deposite(double amount){
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

	   }




}
