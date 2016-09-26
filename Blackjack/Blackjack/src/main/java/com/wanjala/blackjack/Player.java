package com.wanjala.blackjack;

public class Player {
	public Hand hand;
	public String name;

	public Player() {
		hand = new Hand();
	}

	public void setName(String name) {
		this.name = name;
	}

	public int takeTurn(int turn) {
		return turn;
	}
}
