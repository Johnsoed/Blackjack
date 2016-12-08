package bjPack;

import javax.swing.JFrame;

import bjPack.View;

public class BlackJackMain {

	public static void main(String[] args) {
		View newView;
		newView = new View();
		JFrame frame = new JFrame("Blackjack");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(newView);
		frame.pack();
		frame.setVisible(true);

	}

}
