import javax.swing.*;
import java.util.HashMap;

public class Manager extends User {
   private static String id = "Louis";
   private static String password = "123456";
  // methods like pass in a customer and get their information using the customer's getting methods
    private class ManagerFrame extends JFrame {// GUI for the Manager part. Inner class for encapsulation since no other classes should be able to access this part???
      private ManagerFrame(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setTitle("Manager Frame");
        frame.setSize(450,250);
        frame.setLocation(200,100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      }
    }

    private Manager(){
      ManagerFrame mf = new ManagerFrame();
      mf.setVisible(true);
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
