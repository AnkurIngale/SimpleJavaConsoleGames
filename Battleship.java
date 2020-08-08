import java.io.*;
class Battleship
{
public static void main(String args[])
{
Battleship cannon=new Battleship();
cannon.game();
} 
String player1ShipGrid[][]=new String[10][10];
String player1ShootingGrid[][]=new String[10][10];
BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
int i,j;
String player2ShipGrid[][]=new String[10][10];
String player2ShootingGrid[][]=new String[10][10];
String ships[]={"CARRIER","BATTLESHIP","CRUISER","SUBMARINE","DESTROYER"};
void makeboard()
{
for(i=0;i<10;i++)
{
for(j=0;j<10;j++)
{
player1ShipGrid[i][j]=" - ";
player1ShootingGrid[i][j]=" - ";
player2ShipGrid[i][j]=" - ";
player2ShootingGrid[i][j]=" - ";
}
}
}
void displayPlayer1s()
{
char c='A';
System.out.println("PLAYER 1 SHIP GRID : ");
//                  | - | - | - | - | - | - | - | - | - | - | 
System.out.println("    1   2   3   4   5   6   7   8   9   10");
for(i=0;i<10;i++)
{
for(j=0;j<10;j++)
{
if(j==0)
{System.out.print(c+" |"+player1ShipGrid[i][j]);c=(char)(c+1);}
else if(j!=9)
System.out.print("|"+player1ShipGrid[i][j]);
else
System.out.print("|"+player1ShipGrid[i][j]+"|");
}
//                  | - | - | - | - | - | - | - | - | - | - | 
System.out.println("\n-----------------------------------------");
}}
void displayPlayer1ss(){char c='A';
System.out.println("PLAYER 1 SHOOTING GRID : ");
//                  | - | - | - | - | - | - | - | - | - | - | 
System.out.println("    1   2   3   4   5   6   7   8   9   10");
for(i=0;i<10;i++)
{
for(j=0;j<10;j++)
{
if(j==0)
{System.out.print(c+" |"+player1ShootingGrid[i][j]);c=(char)(c+1);}
else if(j!=9)
System.out.print("|"+player1ShootingGrid[i][j]);
else
System.out.print("|"+player1ShootingGrid[i][j]+"|");
}
//                  | - | - | - | - | - | - | - | - | - | - | 
System.out.println("\n-----------------------------------------");
}
}
void displayPlayer2s()
{char c='A';
System.out.println("PLAYER 2 SHIP GRID : ");
//                  | - | - | - | - | - | - | - | - | - | - | 
System.out.println("    1   2   3   4   5   6   7   8   9   10");
for(i=0;i<10;i++)
{
for(j=0;j<10;j++)
{
if(j==0)
{System.out.print(c+" |"+player2ShipGrid[i][j]);c=(char)(c+1);}
else if(j!=9)
System.out.print("|"+player2ShipGrid[i][j]);
else
System.out.print("|"+player2ShipGrid[i][j]+"|");
}
//                  | - | - | - | - | - | - | - | - | - | - | 
System.out.println("\n-----------------------------------------");
}}
void displayPlayer2ss(){char c='A';
System.out.println("PLAYER 2 SHOOTING GRID : ");
//                  | - | - | - | - | - | - | - | - | - | - | 
System.out.println("    1   2   3   4   5   6   7   8   9   10");
for(i=0;i<10;i++)
{
for(j=0;j<10;j++)
{
if(j==0)
{System.out.print(c+" |"+player2ShootingGrid[i][j]);c=(char)(c+1);}
else if(j!=9)
System.out.print("|"+player2ShootingGrid[i][j]);
else
System.out.print("|"+player2ShootingGrid[i][j]+"|");
}
//                  | - | - | - | - | - | - | - | - | - | - | 
System.out.println("\n-----------------------------------------");
}
}
void game()
{
String white=" O ",black=" "+(Character.toString('\u25CF'))+" ";
int counter=1,chance=1;String ro;int column=0,row=0;char b=' ',shipCounter1=0,shipCounter2=0;
int c1=0,b1=0,r1=0,m1=0,d1=0;
int c2=0,b2=0,r2=0,m2=0,d2=0;
//carrier battleship criuser submarine destroyer
boolean asd1=false,asd2=false;
makeboard();
try{
shipDestroyer : while(asd1==false && asd2==false)
{
if(counter%2==0)
chance=2;
else
chance=1;
switch(chance)
{
case 1:
if(counter==1)
{placeTheShipsPlayer1();System.out.print('\u000C');}
else
{
System.out.print('\u000C');
displayPlayer1ss();
System.out.print("NOW ENTER THE ALPHABET OF THE ROW : ");
ro=k.readLine();
ro=ro.toUpperCase();
while(ro.charAt(0)<'A' || ro.charAt(0)>'J')
{System.out.println("WRONG INPUT TRY AGAIN");
ro=k.readLine();
ro=ro.toUpperCase();
}
for(int l=65;l<=90;l++)
{
b=(char)l;
if(b==ro.charAt(0))
{
row=l-65;
}
}
System.out.println();
System.out.print("NOW ENTER THE NUMBER OF COLUMN : ");
column=Integer.parseInt(k.readLine())-1;
while((column+1)<1 || (column+1)>10)
{
System.out.println("WRONG INPUT TRY AGAIN!!");
column=Integer.parseInt(k.readLine())-1;
}
if(player2ShipGrid[row][column].equals(" C "))
{player2ShipGrid[row][column]="X";
System.out.println("YOU HIT A CARRIER!!!");
player1ShootingGrid[row][column]=black;
c1++;
if(c1==5)
{
shipCounter1++;
System.out.println("CARRIER DESTROYED!!!");
}
}
else
if(player2ShipGrid[row][column].equals(" M "))
{player2ShipGrid[row][column]="X";
System.out.println("YOU HIT A SUBAMARINE!!!");
player1ShootingGrid[row][column]=black;
m1++;
if(m1==3)
{
shipCounter1++;
System.out.println("SUBMARINE DESTROYED!!!");
}
}
else
if(player2ShipGrid[row][column].equals(" B "))
{player2ShipGrid[row][column]="X";
System.out.println("YOU HIT A BATTLESHIP!!!");
player1ShootingGrid[row][column]=black;
b1++;
if(b1==4)
{
shipCounter1++;
System.out.println("BATTLESHIP DESTROYED!!!");
}
}
else
if(player2ShipGrid[row][column].equals(" D "))
{player2ShipGrid[row][column]="X";
System.out.println("YOU HIT A DESTROYER!!!");
player1ShootingGrid[row][column]=black;
d1++;
if(d1==2)
{
shipCounter1++;
System.out.println("DESTROYER DESTROYED!!!");
}
}
else
if(player2ShipGrid[row][column].equals(" R "))
{player2ShipGrid[row][column]="X";
System.out.println("YOU HIT A CRUISER!!!");
player1ShootingGrid[row][column]=black;
r1++;
if(r1==3)
{
shipCounter1++;
System.out.println("CRUISER DESTROYED!!!");
}
}
else
{
player1ShootingGrid[row][column]=white;
System.out.println("IT IS A MISS!!!");
}}
if(shipCounter1==5)
asd1=true;
if(asd1==true && asd2==false)
{
System.out.print('\u000C');
System.out.println("PLAYER 2 WON THE BATTLESHIP MATCH!!\nYOU WON THE MATCH AND STILL HAVE "+(5-shipCounter2)+" SHIPS LEFT!!");
break shipDestroyer;
}
break;
case 2:
if(counter==2)
{placeTheShipsPlayer2();System.out.print('\u000C');}
else
{System.out.print('\u000C');displayPlayer2ss();
System.out.print("NOW ENTER THE ALPHABET OF THE ROW : ");
ro=k.readLine();
ro=ro.toUpperCase();
while(ro.charAt(0)<'A' || ro.charAt(0)>'J')
{System.out.println("WRONG INPUT TRY AGAIN");
ro=k.readLine();
ro=ro.toUpperCase();
}
for(int l=65;l<=90;l++)
{
b=(char)l;
if(b==ro.charAt(0))
{
row=l-65;
}
}
System.out.println();
System.out.print("NOW ENTER THE NUMBER OF COLUMN : ");
column=Integer.parseInt(k.readLine())-1;
while((column+1)<1 || (column+1)>10)
{
System.out.println("WRONG INPUT TRY AGAIN!!");
column=Integer.parseInt(k.readLine())-1;
}
if(player1ShipGrid[row][column].equals(" C "))
{player1ShipGrid[row][column]="X";
System.out.println("YOU HIT A CARRIER!!!");
player2ShootingGrid[row][column]=black;
c2++;
if(c2==5)
{
shipCounter2++;
System.out.println("CARRIER DESTROYED!!!");
}
}
else
if(player1ShipGrid[row][column].equals(" M "))
{player1ShipGrid[row][column]="X";
System.out.println("YOU HIT A SUBAMARINE!!!");
player2ShootingGrid[row][column]=black;
m2++;
if(m2==3)
{
shipCounter2++;
System.out.println("SUBMARINE DESTROYED!!!");
}
}
else
if(player1ShipGrid[row][column].equals(" B "))
{player1ShipGrid[row][column]="X";
System.out.println("YOU HIT A BATTLESHIP!!!");
player2ShootingGrid[row][column]=black;
b2++;
if(b2==4)
{
shipCounter2++;
System.out.println("BATTLESHIP DESTROYED!!!");
}
}
else
if(player1ShipGrid[row][column].equals(" D "))
{player1ShipGrid[row][column]="X";
System.out.println("YOU HIT A DESTROYER!!!");
player2ShootingGrid[row][column]=black;
d2++;
if(d2==2)
{
shipCounter2++;
System.out.println("DESTROYER DESTROYED!!!");
}
}
else
if(player1ShipGrid[row][column].equals(" R "))
{player1ShipGrid[row][column]="X";
System.out.println("YOU HIT A CRUISER!!!");
player2ShootingGrid[row][column]=black;
r2++;
if(r2==3)
{
shipCounter2++;
System.out.println("CRUISER DESTROYED!!!");
}
}
else
{player1ShootingGrid[row][column]=white;
System.out.println("IT IS A MISS!!");
}}
if(shipCounter2==5)
asd2=true;
if(asd2==true && asd1==false)
{
System.out.print('\u000C');
System.out.println("PLAYER 1 WON THE BATTLESHIP MATCH!!\nYOU WON THE MATCH AND STILL HAVE "+(5-shipCounter1)+" SHIPS LEFT!!");
break shipDestroyer;
}
break;}
counter++;
}}
catch(Exception e)
{
System.err.println(e);
}}
void carrier(int e,int l,int chan,char choice)
{
if(choice=='H')
{l+=1;
//assuming l1<l2
if(chan==1)
{
player1ShipGrid[e][l-1]=" C ";
player1ShipGrid[e][l]=" C ";
player1ShipGrid[e][l+1]=" C ";
player1ShipGrid[e][l+2]=" C ";
player1ShipGrid[e][l+3]=" C ";
}
else if(chan==2)
{
player2ShipGrid[e][l-1]=" C ";
player2ShipGrid[e][l]=" C ";
player2ShipGrid[e][l+1]=" C ";
player2ShipGrid[e][l+2]=" C ";
player2ShipGrid[e][l+3]=" C ";
}
}
else if(choice=='V')
{e=e+1;
if(chan==1)
{
player1ShipGrid[e-1][l]=" C ";
player1ShipGrid[e][l]=" C ";
player1ShipGrid[e+1][l]=" C ";
player1ShipGrid[e+2][l]=" C ";
player1ShipGrid[e+3][l]=" C ";
}
else if(chan==2)
{
player2ShipGrid[e-1][l]=" C ";
player2ShipGrid[e][l]=" C ";
player2ShipGrid[e+1][l]=" C ";
player2ShipGrid[e+2][l]=" C ";
player2ShipGrid[e+3][l]=" C ";
}
}
}
void submarine(int e,int l,int chan,char choice)
{
if(choice=='H')
{l+=1;
//assuming l1<l2
if(chan==1)
{
player1ShipGrid[e][l-1]=" M ";
player1ShipGrid[e][l]=" M ";
player1ShipGrid[e][l+1]=" M ";
}
else if(chan==2)
{
player2ShipGrid[e][l-1]=" M ";
player2ShipGrid[e][l]=" M ";
player2ShipGrid[e][l+1]=" M ";
}
}
else if(choice=='V')
{e+=1;
if(chan==1)
{
player1ShipGrid[e-1][l]=" M ";
player1ShipGrid[e][l]=" M ";
player1ShipGrid[e+1][l]=" M ";
}
else if(chan==2)
{
player2ShipGrid[e-1][l]=" M ";
player2ShipGrid[e][l]=" M ";
player2ShipGrid[e+1][l]=" M ";
}
}
}
void cruiser(int e,int l,int chan,char choice)
{
if(choice=='H')
{l+=1;
//assuming l1<l2
if(chan==1)
{
player1ShipGrid[e][l-1]=" R ";
player1ShipGrid[e][l]=" R ";
player1ShipGrid[e][l+1]=" R ";
}
else if(chan==2)
{
player2ShipGrid[e][l-1]=" R ";
player2ShipGrid[e][l]=" R ";
player2ShipGrid[e][l+1]=" R ";
}
}
else if(choice=='V')
{e=e+1;
if(chan==1)
{
player1ShipGrid[e-1][l]=" R ";
player1ShipGrid[e][l]=" R ";
player1ShipGrid[e+1][l]=" R ";
}
else if(chan==2)
{
player2ShipGrid[e-1][l]=" R ";
player2ShipGrid[e][l]=" R ";
player2ShipGrid[e+1][l]=" R ";
}
}
}
void battleship(int e,int l,int chan,char choice)
{
if(choice=='H')
{l+=1;
//assuming l1<l2
if(chan==1)
{
player1ShipGrid[e][l-1]=" B ";
player1ShipGrid[e][l]=" B ";
player1ShipGrid[e][l+1]=" B ";
player1ShipGrid[e][l+2]=" B ";
}
else if(chan==2)
{
player2ShipGrid[e][l-1]=" B ";
player2ShipGrid[e][l]=" B ";
player2ShipGrid[e][l+1]=" B ";
player2ShipGrid[e][l+2]=" B ";
}
}
else if(choice=='V')
{e=e+1;
if(chan==1)
{
player1ShipGrid[e-1][l]=" B ";
player1ShipGrid[e][l]=" B ";
player1ShipGrid[e+1][l]=" B ";
player1ShipGrid[e+2][l]=" B ";
}
else if(chan==2)
{
player2ShipGrid[e-1][l]=" B ";
player2ShipGrid[e][l]=" B ";
player2ShipGrid[e+1][l]=" B ";
player2ShipGrid[e+2][l]=" B ";
}
}
}
void destroyer(int e,int l,int chan,char choice)
{
if(choice=='H')
{l+=1;
//assuming l1<l2
if(chan==1)
{
player1ShipGrid[e][l-1]=" D ";
player1ShipGrid[e][l]=" D ";
}
else if(chan==2)
{
player2ShipGrid[e][l-1]=" D ";
player2ShipGrid[e][l]=" D ";
}
}
else if(choice=='V')
{e=e+1;
if(chan==1)
{
player1ShipGrid[e-1][l]=" D ";
player1ShipGrid[e][l]=" D ";
}
else if(chan==2)
{
player2ShipGrid[e-1][l]=" D ";
player2ShipGrid[e][l]=" D ";
}
}
}
void placeTheShipsPlayer1()
{
String choice,row;int r=0,c=0;
try{
displayPlayer1s();
System.out.println("NOW PLACE THE SHIPS : ");
System.out.println("1.CARRIER \nTYPE 'v' FOR VERTICAL AND 'h' FOR HORIZONTAL PLACEMENT");
choice=k.readLine();
choice=choice.toUpperCase();
switch(choice.charAt(0))
{
case 'V':System.out.println("GIVE THE START OF THE SHIP (THE ALPHABET OF THE ROW)");
 row=k.readLine();
row=row.toUpperCase();
while(row.charAt(0)>='G')
{System.out.println("WRONG INPUT TRY AGAIN");
row=k.readLine();
}
System.out.println("NOW ENTER THE COLUMN");
c=Integer.parseInt(k.readLine());
while(c<=0 || c>10)
{
System.out.println("WRONG INPUT TRY AGAIN");
c=Integer.parseInt(k.readLine());
}
r=row.charAt(0)-65;
break;
case 'H':System.out.println("GIVE THE START OF THE SHIP (THE NUMBER OF THE COLUMN)");
    c=Integer.parseInt(k.readLine());
    while(c>6)
    {
    System.out.println("WRONG INPUT TRY AGAIN!!");
    c=Integer.parseInt(k.readLine());
    }
    System.out.println("NOW ENTER THE ALPHABET OF THE ROW!!");
    row=k.readLine();
    r=row.charAt(0)-65;
    while(r<=0 || r>10)
    {
    System.out.println("WRONG INPUT TRY AGAIN");
    row=k.readLine();
    r=row.charAt(0)-65;
    }
    break;
    default:System.out.println("SYSTEMS SHUTTING DOWN :-P");
    System.exit(0);
}
carrier(r,(c-1),1,choice.charAt(0));
System.out.print('\u000C');
displayPlayer1s();
System.out.println("NOW PLACE THE SHIPS : ");
System.out.println("2.BATTLESHIP \nTYPE 'v' FOR VERTICAL AND 'h' FOR HORIZONTAL PLACEMENT");
choice=k.readLine();
choice=choice.toUpperCase();
switch(choice.charAt(0))
{
case 'V':System.out.println("GIVE THE START OF THE SHIP (THE ALPHABET OF THE ROW)");
row=k.readLine();
row=row.toUpperCase();
while(row.charAt(0)>='H')
{System.out.println("WRONG INPUT TRY AGAIN");
row=k.readLine();
}
System.out.println("NOW ENTER THE COLUMN");
c=Integer.parseInt(k.readLine());
while(c<=0 || c>10)
{
System.out.println("WRONG INPUT TRY AGAIN");
c=Integer.parseInt(k.readLine());
}
r=row.charAt(0)-65;
break;
case 'H':System.out.println("GIVE THE START OF THE SHIP (THE NUMBER OF THE COLUMN)");
    c=Integer.parseInt(k.readLine());
    while(c>7)
    {
    System.out.println("WRONG INPUT TRY AGAIN!!");
    c=Integer.parseInt(k.readLine());
    }
    System.out.println("NOW ENTER THE ALPHABET OF THE ROW!!");
    row=k.readLine();
    r=row.charAt(0)-65;
    while(r<=0 || r>10)
    {
    System.out.println("WRONG INPUT TRY AGAIN");
    row=k.readLine();
    r=row.charAt(0)-65;
    }
    break;
    default:System.out.println("SYSTEMS SHUTTING DOWN :-P");
    System.exit(0);
}
battleship(r,(c-1),1,choice.charAt(0));
System.out.print('\u000C');
displayPlayer1s();
System.out.println("NOW PLACE THE SHIPS : ");
System.out.println("3.CRUISER \nTYPE 'v' FOR VERTICAL AND 'h' FOR HORIZONTAL PLACEMENT");
choice=k.readLine();
choice=choice.toUpperCase();
switch(choice.charAt(0))
{
case 'V':System.out.println("GIVE THE START OF THE SHIP (THE ALPHABET OF THE ROW)");
row=k.readLine();
row=row.toUpperCase();
while(row.charAt(0)>='I')
{System.out.println("WRONG INPUT TRY AGAIN");
row=k.readLine();
}
System.out.println("NOW ENTER THE COLUMN");
c=Integer.parseInt(k.readLine());
while(c<=0 || c>10)
{
System.out.println("WRONG INPUT TRY AGAIN");
c=Integer.parseInt(k.readLine());
}
r=row.charAt(0)-65;
break;
case 'H':System.out.println("GIVE THE START OF THE SHIP (THE NUMBER OF THE COLUMN)");
    c=Integer.parseInt(k.readLine());
    while(c>8)
    {
    System.out.println("WRONG INPUT TRY AGAIN!!");
    c=Integer.parseInt(k.readLine());
    }
    System.out.println("NOW ENTER THE ALPHABET OF THE ROW!!");
    row=k.readLine();
    r=row.charAt(0)-65;
    while(r<=0 || r>10)
    {
    System.out.println("WRONG INPUT TRY AGAIN");
    row=k.readLine();
    r=row.charAt(0)-65;
    }
    break;
    default:System.out.println("SYSTEMS SHUTTING DOWN :-P");
    System.exit(0);
}
cruiser(r,(c-1),1,choice.charAt(0));
System.out.print('\u000C');
displayPlayer1s();
System.out.println("NOW PLACE THE SHIPS : ");
System.out.println("4.SUBMARINE \nTYPE 'v' FOR VERTICAL AND 'h' FOR HORIZONTAL PLACEMENT");
choice=k.readLine();
choice=choice.toUpperCase();
switch(choice.charAt(0))
{
case 'V':System.out.println("GIVE THE START OF THE SHIP (THE ALPHABET OF THE ROW)");
row=k.readLine();
row=row.toUpperCase();
while(row.charAt(0)>='I')
{System.out.println("WRONG INPUT TRY AGAIN");
row=k.readLine();
}
System.out.println("NOW ENTER THE COLUMN");
c=Integer.parseInt(k.readLine());
while(c<=0 || c>10)
{
System.out.println("WRONG INPUT TRY AGAIN");
c=Integer.parseInt(k.readLine());
}
r=row.charAt(0)-65;
break;
case 'H':System.out.println("GIVE THE START OF THE SHIP (THE NUMBER OF THE COLUMN)");
    c=Integer.parseInt(k.readLine());
    while(c>8)
    {
    System.out.println("WRONG INPUT TRY AGAIN!!");
    c=Integer.parseInt(k.readLine());
    }
    System.out.println("NOW ENTER THE ALPHABET OF THE ROW!!");
    row=k.readLine();
    r=row.charAt(0)-65;
    while(r<=0 || r>10)
    {
    System.out.println("WRONG INPUT TRY AGAIN");
    row=k.readLine();
    r=row.charAt(0)-65;
    }
    break;
    default:System.out.println("SYSTEMS SHUTTING DOWN :-P");
    System.exit(0);
}
submarine(r,(c-1),1,choice.charAt(0));
System.out.print('\u000C');
displayPlayer1s();
System.out.println("NOW PLACE THE SHIPS : ");
System.out.println("5.DESTROYER \nTYPE 'v' FOR VERTICAL AND 'h' FOR HORIZONTAL PLACEMENT");
choice=k.readLine();
choice=choice.toUpperCase();
switch(choice.charAt(0))
{
case 'V':System.out.println("GIVE THE START OF THE SHIP (THE ALPHABET OF THE ROW)");
row=k.readLine();
row=row.toUpperCase();
while(row.charAt(0)=='J')
{System.out.println("WRONG INPUT TRY AGAIN");
row=k.readLine();
}
System.out.println("NOW ENTER THE COLUMN");
c=Integer.parseInt(k.readLine());
while(c<=0 || c>10)
{
System.out.println("WRONG INPUT TRY AGAIN");
c=Integer.parseInt(k.readLine());
}
r=row.charAt(0)-65;
break;
case 'H':System.out.println("GIVE THE START OF THE SHIP (THE NUMBER OF THE COLUMN)");
    c=Integer.parseInt(k.readLine());
    while(c==10)
    {
    System.out.println("WRONG INPUT TRY AGAIN!!");
    c=Integer.parseInt(k.readLine());
    }
    System.out.println("NOW ENTER THE ALPHABET OF THE ROW!!");
    row=k.readLine();
    r=row.charAt(0)-65;
    while(r<=0 || r>10)
    {
    System.out.println("WRONG INPUT TRY AGAIN");
    row=k.readLine();
    r=row.charAt(0)-65;
    }
    break;
    default:System.out.println("SYSTEMS SHUTTING DOWN :-P");
    System.exit(0);
}
destroyer(r,(c-1),1,choice.charAt(0));
}
catch(Exception e)
{System.err.println(e);}
}
void placeTheShipsPlayer2()
{
String choice,row;int r=0,c=0;
try{
displayPlayer2s();
System.out.println("NOW PLACE THE SHIPS : ");
System.out.println("1.CARRIER \nTYPE 'v' FOR VERTICAL AND 'h' FOR HORIZONTAL PLACEMENT");
choice=k.readLine();
choice=choice.toUpperCase();
switch(choice.charAt(0))
{
case 'V':System.out.println("GIVE THE START OF THE SHIP (THE ALPHABET OF THE ROW)");
row=k.readLine();
row=row.toUpperCase();
while(row.charAt(0)>='G')
{System.out.println("WRONG INPUT TRY AGAIN");
row=k.readLine();
}
System.out.println("NOW ENTER THE COLUMN");
c=Integer.parseInt(k.readLine());
while(c<=0 || c>10)
{
System.out.println("WRONG INPUT TRY AGAIN");
c=Integer.parseInt(k.readLine());
}
r=row.charAt(0)-65;
break;
case 'H':System.out.println("GIVE THE START OF THE SHIP (THE NUMBER OF THE COLUMN)");
    c=Integer.parseInt(k.readLine());
    while(c>6)
    {
    System.out.println("WRONG INPUT TRY AGAIN!!");
    c=Integer.parseInt(k.readLine());
    }
    System.out.println("NOW ENTER THE ALPHABET OF THE ROW!!");
    row=k.readLine();
    r=row.charAt(0)-65;
    while(r<=0 || r>10)
    {
    System.out.println("WRONG INPUT TRY AGAIN");
    row=k.readLine();
    r=row.charAt(0)-65;
    }
    break;
    default:System.out.println("SYSTEMS SHUTTING DOWN :-P");
    System.exit(0);
}
carrier(r,(c-1),2,choice.charAt(0));
System.out.print('\u000C');
displayPlayer2s();
System.out.println("NOW PLACE THE SHIPS : ");
System.out.println("2.BATTLESHIP \nTYPE 'v' FOR VERTICAL AND 'h' FOR HORIZONTAL PLACEMENT");
choice=k.readLine();
choice=choice.toUpperCase();
switch(choice.charAt(0))
{
case 'V':System.out.println("GIVE THE START OF THE SHIP (THE ALPHABET OF THE ROW)");
row=k.readLine();
row=row.toUpperCase();
while(row.charAt(0)>='H')
{System.out.println("WRONG INPUT TRY AGAIN");
row=k.readLine();
}
System.out.println("NOW ENTER THE COLUMN");
c=Integer.parseInt(k.readLine());
while(c<=0 || c>10)
{
System.out.println("WRONG INPUT TRY AGAIN");
c=Integer.parseInt(k.readLine());
}
r=row.charAt(0)-65;
break;
case 'H':System.out.println("GIVE THE START OF THE SHIP (THE NUMBER OF THE COLUMN)");
    c=Integer.parseInt(k.readLine());
    while(c>7)
    {
    System.out.println("WRONG INPUT TRY AGAIN!!");
    c=Integer.parseInt(k.readLine());
    }
    System.out.println("NOW ENTER THE ALPHABET OF THE ROW!!");
    row=k.readLine();
    r=row.charAt(0)-65;
    while(r<=0 || r>10)
    {
    System.out.println("WRONG INPUT TRY AGAIN");
    row=k.readLine();
    r=row.charAt(0)-65;
    }
    break;
    default:System.out.println("SYSTEMS SHUTTING DOWN :-P");
    System.exit(0);
}
battleship(r,(c-1),2,choice.charAt(0));
System.out.print('\u000C');
displayPlayer2s();
System.out.println("NOW PLACE THE SHIPS : ");
System.out.println("3.CRUISER \nTYPE 'v' FOR VERTICAL AND 'h' FOR HORIZONTAL PLACEMENT");
choice=k.readLine();
choice=choice.toUpperCase();
switch(choice.charAt(0))
{
case 'V':System.out.println("GIVE THE START OF THE SHIP (THE ALPHABET OF THE ROW)");
row=k.readLine();
row=row.toUpperCase();
while(row.charAt(0)>='I')
{System.out.println("WRONG INPUT TRY AGAIN");
row=k.readLine();
}
System.out.println("NOW ENTER THE COLUMN");
c=Integer.parseInt(k.readLine());
while(c<=0 || c>10)
{
System.out.println("WRONG INPUT TRY AGAIN");
c=Integer.parseInt(k.readLine());
}
r=row.charAt(0)-65;
break;
case 'H':System.out.println("GIVE THE START OF THE SHIP (THE NUMBER OF THE COLUMN)");
    c=Integer.parseInt(k.readLine());
    while(c>8)
    {
    System.out.println("WRONG INPUT TRY AGAIN!!");
    c=Integer.parseInt(k.readLine());
    }
    System.out.println("NOW ENTER THE ALPHABET OF THE ROW!!");
    row=k.readLine();
    r=row.charAt(0)-65;
    while(r<=0 || r>10)
    {
    System.out.println("WRONG INPUT TRY AGAIN");
    row=k.readLine();
    r=row.charAt(0)-65;
    }
    break;
    default:System.out.println("SYSTEMS SHUTTING DOWN :-P");
    System.exit(0);
}
cruiser(r,(c-1),2,choice.charAt(0));
System.out.print('\u000C');
displayPlayer2s();
System.out.println("NOW PLACE THE SHIPS : ");
System.out.println("4.SUBMARINE \nTYPE 'v' FOR VERTICAL AND 'h' FOR HORIZONTAL PLACEMENT");
choice=k.readLine();
choice=choice.toUpperCase();
switch(choice.charAt(0))
{
case 'V':System.out.println("GIVE THE START OF THE SHIP (THE ALPHABET OF THE ROW)");
row=k.readLine();
row=row.toUpperCase();
while(row.charAt(0)>='I')
{System.out.println("WRONG INPUT TRY AGAIN");
row=k.readLine();
}
System.out.println("NOW ENTER THE COLUMN");
c=Integer.parseInt(k.readLine());
while(c<=0 || c>10)
{
System.out.println("WRONG INPUT TRY AGAIN");
c=Integer.parseInt(k.readLine());
}
r=row.charAt(0)-65;
break;
case 'H':System.out.println("GIVE THE START OF THE SHIP (THE NUMBER OF THE COLUMN)");
    c=Integer.parseInt(k.readLine());
    while(c>8)
    {
    System.out.println("WRONG INPUT TRY AGAIN!!");
    c=Integer.parseInt(k.readLine());
    }
    System.out.println("NOW ENTER THE ALPHABET OF THE ROW!!");
    row=k.readLine();
    r=row.charAt(0)-65;
    while(r<=0 || r>10)
    {
    System.out.println("WRONG INPUT TRY AGAIN");
    row=k.readLine();
    r=row.charAt(0)-65;
    }
    break;
    default:System.out.println("SYSTEMS SHUTTING DOWN :-P");
    System.exit(0);
}
submarine(r,(c-1),2,choice.charAt(0));
System.out.print('\u000C');
displayPlayer2s();
System.out.println("NOW PLACE THE SHIPS : ");
System.out.println("5.DESTROYER \nTYPE 'v' FOR VERTICAL AND 'h' FOR HORIZONTAL PLACEMENT");
choice=k.readLine();
choice=choice.toUpperCase();
switch(choice.charAt(0))
{
case 'V':System.out.println("GIVE THE START OF THE SHIP (THE ALPHABET OF THE ROW)");
row=k.readLine();
row=row.toUpperCase();
while(row.charAt(0)=='J')
{System.out.println("WRONG INPUT TRY AGAIN");
row=k.readLine();
}
System.out.println("NOW ENTER THE COLUMN");
c=Integer.parseInt(k.readLine());
while(c<=0 || c>10)
{
System.out.println("WRONG INPUT TRY AGAIN");
c=Integer.parseInt(k.readLine());
}
r=row.charAt(0)-65;
break;
case 'H':System.out.println("GIVE THE START OF THE SHIP (THE NUMBER OF THE COLUMN)");
    c=Integer.parseInt(k.readLine());
    while(c==10)
    {
    System.out.println("WRONG INPUT TRY AGAIN!!");
    c=Integer.parseInt(k.readLine());
    }
    System.out.println("NOW ENTER THE ALPHABET OF THE ROW!!");
    row=k.readLine();
    r=row.charAt(0)-65;
    while(r<=0 || r>10)
    {
    System.out.println("WRONG INPUT TRY AGAIN");
    row=k.readLine();
    r=row.charAt(0)-65;
    }
    break;
    default:System.out.println("SYSTEMS SHUTTING DOWN :-P");
    System.exit(0);
}
destroyer(r,(c-1),2,choice.charAt(0));
}
catch(Exception e)
{System.err.println(e);}
}
}