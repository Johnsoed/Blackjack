package bjPack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class View extends JPanel{
ImageIcon back = new ImageIcon("src/cards/blank.png");
Game newGame = new Game();

JPanel buttonPanel = new JPanel();
JPanel gamePanel = new JPanel(new BorderLayout());
JPanel playerCards = new JPanel();
JPanel dealerCards = new JPanel();
JPanel scorePanel = new JPanel();
JPanel ai1Cards = new JPanel();
JPanel ai2Cards = new JPanel();
JLabel ai1Name = new JLabel("Ai 1");
JLabel ai2Name = new JLabel("Ai 2");

JLabel[] playersHand = new JLabel[8];
JLabel[] dealersHand = new JLabel [8];
JPanel aiPlayers = new JPanel(new BorderLayout());
JLabel[] ai1Hand = new JLabel [8];
JLabel[] ai2Hand = new JLabel [8];
JLabel playerPoints = new JLabel();
JLabel dealerPoints = new JLabel();
JLabel ai1Points = new JLabel();
JLabel ai2Points = new JLabel();

JButton hitButton = new JButton(); 
JButton stayButton = new JButton();
JButton restart = new JButton();
JLabel dealerName = new JLabel("dealer");
JLabel playerName = new JLabel("player");

public View() {
buttonPanel.setBackground(new Color(0,122,0));
playerCards.setBackground(new Color(0,122,0));
dealerCards.setBackground(new Color(0,122,0));
ai1Cards.setBackground(new Color(0,122,0));
ai2Cards.setBackground(new Color(0,122,0));
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
for (int i = 0; i  < 8; i++) {
	playersHand[i] = new JLabel(back);
	playersHand[i].setPreferredSize(new Dimension(72,96));
	playerCards.add(playersHand[i]);
}
playerCards.add(playerName);
for (int i = 0; i  < 8; i++) {
	dealersHand[i] = new JLabel(back);
	dealersHand[i].setPreferredSize(new Dimension(72,96));
	dealerCards.add(dealersHand[i]);
}

for (int i = 0; i  < 8; i++) {
	ai1Hand[i] = new JLabel(back);
	ai1Hand[i].setPreferredSize(new Dimension(72,96));
	ai1Cards.add(ai1Hand[i]);
}

for (int i = 0; i  < 8; i++) {
	ai2Hand[i] = new JLabel(back);
	ai2Hand[i].setPreferredSize(new Dimension(72,96));
	ai2Cards.add(ai2Hand[i]);
}



dealerCards.add(dealerName);
ai1Cards.add(ai1Name);
ai2Cards.add(ai2Name);

playerPoints.setText("" + newGame.player1.points);
dealerPoints.setText("" + newGame.dealer.points);

ai1Points.setText("" + newGame.ai1.points);
ai2Points.setText("" + newGame.ai2.points);
playerCards.add(playerPoints);
dealerCards.add(dealerPoints);
ai1Cards.add(ai1Points);
ai2Cards.add(ai2Points);



add (mainPanel);
mainPanel.add(gamePanel,BorderLayout.CENTER);
mainPanel.add(buttonPanel,BorderLayout.NORTH);
gamePanel.add(playerCards,BorderLayout.CENTER);
gamePanel.add(dealerCards,BorderLayout.SOUTH);
aiPlayers.add(ai1Cards,BorderLayout.CENTER);
aiPlayers.add(ai2Cards,BorderLayout.SOUTH);
mainPanel.add(aiPlayers,BorderLayout.SOUTH);


reset();
check();
}	

public void playerView() {
	Hand handview = newGame.player1.hand;
	int i = 0;
	for (Card card :handview.ihand) {
		String filename = card.filename;
		ImageIcon picture = new ImageIcon("src/cards/" + filename + ".png");
		playersHand[i].setIcon(picture);
		i++;
		}
	for (;i < 8; i++) {
		playersHand[i].setIcon(back);
	}
	}
	public void dealerView() {
		Hand handview = newGame.dealer.hand;
		int i = 0;
		for (Card card :handview.ihand) {
			String filename = card.filename;
			ImageIcon picture = new ImageIcon("src/cards/" + filename + ".png");
			dealersHand[i].setIcon(picture);
			i++;
		}	
		for (;i < 8; i++) {
			dealersHand[i].setIcon(back);
		}	
}
	
	
	public void aiView(Player ai, JLabel[] aiHand) {
		Hand handview = ai.hand;
		int i = 0;
		for (Card card :handview.ihand) {
			String filename = card.filename;
			ImageIcon picture = new ImageIcon("src/cards/" + filename + ".png");
			aiHand[i].setIcon(picture);
			i++;
		}	
		for (;i < 8; i++) {
			aiHand[i].setIcon(back);
		}	
}
	
	
public  void reset() {
	
	playerPoints.setText("" + newGame.player1.points);
	dealerPoints.setText("" + newGame.dealer.points);

	ai1Points.setText("" + newGame.ai1.points);
	ai2Points.setText("" + newGame.ai2.points);
		newGame.reset();
		newGame.initialDeal();
		
		playerView();
		dealerView();
		aiView(newGame.ai1,ai1Hand);
		aiView(newGame.ai2,ai2Hand);
	}
	
public void check() {
		if (newGame.check21s() == true) {
			endOfGame();
			reset();
}
	}

private class restart implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == restart) {
			newGame.pointsReset(); 
			reset();
			
		}
		
}
		
}
private class hitButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == hitButton) {
		newGame.hitOrStay(true);
		newGame.round();
		playerView();
		dealerView();
		aiView(newGame.ai1,ai1Hand);
		aiView(newGame.ai2,ai2Hand);
		Boolean endGame = newGame.stayBustWin();
		if (endGame == true) {
			endOfGame();
		
	
		}
		}
}

}
private class stayButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == stayButton) {
		while (true) {
		newGame.hitOrStay(false);
		newGame.round();
		playerView();
		dealerView();
		aiView(newGame.ai1,ai1Hand);
		aiView(newGame.ai2,ai2Hand);
		Boolean endGame = newGame.stayBustWin();
		if (endGame == true) {
			endOfGame();
			break;
		
		
		}

	}
 }
	}
	}


public void endOfGame() {
	Boolean message = newGame.winner(newGame.player1);
	if (message == true){
	JOptionPane.showMessageDialog(null,"player one has beaten the dealer");
	}
	if (message == false) {
		JOptionPane.showMessageDialog(null,"player one has lost to the dealer");
	}

		message = newGame.winner(newGame.ai1);
		if (message == true){
		JOptionPane.showMessageDialog(null,"ai one has beaten the dealer");
		}
		if (message == false) {
			JOptionPane.showMessageDialog(null,"ai one has lost to the dealer");
		}

		message = newGame.winner(newGame.ai2);
		if (message == true){
		JOptionPane.showMessageDialog(null,"ai two has beaten the dealer");
		}
		if (message == false) {
			JOptionPane.showMessageDialog(null,"ai two has lost to the dealer");
			}
		reset();
		for(int i = 0; i < 5; i++) {
		check();
		}
}




}
