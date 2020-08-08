import java.util.*;
class TTTRP//tictactoeartificialintelligence
{
public static void main(String args[])
    {
    TTTRP n=new TTTRP();
    n.game();
    }
Scanner s;
Random  r=new Random();

String a[][]=new String[3][3];
String p1="X",p2="O"; 
int i,j;
public void game()
{
    for(i=0;i<3;i++)
    for(j=0;j<3;j++)
    {a[i][j]=" ";}
    s=new Scanner(System.in);
   

boolean play=true;
int row=-1,col=-1;
while(play)
{
    display();
System.out.println("ENTER NUMBER OF ROW AND COLUMN!!");
row=s.nextInt();
col=s.nextInt();

while(!rightMove(row,col))
{
System.out.println("ERROR!!\nENTER AGAIN!!");
row=s.nextInt();
col=s.nextInt();
}
a[row][col]=p1;

if(!gameOver())computer();

play=!gameOver();

if(!play)
{
display();
}
}    

}
public boolean rightMove(int row,int col)
{int counter=0;
if(a[row][col].equals("X") || a[row][col].equals("O"))
return false;
return true;
}


public void display()
{
    int i,j;

    System.out.println('\u000C'+"  0 1 2");
    for(i=0;i<3;i++)
{
for(j=0;j<3;j++)
{
if(j==0)System.out.print(i+" "+a[i][j]);
else System.out.print(" "+a[i][j]);
}
System.out.println();
}
}

public void computer()
{
int r1=r.nextInt(3),c1=r.nextInt(3);

while(!(rightMove(r1,c1)))
{
r1=r.nextInt(3);c1=r.nextInt(3);
}

a[r1][c1]="O";
}

public boolean gameOver()
{
    int counter=0;
for(i=0;i<3;i++)
for(j=0;j<3;j++)
    {if(a[i][j].equals("X") || a[i][j].equals("O")) counter++;}
   
if(counter==9)return true;
else if(checkWinForP())return true;

return false;    
}

public boolean checkWinForP()// where logic stands
{
boolean ok=false;

if(a[0][0].charAt(0)==a[0][1].charAt(0) && a[0][1].charAt(0)==a[0][2].charAt(0) && (a[0][0].charAt(0)!=' '))
ok=true;
else if(a[1][0].charAt(0)==a[1][1].charAt(0) && a[1][1].charAt(0)==a[1][2].charAt(0) && (a[1][0].charAt(0)!=' '))
ok=true;
else if(a[2][0].charAt(0)==a[2][1].charAt(0) && a[2][1].charAt(0)==a[2][2].charAt(0) && (a[2][0].charAt(0)!=' '))
ok=true;
else if(a[0][0].charAt(0)==a[1][1].charAt(0) && a[1][1].charAt(0)==a[2][2].charAt(0) && (a[0][0].charAt(0)!=' '))
ok=true;
else if(a[0][2].charAt(0)==a[1][1].charAt(0) && a[1][1].charAt(0)==a[2][0].charAt(0) && (a[0][2].charAt(0)!=' '))
ok=true;
else if(a[0][0].charAt(0)==a[1][0].charAt(0) && a[1][0].charAt(0)==a[2][0].charAt(0) && (a[0][0].charAt(0)!=' '))
ok=true;
else if(a[0][1].charAt(0)==a[1][1].charAt(0) && a[1][1].charAt(0)==a[2][1].charAt(0) && (a[0][1].charAt(0)!=' '))
ok=true;
else if(a[0][2].charAt(0)==a[1][2].charAt(0) && a[1][2].charAt(0)==a[2][2].charAt(0) && (a[0][2].charAt(0)!=' '))
ok=true;
else
ok=false; 

return ok;

}
}