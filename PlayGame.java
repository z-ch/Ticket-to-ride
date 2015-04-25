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
    public Graph graph = new Graph();
    public RouteTrains routeTrains = new RouteTrains();
    protected BufferedImage backgroundImage = null; //protected BufferedImage boardImage = null;
    protected BufferedImage backgroundImage2 = null;
    protected BufferedImage cardBack = null;
    private int numPlayers = 0;
    protected String[] colors;
    protected String[] name;
    // maybe not have these next two ?? since they're in player
    //private ArrayList<TrainCarCard>[] playerTrainCarCardHands;
    //private ArrayList<DestinationCard>[] playerDestinationCardHands;
    // private ArrayList<TrainCarCard> river = new ArrayList<>(); // 
    private Board gameBoard = new Board();
    protected Image img, img2;
    protected Image backDestCard;
    int startGame = 0;
    boolean paintDest = false;
    private Image[] firstDest= new Image[5];
    private ArrayList<String> availableColors = new ArrayList<String>(Arrays.asList(
                "GREEN", "YELLOW", "RED", "BLUE", "BLACK"));
    protected Player[] playerList;
    int currPlayer = 0;
    boolean now = false;
    int clickX, clickY;
    boolean click = false;
    boolean destinationDeckDraw = false; 
    boolean chooseDestClicked = true;
    boolean trainDeckDraw = false;
    boolean trainRiverDraw = false;
    boolean purchaseRoute = false;
    int trainDrawCount = 0;
    int clickedCard;   //0-4 inclusive
    String cityNameRouteOne, cityNameRouteTwo;
    ArrayList<Polygon> boughtRoutesPoly = new ArrayList<Polygon>();
    ArrayList<Color> boughtRoutesPolyColor = new ArrayList<Color>();
    private Player lastPlayer = null;
    private boolean lastTurn = false;
    private boolean goingOneLastTime = true;
    private boolean lastPaint = false;
    private boolean gameOver = false;

    // delete this?
    public PlayGame() {
        createDestinationDeck();
    }

    /**
     * Create all the TrainCarCards
     */
    private void createTrainDeck() {
        trainDeck = new Deck();
        String colors[] = new String[] {"purple", "white", "blue", 
                "yellow", "orange", "black",
                "red", "green" };
        for (int i=0; i<colors.length; i++) {
            String path = "images/";
            if (colors[i].equals("purple")) path += "purple.jpg";
            if (colors[i].equals("white")) path += "white.jpg";
            if (colors[i].equals("blue")) path += "blue.jpg";
            if (colors[i].equals("yellow")) path += "yellow.jpg";
            if (colors[i].equals("orange")) path += "orange.jpg";
            if (colors[i].equals("black")) path += "black.jpg";
            if (colors[i].equals("red")) path += "red.jpg";
            if (colors[i].equals("green")) path += "green.jpg";
            for (int j=0; j<12; j++)
                trainDeck.addCard(new TrainCarCard(colors[i], path));
        }

        for (int i=0; i<14; i++) {
            String path = "images/rainbow.jpg";
            trainDeck.addCard(new TrainCarCard("rainbow", path));
        }
    }

    /**
     * Create all the destination cards
     * TODO: line wrapping 
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
        addCardToDestinationDeck(new String[] {"Emden", "Waddensilanden"}, 16, "images/Emden-Waddensilanden.jpg");
        addCardToDestinationDeck(new String[] {"Sneek", "Utrecht"}, 16, "images/Sneek-Utrecht.jpg");
        addCardToDestinationDeck(new String[] {"Zwolle", "Rotterdam"}, 17, "images/Zwolle-Rotterdam.jpg");
        addCardToDestinationDeck(new String[] {"'sGravenhage", "Liege"}, 18, "images/'sGravenhage-Liege.jpg");
        addCardToDestinationDeck(new String[] {"Zwolle", "Maastricht"}, 18, "images/Zwolle-Maastricht.jpg");
        addCardToDestinationDeck(new String[] {"Amsterdam", "Antwerpen"}, 19, "images/Amsterdam-Antwerpen.jpg");
        addCardToDestinationDeck(new String[] {"Utrecht", "Middelburg"}, 19, "images/Utrecht-Middelburg.jpg");
        addCardToDestinationDeck(new String[] {"Waddensilanden", "'sGravenhage"}, 20, "images/Waddensilanden-'sGravenhage.jpg");
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
        addCardToDestinationDeck(new String[] {"Waddensilanden", "Duisburg"}, 31, "images/Waddensilanden-Duisburg.jpg");
        addCardToDestinationDeck(new String[] {"Leeuwarden", "Antwerpen"}, 32, "images/Leeuwarden-Antwerpen.jpg");
        addCardToDestinationDeck(new String[] {"Emmen", "Antwerpen"}, 33, "images/Emmen-Antwerpen.jpg");
        addCardToDestinationDeck(new String[] {"Groningen", "Middelburg"}, 34,"images/Groningen-Middelburg.jpg");         
    }

    /**
     * Adds a card to the game's destination deck
     * @param c names of cities in destination card
     * @param scr score of destinationcard
     * @param imgpth String represenation of imagepath
     */
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
        addMouseListener(this);
        // provide any initialisation necessary for your JApplet

        try {
            backgroundImage = ImageIO.read(new File("images/finishedBoard.png"));
            backgroundImage2 = ImageIO.read(new File("images/sample3.png"));
            cardBack = ImageIO.read(new File("images/cardback.jpg"));
            //img = backgroundImage.getScaledInstance(860, 645, Image.SCALE_SMOOTH);
            img = backgroundImage.getScaledInstance(1220, 915, Image.SCALE_SMOOTH);
            img2 = backgroundImage2.getScaledInstance(1220, 915, Image.SCALE_SMOOTH);
            backDestCard = cardBack.getScaledInstance(79, 50, Image.SCALE_SMOOTH);
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
     * Paint method for applet.
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g) {
        if (gameOver)
            return;
        int lastPlayer = currPlayer;
        //if (lastPaint)
        //endGame();

        if (startGame == 0){
            gameOpening(g);
            setUpGame(g);
        }

        if (playerList[currPlayer].last)
            lastPaint = true;

        if(now){
            g.drawImage(img2, 0, 0, this);
            //drawRiver(g); //Here will be the first five train cards drawn
            showCards(g);            
            drawPlayerNameAndCars(g);        //This to represent the players cars being drawn to board
            drawTrains(g); // This was used here to make sure the trains on the
            //actual board were being drawn correctly
            now = false;
            drawRiver(g);     //Draws the 5 train cards needed
            checkIfLastPlayer(playerList[currPlayer]);
            checkIfGameIsAlmostOver();
            //whatCardsIHave(g);
        }
        //HAVE TO SEE IF THE DEST CARD IS CLICKED IF IT WILL GO TO THE RIGHT PLAYER
        if(click) {
            click = false;
            if(clickX >= 678 && clickY >= 47 && clickX <= 881 && clickY <= 175 && (trainDrawCount%2 == 0)) {
                destinationDeckDraw = true;
                playerTurn(playerList[currPlayer]);
                g.drawImage(img2, 0, 0, this);
                showCards(g);
                drawPlayerNameAndCars(g); 
                drawRiver(g);     //Draws the 5 train cards needed
                drawTrains(g);
                checkIfLastPlayer(playerList[currPlayer]);
                checkIfGameIsAlmostOver();
            }

            //Check if the place clicked was on-top of a route
            if(routeClicked() != null && (trainDrawCount%2 == 0)) {
                String[] cityRouteClickedOn = routeClicked();
                cityNameRouteOne = cityRouteClickedOn[0];
                cityNameRouteTwo = cityRouteClickedOn[1];
                purchaseRoute = true;
                JOptionPane.showMessageDialog(this, cityNameRouteOne+ " - " +cityNameRouteTwo+ " ( Color: " +getColorRoute() + " ) ");
                playerTurn(playerList[currPlayer]);
                g.drawImage(img2, 0, 0, this);
                showCards(g);
                drawPlayerNameAndCars(g); 
                drawRiver(g);     //Draws the 5 train cards needed
                drawTrains(g);
                checkIfLastPlayer(playerList[currPlayer]);
                checkIfGameIsAlmostOver();  
            }

            //Show the players current destination cards
            if(clickX >= 930 && clickY >= 780 && clickX <= 1009 && clickY <= 830) {
                //showDestinationCards();   HAVE TO IMPLEMENT
                g.setColor(Color.black);
                g.drawString("HERE", 950, 800);
                g.setFont(new Font("TimesRoman", Font.BOLD, 12));
                showDestinationCards();
                checkIfLastPlayer(playerList[currPlayer]);
                checkIfGameIsAlmostOver();  
            }

            if(clickX >= 911 && clickY >=48 && clickX <= 1114 & clickY <= 173) {
                g.setColor(Color.red);
                g.drawRect(911, 48, 202, 125);                
                trainDeckDraw = true;
                playerTurn(playerList[currPlayer]);
                showCards(g);
                drawRiver(g);     //Draws the 5 train cards needed
                drawTrains(g);
                if(trainDrawCount%2 == 0) {
                    g.drawImage(img2, 0, 0, this); 
                    showCards(g);
                    drawPlayerNameAndCars(g); 
                    drawRiver(g);     //Draws the 5 train cards needed
                    drawTrains(g);
                    checkIfLastPlayer(playerList[currPlayer]);
                    checkIfGameIsAlmostOver();
                }
            }

            if(riverClicked()) {
                trainRiverDraw = true;
                playerTurn(playerList[currPlayer]);
                showCards(g);
                drawRiver(g);     //Draws the 5 train cards needed
                drawTrains(g);
                cardClickedhighLight(g);
                if(trainDrawCount%2 == 0) {
                    g.drawImage(img2, 0, 0, this); 
                    showCards(g);
                    drawPlayerNameAndCars(g); 
                    drawRiver(g);     //Draws the 5 train cards needed
                    drawTrains(g);
                    checkIfLastPlayer(playerList[currPlayer]);
                    checkIfGameIsAlmostOver();
                }
            }
        }
        if (lastPaint && lastPlayer != currPlayer) endGame();

    }

    //TEST FOR CARDS I HAVE : DESTINATION CARDS
    private void whatCardsIHave(Graphics g) {
        g.drawString("Player: " +playerList[currPlayer].name, 700, 320 );
        for(int i = 0; i < playerList[currPlayer].destCards.size(); i++) {
            g.drawString("" +playerList[currPlayer].destCards.get(i).toString(), 700, 350 + i*15 );
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
     * Gets the route color
     * @return the Color of the Route
     */
    public Route.RouteColor getColorRoute() {
        for(int i = 0; i < routeTrains.routeCars.size(); i++) {
            if(routeTrains.routeCars.get(i).contains(clickX, clickY)) {               
                return routeTrains.routeColors.get(i);
            }
        }
        return null;
    }

    /**
     * Checks if the routes on the map were clicked
     * @return the cities of the route clicked, otherwise returns null
     */
    public String[] routeClicked() {
        for(int i = 0; i < routeTrains.routeCars.size(); i++) {
            if(routeTrains.routeCars.get(i).contains(clickX, clickY)) {
                String[] rout = routeTrains.citiesLinked(i);
                //JOptionPane.showMessageDialog(this, rout[0]+ " " +rout[1]);                
                return rout;
            }
        }
        return null;
    }

    /**
     * Gets the polygon of the routes clicked on the map
     * @return the plygon of the route clicked, otherwise returns null
     */
    public Polygon getRoutPoly() {
        for(int i = 0; i < routeTrains.routeCars.size(); i++) {
            if(routeTrains.routeCars.get(i).contains(clickX, clickY)) {
                Polygon rout = routeTrains.getRoutePolygon(i);
                //JOptionPane.showMessageDialog(this, "getRoutPoly()");
                return rout;
            }
        }
        return null;
    }

    /**
     * Gets the current Players color
     * @return the color of the current Player
     */
    public Color getCurPlayerColor(){
        if((playerList[currPlayer].color).equals("GREEN")) 
            return Color.GREEN;
        else if((playerList[currPlayer].color).equals("YELLOW")) 
            return Color.YELLOW;
        else if((playerList[currPlayer].color).equals("RED")) 
            return Color.RED;
        else if((playerList[currPlayer].color).equals("BLUE")) 
            return Color.BLUE;
        else
            return Color.BLACK;
    }

    /**
     * Checks if the river is clicked and makes sure that the right 
     * cards gets drawn back from the drawRiver() method
     */
    public boolean riverClicked() {
        //Basically check where the person clicked and replace that card
        if(clickX >= 685 && clickY >= 295 && clickX <= 764 && clickY <= 418) {
            clickedCard = 0;
            return true;
        }
        else if(clickX >= 770 && clickY >= 295 && clickX <= 849 && clickY <= 418) {
            clickedCard = 1;
            return true;
        }
        else if(clickX >= 855 && clickY >= 295 && clickX <= 934 && clickY <= 418) {
            clickedCard = 2;
            return true;
        }
        else if(clickX >= 940 && clickY >= 295 && clickX <= 1019 && clickY <= 418) {
            clickedCard = 3;
            return true;
        }
        else if(clickX >= 1025 && clickY >= 295 && clickX <= 1104 && clickY <= 418) {
            clickedCard = 4;
            return true;
        }
        return false;
    }

    /**
     * Highlights the river card clicked when the player clikced on the open
     * train cards once
     * @param g The graphics object for the applet
     */
    public void cardClickedhighLight(Graphics g) {
        Color need = getCurPlayerColor();
        g.setColor(need);
        if(clickX >= 685 && clickY >= 295 && clickX <= 764 && clickY <= 418) {
            g.fillRect(685, 420, 79, 2);
        }
        else if(clickX >= 770 && clickY >= 295 && clickX <= 849 && clickY <= 418) {
            g.fillRect(770, 420, 79, 2);
        }
        else if(clickX >= 855 && clickY >= 295 && clickX <= 934 && clickY <= 418) {
            g.fillRect(855, 420, 79, 2);
        }        
        else if(clickX >= 940 && clickY >= 295 && clickX <= 1019 && clickY <= 418) {
            g.fillRect(940, 420, 79, 2);
        }
        else if(clickX >= 1025 && clickY >= 295 && clickX <= 1104 && clickY <= 418) {
            g.fillRect(1025, 420, 79, 2);
        }
    }

    /**
     * Shows the destination cards the current player has
     */
    private void showDestinationCards() {
        try{
            String str = "";
            for (int i=0; i<playerList[currPlayer].getDestCardSize(); i++)
                str += playerList[currPlayer].getDestCard(i).toString() + "\n";
            JOptionPane.showMessageDialog(this, str);

            //             JLabel[] members = new JLabel[playerList[currPlayer].getDestCardSize()];
            //             for (int i=0; i<playerList[currPlayer].getDestCardSize(); i++) {
            //                 BufferedImage cardImage = ImageIO.read(((Card)playerList[currPlayer].getDestCard(i)).getImagePath().toFile());
            //                 //Scales the destination cards
            //                 Image cardImageScaled = cardImage.getScaledInstance(150, 240, Image.SCALE_SMOOTH);
            //                 ImageIcon icon = new ImageIcon(cardImageScaled);
            //                 members[i] = new JLabel(icon,JLabel.LEFT);
            //             }
            //             ArrayList<Object> choices = new ArrayList<Object>();
            //             for(int i = 0; i < members.length; i++) {
            //                 choices.add(members[i]);
            //             }
            // 
            //             JOptionPane.showConfirmDialog ( this,  choices,  "Here are your Destination Cards", JOptionPane.DEFAULT_OPTION); 
            ImageIcon[] icon = new ImageIcon[playerList[currPlayer].getDestCardSize()];
            JLabel[] members = new JLabel[playerList[currPlayer].getDestCardSize()];
            for (int i=0; i<playerList[currPlayer].getDestCardSize(); i++) {
                BufferedImage cardImage = ImageIO.read(((Card)playerList[currPlayer].getDestCard(i)).getImagePath().toFile());
                Image cardImageScaled = cardImage.getScaledInstance(150, 240, Image.SCALE_SMOOTH);
                icon[i] = new ImageIcon(cardImageScaled);
                members[i] = new JLabel(icon[i],JLabel.HORIZONTAL);
            }
            //ImageIcon icon = new ImageIcon(cardImageScaled);
            //             JOptionPane.showMessageDialog(
            //                 null,
            //                 "Hello world",
            //                 "Hello", JOptionPane.INFORMATION_MESSAGE,
            //                 icon);
            JOptionPane.showMessageDialog(
                null,
                members,
                "Hello", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(IOException e) { showStatus(e.toString()); }
        //choice= JOptionPane.showOptionDialog(null, "Here are your Destination Cards", playerList[currPlayer].getName()+ " Destination Cards:", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, new ImageIcon("mog.gif"), members, members[4]);
    }

    /**
     * Shows the number of each type of cards the player has
     * @param g The graphics object for the applet
     */
    private void showCards(Graphics g) {
        int[] numCards = new int[9];
        try {
            Player curPlayer = playerList[currPlayer];
            String[] colors = new String[] {"black", "blue", "green", 
                    "orange", "rainbow", "red", "purple", "white", "yellow" };
            //Counts the cards for the current player
            for(int i = 0; i <  colors.length; i++) {
                for(int j = 0; j < curPlayer.trainCards.size(); j++) {
                    if(curPlayer.trainCards.get(j).getColor().equals(colors[i]))
                        numCards[i] = numCards[i] + 1;
                }
            }
        } catch (NullPointerException e) { showStatus(e.toString()); }
        g.setColor(new Color(102, 0, 0));
        g.fillRect(800, 475, 30, 30); g.fillRect(945, 475, 30, 30);
        g.fillRect(1090, 475, 30, 30); g.fillRect(800, 570, 30, 30);
        g.fillRect(945, 570, 30, 30); g.fillRect(1090, 570, 30, 30);
        g.fillRect(800, 665, 30, 30); g.fillRect(945, 665, 30, 30);
        g.fillRect(1090, 665, 30, 30);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(Integer.toString(numCards[0]), 807, 496);
        g.drawString(Integer.toString(numCards[1]), 952, 496);
        g.drawString(Integer.toString(numCards[2]), 1097, 496);
        g.drawString(Integer.toString(numCards[3]), 807, 591);
        g.drawString(Integer.toString(numCards[4]), 952, 591);
        g.drawString(Integer.toString(numCards[5]), 1097, 591);
        g.drawString(Integer.toString(numCards[6]), 807, 686);
        g.drawString(Integer.toString(numCards[7]), 952, 686);
        g.drawString(Integer.toString(numCards[8]), 1097, 686);
    }

    /**
     * Draws the players name, their dest cards and train cars on the board
     * @param g The graphics object for the applet
     */
    private void drawPlayerNameAndCars(Graphics g) {
        //showStatus(playerList[currPlayer].color);
        if((playerList[currPlayer].color).equals("GREEN")) 
            g.setColor(Color.GREEN);
        if((playerList[currPlayer].color).equals("YELLOW")) 
            g.setColor(Color.YELLOW);
        if((playerList[currPlayer].color).equals("RED")) 
            g.setColor(Color.RED);
        if((playerList[currPlayer].color).equals("BLUE")) 
            g.setColor(Color.BLUE);
        if((playerList[currPlayer].color).equals("BLACK")) 
            g.setColor(Color.BLACK);

        int lcX = 1030, lcY = 780;
        int lookAtTen = 0;
        for(int i = 0; i < playerList[currPlayer].cars; i++) {
            g.fillRect(lcX, lcY, 5, 10);
            lcX = lcX + 7;
            lookAtTen++;
            if(lookAtTen == 10){
                lcX = 1030;
                lcY = lcY + 13;
                lookAtTen = 0;
            }
        }
        //g.setColor(new Color(102, 0, 0));
        g.setColor(getCurPlayerColor());
        g.setFont(new Font("TimesRoman", Font.BOLD, 25));
        g.drawString("Player: " +playerList[currPlayer].name, 685, 240 );

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 12));
        g.drawString("Trains: " +playerList[currPlayer].cars, 1035, 775 );

        g.setFont(new Font("TimesRoman", Font.BOLD, 11));
        g.drawString("Your Dest Cards", 928, 775);
        g.drawImage(backDestCard, 930, 780, this);

        g.setFont(new Font("TimesRoman", Font.BOLD, 25));
        g.drawString("TRAIN CARDS", 809, 279 );

        g.setFont(new Font("TimesRoman", Font.BOLD, 25));
        g.drawString("YOUR HAND", 827, 465 );

        g.drawString("" + playerList[currPlayer].getTokens(), 858, 812);
        g.setFont(new Font("TimesRoman", Font.BOLD, 11));
        g.drawString("TOKENS", 850, 775 );

        g.setColor(new Color(102, 0,0));
        g.setFont(new Font("TimesRoman", Font.PLAIN, 9));
        g.drawString("Scoreboard: ", 735, 775 );
        for(int i = 0; i < playerList.length; i++) {
            g.drawString("" + playerList[i].name + ": " +playerList[i].getPoints(), 700, 770 + (i+1)*10);
        }
    }

    /**
     * Draws the trains on the board
     * @param g The graphics object for the applet
     */
    public void drawTrains(Graphics g) {
        //JOptionPane.showMessageDialog(this, "drawTrains()");
        for(int i = 0; i < boughtRoutesPoly.size(); i++) {
            g.setColor(boughtRoutesPolyColor.get(i));
            g.fillPolygon(boughtRoutesPoly.get(i));
        }
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
            playerList[i].setN(numPlayerName);
        }

        for(int i = 0; i < numPlayers; i++) { 
            String player1Color = (String) JOptionPane.showInputDialog(
                    null, "What color what you like to be",
                    "Message to " + name[i], JOptionPane.QUESTION_MESSAGE, null,
                    availableColors.toArray(), availableColors.get(0));
            playerList[i].setC(player1Color);
            availableColors.remove(player1Color);
        }

        for(int i = 0; i < numPlayers; i++) {
            playerList[i].addPoints(i);
        }
        return;
    }

    /**
     * Draws the 5 train cards visible to the players in beginning 
     * of the game
     * @param g The graphics object for the applet
     */
    private void drawRiver(Graphics g) {
        //HAVE TO DRAW THE 5 TRAIN CARDS FOR ALL PLAYERS
        //This is not the method called to see if the new train
        //card is added when selected from the river
        int rainbowCounter = 0;
        try {
            BufferedImage cardImage1 = ImageIO.read(gameBoard.river.get(0).getImagePath().toFile());
            if(gameBoard.river.get(0).getColor().equals("rainbow")){
                rainbowCounter ++;
            }
            BufferedImage cardImage2 = ImageIO.read(gameBoard.river.get(1).getImagePath().toFile());
            if(gameBoard.river.get(1).getColor().equals("rainbow")){
                rainbowCounter ++;
            }
            BufferedImage cardImage3 = ImageIO.read(gameBoard.river.get(2).getImagePath().toFile());
            if(gameBoard.river.get(2).getColor().equals("rainbow")){
                rainbowCounter ++;
            }
            BufferedImage cardImage4 = ImageIO.read(gameBoard.river.get(3).getImagePath().toFile());
            if(gameBoard.river.get(3).getColor().equals("rainbow")){
                rainbowCounter ++;
            }
            BufferedImage cardImage5 = ImageIO.read(gameBoard.river.get(4).getImagePath().toFile());
            if(gameBoard.river.get(4).getColor().equals("rainbow")){
                rainbowCounter ++;
            }
            //if the number of rainbow cards within the river equals or
            //exceeds 3, the river is placed back into the deck, populated with
            //new cards and the method is recurivly called to draw the new river
            if(rainbowCounter >= 3){
                for(int i = 0; i < gameBoard.river.size(); i ++){
                    Card c = gameBoard.river.remove(i);
                    trainDeck.addCard(c);
                }
                for(int i = 0; i <5; i ++){
                    TrainCarCard cardToAdd = (TrainCarCard) trainDeck.drawCard();
                    gameBoard.river.add(cardToAdd);
                }
                drawRiver(g); return;
            }        
            Image one = cardImage1;
            Image two = cardImage2;
            Image three = cardImage3;
            Image four = cardImage4;
            Image five = cardImage5;
            g.drawImage(one, 685, 295, this);
            g.drawImage(two, 770, 295, this);
            g.drawImage(three, 855, 295, this);
            g.drawImage(four, 940, 295, this);
            g.drawImage(five, 1025, 295, this);
        } catch (Exception e) { showStatus("EXCEPTION THROWN IN DRAWRIVER"); showStatus(e.toString()); }

    }

    /**
     * Gives players train cards, gives them destination cards to choose from
     * lets them choose
     * @param g The graphics object for the applet 
     */
    private void setUpGame(Graphics g) {
        createDestinationDeck(); createTrainDeck();
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

                JCheckBox   card1 = new JCheckBox(draw[0].getImagePath().toString().replace("images","").replace(".jpg","").replace("\\",""));
                JCheckBox   card2 = new JCheckBox(draw[1].getImagePath().toString().replace("images","").replace(".jpg","").replace("\\",""));
                JCheckBox   card3 = new JCheckBox(draw[2].getImagePath().toString().replace("images","").replace(".jpg","").replace("\\",""));
                JCheckBox   card4 = new JCheckBox(draw[3].getImagePath().toString().replace("images","").replace(".jpg","").replace("\\",""));
                JCheckBox   card5 = new JCheckBox(draw[4].getImagePath().toString().replace("images","").replace(".jpg","").replace("\\",""));
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

                // give player 4 random trainCarCards
                for (int tcc = 0; tcc<4; ++tcc) {
                    playerList[i].drawTrainCarCard(trainDeck);
                }
            }
            now = true;

            int rainbowCount = 3;
            while (rainbowCount > 2) {
                while (!gameBoard.river.isEmpty()) {
                    Card c = gameBoard.river.remove(0);
                    trainDeck.addCard(c);
                }

                rainbowCount = 0;
                for(int i = 0; i < 5; i++) {
                    TrainCarCard cardToAdd = (TrainCarCard) trainDeck.drawCard();
                    if (cardToAdd.getColor().equals("rainbow")) ++rainbowCount;
                    gameBoard.river.add(cardToAdd);    
                }

            }
            //JOptionPane.showConfirmDialog(this, name[i] + ", choose cards");
        }

        catch (Exception e) {JOptionPane.showConfirmDialog(this, e.toString()); }
    }

    /**
     * Used to test if there are any cards that will throw an error
     */
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
        // need to check somewhere if the decks are empty
        if (trainDeckDraw) {
            currentPlayer.drawTrainCarCard(trainDeck);
            trainDrawCount++;
            if(trainDrawCount%2 == 0) {
                currPlayer++;
                currPlayer = currPlayer % numPlayers;
            }
            trainDeckDraw = false;
            trainRiverDraw = false;
        }
        if (trainRiverDraw) { // maybe checkboxes instead?
            if (gameBoard.river.get(clickedCard).getColor().equals("rainbow")) {
                if(trainDrawCount%2 == 0) {
                    currentPlayer.addTrainCarCard(gameBoard.river.remove(clickedCard));
                    gameBoard.river.add(clickedCard, (TrainCarCard) trainDeck.drawCard());
                    trainDrawCount = trainDrawCount + 2;
                    if(trainDrawCount%2 == 0) {
                        currPlayer++;
                        currPlayer = currPlayer % numPlayers;
                    }
                    trainRiverDraw = false;
                    trainDeckDraw = false;
                }
            }
            else {
                currentPlayer.addTrainCarCard(gameBoard.river.remove(clickedCard));
                gameBoard.river.add(clickedCard, (TrainCarCard) trainDeck.drawCard());
                trainDrawCount++;
                if(trainDrawCount%2 == 0) {
                    currPlayer++;
                    currPlayer = currPlayer % numPlayers;
                }
                trainRiverDraw = false;
                trainDeckDraw = false;
            }
        }
        else if (destinationDeckDraw) {
            destinationDeckDraw = false;
            showStatus("im here");
            currPlayer++;
            currPlayer = currPlayer % numPlayers;
            //do the draw method from setupgame but 4 and 1
            drawDestinationCardsInGame();
        }

        else if (purchaseRoute) {
            purchaseRoute = false;
            // somehow the GUI will get two cities
            //start temp
            City city1, city2;
            city1 = CityList.getCity(cityNameRouteOne);
            city2 = CityList.getCity(cityNameRouteTwo);
            Route routeToBuy = new Route(cityNameRouteOne,cityNameRouteTwo);

            if (graph.hasEdge(city1.getName(),city2.getName()) && !currentPlayer.hasRoute(city1,city2) 
            && (currentPlayer.getTrainCarsCards(Route.routeColorToString(getColorRoute())) >= routeToBuy.getLength()
                || (Route.routeColorToString(getColorRoute()).equals("gray")))) { // gray color
                //&& currentPlayer.getMaxTrainCarCards() >= routeToBuy.getLength()))) { 
                boolean isDouble = graph.isDouble(city1, city2);
                int ownerCount = 0;
                Player otherOwner = null;
                String routeColor = Route.routeColorToString(getColorRoute());
                if (Route.routeColorToString(getColorRoute()).equals("gray")) {
                    // GUI set routeColor to whatever they want
                    ArrayList<String> cardColors = new ArrayList<String>(Arrays.asList(
                                "GREEN", "YELLOW", "RED", "BLUE", "BLACK", "ORANGE", "PURPLE", "WHITE"));
                    while (currentPlayer.getTrainCarsCards(routeColor) < routeToBuy.getLength()) {   
                        String cardColorUsed = (String) JOptionPane.showInputDialog(
                                null, "What color would you like to use?",
                                "Message to " + playerList[currPlayer].getName(), JOptionPane.QUESTION_MESSAGE, null,
                                cardColors.toArray(), cardColors.get(0));
                        routeColor = cardColorUsed.toLowerCase();
                        if (currentPlayer.getTrainCarsCards(routeColor) < routeToBuy.getLength())
                            JOptionPane.showMessageDialog(this, 
                                "You don't have enough of those Cards!\nPress cancel in the next window\nto do something else");
                    }

                }

                for (Player pr : playerList)
                    if (pr.hasRoute(city1, city2)) {
                        showStatus("playerHasRoute");
                        ++ownerCount;
                        otherOwner = pr;
                }
                if (!isDouble) {
                    if (ownerCount > 0) {
                        // don't let them buy the route
                        JOptionPane.showMessageDialog(this, "Somebody already owns that route!");
                    }
                    else {
                        // buy route from bank
                        currentPlayer.addRoute(city1,city2,routeColor, trainDeck);
                        boughtRoutesPoly.add(getRoutPoly());
                        boughtRoutesPolyColor.add(getCurPlayerColor());
                        currPlayer++;
                        currPlayer = currPlayer % numPlayers;
                    }
                }
                else {
                    if (ownerCount == 0) {
                        // buy route from bank
                        currentPlayer.addRoute(city1,city2,routeColor, trainDeck);
                        boughtRoutesPoly.add(getRoutPoly());
                        boughtRoutesPolyColor.add(getCurPlayerColor());
                        currPlayer++;
                        currPlayer = currPlayer % numPlayers;
                    }
                    else if (ownerCount == 1) {
                        // buy route from owner
                        otherOwner.addTokens(routeToBuy.getWeight());
                        currentPlayer.addRoute(city1,city2,routeColor, trainDeck);
                        boughtRoutesPoly.add(getRoutPoly());
                        boughtRoutesPolyColor.add(getCurPlayerColor());
                        currPlayer++;
                        currPlayer = currPlayer % numPlayers;
                    }
                    else {
                        // don't let them buy the route
                        JOptionPane.showMessageDialog(this, "Somebody already owns those routes!");
                    }
                }
            }
        }

    }

    /**
     * Drawing destination cards during the game, copied from setupgame
     */
    private void drawDestinationCardsInGame() {
        try {
            Graphics g = getGraphics();

            DestinationCard[] draw = new DestinationCard[4];
            for (int c=0; c<4; c++)
                draw[c] = (DestinationCard)destinationDeck.drawCard();
            // display the cards in draw
            for (int k = 0; k < draw.length; k++) {
                // display the card
                BufferedImage cardImage = ImageIO.read(draw[k].getImagePath().toFile());
                //Scales the destination cards
                Image cardImageScaled = cardImage.getScaledInstance(150, 240, Image.SCALE_SMOOTH);
                firstDest[k] = cardImageScaled;
            }
            g.drawImage(img, 0 ,0, this);
            g.drawImage(firstDest[0], 640, 40, this);
            g.drawImage(firstDest[1], 980, 40, this);
            g.drawImage(firstDest[2], 640, 470, this);
            g.drawImage(firstDest[3], 980, 470, this);

            JCheckBox   card1 = new JCheckBox(draw[0].getImagePath().toString().replace("images","").replace(".jpg","").replace("\\",""));
            JCheckBox   card2 = new JCheckBox(draw[1].getImagePath().toString().replace("images","").replace(".jpg","").replace("\\",""));
            JCheckBox   card3 = new JCheckBox(draw[2].getImagePath().toString().replace("images","").replace(".jpg","").replace("\\",""));
            JCheckBox   card4 = new JCheckBox(draw[3].getImagePath().toString().replace("images","").replace(".jpg","").replace("\\",""));
            String msg;
            if(currPlayer-1 == -1) {
                msg = "Choose your destination cards " + name[numPlayers-1];
            }
            else {
                msg = "Choose your destination cards " + name[currPlayer-1];
            }

            Object[] choices = {msg, card1, card2, card3, card4};
            int numSelectedCards = 0; boolean selected[] = new boolean[4];
            while (numSelectedCards < 1) {
                numSelectedCards = 0;
                int n;
                if(currPlayer-1 == -1) {
                    n = JOptionPane.showConfirmDialog ( this,  choices,  "Choose 1 or more Cards, " + name[numPlayers-1], JOptionPane.YES_NO_OPTION); 
                }
                else {
                    n = JOptionPane.showConfirmDialog ( this,  choices,  "Choose 1 or more Cards, " + name[currPlayer-1], JOptionPane.YES_NO_OPTION); 
                }
                selected = new boolean[] { card1.isSelected(), card2.isSelected(), card3.isSelected(), card4.isSelected() };
                for (boolean b : selected)
                    if (b)
                        ++numSelectedCards;
            }

            for (int bool=0; bool<4; bool++) {
                //If the card is selected, puts it in the players hand
                if (selected[bool]) {
                    if(currPlayer-1 == -1) {
                        playerList[numPlayers-1].addDestinationCard(draw[bool]);
                    }
                    else {
                        playerList[currPlayer-1].addDestinationCard(draw[bool]);
                    }
                }
                else {
                    destinationDeck.addCard(draw[bool]);    //Adds back the cards into the deck
                }
            }
            // loop none
            //}
            now = true;
            repaint();
        }
        catch (IOException e) {}
    }

    /**
     * Starts counting until end of round so that the game can end
     * if there is not enough cars to play
     */
    public void checkIfGameIsAlmostOver(){
        if(playerList[currPlayer].getCars() < 3) {
            lastPlayer = playerList[currPlayer];
            playerList[currPlayer].last = true;
        }
    }

    /**
     * Check if the last turn of the game is right now 
     * @param p Player that might be having the last turn
     * @param g The graphics object for the applet
     */
    public void checkIfLastPlayer(Player p) {
        if(p == lastPlayer){
            lastTurn = true;
        }
    }

    /**
     * Adds the bonus poinst to each player
     */
    public void addBonusPoints() {
        ArrayList<Player> extraPoints = new ArrayList<Player>();
        for(int i = 0; i < playerList.length; i++) {
            extraPoints.add(playerList[i]);
        }

        for(int i = 0; i < extraPoints.size(); i++) {
            for(int j = 0; j < extraPoints.size()-1; j++) {
                if(extraPoints.get(j).getTokens() < extraPoints.get(j+1).getTokens()) {
                    Player temp = extraPoints.get(j);
                    extraPoints.set(j, extraPoints.get(j+1));
                    extraPoints.set(j+1, temp);
                }
            }
        }

        int lastTokenCount = 1000;
        int[] possibleBonuses;
        if (numPlayers == 5) possibleBonuses = new int[] {55, 35, 20, 10, 0};
        else if (numPlayers == 4) possibleBonuses = new int[] {55, 35, 20, 0};
        else if (numPlayers == 3) possibleBonuses = new int[] {55, 35, 0};
        else if (numPlayers == 2) possibleBonuses = new int[] {35, 0};
        int currentPossibleBonus = 0; // index
        int nextBonus = 0;
        for (int i=0; i<extraPoints.size(); i++, nextBonus++) {
            Player cp = extraPoints.get(i);
            if (!cp.canGetBonus()) {
                --nextBonus;
                continue;
            }
            if (cp.getTokens() < lastTokenCount) {
                lastTokenCount = cp.getTokens();
                cp.addPoints(nextBonus);
                currentPossibleBonus = nextBonus;
            }
            else cp.addPoints(currentPossibleBonus);
        }
    }

    /**
     * ends the game and shows the scores
     */
    private void endGame() {
        try {
            gameOver = true;
            showStatus("GameOver");
            String scoreString = "";
            addBonusPoints();
            for (Player pr : playerList)
                pr.addPoints(pr.calculateDestinationPoints());

            for (Player pr : playerList)
                scoreString += pr.getName() + ": " + pr.getPoints() + "\n";
            JOptionPane.showMessageDialog(this, "GAME OVER\n" + scoreString);
        }
        catch (ArrayIndexOutOfBoundsException e) { showStatus("Array"); }
        catch (NullPointerException e) { showStatus("null"); }
        catch (Exception e) { showStatus(e.toString()); }
    }
}
