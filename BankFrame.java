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
public class BankFrame {
	JFrame bankframe;
	JPanel Official,Customer;
	JButton Official_click,Customer_Click;
	JLabel creator,Username_label,Title,user_passwordlabel,official_label,official_label2;
	JTextField official_username,user_name,user_password,official_password;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// BankFrame window = new BankFrame();
		// window.bankframe.setVisible(true);
	}



	public BankFrame() {
		initialize();
	}
	private void initialize() {
		bankframe = new JFrame();
		bankframe.setResizable(false);
		bankframe.setBounds(100, 100, 450, 300);
		bankframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bankframe.getContentPane().setBackground(Color.BLACK);
		bankframe.getContentPane().setLayout(null);

		Customer = new JPanel();
		Customer.setBorder(new EmptyBorder(0, 0, 0, 0));
		Customer.setBackground(Color.BLACK);
		Customer.setBounds(6, 95, 210, 143);
		bankframe.getContentPane().add(Customer);
		Customer.setLayout(null);

		Customer_Click = new JButton("Customer Login in ");
		Customer_Click.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//pops out Customer frame
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

		user_password = new JTextField();
		user_password.setColumns(10);
		user_password.setBounds(79, 56, 106, 26);
		Customer.add(user_password);

		user_passwordlabel = new JLabel("Password:");
		user_passwordlabel.setForeground(Color.WHITE);
		user_passwordlabel.setBounds(6, 61, 75, 16);
		Customer.add(user_passwordlabel);

		Official = new JPanel();
		Official.setBorder(new EmptyBorder(0, 0, 0, 0));
		Official.setBackground(Color.BLACK);
		Official.setBounds(234, 95, 210, 143);
		bankframe.getContentPane().add(Official);
		Official.setLayout(null);

		Official_click = new JButton("Official Login in ");
		Official_click.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//pops out Manager frame
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

		official_password = new JTextField();
		official_password.setColumns(10);
		official_password.setBounds(75, 56, 106, 26);
		Official.add(official_password);

		Title = new JLabel("Welcome to our bank");
		Title.setForeground(Color.WHITE);
		Title.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(59, 31, 329, 52);
		bankframe.getContentPane().add(Title);

		creator = new JLabel("Amanda, Louis, Shizhen");
		creator.setForeground(Color.WHITE);
		creator.setHorizontalAlignment(SwingConstants.CENTER);
		creator.setBounds(79, 256, 309, 16);
		bankframe.getContentPane().add(creator);
	}
}
