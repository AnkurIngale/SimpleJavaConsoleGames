import java.io.*;
import java.util.*;
class SnakesAndLadders
{
int i;
void makeAndDisplay(int pos1,int pos2,char player1,char player2)
{
int a[][]={{100,99,98,97,96,95,94,93,92,91},
{81,82,83,84,85,86,87,88,89,90},
{80,79,78,77,76,75,74,73,72,71},
{61,62,63,64,65,66,67,68,69,70},
{60,59,58,57,56,55,54,53,52,51},
{41,42,43,44,45,46,47,48,49,50},
{40,39,38,37,36,35,34,33,32,31},
{21,22,23,24,25,26,27,28,29,30},
{20,19,18,17,16,15,14,13,12,11},
{01,02,03,04,05,06,07,8,9,10}};
int j;
for(i=0;i<10;i++)
{
for(j=0;j<10;j++)
{
if(a[i][j]==pos1)
System.out.print("  "+player1+" !");
else
if(a[i][j]==pos2)
System.out.print("  "+player2+" !");
else
System.out.print("  "+a[i][j]+" !");
}
System.out.println("\n_____________________________________________________________________");
}
}
String forEnter()
{
Scanner sc=new Scanner(System.in);
String enter=sc.nextLine();
if(enter.equals(""))
return "DICE THROWN";
else
return "DICE THROWN BUT IRREGULARLY";
}
public void game()
{
char player1='X',player2='O';
boolean play=true;
String dice;char chance=' ';
BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
Random r=new Random(); 
int counter=0,pos1=1,pos2=1,nod=0,snak=0,ladd=0;//this will count the number of chances
while(play)
{ 
makeAndDisplay(pos1,pos2,player1,player2);
counter++;
if(counter%2==0)
{
chance=player2;
}
else
chance=player1;
System.out.println("\n"+((chance==player1)?"PLAYER 1'S TURN!!\n":"PLAYER 2'S TURN!!\n")+"PRESS THE ENTER KEY TO THROW THE DICE");
dice=forEnter();
System.out.print('\u000C');nod=1+r.nextInt(6);
System.out.println(dice+"\nTHE NUMBER OF THE DICE IS : "+nod);
if(chance==player1)
{
pos1+=nod;
if(pos1>100)
pos1=100-(pos1-100);
}
else
{
pos2=pos2+nod;
if(pos2>100)
{pos2=100-(pos2-100);}
}
while(nod==6)
{
System.out.println("ENTER AGAIN FOR THE DICE READS 6!!!");
dice=forEnter();
nod=1+r.nextInt(6);
if(chance==player1)
{
pos1=pos1+nod;
if(pos1>100)
pos1=100-(pos1-100);
}
else
{
pos2=pos2+nod;
if(pos2>100)
{pos2=100-(pos2-100);}
}
}
if(chance==player1)
{
snak=snakes(pos1);
if(snak>0)
pos1=snak;
ladd=ladders(pos1);
if(ladd>0)
pos1=ladd;
}
else
{
snak=snakes(pos2);
if(snak>0)
pos2=snak;
ladd=ladders(pos2);
if(ladd>0)
pos2=ladd;
}
if(pos1==100 && pos2!=100)
{play=false;System.out.println("PLAYER 1 WINS!!!");}
else if(pos2==100 && pos1!=100)
{play=false;System.out.println("PLAYER 2 WINS!!!");}
} 
}
int snakes(int player)
{
int answer=0;
int snakeHead[]={13,37,50,60,67,83,88,94};
int snakeTail[]={4,15,12,44,47,18,70,65};
for(i=0;i<8;i++)
{
if(player==snakeHead[i])
{
System.out.println("A SNAKE BIT YOU!!!");
answer=snakeTail[i];break;}
}
return answer;
}
int ladders(int player)
{
int ansewer=0;
int ladderStart[]={3,9,17,35,40,55,69,80};
int ladderEnd[]={39,31,27,64,59,85,91,99};
for(i=0;i<8;i++)
{
if(player==ladderStart[i])
{
System.out.println("CLIMBING UP A LADDER!!!");
ansewer=ladderEnd[i];}
}
return ansewer; 
}
public static void main(String args[])
{
SnakesAndLadders creepy=new SnakesAndLadders();
creepy.game();
}}