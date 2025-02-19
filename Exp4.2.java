Experiment 4.2: Card Collection System

Objective:
Develop a Java program that collects and stores playing cards to help users find all the cards of a given symbol (suit).
The program should utilize the Collection interface (such as ArrayList, HashSet, or HashMap) to manage the card data efficiently.

Understanding the Problem Statement

1. Card Structure:
Each card consists of a symbol (suit) and a value (rank).

Example card representations:
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

2. Operations Required:
Add Cards → Store card details in a collection.
Find Cards by Symbol (Suit) → Retrieve all cards belonging to a specific suit (e.g., all "Hearts").
Display All Cards → Show all stored cards.

3. Collections Usage:
ArrayList: To store cards in an ordered manner.
HashSet: To prevent duplicate cards.
HashMap<String, List<Card>>: To organize cards based on suits for faster lookup.


Test Cases

Test Case 1: No Cards Initially
Input:
Display All Cards
Expected Output:
No cards found.

Test Case 2: Adding Cards
Input:
Add Card: Ace of Spades
Add Card: King of Hearts
Add Card: 10 of Diamonds
Add Card: 5 of Clubs
Expected Output:
Card added: Ace of Spades
Card added: King of Hearts
Card added: 10 of Diamonds
Card added: 5 of Clubs

Test Case 3: Finding Cards by Suit
Input:
Find All Cards of Suit: Hearts
Expected Output:
King of Hearts

Test Case 4: Searching Suit with No Cards
Input:
Find All Cards of Suit: Diamonds
(If no Diamonds were added)
Expected Output:
No cards found for Diamonds.

Test Case 5: Displaying All Cards
Input:
Display All Cards
Expected Output:
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

Test Case 6: Preventing Duplicate Cards
Input:
Add Card: King of Hearts
Expected Output:
Error: Card "King of Hearts" already exists.

Test Case 7: Removing a Card
Input:
Remove Card: 10 of Diamonds
Expected Output:
Card removed: 10 of Diamonds







CODE:
import java.util.*;

class Card {
	private String symbol;
	private String value;

	public Card(String symbol, String value) {
		this.symbol = symbol;
		this.value = value;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value + " of " + symbol;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Card card = (Card) obj;
		return symbol.equals(card.symbol) && value.equals(card.value);
	}

	@Override
	public int hashCode() {
		return symbol.hashCode() + value.hashCode();
	}
}
class CardCollection {
	private Set<Card> allCards;
	private Map<String, List<Card>> cardsBySuit;

	public CardCollection() {
		allCards = new HashSet<>();
		cardsBySuit = new HashMap<>();
	}

	public void addCard(Card card) {
		if (allCards.contains(card)) {
			System.out.println("Error: Card \"" + card + "\" already exists.");
		} else {
			allCards.add(card);
			cardsBySuit.computeIfAbsent(card.getSymbol(), k -> new ArrayList<>()).add(card);
			System.out.println("Card added: " + card);
		}
	}

	public void removeCard(Card card) {
		if (allCards.remove(card)) {
			cardsBySuit.get(card.getSymbol()).remove(card);
			System.out.println("Card removed: " + card);
		} else {
			System.out.println("Error: Card \"" + card + "\" not found.");
		}
	}

	public void findCardsBySuit(String suit) {
		List<Card> cards = cardsBySuit.getOrDefault(suit, Collections.emptyList());
		if (cards.isEmpty()) {
			System.out.println("No cards found for " + suit + ".");
		} else {
			cards.forEach(System.out::println);
		}
	}

	public void displayAllCards() {
		if (allCards.isEmpty()) {
			System.out.println("No cards found.");
		} else {
			allCards.forEach(System.out::println);
		}
	}

	public static void main(String[] args) {
		CardCollection collection = new CardCollection();

		collection.displayAllCards();

		collection.addCard(new Card("Spades", "Ace"));
		collection.addCard(new Card("Hearts", "King"));
		collection.addCard(new Card("Diamonds", "10"));
		collection.addCard(new Card("Clubs", "5"));
		collection.findCardsBySuit("Hearts");
		collection.findCardsBySuit("Diamonds");
		collection.displayAllCards();
		collection.addCard(new Card("Hearts", "King"));
		collection.removeCard(new Card("Diamonds", "10"));
	}
}
