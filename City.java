
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

    //     @Override
    //     public int compareTo(Object c) {
    //         if (!(c instanceof City) return 0;
    //         return this.getName().compareTo((City c).getName());
    //     }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object c) {
        return c instanceof City && this.name.equals(((City) c).name);
    }
}
