/*
!------------------------------------------------!
!   +   !   +   !   +   !   +   !   +   !   +   
!------------------------------------------------!
!   +   !   +   !   +   !   +   !   +   !   +   
!------------------------------------------------!
!   +   !   +   !   +   !   +   !   +   !   +   
!------------------------------------------------!
!   +   !   +   !   +   !   +   !   +   !   +   
!------------------------------------------------!
!   +   !   +   !   +   !   +   !   +   !   +   
!------------------------------------------------!
!   +   !   +   !   +   !   +   !   +   !   +   
!------------------------------------------------!
!   +   !   +   !   +   !   +   !   +   !   +   
!------------------------------------------------!
    1       2       3       4       5       6
*/import java.io.*;
class Connect4
{
char board[][]=new char[6][7];
void makeBoard()
{
int i,j;
char ch='+';
for(i=0;i<6;i++)
{
for(j=0;j<7;j++)
{
board[i][j]=ch;
}
}}
void display()
{
int i,j;
 System.out.println("!-------------------------------------------------------!");
for(i=0;i<6;i++)//   !   +   !   +   !   +   !   +   !   +   !   +   !   +   !  
{
for(j=0;j<7;j++)
{if(j==9)
{System.out.print("!   "+board[i][j]+"  !");}
else
System.out.print("!   "+board[i][j]+"   ");
}
 System.out.println("\n!--------------------------------------------------------!");
}                 //   !   +   !   +   !   +   !   +   !   +   !   +   !   +   !
 System.out.println("    1       2       3       4       5       6       7");
}

public void game()
{
try{
BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
String name;boolean winner=false;
char ch='\u25CB',ch1='\u25CB',ch2='\u25CF';
int totalChances=7*6;
int i,inputColumn,j;
String player1,player2;
System.out.print("ENTER THE NAME OF PLAYER 1: ");
player1=k.readLine();player1=player1.toUpperCase();
System.out.print("\n\nENTER THE NAME OF PLAYER 2: ");
player2=k.readLine();player2=player2.toUpperCase();
System.out.print("\n\n");
makeBoard();display();
for(i=1;i<=totalChances;i++)
{
if(i%2==0){
ch='\u25CF';
name=player2;
}
else {ch='\u25CB';name=player1;}
System.out.println(name+"!! ENTER THE COLUMN NUMBER YOU WANT TO PUT YOUR "+ch);
inputColumn=Integer.parseInt(k.readLine());
switch(inputColumn)
{
case 1:
if(board[5][0]!='+')
{
if(board[4][0]!='+')
{
if(board[3][0]!='+')
{
if(board[2][0]!='+'){
if(board[1][0]!='+')
{
if(board[0][0]!='+')
{System.out.println("THIS COLUMN IS FILLED NOW.\nYOU MISS YOUR TURN\nCHANCE GOES TO "+((name.equals(player1))?player2:player1));
}else board[0][0]=ch;
}else board[1][0]=ch;
}else board[2][0]=ch;
}else board[3][0]=ch;
}else board[4][0]=ch;
}else board[5][0]=ch;

break;
case 2:

if(board[5][1]!='+')
{
if(board[4][1]!='+')
{
if(board[3][1]!='+')
{
if(board[2][1]!='+'){
if(board[1][1]!='+')
{
if(board[0][1]!='+'){
System.out.println("THIS COLUMN IS FILLED NOW.\nYOU MISS YOUR TURN\nCHANCE GOES TO "+((name.equals(player1))?player2:player1));
}
else board[0][1]=ch;
}else board[1][1]=ch;
}else board[2][1]=ch;
}else board[3][1]=ch;
}else board[4][1]=ch;
}else board[5][1]=ch;

break;
case 3:
if(board[5][2]!='+')
{
if(board[4][2]!='+')
{
if(board[3][2]!='+')
{
if(board[2][2]!='+'){
if(board[1][2]!='+')
{
if(board[0][2]!='+')
{System.out.println("THIS COLUMN IS FILLED NOW.\nYOU MISS YOUR TURN\nCHANCE GOES TO "+((name.equals(player1))?player2:player1));
}else board[0][2]=ch;
}else board[1][2]=ch;
}else board[2][2]=ch;
}else board[3][2]=ch;
}else board[4][2]=ch;
}else board[5][2]=ch;

break;
case 4:
if(board[5][3]!='+'){
if(board[4][3]!='+')
{
if(board[3][3]!='+')
{
if(board[2][3]!='+'){
if(board[1][3]!='+')
{
if(board[0][3]!='+')
{System.out.println("THIS COLUMN IS FILLED NOW.\nYOU MISS YOUR TURN\nCHANCE GOES TO "+((name.equals(player1))?player2:player1));
}else board[0][3]=ch;
}else board[1][3]=ch;
}else board[2][3]=ch;
}else board[3][3]=ch;
}else board[4][3]=ch;
}else board[5][3]=ch;

break;
case 5:

if(board[5][4]!='+')
{
if(board[4][4]!='+')
{
if(board[3][4]!='+')
{
if(board[2][4]!='+'){
if(board[1][4]!='+')
{
if(board[0][4]!='+')
{System.out.println("THIS COLUMN IS FILLED NOW.\nYOU MISS YOUR TURN\nCHANCE GOES TO "+((name.equals(player1))?player2:player1));
}else board[0][4]=ch;
}else board[1][4]=ch;
}else board[2][4]=ch;
}else board[3][4]=ch;
}else board[4][4]=ch;
}else board[5][4]=ch;

break;
case 6:

if(board[5][5]!='+')
{
if(board[4][5]!='+')
{
if(board[3][5]!='+')
{
if(board[2][5]!='+'){
if(board[1][5]!='+')
{
if(board[0][5]!='+')
{System.out.println("THIS COLUMN IS FILLED NOW.\nYOU MISS YOUR TURN\nCHANCE GOES TO "+((name.equals(player1))?player2:player1));
}else board[0][5]=ch;
}else board[1][5]=ch;
}else board[2][5]=ch;
}else board[3][5]=ch;
}else board[4][5]=ch;
}else board[5][5]=ch;

break;
case 7:
if(board[5][6]!='+')
{
if(board[4][6]!='+')
{
if(board[3][6]!='+')
{
if(board[2][6]!='+'){
if(board[1][6]!='+')
{
if(board[0][6]!='+')
{System.out.println("THIS COLUMN IS FILLED NOW.\nYOU MISS YOUR TURN\nCHANCE GOES TO "+((name.equals(player1))?player2:player1));
}else board[0][6]=ch;
}else board[1][6]=ch;
}else board[2][6]=ch;
}else board[3][6]=ch;
}else board[4][6]=ch;
}else board[5][6]=ch;

break;
default:
System.out.println("INVALID ");
System.exit(0);
}
clear();
display();
winner=getWinner();
if(winner)
{
System.out.println("\n"+name+" , YOU WON THE GAME!!!\nCONGRATULATIONS!!!\n"+(name.equals(player1)?player2 :player1)+", WELL PLAYED!!\nHOPE YOU ENJOYED\n   ==>> A PROJECT BY ANKUR INGALE");
break;}
if(winner==false && i==(42))
{
System.out.println("DRAW MATCH!!! ALL COLUMNS FILLED!!!\nHOPE YOU ENJOYED\n   ==>> A PROJECT BY ANKUR INGALE");
break;
}
}}
catch(Exception e)
{System.out.println(e);}}
public char p(int x,int y)
{
return (y<0||x<0||y>=6||x>=7)?'+':board[y][x];
}
boolean getWinner()
{
int y,x;
for(y=0;y<6;y++)
for(x=0;x<7;x++)
if(p(y,x)!='+' && p(y,x)==p(y,x+1) && p(y,x)==p(y,x+2) &&p(y,x)==p(y,x+3))
return true;
for(y=0;y<6;y++)
for(x=0;x<7;x++)
if(p(y,x)!='+' && p(y,x)==p(y+1,x) && p(y,x)==p(y+2,x) &&p(y,x)==p(y+3,x))
return true;
for(y=0;y<6;y++)
for(x=0;x<7;x++)
if(p(y,x)!='+' && p(y,x)==p(y,x+1) && p(y,x)==p(y,x+2) &&p(y,x)==p(y,x+3))
return true;
for(y=0;y<6;y++)
for(x=0;x<7;x++)
for(int d=-1;d<=1;d+=2)
if(p(y,x)!='+' && p(y,x)==p(y+1*d,x+1) && p(y,x)==p(y+2*d,x+2) &&p(y,x)==p(y+3*d,x+3))
return true;
for(y=0;y<6;y++)
for(x=0;x<7;x++)
if(p(y,x)=='+')
return false;
return false;
}
void clear()
{
System.out.print('\u000C');
}
public static void main(String args[])
{
Connect4 start=new Connect4();
start.game();
}
}