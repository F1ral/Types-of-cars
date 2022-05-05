import java.io.File; 
import java.io.FileWriter; 
import java.util.Scanner;
import java.util.ArrayList;

class Main {
private static ArrayList<Automobile> allVehicles = new ArrayList<Automobile>(); 
private static ArrayList<Automobile> listAutomobiles = new ArrayList<Automobile>(); 
private static ArrayList<Car> listCars = new ArrayList<Car>(); 
  public static void main(String[] args) {
    
		try{
      Scanner file = new Scanner(new File("Regular automobiles.dat"));
      while (file.hasNext()){
        listAutomobiles.add(new Automobile(file.nextLine(), Integer.parseInt(file.nextLine())));
      }
      file.close();
    } catch (Exception e){
      System.err.println("There was an error reading the file" + e.getMessage());
    }

		try{
      Scanner file = new Scanner(new File("cars.dat"));
      while (file.hasNext()){
        listCars.add(new Car(file.nextLine(), Integer.parseInt(file.nextLine()), Boolean.parseBoolean(file.nextLine())));
      }
      file.close();
    } catch (Exception e){
      System.err.println("There was an error reading the file" + e.getMessage());
    }
    for(int i = 0; i < listCars.size(); i++){
      allVehicles.add(listCars.get(i));
    }
    for(int i = 0; i < listAutomobiles.size(); i++){
      allVehicles.add(listAutomobiles.get(i));
    }
    
    Scanner scan = new Scanner(System.in);
    int choice = 0;
    
    while (choice != 9){ //Menu
      
      System.out.println("\n(1) Create new automobile");
      System.out.println("(2) Create new car");
      System.out.println("(3) List all automobiles added");
      System.out.println("(4) List all cars added");
      System.out.println("(5) Remove autombile");
      System.out.println("(9) Save and quit\n");
     
      choice = Integer.parseInt(scan.nextLine());
      if (choice == 1){
        try{
          System.out.println("\nName of automobile");
          String tempName = scan.nextLine();
          System.out.println("Number of wheels");
          int tempWheels = Integer.parseInt(scan.nextLine());
          Automobile temp = new Automobile(tempName, tempWheels);
          listAutomobiles.add(temp);
          allVehicles.add(temp);
        } catch (Exception e){
          System.err.println("There was an error creating a car" + e.getMessage());
        }
      }
      
      if (choice == 2){
        try{
          System.out.println("\nName of car");
          String tempName = scan.nextLine();
          System.out.println("Is it supercar? (y/n)");
          String yesNo = scan.nextLine();
          boolean yesNoSuperCar = false;
          if (yesNo.toLowerCase().equals("y"))
            yesNoSuperCar = true;
          Car temp = new Car(tempName, 4, yesNoSuperCar);
          listCars.add(temp);
          allVehicles.add(temp);
        } catch (Exception e){
          System.err.println("There was an error creating a car" + e.getMessage());
        }
      }
      if (choice == 3){
        for (int i = 0; i < allVehicles.size(); i++){
          System.out.println(allVehicles.get(i).userToString());
        }
      }
      if (choice == 4){
        for (int i = 0; i < listCars.size(); i++){
          System.out.println(listCars.get(i).userToString());
        }
      }
      if (choice == 5){
        for (int i = 0; i < allVehicles.size(); i++){
          System.out.println((i+1) + ")");
          System.out.println(allVehicles.get(i).userToString());
        }
        System.out.println("Choose a vehcle to remove (1-" + allVehicles.size() + ")"); 
        int toRemovePos = Integer.parseInt(scan.nextLine());
        if (toRemovePos < listCars.size()){
          listCars.remove(toRemovePos-1);
          allVehicles.remove(toRemovePos-1);
        }
        else{
          listCars.remove(toRemovePos-1);
          allVehicles.remove(toRemovePos-listCars.size()-1);
        }
      }
    }
    
    try{
      FileWriter fw = new FileWriter(new File("Regular automobiles.dat"), false);
      for (int i = 0; i < listAutomobiles.size(); i ++){
        fw.write(listAutomobiles.get(i).toString());
      }
      fw.close();
    } catch (Exception e){
      System.err.println("There was an error reading the file" + e.getMessage());
    }

    try{
      FileWriter fw = new FileWriter(new File("cars.dat"), false);
      for (int i = 0; i < listCars.size(); i ++){
        fw.write(listCars.get(i).toString());
      }
      fw.close();
    } catch (Exception e){
      System.err.println("There was an error reading the file" + e.getMessage());
    }
    System.out.println("Finished saving");
  }
}