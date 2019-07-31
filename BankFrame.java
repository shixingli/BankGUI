 // package bank;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.TextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JPasswordField;


public class BankFrame {
 JFrame bankframe,accframe;
 JPanel Official,Customer;
 JButton Official_click,Customer_Click;
 JLabel creator,Username_label,Title,user_passwordlabel,official_label,official_label2;
 JTextField official_username,user_name,user_password,official_password;
 private JPasswordField customerpwd;
 private JPasswordField officialpwd;
 private JTextField username;
 private JTextField userid;
 private JTextField userpwd;
 private JButton checkingBTN;
 private JButton BothBTn;
 private JLabel lblNewLabel;
 private Account check = new Checking(0.0);
 private Account saving = new Savings(0.0);

 /**
  * Launch the application.
  */



 public BankFrame(HashMap<String, Customer> customers) {
  initialize(customers);
 }
 public BankFrame(Manager bankManager, HashMap<String, Customer> customers) {
  initialize(bankManager,customers);
 }





 private void initialize(HashMap<String, Customer> customers) {
  accframe = new JFrame();
  accframe.setResizable(false);
  accframe.setBounds(100, 100, 500, 325);
  accframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  accframe.getContentPane().setBackground(Color.PINK);
  accframe.getContentPane().setLayout(null);

  JLabel lblCreateUsername = new JLabel("Name (first and last):");
  lblCreateUsername.setForeground(Color.WHITE);
  lblCreateUsername.setBounds(68, 64, 173, 16);
  accframe.getContentPane().add(lblCreateUsername);

  JLabel lblCreateUserid = new JLabel("Create your id:");
  lblCreateUserid.setForeground(Color.WHITE);
  lblCreateUserid.setBounds(68, 105, 140, 16);
  accframe.getContentPane().add(lblCreateUserid);

  JLabel lblCreateYourId = new JLabel("Create your password:");
  lblCreateYourId.setForeground(Color.WHITE);
  lblCreateYourId.setBounds(68, 148, 140, 16);
  accframe.getContentPane().add(lblCreateYourId);

  username = new JTextField();
  username.setBounds(268, 59, 130, 26);
  accframe.getContentPane().add(username);
  username.setColumns(10);

  userid = new JTextField();
  userid.setColumns(10);
  userid.setBounds(268, 100, 130, 26);
  accframe.getContentPane().add(userid);

  userpwd = new JTextField();
  userpwd.setColumns(10);
  userpwd.setBounds(268, 143, 130, 26);
  accframe.getContentPane().add(userpwd);

  JButton Saving_btn = new JButton("Saving Account ");
  Saving_btn.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
	   if(userpwd.getText().equals("")) {
		   JOptionPane.showMessageDialog(null, "enter your password!!");
		   return;
	   }
		 if(customers.containsKey(userid.getText())) {
			   JOptionPane.showMessageDialog(null, "your id is already existed!!");
			 return;
			}
    Customer newcust = new Customer(saving,username.getText(),userid.getText(),userpwd.getText());
    customers.put(userid.getText(),newcust);
    JOptionPane.showMessageDialog(null, "Your saving account is all set, please log in with your username and password");
    accframe.dispose();
   }
  });
  Saving_btn.setBounds(181, 243, 145, 29);
  accframe.getContentPane().add(Saving_btn);

  checkingBTN = new JButton("Checking Account ");
  checkingBTN.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
	   if(userpwd.getText().equals("")) {
		   JOptionPane.showMessageDialog(null, "enter your password!!");
		   return;
	   }
		 if(customers.containsKey(userid.getText())) {
			   JOptionPane.showMessageDialog(null, "your id is already existed!!");
			 return;
			}
    Customer newcust = new Customer(check,username.getText(),userid.getText(),userpwd.getText());
    customers.put(userid.getText(),newcust);
    JOptionPane.showMessageDialog(null, "Your checking account is all set, please log in with your username and password");
    accframe.dispose();
   }
  });
  checkingBTN.setBounds(21, 243, 153, 29);
  accframe.getContentPane().add(checkingBTN);

  BothBTn = new JButton("Both");
  BothBTn.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
	   if(userpwd.getText().equals("")) {
		   JOptionPane.showMessageDialog(null, "enter your password!!");
		   return;
	   }
	 if(customers.containsKey(userid.getText())) {
		   JOptionPane.showMessageDialog(null, "your id is already existed!!");
		 return;
		}
    Customer newcust = new Customer(check,username.getText(),userid.getText(),userpwd.getText());
    newcust.addAccount(saving);
    customers.put(userid.getText(),newcust);
    JOptionPane.showMessageDialog(null, "Your two accounts are all set, please log in with your username and password");
    accframe.dispose();
   }
  });
  BothBTn.setBounds(327, 243, 117, 29);
  accframe.getContentPane().add(BothBTn);

  lblNewLabel = new JLabel("What type of account you want to open?");
  lblNewLabel.setForeground(Color.WHITE);
  lblNewLabel.setBounds(95, 201, 282, 16);
  accframe.getContentPane().add(lblNewLabel);


 }
 private void initialize(Manager bankManager, HashMap<String, Customer> customers) {
  bankframe = new JFrame();
  bankframe.setResizable(false);
  bankframe.setBounds(200, 200, 475, 350);
  bankframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  bankframe.getContentPane().setBackground(Color.PINK);
  bankframe.getContentPane().setLayout(null);

  Customer = new JPanel();
  Customer.setBorder(new EmptyBorder(0, 0, 0, 0));
  Customer.setBackground(Color.PINK);
  Customer.setBounds(6, 95, 210, 159);
  bankframe.getContentPane().add(Customer);
  Customer.setLayout(null);

  Customer_Click = new JButton("Customer Login");
  Customer_Click.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
     if (customers.containsKey(user_name.getText()) && customers.get(user_name.getText()).getpwd().equals(customerpwd.getText())) {
      //id for now
      customers.get(user_name.getText()).makeFrame();
     }
     else {
     JOptionPane.showMessageDialog(null, "username or password is not correct");
     }
//    JOptionPane.showMessageDialog(null, "username or password is not correct");
    //pops out Customer frame if they correctly match the credentials
   }
  });
  Customer_Click.setBounds(59, 94, 145, 29);
  Customer.add(Customer_Click);

  user_name = new JTextField();
  user_name.setBounds(79, 15, 106, 26);
  Customer.add(user_name);
  user_name.setColumns(10);

  Username_label = new JLabel("Username:");
  Username_label.setForeground(Color.WHITE);
  Username_label.setBounds(6, 20, 75, 16);
  Customer.add(Username_label);

  customerpwd = new JPasswordField();
  customerpwd.setBounds(79, 56, 107, 26);
  Customer.add(customerpwd);

  user_passwordlabel = new JLabel("Password:");
  user_passwordlabel.setForeground(Color.WHITE);
  user_passwordlabel.setBounds(6, 61, 75, 16);
  Customer.add(user_passwordlabel);

  JButton createaccBTN = new JButton("Create an Account");
  createaccBTN.setBounds(59, 129, 145, 29);
  Customer.add(createaccBTN);
  createaccBTN.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
		    BankFrame window = new BankFrame(customers);
		     window.accframe.setVisible(true);
