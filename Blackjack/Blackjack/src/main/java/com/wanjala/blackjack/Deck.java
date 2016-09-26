package com.wanjala.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	public static final int DECKSIZE = 52;

	public Deck() {
		for (int i = 0; i < 13; i++) {
			cards.add(new Card(Suit.CLUBS, FaceValue.values()[i]));
		}
		for (int i = 0; i < 13; i++) {
			cards.add(new Card(Suit.DIAMONDS, FaceValue.values()[i]));
		}
		for (int i = 0; i < 13; i++) {
			cards.add(new Card(Suit.SPADES, FaceValue.values()[i]));
		}
		for (int i = 0; i < 13; i++) {
			cards.add(new Card(Suit.HEARTS, FaceValue.values()[i]));
		}
		shuffle();
	}

	public Card getTopCard() {
		return cards.remove(0);
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
}
