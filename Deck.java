package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Random;

/*The Deck class is meant to encapsulate a blackjack.Card Deck.
 *To this end, most of the operations can be found in ArrayList, so Deck should be implemented as a subclass since a deck is a list
 *On the side: one thing I love about Java is that you don't need to put the base functions first. You can put them in any order,
 *and the JVM will find them come run time
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
	
	/*
	 *I had to figure out how to use lambda expressions to make fill() and sort() work. So I don't forget what I did, I'll put
	 *my notes in the comments*/
	public void fill()
	{
		//iterate over enumerations to add new blackjack.Cards to the deck
		EnumSet.range( blackjack.Card.Rank.NUM01,blackjack.Card.Rank.KING ).forEach( rank -> cardList.add( blackjack.Card.getHeart(rank) ) );
		/*The above code translates to "take every member in the range of enum members of the Rank enum from NUM01 to KING, and apply
		 *the forEach method with the indicated comparator.
		 *The lambda expression passed to forEach essentially states 'take rank from the EnumSet contructed by the range parameter and
		 *use it as the parameter to the getX function of the Card class'
		 */
		
		//and do it once for each suit
		EnumSet.range( blackjack.Card.Rank.NUM01,blackjack.Card.Rank.KING ).forEach( rank -> cardList.add( blackjack.Card.getClub(rank) ) );
		EnumSet.range( blackjack.Card.Rank.NUM01,blackjack.Card.Rank.KING ).forEach( rank -> cardList.add( blackjack.Card.getSpade(rank) ) );
		EnumSet.range( blackjack.Card.Rank.NUM01,blackjack.Card.Rank.KING ).forEach( rank -> cardList.add( blackjack.Card.getDiamond(rank) ) );
		
	}
	
	public void sort()
	{
		//sort by suits first
		Collections.sort( cardList, (a,b) -> (a.getSuit() != blackjack.Card.Suit.DEF && b.getSuit() != blackjack.Card.Suit.DEF)? a.getSuit().ordinal() - b.getSuit().ordinal() : 0 );
		/*The above lambda expression means take a and b as arguments and so long as a and b do not have the default suit as their
		 *suit enums, return the difference between a and b's ordinals as the appropriate comparator result. Otherwise, return 0*/
		
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
		//the lambda expression here is the same as above, except with the Rank enum instead of the Suit enum
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
