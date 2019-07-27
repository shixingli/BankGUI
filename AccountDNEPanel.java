import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountDNEPanel extends JPanel {
  
  public AccountDNEPanel(String accType, String customer) {
    JOptionPane.showMessageDialog(this, customer + " does not have a '" + accType + "' account", "Invalid Request", JOptionPane.ERROR_MESSAGE);
  }
  
}
