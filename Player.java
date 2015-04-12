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
    protected int cars, tokens;
    protected ArrayList<DestinationCard> destCards;
    protected ArrayList<TrainCarCard> trainCards;
    protected ArrayList<Route> capturedRoutes = new ArrayList<Route>();
    
    private class Route
    {
        private ArrayList<String> cities = new ArrayList<String>();
        public Route(String cityOne, String cityTwo) {
            cities.add(cityOne); cities.add(cityTwo);
        }
        
        public boolean equals(Route r) {
            return this.cities.contains(r.cities.get(0)) && this.cities.contains(r.cities.get(1));
        }
    }

    public Player() {
        cars = 40; tokens = 30; // fix this so name and color can be final
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
        return this.capturedRoutes.contains(new Route(cityOne.getName(), cityTwo.getName()));
    }
}
