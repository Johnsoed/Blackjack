package bjPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
	private boolean gameOver;
	
	private boolean roundOver;
	
	ArrayList<Player> aiPlayers;
	
	private Deck mainDeck;
	
	Player dealer;
	
	Player user;
	
	public Game(){
		super();
		gameOver = false;
		roundOver = false;
		aiPlayers = new ArrayList<Player>();
		mainDeck = new Deck();
		dealer = new Player();
		user = new Player();
	}

	public Game(int aiNum){
		this();
		for(int i = 1; i <= aiNum; i++){
			Player add = new Player();
			aiPlayers.add(add);
		}
	}
	
	public void initialDeal(){
		//safety. so we don't pull from too small a deck
		if(mainDeck.deckCount() < (4 + (aiPlayers.size() * 2) ) ){
			mainDeck.newDeck();
		}	
		dealer.addCard(mainDeck.deal());
		dealer.addCard(mainDeck.deal());
		user.addCard(mainDeck.deal());
		user.addCard(mainDeck.deal());
		if(aiPlayers == null){
			//do nothing
		}
		else{
			for(Player aiPlayer: aiPlayers){
				if(aiPlayer != null){
					aiPlayer.addCard(mainDeck.deal());
					aiPlayer.addCard(mainDeck.deal());
				}
			}
		}
	}
	public void checkNaturals(){
		//dealer has blackJack - round over and only players with blackjack get money back
		if(dealer.blackJack()){
			//check AI player for blackJack
			for(Player aiPlayer: aiPlayers){
				if(aiPlayer.blackJack()){
					aiPlayer.playerStandOff();
				}
				else
					aiPlayer.playerLose();
			}
			//check user for blackJack
			if(user.blackJack()){
				user.playerStandOff();
			}
			else
				user.playerLose();
		}
		//check for player naturals
		else{
			//AI player naturals
			for(Player aiPlayer: aiPlayers){
				if(aiPlayer.blackJack()){
					aiPlayer.playerNatural();
				}
			}
			//user natural
			if(user.blackJack()){
				user.playerNatural();
			}
		}
	}
	
	public void userHitStay(boolean hit){
		if(hit){
			user.getHand().AddtoHand(mainDeck.deal());
		}
	}
	//performs AI players hit/stay
	public void aiHitStay(){
		if(aiPlayers == null){
			//do nothing
		}
		else{
			for(Player aiPlayer: aiPlayers){
				if(aiPlayer != null){
					if(aiPlayer.playerHit()){
						aiPlayer.getHand().AddtoHand(mainDeck.deal());
					}
				}
			}
		}
	}
	//performs dealer hit/stay
	public void dealerHitStay(){
		if(dealer.playerHit()){
			dealer.getHand().AddtoHand(mainDeck.deal());
		}
	}
	//checks if user won, tied, or lost; sets values
	private void userWinCheck(){
		if(user.playerBust()){
			user.playerLose();
		}
		else if(user.handValue() > dealer.handValue() || dealer.playerBust()){
			user.playerWin();
		}
		else if(user.handValue() == dealer.handValue()){
			user.playerStandOff();
		}
		else
			user.playerLose();
	}
	//checks if AIs won, tied, or lost; sets values
	private void aiWinCheck(){
		if(aiPlayers == null){
			//do nothing
		}
		else{
			for(Player aiPlayer : aiPlayers){
				if(aiPlayer.playerBust()){
					aiPlayer.playerLose();
				}
				else if(aiPlayer.handValue() > dealer.handValue() || dealer.playerBust()){
					aiPlayer.playerWin();
				}
				else if(aiPlayer.handValue() == dealer.handValue()){
					aiPlayer.playerStandOff();
				}
				else
					aiPlayer.playerLose();
			}
		}
	}
	//performs non-users hit/stay checks and actions
	public void nonUserHitStay(){
		aiHitStay();
		dealerHitStay();		
	}
	//performs win/loss checks and actions
	public void setWinLoss(){
		userWinCheck();
		aiWinCheck();
	}
	public List<Player> getAiPlayers() {
		return aiPlayers;
	}
	public void setAiPlayers(ArrayList<Player> aiPlayers) {
		this.aiPlayers = aiPlayers;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public boolean isRoundOver() {
		return roundOver;
	}

	public void setRoundOver(boolean roundOver) {
		this.roundOver = roundOver;
	}

	public Deck getMainDeck() {
		return mainDeck;
	}

	public void setMainDeck(Deck mainDeck) {
		this.mainDeck = mainDeck;
	} 
	
	
}
