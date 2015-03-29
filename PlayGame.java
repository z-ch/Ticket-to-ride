import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.ArrayList;
import java.nio.file.*;
/**
 * PlayGame class.
 * 
 * @author (your name) 
 * @version 3.27.2015
 */
public class PlayGame extends JApplet
{
    public Deck destinationDeck, trainDeck; // TODO: put these in the board!
    public Graph graph;
    protected BufferedImage backgroundImage = null; //protected BufferedImage boardImage = null;
    private int numPlayers = 0;
    protected String[] colors;
    protected String[] name;
    // maybe not have these next two ?? since they're in player
    private ArrayList<TrainCarCard>[] playerTrainCarCardHands;
    private ArrayList<DestinationCard>[] playerDestinationCardHands;
    private Board gameBoard;

    /**
     * Create all the TrainCarCards
     */
    private void createTrainDeck() {
        String colors[] = new String[] {"purple", "white", "blue", 
                "yellow", "orange", "black",
                "red", "green" };
        for (int i=0; i<colors.length; i++)
            for (int j=0; j<12; j++)
                trainDeck.addCard(new TrainCarCard(colors[i]));

        for (int i=0; i<14; i++)
            trainDeck.addCard(new TrainCarCard("rainbow"));
    }

    /**
     * Create all the destination cards
     * TODO: line wrapping by adding method
     */
    private void createDestinationDeck(){
        destinationDeck.addCard(new DestinationCard(new String[] {"Breda", "Eindhoven",}, 7));
        destinationDeck.addCard(new DestinationCard(new String[] {"Amsterdam", "‘s-Gravenhage",}, 9));
        destinationDeck.addCard(new DestinationCard(new String[] {"Arnhem", "‘s-Hertogenbosch",}, 10));
        destinationDeck.addCard(new DestinationCard(new String[] {"Amsterdam", "Rotterdam",}, 10));
        destinationDeck.addCard(new DestinationCard(new String[] {"Rotterdam", "Turnhout",}, 12));
        destinationDeck.addCard(new DestinationCard(new String[] {"Liege", "Duisburg",}, 12));
        destinationDeck.addCard(new DestinationCard(new String[] {"Haarlem", "Breda",}, 12));
        destinationDeck.addCard(new DestinationCard(new String[] {"Rotterdam", "Antwerpen",}, 13));
        destinationDeck.addCard(new DestinationCard(new String[] {"Amsterdam", "Nijemgen",}, 13));
        destinationDeck.addCard(new DestinationCard(new String[] {"Emmen", "Lelystad",}, 13));
        destinationDeck.addCard(new DestinationCard(new String[] {"Lingen", "Duisburg",}, 14));
        destinationDeck.addCard(new DestinationCard(new String[] {"‘s-Gravenhage", "Antwerpen",}, 14));
        destinationDeck.addCard(new DestinationCard(new String[] {"Groningen", "Enschede",}, 14));
        destinationDeck.addCard(new DestinationCard(new String[] {"Zwolle", "Haarlem",}, 14));
        destinationDeck.addCard(new DestinationCard(new String[] {"Arnhem", "‘s-Gravenhage",}, 14));
        destinationDeck.addCard(new DestinationCard(new String[] {"DenHelder", "Rotterdam",}, 14));
        destinationDeck.addCard(new DestinationCard(new String[] {"Enschede", "Amsterdam",}, 15));
        destinationDeck.addCard(new DestinationCard(new String[] {"Enschede", "Eindhoven",}, 15));
        destinationDeck.addCard(new DestinationCard(new String[] {"Leeuwarden", "Haarlem",}, 15));
        destinationDeck.addCard(new DestinationCard(new String[] {"Emden", "Waddeneilanden",}, 16));
        destinationDeck.addCard(new DestinationCard(new String[] {"Sneek", "Utrecht",}, 16));
        destinationDeck.addCard(new DestinationCard(new String[] {"Zwolle", "Rotterdam",}, 17));
        destinationDeck.addCard(new DestinationCard(new String[] {"‘s-Gravenhage", "Liege",}, 18));
        destinationDeck.addCard(new DestinationCard(new String[] {"Zwolle", "Maastricht",}, 18));
        destinationDeck.addCard(new DestinationCard(new String[] {"Amsterdam", "Antwerpen",}, 19));
        destinationDeck.addCard(new DestinationCard(new String[] {"Utrecht", "Middelburg",}, 19));
        destinationDeck.addCard(new DestinationCard(new String[] {"Waddeneilanden", "‘s-Gravenhage",}, 20));
        destinationDeck.addCard(new DestinationCard(new String[] {"Amsterdam", "Maastricht",}, 20));
        destinationDeck.addCard(new DestinationCard(new String[] {"Roermond", "Middelburg",}, 21));
        destinationDeck.addCard(new DestinationCard(new String[] {"Groningen", "Amsterdam",}, 21));
        destinationDeck.addCard(new DestinationCard(new String[] {"Nijmegen", "Antwerpen",}, 21));
        destinationDeck.addCard(new DestinationCard(new String[] {"Utrecht", "Hasselt",}, 22));
        destinationDeck.addCard(new DestinationCard(new String[] {"Emden", "Utrecht",}, 22));
        destinationDeck.addCard(new DestinationCard(new String[] {"Duisburg", "Rotterdam",}, 23));
        destinationDeck.addCard(new DestinationCard(new String[] {"Leeuwarden", "‘s-Herlogenbosch",}, 24));
        destinationDeck.addCard(new DestinationCard(new String[] {"Lelystad", "Aarschot",}, 24));
        destinationDeck.addCard(new DestinationCard(new String[] {"Lingen", "‘s-Gravenhage",}, 26));
        destinationDeck.addCard(new DestinationCard(new String[] {"Sneek", "Eindhoven",}, 26));
        destinationDeck.addCard(new DestinationCard(new String[] {"DenHelder", "Liege",}, 29));
        destinationDeck.addCard(new DestinationCard(new String[] {"Groningen", "Breda",}, 31));
        destinationDeck.addCard(new DestinationCard(new String[] {"Waddeneilanden", "Duisburg",}, 31));
        destinationDeck.addCard(new DestinationCard(new String[] {"Leeuwarden", "Antwerpen",}, 32));
        destinationDeck.addCard(new DestinationCard(new String[] {"Emmen", "Antwerpen",}, 33));
        destinationDeck.addCard(new DestinationCard(new String[] {"Groningen", "Middelburg",}, 34));         
    }
    
