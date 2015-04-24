import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version 3.22.2015
 */
public class Player
{
    public String color, name;
    private boolean bonus;
    public boolean last = false;
    protected int cars, tokens, points;
    protected ArrayList<DestinationCard> destCards;
    protected ArrayList<TrainCarCard> trainCards;
    protected ArrayList<Route> capturedRoutes = new ArrayList<Route>();

    public Player() {
        cars = 10; tokens = 30; points = 0; bonus = true; // fix this so name and color can be final
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
     * Adds the points to the player
     * @param p Adds this many points to the player
     */
    public void addPoints(int p) {
        points = points + p;
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

    public void addDestinationCard(DestinationCard c) {
        destCards.add(c);
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

    /**
     * Adds the points based on the lengths of the routes
     * @param leng The length of the routes
     */
    public void addRoutePoints(int leng){
        if(leng == 1) points = points + 1;
        else if(leng == 2) points = points + 2;
        else if(leng == 3) points = points + 4;
        else if(leng == 4) points = points + 7;
        else if(leng == 5) points = points + 10;
        else points = points + 15;
    }

    public void addRoute(String cityOne, String cityTwo, String rcolor, Deck d) {
        //if (!hasRoute(cityOne,cityTwo)) {
        Route rte = new Route(cityOne, cityTwo);
        cars -= rte.getLength();
        int cardsToGetRidOf = rte.getLength();
        addRoutePoints(cardsToGetRidOf);
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

    public int calculateDestinationPoints() {
        int pointCount = 0;
        Graph g = new Graph();
        for (DestinationCard dc : destCards) {
            int destValue = dc.getValue();
            String[] cities = dc.getCities();
            if (canReach(cities[0], cities[1], g)) 
                pointCount += destValue;
            else
                pointCount -= destValue;
        }
        return pointCount;
    }
    
    public String getName() { 
        return name;
    }

    public boolean canReach(String cityOne, String cityTwo, Graph g) {
        if (g.hasEdge(cityOne, cityTwo)) return this.hasRoute(cityOne, cityTwo);
        LinkedList<City> adjacentCities = g.adjMatrix.get(cityOne);
        for (City c : adjacentCities)
            if (this.hasRoute(cityOne, c.getName()) && canReach(c.getName(), cityTwo, g))
                return true;
        return false;
    }
}
