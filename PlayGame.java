import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.ArrayList;
import java.nio.file.*;
import java.util.*;
import java.awt.event.*;
/**
 * PlayGame class.
 * 
 * @author (your name) 
 * @version 3.27.2015
 */
public class PlayGame extends JApplet 
implements MouseListener
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
    protected Image img;
    int startGame = 0;
    boolean paintDest = false;
    private Image[] firstDest= new Image[5];
    private ArrayList<String> availableColors = new ArrayList<String>(Arrays.asList(
                "GREEN", "YELLOW", "RED", "BLUE", "BLACK"));
    boolean high = false;
    boolean click = false;
    int clickX, clickY;
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
        destinationDeck = new Deck();
        addCardToDestinationDeck(new String[] {"Breda", "Eindhoven"}, 7, "images/Breda-Eindhoven.jpg");
        addCardToDestinationDeck(new String[] {"Amsterdam", "'sGravenhage"}, 9, "images/Amsterdam-'sGravenhage.jpg");
        addCardToDestinationDeck(new String[] {"Arnhem", "'sHertogenbosch"}, 10, "images/Arnhem-'sHertogenbosch.jpg");
        addCardToDestinationDeck(new String[] {"Amsterdam", "Rotterdam"}, 10, "images/Amsterdam-Rotterdam.jpg");
        addCardToDestinationDeck(new String[] {"Rotterdam", "Turnhout"}, 12, "images/Rotterdam-Turnhout.jpg");
        addCardToDestinationDeck(new String[] {"Liege", "Duisburg"}, 12, "images/Liege-Duisburg.jpg");
        addCardToDestinationDeck(new String[] {"Haarlem", "Breda"}, 12, "images/Haarlem-Breda.jpg");
        addCardToDestinationDeck(new String[] {"Rotterdam", "Antwerpen"}, 13, "images/Rotterdam-Antwerpen.jpg");
        addCardToDestinationDeck(new String[] {"Amsterdam", "Nijemgen"}, 13, "images/Amsterdam-Nijemgen.jpg");
        addCardToDestinationDeck(new String[] {"Emmen", "Lelystad"}, 13, "images/Emmen-Lelystad.jpg");
        addCardToDestinationDeck(new String[] {"Lingen", "Duisburg"}, 14, "images/Lingen-Duisburg.jpg");
        addCardToDestinationDeck(new String[] {"'sGravenhage", "Antwerpen"}, 14, "images/'sGravenhage-Antwerpen.jpg");
        addCardToDestinationDeck(new String[] {"Groningen", "Enschede"}, 14, "images/Groningen-Enschede.jpg");
        addCardToDestinationDeck(new String[] {"Zwolle", "Haarlem"}, 14, "images/Zwolle-Haarlem.jpg");
        addCardToDestinationDeck(new String[] {"Arnhem", "'sGravenhage"}, 14, "images/Arnhem-'sGravenhage.jpg");
        addCardToDestinationDeck(new String[] {"DenHelder", "Rotterdam"}, 14, "images/DenHelder-Rotterdam.jpg");
        addCardToDestinationDeck(new String[] {"Enschede", "Amsterdam"}, 15, "images/Enschede-Amsterdam.jpg");
        addCardToDestinationDeck(new String[] {"Enschede", "Eindhoven"}, 15, "images/Enschede-Eindhoven.jpg");
        addCardToDestinationDeck(new String[] {"Leeuwarden", "Haarlem"}, 15, "images/Leeuwarden-Haarlem.jpg");
        addCardToDestinationDeck(new String[] {"Emden", "Waddeneilanden"}, 16, "images/Emden-Waddeneilanden.jpg");
        addCardToDestinationDeck(new String[] {"Sneek", "Utrecht"}, 16, "images/Sneek-Utrecht.jpg");
        addCardToDestinationDeck(new String[] {"Zwolle", "Rotterdam"}, 17, "images/Zwolle-Rotterdam.jpg");
        addCardToDestinationDeck(new String[] {"'sGravenhage", "Liege"}, 18, "images/'sGravenhage-Liege.jpg");
        addCardToDestinationDeck(new String[] {"Zwolle", "Maastricht"}, 18, "images/Zwolle-Maastricht.jpg");
        addCardToDestinationDeck(new String[] {"Amsterdam", "Antwerpen"}, 19, "images/Amsterdam-Antwerpen.jpg");
        addCardToDestinationDeck(new String[] {"Utrecht", "Middelburg"}, 19, "images/Utrecht-Middelburg.jpg");
        addCardToDestinationDeck(new String[] {"Waddeneilanden", "'sGravenhage"}, 20, "images/Waddeneilanden-'sGravenhage.jpg");
        addCardToDestinationDeck(new String[] {"Amsterdam", "Maastricht"}, 20, "images/Amsterdam-Maastricht.jpg");
        addCardToDestinationDeck(new String[] {"Roermond", "Middelburg"}, 21, "images/Roermond-Middelburg.jpg");
        addCardToDestinationDeck(new String[] {"Groningen", "Amsterdam"}, 21, "images/Groningen-Amsterdam.jpg");
        addCardToDestinationDeck(new String[] {"Nijmegen", "Antwerpen"}, 21, "images/Nijmegen-Antwerpen.jpg");
        addCardToDestinationDeck(new String[] {"Utrecht", "Hasselt"}, 22, "images/Utrecht-Hasselt.jpg");
        addCardToDestinationDeck(new String[] {"Emden", "Utrecht"}, 22, "images/Emden-Utrecht.jpg");
        addCardToDestinationDeck(new String[] {"Duisburg", "Rotterdam"}, 23, "images/Duisburg-Rotterdam.jpg");
        addCardToDestinationDeck(new String[] {"Leeuwarden", "'sHerlogenbosch"}, 24, "images/Leeuwarden-'sHerlogenbosch.jpg");
        addCardToDestinationDeck(new String[] {"Lelystad", "Aarschot"}, 24, "images/Lelystad-Aarschot.jpg");
        addCardToDestinationDeck(new String[] {"Lingen", "'sGravenhage"}, 26, "images/Lingen-'sGravenhage.jpg");
        addCardToDestinationDeck(new String[] {"Sneek", "Eindhoven"}, 26, "images/Sneek-Eindhoven.jpg");
        addCardToDestinationDeck(new String[] {"DenHelder", "Liege"}, 29, "images/DenHelder-Liege.jpg");
        addCardToDestinationDeck(new String[] {"Groningen", "Breda"}, 31, "images/Groningen-Breda.jpg");
        addCardToDestinationDeck(new String[] {"Waddeneilanden", "Duisburg"}, 31, "images/Waddeneilanden-Duisburg.jpg");
        addCardToDestinationDeck(new String[] {"Leeuwarden", "Antwerpen"}, 32, "images/Leeuwarden-Antwerpen.jpg");
        addCardToDestinationDeck(new String[] {"Emmen", "Antwerpen"}, 33, "images/Emmen-Antwerpen.jpg");
        addCardToDestinationDeck(new String[] {"Groningen", "Middelburg"}, 34,"images/Groningen-Middelburg.jpg");         
    }

    private void addCardToDestinationDeck(String[] c, int scr, String imgpth) {
        destinationDeck.addCard(new DestinationCard(c, scr, imgpth));
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
            //img = backgroundImage.getScaledInstance(860, 645, Image.SCALE_SMOOTH);
            img = backgroundImage.getScaledInstance(1220, 915, Image.SCALE_SMOOTH);
            //boardImage = ImageIO.read(new File("images/board.jpg"));            
        } catch (IOException e) {
        }
    }

    public void mouseEntered( MouseEvent e ) { }

    public void mouseExited( MouseEvent e ) { }

    public void mousePressed( MouseEvent e ) { }

    public void mouseReleased( MouseEvent e ) { }

    public void mouseClicked( MouseEvent e ) {
        clickX = e.getX();
        clickY = e.getY();
        click = true;
        repaint();
        e.consume();
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
        if(paintDest) {
            // JOptionPane.showConfirmDialog(this, "hello");
            g.drawImage(firstDest[0], 640, 40, this);
            g.drawImage(firstDest[1], 980, 40, this);
            g.drawImage(firstDest[2], 640, 470, this);
            g.drawImage(firstDest[3], 980, 470, this);
            g.drawImage(firstDest[4], 800, 280, this);
            if(click)
            {
                // check the position, highlight card
                // add it to player hand at the end
            }
            paintDest = false;
        }
        if (startGame == 0){
            gameOpening(g);
            setUpGame();
        }
        if(high) {
            g.drawImage(img, 0, 0, this);
        }
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
     * Does the start up for the game
     * @param g The graphics object for the applet
     */
    private void gameOpening(Graphics g) {
        g.drawImage(img, 0, 0, this);
        startGame++;
        getGameOptions();
    }

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
            //String inputValue = JOptionPane.showInputDialog("Please choose a color"); 
            String player1Color = (String) JOptionPane.showInputDialog(
                    null, "What color what you like to be",
                    "Message to " + name[i], JOptionPane.QUESTION_MESSAGE, null,
                    availableColors.toArray(), availableColors.get(0));

            availableColors.remove(player1Color);
        }
        return;
    }

    /**
     * Gives players train cards, gives them destination cards to choose from
     * lets them choose
     */
    private void setUpGame() {
        createDestinationDeck();
        paintDest = true;
        try {
            for (int i=0; i<numPlayers; i++) {

                DestinationCard[] draw = new DestinationCard[5];
                for (int c=0; c<5; c++)
                    draw[c] = (DestinationCard) /*board.*/destinationDeck.drawCard();
                // display the cards in draw
                //Path[] imagePaths = new Path[5];
                // temporary manually add paths
                draw[0].setImagePath(new File("images/7.jpg").toPath());
                draw[1].setImagePath(new File("images/9.jpg").toPath());
                draw[2].setImagePath(new File("images/12.jpg").toPath());
                draw[3].setImagePath(new File("images/13.jpg").toPath());  
                draw[4].setImagePath(new File("images/14.jpg").toPath());
                for (int k = 0; k < draw.length; k++) {
                    // display the card
                    BufferedImage cardImage = ImageIO.read(draw[k].getImagePath().toFile());
                    //Scales the destination cards
                    Image cardImageScaled = cardImage.getScaledInstance(150, 240, Image.SCALE_SMOOTH);
                    firstDest[k] = cardImageScaled;
                }                
                repaint();
                JOptionPane.showConfirmDialog(this, name[i] + ", choose cards");
            }
        }
        catch (Exception e) {JOptionPane.showConfirmDialog(this, e.toString()); }
    }
}
