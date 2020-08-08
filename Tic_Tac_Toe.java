/*
 * 1 | 2 | 3
 * ---------
 * 4 | 5 | 6
 * ---------
 * 7 | 8 | 9
 */
/*//functions:
   makeBoard();
   display();
   clearScreen();
   game();
   checkWin();
   playAgain();
   
   */
import java.util.*;//here i used scanner
class Tic_Tac_Toe
{ 
Scanner sc=new Scanner(System.in);
String a[][]=new String[3][3];
//original matrix
void makeBoard()
{
int p=1,i,j;
for(i=0;i<3;i++)
{
for(j=0;j<3;j++)
{
a[i][j]=Integer.toString(p);
p++;
}
}
}

void display()
{
int i,j;
for(i=0;i<3;i++)
{
for(j=0;j<3;j++)
{
if(j<2)
System.out.print(a[i][j]+" | ");
else
System.out.print(a[i][j]+"   ");
}
if(i<2)
System.out.println("\n---------");
else
System.out.println(); 
}
}

void clearScreen()
{
System.out.print('\u000C');
}
public void game() 
{
char chance='X',pa;
int s[]={5,61,64,681,74,887,62448,77,86};
int ch,i,j,input;
boolean winPlayer=false,play=false,winPlayer2=false;
makeBoard();
display();
label : for(ch=1;ch<=9;ch++)
{
if(ch%2==0){
chance='O';
}
else{

chance='X';

}
System.out.println("ENTER THE NUMBER WHERE YOU WANT TO PUT '"+chance+"'");
input=sc.nextInt();
while(s[input-1]==0)
{// oh i made it here just copy paste it
System.out.println("THIS AREA IS ALREADY OCCUPIED!!!\nENTER AGAIN");
input=sc.nextInt();
}
switch (input)
{
case 1:
a[0][0]=a[0][0].replace('1',chance);
s[0]=0;
break;
case 2:
a[0][1]=a[0][1].replace('2',chance);
s[1]=0;
break;
case 3:
a[0][2]=a[0][2].replace('3',chance);
s[2]=0;
break;
case 4:
a[1][0]=a[1][0].replace('4',chance);
s[3]=0;
break;
case 5:
a[1][1]=a[1][1].replace('5',chance);
s[4]=0;
break;
case 6:
a[1][2]=a[1][2].replace('6',chance);
s[5]=0;break;
case 7:
a[2][0]=a[2][0].replace('7',chance);
s[6]=0;break;
case 8:
a[2][1]=a[2][1].replace('8',chance);
s[7]=0;break;
case 9:
a[2][2]=a[2][2].replace('9',chance);
s[8]=0;break;
default:System.out.println("\nInvalid");
System.exit(0);
}
clearScreen();
display();  
winPlayer=checkwinForP();
if(winPlayer==true)
{
System.out.println("\nCONGRATULATIONS PLAYER1 WON THE GAME\n");
    break;
}
else if(winPlayer2==true)
{
System.out.println("\nCONGRATULATIONS PLAYER2 WON THE GAME\n");
break;//rest is same
} 
if(ch==9)
{
System.out.println("DRAW MATCH!!!\n");
break;
}
}
playAgain();
}
public boolean checkwinForP()// where logic stands
{
boolean ok=false;

if(a[0][0].charAt(0)==a[0][1].charAt(0) && a[0][1].charAt(0)==a[0][2].charAt(0))
ok=true;
else if(a[1][0].charAt(0)==a[1][1].charAt(0) && a[1][1].charAt(0)==a[1][2].charAt(0))
ok=true;
else if(a[2][0].charAt(0)==a[2][1].charAt(0) && a[2][1].charAt(0)==a[2][2].charAt(0))
ok=true;
else if(a[0][0].charAt(0)==a[1][1].charAt(0) && a[1][1].charAt(0)==a[2][2].charAt(0))
ok=true;
else if(a[0][2].charAt(0)==a[1][1].charAt(0) && a[1][1].charAt(0)==a[2][0].charAt(0))
ok=true;
else if(a[0][0].charAt(0)==a[1][0].charAt(0) && a[1][0].charAt(0)==a[2][0].charAt(0))
ok=true;
else if(a[0][1].charAt(0)==a[1][1].charAt(0) && a[1][1].charAt(0)==a[2][1].charAt(0))
ok=true;
else if(a[0][2].charAt(0)==a[1][2].charAt(0) && a[1][2].charAt(0)==a[2][2].charAt(0))
ok=true;
else
ok=false; 

return ok;

}

public void playAgain() 
{
System.out.println("DO YOU WANT TO PLAY AGAIN??(y/n)");
String playing=sc.nextLine();
playing=sc.nextLine();
if(playing.length()>0){
if(playing.charAt(0)=='n'||playing.charAt(0)=='N')
{
System.out.println("THANK YOU FOR PLAYING THE GAME.\nHOPE YOU ENJOYED IT.\n  ==>> A PROJECT BY ANKUR INGALE.");
}
else {
clearScreen();
game();
}
}}
public static void main()
{
Tic_Tac_Toe mygame=new Tic_Tac_Toe();
mygame.game();
}
}









