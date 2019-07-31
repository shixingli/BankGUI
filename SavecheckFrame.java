 // package bank;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

 public class SavecheckFrame {
 JFrame savecheckframe,halfframe,justframe;
 JLabel Gosaving,gochecking;
 private JTextField deposite_amount;
 private JTextField withdraw_amount;
 private JTextField transfer_amount;
 private JTextField amout_money;


 /**
  * Launch the application.
  */
 public static void main(String[] args) {
//   Account saving = new Savings(0.00);
//   SavecheckFrame window = new SavecheckFrame(saving) ;
//   window.savecheckframe.setVisible(true);
  // SavecheckFrame window1 = new SavecheckFrame(saving,"withdraw") ;
  // window1.halfframe.setVisible(true);
 }


 public SavecheckFrame(Account savechecking) {
  initialize(savechecking);
 }

 public SavecheckFrame(Account savechecking, String actions) {
  half_init(savechecking,actions);
 }
 public SavecheckFrame(Account savechecking,boolean flag) {
  init(savechecking,flag);
 }

 private void init(Account savechecking,boolean flag) {
  justframe = new JFrame();
  justframe.setResizable(false);
  justframe.setBounds(100, 100, 450, 300);
  justframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  justframe.getContentPane().setLayout(null);
  justframe.getContentPane().setBackground(Color.PINK);


  JScrollPane scrollPane_1 = new JScrollPane(null,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  scrollPane_1.setBounds(0, 0, 450, 278);
  justframe.getContentPane().add(scrollPane_1);

  if(savechecking instanceof Savings) {
   for(Transaction txn: savechecking.view_txns()) {
    scrollPane_1.add(new JLabel(txn.getId()+" $ " + txn.getAmount()));

   }
  }
  else {
   for(Transaction txn: savechecking.view_txns()) {
    scrollPane_1.add(new JLabel(txn.getId()+" $ " + txn.getAmount()));
   }
  }
   //   JPanel panel = new JPanel();
  //
  // justframe.getContentPane().add(panel);
  //
  // if(savechecking instanceof Savings) {
  //  for(Transaction txn: savechecking.view_txns()) {
   //           panel.add(new JLabel(txn.getId()+" $ " + txn.getAmount()));
  //
  //  }
  // }
  // else {
  //  for(Transaction txn: savechecking.view_txns()) {
   //           panel.add(new JLabel(txn.getId()+" $ " + txn.getAmount()));
  //  }
  // }
 }

 private void half_init(Account savechecking, String action ) {
  halfframe = new JFrame();
  halfframe.setResizable(false);
  halfframe.setBounds(100, 100, 475, 325);
  halfframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  halfframe.getContentPane().setLayout(null);
  halfframe.getContentPane().setBackground(Color.PINK);


  JLabel lblNewLabel = new JLabel(action);
  lblNewLabel.setForeground(Color.WHITE);
  lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
  lblNewLabel.setBounds(105, 6, 210, 77);
  halfframe.getContentPane().add(lblNewLabel);

  JButton btnNewButton = new JButton(action+ " CAD");
  btnNewButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if(action.equals("Deposit")) {
     try {
      double amount= Double.parseDouble(amout_money.getText());
      savechecking.deposit(amount,"CAD");

     }catch(Exception e1) {
      JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
     }
    }
    else {
     try {
      double amount= Double.parseDouble(amout_money.getText());
      savechecking.withDraw(amount,"CAD");

     }catch(Exception e1) {
      JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
     }
    }
   }
  });
