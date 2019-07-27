import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Arrays;
import java.util.Stack;
import java.util.Calendar;
import java.util.LinkedList;

public class Customer {
  String name;
  String id;
  String pwd;
  
  List<Loan> loans;
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
    this.loans = new LinkedList<Loan>(); 
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
  
  /* getter for Loans */
  public List<Loan> getLoan() {
    return this.loans;
  }
  
  /* setter for Loans */
  public boolean setLoan(Loan moneyDue) {
    if (collateral.isEmpty()) {
      return false;
    } else {
      this.loans.add(moneyDue);
      this.collateral.pop();
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
  
  /* getter for accounts */
  public List<Account> getAccounts() {
    return this.accounts;
  }
  /* add to accounts */
  public void addAccount(Account add) {
    this.accounts.add(add);
  }
  
  /* setter for accounts */
  public void setAccounts(List<Account> setAcc) {
    this.accounts = setAcc;
  }
  
  public List<String> getHistoryAllAcc() {
    return this.txnHistory;
  }
  
  public void makeFrame() {
      JFrame customerFrame = new JFrame("Rich Man's Bank — " + "Client's Name" + " Financial Summary");
      customerFrame.setLayout(new GridLayout(4, 1));
      customerFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.WHITE));
      
      //JLabel header = title(client.getName());

      
      CustomerFrame frame = new CustomerFrame();
      JLabel header = frame.title(this.name);
      customerFrame.add(header);
            
      JLabel schpeel = new JLabel("How may we be of service?", JLabel.CENTER);
      customerFrame.add(schpeel);
      
      frame.addToPane(customerFrame.getContentPane());
      
      customerFrame.setSize(450, 300);
      customerFrame.setLocation(200, 100);
      customerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      customerFrame.setVisible(true);
    }
    

  
  /*
   * THE FRAME  ! 
   */
  
  public class CustomerFrame extends JFrame implements ItemListener {
    JPanel options;
    
    public void addToPane(Container pane) {
        JPanel menu = new JPanel();
        
        String banking[] = { "View Account Summary", 
          "Withdraw", 
          "Deposit", 
          "Open a New Account", 
          "View Transaction History",
          "Take Out a Loan"};
        
        JComboBox dropDown = new JComboBox(banking);
        dropDown.setEditable(false);
        dropDown.addItemListener(this);
        menu.add(dropDown);
        
        JButton checkingSum = new JButton("Checking");
        JButton savingsSum = new JButton("Savings");
        
        JButton checkingW = new JButton("Checking");
        JButton savingsW = new JButton("Savings");
        
        JPanel summary = new JPanel();
        summary.add(checkingSum);
        summary.add(savingsSum);
         
        JPanel withdraw = new JPanel();
        withdraw.add(checkingW);
        withdraw.add(savingsW);
        
        JPanel loan = new JPanel();
        loan.add(new JLabel("Amount:"));
        loan.add(new JTextField(10));
        
        loan.add(new JLabel("Currency Country Code:"));
        loan.add(new JTextField(3));
        
        CheckingListener checkL = new CheckingListener();
        checkingSum.addActionListener(checkL); 
        
        SavingsListener savingsL = new SavingsListener();
        savingsSum.addActionListener(savingsL); 
 
        
//        JPanel withdraw = new JPanel();
//        withdraw.add(new JLabel("Amount:"));
//        withdraw.add(new JTextField(10));
//        
//        withdraw.add(new JLabel("Currency Country Code:"));
//        withdraw.add(new JTextField(3));
//        
//        // unncessary to have the same panel? //
//        JPanel deposit = new JPanel();
//        deposit.add(new JLabel("Amount:"));
//        deposit.add(new JTextField(10));
//        
//        deposit.add(new JLabel("Currency Country Code:"));
//        deposit.add(new JTextField(3));
         
        // creating the drop down menu
        options = new JPanel(new CardLayout());
        options.add(summary, "View Account Summary");
        options.add(withdraw, "Withdraw");
        options.add(loan, "Take out a loan");
//        options.add(deposit, "Deposit");
//        options.add(summary, "Create New Account"); // pop up window for this?
//        options.add(summary, "View Transaction History"); // buttons here and then depending on which will get pop up window
//        

      
        pane.add(menu, BorderLayout.PAGE_START);
        pane.add(options, BorderLayout.CENTER);
    }
     
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(options.getLayout());
        cl.show(options, (String)evt.getItem());
    }
    
    /* creates the title and border for the frame */
  public JLabel title (String customerName) {
    JLabel welcome = new JLabel("", JLabel.CENTER);
    Calendar c = Calendar.getInstance();
    int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
    String greeting;
    
    if(timeOfDay >= 0 && timeOfDay < 12){
      greeting = " Good Morning, ";       
    } else if(timeOfDay >= 12 && timeOfDay < 16){
      greeting = " Good Afternoon, ";
    } else {
      greeting = " Good Evening, ";
    }

    SimpleDateFormat df = new SimpleDateFormat("EEEE, MMMM d 'at' h:mm a z ");
    Date now = new Date();
    welcome.setText(greeting + customerName + ". It is " + df.format(now) + ".");
    
    return welcome;
  }
  
  class CheckingListener implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      System.out.println("Open the customer's checking account, if it exists.");
      
      boolean success = false;
      if (Customer.this.accounts != null) {
        for (Account account : Customer.this.accounts) {
          System.out.println("zoinks");
          if (account instanceof Checking) {
            // open the checking frame
            success = true;
          }
          // if the account is an instance of checking, pop open the checking frame
        }
      }
      if (!success) {
        AccountDNEFrame.openFrame();
      }
      //if no success pop out the "account does not exist frame"
    }
  }
  
    class SavingsListener implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      System.out.println("Open the customer's savings account, if it exists.");
    }
  }
    // write code  for a method for Bank to call which takes in a customer and is used in the creation of the frame
  
//  public static void startInteraction(Customer client) {
//    makeFrame(client);
//  }
 
}
  }
  

