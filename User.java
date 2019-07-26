public abstract class User {
  private String id;
  private int pin;

  public User(String id, int pin){// Since User is an abstract class we should pass in the id and pin here no?
    this.id = id;
    this.pin = pin;
  }

  public User(){
  }

  public int getPin() {
    return pin;
  }

  public String getId() {
    return id;
  }
}