//  btnNewButton.addMouseListener(new MouseAdapter() {
//   @Override
//   public void mouseClicked(MouseEvent e) {
//    if(action.equals("Deposit")) {
//     try {
//      double amount= Double.parseDouble(amout_money.getText());
//      savechecking.deposit(amount,"CAD");
//
//     }catch(Exception e1) {
//      JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
//     }
//    }
//    else {
//     try {
//      double amount= Double.parseDouble(amout_money.getText());
//      savechecking.withDraw(amount,"CAD");
//
//     }catch(Exception e1) {
//      JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
//     }
//    }
//   }
//  });
  btnNewButton.setBounds(166, 160, 122, 29);
  halfframe.getContentPane().add(btnNewButton);

  JButton USDBUTTON = new JButton(action + " USD");
  USDBUTTON.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if(action.equals("Deposit")) {
     try {
      double amount= Double.parseDouble(amout_money.getText());
      savechecking.deposit(amount,"USD");

     }catch(Exception e1) {
      JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
     }
    }
    else {
     try {
      double amount= Double.parseDouble(amout_money.getText());
      savechecking.withDraw(amount,"USD");

     }catch(Exception e1) {
      JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
     }
    }
   }
  });
  USDBUTTON.setBounds(6, 160, 148, 29);
  halfframe.getContentPane().add(USDBUTTON);

  JButton btnDepositeBitcoin = new JButton(action + " Bitcoin");
  btnDepositeBitcoin.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if(action.equals("Deposit")) {
     try {
      double amount= Double.parseDouble(amout_money.getText());
      savechecking.deposit(amount,"BIT");
      JOptionPane.showMessageDialog(null, "deposited " + amount +"!");

     }catch(Exception e1) {
      JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
     }
    }
    else {
     try {
      double amount= Double.parseDouble(amout_money.getText());
      savechecking.withDraw(amount,"Bitcoin");
      JOptionPane.showMessageDialog(null, "withDraw " + amount +"!");

     }catch(Exception e1) {
      JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
     }
    }
   }
  });
//  btnDepositeBitcoin.addMouseListener(new MouseAdapter() {
//   @Override
//   public void mouseClicked(MouseEvent e) {
//    if(action.equals("Deposit")) {
//     try {
//      double amount= Double.parseDouble(amout_money.getText());
//      savechecking.deposit(amount,"BIT");
//      JOptionPane.showMessageDialog(null, "deposited " + amount +"!");
//
//     }catch(Exception e1) {
//      JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
//     }
//    }
//    else {
//     try {
//      double amount= Double.parseDouble(amout_money.getText());
//      savechecking.withDraw(amount,"Bitcoin");
//      JOptionPane.showMessageDialog(null, "withDraw " + amount +"!");
//
//     }catch(Exception e1) {
//      JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
//     }
//    }
//   }
//  });
  btnDepositeBitcoin.setBounds(307, 160, 137, 29);
  halfframe.getContentPane().add(btnDepositeBitcoin);

  amout_money = new JTextField();
  amout_money.setBounds(158, 95, 130, 26);
  halfframe.getContentPane().add(amout_money);
  amout_money.setColumns(10);

  JLabel lblEnterTheAmount = new JLabel("Enter the amount:");
  lblEnterTheAmount.setForeground(Color.WHITE);
  lblEnterTheAmount.setBounds(37, 100, 117, 16);
  halfframe.getContentPane().add(lblEnterTheAmount);

  JButton bal = new JButton("Check Balance");
  bal.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
    JOptionPane.showMessageDialog(null, savechecking.check_balance());
    SavecheckFrame window = new SavecheckFrame(savechecking,true) ;
    window.justframe.setVisible(true);
   }
  });
  bal.setBounds(171, 243, 117, 29);
  halfframe.getContentPane().add(bal);

 }
 private void initialize(Account savechecking) {
  savecheckframe = new JFrame();
  savecheckframe.setResizable(false);
  savecheckframe.setBounds(100, 100, 450, 300);
  savecheckframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  savecheckframe.getContentPane().setLayout(null);
  savecheckframe.getContentPane().setBackground(Color.PINK);


  JLabel lblIWanTo = new JLabel("I want to deposit:");
  lblIWanTo.setBounds(20, 18, 117, 52);
  savecheckframe.getContentPane().add(lblIWanTo);

  deposite_amount = new JTextField();
  deposite_amount.setBounds(138, 31, 130, 26);
  savecheckframe.getContentPane().add(deposite_amount);
  deposite_amount.setColumns(10);

  JLabel lblIWanTo_1 = new JLabel("I want to withdraw:");
  lblIWanTo_1.setBounds(20, 82, 137, 52);
  savecheckframe.getContentPane().add(lblIWanTo_1);

  withdraw_amount = new JTextField();
  withdraw_amount.setColumns(10);
  withdraw_amount.setBounds(138, 95, 130, 26);
  savecheckframe.getContentPane().add(withdraw_amount);

  JButton Checkbalance = new JButton("Check my balance");
  Checkbalance.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(null, savechecking.check_balance());
    SavecheckFrame window = new SavecheckFrame(savechecking,true) ;
    window.justframe.setVisible(true);
   }
  });
  Checkbalance.setBounds(121, 209, 190, 63);
  savecheckframe.getContentPane().add(Checkbalance);

  JLabel lblIWanTo_2 = new JLabel("I want to transfer:");
  lblIWanTo_2.setBounds(20, 133, 137, 52);
  savecheckframe.getContentPane().add(lblIWanTo_2);

  transfer_amount = new JTextField();
  transfer_amount.setColumns(10);
  transfer_amount.setBounds(138, 146, 130, 26);
  savecheckframe.getContentPane().add(transfer_amount);

  JButton btnUsd = new JButton("USD");
  btnUsd.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    try {
     double amount= Double.parseDouble(deposite_amount.getText());
     savechecking.deposit(amount,"USD");
     JOptionPane.showMessageDialog(null, "deposit " + amount +"!");

    }catch(Exception e1) {
     JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
    }
   }
  });
