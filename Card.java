import java.nio.file.Path;
/**
 * Abstract class Card
 * 
 * @author (your name here)
 * @version 3.27.2015
 */
public abstract class Card
{
    public String type;
    protected Path imagePath;

    /**
     * returns the image path of this card
     * @return the image path of this card
     */
    public Path getImagePath() {
        return imagePath;
    }

    /**
     * sets the image path of this card
     */
    public void setImagePath(Path p) {
        imagePath = p;
    }
}
