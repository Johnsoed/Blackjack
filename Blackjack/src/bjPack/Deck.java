package bjPack;
import java.util.*;

import bjPack.Card.Rank;
import bjPack.Card.Suit;
public class Deck {
static List<Card> deckList = new ArrayList<Card>();
	
	public Deck (){
		int c = 0;
    	for(Suit suit: Suit.values()) {
    		for(Rank value: Rank.values()) {
    			deckList.add(new Card(value, suit));
    		}
    	}
 		Collections.shuffle(deckList);
	}

/***********************************************************************
* Returns card object, "moves" through deck using subList
**********************************************************************/	
	public Card deal(){
	int deckSize = deckList.size();
	Card dealtCard;
	dealtCard = deckList.get(0);
	deckList = deckList.subList(1, deckSize);
	return dealtCard;
}


}

