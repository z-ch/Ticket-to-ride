
/**
 * Class city creates a city 
 * object consisting of the names of the various cities
 * 
 * @author (Koushik P, 
 * Zach S, Ryan W, Theresa S, Andi E) 
 * @version 3.22.2015
 */
public class City
{
    protected String name;

    /**
     * Constructor for objects of class City
     * @param n name to set
     */
    public City(String n) {
        name = n;
    }

    /**
     * returns this City's name
     * @return this.name
     */
    public String getName() {
        return name;
    }

    /**
     * returns String representation of this City
     * @return String representation of this City 
     *         (only name)
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Checks to see if this city equals another city
     * only checks if the city names are the same
     * @param c Object to compare to
     * @return true if this city has the same name as c,
     *         false otherwise
     */
    @Override
    public boolean equals(Object c) {
        return c instanceof City && this.name.equals(((City) c).name);
    }
}
