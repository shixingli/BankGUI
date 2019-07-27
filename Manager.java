import javax.swing.*;
import java.awt.*;

public class Manager{
   private static String id = "Louis";
   private static String password = "123456";

   private class ManagerFrame extends JFrame {// GUI for the Manager part. Inner class for encapsulation since no other classes should be able to access this part???
      private JFrame MFrame;
       private ManagerFrame(){
        JFrame frame = new JFrame("Manager Frame");
        frame.setLayout(new GridLayout(4,4));
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.DARK_GRAY));
        frame.setLocation(100,100);
        frame.setSize(600,350);
        frame.setLocation(200,100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(SearchCustomerID());
        this.MFrame = frame;
      }

      private JPanel SearchCustomerID(){
           JPanel panel = new JPanel();

           panel.setLayout( new GridLayout(4,1));
           panel.add(new JLabel("Seach for Customer: "));
           panel.add(new JTextField("Enter ID"));
           return panel;
      }
    }

    private Manager(){
      ManagerFrame mf = new ManagerFrame();
      mf.MFrame.setVisible(true);
    }

    private Customer getCustomer(String id){

        return null;
    }

    public static boolean isManager(String id, String password){
      boolean isIt = false;
      if(Manager.id == id && Manager.password == password){
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
