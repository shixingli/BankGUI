import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountDNEPanel extends JPanel {
  
  public AccountDNEFrame() {
    JOptionPane.showMessageDialog(this, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
  }
  
  public static void main(String[] args) {
    AccountDNEFrame.openFrame();
  }
}
