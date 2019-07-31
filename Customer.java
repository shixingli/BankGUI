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
  private String name;
  private String id;
  private String pwd;

  private List<Loan> loans;
  private List<Account> accounts;
  private double totalBalance; // unnecessary?

  private List<String> collateralItems = Arrays.asList("House", "Business", "Car", "Stocks");
  private Stack<String> collateral = new Stack<String>();// make a list of strings that is collateral and each time they take out a loan you remove an item from the list
  // if the list is empty then we can't take out a loan

  /* no arg */
  public Customer() {
    this.totalBalance = 0;
    this.name = "DEFAULT";
    this.id = "username";
    this.pwd = "pwd";
    this.accounts = new LinkedList<Account>();
    this.loans = new LinkedList<Loan>();
    Bank.customers.put(this.id, this);
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

    double bal = 0;
    for (Account account : accounts) {
      this.accounts.add(account);
      bal += account.view_balance();
    }
    this.totalBalance = bal;
    this.collateral.addAll(this.collateralItems);
    this.loans = new LinkedList<Loan>();
    Bank.customers.put(this.id, this);
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

  /* getter for customerpwd */
  public String getpwd() {
    return this.pwd;
  }
  /* getter for customerUserName */
  public String getUsername() {
    return this.id;
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
    this.updateBalance();
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

  /* adder for multiple accounts */
  public void addAccounts(List<Account> accs) {
    this.accounts.addAll(accs);
  }

  /* gets all history for accs w/out differentiation */
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

  //  /* gets history for a given account */
//  public List<Transaction> getHistoryForAcc(Account account) {
//    List<Transaction> txnHistory = new LinkedList<Transaction>();
//    txnHistory.addAll(account.view_txns());
//    return txnHistory;
//  }

  public void makeFrame() {
      JFrame customerFrame = new JFrame("Rich Man's Bank — " + Customer.this.name + " Financial Summary");
      customerFrame.setLayout(new GridLayout(4, 1));
      customerFrame.getContentPane().setBackground(Color.PINK);

      CustomerFrame frame = new CustomerFrame();
      JLabel header = frame.title(this.name);
      customerFrame.add(header);

      JLabel schpeel = new JLabel("How may we be of service?", JLabel.CENTER);
      schpeel.setForeground(Color.WHITE);
      customerFrame.add(schpeel);

      frame.addToPane(customerFrame.getContentPane());

      customerFrame.setSize(500, 300);
      customerFrame.setLocation(200, 100);
      customerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      customerFrame.setVisible(true);
    }


  /*
   * THE CUSTOMER FRAME  !
   */
  public class CustomerFrame extends JFrame implements ItemListener {
    JPanel options;

    public void addToPane(Container pane) {
        JPanel menu = new JPanel();
        menu.setBackground(Color.PINK);
        String banking[] = { "View Account Summary",
          "Withdraw",
          "Deposit",
          "Open a New Account",
          "View Transaction History",
          "Take Out a Loan",
          "Close an account"};

        JComboBox dropDown = new JComboBox(banking);
        dropDown.setEditable(false);
        dropDown.addItemListener(this);
        menu.add(dropDown);

        JButton checkingSum = new JButton("Checking");
        JButton savingsSum = new JButton("Savings");
        JPanel summary = new JPanel();
        summary.setBackground(Color.PINK);
        summary.add(checkingSum);
        summary.add(savingsSum);
        SummaryListener checkSumL = new SummaryListener("Checking");
        SummaryListener savingsSumL = new SummaryListener("Savings");
        checkingSum.addActionListener(checkSumL);
        savingsSum.addActionListener(savingsSumL);

        JButton checkingW = new JButton("Checking");
        JButton savingsW = new JButton("Savings");
        JPanel withdraw = new JPanel();
        withdraw.setBackground(Color.PINK);
        withdraw.add(checkingW);
        withdraw.add(savingsW);
        AccountListener checkWL = new AccountListener("Checking", "Withdraw");
        AccountListener savingsWL = new AccountListener("Savings", "Withdraw");
        checkingW.addActionListener(checkWL);
        savingsW.addActionListener(savingsWL);

        JButton checkingD = new JButton("Checking");
        JButton savingsD = new JButton("Savings");
        JPanel deposit = new JPanel();
        deposit.setBackground(Color.PINK);
        deposit.add(checkingD);
        deposit.add(savingsD);
        AccountListener checkDL = new AccountListener("Checking", "Deposit");
        AccountListener savingsDL = new AccountListener("Savings", "Deposit");
        checkingD.addActionListener(checkDL);
        savingsD.addActionListener(savingsDL);

        JButton checkingC = new JButton("Checking");
        JButton savingsC = new JButton("Savings");
        JPanel create = new JPanel();
        create.setBackground(Color.PINK);
        create.add(checkingC);
        create.add(savingsC);
        CreateListener checkCL = new CreateListener("Checking");
        checkingC.addActionListener(checkCL);
        CreateListener savingsCL = new CreateListener("Savings");
        savingsC.addActionListener(savingsCL);

        
        //i added close options here
        JButton checkingClose = new JButton("Checking");
        JButton savingsClose = new JButton("Savings");
        JPanel close = new JPanel();
        close.setBackground(Color.PINK);
        close.add(checkingClose);
        close.add(savingsClose);
        CloseListener checkCLose = new CloseListener("Checking");
        CloseListener savingsCLose = new CloseListener("Savings");
        checkingClose.addActionListener(checkCLose);
        savingsClose.addActionListener(savingsCLose);

        JPanel loan = new JPanel();
        loan.setBackground(Color.PINK);
        JTextField loanAmount = new JTextField(7);
        JTextField loanCurr = new JTextField(3);

        if (Customer.this.collateral.isEmpty()) {
          loan.add(new JLabel("Insufficient collateral to take out a loan."));
        } else {
          boolean hasChecking = false;
          for (Account acc : Customer.this.accounts) {
            if (acc instanceof Checking) {
              hasChecking = true;
              loan.add(new JLabel("Amount:")).setForeground(Color.WHITE);
              loan.add(loanAmount);

              loan.add(new JLabel("Curr. Country Code:")).setForeground(Color.WHITE);
              loan.add(loanCurr);
              JButton sub = new JButton("Submit");
              loan.add(sub);

              sub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  String loan = loanAmount.getText();
                  String curr = loanCurr.getText();

                  boolean success = false;
                  for (Currency allowed : Bank.currencies) {
                    if (curr.equals(allowed.getCountry())) {
                      success = true;
                      Loan poor = new Loan(Double.parseDouble(loan));
                      loans.add(poor);
                      try {
                        Customer.this.collateral.pop();
                      } catch (Exception except) {
                        CollateralDNEPanel collat = new CollateralDNEPanel();
                        return;
                      }
                      acc.deposit(poor.moneyBack(), curr);
                      break;
                    }
              }
              LoanPanel loanWindow = new LoanPanel(loan, success);
            }
          });

              break;
            }
          } if (!hasChecking) {
            loan.add(new JLabel("Only customers with Checking accounts can take out loans."));
          }
        }

        JButton display = new JButton("Show");
        JPanel history = new JPanel();
        history.setBackground(Color.PINK);
        history.add(display);
        TransactionHistoryListener historyL = new TransactionHistoryListener();
        display.addActionListener(historyL);

        // creating the drop down menu
        options = new JPanel(new CardLayout());
        options.setBackground(Color.PINK);
        options.add(summary, "View Account Summary");
        options.add(withdraw, "Withdraw");
        options.add(deposit, "Deposit");
        options.add(create, "Open a New Account");
        options.add(loan, "Take Out a Loan"); // pop up window for this?
        options.add(history, "View Transaction History"); // buttons here and then depending on which will get pop up window
        options.add(close,"Close an account");

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
    welcome.setForeground(Color.WHITE);
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

  class AccountListener implements ActionListener {
    String accType;
    String transaction;
    public AccountListener(String type, String txn) {
     this.accType = type;
     this.transaction = txn;
    }

    public void actionPerformed( ActionEvent e ) {
      System.out.println("Open the customer's checking account, if it exists.");

      boolean success = false;
      if (Customer.this.accounts != null) {
        for (Account account : Customer.this.accounts) {
          if (account.getType().equals(this.accType)) {
            System.out.println(account.getType() + "        " + this.transaction);
            SavecheckFrame window = new SavecheckFrame(account, this.transaction);
            window.halfframe.setVisible(true);
            success = true;
          }
        }
      }
      if (!success) {
        AccountDNEPanel dne = new AccountDNEPanel(this.accType, Customer.this.name);
      }
    }
  }

  class SummaryListener implements ActionListener {
    String accType;
    public SummaryListener(String type) {
      this.accType = type;
    }

    public void actionPerformed( ActionEvent e ) {
      boolean success = false;
      if (Customer.this.accounts != null) {
        for (Account account : Customer.this.accounts) {
          if (account.getType().equals(this.accType)) {
            SavecheckFrame window = new SavecheckFrame(account, true);
            window.justframe.setVisible(true);
            success = true;
          }
        }
      }
      if (!success) {
        AccountDNEPanel dne = new AccountDNEPanel(this.accType, Customer.this.name);
      }
    }
  }

  class CreateListener implements ActionListener {
    String accType;

    public CreateListener(String type) {
      this.accType = type;
    }
    public void actionPerformed( ActionEvent e ) {
      System.out.println("Here to create a customer's " + this.accType + " account!");

      boolean success = false;
      for (Account account : Customer.this.accounts) {
        if (account.getType().equals(accType)) {
          AccountEPanel exists = new AccountEPanel(this.accType, Customer.this.name);
          success = true;
          break;
        }
      }

      if (!success) {
        if (accType.equals("Checking")) {
          Checking newCheck = new Checking();
          SavecheckFrame window = new SavecheckFrame(newCheck, "Deposit");
          window.halfframe.setVisible(true);
          Customer.this.accounts.add(newCheck);

        } else if (accType.equals("Savings")) {
          Savings newSavings = new Savings();
          SavecheckFrame window = new SavecheckFrame(newSavings, "Deposit");
          window.halfframe.setVisible(true);
          Customer.this.accounts.add(newSavings);
        }
      }
    }
  }
  //i am closing it.
  class CloseListener implements ActionListener {
	    String accType;
	    public CloseListener(String type) {
	      this.accType = type;
	    }
	    public void actionPerformed( ActionEvent e ) {
	      System.out.println("Here to close a customer's " + this.accType + " account!");
	      boolean success = false;
	      for (Account account : Customer.this.accounts) {
	        if (account.getType().equals(accType)) {
		 		       JOptionPane.showMessageDialog(null, "you closed "+account.getType());
	        	accounts.remove(account);
	          success = true;
	          break;
	        }
	      }
	      if(!success) {
		 	      JOptionPane.showMessageDialog(null, " does not have a '" + accType + "' account");
	      }
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
   * COLLATERAL DNE PANEL
   */
  public class CollateralDNEPanel extends JPanel {
     public CollateralDNEPanel() {
      JOptionPane.showMessageDialog(this, "Insufficent collateral to take out a loan", "Invalid Request", JOptionPane.ERROR_MESSAGE);
    }
  }

  /*
   *  ACCOUNT DNE PANEL
   */
  public class AccountDNEPanel extends JPanel {

    public AccountDNEPanel(String accType, String customer) {
      JOptionPane.showMessageDialog(this, customer + " does not have a '" + accType + "' account", "Invalid Request", JOptionPane.ERROR_MESSAGE);
    }
  }

  /*
   * ACCOUNT ALREADY EXISTS FRAME
   */
    public class AccountEPanel extends JPanel {

    public AccountEPanel(String accType, String customer) {
      JOptionPane.showMessageDialog(this, customer + " already has a '" + accType + "' account", "Invalid Request", JOptionPane.ERROR_MESSAGE);
    }
  }

  /*
   * TRANSACTION HISTORY FRAME
   */
  public class TransactionHistoryFrame extends JFrame {
    public TransactionHistoryFrame() {
      this.setTitle("Rich Man's Bank — " + Customer.this.name + " Transaction History");
      this.setLayout(new GridLayout(2, 1));
      this.getContentPane().setBackground(Color.PINK);

      SimpleDateFormat df = new SimpleDateFormat("EEEE, MMMM d 'at' h:mm a z ");
      Date now = new Date();
      String curr = df.format(now);
      JLabel schpeel = new JLabel("        Transaction history acquired " + curr + "         ", JLabel.CENTER);
      schpeel.setForeground(Color.WHITE);
      this.add(schpeel);

      JPanel panel = new JPanel();
      List<Transaction> history = Customer.this.getHistoryAllAcc();
      panel.setBackground(Color.PINK);
      if (history == null) {
        panel.setLayout(new GridLayout(2, 1));

        panel.add(new JLabel("No recent transactions.", JLabel.CENTER)).setBackground(Color.WHITE);
        this.add(panel);

      } else {
        panel.setLayout(new GridLayout(0, 2));
        for (Account acc : Customer.this.accounts) {
          String capsType = acc.getType().toUpperCase();
          panel.add(new JLabel(capsType, JLabel.CENTER)).setForeground(Color.WHITE);
          panel.add(new JLabel("AMOUNT", JLabel.CENTER)).setForeground(Color.WHITE);
          for (Transaction txn : acc.view_txns()) {
            panel.add(new JLabel(txn.getId(), JLabel.CENTER)).setForeground(Color.WHITE);
            panel.add(new JLabel("$" + txn.getAmount(), JLabel.CENTER)).setForeground(Color.WHITE);
            this.add(panel);
          }
          panel.add(new JLabel("Current Value", JLabel.CENTER)).setForeground(Color.WHITE);
          panel.add(new JLabel("$" + acc.view_balance(), JLabel.CENTER)).setForeground(Color.WHITE);
          panel.add(new JLabel("")).setForeground(Color.WHITE);
          panel.add(new JLabel("")).setForeground(Color.WHITE);
        }
      }
      this.pack();
      this.setLocation(650, 100);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      this.setVisible(true);
    }
  }

  /*
   * TAKE OUT A LOAN FRAME
   */
  public class LoanPanel extends JPanel {
    public LoanPanel(String amnt, boolean validCurr) {
      if (validCurr) {
        double tryingTo = Double.parseDouble(amnt);
        if (tryingTo < 0.0) {
          JOptionPane.showMessageDialog(this, "Loans cannot be taken out for negative amounts.", "Loan Request Failure", JOptionPane.ERROR_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(this, "$" + amnt + " added to your primary Checking account.", "Loan Approved", JOptionPane.INFORMATION_MESSAGE);
        }
      } else {
        JOptionPane.showMessageDialog(this, "Currency not currently supported at this bank.", "Loan Request Failure", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  public static void test() throws Exception{
    Bank richMan = new Bank();
    Checking check = new Checking(100.0);
    check.deposit(900, "USD");
    Savings save = new Savings(100.0);
    save.withDraw(100, "USD");
    List<Account> acc = new LinkedList<Account>();
    acc.add(check);
    acc.add(save);
    Customer me = new Customer(acc, "Deborah Reynolds", "dbreynolds", "1234");
    System.out.println(me.getAccounts());
    me.makeFrame();
  }
}
