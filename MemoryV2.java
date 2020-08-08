import java.util.*;
import java.io.*;
class MemoryV2
{
    
public static void main(String args[]) throws IOException
{
System.out.println("ENTER GRID SIZE::: (GIVE ONLY NUMBER OF ROWS OR COLUMNS AND ONLY EVEN MUMBER)");
BufferedReader k=new BufferedReader(new InputStreamReader(System.in));    
int grid=Integer.parseInt(k.readLine());
while (!(grid%2==0))
{
System.out.println("\nWRONG ENTRY!!!\nENTER AGAIN::");
grid=Integer.parseInt(k.readLine());
}    
MemoryV2 e=new MemoryV2(grid);
e.game(grid);
}

Scanner s;
Random r;
boolean flag[][];
String board[][];
int save[][];
int numbers[];
int foundPair[][];
int i,j;
int num;
public MemoryV2(int g)
{
s=new Scanner(System.in);
r=new Random();
num=(g*g)/2;
board=new String[g][g];
foundPair=new int[g][g];
numbers=new int[num];
flag=new boolean[g][g];
save=new int[g][g];
for(i=0;i<g;i++)
for(j=0;j<g;j++)
{board[i][j]="+";foundPair[i][j]=-1;flag[i][j]=false; save[i][j]=-1;}

for(i=0;i<(num);i++)
numbers[i]=-1;
}

public void display(int g)
{   
    System.out.print('\u000C');
    System.out.print("  ");
    for(i=0;i<g;i++)
    System.out.print(i+" ");
    System.out.println();
for(i=0;i<g;i++){
for(j=0;j<g;j++)
{
if(j==0)System.out.print(i+" "+board[i][j]);
else System.out.print(" "+board[i][j]);
}
System.out.println();
}
}

public void give()
{
int l[]={1,2,3,4,5,6,7,8,9};
for(i=0;i<(num);i++)
{
numbers[i]=l[r.nextInt(9)];
}
}

public void give2(int g)
{
   int r1=r.nextInt(g),r2=r.nextInt(g);
    int c1=r.nextInt(g),c2=r.nextInt(g);
        int r3=r.nextInt(num);
        
        
        
        while(save[r1][c1]!=-1 || save[r2][c2]!=-1 || ((r1==r2) && (c1==c2)))
        {
        r1=r.nextInt(g);r2=r.nextInt(g);
        c1=r.nextInt(g);c2=r.nextInt(g);
        }
        
        while(numbers[r3]==-1)
        {
        r3=r.nextInt(num);
        }
        
        save[r1][c1]=numbers[r3];
        save[r2][c2]=numbers[r3];
        numbers[r3]=-1;
}

public void game(int g)
{
give(); 
give2(g);
int row,col,lr=-1,lc=-1;
String h;
   
 for(i=0;i<g;i++)
 for(j=0;j<g;j++)
        {
        while(save[i][j]==-1)
        give2(g);
        }

try{
while(!(finished(g)))
{
display(g);

System.out.println("\nENTER ROW:::");
row=s.nextInt();
System.out.println("\nENTER COLUMN:::");
col=s.nextInt();

board[row][col]=its(save[row][col]);

if(lr!=-1 && lc!=-1)
{
if(!(flag[row][col] || flag[lr][lc]))
{
if(save[row][col]==save[lr][lc])
{
foundPair[row][col]=123;foundPair[lr][lc]=123;
flag[row][col]=true;flag[lr][lc]=true;
}else if(foundPair[lr][lc]==-1) board[lr][lc]="+";
}else System.out.println("ALREADY FOUND!!");
}
    





lr=row;lc=col;    
System.out.println("PRESS ENTER!!");
h=s.nextLine();
}
}
catch(Exception e){System.err.println(e);}
finally{
greetings(g);
}
}

public void greetings(int g)
{
display(g);    
System.out.println("\n\nHOPE U ENJOYED!!!\n   ==>> A PROJECT BY ANKUR INGALE!!");
}

public boolean finished(int g)
{
    int c=0;
for(i=0;i<g;i++)
for(j=0;j<g;j++)
{
if(foundPair[i][j]!=-1)
c++;
}

return (c==num*2)?true:false;
}

public int sti(String h)
{
return Integer.parseInt(h);
}

public String its(int h)
{
return Integer.toString(h);
}
}