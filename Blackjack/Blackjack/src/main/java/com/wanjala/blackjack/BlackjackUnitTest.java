package com.wanjala.blackjack;

import static org.junit.Assert.*;

import org.junit.Test;

public class BlackjackUnitTest {

	@Test
	public void totalsShouldBeAbleToHandleSeveralAces(){
		Hand hand = new Hand();
		Card ace = new Card(Suit.SPADES,FaceValue.Ace);
		Card ten = new Card(Suit.HEARTS, FaceValue.Ten);
		hand.addCard(ace);
		assertEquals(hand.getTotal(), hand.getTotalCorrectedForAces()); //Should make no difference under 21
		hand.addCard(ten);
		assertEquals(21, hand.getTotal());
		hand.addCard(ten);
		assertEquals(21, hand.getTotalCorrectedForAces());
	}
	
}
