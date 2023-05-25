/*
Joseph Calise
ID#: 2380565
calise@chapman.edu
CPSC-231 Section 03
MP3A_Cards
*/

import java.util.LinkedList;

public class Dealer {

    Deck dealers_deck;

    public Dealer() {
        this.dealers_deck = new Deck();
    }

    public int size() {
        return this.dealers_deck.size();
    }

    public LinkedList<Card> deals(int n) {
        LinkedList<Card> deltCards = new LinkedList<Card>();
        int i;
        for (i = 0; i < n; i++) {
            if (this.dealers_deck.size() != 0) {
                deltCards.add(this.dealers_deck.deal());
            } else {
                return deltCards;
            }
        }
        return deltCards;
    }

    public void resetDeck() {
        this.dealers_deck = new Deck();
    }

    public String toString() {
        int i;
        String cardsInDeck = "";
        for (i = 0; i < this.dealers_deck.size(); i++) {
            cardsInDeck += this.dealers_deck.get(i) + "\n";
        }
        return cardsInDeck;
    }

}