package bjPack;





/*****************************************************************
 * Game class for blackjack game, handles the actual running
 * of the game, interacting with the players and deck.
 * @author  Edward Johnson
 * @version December 8th, 2016
*****************************************************************/
public class Game {
	/** The human player, plays game through GUI interface. */
	private Player player1;
	/** AI dealer, plays against human player and two AI players. */
	private Player dealer;
	/** 52 card deck. */
	private Deck deck;
	/** first AI player, plays against dealer. */
	private Player ai1;
	/** second AI player, plays. */
	private Player ai2;

	/*****************************************************************
	 * Constructor for game class, initializes the human and ai players, ai
	 * dealer, sets dealer's point to default 500.
	 *****************************************************************/
	public Game() {

		deck = new Deck();
		deck.shuffleDeck();
		player1 = new Player();
		dealer = new Player();
		ai1 = new Player();
		ai2 = new Player();
		dealer.points(500);

	}

	/*****************************************************************
	 * method to peform initial dealer, deals each player 2 cards, does bets for
	 * each player, each non-dealer player bets 10, dealer bets 30, 10 points
	 * against each other player.
	 *****************************************************************/
	public void initialDeal() {
		player1.bet(10);
		dealer.bet(30);
		ai1.bet(10);
		ai2.bet(10);

		player1.addCard(deck.deal());
		player1.getHand().AddtoHand(deck.deal());
		dealer.addCard(deck.deal());
		dealer.addCard(deck.deal());
		ai1.addCard(deck.deal());
		ai1.addCard(deck.deal());
		ai2.addCard(deck.deal());
		ai2.addCard(deck.deal());
	}

	/*****************************************************************
	 * sets user hit to true or false depending on input.
	 * 
	 * @param hit sets userHit in player to true or false
	 *****************************************************************/
	public void hitOrStay(boolean hit) {
		player1.userHit(hit);
	}

	/*****************************************************************
	 * checks if both player and dealer have stayed, if the player or dealer
	 * have busted, or if the player or dealer has reached 21, and returns a
	 * boolean value.
	 * 
	 * @return returns true if game end circumstance listed above have happened,
	 *         false if they haven't and game keeps going
	 *****************************************************************/
	public boolean stayBustWin() {

		if (player1.getUserHit() == false && dealer.getUserHit() == false) {
			return true;
		}

		if (player1.playerBust() == true || dealer.playerBust() == true) {
			return true;
		}
		if (player1.blackJack() == true || dealer.blackJack() == true) {
			return true;
		}

		if (dealer.playerBust() == true) {
			return true;
		}

		return false;
	}

	/*****************************************************************
	 * Runs through a round of the game, checking if each player has stayed or
	 * busted, and if they haven't deals them a card.
	 * 
	 *****************************************************************/
	public void round() {
		deckCheck();
		if (player1.getUserHit() == true && player1.playerBust() == false) {
			player1.addCard(deck.deal());
		}
		if (dealer.getUserHit() == true && player1.playerBust() == false) {
			if (dealer.playerHit(player1) == true 
					&& dealer.playerBust() == false) {
				dealer.addCard(deck.deal());
			}

			if (dealer.playerBust() == false) {
				if (ai1.aiHit() == true && ai1.playerBust() == false) {
					ai1.addCard(deck.deal());
				}
				if (ai2.aiHit() == true && ai2.playerBust() == false) {
					ai2.addCard(deck.deal());
				}
			}
		}
	}

	/*****************************************************************
	 * prints cards in console, only used for testing purposes.
	 *****************************************************************/
	public void printCards() {
		System.out.print("player hand is");
		player1.printList();
		System.out.print(" " + player1.handValue());
		System.out.println("");
		System.out.print("dealer hand is ");
		dealer.printList();
		System.out.print(" " + dealer.handValue());

	}

	/*****************************************************************
	 * checks the player sent to the method against the dealer, returns true if
	 * player wins, false if dealer wins, redistributes bets accordingly.
	 * 
	 * @param player
	 *            player, the player to check against the dealer
	 * @return True if player has beaten dealer, false if player has lost
	 *         against the dealer.
	 *****************************************************************/
	public Boolean winner(Player player) {
		if (dealer.handValue() == 21) {
			player.playerLose();
			dealer.dealerWin(player.getBet());
			return false;
		}
		if ((player.handValue() > dealer.handValue() 
				&& player.handValue() <= 21)
				|| (dealer.playerBust() == true 
				&& player.playerBust() == false)) {
			player.playerWin();
			dealer.playerLose();
			return true;

		} else if (dealer.handValue() >= player.handValue() 
				|| player.playerBust() == true) {
			player.playerLose();
			dealer.dealerWin(player.getBet());
			return false;
		}
		player.playerLose();
		dealer.dealerWin(player.getBet());
		return false;
	}

	/*****************************************************************
	 * checks if player or dealer has 21.
	 * 
	 * @return returns true if player or dealer has 21, false if not
	 *****************************************************************/
	public boolean check21s() {
		if (player1.blackJack() == true || dealer.blackJack() == true) {
			return true;
		} else {
			return false;
		}
	}

	/*****************************************************************
	 * resets the game, discards player hands, re-makes and 
	 * re-shuffles the deck.
	 *****************************************************************/
	public void reset() {
		player1.getHand().DiscardHand();
		dealer.getHand().DiscardHand();
		ai1.getHand().DiscardHand();
		ai2.getHand().DiscardHand();
		dealer.userHit(true);
		deck = new Deck();
		deck.shuffleDeck();
	}

	/*****************************************************************
	 * Checks if deck is running low on cards, creates new deck 
	 * and re-shuffles if it is.
	 *****************************************************************/
	public void deckCheck() {
		if (deck.getdeckList().size() < 8) {
			deck = new Deck();
			deck.shuffleDeck();
		}
	}

	/*****************************************************************
	 * Resets all points to reset, as if it were a new game.
	 * 
	 *****************************************************************/
	public void pointsReset() {
		player1.setPoints(100);
		dealer.setPoints(500);
		ai1.setPoints(100);
		ai2.setPoints(100);
		reset();
	}

	/*****************************************************************
	 * Returns player1 from game.
	 * 
	 * @return player1
	 *****************************************************************/
	public Player getPlayer1() {
		return player1;
	}

	/*****************************************************************
	 * Returns dealer from game.
	 * 
	 * @return dealer
	 *****************************************************************/
	public Player getdealer() {
		return dealer;
	}

	/*****************************************************************
	 * Returns ai1 from game.
	 * 
	 * @return ai1
	 *****************************************************************/
	public Player getai1() {
		return ai1;
	}

	/*****************************************************************
	 * returns a12 from game.
	 * 
	 * @return ai2
	 *****************************************************************/
	public Player getai2() {
		return ai2;
	}

	/*****************************************************************
	 * Returns deck from game.
	 * 
	 * @return deck
	 *****************************************************************/
	public Deck getDeck() {
		return deck;
	}

}
