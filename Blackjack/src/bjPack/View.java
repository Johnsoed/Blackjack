package bjPack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*****************************************************************
 * GUI class for blackjack game, displays cards for human player,
 * computer dealer, and two ai opponents, allows player to control
 * game through button presses. Has hit button, stay button, 
 * and reset button
 * @author  Edward Johnson
 * @version December 8th, 2016
*****************************************************************/
public class View extends JPanel {
	/** placeholder icon for empty spot on table. */
   private ImageIcon back = new ImageIcon("src/cards/blank.png");
	/** new blackjack game object. */
	private Game newGame = new Game();
	/** panel where buttons are place. */
	private JPanel buttonPanel = new JPanel();
	/** panel for player and dealer, and their points. */
	private JPanel gamePanel = new JPanel(new BorderLayout());
	/** panel to display players's card hand. */
	private JPanel playerCards = new JPanel();
	/** panel for dealer's card hand. */
	private JPanel dealerCards = new JPanel();
	/** panel to display ai1's cards. */
	private JPanel ai1Cards = new JPanel();
	/** panel to display ai2's cards. */
	private JPanel ai2Cards = new JPanel();
	/** name label for ai 1. */
	private JLabel ai1Name = new JLabel("Ai 1");
	/** name label for ai 2. */
	private JLabel ai2Name = new JLabel("Ai 2");
	/** JLabel array for player's hand. */
	private JLabel[] playersHand = new JLabel[8];
	/** JLabel array for dealer's hand. */
	private JLabel[] dealersHand = new JLabel[8];
	/** JPanel for 2 AI players. */
	private JPanel aiPlayers = new JPanel(new BorderLayout());
	/** JLabel array for ai 1's hand. */
	private JLabel[] ai1Hand = new JLabel[8];
	/** JLabel array for ai 2's hand. */
	private JLabel[] ai2Hand = new JLabel[8];
	/** JLabel for player 1's points. */
	private JLabel playerPoints = new JLabel();
	/** JLabel for dealer's points. */
	private JLabel dealerPoints = new JLabel();
	/** JLabel for ai 1's points. */
	private JLabel ai1Points = new JLabel();
	/** JLabel for ai 2's points. */
	private JLabel ai2Points = new JLabel();
	/** Jbutton for hitting. */
	private JButton hitButton = new JButton();
	/** JButton for staying. */
	private JButton stayButton = new JButton();
	/** JButton to restart game. */
	private JButton restart = new JButton();
	/** JLabel for dealer name. */
	private JLabel dealerName = new JLabel("dealer");
	private /** Jlabel for player name. */
	JLabel playerName = new JLabel("player");

	
	/*****************************************************************
	 * Constructor for view class, sets up panels, texts for buttons,
	 * and background color, initial deal and check for the game.
	*****************************************************************/
	public View() {
		//sets color for panels
		buttonPanel.setBackground(new Color(0, 122, 0));
		playerCards.setBackground(new Color(0, 122, 0));
		dealerCards.setBackground(new Color(0, 122, 0));
		ai1Cards.setBackground(new Color(0, 122, 0));
		ai2Cards.setBackground(new Color(0, 122, 0));
		buttonPanel.setLayout(new FlowLayout());
		restart.setText("restart");
		hitButton.setText("hit");
		stayButton.setText("stay");
		restart.addActionListener(new restart());
		hitButton.addActionListener(new hitButton());
		stayButton.addActionListener(new stayButton());
		buttonPanel.add(hitButton);
		buttonPanel.add(stayButton);
		buttonPanel.add(restart);
		JPanel mainPanel = new JPanel(new BorderLayout());
		for (int i = 0; i < 8; i++) {
			playersHand[i] = new JLabel(back);
			playersHand[i].setPreferredSize(new Dimension(72, 96));
			playerCards.add(playersHand[i]);
		}
		playerCards.add(playerName);
		for (int i = 0; i < 8; i++) {
			dealersHand[i] = new JLabel(back);
			dealersHand[i].setPreferredSize(new Dimension(72, 96));
			dealerCards.add(dealersHand[i]);
		}

		for (int i = 0; i < 8; i++) {
			ai1Hand[i] = new JLabel(back);
			ai1Hand[i].setPreferredSize(new Dimension(72, 96));
			ai1Cards.add(ai1Hand[i]);
		}

		for (int i = 0; i < 8; i++) {
			ai2Hand[i] = new JLabel(back);
			ai2Hand[i].setPreferredSize(new Dimension(72, 96));
			ai2Cards.add(ai2Hand[i]);
		}

		dealerCards.add(dealerName);
		ai1Cards.add(ai1Name);
		ai2Cards.add(ai2Name);

		playerPoints.setText("" + newGame.getPlayer1().getPoints());
		dealerPoints.setText("" + newGame.getdealer().getPoints());

		ai1Points.setText("" + newGame.getai1().getPoints());
		ai2Points.setText("" + newGame.getai2().getPoints());
		playerCards.add(playerPoints);
		dealerCards.add(dealerPoints);
		ai1Cards.add(ai1Points);
		ai2Cards.add(ai2Points);

		add(mainPanel);
		mainPanel.add(gamePanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.NORTH);
		gamePanel.add(playerCards, BorderLayout.CENTER);
		gamePanel.add(dealerCards, BorderLayout.SOUTH);
		aiPlayers.add(ai1Cards, BorderLayout.CENTER);
		aiPlayers.add(ai2Cards, BorderLayout.SOUTH);
		mainPanel.add(aiPlayers, BorderLayout.SOUTH);

		reset();
		check();
	}

