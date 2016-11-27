package bjPack;

import java.util.List;

public class Player {
	Hand hand;
	int points;
	int bet;
	int winlossFlag;
	String endMessage;
	//boolean userHit;
	
	//Constructors
	public Player(){
		super();
		hand = new Hand();
		points = 100;
		bet = 0;
		winlossFlag = 2;
		endMessage = "";
	}
	public Player(Hand hand){
		super();
		this.hand = hand;
		points = 100;
		bet = 0;
		winlossFlag = 2;
		endMessage = "";
	}
	

	public boolean playerHit(){
		//'hard' 17
		if(handValue() < 17 && hand.hasAce() == false){
			return true;
		}
		//'soft' 17
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
	public boolean blackJack(){
		if(handValue() == 21){
			return true;
		}
		else
			return false;
	}
	
	/******************************************************************
	 * printHand() prints out a particular hand
	 *****************************************************************/
	public void printHand(){
		int cardNum = 1;
		for (Card card : hand.ihand){
			System.out.print("Card #" + cardNum++ + ": ");
		 	System.out.println(card.toString());
	 	}
	 }
	
	public void dealerPrintConcealed(){
		int cardNum = 1;
		for (Card card : hand.ihand){
			if(cardNum == 1){
				System.out.print("Card #" + cardNum++ + ": ");
				System.out.println("###### of ######");
			}
			else{
				System.out.print("Card #" + cardNum++ + ": ");
			 	System.out.println(card.toString());
			}
	 	}
	}
	
	public void playerWin(){
		points += (bet * 2);
		bet = 0;
		endMessage = "Win";
		winlossFlag = 1;
	}
	public void playerLose(){
		bet = 0;
		endMessage = "Loss";
		winlossFlag = -1;
	}
	public void playerNatural(){
		points += (int)Math.floor((bet * 1.5));
		bet = 0;
		endMessage = "Natural Win";
		winlossFlag = 1;
	}
	public void playerStandOff(){
		points += bet;
		bet = 0;
		endMessage = "Stand-off(Tie)";
		winlossFlag = 0;
	}
	
	
	public int handValue(){
		return hand.handCount();
	}
	public Hand getHand() {
		return hand;
	}
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	public void addCard(Card card) {
		hand.AddtoHand(card);
	}
	
	
	public int getPoints(){
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getBet(){
		return bet;
	}
	public void setBet(int bet) {
		this.bet = bet;
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
	public int getWinlossFlag() {
		return winlossFlag;
	}
	public void setWinlossFlag(int winlossFlag) {
		this.winlossFlag = winlossFlag;
	}
	
	public String getEndMessage() {
		return endMessage;
	}
	public void setEndMessage(String endMessage) {
		this.endMessage = endMessage;
	}
	
	
}
