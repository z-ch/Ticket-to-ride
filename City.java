
/**
 * City class
 * 
 * @author (your name) 
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
    
    public int compareTo(City c) {
        return this.getName().compareTo(c.getName());
    }
}
