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
        citylist.put("name", new City("name"));
        /*
        citylist.add(new City("Aarschot"));
        citylist.add(new City("Amsterdam"));
        citylist.add(new City("Arnhem"));
        citylist.add(new City("Antwerpen"));
        citylist.add(new City("Breda"));
        citylist.add(new City("DenHelder"));
        citylist.add(new City("Duisburg"));
        citylist.add(new City("Eindhoven"));
        citylist.add(new City("Emmen"));
        citylist.add(new City("Enschede"));
        citylist.add(new City("Emden"));
        citylist.add(new City("Groningen"));
        citylist.add(new City("Haarlem"));
        citylist.add(new City("Hasselt"));        
        citylist.add(new City("Lingen"));
        citylist.add(new City("Liege"));
        citylist.add(new City("Lelystad"));
        citylist.add(new City("Leeuwarden"));
        citylist.add(new City("Maastricht"));
        citylist.add(new City("Middelburg"));
        citylist.add(new City("Nijmegen"));
        citylist.add(new City("Rotterdam"));
        citylist.add(new City("Roermond"));
        citylist.add(new City("'s'Gravenhage"));
        citylist.add(new City("'s-Hertogenbosch"));
        citylist.add(new City("Sneek"));
        citylist.add(new City("Turnhout"));
        citylist.add(new City("Utrecht"));
        citylist.add(new City("Waddeneilanden"));
        citylist.add(new City("Zwolle"));
        */
    }
    
    /**
     * Returns the city with the specified name
     * @param name The city name
     */
    public static City getCity(String name) {
        return cL.citylist.get(name);        
    }

}
