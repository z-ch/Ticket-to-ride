import java.nio.file.Path;
/**
 * Super class containing methods and variables used in both 
 * destination cards and train car card
 * 
 * @author (Koushik P, Zach S,
 * Ryan W, Theresa S, Andi E)
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
