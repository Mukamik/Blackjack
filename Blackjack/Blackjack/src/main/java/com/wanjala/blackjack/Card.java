package com.wanjala.blackjack;

public class Card {
	private Suit suit;
	private FaceValue value;
	
	public Card(Suit suit, FaceValue value){
		this.suit = suit;
		this.value = value;
	}
	
	public Suit getSuit(){
		return suit;
	}
	public int getValue(){
		return value.getValue();
	}
}
