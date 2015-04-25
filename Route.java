import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class Route here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Route
{
    /**
     * enum for the colors that this route can be
     */
    public enum RouteColor 
    {
        YELLOW, ORANGE, GREEN, BLUE, RED, 
        PINK, GRAY, WHITE, BLACK, PURPLE
    }
    // cities is always in alphabetical order (String order)
    private ArrayList<String> cities = new ArrayList<String>();
    private ArrayList<RouteColor> colors = new ArrayList<RouteColor>();
    private int weight, length;

    /**
     * Constructor for Route objects
     * @param cityOne a city in the Route
     * @param cityTwo the other city in the Route
     */
    public Route(String cityOne, String cityTwo) {
        cities.add(cityOne); cities.add(cityTwo);
        Collections.sort(cities);
        String str = cities.get(0);
        if (str.equals("'sGravenhage")) {
            switch (cities.get(1)) {
            case "Rotterdam": 
                weight = 1; length=1;
                colors.add(RouteColor.ORANGE); 
                colors.add(RouteColor.GREEN);
                break;
            case "Haarlem": 
                weight = 2; length = 2;
                colors.add(RouteColor.WHITE);
                colors.add(RouteColor.PINK);
                break;
            case "Middelburg": 
                weight = 4; length = 6;
                colors.add(RouteColor.RED);
                colors.add(RouteColor.YELLOW);
                break;
            }
        }
        else if (str.equals("'sHertogenbosch")) {
            switch (cities.get(1)) {
            case "Breda": 
                weight = 2; length = 2;
                colors.add(RouteColor.ORANGE);
                colors.add(RouteColor.WHITE);
                break;
            case "Eindhoven": 
                weight = 2; length = 1;
                colors.add(RouteColor.GREEN);
                colors.add(RouteColor.BLUE);
                break;
            case "Utrecht":
                weight = 4; length = 3; 
                colors.add(RouteColor.BLACK);
                colors.add(RouteColor.RED);
                break;
            }
        }
        else if (str.equals("Aarschot")) {
            weight = 1; // all have length 1
            switch (cities.get(1)) {
            case "Antwerpen":
                length = 2;
                colors.add(RouteColor.BLUE);
                colors.add(RouteColor.YELLOW);
                break;
            case "Hasselt":
                length = 2;
                colors.add(RouteColor.BLACK);
                colors.add(RouteColor.PINK);
                break;
            case "Liege":
                length = 5;
                colors.add(RouteColor.RED);
                break;
            }
        }        
        else if (str.equals("Amsterdam")) {
            switch (cities.get(1)) {
            case "Utrecht":
                length = 1; weight = 1;
                colors.add(RouteColor.ORANGE);
                colors.add(RouteColor.PINK);
                break;
            case "Haarlem":
                length = 1; weight = 1;
                colors.add(RouteColor.GREEN);
                colors.add(RouteColor.BLACK);
                break;
            case "Rotterdam":
                length = 4; weight = 2;
                colors.add(RouteColor.RED);
                colors.add(RouteColor.BLUE);
                break;
            case "Lelystad":
                length = 3; weight = 3;
                colors.add(RouteColor.YELLOW);
                colors.add(RouteColor.WHITE);
                break;
            }
        }
        else if (str.equals("Antwerpen")) {
            switch (cities.get(1)) {
            case "Turnhout":
                length = 2; weight = 2;
                colors.add(RouteColor.RED);
                colors.add(RouteColor.PINK);
                break;
            case "Middelburg":
                length = 5; weight = 3;
                colors.add(RouteColor.ORANGE);
                colors.add(RouteColor.GREEN);
                break;
            case "Rotterdam":
                length = 5; weight = 4;
                colors.add(RouteColor.BLACK);
                colors.add(RouteColor.WHITE);
                break;
            }
        }
        else if (str.equals("Arnhem")) {
            switch (cities.get(1)) {
            case "Utrecht":
                length = 4; weight = 1;
                colors.add(RouteColor.BLUE);
                colors.add(RouteColor.WHITE);
                break;
            case "Enschede":
                length = 5; weight = 2;
                colors.add(RouteColor.GREEN);
                colors.add(RouteColor.BLACK);
                break;
            case "Zwolle":
                length = 4; weight = 2;
                colors.add(RouteColor.PINK);
                colors.add(RouteColor.ORANGE);
                break;
            case "Nijmegen":
                length = 1; weight = 3;
                colors.add(RouteColor.YELLOW);
                colors.add(RouteColor.RED);
                break;
            }
        }
        else if (str.equals("Breda")) {
            switch (cities.get(1)) {
            case "Turnhout":
                length = 2; weight = 2;
                colors.add(RouteColor.BLACK);
                colors.add(RouteColor.BLUE);
                break;
            case "Rotterdam":
                length = 2; weight = 4;
                colors.add(RouteColor.PINK);
                colors.add(RouteColor.YELLOW);
                break;
            }
        }
        else if (str.equals("DenHelder")) {
            switch (cities.get(1)) {
            case "Haarlem":
                length = 4; weight = 2;
                colors.add(RouteColor.ORANGE);
                colors.add(RouteColor.BLUE);
                break;
            case "Sneek":
                length = 4; weight = 3;
                colors.add(RouteColor.WHITE);
                colors.add(RouteColor.RED);
                break;
            case "Waddensilanden":
                length = 5; weight = 4;
                colors.add(RouteColor.PINK);
                break;
            }
        }
        else if (str.equals("Duisburg")) {
            switch (cities.get(1)) {
            case "Enschede":
                length = 6; weight = 1;
                colors.add(RouteColor.WHITE);
                colors.add(RouteColor.ORANGE);
                break;
            case "Roermond":
                length = 3; weight = 2;
                colors.add(RouteColor.YELLOW);
                colors.add(RouteColor.GREEN);
                break;
            case "Nijmegen":
                length = 4; weight = 2;
                colors.add(RouteColor.BLUE);
                colors.add(RouteColor.PINK);
                break;
            }
        }
        else if (str.equals("Eindhoven")) {
            switch (cities.get(1)) {
            case "Maastricht":
                length = 4; weight = 2;
                colors.add(RouteColor.PINK);
                colors.add(RouteColor.YELLOW);
                break;
            case "Roermond":
                length = 3; weight = 3;
                colors.add(RouteColor.WHITE);
                colors.add(RouteColor.RED);
                break;
            case "Nijmegen":
                length = 3; weight = 3;
                colors.add(RouteColor.BLACK);
                colors.add(RouteColor.ORANGE);
                break;
            }
        }
        else if (str.equals("Emden")) {
            switch (cities.get(1)) {
            case "Lingen":
                length = 6; weight = 1;
                colors.add(RouteColor.BLACK);
                colors.add(RouteColor.GRAY);
                break;
            case "Groningen":
                length = 3; weight = 3;
                colors.add(RouteColor.GRAY);
                colors.add(RouteColor.GRAY);
                break;
            case "Emmen":
                length = 4; weight = 4;
                colors.add(RouteColor.PINK);
                break;
            }
        }
        else if (str.equals("Emmen")) {
            switch (cities.get(1)) {
            case "Lingen":
                length = 3; weight = 2;
                colors.add(RouteColor.YELLOW);
                colors.add(RouteColor.GREEN);
                break;
            case "Groningen":
                length = 3; weight = 3;
                colors.add(RouteColor.BLACK);
                colors.add(RouteColor.RED);
                break;
            case "Zwolle":
                length = 4; weight = 3;
                colors.add(RouteColor.GRAY);
                break;
            }
        }
        else if (str.equals("Enschede")) {
            switch (cities.get(1)) {
            case "Zwolle":
                length = 4; weight = 1;
                colors.add(RouteColor.BLUE);
                colors.add(RouteColor.YELLOW);
                break;
            case "Lingen":
                length = 3; weight = 3;
                colors.add(RouteColor.PINK);
                colors.add(RouteColor.RED);
                break;
            }
        }
        else if (str.equals("Groningen")) {
            switch (cities.get(1)) {
            case "Leeuwarden":
                length = 3; weight = 2;
                colors.add(RouteColor.BLUE);
                colors.add(RouteColor.ORANGE);
                break;
            case "Waddensilanden":
                length = 6; weight = 4;
                colors.add(RouteColor.YELLOW);
                break;
            case "Zwolle":
                length = 6; weight = 4;
                colors.add(RouteColor.GREEN);
                colors.add(RouteColor.WHITE);
                break;
            }
        }
        else if (str.equals("Hasselt")) {
            switch (cities.get(1)) {
            case "Liege":
                length = 2; weight = 1;
                colors.add(RouteColor.GRAY);
                break;
            case "Maastricht":
                length = 2; weight = 2;
                colors.add(RouteColor.GREEN);
                colors.add(RouteColor.RED);
                break;
            case "Turnhout":
                length = 3; weight = 3;
                colors.add(RouteColor.YELLOW);
                colors.add(RouteColor.ORANGE);
                break;
            }
        }
        else if (str.equals("Leeuwarden")) {
            switch (cities.get(1)) {
            case "Sneek":
                length = 1; weight = 1;
                colors.add(RouteColor.BLACK);
                colors.add(RouteColor.YELLOW);
                break;
            case "Waddensilanden":
                length = 2; weight = 3;
                colors.add(RouteColor.GREEN);
                break;
            }
        }
        else if (str.equals("Lelystad")) {
            switch (cities.get(1)) {
            case "Sneek":
                length = 4; weight = 3;
                colors.add(RouteColor.GREEN);
                colors.add(RouteColor.BLUE);
                break;
            case "Zwolle":
                length = 2; weight = 4;
                colors.add(RouteColor.RED);
                colors.add(RouteColor.BLACK);
                break;
            }
        }
        else if (str.equals("Liege")) {
            switch (cities.get(1)) {
            case "Maastricht":
                length = 2; weight = 1;
                colors.add(RouteColor.BLUE);
                colors.add(RouteColor.WHITE);
                break;
            }
        }
        else if (str.equals("Maastricht")) {
            switch (cities.get(1)) {
            case "Roermond":
                length = 2; weight = 1;
                colors.add(RouteColor.ORANGE);
                colors.add(RouteColor.BLACK);
                break;
            }
        }
        else if (str.equals("Sneek")) {
            switch (cities.get(1)) {
            case "Waddensilanden":
                length = 3; weight = 4;
                colors.add(RouteColor.GRAY);
                break;
            }
        }        
        else {
            weight = -1; //should never happen
        }
    }

    /**
     * Returns a String representation of RouteColors
     * @param rc RouteColor to get the String of
     * @return String representation of RouteColors
     */    
    public static String routeColorToString(RouteColor rc) {
        switch (rc) {
        case YELLOW: return "yellow";
        case ORANGE: return "orange";
        case GREEN: return "green";
        case BLUE: return "blue";
        case RED: return "red";
        case GRAY: return "gray";
        case WHITE: return "white";
        case BLACK: return "black";
        case PURPLE:   return "purple";
        }
        return "nosuchcolor";
    }

    /**
     * Equals method for Route
     * @param r Route to compare this to
     * @return true if each City in r.cities exists in this.cities, 
     * false otherwise
     */
    @Override
    public boolean equals(Object r) {
        return r instanceof Route && this.cities.contains(((Route) r).cities.get(0)) && this.cities.contains(((Route) r).cities.get(1));
    }

    /**
     * Returns the weight of this route
     * @return weight of the route
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Returns the length of this route
     * @return length of the route
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the color at index i of colors
     * @param i index to get color from
     * @return the RouteColor at index i of this.colors
     */

    public RouteColor getRouteColor(int i) {
        return colors.get(i);
    }

    /**
     * Checks to see if a given RouteColor is in this Route
     * @param rc RouteColor to look for
     * @return true if rc is in colors, false otherwise
     */
    public boolean containsRouteColor(RouteColor rc) {
        return colors.contains(rc);
    }

    /**
     * Returns the index of the given RouteColor
     * @return index of rc in this.colors,
     * @param rc RouteColor to look for
     * -1 if it is not in this.colors
     */
    public int indexOfRouteColor(RouteColor rc) {
        return colors.indexOf(rc);
    }

}
