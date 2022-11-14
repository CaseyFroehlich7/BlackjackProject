package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Player;

public class BlackjackApp {
	Scanner sc = new Scanner(System.in);
	Dealer dealer = new Dealer();
	Player player = new Player();
	Deck deck = new Deck();
	BlackjackHand playerHand = new BlackjackHand();

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.startRound();
	}

	public void startRound() {

		System.out.println("        $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("        $$  Welcome to Casey's Cowboy Casino! $$");
		System.out.println("        $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println();
		System.out.println("              Lets play some Blackjack Y'all!");
		System.out.println("     The Dealer will now shuffle and deal your cards.");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		deck.createDeck();
		deck.shuffle();
		deck.checkDeckSize();
		System.out.println("Playing with " + deck.checkDeckSize() + " in the deck.");
		System.out.println();
				 
		player.getHand().addCard(deck.dealCard());
		dealer.getHand().addCard(deck.dealCard());
		player.getHand().addCard(deck.dealCard());
		dealer.getHand().addCard(deck.dealCard());

		System.out.println("Players " + player.getHand());
		System.out.println("Hand Value: " + player.getHand().getHandValue());
		System.out.println();

		if (player.getHand().getHandValue() < 21) {
			hitOrStay();
		} else if (player.getHand().getHandValue() == 21) {
			System.out.println("BLACKJACK!! YOU WIN!");
			runItBack();
		} else if (dealer.getHand().getHandValue() == 21) {
			System.out.println("DEALER HAS BLACKJACK! Better luck next time rookie.");
			runItBack();
		} else if (player.getHand().getHandValue() > 21) {
			System.out.println("You busted! Dealer wins.");
			runItBack();
		}

		hitOrStay();
	}

	public void hitOrStay() {

		System.out.println("      Would you like to hit or stay?            ");
		System.out.println("                 1. Cowboy Up! - Hit                        ");
		System.out.println("                 2. Hold Your Horses - Stay                        ");

		int userHitOrStay = sc.nextInt();

		if (userHitOrStay == 1) {
			hit();
		} 
		if (userHitOrStay == 2) {
			stay();
		} else {
			System.out.println("Invalid Selection. Please select a number 1-2.");
		}
	}

	public void hit() {
		player.getHand().addCard(deck.dealCard());
		System.out.println("Updated Player Hand: " + player.getHand());
		System.out.println();
		System.out.println("Updated Hand Value: " + player.getHand().getHandValue());
		System.out.println();

		if (player.getHand().getHandValue() < 21) {
			hitOrStay();
		} else if (player.getHand().getHandValue() == 21) {
			System.out.println("YEEHAW! BLACKJACK!! YOU WIN!");
			runItBack();
		} else if (player.getHand().getHandValue() > 21) {
			System.out.println("Daggummit You Busted! Dealer wins.");
			runItBack();
		} else if (player.getHand().getHandValue() == dealer.getHand().getHandValue()) {
			System.out.println("Hands are equal. No winner? That Ain't Cowboy.. Clear cards.");
			runItBack();
		}

	}

	public void stay() {
		System.out.println("You stayed. Revealing dealer hand now.");
		System.out.println();
		System.out.println("Dealers Hand: " + dealer.getHand());
		System.out.println();
		System.out.println("Dealers Original Hand Value: " + dealer.getHand().getHandValue());
		System.out.println();

		boolean dealerHand = true;
		while (dealerHand) {

			if (dealer.getHand().getHandValue() > 21) {
				System.out.println("Dealer busted! YOU WIN!");
				runItBack();
			} else if (dealer.getHand().getHandValue() == 21) {
				System.out.println("DEALER HAS BLACKJACK! Better luck next time rookie.");
				runItBack();
			} else if (dealer.getHand().getHandValue() > 17 && dealer.getHand().getHandValue() < 21) {
				if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
					System.out.println();
					System.out.println("Close but No Cigar! Dealer wins.");
					runItBack();
				}
				if (dealer.getHand().getHandValue() < player.getHand().getHandValue()) {
					System.out.println();
					System.out.println("Close one Cowboy! You win.");
					runItBack();
				}
			} else if (dealer.getHand().getHandValue() < 17) {
				dealer.getHand().addCard(deck.dealCard());
				System.out.println();
				System.out.println("The dealer has hit and added a card to his hand.");
				System.out.println();
				System.out.println("Updated Dealer Hand " + dealer.getHand());
				System.out.println();
				System.out.println("Updated Dealer Hand Value: " + dealer.getHand().getHandValue());
				System.out.println();
				if (dealer.getHand().getHandValue() < 17) {
					dealer.getHand().addCard(deck.dealCard());
					System.out.println();
					System.out.println("The dealer has hit and added a card to his hand.");
					System.out.println();
					System.out.println("Updated Dealer Hand " + dealer.getHand());
					System.out.println();
					System.out.println("Updated Dealer Hand Value: " + dealer.getHand().getHandValue());
					System.out.println();
					if (dealer.getHand().getHandValue() < player.getHand().getHandValue()) {
						System.out.println("You Win!");
					}
				}
			} else if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
				System.out.println("Hand values are equal. No winner! Clear cards.");
				player.getHand().clear();
				dealer.getHand().clear();
				System.out.println();
				dealerHand = false;

			}
		}
startRound();
	}

	public void runItBack() {
		System.out.println();
		System.out.println(" Great game! Would you like to paly again?");
		System.out.println("          1. Play Again!");
		System.out.println("          2. Quit");


		int playOrQuit = sc.nextInt();

		if (playOrQuit == 1) {
			player.getHand().clear();
			dealer.getHand().clear();
			System.out.println();
		}
		if (playOrQuit == 2){
			System.out.println("Thanks for playing! See you next time.");
		} else {
			System.out.println("Invalid Selection. Please choose a number 1-2.");
		}
		startRound();
		
	}


}
