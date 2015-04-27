import java.io.File;
import java.nio.file.*;
/**
 * Write a description of class TrainCarCard here.
 * 
 * @author (your name) 
 * @version 3.22.2015
 */
public class TrainCarCard extends Card
{
    protected String color;
    /**
     * Constructor for TrainCarCard Class
     */
    public TrainCarCard() {
        type = "TrainCarCard";
        color = "blue";
    }
    
    /**
     * Constructor for TrainCarCard Class 
     * @param c The color of the train car card
     */
    public TrainCarCard(String c) {
        this();
        color = c;
    }

    /**
     * Constructor for TrainCarCard Class 
     * @param c The color of the train car card
     * @param p String representation of this TrainCarCard's
     #        image path
     */
    public TrainCarCard(String c, String p) {
        color = c; imagePath = (new File(p)).toPath();
    }
    
    /**
     * Returns this Card's color
     * @return this.color
     */
    public String getColor() {
        return color;
    }

    /**
     * equals method for TrainCarCard objects
     * @param tcc Object to compare to
     * @return true if tcc is a TrainCarCard with
     *         the same color as this
     */
    @Override
    public boolean equals(Object tcc) {
        return tcc instanceof TrainCarCard && color.equals(((TrainCarCard) tcc).color);
    }
}
