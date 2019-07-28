// package bank;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SavecheckFrame {
	JFrame savecheckframe;
	JLabel Gosaving,gochecking;
	private JTextField deposite_amount;
	private JTextField withdraw_amount;
	private JTextField transfer_amount;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Account saving = new Savings(0.00);
		SavecheckFrame window = new SavecheckFrame(saving) ;
		window.savecheckframe.setVisible(true);
	}
	
	
	public SavecheckFrame(Account savechecking) {
		initialize(savechecking);
	}
	
	
	private void initialize(Account savechecking) {
		savecheckframe = new JFrame();
		savecheckframe.setResizable(false);
		savecheckframe.setBounds(100, 100, 450, 300);
		savecheckframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		savecheckframe.getContentPane().setBackground(Color.PINK);
		savecheckframe.getContentPane().setLayout(null);
		
		JLabel lblIWanTo = new JLabel("I wan to deposite:");
		lblIWanTo.setBounds(20, 18, 117, 52);
		savecheckframe.getContentPane().add(lblIWanTo);
		
		deposite_amount = new JTextField();
		deposite_amount.setBounds(138, 31, 130, 26);
		savecheckframe.getContentPane().add(deposite_amount);
		deposite_amount.setColumns(10);
		
		JLabel lblIWanTo_1 = new JLabel("I wan to withdraw:");
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
			}
		});
		Checkbalance.setBounds(121, 209, 190, 63);
		savecheckframe.getContentPane().add(Checkbalance);
		
		JLabel lblIWanTo_2 = new JLabel("I wan to transfer:");
		lblIWanTo_2.setBounds(20, 133, 137, 52);
		savecheckframe.getContentPane().add(lblIWanTo_2);
		
		transfer_amount = new JTextField();
		transfer_amount.setColumns(10);
		transfer_amount.setBounds(138, 146, 130, 26);
		savecheckframe.getContentPane().add(transfer_amount);
		
		JButton btnUsd = new JButton("USD");
		btnUsd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				//user has to input a valid input
				try {
					double amount= Double.parseDouble(deposite_amount.getText());
					savechecking.deposit(amount,"USD");
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1 + "only integer allowed");
				}
			}
		});
		btnUsd.setBounds(270, 31, 50, 29);
		savecheckframe.getContentPane().add(btnUsd);
		
		JButton btnCad = new JButton("CAD");
		btnCad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					double amount= Double.parseDouble(deposite_amount.getText());
					savechecking.deposit(amount,"CAD");
					
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
					savechecking.deposit(amount,"Bitcoin");
					
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
					savechecking.withDraw(amount,"Bitcoin");
					
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
