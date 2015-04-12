import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.Collections;
/**
 * Graph class.
 * 
 * @author (your name) 
 * @version 3.24.15
 */
public class Graph
{
    protected Hashtable<String, LinkedList<City>> adjMatrix = new Hashtable<>();
    public final int numCities;

    /**
     * Constructor for objects of class Graph
     */
    public Graph()
    {
        numCities = 29+1;
        // fill hashtable with empty LinkedLists
        for (int i=0; i<numCities; i++) {
            adjMatrix.put(CityList.getCityFromArrayList(i).getName(), 
                new LinkedList<City>());
        }
        adjMatrix.put("CityName", new LinkedList<City>());
        addEdge("Groningen", "Emden"); addEdge("Groningen", "Emden");
        addEdge("Groningen", "Emmen"); addEdge("Groningen", "Emmen");
        addEdge("Groningen", "Zwolle"); addEdge("Groningen", "Zwolle");
        addEdge("Groningen", "Leeuwarden"); addEdge("Groningen", "Leeuwarden");
        addEdge("Groningen","Waddeneilanden");
        addEdge("Emden", "Emmen");
        addEdge("Emden", "Lingen"); addEdge("Emden", "Lingen");
        addEdge("Lingen", "Emmen"); addEdge("Lingen", "Emmen");
        addEdge("Lingen", "Enschede"); addEdge("Lingen", "Enschede");
        addEdge("Emmen", "Zwolle");
        addEdge("Leeuwarden", "Sneek"); addEdge("Leeuwarden", "Sneek");
        addEdge("Leeuwarden", "Waddeneilanden");
        addEdge("Waddeneilanden", "Sneek");
        addEdge("Waddeneilanden", "DenHelder");
        addEdge("Sneek", "DenHelder"); addEdge("Sneek", "DenHelder"); 
        addEdge("Sneek", "Lelystad"); addEdge("Sneek", "Lelystad");
        addEdge("Enschede", "Zwolle"); addEdge("Enschede", "Zwolle");
        addEdge("Zwolle", "Lelystad"); addEdge("Zwolle", "Lelystad");
        addEdge("DenHelder", "Haarlem"); addEdge("DenHelder", "Haarlem");
        addEdge("Lelystad", "Amsterdam"); addEdge("Lelystad", "Amsterdam");
        addEdge("Zwolle", "Arnhem"); addEdge("Zwolle", "Arnhem");
        addEdge("Enschede", "Arnhem"); addEdge("Enschede", "Arnhem");
        addEdge("Enschede", "Duisburg"); addEdge("Enschede", "Duisburg");
        addEdge("Haarlem","Amsterdam"); addEdge("Haarlem","Amsterdam");
        addEdge("Haarlem", "'sGravenhage"); addEdge("Haarlem", "'sGravenhage");
        addEdge("Amsterdam", "Utrecht"); addEdge("Amsterdam", "Utrecht"); 
        addEdge("Utrecht", "Arnhem"); addEdge("Utrecht", "Arnhem");
        addEdge("Arnhem", "Nijmegen"); addEdge("Arnhem", "Nijmegen");
        addEdge("Amsterdam", "Rotterdam"); addEdge("Amsterdam", "Rotterdam");
        addEdge("Rotterdam", "Utrecht");
        addEdge("Utrecht", "'sHertogenbosch"); addEdge("Utrecht", "'sHertogenbosch");
        addEdge("Nijmegen", "Duisburg"); addEdge("Nijmegen", "Duisburg");
        addEdge("Nijmegen","Eindhoven"); addEdge("Nijmegen","Eindhoven");
        addEdge("Duisburg", "Roermond"); addEdge("Duisburg", "Roermond"); 
        addEdge("Eindhoven", "Roermond"); addEdge("Eindhoven", "Roermond");
        addEdge("Eindhoven", "Maastricht"); addEdge("Eindhoven", "Maastricht");
        addEdge("Eindhoven", "'sHertogenbosch"); addEdge("Eindhoven", "'sHertogenbosch");
        addEdge("'sHertogenbosch", "Breda");  addEdge("'sHertogenbosch", "Breda");
        addEdge("Breda", "Rotterdam"); addEdge("Breda", "Rotterdam"); 
        addEdge("Breda", "Turnhout"); addEdge("Breda", "Turnhout");
        addEdge("'sGravenhage", "Rotterdam"); addEdge("'sGravenhage", "Rotterdam");
        addEdge("'sGravenhage", "Middelburg"); addEdge("'sGravenhage", "Middelburg");
        addEdge("Middelburg", "Antwerpen"); addEdge("Middelburg", "Antwerpen");
        addEdge("Antwerpen", "Rotterdam"); addEdge("Antwerpen", "Rotterdam");
        addEdge("Roermond", "Maastricht"); addEdge("Roermond", "Maastricht"); 
        addEdge("Antwerpen", "Turnhout"); addEdge("Antwerpen", "Turnhout"); 
        addEdge("Antwerpen", "Aarschot"); addEdge("Antwerpen", "Aarschot");
        addEdge("Turnhout", "Hasselt"); addEdge("Turnhout", "Hasselt"); 
        addEdge("Aarschot", "Hasselt"); addEdge("Aarschot", "Hasselt");
        addEdge("Hasselt", "Maastricht"); addEdge("Hasselt", "Maastricht");
        addEdge("Maastricht", "Liege"); addEdge("Maastricht", "Liege");
        addEdge("Hasselt", "Liege");
        addEdge("Aarschot","Liege");
    }

    /**
     * adds an edge from cityOne to cityTwo AND from cityTwo to cityOne
     * @param cityOne first city
     * @param cityTwo second city
     */
    private void addEdge(String cityOne, String cityTwo) {
        //System.out.println(cityOne + " " + cityTwo);
        adjMatrix.get(cityOne).add(CityList.getCity(cityTwo));
        adjMatrix.get(cityTwo).add(CityList.getCity(cityOne));
        //         try {
        //             System.out.print(cityOne + " " + cityTwo + " ");
        //             adjMatrix.get(cityOne).add(CityList.getCity(cityTwo));
        //             System.out.print("Got cityTwo from CityList, ");
        //             adjMatrix.get(cityTwo).add(CityList.getCity(cityOne));
        //             System.out.print("Got cityOne from CityList, ");
        //             System.out.println("OK");
        //         } catch (NullPointerException e) { System.out.println("AAAHHHH"); }
    }

    /**
     * Checks if there is an edge from cityOne to cityTwo
     * @param cityOne first city
     * @param cityTwo second city
     * @return true if there is an edge, else false
     */
    public boolean hasEdge(String cityOne, String cityTwo) {
        return adjMatrix.get(cityOne).contains(CityList.getCity(cityTwo));
    }

    public boolean isDouble(String cityOne, String cityTwo) {
        int occurrences = Collections.frequency(adjMatrix.get(cityOne), CityList.getCity(cityTwo));
        return occurrences == 2;
    }

    public static void test() {
        Graph g = new Graph();
        System.out.println(g.hasEdge("Hasselt", "Liege") + "\n" + g.hasEdge("Hasselt","Amsterdam"));
        System.out.println(g.isDouble("Hasselt","Liege") + "\n" + g.isDouble("Hasselt", "Maastricht"));
    }
}
