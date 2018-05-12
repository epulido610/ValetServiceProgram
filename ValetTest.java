/*
Ethan Pulido
CS/IS 130
Valet Service
*/
import java.util.Scanner;

public class ValetTest{

 public static void main(String[] args){
   
   ValetService valet = new ValetService();
   Scanner input = new Scanner(System.in);
   
   char userChoice = ' ';
   char userVehicle = ' ';
   
   System.out.println("\nWelcome to the valet service program");
      
  do{
       System.out.println("\n1. to park your car ");
       System.out.println("2. to quit the program");
       
       System.out.println("\nPlease enter 'm' for motrocycle, 'c' for car and 'b' for bus");
       System.out.println("a. Park motorbike");
       System.out.println("b. Park car"); 
       System.out.println("c. Park bus");
       System.out.println("p. Print lot");
       System.out.println("q. Quit");
       userChoice = input.next().charAt(0);
       
       
        switch(userChoice)
         {
           case 'a':
            userVehicle = 'm';
            valet.getUserSpot(userVehicle);
            valet.printBoard();
            break;
            
           case 'b':
           
            userVehicle = 'c';
            valet.getUserSpot(userVehicle);
            valet.printBoard();
            break;
            
           case 'c':
             userVehicle = 'b';
             valet.getUserSpot(userVehicle);
         
             valet.printBoard();
            
           break; 
           
           case 'p':
           
             valet.printBoard();
            
           break;
          
           case 'q':
       
           System.exit(0);
       
           default:
       
           System.out.println("Incorrect selection");
           break;
   
      }
    }while(userChoice != 'q');
  }

}