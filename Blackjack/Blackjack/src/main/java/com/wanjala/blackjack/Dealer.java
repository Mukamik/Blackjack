package com.wanjala.blackjack;

import java.util.ArrayList;

public class Dealer {
	private Deck deck;
	private ArrayList<Player> players;
	public Hand hand;
	private String winner;

	public Dealer() {
		deck = new Deck();
		players = new ArrayList<Player>();
		hand = new Hand();
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void hit(Hand hand) {
		hand.addCard(deck.getTopCard());
	}

	public void stand(Player player) {
		// Standing does nothing.
	}

	public void bust(Player player) {
		players.remove(player);
		System.out.println(player.name + " busted.");
	}

	public void printTotal(String name, Hand hand) {
		int aces = hand.getNumberOfAces();
		String message = name + "'s total is " + hand.getTotalCorrectedForAces();
		if (aces >= 0) {
			for (int i = 1; i <= aces; i++)
				message += " or " + (hand.getTotal() - (i * 10));
		}
		System.out.println(message);
	}

	public void dealRound() {
		int highestTotal = 0;
		hit(hand);
		System.out.println("The dealer's visible card is: ");
		hand.printCards();
		
		for (Player player : players) {
			hit(player.hand);
			hit(player.hand);
			System.out.println(player.name + "'s starting hand is");
			player.hand.printCards();
			printTotal(player.name, player.hand);
			while (player.hand.getTotal() < 17){
				hit(player.hand);
				System.out.println(player.name + " chose to hit");
				printTotal(player.name, player.hand);
			}
			System.out.println(player.name + " folds.");
			if(highestTotal < player.hand.getTotalCorrectedForAces() && player.hand.isBusted() == false){
				highestTotal = player.hand.getTotalCorrectedForAces();
				winner = player.name;
			}
		}
		hit(hand);
		while (hand.getTotalCorrectedForAces() < 17)
			hit(hand);
		
		if(hand.getTotalCorrectedForAces() >= highestTotal && hand.isBusted() == false){
			highestTotal = hand.getTotal();
			winner = "The Dealer";
		}
		
		if (hand.isBusted())
			System.out.println("The dealer busts.");
		else
			printTotal("The Dealer", hand);
	}
	
	public String getGameResult(){
		return winner + " wins with " + hand.getTotal() +" points.";
	}

}
