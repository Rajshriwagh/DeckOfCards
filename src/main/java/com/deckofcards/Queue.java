package com.deckofcards;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class QNode {
	String key;
	QNode next;

	// constructor to create a new linked list node
	public QNode(String decks) {
		this.key = decks;
		this.next = null;
	}
}

// A class to represent a queue
// The queue, front stores the front node of LL and rear stores the
// last node of LL
public class Queue {
	private static final Logger logger = LogManager.getLogger(App.class);
	QNode front, rear;

	public Queue() {
		this.front = this.rear = null;
	}

	// Method to add an key to the queue.
	void enqueue(String decks) {

		// Create a new LL node
		QNode temp = new QNode(decks);

		// If queue is empty, then new node is front and rear both
		if (this.rear == null) {
			this.front = this.rear = temp;
			return;
		}

		// Add the new node at the end of queue and change rear
		this.rear.next = temp;
		this.rear = temp;
	}

	// Method to remove an key from queue.
	void dequeue() {
		// If queue is empty, return NULL.
		if (this.front == null)
			return;

		// Store previous front and move front one node ahead
		QNode temp = this.front;
		this.front = this.front.next;

		// If front becomes NULL, then change rear also as NULL
		if (this.front == null)
			this.rear = null;
	}

	void display() {
		logger.info("Player cards are as follows:");
		if (this.front == null)
			return;
		else {
			QNode temp = this.front;
			while (temp != null) {
				logger.info(temp.key);
				temp = temp.next;
			}
		}
	}
}