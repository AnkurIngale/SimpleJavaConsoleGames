import java.io.*;
import java.util.Random;
class HandCricket
{
BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
public static void main(String args[]) throws IOException
{
Random r=new Random();
HandCricket ob=new HandCricket();
int i,batOrBowl,toss,toss2;
String name;
System.out.print("PLAESE ENTER YOUR NAME : ");
name=ob.k.readLine();
System.out.println("\n\nWHAT DO YOU WANT??\n1.HEADS\n2.TAILS");
toss=Integer.parseInt(ob.k.readLine());
toss2=1+r.nextInt(2);
System.out.println("\nIT'S A "+((toss2==1)?"HEADS":"TAILS"));
if(toss==toss2)
{System.out.println('\u000C'+"YOU WON THE TOSS!! WHAT DO YOU WANT TO DO??\n1.BATTING\n2.BOWLING");
batOrBowl=Integer.parseInt(ob.k.readLine());
switch(batOrBowl)
{
case 1:
System.out.println("\nSO YOU WANT TO BAT!! OKAY, LET'S START :-\n");
ob.playerBatting(-1);
break;
case 2:
System.out.println("\nSO YOU WANT TO BOWL!!! OKAY, LET'S START :-\n");
ob.playerBowling(-1);
break;
default:
System.out.println("IN VALID");
System.exit(0);
}
}else
{
batOrBowl=r.nextInt(2);
System.out.println('\u000C'+"OH!! YOU LOST THE TOSS!!\nTHE COMPUTER DECIDED TO "+(batOrBowl==0?"BAT":"BOWL")+" FIRST!!");
if(batOrBowl==0)
ob.playerBowling(-1);
else
ob.playerBatting(-1);
}
}
void clear()
{System.out.print('\u000C');}
void playerBatting(int compScore)
{
try{
int myHand,computerHand,score=0,wickets=0;
Random r=new Random();
while(wickets!=10)
{
System.out.println("SCORE : "+score+"/"+wickets+"\n");
if(compScore>0)System.out.println("TARGET : "+(compScore+1)+"\n");
System.out.println("ENTER THE NUMBER OF FINGERS :");
myHand=Integer.parseInt(k.readLine());
while(myHand<1||myHand>6)
{
System.out.println("\nDON'T BE GREEDY!!\nENTER AGAIN!!");
myHand=Integer.parseInt(k.readLine());
}
computerHand=1+r.nextInt(6);
if(myHand==computerHand)
wickets++;
else
score=score+myHand;
if(compScore==-1)
{
if(wickets==10)
{
clear();
System.out.println("\nALL DOWN!!!\nYOU SCORED "+score+"!!\nNOW START BOWLING");
playerBowling(score);
break;
}
}
else
{
if(score>compScore)
{
System.out.println("\nYOU WON THE MATCH!!!\nHOPE YOU ENJOYED THE GAME!!\n  ==>> A PROJECT BY ANKUR INGALE");
break;
}
else if(score<compScore && wickets==10)
System.out.println("\nOH!! YOU LOST THE GAME!! WELL PLAYED\nHOPE YOU ENJOYED THE GAME!!\n  ==>> A PROJECT BY ANKUR INGALE");
}
clear();
}}
catch(Exception e)
{System.out.println(e);}
}
void playerBowling(int myScore)
{
int myHand,compHand,compScore=0,wickets=0;
try
{
Random r=new Random();
while(wickets!=10)
{
System.out.println("COMPUTER SCORE : "+compScore+"/"+wickets+"\n");
if(myScore>0)System.out.println("TARGET : "+myScore+"\n");
System.out.println("ENTER THE NUMBER OF FINGERS :");
myHand=Integer.parseInt(k.readLine());
while(myHand<1||myHand>6)
{
System.out.println("\nDON'T BE GREEDY!!\nENTER AGAIN!!");
myHand=Integer.parseInt(k.readLine());
}
compHand=1+r.nextInt(6);
if(myHand==compHand)
wickets++;
else
compScore=compScore+compHand;
if(myScore==-1)
{
if(wickets==10)
{
clear();
System.out.println("\nALL DOWN!!!\nCOMPUTER SCORED "+compScore+"!!\nNOW START BATTING");
playerBatting(compScore);
break;
}
}
else
{
if(compScore>=myScore)
{
System.out.println("\nOH!! YOU LOST THE GAME!! WELL PLAYED\nHOPE YOU ENJOYED THE GAME!!\n  ==>> A PROJECT BY ANKUR INGALE");
break;
}
else if(compScore<myScore && wickets==10)
System.out.println("\nYOU WON THE MATCH!!!\nHOPE YOU ENJOYED THE GAME!!\n  ==>> A PROJECT BY ANKUR INGALE");
}
clear();
}
}catch(Exception e)
{System.out.println(e);}}
}