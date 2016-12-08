/***************************************************************************
* Card() - used to create card object for use within the game. Objects will 
* store two main variable: value - a String, holds the value used to 
* calculate points in a certain hand; suit - a String, holds the suit of 
* the card. 
* @author Logan Crowe, Edward Johnson, Anthony Dowling
***************************************************************************/

package bjPack;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Card {
	/* enumerated Rank values */
	public enum Rank {
		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	/* enumerated Suit values */
	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES
	}

	/* variable for objects Rank */
	private final Rank value;
	/* variable for objects Suit */
	private final Suit suit;

	public String filename;

	/***********************************************************************
	 * Constructors
	 **********************************************************************/
	/**********************************************************************
	 * Card() constructor.
	 * 
	 * @param value
	 *            the rank value of the object
	 * @param suit
	 *            the suit value of the object
	 *********************************************************************/
	public Card(Rank value, Suit suit, String filename) {
		super();
		this.value = value;
		this.suit = suit;
		this.filename = filename;
	}

	/***********************************************************************
	 * Getters and Setters
	 **********************************************************************/
	/**********************************************************************
	 * @return objects rank value
	 *********************************************************************/
	public Rank rank() {
		return value;
	}

	/**********************************************************************
	 * @return objects suit value
	 *********************************************************************/
	public Suit suit() {
		return suit;
	}

	/**********************************************************************
	 * @see java.lang.Object#toString()
	 *********************************************************************/
	public String toString() {
		return value + " of " + suit;
	}
}