import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountDNEPanel extends JPanel {
  
  public AccountDNEPanel() {
    JOptionPane.showMessageDialog(this, "Requested account does not exist for this customer", "Error", JOptionPane.ERROR_MESSAGE);
  }
  
}
