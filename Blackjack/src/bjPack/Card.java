/***************************************************************************
* Card() - used to create card object for use within the game. Objects will 
* store two main variable: value - a String, holds the value used to 
* calculate points in a certain hand; suit - a String, holds the suit of 
* the card. 
* @author Logan Crowe, Edward Johnson, Anthony Dowling
***************************************************************************/

package bjPack;



/***************************************************************************
* Card() - used to create card object for use within the game. Objects will 
* store two main variable: value - a String, holds the value used to 
* calculate points in a certain hand; suit - a String, holds the suit of 
* the card. 
* @author Logan Crowe, Edward Johnson, Anthony Dowling
***************************************************************************/
public class Card {
	/** enumerated Rank values. */
	public enum Rank {
		/** card value for two. */
		TWO, 
		/** card value for three. */
		THREE, 
		/** card value for four. */
		FOUR, 
		/** card value for five. */
		FIVE, 
		/** card value for six. */
		SIX, 
		/** card value for seven. */
		SEVEN, 
		/** card value for eight. */
		EIGHT, 
		/** card value for nine. */
		NINE,
		/** card value for ten. */
		TEN, 
		/** card value for jack. */
		JACK, 
		/** card value for queen. */
		QUEEN, 
		/** card value for king. */
		KING, 
		/** card value for ace. */
		ACE
	}

	/** enumerated Suit values. */
	public enum Suit {
		/** card value for clubs. */
		CLUBS, 
		/** card value for diamonds. */
		DIAMONDS, 
		/** card value for hearts. */
		HEARTS, 
		/** card value for spades. */
		SPADES
	}

	/** variable for objects Rank. */
	private final Rank value;
	/** variable for objects Suit. */
	private final Suit suit;
	/** string filename corresponding to card icon. */
	private String filename;

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
	 *  @param filename
	 *  	filename for the card
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
	 * 
	 * @return returns value and suit in form of string
	 *********************************************************************/
	public String toString() {
		return value + " of " + suit;
	}
	
	/** Returns filename.
	 * 
	 * @return filename String for card's filename.
	 */
	public String getfilename() {
		return filename;
	}
}