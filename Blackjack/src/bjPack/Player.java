package bjPack;

import java.util.List;

public class Player {
	Hand hand = new Hand();
	int points = 100;
	int bet = 0;
	boolean winLose;
	boolean userHit =true; 
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
	public boolean playerHit(Player otherplayer){
		if (otherplayer.handValue() > handValue()) {
			userHit = true;
			return true;	
		}
		else if(handValue() < 17 && hand.hasAce() == false){
			
			userHit = true;
			return true;
		}

		else if(handValue() > 17 && handValue() < 20
				&& hand.hasAce() == true){
			userHit = true;
			return true;
		}
		else{
			userHit = false;
			return false;

		}
	}
	
	public Boolean aiHit() {
		 if (handValue() < 17) {
			return true;
		}
		 else return false; 
	}
	
	public boolean playerBust(){
		if(handValue() > 21){
			return true;
		}
		else 
			return false;
	}
	
	public void printList(){
		for (Card card :hand.ihand) {
	 		System.out.print(card.toString());
	 		System.out.print("  "); 
		}
	 }
	
	public boolean blackJack(){
		if(handValue() == 21){
			return true;
		}
		else
			return false;
	}
	
	public void bet(int bet){
		if(points < 10){
			System.out.println("Not enough points to bet!");
		}
		else{
			System.out.println("bet - " + bet);
			points = points - bet;
			this.bet = bet;
		}
	}

	public int getPoints(){
		return points;
	}
	
	public int getBet(){
		return bet;
	}
	
	public void playerWin(){
		points = points + (bet * 2);
	}
	
	public void addCard(Card card) {
		hand.AddtoHand(card);
	}
	
	public void playerLose(){
		System.out.println("lost - " + bet);
	}
	
	public void userHit(boolean hit) {
		userHit = hit;
	}
	
	public void dealerWin(int playerBet) {
		points = points + playerBet * 2;
		
	}

	public void points(int i) {
		points = i;
		
	}
	
}