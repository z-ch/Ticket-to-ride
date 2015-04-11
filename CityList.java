import java.util.Hashtable;
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
    }
    
    /**
     * Returns the city with the specified name
     * @param name The city name
     */
    public static City getCity(String name) {
        return cL.citylist.get(name);        
    }

}
