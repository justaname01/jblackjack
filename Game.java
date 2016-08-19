package blackjack;

public class Game
{
	public static void main(String args[])
	{
		Deck d = new Deck();
		d.fill();
		
		prettyPrintDeck(d.getDeck());
		
		System.out.println("\n\n\n\n");
		d.shuffle();
		
		prettyPrintDeck(d.getDeck());
		
		System.out.println("\n\n\n\n");
		d.sort();
		
		prettyPrintDeck(d.getDeck());
	}
	
	public static void prettyPrintDeck(java.util.ArrayList<Card> deck)
	{
		for(int ind = 0; ind < deck.size(); ind++)
			System.out.println(deck.get(ind));
	}
}