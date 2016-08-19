package blackjack;

import java.util.Scanner;

public class Game
{
	public static void main(String args[])
	{
		
	}
	
	public static char menu()
	{
		
	}
	
	//in Java, a static method cannot call an object method, but it can call another static method
	public static void prettyPrintDeck(java.util.ArrayList<Card> deck)
	{
		for(int ind = 0; ind < deck.size(); ind++)
			System.out.println(deck.get(ind));
	}
}
