import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class CustomerFrame implements ItemListener {
    JPanel options;
    Customer customer;
     
    public void addToPane(Container pane) {
        JPanel menu = new JPanel();
        
        String banking[] = { "View Account Summary", 
          "Withdraw", 
          "Deposit", 
          "Create New Account", 
          "View Transaction History" };
        
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
    
     
    private static void makeFrame() {
      JFrame customerFrame = new JFrame("Rich Man's Bank — " + "Client's Name" + " Financial Summary");
      customerFrame.setLayout(new GridLayout(4, 1));
      customerFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.WHITE));
      
      //JLabel header = title(client.getName());
      JLabel header = title("DEFAULT");
      JLabel schpeel = new JLabel("How may we be of service?", JLabel.CENTER);
      customerFrame.add(header);
      customerFrame.add(schpeel);
      
      CustomerFrame frame = new CustomerFrame();
      frame.addToPane(customerFrame.getContentPane());
      
      customerFrame.setSize(450, 250);
      customerFrame.setLocation(200, 100);
      customerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      customerFrame.setVisible(true);
    }
    
    /* creates the title and border for the frame */
  public static JLabel title (String customerName) {
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
      System.out.println( "Checking button clicked" );
    }
  }
  
    class SavingsListener implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      System.out.println( "Savings button clicked" );
    }
  }
    // write code  for a method for Bank to call which takes in a customer and is used in the creation of the frame
  
//  public static void startInteraction(Customer client) {
//    makeFrame(client);
//  }
  
    public static void main(String[] args) {
      Customer test = new Customer();
      makeFrame();
    }
}
