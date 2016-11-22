package bjPack;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private boolean gameOver = false;
	
	private boolean roundOver = false;
	
	private List<Player> aiPlayers = new ArrayList<Player>();
	
	private Deck mainDeck = new Deck();
	
	Player dealer = new Player();
	
	Player user = new Player();
	
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Game(boolean gameOver, List<Player> aiPlayers, Deck mainDeck) {
		super();
		this.gameOver = gameOver;
		this.aiPlayers = aiPlayers;
		this.mainDeck = mainDeck;
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

}
