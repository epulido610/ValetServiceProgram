/*
Ethan Pulido
CSIS 130 
Valet Service

------------------------------
        ValetService 
------------------------------
          private
------------------------------
-parkSpots[10][10]: char
-random: rand
------------------------------
		  public
------------------------------
+ValetService()
+getUserSpot(ch:char): void
+printBoard(ary[][]): void
+isValid(ary[][]): boolean
*/

import java.util.Random;
import java.util.Arrays;

public class ValetService{

 private char[][] parkSpots;
 private char[][] ary;
 private char vehicle;

 ValetService()
  {
    parkSpots = new char[10][10];
    ary = new char[10][10];
   
    for (char[] row: ary)
    Arrays.fill(row, 'o');
    
    Random rand = new Random();
    vehicle = ' ';
  }
 void getUserSpot(char u)
  {
    boolean isAvailable = false;
    Random rand = new Random();
    int n = 0;
    int i =0;
    int ctr = 0;
    
     switch(u)
     {
       
       case 'm':
               
               setArrays(ary);
               
               int num = 9;
               i = rand.nextInt(num - 1) + 1;
               n = rand.nextInt(9) + 1;
            
            
              if(checkBounds(i,n) == true){
              
                   if(isValid(i, n) == false)
                       {
                          System.out.println("Error! Spot TAKEN!!");
                          break;
                       }
                   else if(isValid(i, n) == true)
                       {
                         ary[i][n] = 'm';
                       }
                 }
              else if(checkBounds(i,n) == false)
                {
                   System.out.println("array out of bounds");
                   break;
                }
       
        setArrays(ary);
        break;
        
        case 'c': 
                
                int numz = 8;
                n = rand.nextInt(8);
                i = rand.nextInt(9) + 1;
                int c = i + 1;
                
              if(checkBounds(i,n) == true){
              
                   if(isValid(i, n) == false)
                       {
                          System.out.println("Error! Spot TAKEN!!");
                          break;
                       }
                   else if(isValid(i, n) == true)
                       {
                          if(checkBounds(c,n) == true){
              
                          if(isValid(c, n) == false)
                            {
                              System.out.println("Error! Spot TAKEN!!");
                              break;
                            }
                          else if(isValid(c, n) == true)
                            {
                              ary[i][n] = 'c';
                              ary[c][n] = 'c';
                            }  
                        }
                     }  
                  }     
                else if(checkBounds(c,n) == false)
                  {
                     System.out.println("array out of bounds"); 
                  }
               
              else if(checkBounds(i,n) == false)
                {
                   System.out.println("array out of bounds");
                   break;
                }
                
            setArrays(ary);
          
          break;
          
       case 'b':
          
                int numbs = 7;
                n = rand.nextInt(7);
                i = rand.nextInt(9) + 1;
                int x = i + 1;
				    int z = x + 1;
                
              if(checkBounds(i,n) == true){
              
                   if(isValid(i, n) == false)
                       {
                          System.out.println("Error! Spot TAKEN!!");
                          break;
                       }
                   else if(isValid(i, n) == true)
                       {
                          if(checkBounds(x,n) == true){
              
                          if(isValid(x, n) == false)
                            {
                              System.out.println("Error! Spot TAKEN!!");
                              break;
                            }
                          else if(isValid(x, n) == true)
                            {
                               if(checkBounds(z,n) == true){
              
                               if(isValid(z, n) == false)
                                  {
                                    System.out.println("Error! Spot TAKEN!!");
                                    break;
                                  }
                               if(isValid(z, n) == true)
                                  {
                                     ary[i][n] = 'b';
                                     ary[z][n] = 'b';
                                     ary[x][n] = 'b';
                                     
                                  }
                            } 
                        }
                     }  
                  }     
                else if(checkBounds(x,n) == false)
                  {
                     System.out.println("array out of bounds"); 
					 break;
                  }
               
              else if(checkBounds(i,n) == false)
                {
                   System.out.println("array out of bounds");
                   break;
                }
			  else if(checkBounds(z,n) == false)
                {
                   System.out.println("array out of bounds");
                   break;
                }
             }   
            setArrays(ary);
          
          break;
                
      }
   }
 void printBoard()
  {
     for(int rows = 0; rows < 10; rows++)
      {
        System.out.println();
        for(int columns = 0; columns < 10; columns++)
          {
            System.out.print(parkSpots[rows][columns] + " "); 
          }  
      }
  }
 boolean isValid(int x, int y)
   {
     if(parkSpots[x][y] == 'm') 
       {
         return false;
       }
     else if(parkSpots[x][y] == 'b')
     {
        return false;
     }
     else if(parkSpots[x][y] == 'c')
     {
       return false;
     }
     else
     {
       return true;
     }
     
   }
 void setArrays(char[][] ary)
   {
     for(int r = 0; r < 10; r++)
      {
        for(int c = 0; c < 10; c++)
         {
           parkSpots[r][c] = ary[r][c];
         }
      }
   }
 boolean checkBounds(int i, int n){
    try {
        if ( i >= ary.length){
          return false;
        }
        if(n >= ary.length){
          return false;
        }
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Method Halted!, continuing doing the next thing");
        return false;
    }
    
    return true;
}
}