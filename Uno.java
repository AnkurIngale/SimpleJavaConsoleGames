import java.io.*;
import java.util.*;

class Uno
{
ArrayList cards;
ArrayList p1;
ArrayList p2;
ArrayList deck;
BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
/*
   (number)(color)
   (action)(color)
   WC D4
   */
  
  public Uno()
  {
    cards=new ArrayList();
    p1=new ArrayList();
    p2=new ArrayList();
    deck=new ArrayList();
    }
    
    public void allCards()
    {
    cards.add("0R");
    cards.add("1R");
    cards.add("2R");
    cards.add("3R");
    cards.add("4R");
    cards.add("5R");
    cards.add("6R");
    cards.add("7R");
    cards.add("8R");
    cards.add("9R");
    
    cards.add("0G");
    cards.add("1G");
    cards.add("2G");
    cards.add("3G");
    cards.add("4G");
    cards.add("5G");
    cards.add("6G");
    cards.add("7G");
    cards.add("8G");
    cards.add("9G");
    
    cards.add("0B");
    cards.add("1B");
    cards.add("2B");
    cards.add("3R");
    cards.add("4R");
    cards.add("5B");
    cards.add("6B");
    cards.add("7B");
    cards.add("8B");
    cards.add("9B");
    
    cards.add("0Y");
    cards.add("1Y");
    cards.add("2Y");
    cards.add("3Y");
    cards.add("4Y");
    cards.add("5Y");
    cards.add("6Y");
    cards.add("7Y");
    cards.add("8Y");
    cards.add("9Y");
    
    cards.add("SR");
    cards.add("SG");
    cards.add("SB");
    cards.add("SY");
    
    cards.add("DR");
    cards.add("DY");
    cards.add("DB");
    cards.add("DG");
    
    cards.add("WC");
    cards.add("WC");
    cards.add("D4");
    cards.add("D4");
}
    
    
    public void shuffleAndGive()
    {
    //cards initialization
    allCards();
    Random r=new Random();
    int j=r.nextInt(cards.size());
    for(int i=0;i<7;i++)
    {
    j=r.nextInt(cards.size());
    p1.add(cards.get(j));
    cards.remove(cards.get(j));
    }
    
    for(int i=0;i<7;i++)
    {
    j=r.nextInt(cards.size());
    p2.add(cards.get(j));
    cards.remove(cards.get(j));
    }
    
    String s="";
    j=r.nextInt(cards.size());
    s=cards.get(j).toString();
    while(s.charAt(0)=='W' || s.charAt(0)=='R' || s.charAt(0)=='S' || s.charAt(0)=='D')
    {
        j=r.nextInt(cards.size());
    s=cards.get(j).toString();
    }
    
    deck.add(cards.get(j));
    cards.remove(cards.get(j));
    }
    
    public boolean giveChance(boolean chance)
    {
    if((deck.get(deck.size()-1)).toString().charAt(0)=='S' || deck.get(deck.size()-1).toString().charAt(0)=='R')
    {
    return chance;
    }
    
    else return !chance;
}

    public boolean cardValid(boolean chance,String cardPlayed)
    {
        
        String c=deck.get(deck.size()-1).toString();
    if(chance)
    {
    if((p1.contains(cardPlayed)))
    {
    if(cardPlayed.equals("WC") || cardPlayed.equals("D4"))
    {
    return true;
    }
    else if(cardPlayed.charAt(0)==c.charAt(0) || cardPlayed.charAt(1)==c.charAt(1))
    {
    return true;
    }
    else return false;
    }
    else return false;
    }
    
    else
    {if((p2.contains(cardPlayed)))
    {
    if(cardPlayed.equals("WC") || cardPlayed.equals("D4"))
    {
    return true;
    }
    else if(cardPlayed.charAt(0)==c.charAt(0) || cardPlayed.charAt(1)==c.charAt(1))
    {
    return true;
    }
    else return false;
    }
    else return false;}
    }
    
    
    public void draw(boolean c){
    String d="";
    Random r=new Random();
    int j;
        if(c)
   {
    j=r.nextInt(cards.size());
    p1.add(cards.get(j));
    cards.remove(j);
    if(cards.isEmpty()){cardsEmpty();}
    }
    
    else{j=r.nextInt(cards.size());
    p2.add(cards.get(j));
    cards.remove(j);
    if(cards.isEmpty()){cardsEmpty();}}
    }
    
