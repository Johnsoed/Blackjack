package bjPack;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public Game() {
		super();
		Deck mainDeck = new Deck();
		Hand playerOneHand = new Hand();
		Hand dealerHand = new Hand();
		//add other players
		Deal1(playerOneHand, mainDeck);
		Deal1(dealerHand, mainDeck);
		Deal1(playerOneHand, mainDeck);
		Deal1(dealerHand, mainDeck);
		//deal to other players
		
	}

	/************************************************************************
	 * DealerHit() is the A.I. for the dealer. Right now, dealer
	 * only has one option, to hit if hand count is less than 17. In all 
	 * other cases dealer stays.
	 * @param dealerHand dealers hand
	 * @return boolean true if dealer can hit
	 ************************************************************************/
	public static boolean dealerHit(Hand hand){
		int count = Hand.handCount();
		if(count < 17){
			return true;
		}
		else
			return false;
	}
	
	
	private static void Deal1(Hand hand, Deck deck){
		hand.AddtoHand(deck.deal());
	}
	

//	/************************************************************************
//	 * hasAce() checks a hand for an Ace value and returns true if found
//	 * @param hand the hand to be checked for an Ace
//	 * @return boolean true if Ace Card() is found in hand
//	 ************************************************************************/
//	public static boolean hasAce(List<Card> hand){
//		int bool = 0;
//			for(Card card :hand){
//				switch(card.rank()){
//				case ACE:
//					bool = 1;
//					break;
//				}
//			}
//			if(bool == 1){
//				return true;
//				}
//			else 
//				return false;
//	}
	

	
//   /*************************************************************************
//	*handCount() takes a hand, iterates through the cards in the hand, and 
//	*counts the values of the cards, adding them and returning the hand count
//	* @param hand the hand you wish to count
//	* @return handCount int representing the hands value
//	*************************************************************************/
//	static int handCount(List<Card> hand){
//		int count = 0;
//		for(Card card :hand){
//			switch(card.rank()){
//			case TWO:
//				count += 2;
//				break;
//			case THREE:
//				count += 3;
//				break;
//			case FOUR:
//				count += 4;
//				break;
//			case FIVE:
//				count += 5;
//				break;
//			case SIX:
//				count += 6;
//				break;
//			case SEVEN:
//				count += 7;
//				break;
//			case EIGHT:
//				count += 8;
//				break;
//			case NINE:
//				count += 9;
//				break;
//			case TEN:
//				count += 10;
//				break;
//			case JACK:
//				count += 10;
//				break;
//			case QUEEN:
//				count += 10;
//				break;
//			case KING:
//				count += 10;
//				break;
//			case ACE:
//				count += 11;
//				break;
//			}
//		}
//		if(hasAce(hand)==true && count > 21)
//			count -= 10;
//		return count;
//	}
//	

}
