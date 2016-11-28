package bjPack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class View extends JFrame{
	
	private static Scanner input;
	JPanel topPanel = new JPanel();
	JPanel dcardPanel = new JPanel();
	JPanel pcardPanel = new JPanel();
	JTextPane winlosebox = new JTextPane();
	JButton hitbutton = new JButton();
	JButton dealbutton = new JButton();
	JButton staybutton = new JButton();
	JButton playagainbutton = new JButton();
	JLabel dealerlabel = new JLabel();
	JLabel playerlabel = new JLabel();

	Game game = new Game(); 

	/*************************************************************
    the labels to represent the cards for the game
	*************************************************************/
    JLabel playercard1;
    JLabel playercard2;
    JLabel playercardhit;
    JLabel dealercard0;
    JLabel dealercard1;
    JLabel dealercard2;
    JLabel dealercardhit;

    /*************************************************************
     Constructs the screen
    *************************************************************/
    public View(){  
	    
	    topPanel.setBackground(new Color(0, 122, 0));
	    dcardPanel.setBackground(new Color(0, 122, 0));
	    pcardPanel.setBackground(new Color(0, 122, 0));
	    
	    topPanel.setLayout(new FlowLayout());
	    winlosebox.setText(" ");
	    winlosebox.setFont(new java.awt.Font("Helvetica Bold", 1, 20));
	    dealbutton.setText("  Deal");
	    dealbutton.addActionListener(new dealbutton());
	    hitbutton.setText("  Hit");
	    hitbutton.addActionListener(new hitbutton());
	    hitbutton.setEnabled(false);
	    staybutton.setText("  Stay");
	    staybutton.addActionListener(new staybutton());   
	    staybutton.setEnabled(false);
	    playagainbutton.setText("  Play Again");
	    playagainbutton.addActionListener(new playagainbutton());
	    playagainbutton.setEnabled(false); 
	    
	    dealerlabel.setText("  Dealer:  ");
	    playerlabel.setText("  Player:  ");

	    topPanel.add(winlosebox);
	    topPanel.add(dealbutton);
	    topPanel.add(hitbutton);
	    topPanel.add(staybutton);
	    topPanel.add(playagainbutton);
	    pcardPanel.add(playerlabel);
	    dcardPanel.add(dealerlabel);
	    
	    setLayout(new BorderLayout());
	    add(topPanel,BorderLayout.NORTH);
	    add(dcardPanel,BorderLayout.CENTER);
	    add(pcardPanel,BorderLayout.SOUTH);
	    
	  }//end BlackjackGUI 

	  /*************************************************************
	     Shows the screen
	  *************************************************************/
	  public void display() 
	  {
	    JFrame myFrame = new JFrame("BlackJack");
	    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    myFrame.setContentPane(this);
	    myFrame.setPreferredSize(new Dimension(700,550));

	    //Display the window.
	    myFrame.pack();
	    myFrame.setVisible(true);
	    
	  }//end display

	/*************************************************************
	   DealButton
	   @param e Deal button pressed
	*************************************************************/
	class dealbutton implements ActionListener { 
	  public void actionPerformed(ActionEvent e) {

	    dcardPanel.add(dealerlabel);
	    pcardPanel.add(playerlabel);

	   /**
	      Get's dealer and player cards from Hand
	       and the image associated with that random
	       card and puts them on the screen.
	   */
	    
	    dealercard0 = new JLabel(new ImageIcon("back.jpg"));

	    game.initialDeal();

//	    //to iterate set and get current dealer cards
//	    Card dcard=null;
//	    Iterator<Card> dscan = (dealer.inHand).iterator();
//	    int count = 0;
//	    while (dscan.hasNext())
//	    {
//	        dcard = dscan.next();
//	        if(count==0)
//	          dealercard1 = new JLabel(dcard.getimage());
//	        else 
//	          dealercard2 = new JLabel(dcard.getimage());
//	          
//	        count++;
//	    }
//
//	    //to iterate set and get current player cards
//	    Iterator<Card> pscan = (player.inHand).iterator();
//	    count = 0;
//	    while (pscan.hasNext())
//	    {
//	       Card pcard = pscan.next();
//	       if(count==0)
//	         playercard1 = new JLabel(pcard.getimage());
//	       else
//	         playercard2 = new JLabel(pcard.getimage());
//	   
//	       count++;
//	    }
	 
	    dcardPanel.add(dealercard0);
	    dcardPanel.add(dealercard2);
	 
	    pcardPanel.add(playercard1);
	    pcardPanel.add(playercard2);
	    
	    dealerlabel.setText("  Dealer:  "+ game.dealer.getHand().handCount());
	    playerlabel.setText("  Player:  " + game.user.getHand().handCount());
	    
	    hitbutton.setEnabled(true);
	    staybutton.setEnabled(true);
	    dealbutton.setEnabled(false);

//	    if(game.blackj())     
//	     {
//	       hitbutton.setEnabled(false);
//	       staybutton.setEnabled(false);
//	       dealbutton.setEnabled(false);
//	       playagainbutton.setEnabled(true);
//	       winlosebox.setText("BlackJack");
//	     }

	    add(dcardPanel,BorderLayout.CENTER);
	    add(pcardPanel,BorderLayout.SOUTH);

	  }
	}//end dealbutton

	/*************************************************************
	   HitButton
	    every time the player wants another card
	    until hand value is over 21.
	   @param e Hit button pressed
	*************************************************************/
	class hitbutton implements ActionListener { 
	  public void actionPerformed(ActionEvent e) {

	    
	    Card hitcard = game.getMainDeck().deal();
	    playercardhit = new JLabel(hitcard.getimage());
	    pcardPanel.add(playercardhit);
	    pcardPanel.repaint();
	 
	    if(game.bust(player))     
	    {
	      winlosebox.setText("Bust");
	      hitbutton.setEnabled(false);
	      dealbutton.setEnabled(false);
	      staybutton.setEnabled(false);
	      playagainbutton.setEnabled(true);
	    }

	    playerlabel.setText("  Player:   " + game.handValue(player));

	  }
	}//end hitbutton

	/*************************************************************
	   StayButton
	    dealer must hit on 16 or lower. determines the winner, 
	    player wins if under 21 and above dealer. 
	    Tie goes to dealer.
	   @param e Stay button pressed
	*************************************************************/
	class staybutton implements ActionListener { 
	  public void actionPerformed(ActionEvent e) {
	    
	    dcardPanel.remove(dealercard0);
	    dcardPanel.add(dealercard1);

	    dealer = game.dealerPlays();
	    dcardPanel.removeAll();
	    dcardPanel.add(dealerlabel);
	    dealerlabel.setText(" " + dealerlabel.getText());  
	    
	    //iterate through cards and re-display
	    Card dhitcard = null;
	    Iterator<Card> scan = (dealer.inHand).iterator();
	    while (scan.hasNext())
	    {
	        dhitcard = scan.next();
	        dealercardhit = new JLabel(dhitcard.getimage());
	        dcardPanel.add(dealercardhit);
	    }
	    
	    dealerlabel.setText("Dealer: " + game.handValue(dealer));
	    playerlabel.setText("Player: " + game.handValue(player));

	    winlosebox.setText(game.winner());
	    hitbutton.setEnabled(false);
	    staybutton.setEnabled(false);
	    
	    playagainbutton.setEnabled(true);

	  }
	}//end staybutton

	/*************************************************************
	   PlayAgainButton
	    resets screen
	   @param e Play Again button pressed
	*************************************************************/
	class playagainbutton implements ActionListener { 
	  public void actionPerformed(ActionEvent e) {

	    dealerlabel.setText("Dealer: ");
	    playerlabel.setText("Player: ");
	    winlosebox.setText(""); 
	    dealer = new Hand();
	    player = new Hand();
	    game=new Blackjack(dealer, player);

	    dcardPanel.removeAll();
	    pcardPanel.removeAll();

	    hitbutton.setEnabled(false);
	    staybutton.setEnabled(false);
	    playagainbutton.setEnabled(false);
	    dealbutton.setEnabled(true);

	  }
	}//end playagainbutton
	}//end BlackjackGUI
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//user frame
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
//	public static void main(String args[]){
//		View view = new View();
//	}
//
//	public View(){
//		
////		Game game = new Game();
//		userFrame = new JFrame();
//		dealerPanel = new JPanel();
////		for(int i = 0; i == game.getAiPlayers().size(); i++){
////			//instantiate aiPanels?
////		}
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
	
