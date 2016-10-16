/***************************************************************************
* Card() - used to create card object for use within the game. Objects will 
* store two main variable: value - a String, holds the value used to 
* calculate points in a certain hand; suit - a String, holds the suit of 
* the card. 
* @author Logan Crowe, Edward Johnson, Anthony Dowling
***************************************************************************/
package bjPack;

import java.util.*;

public class Card {
	
	public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN,
		EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }
	
	public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
	
	private final Rank value;
	private final Suit suit;

   /***********************************************************************
	* Constructors
	**********************************************************************/
	
    public Card(Rank value, Suit suit) {
		super();
		this.value = value;
		this.suit = suit;
	}

   /***********************************************************************
	* Getters and Setters
	**********************************************************************/	
    public Rank rank() {return value;}
    public Suit suit() {return suit;}
    public String toString() {return value + " of " + suit;}


}