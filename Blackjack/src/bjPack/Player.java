package bjPack;
/*****************************************************************
Player object for use in blackjack game, each players has points,
a hand of cards, booleans for if they have stayed or won/lost,
and bet amount. 
@author  Edward Johnson, Anthony Dowling, Logan Crowe
@version December 8th, 2016
*****************************************************************/
import java.util.List;

public class Player {
	private Hand hand = new Hand();
	private int points = 100;
	private int bet = 0;
	private boolean winLose;
	private boolean userHit = true;

	/*****************************************************************
	constructor for player, creates player with a hand array of cards
	in this case, empty
	@param n/a
	*****************************************************************/
	public Player() {
		// Hand hand = new Hand();
		this.hand = hand;

	}

	/*****************************************************************
	constructor for player, creates player object with particular hand
	@param n/a
	*****************************************************************/
	public Player(Hand hand) {
		this.hand = hand;
	}

	/*****************************************************************
	 * returns value of player's hand
	@param n/a
	@return handcount, in value of play
	*****************************************************************/
	public int handValue() {
		return hand.handCount();
	}

	/*****************************************************************
	determines whether computer dealer hits or stays, using the 
	other player's handcount. If the dealer's hand is less than 17
	or if the player's hand is larger, dealer hits, else, they stay
	@param n/a
	@returns returns true if dealer player hits, false if they don't
	*****************************************************************/
	public boolean playerHit(Player otherplayer) {
		if (otherplayer.handValue() > handValue()) {
			userHit = true;
			return true;
		} else if (handValue() < 17 && hand.hasAce() == false) {

			userHit = true;
			return true;
		}

		else if (handValue() > 17 && handValue() < 20 && hand.hasAce() == true) {
			userHit = true;
			return true;
		} else {
			userHit = false;
			return false;

		}
	}

	/*****************************************************************
	determines whether aiplayer hits or stays, if their hand value is
	less than 17 they hit, else, they stay
	@param n/a
	*****************************************************************/
	public Boolean aiHit() {
		if (handValue() < 17) {
			return true;
		} else
			return false;
	}

	/*****************************************************************
	determines whether player has busted, if their hand value is
	greater than 21, they've busted, otherwise they haven't
	@param n/a
	@returns if player has busted, returns true, else, returns false
	*****************************************************************/
	public boolean playerBust() {
		if (handValue() > 21) {
			return true;
		} else
			return false;
	}

	/*****************************************************************
	prints hand list in console, for use in testing
	@param n/a
	*****************************************************************/
	public void printList() {
		for (Card card : hand.ihand) {
			System.out.print(card.toString());
			System.out.print("  ");
		}
	}

	/*****************************************************************
	sees if player has blackjack, a hand value equal to 21
	@param n/a
	@return returns true if player has 21, false if they don't
	*****************************************************************/
	public boolean blackJack() {
		if (handValue() == 21) {
			return true;
		} else
			return false;
	}

	/*****************************************************************
	bets points equal to number passed to method, points are taken
	out of the players points and put into "bet," if they win they win
	equal to their bet, and get their bet back, if they lose they lose
	the points in bet
	@param bet, amount to bet
	*****************************************************************/
	public void bet(int bet) {
		if (points < 10) {
			System.out.println("Not enough points to bet!");
		} else {
			points = points - bet;
			this.bet = bet;
		}
	}

	/*****************************************************************
	returns points
	@param n/a
	@return points
	*****************************************************************/
	public int getPoints() {
		return points;
	}

	/*****************************************************************
	returns bet
	@param n/a
	@return bet
	*****************************************************************/
	public int getBet() {
		return bet;
	}

	/*****************************************************************
	when called, adds double the players bets to their points,
	essentially, giving them their bet back and adding an amount
	equal to what they bet. I;e, if they bet 10 points in win, they
	get their ten points back +10 as winnings
	@param n/a
	*****************************************************************/
	public void playerWin() {
		points = points + (10 * 2);
	}

	/*****************************************************************
	adds card in parameter to player's hand
	@param card, card to be added
	*****************************************************************/
	public void addCard(Card card) {
		hand.AddtoHand(card);
	}

	/*****************************************************************
	 * lose condition. Written by anthony, never implemented by me
	 * player simply loses their bet upon losing
	@param n/a
	*****************************************************************/
	public void playerLose() {

	}

	/*****************************************************************
	sets userHit, if userHit is true, player has not stayed and is
	still in the game
	@param hit, true or false value to set userHit to
	*****************************************************************/
	public void userHit(boolean hit) {
		userHit = hit;
	}

	/*****************************************************************
	upon dealer beating a player, they get 20 points, 10 to cover
	their bet + the 10 point bet of the player they beat. 
	@param int playerBet, bet the player is making against them
	*****************************************************************/
	public void dealerWin(int playerBet) {
		points = points + 10 * 2;

	}

	/*****************************************************************
	sets points
	@param i, player's points are set to i
	*****************************************************************/
	public void points(int i) {
		points = i;

	}
	
	/*****************************************************************
	getter for hand
	@param n/a
	@return returns hand
	*****************************************************************/
	public Hand getHand() {
		return hand;
	}
	
	/*****************************************************************
	returns winlose boolean
	@param n/a
	@return winLose 
	*****************************************************************/
	public boolean winLose() {
		return winLose;
	}
	
	/*****************************************************************
	returns userHit boolean
	@param n/a
	@return userHit 
	*****************************************************************/
	public boolean getUserHit() {
		return userHit;
	}

	/*****************************************************************
	setter for points
	@param i, value to set points to
	*****************************************************************/
	public void setPoints(int i) {
		points = i;
	}
	
	
}