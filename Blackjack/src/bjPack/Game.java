package bjPack;

import java.util.ArrayList;
import java.util.List;

public class Game {
	public static void main(String args[]) { 
		int k = 1;
		Deck deck1 = new Deck();
		//ints for hands
		
		
		//booleans for hit/stay
		
		
		
		
//	//tests deck creation
//		for (Card c :deck1.deckList) {
//			System.out.println(k);
//			System.out.println(c.toString());
//			k++;
//		}
//		
//		int c= 1;
//		for(int i = 0; i<52; i++) {
//			//tests deal
//			Card newCard;
//			newCard = deck1.deal(); 
//			System.out.print("card " + c + " ");
//			System.out.println(newCard.toString());
//	
//			c++;
//		}
	
		//performs initial deal using fresh deck
		Deck deck2 = new Deck();
		List<Card> playerOneHand = new ArrayList<Card>();
		List<Card> dealerHand = new ArrayList<Card>();
		playerOneHand.add(deck2.deal());
		dealerHand.add(deck2.deal());
		playerOneHand.add(deck2.deal());
		dealerHand.add(deck2.deal());
		System.out.print("player one's hand is: ");
		printList(playerOneHand);
		System.out.println("");
		System.out.print("dealer's hand is: ");
		printList(dealerHand);
		
		//while loop - needs to run until 21, then check for ACE, reassign hand value if found
		//end match if not. match also ends if both players pick stay. 
	}
	
	static void printList(List<Card> dealerHand){
		for (Card card :dealerHand) {
	 		System.out.print(card.toString());
	 		System.out.print("  ");
	 	}
	 }
	
	
//Static hand value - assign number value to hand based on enum
}