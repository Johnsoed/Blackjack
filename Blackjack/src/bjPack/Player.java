package bjPack;



/*****************************************************************
 * Player object for use in blackjack game, each players has 
 * points,a hand of cards, booleans for if they have stayed 
 * or won/lost, and bet amount. 
 * @author  Edward Johnson, Anthony Dowling, Logan Crowe
 * @version December 8th, 2016
*****************************************************************/
public class Player {
	/** players hand of cards. */ 
	private Hand hand = new Hand();
	/** players points. */ 
	private int points = 100;
	/** player's bet. */ 
	private int bet = 0;
	/** boolean for if player has won/lost the game. */ 
	private boolean winLose;
	/** boolean for if player has hit or stayed. */ 
	private boolean userHit = true;

	/*****************************************************************
	Constructor for player, creates player with a hand array of cards
	in this case, empty.
	*****************************************************************/
	public Player() {
		// Hand hand = new Hand();
		this.hand = hand;

	}

	/*****************************************************************
	 * constructor for player, 
	 * creates player object with certain hand.
	@param hand sets hand to set playerhand to
	*****************************************************************/
	public Player(Hand hand) {
		this.hand = hand;
	}

	/*****************************************************************
	 * Returns value of player's hand.
	@return handcount, in value of play
	*****************************************************************/
	public int handValue() {
		return hand.handCount();
	}

	/*****************************************************************
	 * determines whether computer dealer hits or stays, using the 
	 * other player's handcount. If the dealer's hand is less than 17
	 * or if the player's hand is larger, dealer hits, else, they stay
	 
	 * @param otherplayer the player dealer looks at to decide 
	 * 	whether to hit or stay
	 * 
	 * @return returns true if dealer player hits, false if they don't
	*****************************************************************/
	public boolean playerHit(Player otherplayer) {
		if (otherplayer.handValue() > handValue()) {
			userHit = true;
			return true;
		} else if (handValue() < 17 && hand.hasAce() == false) {

			userHit = true;
			return true;
		} else if (handValue() > 17 && handValue() < 20 
				&& hand.hasAce() == true) {
			userHit = true;
			return true;
		} else {
			userHit = false;
			return false;

		}
	}

	/*****************************************************************
	 * determines whether aiplayer hits or stays, if their hand value 
	 * is less than 17 they hit, else, they stay.
	 
	 * @return return's true if hand handcount is less than 17, false 
	 * if hand value is greater. 
	*****************************************************************/
	public Boolean aiHit() {
		if (handValue() < 17) {
			return true;
		} else {
			return false;
		}
	}

	/*****************************************************************
	 * Determines whether player has busted, if their hand value is
	 * greater than 21, they've busted, otherwise they haven't.
	 * @return Returns true if player has busted, false if not. 
	*****************************************************************/
	public boolean playerBust() {
		if (handValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

	/*****************************************************************
	 * prints hand list in console, for use in testing.
	*****************************************************************/
	public void printList() {
		for (Card card : hand.getihand()) {
			System.out.print(card.toString());
			System.out.print("  ");
		}
	}

	/*****************************************************************
	 * Sees if player has blackjack, a hand value equal to 21.
	 
	 * @return returns true if player has 21, false if they don't
	*****************************************************************/
	public boolean blackJack() {
		if (handValue() == 21) {
			return true;
		} else {
			return false;
		}
	}

	/*****************************************************************
	 * Bets points equal to number passed to method, points are taken
	 * out of the players points and put into "bet," if they win they 
	 * win equal to their bet, and get their bet back, if they 
	 * lose they lose the points in bet.
	 
	 * @param bet amount to bet
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
	 * returns points.
	 
	 * @return points
	*****************************************************************/
	public int getPoints() {
		return points;
	}

	/*****************************************************************
	 * Returns bet.
	 
	 * @return bet
	*****************************************************************/
	public int getBet() {
		return bet;
	}

	/*****************************************************************
	 * when called, adds double the players bets to their points,
	 * essentially, giving them their bet back and adding an amount
	 * equal to what they bet. I;e, if they bet 10 points in win, the
	 * 	get their ten points back +10 as winnings
	*****************************************************************/
	public void playerWin() {
		points = points + (10 * 2);
	}

	/*****************************************************************
	 * Adds card in parameter to player's hand.
	
	 * @param card card to be added
	*****************************************************************/
	public void addCard(Card card) {
		hand.AddtoHand(card);
	}

	/*****************************************************************
	 * lose condition. Written by Anthony, never implemented by me
	 * player simply loses their bet upon losing
	*****************************************************************/
	public void playerLose() {

	}

	/*****************************************************************
	 * Sets userHit, if userHit is true, player has not stayed and is
	 * still in the game.
	 
	 * @param hit true or false value to set userHit to
	*****************************************************************/
	public void userHit(boolean hit) {
		userHit = hit;
	}

	/*****************************************************************
	 * upon dealer beating a player, they get 20 points, 10 to cover
	 * their bet + the 10 point bet of the player they beat. 
	 
	 * @param playerBet bet the player is making against them
	*****************************************************************/
	public void dealerWin(int playerBet) {
		points = points + 10 * 2;

	}

	/*****************************************************************
	 * 	Sets points.
	 
	 * @param i player's points are set to i
	*****************************************************************/
	public void points(int i) {
		points = i;

	}
	
	/*****************************************************************
	 * Getter for hand.
	 
	 * @return returns hand
	*****************************************************************/
	public Hand getHand() {
		return hand;
	}
	
	/*****************************************************************
	 * 	Returns winlose boolean.
	 
	 * @return winLose 
	*****************************************************************/
	public boolean winLose() {
		return winLose;
	}
	
	/*****************************************************************
	 * 	Returns userHit boolean.
	 
	 * @return userHit 
	*****************************************************************/
	public boolean getUserHit() {
		return userHit;
	}

	/*****************************************************************
	 * Setter for points.
	 
	 * @param i value to set points to
	*****************************************************************/
	public void setPoints(int i) {
		points = i;
	}
	
	
}