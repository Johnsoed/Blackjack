package bjPack;

import java.util.ArrayList;
import java.util.List;

public class Game {
	Player player1;
	Player dealer;
	Deck deck;
	Player ai1;
	Player ai2;
	public Game() {
		
		deck = new Deck();
		deck.shuffleDeck();
		player1 = new Player();
		dealer = new Player();
		ai1 = new Player();
		ai2 = new Player();
		dealer.points(500);

	}
	
	public void initialDeal() {
		player1.bet(10);
		dealer.bet(30);		
		ai1.bet(10);				
		ai2.bet(10);			
		
		player1.addCard(deck.deal());
		player1.hand.AddtoHand(deck.deal());
		dealer.addCard(deck.deal());
		dealer.addCard(deck.deal());
		ai1.addCard(deck.deal());
		ai1.addCard(deck.deal());
		ai2.addCard(deck.deal());
		ai2.addCard(deck.deal());
	}
	
	public void hitOrStay(boolean hit) {
		player1.userHit(hit);
	}
	
	public boolean stayBustWin(){
		
		if (player1.userHit == false && dealer.userHit == false) {
			return true; 
		}
		
		if (player1.playerBust() == true || dealer.playerBust() == true)
			return true;
		if (player1.blackJack() == true || dealer.blackJack() == true) {
			return true;
		}
		
		
		if (dealer.playerBust() == true) {
			return true;
		}
		
		return false; 			
	}
	
	public void round() {
		deckCheck();
		if (player1.userHit == true && player1.playerBust() == false) {
		player1.addCard(deck.deal());	
		}
		if (dealer.userHit == true && player1.playerBust() == false) {
		if (dealer.playerHit(player1) == true && dealer.playerBust() == false)
		{
			dealer.addCard(deck.deal());
		}
		
		if (dealer.playerBust() == false) {
		if (ai1.aiHit() == true && ai1.playerBust() == false) {
			ai1.addCard(deck.deal());
		}
		if (ai2.aiHit() == true && ai2.playerBust() == false) {
			ai2.addCard(deck.deal());
		}
		}
		}
	} 
	
	public void printCards() {
		System.out.print("player hand is");
		player1.printList();
		System.out.print(" " + player1.handValue());
		System.out.println("");
		System.out.print("dealer hand is ");
		dealer.printList();
		System.out.print(" " + dealer.handValue());

	}
	
	public Boolean winner(Player player) {
		if (dealer.handValue() == 21) {
			player.playerLose();
			dealer.dealerWin(player.bet);
			return false; }
		if((player.handValue() > dealer.handValue() && player.handValue() <= 21)
				|| (dealer.playerBust() == true && player.playerBust() == false) ){
			player.playerWin();
			dealer.playerLose();
			return true;
			
		}
		else if (dealer.handValue() >= player.handValue() || player.playerBust() == true)
	{
			player.playerLose();
			dealer.dealerWin(player.bet);
			return false;
				}
		player.playerLose();
		dealer.dealerWin(player.bet);
		return  false;
	}
	
	
	public boolean check21s() {
		if (player1.blackJack() == true || dealer.blackJack() == true) {
			return true;
		}
		else return false; 
	}
	
	public void reset() {
		player1.hand.DiscardHand();
		dealer.hand.DiscardHand();
		ai1.hand.DiscardHand();
		ai2.hand.DiscardHand();
		dealer.userHit(true);
		deck = new Deck();
		deck.shuffleDeck();
	}
	
	public void deckCheck() {
		if (deck.deckList.size() < 8) {
			deck = new Deck();
			deck.shuffleDeck();
		}
	}
	
	
	public void pointsReset() {
		player1.points = 100;
		dealer.points(500);
		ai1.points(100);
		ai2.points(100);
		reset();
	}
}
