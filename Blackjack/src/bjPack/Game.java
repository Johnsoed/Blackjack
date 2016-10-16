/***************************************************************************
* Game is the main class of the BlackJack game. It handles all of the 
* elements of the game and also contains the methods for the AI and other
* helper methods.
* @author Logan Crowe, Edward Johnson, Anthony Dowling
***************************************************************************/
package bjPack;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Game {
	
	public static void main(String args[]) {
		/*game decks*/
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		/*input scanner*/
	    Scanner input = new Scanner(System.in);
	    
		while(true){
			/*player hand*/
			List<Card> playerOneHand = new ArrayList<Card>();
			/*dealer hand*/
			List<Card> dealerHand = new ArrayList<Card>();
			//deal 2 cards to each
			playerOneHand.add(deck2.deal());
			playerOneHand.add(deck2.deal());
			dealerHand.add(deck2.deal());
			dealerHand.add(deck2.deal());
			//display each hand
			System.out.print("player one's hand is: ");
			printList(playerOneHand);
			System.out.println("");
			System.out.print("dealer's hand is: ");
			printList(dealerHand);
			//setup game values
			boolean playerHit = true;
			boolean dealerHits = true;
			int playerScore = 0;
			int dealerScore = 0;
			boolean bust = false;
			String hitStay = "";
			String newGame = "";
			//the game
			while (bust == false && (playerHit == true || 
					dealerHits == true)) {
				System.out.println("");
				//player prompts
				if (playerHit == true){
			    System.out.println("enter 'hit' to hit and 'stay' to stay");
			    hitStay = input.next();
				    if (hitStay.equals("stay")) {
				    	playerHit = false;
				    	System.out.println(playerHit);
				    }
				}
				
				//System.out.println(playerHit);//debugging
				//System.out.println(hitStay);//debugging
				
				//player hits
				if (bust == false && playerHit == true){ 
					playerOneHand.add(deck2.deal());
					playerScore = handCount(playerOneHand);
					System.out.print("player one's hand is: ");
					printList(playerOneHand);
					System.out.print(" " + playerScore);
					if (playerScore > 21) {bust = true;}//bust
				}
				System.out.println("");
				//run AI for dealer
				if (dealerHit(dealerHand) == false) {dealerHits = false;}
				//dealer hits
				if (bust == false && dealerHits == true){ 
					dealerHand.add(deck2.deal());
					dealerScore = handCount(dealerHand);
					System.out.print("dealer's hand is: ");
					printList(dealerHand);
					System.out.print(" " + dealerScore);
					if (dealerScore > 21) {bust = true;}//bust
					System.out.println("");
				}
				//?
				if (playerScore == 21 || dealerScore == 21){
					bust = true;
				}
			}
			//the wrap-up
			//counts the hand scores
			playerScore = handCount(playerOneHand);
			dealerScore = handCount(dealerHand);
			//display them
			System.out.print("Player's final hand: ");
			printList(playerOneHand);
			System.out.print(" " + playerScore);
			System.out.println("");
			System.out.print("Dealer's final hand: ");
			printList(dealerHand);
			System.out.print(" " + dealerScore);
			System.out.println("");
			//decide winner
			if (playerScore > 21){playerScore = 0;}
			if (dealerScore > 21){dealerScore = 0;}
			//print winner
			if (dealerScore >= playerScore){
				System.out.println("dealer wins");
			}
			else{
				System.out.println("player wins");
			}
			//prompt for game choices
		    System.out.println("enter 'q' to quit and anything else "
		    		+ "for new game");
		    newGame = input.next();
		    //'q' quits
		    if (newGame.equals("q")) {
		    	input.close();
		    	System.exit(0);
		    }
		    //everything else makes new game
		    else{
		    }
	    }
			
	}
	
	/***********************************************************************
	 * dealerHit() is the AI for the dealer. As it is, the only condition
	 * is if the hand value is less than 17. In this case, the dealer hits.
	 * In all other cases, it stays. 
	 * @param dealerHand the dealers hand
	 * @return boolean true if the dealer should hit
	 **********************************************************************/
	static boolean dealerHit(List <Card> dealerHand){
		int count = handCount(dealerHand);
		if(count < 17){
			return true;
		}
		else
			return false;		
	}
	
	/************************************************************************
	 * hasAce() is a check to see if a hand has an Ace in it, which could 
	 * make the hands value different depending on the situation. 
	 * @param hand the hand that is going to be checked
	 * @return boolean true if hand contains an Ace
	 ***********************************************************************/
	static boolean hasAce(List<Card> hand){
		int bool = 0;
			for(Card card :hand){
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
	
	/************************************************************************
	 * printList() prints out the list of cards in the hand provided in 
	 * the parameter.
	 * @param hand the hand that is to be printed
	 ***********************************************************************/
	static void printList(List<Card> hand){
		for (Card card :hand) {
	 		System.out.print(card.toString());
	 		System.out.print("  ");
	 		}		
	 }
	
	
	/************************************************************************
	 * handCount() counts up the value of the hand based on the cards in it.
	 * @param hand the hand that is going to be counted
	 * @return handCount int that represents the value of the hand
	 ***********************************************************************/
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