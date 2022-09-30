package com.deckofcards;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeckOfCards {
	private static final Logger logger = LogManager.getLogger(App.class);
	String[] SUITS = { "CLUBS", "DIAMOND", "HEARTS", "SPADES" };
	String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	private String[] decks = new String[52];
	private String[][] playersCards = new String[SUITS.length][RANKS.length];
	private int deckIndex = 0;

	public void initiailzeDeck() { // deck initiaization as 2CLUBS - 3CLUBS and so on % gives rank as 2,3,4,5,6,...
									// / gives CLUBS first till 13 then DIAMOND and so on
		logger.info("Cards inside the deck are as follows");
		for (int i = 0; i < decks.length; i++) {
			decks[i] = RANKS[i % 13] + SUITS[i / 13];
			logger.info(decks[i]);// print each value entered in deck
		}
	}

	public void shuffleDeck() {// switches position of all elements in deck using random value and temp
		for (int i = 0; i < decks.length; i++) {
			int randomIndex = (int) (Math.random() * decks.length);
			String temp = decks[i];
			decks[i] = decks[randomIndex];
			decks[randomIndex] = temp;
		}
	}

	public void distributeToPlayers(Queue player) {// distribute cards to players
		int count = 0;
		for (int j = deckIndex; j < 52; j++) {
			player.enqueue((decks[deckIndex++]));
			count++;
			if (count == 9) {
				break;
			}
		}

	}

	public void printDistributedCardsToPlayers() {// print distributed cards to players 9 cards to 4 players
		for (int i = 0; i < 4; i++) {
			logger.info("Player " + (i + 1) + "");
			for (int j = 0; j < 9; j++) {
				logger.info(playersCards[i][j] + "    ");
			}
			logger.info("\n");
		}
	}

}