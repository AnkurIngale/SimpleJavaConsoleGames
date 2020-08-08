import java.io.*;
import java.util.Random;
class Football
{
void makeGoalPost()
{
System.out.println("        ------------------------|------------------------|------------------------");
System.out.println("       |                        |                        |                        |");
System.out.println("       |           1            |            2           |            3           |");
System.out.println("       |                        |                        |                        |");
System.out.println("       |                        |                        |                        |");
System.out.println("       |------------------------|------------------------|------------------------|");
System.out.println("       |                        |                        |                        |");
System.out.println("       |                        |                        |                        |");
System.out.println("       |           4            |            5           |            6           |");
System.out.println("       |                        |                        |                        |");
System.out.println("       |                        |                        |                        |");
System.out.println("       |------------------------|------------------------|------------------------|");
System.out.println("       |                        |                        |                        |");
System.out.println("       |           7            |            8           |            9           |");
System.out.println("       |                        |                        |                        |");
System.out.println("       |                        |                        |                        |");
System.out.println("        ------------------------|------------------------|------------------------");
}
int Choice,goals=0,goalcomp=0,i=0,savecomp=0,saves=0;
int computerChoice;
BufferedReader k=new BufferedReader (new InputStreamReader(System.in));
Random r=new Random();
void gameplayer()
{
try{
display();
makeGoalPost();
System.out.println("\nENTER THE NUMBER WHERE YOU WANT TO HIT THE BALL??");
Choice=Integer.parseInt(k.readLine());
computerChoice=1+r.nextInt(9);
switch(Choice)
{
case 1:
if(computerChoice==1)
savecomp++;
else
goals++;
break;
case 2:
if(computerChoice==2)
savecomp++;
else
goals++;
break;
case 3:
if(computerChoice==3)
savecomp++;
else
goals++;
break;
case 4:
if(computerChoice==4)
savecomp++;
else
goals++;
break;
case 5:
if(computerChoice==5 )
savecomp++;
else
goals++;
break;
case 6:
if(computerChoice==6)
savecomp++;
else
goals++;
break;
case 7:
if( computerChoice==7)
savecomp++;
else
goals++;
break;
case 8:
if(computerChoice==8 )
savecomp++;
else
goals++;
break;
case 9:
if(computerChoice==9)
savecomp++;
else
goals++;
break;
default: System.out.println("GET LOST!!");System.exit(0);
}
}
catch(Exception e)
{System.out.println(e);}
}
void computer()
{

try{
display();
makeGoalPost();
System.out.println("\nENTER THE NUMBER WHERE YOU WANT TO DIVE??");
Choice=Integer.parseInt(k.readLine());
computerChoice=1+r.nextInt(9);
switch(computerChoice)
{
case 1:
if(Choice==1)
saves++;
else
goalcomp++;
break;
case 2:
if(Choice==2)
saves++;
else
goalcomp++;
break;
case 3:
if(Choice==3 )
saves++;
else
goalcomp++;
break;
case 4:
if(Choice==4 )
saves++;
else
goalcomp++;
break;
case 5:
if(Choice==5  )
saves++;
else
goalcomp++;
break;
case 6:
if(Choice==6 )
saves++;
else
goalcomp++;
break;
case 7:
if( Choice==7)
saves++;
else
goalcomp++;
break;
case 8:
if( Choice==8 )
saves++;
else
goalcomp++;
break;
case 9:
if(Choice==9)
saves++;
else
goalcomp++;
break;
default: System.out.println("GET LOST!!");System.exit(0);
}
}

catch(Exception e)
{System.out.println(e);
display();
}
}
void game()
{
int j;
for(j=1;j<=5;j++)
{
gameplayer();
computer();
if(j==5)
{
System.out.print('\u000C');
display();
System.out.println("HOPE U ENJOYED \n   A PROJECT BY ANKUR INGALE");
}
if(goalcomp==goals)
continue;
}
}
void display()
{
System.out.print('\u000C');
System.out.println("COMPUTER DETAILS :-\n---------------------");
System.out.println("GOALS SCORED : "+goalcomp+"\nSAVES : "+savecomp+"\n-------------------------------------");
System.out.println("PLAYER DETAILS :-\n-------------------");
System.out.println("GOALS SCORED : "+goals+"\nSAVES : "+saves+"\n-------------------------------------------");
}
public static void main(String args[]){
Football letsPlay=new Football();
letsPlay.game();
}
}