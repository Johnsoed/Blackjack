package bjPack;

import java.util.*;

public class Hand{
	
	List<Card> ihand;

	public Hand() {
		super();
		ihand = new ArrayList<Card>();
	}
	
	public Hand(List<Card> hand) {
		super();
		ihand = new ArrayList<Card>();
		ihand = hand;
	}

	public void AddtoHand(Card input){
		ihand.add(input);
	}
	
	public void DiscardHand(){
		ihand = new ArrayList<Card>();
	}
	
	/*************************************************************************
	*handCount() takes a hand, iterates through the cards in the hand, and 
	*counts the values of the cards, adding them and returning the hand count
	* @param hand the hand you wish to count
	* @return handCount int representing the hands value
	*************************************************************************/
	int handCount(){
		int count = 0;
		for(Card card :ihand){
			switch(card.rank()){
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
		if(hasAce()==true && count > 21)
			count -= 10;
		return count;
	}
	
	/************************************************************************
	 * hasAce() checks a hand for an Ace value and returns true if found
	 * @param hand the hand to be checked for an Ace
	 * @return boolean true if Ace Card() is found in hand
	 ************************************************************************/
	public boolean hasAce(){
		boolean bool = false;
			for(Card card :ihand){
				switch(card.rank()){
				case ACE:
					bool = true;
					break;
				default:
					break;
				}
			}
			return bool;
	}
	
	public Card getCard(int cardNum){
		if(ihand.size() >= cardNum + 1){
			return ihand.get(cardNum);
		}
		else{
			return null;
		}
	}
	
	public int size(){
		return ihand.size();
	}

//	@Override
//	public Iterator<Card> iterator() {
//		return null;
//	}
}
