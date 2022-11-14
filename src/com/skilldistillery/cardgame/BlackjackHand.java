package com.skilldistillery.cardgame;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand {

// concrete class
// child of hand
//call child to call parents constructor (implicit)

	public BlackjackHand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getHandValue() {
		int handValue = 0;
		for(int i = 0; i < hand.size(); i++) {
			handValue += hand.get(i).getValue();
		}
		 return handValue;
	}
	
	public void addCard(Card card) {
		this.hand.add(card);
	}
	public void clear() {
		hand.clear();
		System.out.println("Played cards cleared.");
	}

	public boolean gotBlackjack() {
		boolean result = false;
		if(getHandValue() == 21) {
			result = true;
		}
		return result;
	}
	
	public boolean didYouBust() {
		boolean result = false;
		if(getHandValue() > 21) {
			result = true;
		}
		return result;
	}


	
}
