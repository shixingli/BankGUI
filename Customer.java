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
    this.accounts = new LinkedList<Account>();
  }
  
  /* adding a default customer w/ account dependent on money in that account */
  public Customer(Account accAdd) {
    this();
    this.totalBalance = accAdd.view_balance();
    this.accounts.add(accAdd);
    this.collateral.addAll(this.collateralItems);
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
    this.accounts = new LinkedList<Account>();
    this.totalBalance = 0;
    this.name = "DEFAULT";
    this.id = "username";
    this.pwd = "pwd";
    this.loans = new LinkedList<Loan>();
    
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
  
  public List<Transaction> getHistoryAllAcc() {
    if (this.accounts == null) {
      return null;
    } else {
      List<Transaction> txnHistory = new LinkedList<Transaction>();
      for (Account account : this.accounts) {
        txnHistory.addAll(account.view_txns());
      }
      return txnHistory;
    }
  }
  
  public void makeFrame() {
      JFrame customerFrame = new JFrame("Rich Man's Bank — " + Customer.this.name + " Financial Summary");
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
   * THE CUSTOMER FRAME  ! 
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
        JPanel summary = new JPanel();
        summary.add(checkingSum);
        summary.add(savingsSum);
        
        JButton checkingW = new JButton("Checking");
        JButton savingsW = new JButton("Savings");
        JPanel withdraw = new JPanel();
        withdraw.add(checkingW);
        withdraw.add(savingsW);
        
        JButton checkingD = new JButton("Checking");
        JButton savingsD = new JButton("Savings");
        JPanel deposit = new JPanel();
        deposit.add(checkingD);
        deposit.add(savingsD);
        
        CheckingListener checkL = new CheckingListener();
        checkingSum.addActionListener(checkL); 
        checkingW.addActionListener(checkL);
        checkingD.addActionListener(checkL);
        
        SavingsListener savingsL = new SavingsListener();
        savingsSum.addActionListener(savingsL); 
        savingsW.addActionListener(savingsL); 
        savingsD.addActionListener(savingsL);
        
        JButton checkingC = new JButton("Checking");
        JButton savingsC = new JButton("Savings");
        JPanel create = new JPanel();
        create.add(checkingC);
        create.add(savingsC);
        
        CheckingCreateListener checkCL = new CheckingCreateListener();
        checkingC.addActionListener(checkCL); 
        SavingsCreateListener savingsCL = new SavingsCreateListener();
        savingsC.addActionListener(savingsCL);
        
        
        JPanel loan = new JPanel();
        if (Customer.this.collateral.isEmpty()) {
          loan.add(new JLabel("Insufficient collateral to take out a loan."));
        } else {
        loan.add(new JLabel("Amount:"));
        loan.add(new JTextField(10));
        
        loan.add(new JLabel("Currency Country Code:"));
        loan.add(new JTextField(3));
        }
        
        JButton display = new JButton("Show");
        JPanel history = new JPanel();
        history.add(display);
        TransactionHistoryListener historyL = new TransactionHistoryListener();
        display.addActionListener(historyL);
        
        
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
        options.add(deposit, "Deposit");
        options.add(create, "Open a New Account");
        options.add(loan, "Take Out a Loan"); // pop up window for this?
        options.add(history, "View Transaction History"); // buttons here and then depending on which will get pop up window
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
  
  /* INCOMPLETE */
  class CheckingListener implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      System.out.println("Open the customer's checking account, if it exists.");
      
      boolean success = false;
      if (Customer.this.accounts != null) {
        for (Account account : Customer.this.accounts) {
          if (account instanceof Checking) {
            // open the checking frame
            success = true;
          }
        }
      }
      if (!success) {
        AccountDNEPanel dne = new AccountDNEPanel("Checking", Customer.this.name);
      }
    }
  }
  
    /* INCOMPLETE */
    class SavingsListener implements ActionListener {
      public void actionPerformed( ActionEvent e ) {
        System.out.println("Open the customer's savings account, if it exists.");
        
        boolean success = false;
        if (Customer.this.accounts != null) {
          for (Account account : Customer.this.accounts) {
            if (account instanceof Savings) {
              // open the checking frame
              success = true;
            }
          }
        }
        if (!success) {
          AccountDNEPanel dne = new AccountDNEPanel("Savings", Customer.this.name);
        }
      }
    }
    
    class CheckingCreateListener implements ActionListener {
      public void actionPerformed( ActionEvent e ) {
        System.out.println("Here to create a customer's checking account!");
        // if it already exists you can't make it
      }
    }
    
    class SavingsCreateListener implements ActionListener {
      public void actionPerformed( ActionEvent e ) {
        System.out.println("Here to create a customer's savings account!");
      }
    }
    
    class TransactionHistoryListener implements ActionListener {
      public void actionPerformed( ActionEvent e ) {
        System.out.println("Here to display a customer's transaction history!");
        TransactionHistoryFrame tf = new TransactionHistoryFrame();
      }
    }
  }
  
  
  /* 
   * TRANSACTION HISTORY FRAME
   */
  
  public class TransactionHistoryFrame extends JFrame {
    public TransactionHistoryFrame() {
      this.setTitle("Rich Man's Bank — " + Customer.this.name + " Transaction History");
      this.setLayout(new GridLayout(2, 1));
      this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.WHITE));
      
      SimpleDateFormat df = new SimpleDateFormat("EEEE, MMMM d 'at' h:mm a z ");
      Date now = new Date();
      String curr = df.format(now);
      JLabel schpeel = new JLabel("        Transaction history acquired " + curr + "         ", JLabel.CENTER);
      this.add(schpeel);
      
      JPanel panel = new JPanel();
      List<Transaction> history = Customer.this.getHistoryAllAcc();
      
      if (history == null) {
        panel.setLayout(new GridLayout(2, 1));
        panel.add(new JLabel("No recent transactions.", JLabel.CENTER));
        this.add(panel);
        
      } else {
        int lenList = history.size();
        panel.setLayout(new GridLayout(1 + lenList, 2));
        System.out.println("Here");
        System.out.println(history.toString());
        for (Transaction txn : history) {
          System.out.println("In the loop");
          panel.add(new JLabel(txn.getId()));
          //panel.add(new JButton("OK-2"));
          this.add(panel);
        }
      }
      this.pack();
      this.setLocation(650, 100);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      this.setVisible(true);
    }
  }
}
  

