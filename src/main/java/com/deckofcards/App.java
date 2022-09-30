package com.deckofcards;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	private static final Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		logger.info("Welcome to Deck of Cards Program!");
		DeckOfCards deckOfCard = new DeckOfCards();
		Queue player1 = new Queue();
		Queue player2 = new Queue();
		Queue player3 = new Queue();
		Queue player4 = new Queue();

		deckOfCard.initiailzeDeck();
		deckOfCard.shuffleDeck();
		deckOfCard.distributeToPlayers(player1);
		deckOfCard.distributeToPlayers(player2);
		deckOfCard.distributeToPlayers(player3);
		deckOfCard.distributeToPlayers(player4);
		// deckOfCard.printDistributedCardsToPlayers();
		player1.display();
		player2.display();
		player3.display();
		player4.display();

	}
}