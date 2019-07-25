//shizhen
public class Bank {
  // List<Customer> customers; // list of customers
  // HashMap<Integer, Customer> map = new HashMap<>(); //cust id is integer
  // Manager bankManager;
  // Currency[] currencies;
  //
  BankFrame frame;
  // CustomerFrame atm; // customer gui interactivity
  // ManagerFrame authorized; // manager gui interactivity

  void open(){
    frame = new BankFrame();
		frame.bankframe.setVisible(true);
  }

  //TODO:
  // abstract void close();



  public static void main(String[] args)  {
      Bank mybank = new Bank();
      mybank.open();
  }

}
