import java.util.*;

public class Bank {
  // List<Customer> customers; // list of customers
  public static HashMap<String, Customer> customers = new HashMap<>(); //cust id is username
  // Manager bankManager;
  Currency[] currencies;
  BankFrame frame;
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
