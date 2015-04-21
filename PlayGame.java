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
            //drawRiver(g); //Here will be the first five train cards drawn
            showCards(g);            
            drawPlayerNameAndCars(g);        //This to represent the players cars being drawn to board
            drawTrains(g); // This was used here to make sure the trains on the
            //actual board were being drawn correctly
            now = false;
            drawRiver(g);     //Draws the 5 train cards needed
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
            }

            //Check if the place clicked was on-top of a route
            if(routeClicked() != null) {
                String[] cityRouteClickedOn = routeClicked();
                cityNameRouteOne = cityRouteClickedOn[0];
                cityNameRouteTwo = cityRouteClickedOn[1];
                purchaseRoute = true;
                playerTurn(playerList[currPlayer]);
            }

            //Show the players current destination cards
            if(clickX >= 930 && clickY >= 780 && clickX <= 1009 && clickY <= 830) {
                //showDestinationCards();   HAVE TO IMPLEMENT
                g.setColor(Color.black);
                g.drawString("HERE", 950, 800);
                g.setFont(new Font("TimesRoman", Font.BOLD, 12));                
            }

            if(clickX >= 911 && clickY >=48 && clickX <= 1114 & clickY <= 173) {
                g.setColor(Color.red);
                g.drawRect(911, 48, 202, 125);                
                trainDeckDraw = true;
                playerTurn(playerList[currPlayer]);
                showCards(g);
                drawRiver(g);     //Draws the 5 train cards needed
                if(trainDrawCount%2 == 0) {
                    g.drawImage(img2, 0, 0, this); 
                    showCards(g);
                    drawPlayerNameAndCars(g); 
                    drawRiver(g);     //Draws the 5 train cards needed
                }
            }

            if(riverClicked()) {
                trainRiverDraw = true;
                playerTurn(playerList[currPlayer]);
                showCards(g);
                drawRiver(g);     //Draws the 5 train cards needed
                if(trainDrawCount%2 == 0) {
                    g.drawImage(img2, 0, 0, this); 
                    showCards(g);
                    drawPlayerNameAndCars(g); 
                    drawRiver(g);     //Draws the 5 train cards needed
                }
            }
            drawRiver(g);
            //whatCardsIHave(g);
        }
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
     * Checks if the routes on the map were clicked
     * @return the cities of the route clicked, otherwise returns null
     */
    public String[] routeClicked() {
        for(int i = 0; i < routeTrains.routeCars.size(); i++) {
            if(routeTrains.routeCars.get(i).contains(clickX, clickY)) {
                String[] rout = routeTrains.citiesLinked(i);
                JOptionPane.showMessageDialog(this, rout[0]+ " " +rout[1]);                
                return rout;
            }
        }
        return null;
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
     * Shows the destination cards the current player has
     */
    private void showDestinationCards() {
        //JOptionPane.showConfirmDialog(this, draw[k].getImagePath());
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
        g.setColor(new Color(102, 0, 0));
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
    }

    /**
     * Draws the trains on the board
     * @param g The graphics object for the applet
     */
    public void drawTrains(Graphics g) {
        g.setColor(new Color(255,0,0, 217));
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
        g.fillPolygon(new int[]{113,120,157,149}, new int[]{369,365,468,471}, 4);
        g.fillPolygon(new int[]{101,111,146,139}, new int[]{371,369,471,474}, 4);
        g.fillPolygon(new int[]{256,264,216,208}, new int[]{391,395,464,457}, 4);
        g.fillPolygon(new int[]{264,272,225,217}, new int[]{398,403,469,465}, 4);
        g.fillPolygon(new int[]{167,192,194,169}, new int[]{473,466,477,483}, 4);
        g.fillPolygon(new int[]{169,194,197,173}, new int[]{484,476,487,493}, 4);
        g.fillPolygon(new int[]{227,232,255,247}, new int[]{484,476,493,500}, 4);
        g.fillPolygon(new int[]{218,224,247,240}, new int[]{492,483,501,508}, 4);
        g.fillPolygon(new int[]{144,153,145,134}, new int[]{503,508,563,560}, 4);
        g.fillPolygon(new int[]{154,165,155,146}, new int[]{509,511,565,562}, 4);
        g.fillPolygon(new int[]{197, 206,195,185}, new int[]{497,497,603,602}, 4);
        g.fillPolygon(new int[]{206,215,205,196}, new int[]{494,497,604,603}, 4);
        g.fillPolygon(new int[]{247,257,249,236,220,211,226,239}, new int[]{528,532,558,583,608,602,580,554}, 8);
        g.fillPolygon(new int[]{273,379,382,275}, new int[]{498,476,486,509}, 4);
        g.fillPolygon(new int[]{274,383,384,278}, new int[]{508,486,496,518}, 4);
        g.fillPolygon(new int[]{354,362,386,376}, new int[]{357,356,461,465}, 4);
        g.fillPolygon(new int[]{364,374,399,388}, new int[]{357,355,460,463}, 4);
        g.fillPolygon(new int[]{491,498,410,403}, new int[]{356,362,470,462}, 4);
        g.fillPolygon(new int[]{499,507,419,413}, new int[]{364,370,477,470}, 4);
        g.fillPolygon(new int[]{510,518,535,550,561,565,565,565,552,555,550,549,540,526}, new int[]{366,361,384,410,436,464,493,521,520,494,440,439,412,390}, 14);
        g.fillPolygon(new int[]{521,531,547,561,571,577,576,576,566,566,565,561,551,538}, new int[]{364,359,382,406,432,463,488,518,516,490,463,435,409,386}, 14);
        g.fillPolygon(new int[]{393,403,414,404}, new int[]{493,490,511,517}, 4);
        g.fillPolygon(new int[]{404,414,424,415}, new int[]{491,486,509,513}, 4);
        g.fillPolygon(new int[]{278,283,339,333}, new int[]{532,524,582,589}, 4);
        g.fillPolygon(new int[]{267,279,332,324}, new int[]{537,531,590,596}, 4);
        g.fillPolygon(new int[]{152,157,176,168}, new int[]{598,592,612,617}, 4);
        g.fillPolygon(new int[]{159,165,184,177}, new int[]{592,586,604,611}, 4);
        g.fillPolygon(new int[]{413,420,409,399}, new int[]{538,539,620,618}, 4);
        g.fillPolygon(new int[]{420,432,420,410}, new int[]{539, 539,621,620}, 4);
        g.fillPolygon(new int[]{549,560,529,519}, new int[]{555,560,637,630}, 4);
        g.fillPolygon(new int[]{561,570,539,529}, new int[]{559,564,642,635}, 4);
        g.fillPolygon(new int[]{422,426,508,504}, new int[]{631,622,641,651}, 4);
        g.fillPolygon(new int[]{420,422,504,502}, new int[]{641,632,651,662}, 4);
        g.fillPolygon(new int[]{437,438,549,548}, new int[]{537,527,538,550}, 4);
        g.fillPolygon(new int[]{438,440,553,551}, new int[]{528,515,527,539}, 4);
        g.fillPolygon(new int[]{294,287,329,337}, new int[]{649,641,604,610}, 4);
        g.fillPolygon(new int[]{303,295,335,343}, new int[]{656,648,611,618}, 4);
        g.fillPolygon(new int[]{209,216,269,265}, new int[]{638,628,649,658}, 4);
        g.fillPolygon(new int[]{213,219,272,269}, new int[]{629,618,638,648}, 4);
        g.fillPolygon(new int[]{285,295,336,328}, new int[]{676,668,703,711}, 4);
        g.fillPolygon(new int[]{293,301,342,335}, new int[]{669,659,695,704}, 4);
        g.fillPolygon(new int[]{357,363,385,379}, new int[]{616,609,623,632}, 4);
        g.fillPolygon(new int[]{364,369,392,386}, new int[]{610,597,615,623}, 4);
        g.fillPolygon(new int[]{511,520,518,509}, new int[]{672,673,729,727}, 4);
        g.fillPolygon(new int[]{522,532,532,519}, new int[]{673,672,729,728}, 4);
        g.fillPolygon(new int[]{417, 427,439,457,477,500,495,472,448,428}, new int[]{654,648,674,695,712,725,735,720,702,678}, 10);
        g.fillPolygon(new int[]{408,417,430,447,468,492,486,462,438,420}, new int[]{662,658,682,704,720,736,744,730,710,687}, 10);
        g.fillPolygon(new int[]{128,136,113,103}, new int[]{593,596,758,755}, 4);
        g.fillPolygon(new int[]{138,148,125,114}, new int[]{596,597,761,759}, 4);
        g.fillPolygon(new int[]{190,200,266,256}, new int[]{648,644,765,768}, 4);
        g.fillPolygon(new int[]{201,210,275,265}, new int[]{645,640,760,763}, 4);
        g.fillPolygon(new int[]{523,532,536,527}, new int[]{761,761,815,815}, 4);
        g.fillPolygon(new int[]{511,521,525,515}, new int[]{761,761,815,815}, 4);
        g.fillPolygon(new int[]{127,130,156,184,211,239,265,270,242,211,183,154}, new int[]{781,772,782,790,790,788,779,788,796,800,799,792}, 12);
        g.fillPolygon(new int[]{128,130,157,184,211,241,266,268,240,210,182,153}, new int[]{792,785,795,800,802,798,790,799,807,810,809,803}, 12);
        g.fillPolygon(new int[]{293,294,345,343}, new int[]{797,789,804,812}, 4);
        g.fillPolygon(new int[]{294,297,349,345}, new int[]{786,779,793,802}, 4);
        g.fillPolygon(new int[]{296,289,325,332}, new int[]{766,760,721,727}, 4);
        g.fillPolygon(new int[]{304,297,332,340}, new int[]{773,768,729,735}, 4);
        g.fillPolygon(new int[]{351,356,427,421}, new int[]{727,718,759,767}, 4);
        g.fillPolygon(new int[]{356,362,432,426}, new int[]{718,709,749,758}, 4);
        g.fillPolygon(new int[]{376,373,424,428}, new int[]{807,798,781,789}, 4);
        g.fillPolygon(new int[]{374,369,421,424}, new int[]{797,789,771,781}, 4);
        g.fillPolygon(new int[]{456,452,504,508}, new int[]{776,768,749,758}, 4);
        g.fillPolygon(new int[]{451,450,500,503}, new int[]{766,755,739,748}, 4);
        g.fillPolygon(new int[]{453,460,480,504,501,475}, new int[]{789,782,798,811,820,805}, 6);
        g.fillPolygon(new int[]{373,376,428,456,457,511,513,455,428,373}, new int[]{820,809,825,828,830,829,837,837,834,820}, 10);
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
            //String inputValue = JOptionPane.showInputDialog("Please choose a color"); 
            String player1Color = (String) JOptionPane.showInputDialog(
                    null, "What color what you like to be",
                    "Message to " + name[i], JOptionPane.QUESTION_MESSAGE, null,
                    availableColors.toArray(), availableColors.get(0));
            playerList[i].setC(player1Color);
            availableColors.remove(player1Color);
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
                drawRiver(g);
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

    //Used to test if there are any cards that will throw an error
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
        showStatus(currPlayer + "");

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
                    gameBoard.river.add(clickedCard, (TrainCarCard) /*gameBoard.*/trainDeck.drawCard());
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
            //end temp
            Route routeToBuy = new Route(city1.toString(),city2.toString());
            if (graph.hasEdge(city1.getName(),city2.getName())) { // also make sure the edge isn't taken!
                boolean isDouble = graph.isDouble(city1, city2);
                int ownerCount = 0;
                Player otherOwner = null;
                for (Player pr : playerList)
                    if (pr.hasRoute(city1, city2)) {
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
                        currentPlayer.addRoute(city1,city2);
                    }
                }
                else {
                    if (ownerCount == 0) {
                        // buy route from bank
                        currentPlayer.addRoute(city1,city2);
                    }
                    if (ownerCount == 1) {
                        // buy route from owner
                        otherOwner.addTokens(routeToBuy.getWeight());
                        currentPlayer.addRoute(city1,city2);
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
}

