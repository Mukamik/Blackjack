package com.wanjala.blackjack;

/**
 * Hello world!
 *
 */
public class Blackjack {
	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		Player one = new Player();
		Player two = new Player();
		Player three = new Player();
		one.setName("Tom");
		two.setName("Dick");
		three.setName("Harry");
		
		dealer.addPlayer(one);
		dealer.addPlayer(two);
		dealer.addPlayer(three);
		
		
		dealer.dealRound();
		System.out.println(dealer.getGameResult());
		
	}
}
