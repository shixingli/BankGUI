// import java.awt.Color;
// import java.awt.Font;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;

// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
// import javax.swing.JPanel;
// import javax.swing.JTextField;
// import javax.swing.SwingConstants;
// import javax.swing.border.EmptyBorder;
// import javax.swing.JList;
// import javax.swing.JPopupMenu;
// import java.awt.Component;
// import javax.swing.JMenuBar;
// import javax.swing.JMenu;

// public class AccountFrame {
// 	JFrame accountframe;
// 	JLabel Gosaving,gochecking;


// 	/**
// 	 * Launch the application.
// 	 */
// 	public static void main(String[] args) {

// 	}


// 	public AccountFrame() {
// 		initialize();
// 	}
// 	private void initialize() {
// 		accountframe = new JFrame();
// 		accountframe.setResizable(false);
// 		accountframe.setBounds(100, 100, 450, 300);
// 		accountframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		accountframe.getContentPane().setBackground(Color.PINK);
// 		accountframe.getContentPane().setLayout(null);

// 		Gosaving = new JLabel("Go to my savings ");
// 		Gosaving.setForeground(Color.WHITE);
// 		Gosaving.addMouseListener(new MouseAdapter() {
// 			@Override
// 			public void mouseClicked(MouseEvent e) {
// 				//pops out the saving /checking frame
// 				SavecheckFrame window = new SavecheckFrame();
// 				window.savecheckframe.setVisible(true);
// 			}
// 		});
// 		Gosaving.setHorizontalAlignment(SwingConstants.CENTER);
// 		Gosaving.setBounds(30, 90, 138, 96);
// 		accountframe.getContentPane().add(Gosaving);

// 		gochecking = new JLabel("Go to my checkings");
// 		gochecking.setForeground(Color.WHITE);
// 		gochecking.addMouseListener(new MouseAdapter() {
// 			@Override
// 			public void mouseClicked(MouseEvent e) {
// 				//pops out the saving /checking frame
// 				SavecheckFrame window = new SavecheckFrame();
// 				window.savecheckframe.setVisible(true);
// 			}
// 		});
// 		gochecking.setHorizontalAlignment(SwingConstants.CENTER);
// 		gochecking.setBounds(251, 90, 138, 96);
// 		accountframe.getContentPane().add(gochecking);
// 	}

// }
