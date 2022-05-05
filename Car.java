public class Car extends Automobile{
  private boolean isSupercar;
  public Car(String name, int wheels, boolean superCar){
    super(name, wheels);
    isSupercar = superCar; 
  }
  public String userToString(){
    String temp = super.userToString();
    temp += isSupercar ? "Is a supercar: " : "Is not a supercar\n";
    return temp;
  }
  
  public String toString(){
    String superCarBoolean = isSupercar ? "true" : "false";
    return super.toString() + superCarBoolean + "\n";
  }
}