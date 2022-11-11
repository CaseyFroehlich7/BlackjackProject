package com.skilldistillery.cardgame;

import java.util.List;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand {

// concrete class
// child of hand
	//call child to call parents constructor (implicit)
	

	
	public BlackjackHand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void getHandValue(List<Card> numCards, int value) {
		for (Card card : numCards) {
			System.out.println(card);
		}
		System.out.println("Value of hand: " + value);
		
	}

	public boolean isBlackjack() {
		return false;
		
	}
	
	public boolean isBust() {
		return false;
		
	}
}
