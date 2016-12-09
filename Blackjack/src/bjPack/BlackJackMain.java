package bjPack;



import javax.swing.JFrame;

/*****************************************************************
 * Main class for running blackjack game, launches GUI.
 * @author  Edward Johnson, Anthony Dowling, Logan Crowe
 * @version December 8th, 2016
*****************************************************************/
public class BlackJackMain {
	/** main class, launches blackjack gui.
	 * @param args main method args
	 */
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
