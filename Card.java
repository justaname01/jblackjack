package blackjack;

public class Card
{
	 enum Rank
	{
		DEF,NUM01,NUM02,NUM03,NUM04,NUM05,NUM06,NUM07,NUM08,NUM09,ACE,JACK,QUEEN,KING
	}
	 enum Suit
	{
		DEF,HEART,CLUB,SPADE,DIAMOND
	}
	
	Rank rank;
	Suit suit;
	
	private Card()
	{
		rank = Rank.DEF;
		suit = Suit.DEF;
	}
	
	private Card(Suit s,Rank r)
	{
		rank = r;
		suit = s;
	}
	
	public Rank getRank()
	{
		return rank;
	}
	public Suit getSuit()
	{
		return suit;
	}
	
	public static Card getHeart(Rank r)
	{
		return new Card(Suit.HEART,r);
	}
	public static Card getClub(Rank r)
	{
		return new Card(Suit.CLUB,r);
	}
	public static Card getSpade(Rank r)
	{
		return new Card(Suit.SPADE,r);
	}
	public static Card getDiamond(Rank r)
	{
		return new Card(Suit.DIAMOND,r);
	}
	
	public String toString()
	{
		String ret = "A ";
		switch(rank)
		{
			case NUM01:
			case NUM02:
			case NUM03:
			case NUM04:
			case NUM05:
			case NUM06:
			case NUM07:
			case NUM08:
			case NUM09:
				ret = ret + String.valueOf( rank.ordinal() ) + " of ";
				break;
			case ACE:
				ret = "An Ace of ";
				break;
			case JACK:
				ret = ret + "Jack of ";
				break;
			case QUEEN:
				ret = ret + "Queen of ";
				break;
			case KING:
				ret = ret + "King of ";
				break;
		}
		
		switch(suit)
		{
			case HEART:
				ret = ret + "Hearts";
				break;
			case CLUB:
				ret = ret + "Clubs";
				break;
			case SPADE:
				ret = ret + "Spades";
				break;
			case DIAMOND:
				ret = ret + "Diamonds";
				break;
		}
		return ret;
	}
}