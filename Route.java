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
    public enum RouteColor 
    {
        YELLOW, ORANGE, GREEN, BLUE, RED, 
        PINK, GRAY, WHITE, BLACK
    }

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
            case "Turnhout": weight = 2; break;
            case "Rotterdam": weight = 4; break;
            }
        }
        else if (str.equals("DenHelder")) {
            switch (cities.get(1)) {
            case "Haarlem": weight = 2; break;
            case "Sneek": weight = 3; break;
            case "Waddeneilanden": weight = 4; break;
            }
        }
        else if (str.equals("Duisburg")) {
            switch (cities.get(1)) {
            case "Enschede": weight = 1; break;
            case "Roermond": case "Nijmegen": weight = 2; break;
            }
        }
        else if (str.equals("Eindhoven")) {
            switch (cities.get(1)) {
            case "Maastricht": weight = 2; break;
            case "Roermond": case "Nijmegen": weight = 3; break;
            }
        }
        else if (str.equals("Emden")) {
            switch (cities.get(1)) {
            case "Lingen": weight = 1; break;
            case "Groningen": weight = 3; break;
            case "Emmen": weight = 4; break;
            }
        }
        else if (str.equals("Emmen")) {
            switch (cities.get(1)) {
            case "Lingen": weight = 2; break;
            case "Groningen": case "Zwolle": weight = 3; break;
            }
        }
        else if (str.equals("Enschede")) {
            switch (cities.get(1)) {
            case "Zwolle": weight = 1; break;
            case "Lingen": weight = 3; break;
            }
        }
        else if (str.equals("Groningen")) {
            switch (cities.get(1)) {
            case "Leeuwarden": weight = 2; break;
            case "Waddeneilanden": case "Zwolle": weight = 4; break;
            }
        }
        else if (str.equals("Hasselt")) {
            switch (cities.get(1)) {
            case "Liege": weight = 1; break;
            case "Maastricht": weight = 2; break;
            case "Turnhout": weight = 3; break;
            }
        }
        else if (str.equals("Leeuwarden")) {
            switch (cities.get(1)) {
            case "Sneek": weight = 1; break;
            case "Waddeneilanden": weight = 3; break;
            }
        }
        else if (str.equals("Lelystad")) {
            switch (cities.get(1)) {
            case "Sneek": weight = 2; break;
            case "Zwolle": weight = 4; break;
            }
        }
        else if (str.equals("Liege")) {
            switch (cities.get(1)) {
            case "Maastricht": weight = 1; break;
            }
        }
        else if (str.equals("Maastricht")) {
            switch (cities.get(1)) {
            case "Roermond": weight = 1; break;
            }
        }
        else if (str.equals("Sneek")) {
            switch (cities.get(1)) {
            case "Waddeneilanden": weight = 4; break;
            }
        }        
        weight = -1;
    }

    /**
     * Equals method for Route
     * @param r Route to compare this to
     * @return true if each City in r.cities exists in this.cities, 
     * false otherwise
     */
    public boolean equals(Route r) {
        return this.cities.contains(r.cities.get(0)) && this.cities.contains(r.cities.get(1));
    }

    /**
     * Returns the weight of this route
     * @return weight of the route
     */
    public int getWeight() {
        return weight;
    }
}
