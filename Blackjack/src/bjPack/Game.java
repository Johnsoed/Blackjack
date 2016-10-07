package bjPack;

import java.util.ArrayList;
import java.util.List;

public class Game {
public static void main(String args[]) { 
	Deck deck1 = new Deck();
	for (Card c :deck1.deckList) {
//		System.out.println(c.toString());
	}
	
	int c= 1;
	for(int i = 0; i<52; i++) {

//tests deal
		Card newCard;
		newCard = deck1.deal(); 
		System.out.print("card " + c + " ");
		System.out.println(newCard.toString());

		c++;
	}
	
	//performs initial deal using fresh deck
	Deck deck2 = new Deck();
	List<Card> playerOneHand = new ArrayList<Card>();
	List<Card> dealerHand = new ArrayList<Card>();
	Card tempCard = deck2.deal();
	playerOneHand.add(tempCard);
	tempCard = deck2.deal();
	dealerHand.add(tempCard);
	tempCard = deck2.deal();
	playerOneHand.add(tempCard);
	tempCard = deck2.deal();
	dealerHand.add(tempCard);
	System.out.print("player one's hand is: ");
	for (Card h :playerOneHand) {
 		System.out.print(h.toString());
 		System.out.print(", ");
			}
	System.out.println("");
	System.out.print("dealer's hand is: ");
	for (Card h :dealerHand) {
 		System.out.print(h.toString());
 		System.out.print(" ");
			}
	
	
	
		}



}