	/*****************************************************************
	 * Method to view player's hand, uses filenames in cards to pull
	 * the correct image to set as the card's icon, does this for
	 * each card in the hand. 
	*****************************************************************/
	public void playerView() {
		Hand handview = newGame.getPlayer1().getHand();
		int i = 0;
		for (Card card : handview.getihand()) {
			String filename = card.getfilename();
			ImageIcon picture = new ImageIcon("src/cards/" + filename + ".png");
			playersHand[i].setIcon(picture);
			i++;
		}
		for (; i < 8; i++) {
			playersHand[i].setIcon(back);
		}
	}

	/*****************************************************************
	 * 	Method to view dealer's hand, uses filenames in cards to pull
	 * the correct image to set as the card's icon, does this for
	 * each card in the hand. 
	*****************************************************************/
	public void dealerView() {
		Hand handview = newGame.getdealer().getHand();
		int i = 0;
		for (Card card : handview.getihand()) {
			String filename = card.getfilename();
			ImageIcon picture = new ImageIcon("src/cards/" + filename + ".png");
			dealersHand[i].setIcon(picture);
			i++;
		}
		for (; i < 8; i++) {
			dealersHand[i].setIcon(back);
		}
	}

	/*****************************************************************
	 * Method to view dealer's hand, uses filenames in cards to pull
	 * the correct image to set as the card's icon, does this for
	 * each card in the hand. 
	 * 
	 * @param ai AI player to display cards for
	 * 
	 * @param aiHand JLabel array to update
	*****************************************************************/
	public void aiView(Player ai, JLabel[] aiHand) {
		Hand handview = ai.getHand();
		int i = 0;
		for (Card card : handview.getihand()) {
			String filename = card.getfilename();
			ImageIcon picture = new ImageIcon("src/cards/" + filename + ".png");
			aiHand[i].setIcon(picture);
			i++;
		}
		for (; i < 8; i++) {
			aiHand[i].setIcon(back);
		}
	}

	/*****************************************************************
	 * 	Resets the game, starts new round, deals new cards, sets points
	 * back to default.
	*****************************************************************/
	public void reset() {

		playerPoints.setText("" + newGame.getPlayer1().getPoints());
		dealerPoints.setText("" + newGame.getdealer().getPoints());

		ai1Points.setText("" + newGame.getai1().getPoints());
		ai2Points.setText("" + newGame.getai2().getPoints());
		newGame.reset();
		newGame.initialDeal();

		playerView();
		dealerView();
		aiView(newGame.getai1(), ai1Hand);
		aiView(newGame.getai2(), ai2Hand);
	}

	/*****************************************************************
	 * checks if player or dealer has 21 at the start of the game, 
	 * if so, triggers the end of the game.
	*****************************************************************/
	public void check() {
		if (newGame.check21s() == true) {
			endOfGame();
		}
	}

	/*****************************************************************
	action listener object for the restart button.
	*****************************************************************/
	private class restart implements ActionListener {
		@Override
	/*****************************************************************
	 * resets game upon getting signal from reset button
	 * @params ActionEvent arg0, signal from button listener
	*****************************************************************/
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == restart) {
				newGame.pointsReset();
				reset();

			}

		}

	}

	
	/*****************************************************************
	 * action listener object for the hit button.
	*****************************************************************/
	private class hitButton implements ActionListener {
		@Override
	/*****************************************************************
	 * performs "hit" when player clicks the hit button, player draws 
	 * a new card, and the computer controller players take their turns
	 * 	as well, checks if game has ended it calls the game end
	 * 	method if it has.
	 * @param ActionEvent arg0, signal from button listener
	*****************************************************************/
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == hitButton) {
				newGame.hitOrStay(true);
				newGame.round();
				playerView();
				dealerView();
				aiView(newGame.getai1(), ai1Hand);
				aiView(newGame.getai2(), ai2Hand);
				Boolean endGame = newGame.stayBustWin();
				if (endGame == true) {
					endOfGame();

				}
			}
		}

	}

	/*****************************************************************
	 * 	action listener object for the stay button.
	*****************************************************************/
	private class stayButton implements ActionListener {
		@Override
	/*****************************************************************
	 * performs "stay" when the player clicks the stay button. 
	 * The player no longer draws new cards and the game goes on 
	 * automatically afterwords until dealer has won or lost. 
	 * @param ActionEvent arg0, signal from button listener
	*****************************************************************/
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == stayButton) {
				while (true) {
					newGame.hitOrStay(false);
					newGame.round();
					playerView();
					dealerView();
					aiView(newGame.getai1(), ai1Hand);
					aiView(newGame.getai2(), ai2Hand);
					Boolean endGame = newGame.stayBustWin();
					if (endGame == true) {
						endOfGame();
						break;

					}
				}
			}
		}
	}

	/*****************************************************************
	 * in case of game over, this method is called to display who wins 
	 * and loses, redistribute points, and reset the game. 
	*****************************************************************/
	public void endOfGame() {
		Boolean message = newGame.winner(newGame.getPlayer1());
		if (message == true) {
			JOptionPane.showMessageDialog(
					null, "player one has beaten the dealer");
		}
		if (message == false) {
			JOptionPane.showMessageDialog(
					null, "player one has lost to the dealer");
		}

		message = newGame.winner(newGame.getai1());
		if (message == true) {
			JOptionPane.showMessageDialog(
					null, "ai one has beaten the dealer");
		}
		if (message == false) {
			JOptionPane.showMessageDialog(
					null, "ai one has lost to the dealer");
		}

		message = newGame.winner(newGame.getai2());
		if (message == true) {
			JOptionPane.showMessageDialog(null, "ai two has beaten the dealer");
		}
		if (message == false) {
			JOptionPane.showMessageDialog(
					null, "ai two has lost to the dealer");
		}
		reset();
		for (int i = 0; i < 5; i++) {
			check();
		}
	}

}
