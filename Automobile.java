public class Automobile{
  private int numberOfWheels;
  private String nameOfAutomobile;
  public Automobile(String name, int wheels){
    numberOfWheels = wheels;
    nameOfAutomobile = name;
  }
  public String userToString(){
    String temp = "";
    temp += "Name of automobile: " + nameOfAutomobile;
    temp += "\nNumber of wheels: " + numberOfWheels + "\n";
    return temp;
  }
  public String toString(){
    return nameOfAutomobile +  "\n" + numberOfWheels + "\n";
  }
}
