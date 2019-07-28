import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class Manager{
   private static String id = "Louis";
   private static String password = "123456";
   private HashMap<String,Customer> customerHM;

   private class ManagerFrame extends JFrame {// GUI for the Manager part. Inner class for encapsulation since no other classes should be able to access this part???
       private JFrame MFrame;

       private ManagerFrame(HashMap c) {
           JFrame frame = new JFrame("RichManBank's Esteemed Manager");
           frame.setLayout(new GridLayout(3, 3));
           frame.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.DARK_GRAY));
           frame.setLocation(100, 100);
           frame.setSize(1000, 700);
           frame.setLocation(200, 100);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.add(searchCustomerID());
           frame.add(listOfDebtors());
           this.MFrame = frame;
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
           JPanel DebtPanel = new JPanel();
           DebtPanel.setLayout(new GridLayout(2,2));
           DebtPanel.add(new JLabel("List of Debtors: "));

           String[] names = new String[customerHM.size()];
           int i = 0;
            for(Map.Entry<String,Customer> e: customerHM.entrySet()){
               if ( e.getValue().getLoan() == null) {
                   names[i] = e.getValue().getUsername();
               }
               i++;
           }
           JList list = new JList(names);
           list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
           list.setLayoutOrientation(JList.VERTICAL);
           list.setVisibleRowCount(3);
           list.addMouseListener(new MouseAdapter() {
               public void mouseClicked(MouseEvent e) {
                   if (e.getClickCount() == 2) {
                       Customer selectedItem = customerHM.get(list.getSelectedValue());
                       selectedItem.makeFrame();
                   }
               }
           });

           JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           scrollPane.setMinimumSize(new Dimension(100, 50));

           DebtPanel.add(scrollPane);
           return DebtPanel;
       }
   }
    private Manager(HashMap c){
       this.customerHM = c;
      ManagerFrame mf = new ManagerFrame(c);

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
        HashMap<String, Customer> customers = new HashMap<>();
        Checking check = new Checking(100.0);
        check.deposit(900);
        Savings save = new Savings(100.0);
        save.withDraw(100);
        List<Account> acc = new LinkedList<Account>();
        acc.add(check);
        acc.add(save);
        Customer me = new Customer(acc, "Deborah Reynolds", "dbreynolds", "1234");
        Customer s = new Customer(acc, "Louis Tannudin", "ltann", "1234");
        customers.put("dbreynolds", me);
        customers.put("ltann", s);
        Manager m = new Manager(customers);
    }
}
