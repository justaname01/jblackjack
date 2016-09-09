package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Random;

/*The Deck class is meant to encapsulate a blackjack.Card Deck.
 *To this end, most of the operations can be found in ArrayList, so Deck should be implemented as a subclass since a deck is a list
 */
public class Deck
{
	private ArrayList<Card> cardList;
	public Deck()
	{
		cardList = new ArrayList<Card>();
	}
	
	//The only additional operations needed are below
	
	//I believe the algorithm I'm using is Fisher-Yeats. I may be wrong, however.
	public void shuffle()
	{
		Random gen = new Random(System.currentTimeMillis());
		
		for(int ind = cardList.size()-1; ind > 0; ind-- )
		{
			//Random's nextInt() method will return an integer between 0, inclusive, and the bound, exclusive
			//the swap() method in Collections takes an implementation of List and two indices
			Collections.swap( cardList, gen.nextInt(ind), ind );
		}
	}
	
	public void fill()
	{
		//iterate over enumerations to add new blackjack.Cards to the deck
		EnumSet.range( blackjack.Card.Rank.NUM01,blackjack.Card.Rank.KING ).forEach( rank -> cardList.add( blackjack.Card.getHeart(rank) ) );
		
		//and do it once for each suit
		EnumSet.range( blackjack.Card.Rank.NUM01,blackjack.Card.Rank.KING ).forEach( rank -> cardList.add( blackjack.Card.getClub(rank) ) );
		EnumSet.range( blackjack.Card.Rank.NUM01,blackjack.Card.Rank.KING ).forEach( rank -> cardList.add( blackjack.Card.getSpade(rank) ) );
		EnumSet.range( blackjack.Card.Rank.NUM01,blackjack.Card.Rank.KING ).forEach( rank -> cardList.add( blackjack.Card.getDiamond(rank) ) );
		
	}
	
	public void sort()
	{
		//sort by suits first
		Collections.sort( cardList, (a,b) -> (a.getSuit() != blackjack.Card.Suit.DEF && b.getSuit() != blackjack.Card.Suit.DEF)? a.getSuit().ordinal() - b.getSuit().ordinal() : 0 );
		
		//the reason these aren't zero-based is because subList excludes the toIndex parameter from the sublist returned
		final int END_HEARTS = 13;
		final int END_CLUB = 26;
		final int END_SPADE = 39;
		final int END_DIAMOND = 52;
		//then by ranks
		Collections.sort( cardList.subList( 0,END_HEARTS ),  (a,b) -> (a.getRank() != blackjack.Card.Rank.DEF && b.getRank() != blackjack.Card.Rank.DEF)? a.getRank().ordinal() - b.getRank().ordinal() : 0);
		Collections.sort( cardList.subList( END_HEARTS,END_CLUB ),  (a,b) -> (a.getRank() != blackjack.Card.Rank.DEF && b.getRank() != blackjack.Card.Rank.DEF)? a.getRank().ordinal() - b.getRank().ordinal() : 0);
		Collections.sort( cardList.subList( END_CLUB,END_SPADE ),  (a,b) -> (a.getRank() != blackjack.Card.Rank.DEF && b.getRank() != blackjack.Card.Rank.DEF)? a.getRank().ordinal() - b.getRank().ordinal() : 0);
		Collections.sort( cardList.subList( END_SPADE,END_DIAMOND ),  (a,b) -> (a.getRank() != blackjack.Card.Rank.DEF && b.getRank() != blackjack.Card.Rank.DEF)? a.getRank().ordinal() - b.getRank().ordinal() : 0);
	}
	
	//draw is a specialized method for removing a blackjack.Card from the deck. So not only does it need to retrieve the first blackjack.Card, it also needs to remove it.
	public blackjack.Card draw()
	{
		blackjack.Card ret = cardList.get(0);
		cardList.remove(0);
		return ret;
	}
	
	public ArrayList<Card> getDeck()
	{
		return cardList;
	}
}