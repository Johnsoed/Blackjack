package bjPack;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private boolean gameOver;
	
	private boolean roundOver;
	
	private List<Player> aiPlayers;
	
	private Deck mainDeck;
	
	Player dealer;
	
	Player user;
	
	public Game() {
		super();
		gameOver = false;
		roundOver = false;
		aiPlayers = new ArrayList<Player>();
		mainDeck = new Deck();
		dealer = new Player();
		user = new Player();
	}

	
	
public Game(boolean gameOver, boolean roundOver, List<Player> aiPlayers, Deck mainDeck, Player dealer,
			Player user) {
		super();
		this.gameOver = gameOver;
		this.roundOver = roundOver;
		this.aiPlayers = aiPlayers;
		this.mainDeck = mainDeck;
		this.dealer = dealer;
		this.user = user;
	}



//	while(!gameOver){
		//first round
		//check AI hit/stay
		//check player hit/stay
		//check dealer hit/stay
	
		//all other rounds
		//check player bust --lose condition
		//check dealer bust -- win condition
		//check Ai player bust -- set player to null
		
		//check Ai hit/stay
		//check player hit/stay
		//check dealer hit/stay
	//all stay = check all hands for winner - gameOver = true
//	}
	public void aiHit(){
		roundOver = true;
		for(Player aiPlayer: aiPlayers){
			if(aiPlayer != null){
				if(aiPlayer.playerHit()){
					aiPlayer.getHand().AddtoHand(mainDeck.deal());
					roundOver = false;
				}
			}
		}
	}
	

	/*****************************************************************
	 * DealerHit() is the A.I. for the dealer. Right now, dealer
	 * only has one option, to hit if hand count is less than 17. In all 
	 * other cases dealer stays.
	 * @param dealerHand dealers hand
	 * @return boolean true if dealer can hit
	 *****************************************************************/
	public void dealerHit(){
		if(dealer.handValue() < 17){
			dealer.getHand().AddtoHand(mainDeck.deal());
			roundOver = false;
		}
		else
			roundOver = true;
	}
	
	
	private void Deal1(Hand hand){
		hand.AddtoHand(mainDeck.deal());
	}
	
	private void aiWinCheck(){
		for(Player aiPlayer : aiPlayers){
			if(aiPlayer.handValue() > dealer.handValue()){
				aiPlayer.playerWin();
			}
			else
				aiPlayer.playerLose();
		}
	}
	
	private void userWinCheck(){
		if(user.handValue() > dealer.handValue()){
			user.playerWin();
		}
		else
			user.playerLose();
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



	public List<Player> getAiPlayers() {
		return aiPlayers;
	}



	public void setAiPlayers(List<Player> aiPlayers) {
		this.aiPlayers = aiPlayers;
	} 
	
	
}
