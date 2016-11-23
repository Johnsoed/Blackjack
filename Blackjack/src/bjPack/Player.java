package bjPack;

import java.util.List;

public class Player {
	Hand hand;
	int points = 100;
	int bet = 0;
	boolean userHit; 
	public Player(){
		super();
		hand = new Hand();
	}
	
	public Player(Hand hand){
		super();
		this.hand = hand;
	}
	
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
	
	/******************************************************************
	 * printList() prints out a particular hand
	 *****************************************************************/
	public void printList(){
		for (Card card : hand){
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

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	
	public void setPoints(int points) {
		this.points = points;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public void userHit(boolean hit) {
		userHit = hit;
	}
	
}
