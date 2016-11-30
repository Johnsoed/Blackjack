package bjPack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Scanner;

public class View extends JFrame{
//	public static void main(String args[]) throws IOException{
//		Game game;
////		try {
//			game = new Game();
//			game.initialDeal();
//			ImageIcon playerCard1 = new ImageIcon(game.user.getHand().getCard(0).getImage());
//			ImageIcon playerCard2 = new ImageIcon(game.user.getHand().getCard(1).getImage());
//			JFrame userFrame;
//			userFrame = new JFrame("User Frame");
//			userFrame.setSize(400,300);
//			JPanel userCardPanel = new JPanel();
//			JLabel playerCard1label = new JLabel(playerCard1);
//			JLabel playerCard2label = new JLabel(playerCard2);
//			userCardPanel.add(playerCard1label);
//			userCardPanel.add(playerCard2label);
//			
////		} catch (IOException e) {
////			game = null;
////			e.printStackTrace();
////		}
//		
//		//user frame
//		
//		//dealer panel
//		JFrame dealerFrame;
//		//aiPlayer panels
//		JPanel aiPanel1;
//		JPanel aiPanel2;
//		JPanel aiPanel3;
//		JPanel aiPanel4;
//		//menu items
//		
//		//user buttons
//		JButton hit = new JButton("HIT");
//		hit.setSize(100, 30);
//		hit.setLocation(50,50);
//		JButton stay = new JButton("STAY");
//		stay.setSize(100, 30);
//		stay.setLocation(150, 50);
//
//		dealerFrame = new JFrame("Dealer Frame");
//		
//		
//		JPanel userButtonPanel = new JPanel();
////		userButtonPanel.setOpaque(true);
////		userButtonPanel.setBackground(Color.WHITE);
////		userButtonPanel.setLayout(null);
////		
////		JPanel dealerCardPanel = new JPanel();
//		userButtonPanel.add(hit);
//		userButtonPanel.add(stay);
////		userCardPanel.add(playerCard1label, BorderLayout.CENTER);
//		
////		for(int i = 0; i == game.getAiPlayers().size(); i++){
////			//instantiate aiPanels?
////		}
//		//instantiate menu and menu items
//		menuBar = new JMenuBar();
//		menu = new JMenu("File");
//		newGame = new JMenuItem("New Game");
//		quitGame = new JMenuItem("Quit Game");
//		//add menu and menu items
//		menu.add(newGame);
//		menu.add(quitGame);
//		menuBar.add(menu);
//		
//		//add menu bar to user frame
//		
//		userCardPanel.add(userButtonPanel);
//		
////		userFrame.getContentPane().add(userCardPanel);
////		dealerFrame.getContentPane().add(dealerCardPanel);
//		
//		//action for quit game menu option
//		quitGame.addActionListener((ActionEvent event) -> {	 
//		        System.exit(0);
//		 });
//		userFrame.setJMenuBar(menuBar);
//		//userFrame.add(userButtonPanel);
//		userFrame.add(userCardPanel);
//		dealerFrame.setSize(400,300);
//		userFrame.setSize(400,300);
//		dealerFrame.pack();
//		userFrame.pack();
//		dealerFrame.setVisible(true);
//		userFrame.setVisible(true);
//	}
//	
////	public static void main(String args[]){
////		
////		input = new Scanner(System.in);
////		
////		System.out.println("How many AI players do you want?(0-4)");
////		int aiPlayerNum = Integer.parseInt(input.next());
////		
////		Game game = new Game(aiPlayerNum);
////
////		while(!game.isRoundOver()){
////			game.initialDeal();
////			dealerInfoConcealed(game);
////			userInfo(game);
////			if(aiPlayerNum > 0){
////				int playerNum = 1;
////				//System.out.println("AIPlayer #1:");
////				//game.aiPlayers.get(1).getHand();		
////				for(Player aiPlayer: game.aiPlayers){
////					System.out.println("Player #" + playerNum++ + "'s Hand:");
////					aiPlayer.printHand();
////				}
////			}
////			boolean userTurn = true;
////			while(userTurn && !game.user.playerBust()){
////				game.user.bet();
////				System.out.println("Do you want to hit or stay?");
////				System.out.println("<Type h to hit>");
////				String userHitStay = input.next();
////				if(userHitStay.equals("h")){
////					game.userHitStay(true);
////					userInfo(game);
////					
////				}
////				else{
////					userTurn = false;
////				}
////			}
////			dealerInfoConcealed(game);
////			userInfo(game);
////			
////			game.dealerHitStay();
////			game.aiHitStay();
////			
////			System.out.println("####Final hands####");
////			dealerInfo(game);
////			userInfo(game);
////			
////			game.setWinLoss();
////			
////			System.out.println("####RESULTS####");
////			System.out.print("#User: " + game.user.getEndMessage() + " #Points: " + game.user.getPoints());
////			
////			game.setRoundOver(true);
////		}
////		
////	}
////	
////	
////	//move these to Game() or Player()
////	public static void userInfo(Game game){
////		System.out.println("Your Hand:");
////		game.user.printHand();
////		System.out.println("Your Score: " + game.user.handValue());
////	}
////	public static void dealerInfo(Game game){
////		System.out.println("Dealer's Hand:");
////		game.dealer.printHand();
////		System.out.println("Dealer Score: " + game.dealer.handValue());
////	}
////	public static void dealerInfoConcealed(Game game){
////		System.out.println("Dealer's Hand:");
////		game.dealer.dealerPrintConcealed();
////	}
//	   
//	   
//	//move main to here
//	
//	//setup a game
//	
//	//views for players/AI
//	
//	//
}
