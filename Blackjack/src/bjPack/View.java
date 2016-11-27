package bjPack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class View extends JFrame{
	
	private static Scanner input;

	public static void main(String args[]){
		
		input = new Scanner(System.in);
		
		System.out.println("How many AI players do you want?(0-4)");
		int aiPlayerNum = Integer.parseInt(input.next());
		
		Game game = new Game(aiPlayerNum);
		
		while(!game.isRoundOver()){
			game.initialDeal();
			dealerInfoConcealed(game);
			userInfo(game);
			//System.out.println("Number of AI's: " + aiPlayerNum);
			if(aiPlayerNum > 0){
				//System.out.println("test");
				int playerNum = 1;
				for(Player aiPlayer: game.getAiPlayers()){//##doesn't work yet##
					System.out.println("Player #" + playerNum++ + "'s Hand:");
					aiPlayer.printHand();
				}
			}
			boolean userTurn = true;
			while(userTurn && !game.user.playerBust()){
				game.user.bet();
				System.out.println("Do you want to hit or stay?");
				System.out.println("<Type h to hit>");
				String userHitStay = input.next();
				if(userHitStay.equals("h")){
					game.userHitStay(true);
					userInfo(game);
					
				}
				else{
					userTurn = false;
				}
			}
			dealerInfoConcealed(game);
			userInfo(game);
			
			game.dealerHitStay();
			//AI Hit/Stay
			
			System.out.println("####Final hands####");
			dealerInfo(game);
			userInfo(game);
			
			game.setWinLoss();
			
			System.out.println("####RESULTS####");
			System.out.print("#User: " + game.user.getEndMessage() + " #Points: " + game.user.getPoints());
			
			game.setRoundOver(true);
		}
		
	}
	
	
	//move these to Game() or Player()
	public static void userInfo(Game game){
		System.out.println("Your Hand:");
		game.user.printHand();
		System.out.println("Your Score: " + game.user.handValue());
	}
	public static void dealerInfo(Game game){
		System.out.println("Dealer's Hand:");
		game.dealer.printHand();
		System.out.println("Dealer Score: " + game.dealer.handValue());
	}
	public static void dealerInfoConcealed(Game game){
		System.out.println("Dealer's Hand:");
		game.dealer.dealerPrintConcealed();
	}
	
	
	//user frame
//	JFrame userFrame;
//	//dealer panel
//	JPanel dealerPanel;
//	//aiPlayer panels
//	JPanel aiPanel1;
//	JPanel aiPanel2;
//	JPanel aiPanel3;
//	JPanel aiPanel4;
//	//menu items
//	JMenuBar menuBar;
//	JMenu menu;
//	JMenuItem newGame;
//	JMenuItem quitGame;
//	//user buttons
//	JButton hit;
//	JButton stay;
//	
//
//	public View(){
//		game = new Game();
//		userFrame = new JFrame();
//		dealerPanel = new JPanel();
//		for(int i = 0; i == game.getAiPlayers().size(); i++){
//			//instantiate aiPanels?
//		}
//		//instantiate menu and menu items
//		menuBar = new JMenuBar();
//		menu = new JMenu("File");
//		newGame = new JMenuItem("New Game");
//		quitGame = new JMenuItem("Quit Game");
//		//add menu and menu items
//		menuBar.add(menu);
//		menu.add(newGame);
//		menu.add(quitGame);
//		//add menu bar to user frame
//		userFrame.setJMenuBar(menuBar);
//		//action for quit game menu option
//		quitGame.addActionListener((ActionEvent event) -> {	 
//		        System.exit(0);
//		 });
//		
//	}
	

	   
	   
	//move main to here
	
	//setup a game
	
	//views for players/AI
	
	//
}
