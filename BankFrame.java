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
	JPanel Customer;
	JPanel Offcial;
	JButton Official_click;
	JLabel Title;
	JLabel creator;




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
		Customer.setBounds(42, 95, 173, 143);
		bankframe.getContentPane().add(Customer);
		Customer.setLayout(null);

		JButton Customer_Click = new JButton("Customer Login in ");
		Customer_Click.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//pops out Customer frame
			}
		});
		Customer_Click.setBounds(6, 53, 145, 29);
		Customer.add(Customer_Click);

		Offcial = new JPanel();
		Offcial.setBackground(Color.BLACK);
		Offcial.setBorder(new EmptyBorder(0, 0, 0, 0));
		Offcial.setBounds(261, 95, 183, 143);
		bankframe.getContentPane().add(Offcial);
		Offcial.setLayout(null);

		Official_click = new JButton("Official Login in ");
		Official_click.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//pops out Manager frame
			}
		});
		Official_click.setForeground(Color.BLACK);
		Official_click.setBounds(0, 51, 142, 29);
		Offcial.add(Official_click);

		Title = new JLabel("Welcome to our bank");
		Title.setForeground(Color.WHITE);
		Title.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(59, 31, 329, 52);
		bankframe.getContentPane().add(Title);

		creator = new JLabel("Amenda, Louis, Shizhen");
		creator.setForeground(Color.WHITE);
		creator.setHorizontalAlignment(SwingConstants.CENTER);
		creator.setBounds(79, 256, 309, 16);
		bankframe.getContentPane().add(creator);
	}
}