    public void cardsEmpty()
    {
    for(int i=0;i<deck.size()-1;i++)
    {
        if(deck.get(i).toString().charAt(0)==' ')
        {}
        else {cards.add(deck.get(i));deck.remove(deck.get(i));}
    }
    }
    
    public void action(boolean chance,String cardPlayed)
    {
    if(cardPlayed.equals("D4"))
    {
    draw(!chance);
    draw(!chance);
    draw(!chance);
    draw(!chance);
    
    String s;
    try{
    System.out.println("SELECT COLOR!!! (R,G,B,Y)");
    s=k.readLine().toUpperCase();
    putInTheDeck(cardPlayed,s);
    }catch(Exception e){System.err.println(e);System.exit(0);}
    }
    else if(cardPlayed.charAt(0)=='D')
    {
    draw(!chance);
    draw(!chance);
    putInTheDeck(cardPlayed,null);
    }
    
    else if(cardPlayed.charAt(0)=='W')
    {String s;
    try{
    System.out.println("SELECT COLOR!!! (R,G,B,Y)");
    s=k.readLine().toUpperCase();
    putInTheDeck(cardPlayed,s);
    }catch(Exception e){System.err.println(e);System.exit(0);}
    }
    else putInTheDeck(cardPlayed,null);
    }

    public void putInTheDeck(String cardPlayed,String color){
    if(cardPlayed.equals("WC") || cardPlayed.equals("D4"))
    {
    deck.add(" " + color.toUpperCase());
    }
    
    else deck.add(cardPlayed);
    }

    public void player1Chance()
    {
    String card="";
    try{
        
    System.out.println("DECK : "+deck.get(deck.size()-1)+"\n");    
    System.out.println("PLAYER 1 CHANCE :::: TOTAL CARDS : "+p1.size());
    System.out.println("\nTYPE IN A CARD FROM BOTTOM OR TYPE 'DRAW' TO DRAW A CARD!!");
    
    for(int i=0;i<p1.size();i++)
    {
    System.out.print(p1.get(i)+" ");
    }
    System.out.println("\n");
    card=k.readLine().toUpperCase();
    
    while(!(card.equals("DRAW")) && !cardValid(true,card))
    {
    System.out.println("ERROR!! ENTER AGAIN!!");
    card=k.readLine().toUpperCase();
    }
    
    if(!card.equals("DRAW"))
    {
    action(true,card);
    p1.remove(card);
    }
    else draw(true);
}
    catch(Exception e){System.err.println(e);System.exit(0);}
    }
    
    
    public void player2Chance()
{
   String card="";
    try{
        
    System.out.println("DECK : "+deck.get(deck.size()-1)+"\n");    
    System.out.println("PLAYER 2 CHANCE :::: TOTAL CARDS : "+p2.size());
    System.out.println("\nTYPE IN A CARD FROM BOTTOM OR TYPE 'DRAW' TO DRAW A CARD!!");
    
    for(int i=0;i<p2.size();i++)
    {
    System.out.print(p2.get(i)+" ");
    }
    System.out.println("\n");
    card=k.readLine().toUpperCase();
    
    while(!(card.equals("DRAW")) && !cardValid(false,card))
    {
    System.out.println("ERROR!! ENTER AGAIN!!");
    card=k.readLine().toUpperCase();
    }
    
    if(!card.equals("DRAW"))
    {
    action(false,card);
    p2.remove(card);
    }
    else draw(false);
}
    catch(Exception e){System.err.println(e);System.exit(0);}
 
}

public void game()
{
boolean chance=true,play=true;

while(play)
{
    System.out.print('\u000C');
    chance=giveChance(chance);
    
if(chance)
{
player1Chance();
takeEnter();
}
else {player2Chance();takeEnter();}


if(p1.isEmpty()){winner(true);play=false;}
else if(p2.isEmpty()){winner(false);play=false;}


}
}

public void winner(boolean c){
    System.out.print('\u000C');
System.out.println("PLAYER "+Integer.toString(c?1:2)+ " WON!!!!!!\n\nTHANK YOU FOR PLAYING!!\n   ==>> A PROJECT BY ANKUR INGALE");
}

public void takeEnter(){Scanner s=new Scanner(System.in);
System.out.println("PRESS ENTER!!");
String e=s.nextLine();
}

public static void main(String args[])
{
Uno patte=new Uno();
patte.shuffleAndGive();
patte.game();

}
}