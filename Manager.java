import javax.print.attribute.standard.JobMediaSheetsCompleted;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Manager{
   private static String id = "Louis";
   private static String password = "123456";

   private class ManagerFrame extends JFrame {// GUI for the Manager part. Inner class for encapsulation since no other classes should be able to access this part???
       private JFrame MFrame;
       private List customerList;

       private ManagerFrame(List customerList) {
           JFrame frame = new JFrame("RichManBank's Esteemed Manager");
           frame.setLayout(new GridLayout(3, 3));
           frame.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.DARK_GRAY));
           frame.setLocation(100, 100);
           frame.setSize(1000, 700);
           frame.setLocation(200, 100);
           frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           frame.add(searchCustomerID());
           frame.add(listOfDebtors());
           this.MFrame = frame;
           this.customerList = customerList;
       }

       private JPanel searchCustomerID() {
           JPanel SearchPanel = new JPanel();

           SearchPanel.setLayout(new GridLayout(3, 2));
           SearchPanel.add(new JLabel("Seach for Customer: "));

           JTextField tf = new JTextField("(Enter ID)");
           SearchPanel.add(tf);

           tf.addActionListener(e -> {
               String customerID = tf.getText();
               getCustomer(customerID);
           });
           return SearchPanel;
       }

       private JPanel listOfDebtors(){
           String[] debtors = new String[3]
           JPanel DebtPanel = new JPanel(debtors);
           DebtPanel.setLayout(new GridLayout(2,2));
           DebtPanel.add(new JLabel("List of Debtors: "));

           JList list = new JList(debtors);
           list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
           list.setLayoutOrientation(JList.VERTICAL);
           list.setVisibleRowCount(3);
           list.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   if (e.getClickCount() == 2) {
                       Customer selectedItem = (Customer) list.getSelectedValue();
                       selectedItem.toString();

                   }
               }
           });

           JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           scrollPane.setMinimumSize(new Dimension(100, 50));

           DebtPanel.add(scrollPane);
           return DebtPanel;
       }
   }
    private Manager(){
      ManagerFrame mf = new ManagerFrame();
      mf.MFrame.setVisible(true);
    }

    private Customer getCustomer(String id){
        System.out.println(id);
        return null;
    }

    private void displayCustomer(){//print out a frame of Customer's info.
       JFrame CFrame = new JFrame();

    }

    public static boolean isManager(String id, String password){
      boolean isIt = false;
      if(Manager.id.equals(id) && Manager.password.equals(password)){
        isIt = true;
      }
      else{
        System.out.println("login unsuccessful");
      }
      return isIt;
    }

    public static void main(String[] args){
      Manager m = new Manager();
    }
}
