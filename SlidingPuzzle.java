import java.util.*;
import java.io.*;
class SlidingPuzzle{

int g;
String board[][];
int num[][];
int i,j;
Scanner s;
Random r;
public SlidingPuzzle()
{
//do nothing


}

public SlidingPuzzle(int grid)
{
g=grid;
board=new String[g][g];
num=new int[g][g];
r=new Random();
s=new Scanner(System.in);
for(i=0;i<g;i++)
for(j=0;j<g;j++)
{board[i][j]="";num[i][j]=-1;}


}

public void give()
{
int lol[][]=new int [g][g];
int r1=r.nextInt(g),r2=r.nextInt(g);
int counter=0;
for(i=0;i<g;i++)
for(j=0;j<g;j++)
{lol[i][j]=counter+1;counter++;}

for(i=0;i<g;i++)
{
for(j=0;j<g;j++){
while(lol[r1][r2]==-1)
{r1=r.nextInt(g);r2=r.nextInt(g);}

num[i][j]=lol[r1][r2];
lol[r1][r2]=-1;
r1=r.nextInt(g);
r2=r.nextInt(g);
}}
}

public void giveToBoard()
{
    
int r1=r.nextInt(g),r2=r.nextInt(g);
board[r1][r2]="  ";    
for(i=0;i<g;i++)
for(j=0;j<g;j++)
{
if(!(board[i][j].equals("  ")))
{
    if(num[i][j]<10)
board[i][j]="0"+its(num[i][j]);
else board[i][j]=its(num[i][j]);
}
}
}

public void game()
{
int row,col;  int spacer=-1,spacec=-1; String enter,temp,h;

give();
giveToBoard();
while(!finished())
{
    
for(i=0;i<g;i++)
for(j=0;j<g;j++)
if(board[i][j].equals("  ")){spacer=i;spacec=j;}    
display();
System.out.println("\nENTER ROW:::");
row=s.nextInt();
System.out.println("\nENTER COLUMN:::");
col=s.nextInt();

while(!properMove(row,col))
{
System.out.println("\nERROR!!\nENTER ROW:::");
row=s.nextInt();
System.out.println("\nENTER COLUMN:::");
col=s.nextInt();
}

temp="";
temp=board[row][col];
board[row][col]=board[spacer][spacec];
board[spacer][spacec]=temp;

System.out.println("PRESS ENTER!!");
h=s.nextLine();
}

greetings();
}


public boolean finished()
{
    int p[]=new int[(g*g)-1];
    int counter=0;
    
    for(j=0;j<g;j++){
    for(i=0;i<g;i++)
    {
      if(!(board[i][j].equals("  ")))
      {
        p[counter]=sti(board[i][j]);
        counter++;
        }
    }}
        counter=0;
      for(i=1;i<((g*g)-1);i++)
      {
        if(p[i]>p[i-1])
        counter++;
        }
        
        return (counter==((g*g)-2))?true:false;
    
}




public boolean properMove(int r,int c)
{
   
    if(board[r][c].equals("  "))return false;
   
    if((r-1)>=0)
    if(board[r-1][c].equals("  "))return true;
    
    if((r+1)<g)
    if(board[r+1][c].equals("  "))return true;
    
     if((c-1)>=0)
    if(board[r][c-1].equals("  "))return true;
    
    if((c+1)<g)
    if(board[r][c+1].equals("  "))return true;
    
    return false;
}


public void display()
{
    System.out.print('\u000C'+"  ");
for(i=0;i<g;i++)    
System.out.print(i+"  ");
System.out.println();
for(i=0;i<g;i++){
for(j=0;j<g;j++)
{
if(j==0)
System.out.print(i+" "+board[i][j]);
else System.out.print(" "+board[i][j]);
}
System.out.println();
}
}


public String its(int h)
{
return  Integer.toString(h);
}

public int sti(String h)
{
return Integer.parseInt(h);
}

public void greetings()
{
display();
System.out.println("HOPE YOU ENJOYED THE GAME!!\n   ==>> A PROJECT BY ANKUR INGALE!!");
}


public static void main(String args[])throws IOException
{
 Scanner sh=new Scanner(System.in);
SlidingPuzzle lol=new SlidingPuzzle();
System.out.println("ENTER GRID SIZE:::(EVEN NUMBER PLEASE)");
int h=sh.nextInt();
while(!(h%2==0))
{
System.out.println("EVEN NUMBER PLEASE ::");
h=sh.nextInt();
}

SlidingPuzzle actual=new SlidingPuzzle(h);
actual.game();
}
}