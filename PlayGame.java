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
    public Deck destinationDeck, trainDeck; // TODO: put these in the board!!!
    public Graph graph;
    protected BufferedImage backgroundImage = null; //protected BufferedImage boardImage = null;
    protected BufferedImage backgroundImage2 = null;
    private int numPlayers = 0;
    protected String[] colors;
    protected String[] name;
    // maybe not have these next two ?? since they're in player
    //private ArrayList<TrainCarCard>[] playerTrainCarCardHands;
    //private ArrayList<DestinationCard>[] playerDestinationCardHands;
    // private ArrayList<TrainCarCard> river = new ArrayList<>(); // 
    private Board gameBoard;
    protected Image img, img2;
    int startGame = 0;
    boolean paintDest = false;
    private Image[] firstDest= new Image[5];
    private ArrayList<String> availableColors = new ArrayList<String>(Arrays.asList(
                "GREEN", "YELLOW", "RED", "BLUE", "BLACK"));
    protected Player[] playerList;
    int currentPlayer = 0;
    boolean now = false;
    //     int clickX, clickY;
    //     boolean click = false;

    public PlayGame() {
        createDestinationDeck();
    }

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
        // need to scan next file
        //addCardToDestinationDeck(new String[] {"Enschede", "Amsterdam"}, 15, "images/Enschede-Amsterdam.jpg");
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
            backgroundImage2 = ImageIO.read(new File("images/sample3.png"));
            //img = backgroundImage.getScaledInstance(860, 645, Image.SCALE_SMOOTH);
            img = backgroundImage.getScaledInstance(1220, 915, Image.SCALE_SMOOTH);
            img2 = backgroundImage2.getScaledInstance(1220, 915, Image.SCALE_SMOOTH);
            //boardImage = ImageIO.read(new File("images/board.jpg"));            
        } catch (IOException e) {
        }
    }

    public void mouseEntered( MouseEvent e ) { }

    public void mouseExited( MouseEvent e ) { }

    public void mousePressed( MouseEvent e ) { }

    public void mouseReleased( MouseEvent e ) { }

    public void mouseClicked( MouseEvent e ) {
        //         clickX = e.getX();
        //         clickY = e.getY();
        //         click = true;
        //         repaint();
        //         e.consume();
    }

    /**
     * Paint method for applet.
     * 
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g)
    {
        if (startGame == 0){
            gameOpening(g);
            setUpGame(g);
        }
        if(now){

            g.drawImage(img2, 0, 0, this);
            drawTrains(g);
        }

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
     * Draws the tarins on the board
     * @param g The graphics object for the applet
     */
    public void drawTrains(Graphics g) {
        g.setColor(new Color(255,0,255, 128));
        //draw Polygons for trains
        g.fillPolygon(new int[]{428, 439, 443, 433}, new int[]{101, 102, 211, 210}, 4);
        g.fillPolygon(new int[]{453, 458,  484, 506, 525, 541, 553, 558, 548, 543, 531, 518, 499, 477}, new int[]{92, 83, 97, 115, 136, 161, 188, 216, 218, 191, 167, 143, 123, 105}, 14);
        g.fillPolygon(new int[]{444, 448, 475, 497, 517, 531, 543, 548, 539, 534, 523, 508, 491, 469}, new int[]{100, 90, 105, 123, 145, 169, 195, 223, 225, 200, 175, 152, 131, 113}, 14);
        g.fillPolygon(new int[]{423, 352, 347, 419}, new int[]{100, 141, 133, 91}, 4);
        g.fillPolygon(new int[]{413, 418, 346, 341}, new int[]{82, 90, 131, 124}, 4);
        g.fillPolygon(new int[]{364, 425, 418, 358}, new int[]{152, 206, 213, 159}, 4);
        g.fillPolygon(new int[]{357, 417, 411, 350}, new int[]{160, 214, 222, 168}, 4);
        g.fillPolygon(new int[]{315, 312, 286, 258, 230, 204, 179, 158, 152, 174, 200, 229, 258, 287}, new int[]{135, 144, 139, 138, 142, 150, 163, 179, 171, 155, 141, 132, 128, 129}, 14);
        g.fillPolygon(new int[]{306, 310, 239, 233}, new int[]{146, 154, 196, 189}, 4);
        g.fillPolygon(new int[]{311, 316, 244, 239}, new int[]{156, 164, 207, 198}, 4);
        g.fillPolygon(new int[]{453, 535, 533, 451}, new int[]{217, 228, 237, 226}, 4);
        g.fillPolygon(new int[]{451, 533, 532, 450}, new int[]{228, 239, 249, 236}, 4);

    }

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
            playerList = new Player[numPlayers];
            for (int i=0; i<numPlayers; i++)
                playerList[i] = new Player();
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
     * @param g The graphics object for the applet 
     */
    private void setUpGame(Graphics g) {
        createDestinationDeck();
        paintDest = true;
        try {
            for (int i=0; i<numPlayers; i++) {

                DestinationCard[] draw = new DestinationCard[5];
                for (int c=0; c<5; c++)
                    draw[c] = (DestinationCard) /*board.*/destinationDeck.drawCard();
                // display the cards in draw
                for (int k = 0; k < draw.length; k++) {
                    // display the card
                    //JOptionPane.showConfirmDialog(this, draw[k].getImagePath());
                    BufferedImage cardImage = ImageIO.read(draw[k].getImagePath().toFile());
                    //Scales the destination cards
                    Image cardImageScaled = cardImage.getScaledInstance(150, 240, Image.SCALE_SMOOTH);
                    firstDest[k] = cardImageScaled;
                }                

                g.drawImage(firstDest[0], 640, 40, this);
                g.drawImage(firstDest[1], 980, 40, this);
                g.drawImage(firstDest[2], 640, 470, this);
                g.drawImage(firstDest[3], 980, 470, this);
                g.drawImage(firstDest[4], 800, 280, this);

                JCheckBox   card1 = new JCheckBox(draw[0].getImagePath().toString());
                JCheckBox   card2 = new JCheckBox(draw[1].getImagePath().toString());
                JCheckBox   card3 = new JCheckBox(draw[2].getImagePath().toString());
                JCheckBox   card4 = new JCheckBox(draw[3].getImagePath().toString());
                JCheckBox   card5 = new JCheckBox(draw[4].getImagePath().toString());
                String msg = "Choose your destination cards " + name[i]; 

                Object[] choices = {msg, card1, card2, card3, card4, card5};

                int numSelectedCards = 0; boolean selected[] = new boolean[5];
                while (numSelectedCards < 3) {
                    numSelectedCards = 0;
                    int n = JOptionPane.showConfirmDialog ( this,  choices,  "Choose 3 or more Cards, " + name[i], JOptionPane.YES_NO_OPTION); 
                    selected = new boolean[] { card1.isSelected(), card2.isSelected(), card3.isSelected(), card4.isSelected(), card5.isSelected() };
                    for (boolean b : selected)
                        if (b)
                            ++numSelectedCards;
                }

                for (int bool=0; bool<5; bool++) {
                    //If the card is selected, puts it in the players hand
                    if (selected[bool]) {
                        playerList[i].addDestinationCard(draw[bool]);
                    }
                    else {
                        destinationDeck.addCard(draw[bool]);    //Adds back the cards into the deck
                    }
                }
            }
            now = true;
            //JOptionPane.showConfirmDialog(this, name[i] + ", choose cards");
        }

        catch (Exception e) {JOptionPane.showConfirmDialog(this, e.toString()); }
        playerTurn(playerList[currentPlayer]);
    }

    public static void test() {
        try {
            PlayGame pg = new PlayGame();
            if (pg.destinationDeck == null) System.out.println("deck");
            if (pg.destinationDeck.cards == null) System.out.println("cards");
            for (Card c : pg.destinationDeck.cards) {
                System.out.print(c.getImagePath() + " ");
                BufferedImage cardImage = ImageIO.read(c.getImagePath().toFile());
                System.out.println("OK");
            }
            System.out.println("ALL OK");

        } catch (IOException e) { System.out.println("AAAAAHHHHH"); }
        catch (NullPointerException e) { System.out.println(e); }
    }

    //80 chars******************************************************************
    /**
     * Allows the currentPlayer to take their turn. Once gameplay starts, this 
     * will run on consecutive players until someone runs out of train tokens.
     * 
     * @param currentPlayer the player who's turn it is
     */

    private void playerTurn(Player currentPlayer) {
        boolean trainDeckDraw, trainRiverDraw = false;
        boolean destinationDeckDraw = true, purchaseRoute = false;
        trainDeckDraw = false;
        // need to check somewhere if the decks are empty
        if (trainDeckDraw) 
            for (int i=0; i<2; i++) 
                currentPlayer.drawTrainCarCard(trainDeck);
        if (trainRiverDraw) { // maybe checkboxes instead?
            int clickedCard = 0; // 0-4 inclusive
            if (gameBoard.river.get(clickedCard).getColor().equals("rainbow")) {
                currentPlayer.addTrainCarCard(gameBoard.river.remove(clickedCard));
                gameBoard.river.add(clickedCard, (TrainCarCard) /*gameBoard.*/trainDeck.drawCard());
            }
            else {
                currentPlayer.addTrainCarCard(gameBoard.river.remove(clickedCard));
                gameBoard.river.add(clickedCard, (TrainCarCard) /*gameBoard.*/trainDeck.drawCard());
                repaint(); //??
                clickedCard = 1; // clicks new card THEY CAN'T CLICK RAINBOWS NOW DO THAT IN GUI
                currentPlayer.addTrainCarCard(gameBoard.river.remove(clickedCard));
                gameBoard.river.add(clickedCard, (TrainCarCard) /*gameBoard.*/trainDeck.drawCard());   
            }
        }
        else if (destinationDeckDraw) {
            //do the draw method from setupgame but 4 and 1
            drawDestinationCardsInGame();
        }
        else if (purchaseRoute) {
            // somehow the GUI will get two cities
            //start temp
            City city1, city2; 
            city1 = CityList.getCity("Leeuwarden");
            city2 = CityList.getCity("Sneek");
            //end temp
            if (graph.hasEdge(city1.getName(),city2.getName())) { // also make sure the edge isn't taken!
                boolean isDouble = graph.isDouble(city1, city2);
                int ownerCount = 0;
                for (Player pr : playerList) 
                    if (pr.hasRoute(city1, city2)) ++ownerCount;
                if (!isDouble) {
                    if (ownerCount > 0) {
                        // don't let them buy the route
                    }
                    else {
                        // buy route from bank
                    }
                }
                else {
                    if (ownerCount == 0) {
                        // buy route from bank
                    }
                    if (ownerCount == 1) {
                        // buy route from owner
                    }
                    else {
                        // don't let them buy the route
                    }
                }
                // draw the edge on the board
                // add the edge to the "taken" edges
                // know which player got the edge
            }
        }
    }

    /**
     * Drawing destination cards during the game, copied from setupgame
     */
    private void drawDestinationCardsInGame() {
        try {
            Graphics g = getGraphics();
            for (int i=0; i<numPlayers; i++) {

                DestinationCard[] draw = new DestinationCard[4];
                for (int c=0; c<4; c++)
                    draw[c] = (DestinationCard) /*board.*/destinationDeck.drawCard();
                // display the cards in draw
                for (int k = 0; k < draw.length; k++) {
                    // display the card
                    //JOptionPane.showConfirmDialog(this, draw[k].getImagePath());
                    BufferedImage cardImage = ImageIO.read(draw[k].getImagePath().toFile());
                    //Scales the destination cards
                    Image cardImageScaled = cardImage.getScaledInstance(150, 240, Image.SCALE_SMOOTH);
                    firstDest[k] = cardImageScaled;
                }                

                g.drawImage(firstDest[0], 640, 40, this);
                g.drawImage(firstDest[1], 980, 40, this);
                g.drawImage(firstDest[2], 640, 470, this);
                g.drawImage(firstDest[3], 980, 470, this);

                JCheckBox   card1 = new JCheckBox(draw[0].getImagePath().toString());
                JCheckBox   card2 = new JCheckBox(draw[1].getImagePath().toString());
                JCheckBox   card3 = new JCheckBox(draw[2].getImagePath().toString());
                JCheckBox   card4 = new JCheckBox(draw[3].getImagePath().toString());
                String msg = "Choose your destination cards " + name[i]; 

                Object[] choices = {msg, card1, card2, card3, card4};

                int numSelectedCards = 0; boolean selected[] = new boolean[4];
                while (numSelectedCards < 1) {
                    numSelectedCards = 0;
                    int n = JOptionPane.showConfirmDialog ( this,  choices,  "Choose 1 or more Cards, " + name[i], JOptionPane.YES_NO_OPTION); 
                    selected = new boolean[] { card1.isSelected(), card2.isSelected(), card3.isSelected(), card4.isSelected() };
                    for (boolean b : selected)
                        if (b)
                            ++numSelectedCards;
                }

                for (int bool=0; bool<4; bool++) {
                    //If the card is selected, puts it in the players hand
                    if (selected[bool]) {
                        playerList[i].addDestinationCard(draw[bool]);
                    }
                    else {
                        destinationDeck.addCard(draw[bool]);    //Adds back the cards into the deck
                    }
                }
            }
        }
        catch (IOException e) {}
    }

    // draw train cards from deck, or from river
    // draw destination cards
    // OR you can buy a route
}

