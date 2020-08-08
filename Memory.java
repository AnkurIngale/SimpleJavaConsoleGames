import java.util.*;
import java.io.*;

class Memory
{
    int n[]={0,0,0,0,0};
    int save[];
    int i,j;
    int foundPair[][];
    BufferedReader k;
    Random r;
    Scanner s;
    public Memory()
    {
        save=new int[10];
        foundPair=new int[10][10];
        s=new Scanner(System.in);
        k=new BufferedReader(new InputStreamReader(System.in));
        r = new Random();
       for(i=0;i<10;i++) 
       save[i]=-1;
       
       for(i=0;i<10;i++)
       for(j=0;j<10;j++)
       foundPair[i][j]=-1;
    }
    
    public void giveNumbers()
    {
        int rand=r.nextInt(9);
        
        int l[]={1,2,3,4,5,6,7,8,9};
        for(i=0;i<5;i++)
        {
        if(n[i]==0)
        {
        rand=r.nextInt(9);
        while(l[rand]==0)
        rand=r.nextInt(9);
        
        n[i]=l[rand];
        l[rand]=0;
    }
        }
    }
    
    public void giveFinal()
    {
        int r1=r.nextInt(10),r2=r.nextInt(10);
        int r3=r.nextInt(5);
        
        
        
        while(save[r1]!=-1 || save[r2]!=-1 || (r1==r2))
        {
        r1=r.nextInt(10);r2=r.nextInt(10);
        }
        
        while(n[r3]==-1)
        {
        r3=r.nextInt(5);
        }
        
        save[r1]=n[r3];
        save[r2]=n[r3];
        n[r3]=-1;
    }
    
    public void game()
    {int in,last=-1;String h;
        int flagger=0;
        giveNumbers();
        
        for(i=0;i<10;i++)
        {
        while(save[i]==-1)
        giveFinal();
        }
      
    try{
        while(!(finish()))
        {
            System.out.print('\u000C');
    for(i=0;i<10;i++)
    for(j=0;j<10;j++)
    {
    if(foundPair[i][j]!=-1)
    System.out.println("("+i+","+j+")=> "+foundPair[i][j]);
    }
    
    System.out.println("\nENTER A NUMBER FROM 0 TO 9");
    in=Integer.parseInt(k.readLine());
    
    System.out.println("\nVALUE AT "+in+" => "+save[in]);
    
    if(last!=-1)
    {
    if(save[in]==save[last])
    {
        
        for(i=0;i<10;i++)
        for(j=0;j<10;j++)
        {
        if(foundPair[i][j]==save[in])
        {
        flagger=1;
        }
        }
    if(flagger==1){
    System.out.println("ALREADY ENTERED!!");
    }
    else{
        System.out.println("YOU GOT THE PAIR!!!!");
    foundPair[in][last]=save[in];}
    flagger=0;
    }
    }
    System.out.println("PRESS ENTER!!");
    h=s.nextLine();
    last=in;
}}
    catch(Exception e){System.err.println(e);System.exit(0);}
    
    finally{
    greetings();
    }
    }
    
    public boolean finish()
    {
    int counter=0;
     for(i=0;i<10;i++)
       for(j=0;j<10;j++)
       {if(foundPair[i][j]!=-1) counter++;}
       
       return (counter==5)?true:false;
    }
    
    
    public void greetings()
    {
        System.out.print('\u000C');
     for(i=0;i<10;i++)
    for(j=0;j<10;j++)
    {
    if(foundPair[i][j]!=-1)
    System.out.println("("+i+","+j+")=> "+foundPair[i][j]);
    }
    
    System.out.println("\n\n\n\nHOPE U ENJOYED!!1\n   ===>> A PROJECT BY ANKUR INGALE!!!");
    }
    
    
    public static void main(String args[])
    {
        Memory p=new Memory();
        p.game();
    }
}