//	public static void main(String args[]){
//		
//		input = new Scanner(System.in);
//		
//		System.out.println("How many AI players do you want?(0-4)");
//		int aiPlayerNum = Integer.parseInt(input.next());
//		
//		Game game = new Game(aiPlayerNum);
//
//		while(!game.isRoundOver()){
//			game.initialDeal();
//			dealerInfoConcealed(game);
//			userInfo(game);
//			if(aiPlayerNum > 0){
//				int playerNum = 1;
//				//System.out.println("AIPlayer #1:");
//				//game.aiPlayers.get(1).getHand();		
//				for(Player aiPlayer: game.aiPlayers){
//					System.out.println("Player #" + playerNum++ + "'s Hand:");
//					aiPlayer.printHand();
//				}
//			}
//			boolean userTurn = true;
//			while(userTurn && !game.user.playerBust()){
//				game.user.bet();
//				System.out.println("Do you want to hit or stay?");
//				System.out.println("<Type h to hit>");
//				String userHitStay = input.next();
//				if(userHitStay.equals("h")){
//					game.userHitStay(true);
//					userInfo(game);
//					
//				}
//				else{
//					userTurn = false;
//				}
//			}
//			dealerInfoConcealed(game);
//			userInfo(game);
//			
//			game.dealerHitStay();
//			game.aiHitStay();
//			
//			System.out.println("####Final hands####");
//			dealerInfo(game);
//			userInfo(game);
//			
//			game.setWinLoss();
//			
//			System.out.println("####RESULTS####");
//			System.out.print("#User: " + game.user.getEndMessage() + " #Points: " + game.user.getPoints());
//			
//			game.setRoundOver(true);
//		}
//		
//	}
//	
//	
//	//move these to Game() or Player()
//	public static void userInfo(Game game){
//		System.out.println("Your Hand:");
//		game.user.printHand();
//		System.out.println("Your Score: " + game.user.handValue());
//	}
//	public static void dealerInfo(Game game){
//		System.out.println("Dealer's Hand:");
//		game.dealer.printHand();
//		System.out.println("Dealer Score: " + game.dealer.handValue());
//	}
//	public static void dealerInfoConcealed(Game game){
//		System.out.println("Dealer's Hand:");
//		game.dealer.dealerPrintConcealed();
//	}
	   
	   
	//move main to here
	
	//setup a game
	
	//views for players/AI
	
	//
}
