import java.util.ArrayList;
import java.util.Random;
/**
 * Deck Object containing a List of Cards
 * 
 * @author (Koushik P, Zach S, 
 * Ryan W, Theresa S, Andi E) 
 * @version 3.22.2015
 */
public class Deck
{
    // instance variables - replace the example below with your own
    protected ArrayList<Card> cards = new ArrayList<>();
    protected Random r = new Random();

    /**
     * Empty constructor for objects of class Deck
     */
    public Deck() {};

    /**
     * Constructor for objects of class Deck
     * @param c ArrayList of Cards
     */
    public Deck(ArrayList<Card> c)
    {
        for (Card cr : c)
            cards.add(cr);
    }
    
    /**
     * Draws a Card from this.cards
     * @return the randomly-drawn Card
     */
    public Card drawCard() {
        int i = r.nextInt(cards.size());
        return cards.remove(i);
    }
    
    /**
     * Adds a Card to this.cards in a random location
     * @param c Card to add to this.cards
     */
    public void addCard(Card c) {
        int i = r.nextInt(cards.size() + 1);
        cards.add(i, c);
    }
}
