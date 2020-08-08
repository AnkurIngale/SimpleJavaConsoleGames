import java.io.*;
import java.util.Random;

class MineSweeper
{
 String board[][];
 int save[][];
 int i,j;
 int n,numberOfMines;
 int flag[][];
 Random r;
 BufferedReader k;
 
 public void initializor()
 {
    r=new Random();
    k=new BufferedReader(new InputStreamReader(System.in));
    
    try{
    System.out.println("ENTER NUMBER OF ROWS OF SQUARE GRID ::");
    n=Integer.parseInt(k.readLine());
    board=new String[n][n];
    save=new int[n][n];
    flag=new int[n][n];
    }catch(Exception e){System.err.println(e);System.exit(0);}
    }
    
    public void initializor2()
    {
    for(i=0;i<n;i++){
    for(j=0;j<n;j++)
    {
        board[i][j]="+";
        save[i][j]=-9;
        flag[i][j]=0;
    }
    }
    
    try{
    System.out.println("\nENTER NUMBER OF MINES ::");
    numberOfMines=Integer.parseInt(k.readLine());
    }
    catch(Exception e){System.err.println(e);System.exit(0);}
    
    int r1,r2;
    for(i=0;i<numberOfMines;i++)
    {
        r1=r.nextInt(n);
        r2=r.nextInt(n);
        
        while(save[r1][r2]==99)
        {
        r1=r.nextInt(n);
        r2=r.nextInt(n);
        }
        
        save[r1][r2]=99;
    }
    }
    
    public void display()
    {   
        for(i=0;i<n;i++)
        {
        if(i==0)
        {
            System.out.print("  "+i);
        }
        else System.out.print(" "+i);
        }
        System.out.println();
        for(i=0;i<n;i++)
        {
        for(j=0;j<n;j++)
        {
            if(j==0)
            System.out.print(i+" "+board[i][j]);
            else System.out.print(" "+board[i][j]);
        }
        System.out.println();
        }
    }
    
    public void neighbourCount()
    { int e,l,counter=0;
        for(i=0;i<n;i++)
        {
        for(j=0;j<n;j++)
        {
           if(!(save[i][j]==99))
           {
               for(e=(i-1);e<=(i+1);e++)
               {
                   for(l=(j-1);l<=(j+1);l++)
                   {
                       if(e>=0 && e<n)
                       {
                        if(l>=0 && l<n)
                        {
                            if(save[e][l]==99)
                            counter++;
                        }
                        }
                    }
                }
                save[i][j]=(counter);
                counter=0;
            }
        }
        }
    }
    
    public void game()
    {
    int row,col,counter=0;
    boolean play=true;
    try{
    while(play)
    {   counter=0;
        System.out.print('\u000C');
        display();
        System.out.println("\nENTER ROW ::");
        row=Integer.parseInt(k.readLine());
        System.out.println("\nENTER COL ::");
        col=Integer.parseInt(k.readLine());
        if(save[row][col]==99)
        {
        play=false;greetings(false);showFinal();
        }
        else show(row,col);
        
       for(i=0;i<n;i++)
        {
        for(j=0;j<n;j++)
        {
           if(board[i][j].equals("+"))
           counter++;
           
        }
        }
        if(counter==numberOfMines)
        {play=false;greetings(true);showFinal();}
}}catch(Exception e){System.err.println(e);System.exit(0);}
    }
    
    
    public void showFinal()
    {
         for(i=0;i<n;i++)
        {
        for(j=0;j<n;j++)
        {
            if(save[i][j]==99)
            System.out.print("M"+" ");
            else System.out.print(board[i][j]+" ");
           
        }
        System.out.println();
        }
    }
    public void greetings(boolean con)
    {
    if(con)
    {
    System.out.println("\nYOU WON THE GAME!! HOPE U ENJOYED IT!!");
    }
    else System.out.println("\nBAD LUCK!! NEXT TIME!!");
    
    System.out.println("  ==>> A PROJECT BY ANKUR INGALE");
    }
    
    public void show(int r,int c)
    { int e,l;
        
        if(save[r][c]==0){
        for(e=(r-1);e<=(r+1);e++)
        {
          for(l=(c-1);l<=(c+1);l++)
          {
            if(e>=0 && e<n)
            {
                if(l>=0 && l<n)
                {
                    if(save[e][l]==0 && flag[e][l]==0)
                    {flag[e][l]=1;show(e,l);}
                    else if(!(save[r][c]==99))board[e][l]=Integer.toString(save[e][l]);
                }
            }
            }
        }}
        
        else if(!(save[r][c]==99))board[r][c]=Integer.toString(save[r][c]);
        
                }
               

    
    public static void main(String args[])
    
    {
        MineSweeper mine=new MineSweeper();
        mine.initializor();
        mine.initializor2();
        mine.neighbourCount();
        mine.game();
    }
}