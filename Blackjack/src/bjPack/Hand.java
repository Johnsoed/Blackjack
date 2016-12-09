package bjPack;

import java.util.*;

/*****************************************************************
 * Hand class Holds and allows manipulation of array of card 
 * Objects, the player's hand of cards while playing the game.
 * @author  Edward Johnson, Anthony Dowling, Logan Crowe
 * @version December 8th, 2016
*****************************************************************/
public class Hand {
	/** list of cards. */
	private List<Card> ihand;

	/** constructor for hand when given no paramters.*/ 
	public Hand() {
		super();
		ihand = new ArrayList<Card>();
	}
	
	/** constructor for hand, sets hand to cardlist in parameter.
	 *  @param hand handlist to set as hand
	 */ 
	public Hand(List<Card> hand) {
		super();
		ihand = new ArrayList<Card>();
		ihand = hand;
	}

	/** method to insert a new card into card.
	 * Has else statement in case hand get too full
	 * 
	 * @param input the card to be added
	 */
	public void AddtoHand(Card input) {
		if (ihand.size() < 8) {
			ihand.add(input);
		} else {
			DiscardHand();
		}
	}

	/** method to discard hand. */
	public void DiscardHand() {
		ihand = new ArrayList<Card>();
	}

	/*************************************************************************
	 * 
	 * handCount takes a hand, iterates through the cards in the hand, and
	 * counts the values of the cards, adding them, returning the hand count.
	 * 
	 *            the hand you wish to count
	 * @return handCount int representing the hands value
	 *************************************************************************/
	int handCount() {
		int count = 0;
		for (Card card : ihand) {
			switch (card.rank()) {
			case TWO:
				count += 2;
				break;
			case THREE:
				count += 3;
				break;
			case FOUR:
				count += 4;
				break;
			case FIVE:
				count += 5;
				break;
			case SIX:
				count += 6;
				break;
			case SEVEN:
				count += 7;
				break;
			case EIGHT:
				count += 8;
				break;
			case NINE:
				count += 9;
				break;
			case TEN:
				count += 10;
				break;
			case JACK:
				count += 10;
				break;
			case QUEEN:
				count += 10;
				break;
			case KING:
				count += 10;
				break;
			case ACE:
				count += 11;
				break;
			}
		}
		if (hasAce() == true && count > 21) {
			count -= 10;
		}
		return count;
	}

	/************************************************************************
	 * hasAce() checks a hand for an Ace value and returns true if found.
	 * 
	 * @return boolean true if Ace Card() is found in hand
	 ************************************************************************/
	public boolean hasAce() {
		boolean bool = false;
		for (Card card : ihand) {
			switch (card.rank()) {
			case ACE:
				bool = true;
				break;
			default:
				break;
			}
		}
		return bool;
	}
	
	/** returns ihand list of cards. 
	 * 
	 * @return ihand returns hand list 
	 */
	public List<Card> getihand() {
		return ihand;
	}

}
