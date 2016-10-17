package bjPack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BlackJackUnitTest {

	/********************************************************
	 * Test case for hasAce method, seeing if when given a hand containing an ACE, if it returns true.
	 */
	@Test
	public void AceTest(){
		Game game = new Game();
		Card card = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
		List<Card> hand = new ArrayList<Card>();
		hand.add(card);
		assertTrue(game.hasAce(hand));
		
	}
	/********************************************************
	 * Test case for hasAce method, seeing if when a hand DOES NOT have an ACE, if it returns false.
	 */
	@Test
	public void AceTest2(){
		Game game = new Game();
		Card card = new Card(Card.Rank.KING, Card.Suit.HEARTS);
		List<Card> hand = new ArrayList<Card>();
		hand.add(card);
		assertFalse(game.hasAce(hand));
		
	}
	/********************************************************
	 * Test case for dealerHit method, seeing if when the dealer's hand is less than 17, if it will obtain another card
	 */
	@Test
	public void dealerRulesTest(){
		Game game = new Game();
		List<Card> dealerHand = new ArrayList<Card>();
		Card card = new Card(Card.Rank.KING, Card.Suit.HEARTS);
		Card card2 = new Card(Card.Rank.SIX, Card.Suit.HEARTS);
		dealerHand.add(card);
		dealerHand.add(card2);
		assertTrue(game.dealerHit(dealerHand));
	}
	
	/********************************************************
	 * Test case for dealerHit method, seeing if when the dealer's hand is >= 17, if it will NOT obtain another card
	 */
	@Test
	public void dealerRulesTest2(){
		Game game = new Game();
		List<Card> dealerHand = new ArrayList<Card>();
		Card card = new Card(Card.Rank.KING, Card.Suit.HEARTS);
		Card card2 = new Card(Card.Rank.SEVEN, Card.Suit.HEARTS);
		dealerHand.add(card);
		dealerHand.add(card2);
		assertFalse(game.dealerHit(dealerHand));
	}
	
	@Test
	public void gameTest(){
		Game game = new Game();
		Deck deck2 = new Deck();
		List<Card> playerOneHand = new ArrayList<Card>();
		List<Card> dealerHand = new ArrayList<Card>();
		playerOneHand.add(deck2.deal());
		playerOneHand.add(deck2.deal());
		dealerHand.add(deck2.deal());
		dealerHand.add(deck2.deal());
		assertTrue(dealerHand != null);
		assertTrue(playerOneHand != null);
	}
}
