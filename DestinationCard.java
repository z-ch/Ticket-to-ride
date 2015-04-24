import java.nio.file.Path;
import java.io.File;
/**
 * DestinationCard class
 * 
 * @author (your name) 
 * @version 3.22.2015
 */
public class DestinationCard extends Card
{
    protected final String cities[] = new String[2];
    protected final int value;

    /**
     * Constructor for DestinationCard Class 
     * @param c[] 2 element  array of cities
     */
    public DestinationCard(String c[], int v) {
        type = "DestinationCard";
        cities[0] = c[0]; cities[1] = c[1];
        value = v;
    }
    
    /**
     * Constructor for DestinationCard class with path
     * 
     */
    public DestinationCard(String c[], int v, Path p) {
        this(c,v);
        imagePath = p;
    }

    public DestinationCard(String c[], int v, String p) {
        this(c,v);
        imagePath = (new File(p)).toPath();
    }

    /**
     * Returns this Card's value
     * @return this.value
     */
    public int getValue() {
        return value;
    }
    
    public String toString() {
        return cities[0] + "-" + cities[1];
    }
    
    public String[] getCities() {
        return new String[] { cities[0], cities[1] };
    }
}
