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
	
	public void shuffle() {
		Collections.shuffle(cardList);
	}
	
	public void fill()
	{
		EnumSet.range( blackjack.Card.Rank.NUM01,blackjack.Card.Rank.KING ).forEach( rank -> cardList.add( blackjack.Card.getHeart(rank) ) );
		
		EnumSet.range( blackjack.Card.Rank.NUM01,blackjack.Card.Rank.KING ).forEach( rank -> cardList.add( blackjack.Card.getClub(rank) ) );
		EnumSet.range( blackjack.Card.Rank.NUM01,blackjack.Card.Rank.KING ).forEach( rank -> cardList.add( blackjack.Card.getSpade(rank) ) );
		EnumSet.range( blackjack.Card.Rank.NUM01,blackjack.Card.Rank.KING ).forEach( rank -> cardList.add( blackjack.Card.getDiamond(rank) ) );
		
	}
	
	public void sort()
	{
		Collections.sort( cardList, (a,b) -> (a.getSuit() != blackjack.Card.Suit.DEF && b.getSuit() != blackjack.Card.Suit.DEF)? a.getSuit().ordinal() - b.getSuit().ordinal() : 0 );
		
		final int END_HEARTS = 13;
		final int END_CLUB = 26;
		final int END_SPADE = 39;
		final int END_DIAMOND = 52;
		
		Collections.sort( cardList.subList( 0,END_HEARTS ),  (a,b) -> (a.getRank() != blackjack.Card.Rank.DEF && b.getRank() != blackjack.Card.Rank.DEF)? a.getRank().ordinal() - b.getRank().ordinal() : 0);
		Collections.sort( cardList.subList( END_HEARTS,END_CLUB ),  (a,b) -> (a.getRank() != blackjack.Card.Rank.DEF && b.getRank() != blackjack.Card.Rank.DEF)? a.getRank().ordinal() - b.getRank().ordinal() : 0);
		Collections.sort( cardList.subList( END_CLUB,END_SPADE ),  (a,b) -> (a.getRank() != blackjack.Card.Rank.DEF && b.getRank() != blackjack.Card.Rank.DEF)? a.getRank().ordinal() - b.getRank().ordinal() : 0);
		Collections.sort( cardList.subList( END_SPADE,END_DIAMOND ),  (a,b) -> (a.getRank() != blackjack.Card.Rank.DEF && b.getRank() != blackjack.Card.Rank.DEF)? a.getRank().ordinal() - b.getRank().ordinal() : 0);
	}
	
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
