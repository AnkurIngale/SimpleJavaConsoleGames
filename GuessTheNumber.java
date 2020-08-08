
import java.io.*;
import java.util.*;
public class GuessTheNumber {
   int a[][]=new int [4][5];
   BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
   Random r=new Random();
   int i,j;
   void makeboard()
   {
   for(i=0;i<4;i++)
   {
   for(j=0;j<5;j++)
   {
   a[i][j]=r.nextInt(89)+11;
   }
   }
   }
   
   void display()
   {              // |    |
   System.out.println("    1     2     3     4     5");
   System.out.println("   -----------------------------");
   int c=1;
   for(i=0;i<4;i++)
   {for(j=0;j<5;j++)
   {
      if(j==0)
      {System.out.print(c+" | "+a[i][j]+" ");c++;}
      else if(j>0 && j<4)
          System.out.print(" | "+a[i][j]+" ");
      else if(j==4)
           System.out.print(" | "+a[i][j]+" |");
   }
   System.out.println("\n   -----------------------------");
   }
   }
   
   public void game() 
   {
       try{
   int row,column;
   makeboard();
   display();
   System.out.println("CHOOSE A NUMBER FROM THE GRID ABOVE AND KEEP THAT NUMBER IN YOUR MIND!!!\nONCE SELECTED PRESS ENTER");
   String enter=forEnter();
   System.out.println(enter);
   System.out.println("NOW ENTER THE NUMBER OF THE ROW IN WHICH YOUR NUMBER IS PRESENT !!");
   row=Integer.parseInt(k.readLine())-1;
   System.out.println("NOW ENTER THE NUMBER OF THE COLUMN IN WHICH YOUR NUMBER IS PRESENT !!");
   column=Integer.parseInt(k.readLine())-1;
   System.out.println("\n\n\n\n\n\n THE NUMBER IS : "+a[row][column]);
   }catch(Exception e)
   {System.err.println(e);}}
   String forEnter()
   {
   Scanner sc=new Scanner(System.in);
   String enter=sc.nextLine();
   if(enter.equals(""))
   {
   return "I ASSUME THAT YOU HAVE SELECTED THE NUMBER!!! ";
   }
       return "I AM NOT SURE IF YOU HAVE CHOSEN A NUMBER BUT I'LL CONTINUE";
   }
   public static void main(String args[])
   {
   GuessTheNumber guess=new GuessTheNumber();
   guess.game();
   }
}