    /**
     * creates the game board
     */
    private void createGameBoard() {
        gameBoard = new Board();
    }

    //// begin pasted stuff

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
        // this is a workaround for a security conflict with some browsers
        // including some versions of Netscape & Internet Explorer which do 
        // not allow access to the AWT system event queue which JApplets do 
        // on startup to check access. May not be necessary with your browser. 
        JRootPane rootPane = this.getRootPane();    
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);

        // provide any initialisation necessary for your JApplet

        try {
            backgroundImage = ImageIO.read(new File("images/finishedBoard.png"));
            //boardImage = ImageIO.read(new File("images/board.jpg"));
        } catch (IOException e) {
        }
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that it 
     * should start its execution. It is called after the init method and 
     * each time the JApplet is revisited in a Web page. 
     */
    public void start()
    {
        // provide any code requred to run each time 
        // web page is visited
        getGameOptions();
    }

    /** 
     * Called by the browser or applet viewer to inform this JApplet that
     * it should stop its execution. It is called when the Web page that
     * contains this JApplet has been replaced by another page, and also
     * just before the JApplet is to be destroyed. 
     */
    public void stop()
    {
        // provide any code that needs to be run when page
        // is replaced by another page or before JApplet is destroyed 
    }

    /**
     * Paint method for applet.
     * 
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g)
    {
        // simple text displayed on applet
        //         g.setColor(Color.white);
        //         g.fillRect(0, 0, 200, 100);
        //         g.setColor(Color.black);
        //         g.drawString("Sample Applet", 20, 20);
        //         g.setColor(Color.blue);
        //         g.drawString("created by BlueJ", 20, 40);
        g.drawImage(backgroundImage, 0, 0, this); // I don't know if this is right
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * is being reclaimed and that it should destroy any resources that it
     * has allocated. The stop method will always be called before destroy. 
     */
    public void destroy()
    {
        // provide code to be run when JApplet is about to be destroyed.
    }

    /**
     * Returns information about this applet. 
     * An applet should override this method to return a String containing 
     * information about the author, version, and copyright of the JApplet.
     *
     * @return a String representation of information about this JApplet
     */
    public String getAppletInfo()
    {
        // provide information about the applet
        return "Title:   \nAuthor:   \nA simple applet example description. ";
    }

    /**
     * Returns parameter information about this JApplet. 
     * Returns information about the parameters than are understood by this JApplet.
     * An applet should override this method to return an array of Strings 
     * describing these parameters. 
     * Each element of the array should be a set of three Strings containing 
     * the name, the type, and a description.
     *
     * @return a String[] representation of parameter information about this JApplet
     */
    public String[][] getParameterInfo()
    {
        // provide parameter information about the applet
        String paramInfo[][] = {
                {"firstParameter",    "1-10",    "description of first parameter"},
                {"status", "boolean", "description of second parameter"},
                {"images",   "url",     "description of third parameter"}
            };
        return paramInfo;
    }
    /// end pasted stuff

    /**
     * Gets user input to set up the game (number of players, etc)
     * TODO get the player hands working
     */
    private void getGameOptions() {
        while (numPlayers < 2 || numPlayers > 5) {
            String numPlayerString = JOptionPane.showInputDialog("Input Number of players (2-5)");
            numPlayers = Integer.parseInt(numPlayerString);
        }

        name = new String[numPlayers];
        //playerTrainCarCardHands = new ArrayList[numPlayers];
        //playerDestinationCardHands = new ArrayList<DestinationCard>[numPlayers];

        for(int i = 0; i < numPlayers; i++) {
            String numPlayerName = JOptionPane.showInputDialog("Input Name of Player " +(i+1));
            name[i] = numPlayerName;
        }

        for(int i = 0; i < numPlayers; i++) {
            String inputValue = JOptionPane.showInputDialog("Please choose a color"); 
        }
        
        
    }

    /**
     * Gives players train cards, gives them destination cards to choose from
     * lets them choose 
     */
    private void setupGame() {
        for (int i=0; i<numPlayers; i++) {
            DestinationCard[] draw = new DestinationCard[5];
            for (int c=0; c<5; c++)
                draw[c] = (DestinationCard) /*board.*/destinationDeck.drawCard();
            // display the cards in draw
            Path[] imagePaths = new Path[5];
            for (Card c : draw) {
                // display the card
                // new window?
                // 
                Path imagePath = c.getImagePath();
            }
            // pop up window for cards to appear
            for (int d=0; d<imagePaths.length; d++) {
                // in window display(imagePaths[d], ...
                // 1050 window height 670 * 5 window width
                //display location = (670*numberofcardsonscreen,0)
            }
            
        }
    }
}
