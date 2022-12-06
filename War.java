
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    Deck CardsForGrab = new Deck();
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        Deck[] d;
        Deck deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        d = deck.dealDeck();
        Deck p1 = d[0];
        Deck p2 = d[1];
        // ...then run the event loop
        this.runEventLoop(p1,p2);
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck p1, Deck p2) {
        int round = 1;
        Card pl1;
        Card pl2;
        while (p1.getDeckSize() > 0 && p2.getDeckSize() > 0 && round < 300) {
            pl1 = p1.dealCardFromDeck();
            pl2 = p2.dealCardFromDeck();
            System.out.println("Round " + round);
            System.out.println("First Deck Top Card: " + pl1.getFace() + " of " + pl1.getSuit());
            System.out.println("First Deck Size: " + p1.getDeckSize());
            System.out.println("Second Deck Top Card: " + pl2.getFace() + " of " + pl2.getSuit());
            System.out.println("Second Deck Size: " + p2.getDeckSize());
            if (pl1.getRank() > pl2.getRank()) {
                p1.addCardToDeck(pl1);
                p1.addCardToDeck(pl2);
            } else if (pl1.getRank() < pl2.getRank()) {
                p2.addCardToDeck(pl2);
                p2.addCardToDeck(pl2);
            } else if (pl1.getRank() == pl2.getRank()) {
                war(p1,p2,pl1,pl2);
            }
            round++;
        }
    }
    
    public void war(Deck p1, Deck p2, Card pl1, Card pl2) {
        System.out.println("War");
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
