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
    
    public Path getImagePath() {
        return imagePath;
    }
    
}