//		    JOptionPane.showMessageDialog(null, err+ "your id is already existed!!");
   }
  });

  Official = new JPanel();
  Official.setBorder(new EmptyBorder(0, 0, 0, 0));
  Official.setBackground(Color.PINK);
  Official.setBounds(234, 95, 210, 143);
  bankframe.getContentPane().add(Official);
  Official.setLayout(null);

  Official_click = new JButton("Official Login");
  Official_click.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if(bankManager.isManager(official_username.getText(),officialpwd.getText())==true){
      Manager mymana = new Manager(customers,"louis","1234");
    	mymana.createMFrame();
   }
   else {
    JOptionPane.showMessageDialog(null, "manager password or username is wrong");

   }
   }
  });

  Official_click.setForeground(Color.BLACK);
  Official_click.setBounds(62, 94, 142, 29);
  Official.add(Official_click);

  official_label = new JLabel("Username:");
  official_label.setForeground(Color.WHITE);
  official_label.setBounds(6, 20, 75, 16);
  Official.add(official_label);

  official_username = new JTextField();
  official_username.setColumns(10);
  official_username.setBounds(75, 15, 106, 26);
  Official.add(official_username);

  official_label2 = new JLabel("Password:");
  official_label2.setForeground(Color.WHITE);
  official_label2.setBounds(6, 61, 75, 16);
  Official.add(official_label2);

  officialpwd = new JPasswordField();
  officialpwd.setBounds(75, 56, 107, 26);
  Official.add(officialpwd);

  Title = new JLabel("Richman's Bank");
  Title.setForeground(Color.WHITE);
  Title.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
  Title.setHorizontalAlignment(SwingConstants.CENTER);
  Title.setBounds(59, 31, 329, 52);
  bankframe.getContentPane().add(Title);

  creator = new JLabel("Made by: Amanda, Louis, Shizhen");
  creator.setForeground(Color.WHITE);
  creator.setHorizontalAlignment(SwingConstants.CENTER);
  creator.setBounds(79, 256, 309, 16);
  bankframe.getContentPane().add(creator);
 }
}
