import java.util.Hashtable;
import java.util.ArrayList;
/**
 * Write a description of class CityList here.
 * 
 * @author (your name) 
 * @version 3.24.15
 */
public class CityList
{
    private Hashtable<String, City> citylist;
    private static CityList cL = new CityList();
    private static ArrayList<City> cityArrayList = new ArrayList<City>();

    /**
     * Constructor for objects of class CityList
     */
    public CityList() {
        citylist = new Hashtable<String, City>();
        //citylist.put("name", new City("name"));
        citylist.put("Aarschot", new City("Aarschot"));
        citylist.put("Amsterdam", new City("Amsterdam"));
        citylist.put("Arnhem", new City("Arnhem"));
        citylist.put("Antwerpen", new City("Antwerpen"));
        citylist.put("Breda", new City("Breda"));
        citylist.put("DenHelder", new City("DenHelder"));
        citylist.put("Duisburg", new City("Duisburg"));
        citylist.put("Eindhoven", new City("Eindhoven"));
        citylist.put("Emmen", new City("Emmen"));
        citylist.put("Enschede", new City("Enschede"));
        citylist.put("Emden", new City("Emden"));
        citylist.put("Groningen", new City("Groningen"));
        citylist.put("Haarlem", new City("Haarlem"));
        citylist.put("Hasselt", new City("Hasselt"));        
        citylist.put("Lingen", new City("Lingen"));
        citylist.put("Liege", new City("Liege"));
        citylist.put("Lelystad", new City("Lelystad"));
        citylist.put("Leeuwarden", new City("Leeuwarden"));
        citylist.put("Maastricht", new City("Maastricht"));
        citylist.put("Middelburg", new City("Middelburg"));
        citylist.put("Nijmegen", new City("Nijmegen"));
        citylist.put("Rotterdam", new City("Rotterdam"));
        citylist.put("Roermond", new City("Roermond"));
        citylist.put("'s'Gravenhage", new City("'s'Gravenhage"));
        citylist.put("'s-Hertogenbosch", new City("'s-Hertogenbosch"));
        citylist.put("Sneek", new City("Sneek"));
        citylist.put("Turnhout", new City("Turnhout"));
        citylist.put("Utrecht", new City("Utrecht"));
        citylist.put("Waddeneilanden", new City("Waddeneilanden"));
        citylist.put("Zwolle", new City("Zwolle"));

        // construct city array list
        cityArrayList.add(citylist.get("Aarschot"));
        cityArrayList.add(citylist.get("Amsterdam"));
        cityArrayList.add(citylist.get("Arnhem"));
        cityArrayList.add(citylist.get("Antwerpen"));
        cityArrayList.add(citylist.get("Breda"));
        cityArrayList.add(citylist.get("DenHelder"));
        cityArrayList.add(citylist.get("Duisburg"));
        cityArrayList.add(citylist.get("Eindhoven"));
        cityArrayList.add(citylist.get("Emmen"));
        cityArrayList.add(citylist.get("Enschede"));
        cityArrayList.add(citylist.get("Emden"));
        cityArrayList.add(citylist.get("Groningen"));
        cityArrayList.add(citylist.get("Haarlem"));
        cityArrayList.add(citylist.get("Hasselt"));
        cityArrayList.add(citylist.get("Lingen"));
        cityArrayList.add(citylist.get("Liege"));
        cityArrayList.add(citylist.get("Lelystad"));
        cityArrayList.add(citylist.get("Leeuwarden"));
        cityArrayList.add(citylist.get("Maastricht"));
        cityArrayList.add(citylist.get("Middelburg"));
        cityArrayList.add(citylist.get("Nijmegen"));
        cityArrayList.add(citylist.get("Rotterdam"));
        cityArrayList.add(citylist.get("Roermond"));
        cityArrayList.add(citylist.get("'s'Gravenhage"));
        cityArrayList.add(citylist.get("'s-Hertogenbosch"));
        cityArrayList.add(citylist.get("Sneek"));
        cityArrayList.add(citylist.get("Turnhout"));
        cityArrayList.add(citylist.get("Utrecht"));
        cityArrayList.add(citylist.get("Waddeneilanden"));
        cityArrayList.add(citylist.get("Zwolle"));
    }
    
    /**
     * Returns the city with the specified name
     * @param name The city name
     */
    public static City getCity(String name) {
        return cL.citylist.get(name);        
    }
    
    /**
     * Returns city in cityArrayList at index i
     * @param i index to get city from
     */
    public static City getCityFromArrayList(int i) {
        if (i > 1 && i < cL.cityArrayList.size())
            return cL.cityArrayList.get(i);
        else return null;
    }
}
