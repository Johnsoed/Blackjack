package bjPack;

import java.util.ArrayList;
import java.util.List;

public class Game {
public static void main(String args[]) { 
	int k = 1;
	Deck deck1 = new Deck();

//tests deck creation
	for (Card c :deck1.deckList) {
		System.out.println(k);
		System.out.println(c.toString());
		k++;
	}
	
//	int c= 1;
//	for(int i = 0; i<52; i++) {
//
////tests deal
//		Card newCard;
//		newCard = deck1.deal(); 
//		System.out.print("card " + c + " ");
//		System.out.println(newCard.toString());
//
//		c++;
//	}
//	
	//performs initial deal using fresh deck
	Deck deck2 = new Deck();
	List<Card> playerOneHand = new ArrayList<Card>();
	List<Card> dealerHand = new ArrayList<Card>();
	playerOneHand.add(deck2.deal());
	playerOneHand.add(deck2.deal());
	dealerHand.add(deck2.deal());
	dealerHand.add(deck2.deal());
	System.out.print("player one's hand is: ");
	printList(playerOneHand);
	printList(dealerHand);
	System.out.println("");
	System.out.print("dealer's hand is: ");
	
	//System.out.println(handCount(playerOneHand));

	
	
	
	
	
		}

static boolean dealerHit(List <Card> dealerHand){
	int count = handCount(dealerHand);
	if(count < 17){
		return true;
	}
	else
		return false;
	
}

static boolean hasAce(List<Card> dealerHand){
	int bool = 0;
		for(Card card :dealerHand){
			switch(card.rank()){
			case ACE:
				bool = 1;
				break;
			}
		
		}
		if(bool == 1){
			return true;
			}
		else 
			return false;
}

static void printList(List<Card> dealerHand){
	
	for (Card card :dealerHand) {
 		System.out.print(card.toString());
 		System.out.print("  ");
 		}
	
 }

/*************************************************************************
   *takes a hand, iterates through the cards in the hand, and counts the values
   *of the cards, adding them and returning the hand count
*************************************************************************/
static int handCount(List<Card> hand){
	int count = 0;
	for(Card card :hand){
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
	if(hasAce(hand)==true && count > 21)
		count -= 10;
	return count;
}
}
