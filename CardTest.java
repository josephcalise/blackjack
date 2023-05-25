
/*
Joseph Calise
ID#: 2380565
calise@chapman.edu
CPSC-231 Section 03
MP3A_Cards
*/

public class CardTest {

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        System.out.println();
        System.out.println("First Hand of 10:");
        System.out.println(dealer.deals(10));
        System.out.println();
        System.out.println("Cards left after first deal:");
        System.out.println(dealer.size());
        System.out.println();
        System.out.println("Second Hand of 22:");
        System.out.println(dealer.deals(22));
        System.out.println();
        System.out.println("Cards left after first deal:");
        System.out.println(dealer.size());
        System.out.println();
        System.out.println("Third Hand of 10:");
        System.out.println(dealer.deals(10));
        System.out.println();
        System.out.println("Cards left in deck: ");
        System.out.println(dealer);
        System.out.println();
        System.out.println("Last 10 cards delt:");
        System.out.println(dealer.deals(10));
        System.out.println();
        System.out.println("Deals() method after empty deck:");
        System.out.println(dealer.deals(5));
    }
}
