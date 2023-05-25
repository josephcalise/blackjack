/*
Joseph Calise
ID#: 2380565
calise@chapman.edu
CPSC-231 Section 03
MP3B_Black_Jack
*/

import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    private boolean keepPlaying = true;
    Scanner input = new Scanner(System.in);

    /**
     * startRound intakes everyone at the table as well as the dealers deck.
     * startRound will preform the actions of dealing cards from the Deck class
     * then distributing those cards into the player and computers hands
     * (LinkedLists)
     * 
     * @param player   Instance of the player class that is created on the driver.
     * @param dealer   Instance of the Dealer class to control the deck and dealing
     *                 functionality.
     * @param computer Instance of the Computer class which will be what the player
     *                 is playing against.
     *                 @return, there is not return for this method.
     */
    public void startRound(Player player, Dealer dealer, Computer computer) {
        LinkedList<Card> playerHand = dealer.deals(2);
        LinkedList<Card> computerHand = dealer.deals(2);
        computer.dealHand(computerHand);
        System.out.println(player.dealHand(playerHand));
        System.out.println("Your hand is: " + player.handTotal());
        System.out.println();
        System.out.println("Computer is showing:");
        System.out.println(computerHand.get(0));
    }

    /**
     * finishRound intakes the instance of the Computer class and Dealer class.
     * finishRound is ran whent he player chooses to hold.
     * This method will complete the computers hand if needed for the final
     * comparison for the winner.
     * **********************BLACKJACK RULES***************************
     * If the computer has a soft 17 (17 with an ace), it will hit.
     * If the computer has less than 17, it will hit until it has more than 17 or is
     * busts (over 21).
     * 
     * @param dealer   Instance of the Dealer class to control the deck and dealing
     *                 functionality.
     * @param computer Instance of the Computer class which will be what the player
     *                 is playing against.
     *                 @return, there is not return for this method.
     */
    public void finishRound(Computer computer, Dealer dealer) {

        if (computer.handTotal() == 17 && computer.aces() == true) {
            LinkedList<Card> extra = dealer.deals(1);
            System.out.println(computer.dealHand(extra));
        } else if (computer.handTotal() > 17) {
            System.out.println("The computers hand is:");
            System.out.println(computer);
            System.out.println("Computer has " + computer.handTotal());
        } else {
            while (computer.handTotal() < 17 && computer.handTotal() < 21) {
                System.out.println("The computer HITS!");
                LinkedList<Card> extra = dealer.deals(1);
                System.out.println(computer.dealHand(extra));
            }
            System.out.println("The computer's FINAL hand is:");
            System.out.println(computer);
            System.out.println("Computer had " + computer.handTotal());

        }
    }

    /**
     * playerOptions controls the player's choice to hit or hold when they are delt
     * their hand.
     * If the player chooses to hit, they will press 1 and an additional card will
     * be inputed into their hand.
     * If the player chooses to hold, they will press 0 and the GameDriver will run
     * completeRound() to finish the round for final comparisons.
     * 
     * @param player Instance of the Player class needed to access the player's hand
     *               (LinkedList)
     * @param dealer Instance of Dealer class needed to deal cards from the deck.
     * @return return type is a boolean that will either trigger the finishRound
     *         method, or continue to let the player hit again.
     * 
     */
    public boolean playerOptions(Player player, Dealer dealer) {
        int hit = input.nextInt();
        if (hit == 1) {
            LinkedList<Card> extra = dealer.deals(1);
            System.out.println(player.dealHand(extra));
            System.out.println("Your new total is: " + player.handTotal());
            return false;
        } else {
            return true;
        }
    }

    /**
     * checkWinner is a method to compare the total hands of both the player and
     * computer to assess a winner.
     * This instance should only be ran if both the player and computer hold their
     * hand with less than 21.
     * If a bust occurs or if the player gets 21, this method will not run.
     * 
     * @param player   Instance of the Player class to access their hand.
     * @param computer Instance of the Computer class to access their hand.
     * @return The return type is an Int. This int will correspond in the game logic
     *         to access a winner.
     * @return 0 means that they player and computer push (same value)
     * @return 1 means the player wins the hand by either having more, getting 21,
     *         or the computer busts.
     * @return 2 means the player loses.
     */
    public int checkWinner(Player player, Computer computer) {
        if (player.handTotal() == computer.handTotal()) {
            return 0;
        } else if (player.handTotal() > computer.handTotal() || computer.handTotal() > 21) {
            return 1;
        } else {
            return 2;
        }
    }

    // just a method to break up the terminal during the gameplay.
    public void space() {
        System.out.println();
        System.out.println();

    }

    /********************* Main Game logic *******************************/
    public Game(Player player) {
        /*
         * Initializes the standard variables computer and dealer (which gives a deck to
         * play with.)
         */
        Computer computer = new Computer();
        Dealer dealer = new Dealer();
        // This programs is made to run until the player chooses to stop playing, or
        // they run out of money.
        // Logic of those two are present in this while loop.
        while (player.getCash() > 0 && this.keepPlaying == true) {
            System.out.println("You have $" + player.getCash() + " to play with!");
            boolean hold = false;
            boolean bust = false;
            int bet = 0;
            // Min bets are to be $5 or more with no maximum, will ask for a bet until the
            // min is hit.
            while (bet < 5 || bet > player.getCash()) {
                if (bet < 5) {
                    System.out.println("Please place a bet greater than the minimum ($5).");
                    bet = input.nextInt();
                } else if (bet > player.getCash()) {
                    System.out.println("You don't have that much! Please enter a valid bet!");
                    bet = input.nextInt();
                }
            }
            space();
            // Start round is ran to deal the cards to the player and computer.
            startRound(player, dealer, computer);
            // This while loop is to control the logic of the game.
            // During this while loop the there are nested IF statements, these statements
            // contorl the conditions of a blackjack hand.
            // bust and hold variables are set to false allowing the player to hit until
            // they bust or are happy with their total hand.
            while (bust == false && hold == false) {
                if (player.handTotal() == 21) {
                    System.out.println("You have 21!");
                    System.out.println("The computer shows their hand:");
                    System.out.println(computer);
                    System.out.println(player.winHand(bet));
                    // holding being set to true since the player has won the round.
                    hold = true;
                }
                // a player's hand being less than 21 allows them to have the option to hit or
                // hold.
                if (player.handTotal() < 21) {
                    System.out.println("Would you like to hit (1) or hold (0)?");
                    // hold is set to the playerOptions method, since this returns a boolean, it
                    // will keep hold to false if they player is hitting
                    // but will set it to true once the players holds their hand, triggering the
                    // finishRound method to complete the round.
                    hold = playerOptions(player, dealer);
                    if (hold == true) {
                        System.out.println("The computer shows their hand:");
                        System.out.println(computer);
                        finishRound(computer, dealer);
                        // after the computer hits or holds according to blackjack rules, it will
                        // compare the winner.
                        // once the winner is compared, it will trigger to either add money to the
                        // players ammount (if they win), or take money (if they lose).
                        // 0 = push / 1 = player win / 2 = computer wins
                        if (checkWinner(player, computer) == 0) {
                            System.out.println("It's a push! No winners.");
                        } else if (checkWinner(player, computer) == 1) {
                            System.out.println("Player wins with " + player.handTotal() + "!");
                            System.out.println(player.winHand(bet));
                        } else {
                            System.out.println("Computer wins with " + computer.handTotal() + ".");
                            System.out.println(player.lostCash(bet));
                        }
                    }
                    // catches a bust by the player while they are hitting setting bust to true and
                    // ending the round.
                } else if (player.handTotal() > 21) {
                    System.out.println("Oh No! You busted!");
                    System.out.println(player.lostCash(bet));
                    bust = true;
                }
            }
            space();
            System.out.println("Would you like to play another round? (1 = yes / 0 = no).");
            int play = input.nextInt();
            if (play == 0) {
                keepPlaying = false;
            }
            // below discards the player and computers hands, as well as checks the deck
            // size.
            // if the deck size is below 10, it will initialize a new deck to keep the game
            // going.
            player.discardHand();
            computer.discardHand();
            if (dealer.size() < 10) {
                dealer = new Dealer();
            }
            space();
        }

        if (player.getCash() == 0) {
            System.out.println("Oh Dear! You're out of cash!");
            System.out.println("Come back when you have more.");
        } else {
            System.out.println("Thanks for playing!");
            System.out.println("You ended with $" + player.getCash() + ".");
            System.out.println("Come back when you wanna lose more money!");
            System.out.println("Remember, the house always wins!");
        }
    }
}