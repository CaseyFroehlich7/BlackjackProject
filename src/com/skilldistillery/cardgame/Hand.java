package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	
	private int value;
	
	List<Card> numCards = new ArrayList<>();
	
	public Hand() {
		System.out.println("add text");
	}
	
	public void addCard(Card card) {
		Hand.add(card);
		
	}
	
	public void clear() {
		
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand [numCards=" + numCards + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numCards);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		return Objects.equals(numCards, other.numCards);
	}

}
