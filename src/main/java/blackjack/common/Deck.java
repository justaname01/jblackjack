package blackjack.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class Deck
{
	private List<Card> cardList;
	
	public Deck()
	{
		cardList = new ArrayList<Card>();
	}
	
	public void shuffle() {
		Collections.shuffle(cardList);
	}
	
	public void fill()
	{
		EnumSet.range( Card.Rank.NUM01,Card.Rank.KING ).forEach( rank -> cardList.add( Card.getHeart(rank) ) );
		EnumSet.range( Card.Rank.NUM01,Card.Rank.KING ).forEach( rank -> cardList.add( Card.getClub(rank) ) );
		EnumSet.range( Card.Rank.NUM01,Card.Rank.KING ).forEach( rank -> cardList.add( Card.getSpade(rank) ) );
		EnumSet.range( Card.Rank.NUM01,Card.Rank.KING ).forEach( rank -> cardList.add( Card.getDiamond(rank) ) );
	}
	
	public void sort()
	{
		Collections.sort( cardList, (a,b) -> (a.getSuit() != Card.Suit.DEF && b.getSuit() != Card.Suit.DEF)? a.getSuit().ordinal() - b.getSuit().ordinal() : 0 );
		
		final int END_HEARTS = 13;
		final int END_CLUB = 26;
		final int END_SPADE = 39;
		final int END_DIAMOND = 52;
		
		Collections.sort( cardList.subList( 0,END_HEARTS ),  (a,b) -> (a.getRank() != Card.Rank.DEF && b.getRank() != Card.Rank.DEF)? a.getRank().ordinal() - b.getRank().ordinal() : 0);
		Collections.sort( cardList.subList( END_HEARTS,END_CLUB ),  (a,b) -> (a.getRank() != Card.Rank.DEF && b.getRank() != Card.Rank.DEF)? a.getRank().ordinal() - b.getRank().ordinal() : 0);
		Collections.sort( cardList.subList( END_CLUB,END_SPADE ),  (a,b) -> (a.getRank() != Card.Rank.DEF && b.getRank() != Card.Rank.DEF)? a.getRank().ordinal() - b.getRank().ordinal() : 0);
		Collections.sort( cardList.subList( END_SPADE,END_DIAMOND ),  (a,b) -> (a.getRank() != Card.Rank.DEF && b.getRank() != Card.Rank.DEF)? a.getRank().ordinal() - b.getRank().ordinal() : 0);
	}
	
	public Card draw()
	{
		Card ret = cardList.get(0);
		cardList.remove(0);
		return ret;
	}
	
	public String toString()
	{
		String ret = "";
		for(int ind = 0; ind < cardList.size(); ind++)
		{
			ret = ret + cardList.get(ind) + "\n";
		}
		return ret;
	}
}
