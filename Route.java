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
    private ArrayList<String> cities = new ArrayList<String>();

    /**
     * Constructor for Route objects
     * @param cityOne a city in the Route
     * @param cityTwo the other city in the Route
     */
    public Route(String cityOne, String cityTwo) {
        cities.add(cityOne); cities.add(cityTwo);
        Collections.sort(cities);
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
        String str = cities.get(0);
        if (str.equals("'sGravenhage")) {
            switch (cities.get(1)) {
                case "Rotterdam": return 1;
                case "Haarlem": return 2;
                case "Middelburg": return 4;
            }
        }
        else if (str.equals("'sHertogenbosch")) {
            switch (cities.get(1)) {
                case "Breda": case "Eindhoven": return 2;
                case "Utrecht": return 4;
            }
        }
        else if (str.equals("Aarschot")) {
            switch (cities.get(1)) {
                case "Antwerpen": case "Hasselt": case "Liege": return 1;
            }
        }        
        else if (str.equals("Amsterdam")) {
            switch (cities.get(1)) {
                case "Utrecht": case "Haarlem": case "Arnhem": return 1;
                case "Rotterdam": return 2;
                case "Lelystad": return 3;
            }
        }
        else if (str.equals("Antwerpen")) {
            switch (cities.get(1)) {
                case "Turnhout": return 2;
                case "Middelburg": return 3;
                case "Rotterdam": return 4;
            }
        }
        else if (str.equals("Arnhem")) {
            switch (cities.get(1)) {
                case "Utrecht": return 1;
                case "Enschede": case "Zwolle": return 2;
                case "Nijmegen": return 3;
            }
        }
        else if (str.equals("Breda")) {
            switch (cities.get(1)) {
                case "Turnhout": return 2;
                case "Rotterdam": return 4;
            }
        }
        else if (str.equals("DenHelder")) {
            switch (cities.get(1)) {
                case "Haarlem": return 2;
                case "Sneek": return 3;
                case "Waddeneilanden": return 4;
            }
        }
        else if (str.equals("Duisburg")) {
            switch (cities.get(1)) {
                case "Enschede": return 1;
                case "Roermond": case "Nijmegen": return 2;
            }
        }
        else if (str.equals("Eindhoven")) {
            switch (cities.get(1)) {
                case "Maastricht": return 2;
                case "Roermond": case "Nijmegen": return 3;
            }
        }
        else if (str.equals("Emden")) {
            switch (cities.get(1)) {
                case "Lingen": return 1;
                case "Groningen": return 3;
                case "Emmen": return 4;
            }
        }
        else if (str.equals("Emmen")) {
            switch (cities.get(1)) {
                case "Lingen": return 2;
                case "Groningen": case "Zwolle": return 3;
            }
        }
        else if (str.equals("Enschede")) {
            switch (cities.get(1)) {
                case "Zwolle": return 1;
                case "Lingen": return 3;
            }
        }
        else if (str.equals("Groningen")) {
            switch (cities.get(1)) {
                case "Leeuwarden": return 2;
                case "Waddeneilanden": case "Zwolle": return 4;
            }
        }
        else if (str.equals("Hasselt")) {
            switch (cities.get(1)) {
                case "Liege": return 1;
                case "Maastricht": return 2;
                case "Turnhout": return 3;
            }
        }
        else if (str.equals("Leeuwarden")) {
            switch (cities.get(1)) {
                case "Sneek": return 1;
                case "Waddeneilanden": return 3;
            }
        }
        else if (str.equals("Lelystad")) {
            switch (cities.get(1)) {
                case "Sneek": return 2;
                case "Zwolle": return 4;
            }
        }
        else if (str.equals("Liege")) {
            switch (cities.get(1)) {
                case "Maastricht": return 1;
            }
        }
        else if (str.equals("Maastricht")) {
            switch (cities.get(1)) {
                case "Roermond": return 1;
            }
        }
        else if (str.equals("Sneek")) {
            switch (cities.get(1)) {
                case "Waddeneilanden": return 4;
            }
        }        
        return -1;
    }
}
