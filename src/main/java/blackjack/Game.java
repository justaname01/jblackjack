package blackjack;

import blackjack.common.Deck;
import java.util.List;

public class Game
{
	public static void main(String args[])
	{
		Deck d = new Deck();
		d.fill();
		
		System.out.println(d.toString());
		
		System.out.println("\n\n\n\n");
		d.shuffle();
		
		System.out.println(d.toString());
		
		System.out.println("\n\n\n\n");
		d.sort();
		
		System.out.println(d.toString());
	}
	
	
}