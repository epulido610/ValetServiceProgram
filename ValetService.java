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
 void getUserSpot(char a)
  {
    boolean isAvailable = false;
    Random rand = new Random();
    int n = 0;
    int i =0;
    int ctr = 0;
    
     switch(a)
     {
       
       case 'm':
       
            ctr = 0;
            
            i = rand.nextInt(9) + 1;
            n = rand.nextInt(9) + 1;
            ary[i][n] = 'm';
            
            if(isValid(i, n, 'm') == false)
             {
               ctr++;
             }
            else if(ctr >= 3)
             {
               System.out.println("Error! No Spots");
               break;
             }
             
        setArrays(ary);
       
        break;
        
        case 'c':
          
             ctr = 0;
              
             
                ctr++;
                
                n = rand.nextInt(9) + 1;
                i = rand.nextInt(9) + 1;
                ary[i][n] = 'c';
                
                if(isValid(i, n, 'c') == false)
                 {
                   ctr++;
                 }
                else if(ctr >= 3)
                 {
                    System.out.println("Error! No Spots");
                    break;
                 }
           
          int cttr =0;
           
         
              ary[i+1][n] = 'c';
              
              if(isValid(i, n, 'c') == false)
               {
                 cttr++;
               }
               else if(cttr >= 3)
               {
                 System.out.println("Error! No Spots");
                 break;
               }
          
          
          setArrays(ary);
          
          break;
       case 'b':
         
          
             ctr = 0;
             
             
               do{
                   n = rand.nextInt(9) + 1;
                   i = rand.nextInt(9) + 1;
                   ary[i][n] = 'b';
                   isAvailable = isValid(i,n,'b');
                   
                   if(isValid(i, n, 'b') == false)
                    {
                      ctr++;
                    }
                   else if(ctr >= 3)
                    {
                      System.out.println("Error! No Spots");
                      break;
                    }
                 }while(isAvailable == false);
                 
               int cntr = 0;
               
                do{
                    ary[i+1][n] = 'b';
                    isAvailable = isValid(i, n, 'b');
                    
                    if(isAvailable == false)
                     {
                       cntr++;
                     }
                    else if(cntr >= 3)
                     {
                       System.out.println("Error! No Spots");
                       break;
                     }
                 }while(isAvailable == false);
                 
          int ctttr = 0;
              
              do{

                  isAvailable = isValid(i, n, 'b');
                  
                  if(isAvailable == false)
                   {
                     ctttr++;
                   }
                  else if(ctttr >= 3)
                   {
                     System.out.println("Error! No Spots");
                     break;
                   } 
               }while(isAvailable == false);
                
          setArrays(ary);
          
         
        
        break; 
     }
     
    setArrays(ary);
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
 boolean isValid(int x, int y, char val)
   {
     if(parkSpots[x][y] == val) 
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
}