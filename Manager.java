import javax.swing.*;

public class Manager extends User {
  // methods like pass in a customer and get their information using the customer's getting methods
    private class ManagerFrame extends JFrame {// GUI for the Manager part. Inner class for encapsulation since no other classes should be able to access this part???
      public ManagerFrame(){
        JFrame frame = new JFrame();
        frame.setTitle("Manager Frame");
        frame.setSize(450,250);
        frame.setLocation(200,100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
      }
    }
    public Manager(){
      ManagerFrame mf = new ManagerFrame();
    }

    public Customer getCustomer(String id){
        return null;
    }

    public static void main(String[] args){
      Manager m = new Manager();
    }
}
