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
	List<Card> deckList;
	
	/*********************************************************************
	 * Deck() creates an array of Card objects and shuffles them. 
	 *********************************************************************/
	public Deck() {
    	newDeck();
 		Collections.shuffle(deckList);
	}
	
	/*********************************************************************
	 * Deal() is used to deal a single card from the deck. The decks
	 * size is revalued to take into account the missing card. 
	 * @return Card a card from the deck. 
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
    			String s = ("" + suit);
    			String r = ("" + value);
    			s = ("" +s.charAt(0));
    			switch(value){
    			case TWO:
    				r = "2";
    				break;
    			case THREE:
    				r = "3";
    				break;
    			case FOUR:
    				r = "4";
    				break;
    			case FIVE:
    				r = "5";
    				break;
    			case SIX:
    				r = "6";
    				break;
    			case SEVEN:
    				r = "7";
    				break;
    			case EIGHT:
    				r = "8";
    				break;
    			case NINE:
    				r = "9";
    				break;
    			case TEN:
    				r = "10";
    				break;
    			case JACK:
    				r = "J";
    				break;
    			case QUEEN:
    				r = "Q";
    				break;
    			case KING:
    				r = "K";
    				break;
    			case ACE:
    				r = "A";
    				break;
    			}
    			deckList.add(new Card(value, suit,(""+s+r) ));
    		}
    	}
	}
	

}

