package com.skilldistillery.players;

import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.cards.Deck;

public class Dealer extends Player {
	Deck deck = new Deck();
	BlackjackHand hand = new BlackjackHand();
	
	public Dealer() {
		deck.shuffle();
		deck.createDeck();
		deck.checkDeckSize();
		
	}
	
	public BlackjackHand getHand() {
		return hand;
	}
	
}
