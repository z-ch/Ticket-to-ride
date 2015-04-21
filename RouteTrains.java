import java.awt.Polygon;
import java.awt.Color;
import java.util.*;
/**
 * Write a description of class RouteTrains here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RouteTrains
{
    protected ArrayList<Polygon> routeCars = new ArrayList<Polygon>();
    protected ArrayList<String[]> citiesLinked = new ArrayList<String[]>();
    protected String[] trainCarRoutes = new String[2];
    protected ArrayList<Route.RouteColor> routeColors = new ArrayList<>();
    //routeColors.add(Route.RouteColor.YELLOW);
    /**
     * Constructor for objects of class RouteTrains
     */
    public RouteTrains() {        
        routeCars.add(new Polygon(new int[]{428, 439, 443, 433}, new int[]{101, 102, 211, 210}, 4));
        citiesLinked.add(new String[] { "Emden", "Emmen" });
        routeColors.add(Route.RouteColor.YELLOW);
        //trainCarRoutes[0] = "Emden"; trainCarRoutes[1] = "Emmen";
        //citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{453, 458,  484, 506, 525, 541, 553, 558, 548, 543, 531, 518, 499, 477}, new int[]{92, 83, 97, 115, 136, 161, 188, 216, 218, 191, 167, 143, 123, 105}, 14));
        trainCarRoutes[0] = "Emden"; trainCarRoutes[1] = "Lingen";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{444, 448, 475, 497, 517, 531, 543, 548, 539, 534, 523, 508, 491, 469}, new int[]{100, 90, 105, 123, 145, 169, 195, 223, 225, 200, 175, 152, 131, 113}, 14));
        trainCarRoutes[0] = "Emden"; trainCarRoutes[1] = "Lingen";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{423, 352, 347, 419}, new int[]{100, 141, 133, 91}, 4));
        trainCarRoutes[0] = "Emden"; trainCarRoutes[1] = "Groningen";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{413, 418, 346, 341}, new int[]{82, 90, 131, 124}, 4));
        trainCarRoutes[0] = "Emden"; trainCarRoutes[1] = "Groningen";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{364, 425, 418, 358}, new int[]{152, 206, 213, 159}, 4));
        trainCarRoutes[0] = "Groningen"; trainCarRoutes[1] = "Emmen";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{357, 417, 411, 350}, new int[]{160, 214, 222, 168}, 4));
        trainCarRoutes[0] = "Groningen"; trainCarRoutes[1] = "Emmen";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{315, 312, 286, 258, 230, 204, 179, 158, 152, 174, 200, 229, 258, 287}, new int[]{135, 144, 139, 138, 142, 150, 163, 179, 171, 155, 141, 132, 128, 129}, 14));
        trainCarRoutes[0] = "Groningen"; trainCarRoutes[1] = "Waddensilanden";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{306, 310, 239, 233}, new int[]{146, 154, 196, 189}, 4));
        trainCarRoutes[0] = "Groningen"; trainCarRoutes[1] = "Leeuwarden";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{311, 316, 244, 239}, new int[]{156, 164, 207, 198}, 4));
        trainCarRoutes[0] = "Groningen"; trainCarRoutes[1] = "Leeuwarden";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{453, 535, 533, 451}, new int[]{217, 228, 237, 226}, 4));
        trainCarRoutes[0] = "Emden"; trainCarRoutes[1] = "Lingen";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{451, 533, 532, 450}, new int[]{228, 239, 249, 236}, 4));
        trainCarRoutes[0] = "Emden"; trainCarRoutes[1] = "Lingen";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{343, 364, 355, 333}, new int[]{160, 321, 322, 161}, 4));
        trainCarRoutes[0] = "Groningen "; trainCarRoutes[1] = "Lwolle";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{332, 353, 343, 322}, new int[]{162, 323, 324, 163}, 4));
        trainCarRoutes[0] = "Groningen "; trainCarRoutes[1] = "Lwolle";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{426, 434, 373, 365}, new int[]{234, 239, 330, 325}, 4));
        trainCarRoutes[0] = "Emmen"; trainCarRoutes[1] = "Lwolle";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{156, 211, 208, 154}, new int[]{187, 196, 207, 197}, 4));
        trainCarRoutes[0] = "Leeuwarden"; trainCarRoutes[1] = "Waddensilanden";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{129, 137, 123, 113, 107, 105, 108, 97, 95, 96, 102, 114}, new int[]{198, 204, 226, 251, 278, 306, 330, 332, 306,277, 249, 222}, 12));
        trainCarRoutes[0] = "Waddensilanden"; trainCarRoutes[1] = "DenHelder";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{149, 161, 184, 209, 204, 179, 153, 140}, new int[]{198, 222, 238, 249, 257, 245, 228, 202}, 8));
        trainCarRoutes[0] = "Waddensilanden"; trainCarRoutes[1] = "Sneek";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{214, 224, 223, 214}, new int[]{218, 218, 244, 244}, 4));
        trainCarRoutes[0] = "Leeuwarden"; trainCarRoutes[1] = "Sneek";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{225, 235, 235, 226}, new int[]{219, 219, 244, 244}, 4));
        trainCarRoutes[0] = "Leeuwarden"; trainCarRoutes[1] = "Sneek";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{537, 545, 517, 507}, new int[]{254, 258, 332, 330}, 4));
        trainCarRoutes[0] = "Lingen"; trainCarRoutes[1] = "Enschede";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{548, 556, 527, 518}, new int[]{258, 262, 336, 332}, 4));
        trainCarRoutes[0] = "Lingen"; trainCarRoutes[1] = "Enschede";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{198, 205, 119, 113}, new int[]{263, 270, 340, 333}, 4));
        trainCarRoutes[0] = "Sneek"; trainCarRoutes[1] = "DanHelder";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{206, 212, 128, 122}, new int[]{272, 279, 348, 343}, 4));
        trainCarRoutes[0] = "Sneek"; trainCarRoutes[1] = "DanHelder";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{231, 239, 278, 269}, new int[]{270, 267, 366, 369}, 4));
        trainCarRoutes[0] = "Sneek"; trainCarRoutes[1] = "Lelystad";
        citiesLinked.add(trainCarRoutes);
        routeCars.add(new Polygon(new int[]{220, 229, 267, 258}, new int[]{274, 270, 370, 373}, 4));
        trainCarRoutes[0] = "Sneek"; trainCarRoutes[1] = "Lelystad";
        citiesLinked.add(trainCarRoutes);
    }
    
    
    /**
     * Gets the cities that were int the specific index
     * @return the cities that the clicked route links to
     */
    public String[] citiesLinked(int i) {
        return citiesLinked.get(i);
    }
    
    /**
     * Returns the routes polygon in the specific index
     * @return the polygon that represents the route at the
     *         specified index
     */
    public Polygon getRoutePolygon(int i) {
        return routeCars.get(i);
    }
}