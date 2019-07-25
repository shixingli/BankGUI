//shizhen
public abstract class Bank {
  List<Customer> customers;
  HashMap<Integer, Customer> map = new HashMap<>(); //cust id is integer
  Manager bankManager;
  Currency[] currencies;
  
  BankFrame frame;
  CustomerFrame atm; // customer gui interactivity
  ManagerFrame authorized; // manager gui interactivity
  
  abstract void open();
  abstract void close();
  
}
