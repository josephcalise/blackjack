
/*
Joseph Calise
ID#: 2380565
calise@chapman.edu
CPSC-231 Section 03
MP3B_Black_Jack
*/
import java.util.LinkedList;

public class Computer {
    public LinkedList<Card> hand;

    public Computer() {
        this.hand = new LinkedList<Card>();
    }

    /**
     * handTotal is a method written to return the value of the players hand.
     * based on card values, the method will access 10 for face cards and 11 or 1
     * for aces.
     * The end of the method is the logic of whether an ace should be counted as an
     * 11 or a 1.
     * If the player's hand is greater than 21, then the ace will revert to the
     * value of 1.
     * 
     * @return int, which will represent the total of the player's hand.
     */
    public int handTotal() {
        int handTotal = 0;
        int i;
        for (i = 0; i < this.hand.size(); i++) {
            if (this.hand.get(i).value == 14) {
                handTotal += 11;
            } else if (this.hand.get(i).value > 10) {
                handTotal += 10;
            } else {
                handTotal += this.hand.get(i).value;
            }

        }
        if (handTotal > 21 && this.aces() == true) {
            int count = this.countAces();
            return handTotal - 10 * count;
        } else {
            return handTotal;
        }
    }

    /**
     * aces is a method that will return whether the player's hand contains an ace.
     * This logic is used in the handTotal method to determine what value to assign
     * the ace.
     * 
     * @return boolean, TRUE is the player has an ace in their hand, FALSE is it
     *         does not.
     */
    public boolean aces() {
        int i;
        for (i = 0; i < this.hand.size(); i++) {
            if (this.hand.get(i).value == 14) {
                return true;
            }
        }
        return false;
    }

    public int countAces() {
        int counter = 0;
        for (Card card : this.hand) {
            if (card.value == 14) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * dealHand is a method that will take the cards from the Dealer class' deal()
     * LinkedList
     * and add those cards into our player's LinkedList to play the round
     * 
     * @param hand represents the LinkedList from the Dealer's method deal()
     * @return LinkedList which will be our players hand after the Dealer's deal
     *         method.
     */
    public LinkedList<Card> dealHand(LinkedList<Card> hand) {
        for (Card card : hand) {
            this.hand.add(card);
        }
        return this.hand;
    }

    /**
     * discardHand is run after every round is concluded.
     * it clears the computer's hand of any cards from the last round.
     */
    public void discardHand() {
        this.hand.clear();
    }

    public String toString() {
        return "" + this.hand;
    }
}