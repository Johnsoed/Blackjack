package bjPack;

import java.util.List;

public class Player {
	Hand hand = new Hand();
	int points = 100;
	int bet = 0;
	boolean userHit; 
	public Player(){
		//Hand hand = new Hand();
		this.hand = hand;
		
	}
	
	public Player(Hand hand){
		this.hand = hand;
	}
	//has a hand
	
	public int handValue(){
		return hand.handCount();
	}
	public boolean playerHit(){
		if(handValue() < 17 && hand.hasAce() == false){
			return true;
		}
		else if(handValue() > 17 && handValue() < 20
				&& hand.hasAce() == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean playerBust(){
		if(handValue() > 21){
			return true;
		}
		else 
			return false;
	}
	
/*	*//************************************************************************
	 * printList() prints out a particular hand
	 ************************************************************************//*
	public void printList(){
		for () {
	 		System.out.print(card.toString());
	 		System.out.print("  ");
	 		}
	 }*/
	
	public boolean blackJack(){
		if(handValue() == 21){
			return true;
		}
		else
			return false;
	}
	
	public void bet(){
		if(points < 10){
			System.out.println("Not enough points to bet!");
		}
		else{
			points -= 10;
			bet += 10;
		}
	}

	public int getPoints(){
		return points;
	}
	
	public int getBet(){
		return bet;
	}
	
	public void playerWin(){
		points += (bet * 2);
	}
	
	public void addCard(Card card) {
		hand.AddtoHand(card);
	}
	
	public void playerLose(){
		bet = 0;
	}
	
	public void userHit(boolean hit) {
		userHit = hit;
	}
	
}
