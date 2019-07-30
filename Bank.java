import java.util.*;

public class Bank {
  // List<Customer> customers; // list of customers
  public static HashMap<String, Customer> customers = new HashMap<>();
  Manager bankManager;
  public static Currency[] currencies;
  BankFrame frame;
  static String curr_managername = "louis";
  static String curr_managerpwd  ="1234";
  // ManagerFrame authorized; // manager gui interactivity
  static double interestrate;
  static double accountfee;
  // Rich Man's Bank Default

  public Bank() {
    defaultCurrencies();

    bankManager = new Manager(this.customers,curr_managername, curr_managerpwd);
  }

  // Rich Man's Bank w/ customers input
  public Bank(HashMap<String, Customer> users) {
    this();
    customers = users;
  }

  public Bank(Currency[] inpCurrencies, HashMap<String, Customer> users) {
    Bank.newCurrencies(inpCurrencies);
    customers = users;
    bankManager = new Manager(this.customers, "louis", "1234");
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
    frame = new BankFrame(bankManager,customers);
    frame.bankframe.setVisible(true);
  }

  public static void main(String[] args)  {
    // defaultCurrencies();
    HashMap<String, Customer> map = new HashMap<String, Customer>();
    // defaultCurrencies();
    Bank mybank = new Bank(map);

    Checking c1c = new Checking(101);
    Savings c1s = new Savings(11);
    c1c.deposit(900,"USD");
    Checking c2c = new Checking(50);

    Savings c3s = new Savings(1000000);

    List<Account> c1Acc = new LinkedList<Account>();
    c1c.deposit(900,"USD");
    c1Acc.add(c1c);
    c1Acc.add(c1s);
    Customer c1 = new Customer(c1Acc, "Deborah Reynolds", "dbreynolds", "890cloverfield");
    map.put(c1.getUsername(), c1);
    Customer c2 = new Customer(c2c, "Blake Lively", "blive", "123456");
    map.put(c2.getUsername(), c2);
    Customer c3 = new Customer(c3s, "Jake Gyllenhaal", "deadpool", "48");
    map.put(c3.getUsername(), c3);

    // Bank mybank = new Bank(map);
    mybank.open();

  }

//  public static double getInterest_manager(){
//    interestrate = Manager.getInterest();
//  }
  // public static HashMap<String, Customer> test() {
  //   HashMap<String, Customer> map = new HashMap<String, Customer>();
  //   // defaultCurrencies();
  //
  //   Checking c1c = new Checking(101);
  //   Savings c1s = new Savings(11);
  //   c1c.deposit(900,"USD");
  //   Checking c2c = new Checking(50);
  //
  //   Savings c3s = new Savings(1000000);
  //
  //   List<Account> c1Acc = new LinkedList<Account>();
  //   c1c.deposit(900,"USD");
  //   c1Acc.add(c1c);
  //   c1Acc.add(c1s);
  //   Customer c1 = new Customer(c1Acc, "Deborah Reynolds", "dbreynolds", "890cloverfield");
  //   map.put(c1.getUsername(), c1);
  //   Customer c2 = new Customer(c2c, "Blake Lively", "blive", "123456");
  //   map.put(c2.getUsername(), c2);
  //   Customer c3 = new Customer(c3s, "Jake Gyllenhaal", "deadpool", "48");
  //   map.put(c3.getUsername(), c3);
  //
  //   return map;
  // }




}