//  btnUsd.addMouseListener(new MouseAdapter() {
//   @Override
//   public void mouseClicked(MouseEvent e) {
//    //user has to input a valid input
//    try {
//     double amount= Double.parseDouble(deposite_amount.getText());
//     savechecking.deposit(amount,"USD");
//     JOptionPane.showMessageDialog(null, "deposit " + amount +"!");
//
//    }catch(Exception e1) {
//     JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
//    }
//   }
//  });
  btnUsd.setBounds(270, 31, 50, 29);
  savecheckframe.getContentPane().add(btnUsd);

  JButton btnCad = new JButton("CAD");
  btnCad.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
    try {
     double amount= Double.parseDouble(deposite_amount.getText());
     savechecking.deposit(amount,"CAD");
     JOptionPane.showMessageDialog(null, "deposit " + amount +"!");

    }catch(Exception e1) {
     JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
    }
   }
  });
  btnCad.setBounds(320, 31, 56, 29);
  savecheckframe.getContentPane().add(btnCad);

  JButton btnBitcoin = new JButton("Bitcoin");
  btnBitcoin.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
    try {
     double amount= Double.parseDouble(deposite_amount.getText());
     savechecking.deposit(amount,"BIT");
     JOptionPane.showMessageDialog(null, "deposit " + amount +"!");

    }catch(Exception e1) {
     JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
    }
   }
  });
  btnBitcoin.setBounds(373, 31, 71, 29);
  savecheckframe.getContentPane().add(btnBitcoin);

  JButton withdraw_usd = new JButton("USD");
  withdraw_usd.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
    try {
     double amount= Double.parseDouble(deposite_amount.getText());
     savechecking.withDraw(amount,"USD");
     JOptionPane.showMessageDialog(null, "withDraw " + amount +"!");

    }catch(Exception e1) {
     JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
    }
   }
  });
  withdraw_usd.setBounds(270, 95, 50, 29);
  savecheckframe.getContentPane().add(withdraw_usd);

  JButton withdraw_cad = new JButton("CAD");
  withdraw_cad.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
    try {
     double amount= Double.parseDouble(deposite_amount.getText());
     savechecking.withDraw(amount,"CAD");
     JOptionPane.showMessageDialog(null, "withDraw " + amount +"!");

    }catch(Exception e1) {
     JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
    }
   }
  });
  withdraw_cad.setBounds(320, 95, 56, 29);
  savecheckframe.getContentPane().add(withdraw_cad);

  JButton withdraw_bitcoin = new JButton("Bitcoin");
  withdraw_bitcoin.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
    try {
     double amount= Double.parseDouble(deposite_amount.getText());
     savechecking.withDraw(amount,"BIT");
      JOptionPane.showMessageDialog(null, "withDraw " + amount +"!");

    }catch(Exception e1) {
     JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
    }
   }
  });
  withdraw_bitcoin.setBounds(373, 95, 71, 29);
  savecheckframe.getContentPane().add(withdraw_bitcoin);

  JButton btntransfer = new JButton("Transfer");
  btntransfer.setBounds(280, 146, 117, 29);
  savecheckframe.getContentPane().add(btntransfer);

 }
}
