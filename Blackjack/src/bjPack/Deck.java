/***************************************************************************
* Deck() - used to create a 'deck' of Card objects using an array. 
* @author Logan Crowe, Edward Johnson, Anthony Dowling
***************************************************************************/
package bjPack;
import java.io.IOException;
import java.util.*;
import bjPack.Card.Rank;
import bjPack.Card.Suit;
public class Deck {
	
	/*the Arraylist that holds the deck*/	
	List<Card> deckList;
	
	/*********************************************************************
	 * Deck() creates an array of Card objects and shuffles them. 
	 * @throws IOException 
	 *********************************************************************/
	public Deck(){
    	newDeck();
 		Collections.shuffle(deckList);
	}
	
	/*********************************************************************
	 * Deal() is used to deal a single card from the deck. The decks
	 * size is revalued to take into account the missing card. 
	 * @return Card a card from the deck. 
	 * @throws IOException 
	 *********************************************************************/
	public Card deal(){
		//safety. so we don't pull from empty deck
		if(deckCount() > 0){
			Card dealtCard;
			dealtCard = deckList.get(0);
			deckList = deckList.subList(1, deckCount());
			return dealtCard;
		}
		else{
			newDeck();
			Card dealtCard;
			dealtCard = deckList.get(0);
			deckList = deckList.subList(1, deckCount());
			return dealtCard;
		}
	}
	
	/*********************************************************************
	 * @return deckCount an int that represents the current size of the 
	 * deck.
	 *********************************************************************/
	public final int deckCount() {
		return deckList.size();
	}
	
	/*********************************************************************
	 * Shuffles the deck. 
	 *********************************************************************/
	public final void shuffleDeck(){
		Collections.shuffle(deckList);
	}
	
	public void newDeck(){
		deckList = new ArrayList<Card>();
		for ( Suit suit: Suit.values() ) {
    		for ( Rank value: Rank.values() ) {
    			deckList.add(new Card(value, suit));
    		}
    	}
	}

}

