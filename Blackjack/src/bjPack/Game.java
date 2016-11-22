package bjPack;

import java.util.ArrayList;
import java.util.List;

public class Game {
	Player player1;
	Player dealer;
	Deck deck;
	public Game() {

		Deck deck = new Deck();
		Player player1 = new Player();
		Player dealer = new Player();
	}
	
	public void hitOrStay(boolean hit) {
		player1.userHit(hit);
	}
	
	public boolean stayBustWin(){
		if (player1.userHit == false && dealer.playerHit() == false) {
			return false; 
		}
		
		if (player1.playerBust() == true && dealer.playerBust() == true)
			return true;
		if (player1.blackJack() == true || dealer.blackJack() == true) {
			return true;
		}
		
		if (dealer.playerBust() == true) {
			return true;
		}
		
		return false; 			
	}
	
	public void Round() {
		if (player1.userHit == true && player1.playerBust() == false) {
		player1.addCard(deck.deal());	
		}
		
		if (dealer.playerHit() == true && dealer.playerBust() == false)
		{
			dealer.addCard(deck.deal());
		}
	} 
	
	public void 
	
	
}
