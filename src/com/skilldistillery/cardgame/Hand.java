package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.skilldistillery.cards.Card;

public abstract class Hand {

	
	List<Card> hand = new ArrayList<>();
	
	public Hand() {
		System.out.println();
	}
	
	public void addCard(Card card) {
	}
	
	public void clear() {
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand [cards=" + hand + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hand);
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
		return Objects.equals(hand, other.hand);
	}

}
