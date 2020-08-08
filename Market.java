import java.io.*;
import java.util.Random;
class Market
{
BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
int rate[]={35,40,120,55,50,80,60};
String company[]={"TATA","ONGC","NIFTY","INFOSYS","RELIANCE","RELIANCE OILS","SBI"};
int rateSelector[]={-15,-10,-5,5,10,15};
boolean haveshares[]={false,false,false,false,false,false,false};
int saveNumberOfShares[]={0,0,0,0,0,0,0};
int hms,sellorbuy,which,money=100000,initial,j,h,price=0;
public void game(){
String name;int rounds,i;
try{
System.out.print("YOUR NAME : ");
name=k.readLine();
System.out.print("\nENTER THE NUMBER OF ROUNDS YOU WANT TO PLAY : ");
rounds=Integer.parseInt(k.readLine());
for(i=1;i<=(rounds*3);i++)
{
initial=money;
System.out.println("MONEY YOU HAVE : Rs."+initial+"\n");
System.out.println("WHAT DO YOU WANT TO DO??\n1.BUY\n2.SELL\n3.EXIT GAME");
sellorbuy=Integer.parseInt(k.readLine());
System.out.print('\u000C');
switch(sellorbuy)
{
case 1:
buyingSystem();
break;
case 2:
if(haveshares[0]==false&&haveshares[1]==false&&haveshares[2]==false&&haveshares[3]==false&&haveshares[4]==false&&haveshares[5]==false&&haveshares[6]==false)
{System.out.println("YOU CANNOT SELL SHARES UNTIL YOU BUY IT!!");
i--;
continue;}
else
sellingSystem();
break;
case 3:
last();
System.out.println("HOPE YOU ENJOYED THE GAME!!\n   ==> A PROJECT BY ANKUR INGALE");
System.exit(0);
break;
default:System.out.println("INVALID CHOICE!!");
last();
System.exit(0);
}
if(i%3==0)
{
rounder();
}
if(i==(rounds*3))
last();
}
}
catch(Exception e)
{
System.out.println(e);
}
}
void last()
{
int moneyx=initial;
System.out.println("YOUR GAME SUMMARY :-\n--------------------\n");
for(j=0;j<7;j++)
{
if(haveshares[j]==true)
{
System.out.println(company[j]+" => "+saveNumberOfShares[j]+" SHARES => Rs."+(saveNumberOfShares[j]*rate[j]));
moneyx=moneyx+(saveNumberOfShares[j]*rate[j]);
}
}
System.out.println("THEREFORE, TOTAL AMOUNT : Rs."+moneyx);
}
void rateChanger()
{
Random r=new Random();
for(j=0;j<7;j++)
{
if(haveshares[j]==true)
{
rate[j]=rate[j]+(rateSelector[r.nextInt(6)]);
}
}
}
void rounder()
{
System.out.print('\u000C');
try{
System.out.println("NOW LET'S CHECK YOUR LUCK!!!\nIF THE RATES INCREASE YOU CAN SELL THE SHARES TO GAIN!!\nBUT IF RATES DECREASE THEN BETTER BUY SHARES!!");
rateChanger();
}
catch(Exception e)
{System.out.println(e);}
}
void buyingSystem()
{
try{
System.out.println("IN WHICH COMPANY YOU WANT TO BUY SHARES??");
for(j=0;j<7;j++)
{
System.out.println((j+1)+"."+company[j]+" => Rs."+rate[j]+"/SHARE");
}
which=Integer.parseInt(k.readLine());
if(which<1 || which>7)
{System.out.println("GET LOST!!");last();System.exit(0);}
howManyShares();
switch(which)
{//company[]={"TATA","ONGC","NIFTY","INFOSYS","RELIANCE","RELIANCE OILS","SBI"};
case 1:
price=money-(rate[0]*hms);
while(price<0)
{
System.out.println("YOU CANNOT BUY "+hms+" SHARES BECAUSE YOUR MONEY IS RUNNING OUT!!\nYOU CAN BUY MAXIMUM "+((int)(money/rate[0]))+" SHARES!!\nTHEREFORE, ENTER A SENSIBLE NUMBER OF SHARES");
howManyShares();
price=money -(rate[0]*hms);
}
haveshares[0]=true;
saveNumberOfShares[0]=saveNumberOfShares[0]+hms;
money=price;
break;
case 2:
price=money -(rate[1]*hms);
while(price<0)
{
System.out.println("YOU CANNOT BUY "+hms+" SHARES BECAUSE YOUR MONEY IS RUNNING OUT!!\nYOU CAN BUY MAXIMUM "+((int)(money/rate[1]))+" SHARES!!\nTHEREFORE, ENTER A SENSIBLE NUMBER OF SHARES");
howManyShares();
price=money -(rate[1]*hms);
}haveshares[1]=true;saveNumberOfShares[1]=saveNumberOfShares[1]+hms;
money=price;
break;
case 3:
price=money-(rate[2]*hms);
while(price<0)
{
System.out.println("YOU CANNOT BUY "+hms+" SHARES BECAUSE YOUR MONEY IS RUNNING OUT!!\nYOU CAN BUY MAXIMUM "+((int)(money/rate[2]))+" SHARES!!\nTHEREFORE, ENTER A SENSIBLE NUMBER OF SHARES");
howManyShares();
price=money-(rate[2]*hms);
}haveshares[2]=true;saveNumberOfShares[2]=saveNumberOfShares[2]+hms;
money=price;
break;
case 4:
price=money-(rate[3]*hms);
while(price<0)
{
System.out.println("YOU CANNOT BUY "+hms+" SHARES BECAUSE YOUR MONEY IS RUNNING OUT!!\nYOU CAN BUY MAXIMUM "+((int)(money/rate[3]))+" SHARES!!\nTHEREFORE, ENTER A SENSIBLE NUMBER OF SHARES");
howManyShares();
price=money-(rate[3]*hms);
}haveshares[3]=true;saveNumberOfShares[3]=saveNumberOfShares[3]+hms;
money=price;
break;
case 5:
price=money-(rate[4]*hms);
while(price<0)
{
System.out.println("YOU CANNOT BUY "+hms+" SHARES BECAUSE YOUR MONEY IS RUNNING OUT!!\nYOU CAN BUY MAXIMUM "+((int)(money/rate[4]))+" SHARES!!\nTHEREFORE, ENTER A SENSIBLE NUMBER OF SHARES");
howManyShares();
price=money-(rate[4]*hms);
}haveshares[4]=true;saveNumberOfShares[4]=saveNumberOfShares[4]+hms;
money=price;
break;
case 6:
price=money-(rate[5]*hms);
while(price<0)
{
System.out.println("YOU CANNOT BUY "+hms+" SHARES BECAUSE YOUR MONEY IS RUNNING OUT!!\nYOU CAN BUY MAXIMUM "+((int)(money/rate[5]))+" SHARES!!\nTHEREFORE, ENTER A SENSIBLE NUMBER OF SHARES");
howManyShares();
price=money-(rate[5]*hms);
}haveshares[5]=true;saveNumberOfShares[5]=saveNumberOfShares[5]+hms;
money=price;
break;
case 7:
price=money-(rate[6]*hms);
while(price<0)
{
System.out.println("YOU CANNOT BUY "+hms+" SHARES BECAUSE YOUR MONEY IS RUNNING OUT!!\nYOU CAN BUY MAXIMUM "+((int)(money/rate[6]))+" SHARES!!\nTHEREFORE, ENTER A SENSIBLE NUMBER OF SHARES");
howManyShares();
price=money -(rate[6]*hms);
}haveshares[6]=true;saveNumberOfShares[6]=saveNumberOfShares[6]+hms;
money=price;
break;
}
}
catch(Exception e)
{System.out.println(e);}
}
void sellingSystem()
{
String com;
try{
for(j=0;j<7;j++)
{
if(haveshares[j]==true)
System.out.println(company[j]+" => Rs."+rate[j]+"/SHARE");
}
System.out.println("TYPE IN THE NAME OF THE COMPANY WHOSE SHARES YOU WANNA SELL???(NO CAPSLOCK NEEDED BUT MAKE SURE TO PUT IN THE NAME FROM THE LIST ABOVE)");
com=k.readLine();
com=com.trim();
com=com.toUpperCase();
for(j=0;j<7;j++)
{
if(com.equals(company[j]))
{
if(haveshares[j]==false)
{
System.out.println("WRONG ENTRY!!\nSYSTEM CLOSED DOWN!!");
last();System.exit(0);
}
else
{
howManyShares();
while(hms>saveNumberOfShares[j])
{
System.out.println("YOU ARE PUTTING EXCESS NUMBER OF SHARES THAN YOU BOUGHT!!\nENTER AGAIN!! ");
howManyShares();
}
money=money+(rate[j]*hms);
saveNumberOfShares[j]=saveNumberOfShares[j]-hms;
break;
}
}
}
}
catch(Exception e)
{System.out.println(e);}
}
public static void main(String args[])
{
Market bank=new Market();
bank.game();
}
void howManyShares()
{
try{
System.out.println("\nHOW MANY NUMBER OF SHARES YOU WANT??\n1.50\n2.100\n3.500\n4.1000\n5.5000\n6.10000 ");
h=Integer.parseInt(k.readLine());
switch(h)
{
case 1:hms=50;break;
case 2:hms=100;break;
case 3:hms=500;break;
case 4:hms=1000;break;
case 5:hms=5000;break;
case 6:hms=10000;break; 
default :System.out.println("GET LOST!!");last();System.exit(0);
}
System.out.print('\u000C');
}
catch(Exception e)
{System.out.println(e);
}
}}






















