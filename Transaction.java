import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {
  protected String id;
  protected double amount;
  
  public Transaction(double amount) {
    this.amount = amount;
  }
    
  public String getId() {
    return this.id;
  } 
  
  public double getAmount() {
    return this.amount;
  }
  
  public String time() {
    SimpleDateFormat df = new SimpleDateFormat("EEEE, MMMM d 'at' h:mm a z ");
    Date now = new Date();
    return (df.format(now));
  }
  
  public String toString() {
    return this.id;
  }
  
}
