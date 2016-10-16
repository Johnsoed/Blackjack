package bjPack;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Game {
public static void main(String args[]) { 
	int k = 1;
	Deck deck1 = new Deck();
    Scanner input = new Scanner(System.in);

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
	while(true){
	Deck deck2 = new Deck();
	List<Card> playerOneHand = new ArrayList<Card>();
	List<Card> dealerHand = new ArrayList<Card>();
	playerOneHand.add(deck2.deal());
	playerOneHand.add(deck2.deal());
	dealerHand.add(deck2.deal());
	dealerHand.add(deck2.deal());
	System.out.print("player one's hand is: ");
	printList(playerOneHand);
	System.out.println("");
	System.out.print("dealer's hand is: ");
	printList(dealerHand);
	
	//System.out.println(handCount(playerOneHand));
	boolean playerHit = true;
	boolean dealerHits = true;
	int playerScore = 0;
	int dealerScore = 0;
	boolean bust = false;
	String hitStay = "";
	String newGame = "";
	while (bust == false && (playerHit == true || 
			dealerHits == true)) {
		System.out.println("");
		if (playerHit == true){
	    System.out.println("enter 'hit' to hit and 'stay' to stay");
	    hitStay = input.next();
	    if (hitStay.equals("stay")) {
	    	playerHit = false;
	    	System.out.println(playerHit);
	    }
		}
		System.out.println(playerHit);
		System.out.println(hitStay);
		if (bust == false && playerHit == true){ 
			playerOneHand.add(deck2.deal());
			playerScore = handCount(playerOneHand);
			System.out.print("player one's hand is: ");
			printList(playerOneHand);
			System.out.print(" " + playerScore);
			if (playerScore > 21) {bust = true;}
		}
		System.out.println("");
		if (dealerHit(dealerHand) == false) {dealerHits = false;}
		if (bust == false && dealerHits == true){ 
			dealerHand.add(deck2.deal());
			dealerScore = handCount(dealerHand);
			System.out.print("dealer's hand is: ");
			printList(dealerHand);
			System.out.print(" " + dealerScore);
			if (dealerScore > 21) {bust = true;}
			System.out.println("");
		}
		if (playerScore == 21 || dealerScore == 21){
			bust = true;
		}
	}
	playerScore = handCount(playerOneHand);
	dealerScore = handCount(dealerHand);
	System.out.print("Player's final hand: ");
	printList(playerOneHand);
	System.out.print(" " + playerScore);
	System.out.println("");
	System.out.print("Dealer's final hand: ");
	printList(dealerHand);
	System.out.print(" " + dealerScore);
	System.out.println("");
	if (playerScore > 21){playerScore = 0;}
	if (dealerScore > 21){dealerScore = 0;}
	if (dealerScore >= playerScore){
		System.out.println("dealer wins");
	}
	else{
		System.out.println("player wins");
	}
    System.out.println("enter 'q' to quit and 'n' for new game");
    newGame = input.next();
    if (newGame.equals("q")) {
    	System.exit(0);
    }
    else{
    }
    }
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