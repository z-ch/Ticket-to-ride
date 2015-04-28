import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.Collections;
/**
 * Graph class.
 * 
 * @author (Koushik P, Zach S, Ryan W, Theresa S, 
 * Andi E) 
 * @version 3.24.15
 */
public class Graph
{
    Hashtable<String, LinkedList<City>> adjMatrix 
            = new Hashtable<>();
    public final int numCities;

    /**
     * Constructor for objects of class Graph
     */
    public Graph()
    {
        numCities = 29+1;
        for (int i=0; i<numCities; i++) {
            adjMatrix.put(CityList.getCityFromArrayList(i).getName(), 
                new LinkedList<City>());
        }
        addEdge("Groningen", "Emden"); addEdge("Groningen", "Emden");
        addEdge("Groningen", "Emmen"); addEdge("Groningen", "Emmen");
        addEdge("Groningen", "Zwolle"); addEdge("Groningen", "Zwolle");
        addEdge("Groningen", "Leeuwarden"); addEdge("Groningen", "Leeuwarden");
        addEdge("Groningen","Waddensilanden");
        addEdge("Emden", "Emmen");
        addEdge("Emden", "Lingen"); addEdge("Emden", "Lingen");
        addEdge("Lingen", "Emmen"); addEdge("Lingen", "Emmen");
        addEdge("Lingen", "Enschede"); addEdge("Lingen", "Enschede");
        addEdge("Emmen", "Zwolle");
        addEdge("Leeuwarden", "Sneek"); addEdge("Leeuwarden", "Sneek");
        addEdge("Leeuwarden", "Waddensilanden");
        addEdge("Waddensilanden", "Sneek");
        addEdge("Waddensilanden", "DenHelder");
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
        addEdge("Utrecht", "'sHertogenbosch"); 
        addEdge("Utrecht", "'sHertogenbosch");
        addEdge("Nijmegen", "Duisburg"); addEdge("Nijmegen", "Duisburg");
        addEdge("Nijmegen","Eindhoven"); addEdge("Nijmegen","Eindhoven");
        addEdge("Duisburg", "Roermond"); addEdge("Duisburg", "Roermond"); 
        addEdge("Eindhoven", "Roermond"); addEdge("Eindhoven", "Roermond");
        addEdge("Eindhoven", "Maastricht"); addEdge("Eindhoven", "Maastricht");
        addEdge("Eindhoven", "'sHertogenbosch");
        addEdge("Eindhoven", "'sHertogenbosch");
        addEdge("'sHertogenbosch", "Breda"); 
        addEdge("'sHertogenbosch", "Breda");
        addEdge("Breda", "Rotterdam"); addEdge("Breda", "Rotterdam"); 
        addEdge("Breda", "Turnhout"); addEdge("Breda", "Turnhout");
        addEdge("'sGravenhage", "Rotterdam"); 
        addEdge("'sGravenhage", "Rotterdam");
        addEdge("'sGravenhage", "Middelburg");
        addEdge("'sGravenhage", "Middelburg");
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
        adjMatrix.get(cityOne).add(CityList.getCity(cityTwo));
        adjMatrix.get(cityTwo).add(CityList.getCity(cityOne));
    }

    /**
     * Checks if there is an edge from cityOne to cityTwo
     * @param cityOne first city
     * @param cityTwo second city
     * @return true if there is an edge, else false
     */
    public boolean hasEdge(String cityOne, String cityTwo) {
        return adjMatrix.get(cityOne).contains(new City(cityTwo));
    }

    /**
     * Checks if the route from city one to city two is double or not
     * @param cityOne first city in route (String)
     * @param cityTwo second city in route (String)
     * @return true if this route is double, else false
     */
    public boolean isDouble(String cityOne, String cityTwo) {
        int occurrences = Collections.frequency(adjMatrix.get(cityOne), 
                CityList.getCity(cityTwo));
        return occurrences == 2;
    }
    
    /**
     * Checks if the route from city one to city two is double or not
     * @param cityOne first city in route
     * @param cityTwo second city in route
     * @return true if this route is double, else false
     */
    public boolean isDouble(City cityOne, City cityTwo) {
        return isDouble(cityOne.getName(), cityTwo.getName());
    }


    /**
     * just a test method
     */
    public static void test() {
        Graph g = new Graph();
        System.out.println(g.hasEdge("Hasselt", "Liege") + "\n" +
                g.hasEdge("Hasselt","Amsterdam"));
        System.out.println(g.isDouble("Hasselt","Liege") + "\n" +
                g.isDouble("Hasselt", "Maastricht"));
    }
}
