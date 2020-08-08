import java.io.*;
import java.util.Random;
class Roulette
{
void makeboard()
{
String a[]=new String[43];
int i;
for(i=0;i<37;i++)
{
a[i]=Integer.toString(i);
} 
a[37]="ODD";
a[38]="EVEN";
a[39]="0-9";
a[40]="10-18";
a[41]="19-27";
a[42]="28-36";
}
void instructions()
{
System.out.println("1.SELECT A NUMBER FROM 0 TO 36\n2.COMPUTER WILL SELECT 1 NUMBER\n3.YOU CAN ALSO SELECT OTHER OPTIONS LIKE ODD,EVEN AND THE RANGE OF NUMBERS.\n4.PRESS EXIT OPTION TO EXIT.\n5.ONE WHO HAS MORE MONEY WINS!! ");
}
void game()
{
Random r1=new Random();
double amount=100000.0,initial=0.0;int dice;
BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
int turn=1,mychoice,other,other2,othera=0,othera2=0;
boolean play=true;
System.out.println("WELCOME TO ANKUR'S CASINO!!!\nYOU WILL BE PLAYING ROULETTE\n");
instructions(); 
try{
while(play && amount!=0)
{ 
initial=amount;
System.out.println("MONEY YOU HAVE : $"+initial);
System.out.println("SELECT ANY NUMBER FROM 0 TO 36 OR ENTER 99 TO EXIT");
mychoice=Integer.parseInt(k.readLine());
if(mychoice==99)
{
play=false;
System.exit(0);
}
while(mychoice<0 || mychoice>36 && mychoice<99)
{
System.out.println("\nONLY BETWEEN 0 AND 36");
mychoice=Integer.parseInt(k.readLine());}
System.out.print('\u000C');
System.out.println("\nNOW , ENTER IF YOU WANT THE FOLLOWING :-\n1.ODD NUMBER\n2.EVEN NUMBER\n7.NO THANKS!! ");
other=Integer.parseInt(k.readLine());
System.out.println("\nNOW , ENTER IF YOU WANT THE FOLLOWING :-\n1. 0-9\n2. 10-18\n3. 19-27\n4.28-36\n7.NO THANKS!! ");
other2=Integer.parseInt(k.readLine());
System.out.print('\u000C');
if(other!=7)
{
if(other!=7){
System.out.println("\nENTER THE AMOUNT YOU HAVE TO BET ON!! ALSO PUT THE AMOUNT ON ODD/EVEN AND ALSO ON THR RANGE:- ");
amount=Double.parseDouble(k.readLine());
othera=Integer.parseInt(k.readLine());
othera2=Integer.parseInt(k.readLine());
System.out.print('\u000C');}
else
{
other2=0;
}
}
else other=0;
dice=r1.nextInt(37);
System.out.println("LET'S CHECK YOUR LUCK!!\nTHE BALL STOPS ON "+dice);
if(dice==mychoice)
{
System.out.println("YOU HAVE LUCK MY FRIEND!!! YOU RECEIVE DOUBLE AMOUNT!!");
amount=amount*2;
switch(other){
case 1:
if(dice%2!=0)
{
System.out.println("YOU GOT AN ODD!!! HALF AMOUNT WILL BE ADDED");
amount=amount+amount*0.5;
}
else
{
System.out.println("BAD LUCK!!! HALF AMOUNT WILL BE SUBTRACTED");
amount=amount-(amount*0.5);
}
break;
case 2:
if(dice%2==0)
{System.out.println("YOU GOT AN EVEN !!! HALF AMOUNT WILL BE ADDED");
amount=amount+amount*0.5;}
else
{
System.out.println("BAD LUCK!!! HALF AMOUNT WILL BE SUBTRACTED");
amount=amount-(amount*0.5);
}
break;
default :other=0;othera=0;
}
switch(other2)
{
case 1:
if(dice<=9)
{
System.out.println("YOU CAME IN THAT RANGE!!! HALF AMOUNT WILL BE ADDED");
amount=amount+amount*0.5;
}
else
{
System.out.println("BAD LUCK!!! HALF AMOUNT WILL BE SUBTRACTED");
amount=amount-(amount*0.5);
}
break;
case 2:
if(dice>=10 && dice<=18)
{
System.out.println("YOU CAME IN THAT RANGE!!! HALF AMOUNT WILL BE ADDED");
amount=amount+amount*0.5;
}
else
{System.out.println("BAD LUCK!!! HALF AMOUNT WILL BE SUBTRACTED");
amount=amount-(amount*0.5);
}
break;
case 3:
if(dice>=19 && dice<=27)
{
System.out.println("YOU CAME IN THAT RANGE!!! HALF AMOUNT WILL BE ADDED");
amount=amount+amount*0.5;
}
else
{System.out.println("BAD LUCK!!! HALF AMOUNT WILL BE SUBTRACTED");
amount=amount-(amount*0.5);
}
break;
case 4:
if(dice>=28 && dice<=36)
{
System.out.println("YOU CAME IN THAT RANGE!!! HALF AMOUNT WILL BE ADDED");
amount=amount+amount*0.5;
}
else
{System.out.println("BAD LUCK!!! HALF AMOUNT WILL BE SUBTRACTED");
amount=amount-(amount*0.5);
}
break;
default : other2=0;othera2=0;
}

}
else
{
System.out.println("BAD LUCK THIS TIME!!! YOUR MONEY IS WASTED!!!");
amount=initial-(amount+othera+othera2);
}
}}
catch(Exception e)
{System.out.println();}
}
public static void main(String args[])
{
Roulette gamer=new Roulette();
gamer.game();
}}

/*components in board
   0-36
   odd even 0-9 or 10-18 or 19-27 or 28-36
   */

