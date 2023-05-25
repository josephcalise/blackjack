/*
Joseph Calise
ID#: 2380565
calise@chapman.edu
CPSC-231 Section 03
MP3A_Cards
*/

import java.util.LinkedList;
import java.util.Random;

public class Deck {
    Random randy = new Random();
    public LinkedList<Card> m_deck = new LinkedList<Card>();

    public Deck() {
        // nested loop to make all 4 suits with all values 2-14:
        // in each loop run it makes the card and adds it to the deck LL.
        int i;
        int j;
        for (i = 0; i < 4; i++) {
            for (j = 2; j < 15; j++) {
                Card i_j = new Card(j, i);
                this.m_deck.add(i_j);
            }
        }

    }

    public Deck(Deck oldDeck) {
        int i;
        for (i = 0; i < oldDeck.size(); i++) {
            int suit = oldDeck.get(i).suit;
            int value = oldDeck.get(i).value;
            Card holder = new Card(value, suit);
            this.m_deck.add(holder);
        }
    }

    public int getCardValue(Card card) {
        return card.value;
    }

    public void set(int i, Card card) {
        this.m_deck.set(i, card);
    }

    public int size() {
        return this.m_deck.size();
    }

    public Card get(int i) {
        return this.m_deck.get(i);
    }

    public void remove(int i) {
        this.m_deck.remove(i);
    }

    public Card deal() {
        int index = randy.nextInt(this.m_deck.size());
        Card delt = this.m_deck.get(index);
        this.m_deck.remove(index);
        return delt;
    }

    public String toString() {
        return this.m_deck.toString();
    }

    public void add(Card card) {
        this.m_deck.add(card);
    }

}