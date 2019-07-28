import java.util.*;

public class Bank {
  // List<Customer> customers; // list of customers
  public static HashMap<String, Customer> customers = new HashMap<>();
  // Manager bankManager;
  public static Currency[] currencies;
  BankFrame frame;
  // ManagerFrame authorized; // manager gui interactivity
  
  // Rich Man's Bank Default
  public Bank() {
    defaultCurrencies();
  }
  
  // Rich Man's Bank w/ customers input
  public Bank(HashMap<String, Customer> users) {
    this();
    customers = users;
  }
  
  public Bank(Currency[] inpCurrencies, HashMap<String, Customer> users) {
    Bank.newCurrencies(inpCurrencies);
    customers = users;
  }
    
  public static void defaultCurrencies() {
    Currency USD = new Currency();
    Currency Bitcoin = new Currency("BIT", 9536.68);
    Currency CAD = new Currency("CAD", 0.76);                          
    currencies = new Currency[]{USD, Bitcoin, CAD};
  }
  
  public static void newCurrencies(Currency[] newCurr) {
    currencies = newCurr;
  }
  
  void open(){
    frame = new BankFrame();
    frame.bankframe.setVisible(true);
  }

  public static void main(String[] args)  {
      Bank mybank = new Bank(Bank.test());
      mybank.open();
  }
  
  public static HashMap<String, Customer> test() {
    HashMap<String, Customer> map = new HashMap<String, Customer>();
    
    Checking c1c = new Checking(101);
    Savings c1s = new Savings(11);
    
    Checking c2c = new Checking(50);
    
    Savings c3s = new Savings(1000000);
    
    List<Account> c1Acc = new LinkedList<Account>();
    c1Acc.add(c1c);
    c1Acc.add(c1s);
    Customer c1 = new Customer(c1Acc, "Deborah Reynolds", "dbreynolds", "890cloverfield");
    map.put(c1.getUsername(), c1);
    Customer c2 = new Customer(c2c, "Blake Lively", "blive", "123456");
    map.put(c2.getUsername(), c2);
    Customer c3 = new Customer(c3s, "Jake Gyllenhaal", "deadpool", "48");
    map.put(c3.getUsername(), c3);
    
    return map;
  }
  
  

}
