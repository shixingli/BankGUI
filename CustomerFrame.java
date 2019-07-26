import javax.swing.*;
import javax.swing.border.TitledBorder;

public class CustomerFrame extends JFrame {
  String custName;
  
  public CustomerFrame(Customer client) {
    setTitle("Interactions Pane");
    setSize( 500, 500 );
    setLocationRelativeTo( null);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setVisible( true );
  }
// buttons to create savings account
  //checkign account
  //deposit
  // take out a loan
  
  public static void main(String[] args) {
    CustomerFrame.create(new Customer());
  }
  
  public static void create(Customer client) {
    CustomerFrame custFrame = new CustomerFrame(client);
    
    JPanel panel = new JPanel();
    
    JComboBox accounts = new JComboBox( new String[] {"Savings", "Checking"} );
    JButton button1 = new JButton( "OK-1" );
    JTextField t = new JTextField("enter the text", 16);
    
    addTitle(panel);
    
    panel.add(t);
    panel.add(accounts);
    panel.add(button1);
    
    custFrame.add(panel);
  }
  
  public static void addTitle(JPanel panel) {
    TitledBorder border = new TitledBorder("This is my title");
    border.setTitleJustification(TitledBorder.CENTER);
    border.setTitlePosition(TitledBorder.TOP);
    
    panel.setBorder(border);
  }
}
