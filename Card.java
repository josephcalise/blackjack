/*
Joseph Calise
ID#: 2380565
calise@chapman.edu
CPSC-231 Section 03
MP3A_Cards
*/

public class Card {

    public static final int HEARTS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;

    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    public int value;
    public int suit;

    public Card() {
        this.value = Card.ACE;
        this.suit = Card.SPADES;
    }

    public Card(String face, String suitSelect) {
        if (face.toLowerCase().equals("jack")) {
            this.value = Card.JACK;
        } else if (face.toLowerCase().equals("queen")) {
            this.value = Card.QUEEN;
        } else if (face.toLowerCase().equals("king")) {
            this.value = Card.KING;
        } else {
            this.value = Card.ACE;
        }

        if (suitSelect.toLowerCase().equals("hearts")) {
            this.suit = Card.HEARTS;
        } else if (suitSelect.toLowerCase().equals("spades")) {
            this.suit = Card.SPADES;
        } else if (suitSelect.toLowerCase().equals("clubs")) {
            this.suit = Card.CLUBS;
        } else {
            this.suit = Card.DIAMONDS;
        }

    }

    public Card(int number, String suitSelect) {
        this.value = number;

        if (suitSelect.toLowerCase().equals("hearts")) {
            this.suit = Card.HEARTS;
        } else if (suitSelect.toLowerCase().equals("spades")) {
            this.suit = Card.SPADES;
        } else if (suitSelect.toLowerCase().equals("clubs")) {
            this.suit = Card.CLUBS;
        } else {
            this.suit = Card.DIAMONDS;
        }

    }

    public Card(int number, int suitSelect) {
        this.value = number;
        this.suit = suitSelect;
    }

    public Card(Card card) {
        this.value = card.value;
        this.suit = card.suit;
    }

    // settors
    public void setValue(int value) {
        this.value = value;
    }

    public void setValue(String face) {
        if (face.toLowerCase().equals("jack")) {
            this.value = Card.JACK;
        } else if (face.toLowerCase().equals("queen")) {
            this.value = Card.QUEEN;
        } else if (face.toLowerCase().equals("king")) {
            this.value = Card.KING;
        } else {
            this.value = Card.ACE;
        }
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setSuit(String suit) {
        if (suit.toLowerCase().equals("hearts")) {
            this.suit = Card.HEARTS;
        } else if (suit.toLowerCase().equals("spades")) {
            this.suit = Card.SPADES;
        } else if (suit.toLowerCase().equals("clubs")) {
            this.suit = Card.CLUBS;
        } else {
            this.suit = Card.DIAMONDS;
        }
    }

    // gettors

    public String getSuit() {
        return "" + this.suit;
    }

    public String getValue() {
        return "" + this.value;
    }

    // methods
    public boolean equals(Card other) {
        if (!(other instanceof Card)) {
            return false;
        } else {
            if (other.suit == this.suit && other.value == this.value) {
                return true;
            } else {
                return false;
            }
        }
    }

    public String toString() {
        String results = "";
        if (this.value == 11) {
            results += "Jack of ";
        } else if (this.value == 12) {
            results += "Queen of ";
        } else if (this.value == 13) {
            results += "King of ";
        } else if (this.value == 14) {
            results += "Ace of ";
        } else {
            results += "" + this.value + " of ";
        }

        if (this.suit == 0) {
            results += "Hearts";
        } else if (this.suit == 1) {
            results += "Spades";
        } else if (this.suit == 2) {
            results += "Clubs";
        } else {
            results += "Diamonds";
        }

        return results;

    }

}
