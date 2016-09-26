package com.wanjala.blackjack;

import java.util.ArrayList;

public class Hand {
	private int total;
	private ArrayList<Card> cards;
	private int aces;

	public Hand() {
		total = 0;
		cards = new ArrayList<Card>();
		aces = 0;
	}

	public int getTotal() {
		return total;
	}

	public int getTotalCorrectedForAces() {
		int tempAces = aces;
		int tempTotal = total;
		while (tempAces > 0 && tempTotal > 21) {
			tempTotal -= 10;
			tempAces--;
		}
		return tempTotal;
	}

	public boolean isBusted() {
		return getTotalCorrectedForAces() > 21;
	}

	public int getNumberOfAces() {
		return aces;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) {
		cards.add(card);
		this.total += card.getValue();
		if (card.getValue() == 11)
			aces++;
	}

	public void printCards() {
		for (Card card : cards) {
			if (card.getValue() == 11)
				System.out.println("Ace of " + card.getSuit());
			else
				System.out.println(card.getValue() + " of " + card.getSuit());
		}
	}

}
