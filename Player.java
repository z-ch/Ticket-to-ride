import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version 3.22.2015
 */
public class Player
{
    public /*final*/ String color, name;
    private boolean bonus;
    protected int cars, tokens, points;
    protected ArrayList<DestinationCard> destCards;
    protected ArrayList<TrainCarCard> trainCards;
    protected ArrayList<Route> capturedRoutes = new ArrayList<Route>();

    public Player() {
        cars = 40; tokens = 30; points = 0; bonus = true; // fix this so name and color can be final
        destCards = new ArrayList<>(); trainCards = new ArrayList<>();
    }

    /**
     * Constructor for objects of type Player
     * @param n name of Player
     * @param c color of Player
     */
    public Player(String n, String c) {
        this();
        color = c; name = n;
    }

    /**
     * Sets the name of the player
     * @param n Name of player
     */
    public void setN(String n) {
        name = n;
    }

    /**
     * Sets the color of the player
     * @param c Color of player
     */
    public void setC(String c) {
        color = c;
    }

    /**
     * draws a destination card
     * @param d Deck of DestinationCards
     */
    public void drawDestinationCard(Deck d) {
        // maybe add a instanceof check?
        DestinationCard c = (DestinationCard) d.drawCard();
        destCards.add(c);
    }

    public void addDestinationCard(Card c) {

        destCards.add((DestinationCard) c);
    }

    /**
     * draws a train card
     * @param d Deck of TrainCarCards
     */
    public void drawTrainCarCard(Deck d) {
        // maybe add a instanceof check?
        TrainCarCard c = (TrainCarCard) d.drawCard();
        trainCards.add(c);
    }

    public void addTrainCarCard(Card c) {
        // maybe add a instanceof check?
        trainCards.add((TrainCarCard) c);
    }

    public boolean hasRoute(String cityOne, String cityTwo) {
        return this.capturedRoutes.contains(new Route(cityOne, cityTwo));
    }

    public boolean hasRoute(City cityOne, City cityTwo) {
        return this.hasRoute(cityOne.getName(), cityTwo.getName());
        //return this.capturedRoutes.contains(new Route(cityOne.getName(), cityTwo.getName()));
    }

    public void addRoute(String cityOne, String cityTwo, String rcolor, Deck d) {
        //if (!hasRoute(cityOne,cityTwo)) {
        Route rte = new Route(cityOne, cityTwo);
        cars -= rte.getLength();
        int cardsToGetRidOf = rte.getLength();
        for (int i=0; i<trainCards.size() && cardsToGetRidOf > 0; i++)
            if (trainCards.get(i).getColor().equals(rcolor)) {
                d.addCard(trainCards.remove(i--));
                --cardsToGetRidOf;
        }
        
        if (cardsToGetRidOf > 0) {
            for (int i=0; i<trainCards.size() && cardsToGetRidOf > 0; i++) {
                if (trainCards.get(i).getColor().equals("rainbow")) {
                    d.addCard(trainCards.remove(i--));
                    --cardsToGetRidOf;
                }
            }
        }
        if (tokens >= rte.getWeight()) {
            tokens -= rte.getWeight();
        }
        else {
            points -= 5;// SUBTRACT 5 POINTS
            bonus = false;
        }
        capturedRoutes.add(new Route(cityOne, cityTwo));
        //}
    }

    public void addRoute(City cityOne, City cityTwo, String rcolor, Deck d) {
        addRoute(cityOne.getName(), cityTwo.getName(), rcolor, d);
    }

    public void addTokens(int t) {
        tokens += t;
    }

    public int getCars() {
        return cars;
    }

    public int getTrainCarsCards(String trainCarColor) {
        int total = 0;
        for (TrainCarCard tcc : trainCards)
            if (trainCarColor.equals(tcc.getColor()) || tcc.getColor().equals("rainbow"))
                ++total;
        return total;
    }

    public boolean canGetBonus() {
        return bonus;
    }
    
    public int getTokens() {
        return tokens;
    }
    
    public int getPoints() {
        return points;
    }
    
    public DestinationCard getDestCard(int i) {
        return destCards.get(i);
    }
    
    public int getDestCardSize() {
        return destCards.size();
    }
}
