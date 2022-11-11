package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
//has-a / composition / association (A Deck has a bunch-0 cards)
	// a deck has a fixed amount of cards
	// a deck is some type of collection of cards
	// 
	List<Card> deck = new ArrayList<>();
	//deck is a collection of cards
	
	public Deck() {
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		
		for (Suit suit : suits) {
			// for each suit (all four of them)
			for(Rank rank : ranks) {
				// for each rank (all 13 of them)
				Card aCard = new Card(rank, suit);
				// as I generate each card where do you put each  card thats been generated. The deck.
				
				deck.add(aCard);
			}
			
		}

	
	}
	
	
	public int checkDeckSize() {
		return deck.size();
	}
	
	public Card dealCard() { //when card is dealt the return type wouldnt be int or string it would be an actual Card
		return deck.remove(0);
	}
	
	public void shuffe() {
		Collections.shuffle(deck);
	}
	
	
	
	
}
