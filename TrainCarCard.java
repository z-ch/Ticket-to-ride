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
    
    @Override
    public boolean equals(Object tcc) {
        return tcc instanceof TrainCarCard && color.equals(((TrainCarCard) tcc).color);
    }
}
