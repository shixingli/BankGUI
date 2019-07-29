import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class Manager{
   private static String id = "Louis";
   private static String password = "123456";
   private HashMap<String,Customer> customerHM;
   private static double accessFee = 3.0;
   private static double withdrawFee = 3.0;
   private static double depositFee = 3.0;
   private static double closeFee = 3.0;
   private static double interest = 0.015;

   private class ManagerFrame extends JFrame {// GUI for the Manager part. Inner class for encapsulation since no other classes should be able to access this part???
       private JFrame MFrame;

       private ManagerFrame() {
           JFrame frame = new JFrame("RichManBank's Esteemed Manager");
           frame.setLayout(new GridLayout(3, 3));
           frame.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.DARK_GRAY));
           frame.setLocation(100, 100);
           frame.setSize(800, 400);
           frame.setLocation(200, 100);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.add(searchCustomerID());
           frame.add(listOfDebtors());
           frame.add(managerOptions());
           this.MFrame = frame;
       }

       private JPanel searchCustomerID() {
           JPanel SearchPanel = new JPanel();

           SearchPanel.setLayout(new GridLayout(3, 2));
           SearchPanel.add(new JLabel("Seach for Customer: "));

           JTextField tf = new JTextField("(Enter ID)");
           tf.setPreferredSize( new Dimension( 100, 30 ) );
           SearchPanel.add(tf);

           tf.addActionListener(e -> {
               String customerID = tf.getText();
               if(customerHM.containsKey(customerID)){
                   customerOverview(customerHM.get(customerID));
               }
               else{
                   JOptionPane.showMessageDialog(null, "Invalid Customer ID!");
               }
           });
           return SearchPanel;
       }

       private JPanel listOfDebtors(){
           JPanel DebtPanel = new JPanel();
           DebtPanel.setLayout(new GridLayout(2,2));
           DebtPanel.add(new JLabel("List of Debtors: "));

           String[] names = new String[customerHM.size()];
           int i = 0;
            for(Map.Entry<String,Customer> e: customerHM.entrySet()){
               if (e.getValue().getLoan().isEmpty()) {
                   names[i] = e.getValue().getUsername();
               }
               i++;
           }
           JList list = new JList(names);
           list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
           list.setLayoutOrientation(JList.VERTICAL);
           list.setVisibleRowCount(3);
           list.addMouseListener(new MouseAdapter() {
               public void mouseClicked(MouseEvent e) {
                   if (e.getClickCount() == 2) {
                       Customer selectedItem = customerHM.get(list.getSelectedValue());
                        customerOverview(selectedItem);
                   }
               }
           });

           JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           scrollPane.setMinimumSize(new Dimension(100, 50));

           DebtPanel.add(scrollPane);
           return DebtPanel;
       }

       private JPanel managerOptions(){
           JPanel p = new JPanel();
           JButton daily_transactions = new JButton("Daily Transactions");
           daily_transactions.addActionListener((ActionEvent e) ->{
               dailyTransactions(customerHM);
           });
           p.add(daily_transactions);

           JButton interest_rate = new JButton("Interest Rate Options");
           interest_rate.addActionListener(e->{
               interestRates();
           });
           p.add(interest_rate);

           JButton access_fee = new JButton("Access Fee");
           access_fee.addActionListener(e->{
               accessFee();
           });
           p.add(access_fee);

           JButton withdraw_fee = new JButton("Withdraw Fee");
           withdraw_fee.addActionListener(e->{
               withdrawFee();
           });
           p.add(withdraw_fee);

           JButton depositFee = new JButton("Deposit Fee");
           depositFee.addActionListener(e->{
               depositFee();
           });
           p.add(depositFee);

           JButton closing_fee = new JButton("Closing Fee");
           closing_fee.addActionListener(e->{
               closeFee();
           });
           p.add(closing_fee);

           return p;
       }

       private void interestRates(){
           JFrame j = new JFrame();
           JPanel p = new JPanel();
           JLabel current = new JLabel("Current Interest Rates is: " + (interest*100) + "%");
           j.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.DARK_GRAY));
           j.setLayout(new GridLayout(4,2));
           JTextField new_interest_rate = new JTextField("(Enter a valid rate in percent)");
           new_interest_rate.setSize(400,100);
           j.setSize(300,300);
           j.add(current);
           JButton change_interest_rate = new JButton("Change Interest Rate");
           change_interest_rate.addActionListener(actionEvent -> {
               double input =  Double.parseDouble(new_interest_rate.getText()) / 100;
               interest = input;
               j.setVisible(false);
           });
           p.add(new_interest_rate);
           p.add(change_interest_rate);
           j.add(p);
           j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           j.setVisible(true);
       }

       private void accessFee(){
           JFrame j2 = new JFrame();
           JPanel p = new JPanel();
           JLabel current = new JLabel("Current Account Access fee is: " + accessFee + "USD");
           j2.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.DARK_GRAY));
           j2.setLayout(new GridLayout(4,2));
           JTextField new_fee = new JTextField("Enter a valid fee");
           new_fee.setSize(400,100);
           j2.setSize(300,300);
           j2.add(current);
           JButton change_access_fee = new JButton("Change Access Fee");
           change_access_fee.addActionListener(actionEvent -> {
               double input =  Double.parseDouble(new_fee.getText());
               accessFee = input;
               j2.setVisible(false);
           });
           p.add(new_fee);
           p.add(change_access_fee);
           j2.add(p);
           j2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           j2.setVisible(true);
       }

       private void withdrawFee(){
           JFrame j3 = new JFrame();
           JPanel p = new JPanel();
           j3.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.DARK_GRAY));
           JLabel current = new JLabel("Current Withdraw fee is: " + withdrawFee + "USD");
           j3.setLayout(new GridLayout(4,2));
           JTextField new_fee = new JTextField("Enter a valid fee");
           new_fee.setSize(400,100);
           j3.setSize(300,300);
           j3.add(current);
           JButton change_withdraw_fee = new JButton("Change Withdraw Fee");
           change_withdraw_fee.addActionListener(actionEvent -> {
               double input =  Double.parseDouble(new_fee.getText());
               withdrawFee = input;
               j3.setVisible(false);
           });
           p.add(new_fee);
           p.add(change_withdraw_fee);
           j3.add(p);
           j3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           j3.setVisible(true);
       }

       private void depositFee(){
           JFrame j4 = new JFrame();
           JPanel p = new JPanel();
           j4.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.DARK_GRAY));
           JLabel current = new JLabel("Current Deposit fee is: " + depositFee + "USD");
           j4.setLayout(new GridLayout(4,2));
           JTextField new_fee = new JTextField("Enter a valid fee");
           new_fee.setSize(400,100);
           j4.setSize(300,300);
           j4.add(current);
           JButton change_deposit_fee = new JButton("Change Deposit Fee");
           change_deposit_fee.addActionListener(actionEvent -> {
               double input =  Double.parseDouble(new_fee.getText());
               depositFee = input;
               j4.setVisible(false);
           });
           p.add(new_fee);
           p.add(change_deposit_fee);
           j4.add(p);
           j4.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           j4.setVisible(true);
       }

       private void closeFee(){
           JFrame j5 = new JFrame();
           JPanel p = new JPanel();
           j5.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.DARK_GRAY));
           JLabel current = new JLabel("Current Close fee is: " + closeFee + "USD");
           j5.setLayout(new GridLayout(4,2));
           JTextField new_fee = new JTextField("Enter a valid fee");
           new_fee.setSize(400,100);
           j5.setSize(300,300);
           j5.add(current);
           JButton change_closing_fee = new JButton("Change Closing Fee");
           change_closing_fee.addActionListener(actionEvent -> {
               double input =  Double.parseDouble(new_fee.getText());
               closeFee = input;
               j5.setVisible(false);
           });
           p.add(new_fee);
           p.add(change_closing_fee);
           j5.add(p);
           j5.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           j5.setVisible(true);
       }

       private void dailyTransactions(HashMap<String, Customer> c){
           StringBuilder info = new StringBuilder();
           for(Map.Entry<String,Customer> e: customerHM.entrySet()){
               if(!e.getValue().getHistoryAllAcc().isEmpty()){
                   info.append(e.getValue().getName() + " ");
                   info.append(e.getValue().getHistoryAllAcc());
                   info.append(System.lineSeparator());
               }
           }
           if(info.toString().equals("")){
               info.append("No Transactions of All Customer Accounts");
           }
           JOptionPane.showMessageDialog(null,info.toString());
       }



       private void customerOverview(Customer c){
           StringBuilder info = new StringBuilder();
           info.append(c.getName());
           info.append(System.lineSeparator());
           info.append(c.getAccounts());
           info.append(System.lineSeparator());
           info.append(c.getTotalBalance());
           if(!c.getLoan().isEmpty()){
               info.append(System.lineSeparator());
               info.append(c.getLoan());
           }
           JOptionPane.showMessageDialog(null,info.toString());
       }

   }//End of Manager Frame

    private Manager(HashMap c){
       this.customerHM = c;
       ManagerFrame mf = new ManagerFrame();

      mf.MFrame.setVisible(true);
    }

    public static boolean isManager(String id, String password){
      boolean isIt = false;
      if(Manager.id.equals(id) && Manager.password.equals(password)){
        isIt = true;
      }
      else{
        System.out.println("login unsuccessful");
      }
      return isIt;
    }

    public static double getAccountFee() {
        return accessFee;
    }

    public static double getDepositFee() {
        return depositFee;
    }

    public static double getWithdrawFee() {
        return withdrawFee;
    }

    public static double getCloseFee() {
        return closeFee;
    }

    public static double getInterest(){
       return interest;
    }

    public static void main(String[] args){
        Bank b = new RichManBank();
        HashMap<String, Customer> customers = new HashMap<>();
        Checking check = new Checking(100.0);
        check.deposit(900, "USD");
        Savings save = new Savings(100.0);
        save.withDraw(100, "USD");
        List<Account> acc = new LinkedList<Account>();
        acc.add(check);
        acc.add(save);
        Customer me = new Customer(acc, "Deborah Reynolds", "dbreynolds", "1234");
        Customer s = new Customer(acc, "Louis Tannudin", "ltann", "1234");
        customers.put("dbreynolds", me);
        customers.put("ltann", s);
        customers.put("ltannn", new Customer(acc, "Louis Tannudin", "ltann", "1234"));
        customers.put("ltannnn", new Customer(acc, "Louis Tannudin", "ltann", "1234"));

        Manager m = new Manager(customers);
    }
}
