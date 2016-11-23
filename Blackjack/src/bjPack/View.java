package bjPack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View extends JFrame{
	
	Game game;
	//user frame
	JFrame userFrame;
	//dealer panel
	JPanel dealerPanel;
	//aiPlayer panels
	JPanel aiPanel1;
	JPanel aiPanel2;
	JPanel aiPanel3;
	JPanel aiPanel4;
	//menu items
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem newGame;
	JMenuItem quitGame;
	//user buttons
	JButton hit;
	JButton stay;
	

	public View(){
		game = new Game();
		userFrame = new JFrame();
		dealerPanel = new JPanel();
		for(int i = 0; i == game.getAiPlayers().size(); i++){
			//instantiate aiPanels?
		}
		//instantiate menu and menu items
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		newGame = new JMenuItem("New Game");
		quitGame = new JMenuItem("Quit Game");
		//add menu and menu items
		menuBar.add(menu);
		menu.add(newGame);
		menu.add(quitGame);
		//add menu bar to user frame
		userFrame.setJMenuBar(menuBar);
		//action for quit game menu option
		quitGame.addActionListener((ActionEvent event) -> {	 
		        System.exit(0);
		 });
		
	}
	

	   
	   
	//move main to here
	
	//setup a game
	
	//views for players/AI
	
	//
}
