/*
Joseph Calise
ID#: 2380565
calise@chapman.edu
CPSC-231 Section 03
MP3B_Black_Jack
*/

import java.util.LinkedList;

public class Player {
    private String name;
    // cash will serve as the players bank account.
    private int cash;
    public LinkedList<Card> hand;

    public Player() {
        this.name = "Player";
        this.cash = 100;
        this.hand = new LinkedList<Card>();
    }

    public Player(String name, int cash) {
        this.name = name;
        this.cash = cash;
        this.hand = new LinkedList<Card>();
    }

    /**
     * totalCash is a more formal getCash method which will System.out the cash
     * amount
     * as well as the player's name.
     * 
     * @return String of player's name and the cash amount left they have to play
     *         with.
     */
    public String totalCash() {
        return this.name + " now has $" + this.cash + " left in their account.";
    }

    /**
     * getCash will return the cash remaining in the player's balance.
     * 
     * @return int that represents the cash the player has left to play with.
     */
    public int getCash() {
        return this.cash;
    }

    /**
     * lostCash is a method called when the player loses the round.
     * This will subtract the bet amount and System.out the remaining balance.
     * 
     * @param bet is the value the player bet on the hand.
     * @return String, this string will contain the amount the player has left,
     *         formatted in text.
     */
    public String lostCash(int bet) {
        this.cash -= bet;
        return this.totalCash();
    }

    /**
     * winHand is a method called when the player wins the round.
     * This will add the bet amount and System.out the remaining balance.
     * 
     * @param bet is the value the player bet on the hand.
     * @return String, this string will contain the amount the player has left,
     *         formatted in text.
     */
    public String winHand(int bet) {
        this.cash += bet;
        return this.totalCash();
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
     * discardHand is run after every round is concluded.
     * it clears the players hand of any cards from the last round.
     */
    public void discardHand() {
        this.hand.clear();
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

}