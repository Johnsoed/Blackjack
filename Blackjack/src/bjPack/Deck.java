/***************************************************************************
* Deck() - used to create a 'deck' of Card objects using an array. 
* @author Logan Crowe, Edward Johnson, Anthony Dowling
***************************************************************************/
package bjPack;
import java.util.*;
import bjPack.Card.Rank;
import bjPack.Card.Suit;
public class Deck {
	
	/*the Arraylist that holds the deck*/	
	List<Card> deckList = new ArrayList<Card>();
	
	/*********************************************************************
	 * Deck() creates an array of Card objects and shuffles them. 
	 *********************************************************************/
	public Deck (){
    	for(Suit suit: Suit.values()) {
    		for(Rank value: Rank.values()) {
    			deckList.add(new Card(value, suit));
    		}
    	}
 		Collections.shuffle(deckList);
	}
	
	/*********************************************************************
	 * deal() is used to deal a single card from the deck. The decks
	 * size is revalued to take into account the missing card. 
	 * @return Card a card from the deck. 
	 *********************************************************************/
	public Card deal(){
		int deckSize = deckList.size();
		Card dealtCard;
		dealtCard = deckList.get(0);
		deckList = deckList.subList(1, deckSize);
		return dealtCard;
	}
	
	/*********************************************************************
	 * @return deckCount an int that represents the current size of the 
	 * deck.
	 *********************************************************************/
	public int deckCount(){
		return deckList.size();
	}
	
	/*********************************************************************
	 * Shuffles the deck. 
	 *********************************************************************/
	public void shuffleDeck(){
		Collections.shuffle(deckList);
	}


}

