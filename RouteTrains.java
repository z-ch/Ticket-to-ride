import java.awt.Polygon;
import java.awt.Color;
import java.util.*;
/**
 * Class RouteTrains creates polygons required for route highlighting. 
 * Route also links cities for route 
 * highlighting together
 * 
 * @author (Koushik P, Zach S, Ryan W, Theresa S,
 * Andi E) 
 * @version (3.24.15)
 */
public class RouteTrains
{
    protected ArrayList<Polygon> routeCars = new ArrayList<Polygon>();
    protected ArrayList<String[]> citiesLinked = new ArrayList<String[]>();
    protected String[] trainCarRoutes = new String[2];
    protected ArrayList<Route.RouteColor> routeColors = new ArrayList<>();
    /**
     * Constructor for objects of class RouteTrains
     */
    public RouteTrains() {        
        routeCars.add(new Polygon(new int[]{428, 439, 443, 433}, new int[]{101,
            102, 211, 210}, 4));
        citiesLinked.add(new String[] { "Emden", "Emmen" });
        routeColors.add(Route.RouteColor.PURPLE);
        routeCars.add(new Polygon(new int[]{453, 458,  484, 506, 525, 541, 553,
            558, 548, 543, 531, 518, 499, 477}, new int[]{92, 83, 97, 115, 136,
                161, 188, 216, 218, 191, 167, 143, 123, 105}, 14));
        citiesLinked.add(new String[] { "Emden", "Lingen" });
        routeColors.add(Route.RouteColor.GRAY);
        routeCars.add(new Polygon(new int[]{444, 448, 475, 497, 517, 531, 543,
            548, 539, 534, 523, 508, 491, 469}, new int[]{100, 90, 105, 123, 
                145, 169, 195, 223, 225, 200, 175, 152, 131, 113}, 14));
        citiesLinked.add(new String[] { "Emden", "Lingen" });
        routeColors.add(Route.RouteColor.BLACK);
        routeCars.add(new Polygon(new int[]{423, 352, 347, 419}, new int[]{100,
            141, 133, 91}, 4));
        citiesLinked.add(new String[] { "Emden", "Groningen" });
        routeColors.add(Route.RouteColor.GRAY);
        routeCars.add(new Polygon(new int[]{413, 418, 346, 341}, new int[]{82,
            90, 131, 124}, 4));
        citiesLinked.add(new String[] { "Emden", "Groningen" });
        routeColors.add(Route.RouteColor.GRAY);
        routeCars.add(new Polygon(new int[]{364, 425, 418, 358}, new int[]{152,
            206, 213, 159}, 4));
        citiesLinked.add(new String[] { "Groningen", "Emmen" });
        routeColors.add(Route.RouteColor.RED);
        routeCars.add(new Polygon(new int[]{357, 417, 411, 350}, new int[]{160,
            214, 222, 168}, 4));
        citiesLinked.add(new String[] { "Groningen", "Emmen" });
        routeColors.add(Route.RouteColor.BLACK);
        routeCars.add(new Polygon(new int[]{315, 312, 286, 258, 230, 204, 179,
            158, 152, 174, 200, 229, 258, 287}, new int[]{135, 144, 139, 138,
                142, 150, 163, 179, 171, 155, 141, 132, 128, 129}, 14));
        citiesLinked.add(new String[] { "Groningen", "Waddensilanden" });
        routeColors.add(Route.RouteColor.YELLOW);
        routeCars.add(new Polygon(new int[]{306, 310, 239, 233}, new int[]{146,
            154, 196, 189}, 4));
        citiesLinked.add(new String[] { "Groningen", "Leeuwarden" });
        routeColors.add(Route.RouteColor.BLUE);
        routeCars.add(new Polygon(new int[]{311, 316, 244, 239}, new int[]{156,
            164, 207, 198}, 4));
        citiesLinked.add(new String[] { "Groningen", "Leeuwarden" });
        routeColors.add(Route.RouteColor.ORANGE);
        routeCars.add(new Polygon(new int[]{453, 535, 533, 451}, new int[]{217,
            228, 237, 226}, 4));
        citiesLinked.add(new String[] { "Emmen", "Lingen" });
        routeColors.add(Route.RouteColor.YELLOW);
        routeCars.add(new Polygon(new int[]{451, 533, 532, 450}, new int[]{228,
            239, 249, 236}, 4));
        citiesLinked.add(new String[] { "Emmen", "Lingen" });
        routeColors.add(Route.RouteColor.GREEN);
        routeCars.add(new Polygon(new int[]{343, 364, 355, 333}, new int[]{160,
            321, 322, 161}, 4));
        citiesLinked.add(new String[] { "Groningen", "Zwolle" });
        routeColors.add(Route.RouteColor.GREEN);
        routeCars.add(new Polygon(new int[]{332, 353, 343, 322}, new int[]{162,
            323, 324, 163}, 4));
        citiesLinked.add(new String[] { "Groningen", "Zwolle" });
        routeColors.add(Route.RouteColor.WHITE);
        routeCars.add(new Polygon(new int[]{426, 434, 373, 365}, new int[]{234,
            239, 330, 325}, 4));
        citiesLinked.add(new String[] { "Emmen", "Zwolle" });
        routeColors.add(Route.RouteColor.GRAY);
        routeCars.add(new Polygon(new int[]{156, 211, 208, 154}, new int[]{187,
            196, 207, 197}, 4));
        citiesLinked.add(new String[] { "Leeuwarden", "Waddensilanden" });
        routeColors.add(Route.RouteColor.GREEN);
        routeCars.add(new Polygon(new int[]{129, 137, 123, 113, 107, 105, 108,
            97, 95, 96, 102, 114}, new int[]{198, 204, 226, 251, 278, 306, 330,
                332, 306,277, 249, 222}, 12));
        citiesLinked.add(new String[] { "Waddensilanden", "DenHelder" });
        routeColors.add(Route.RouteColor.PURPLE);
        routeCars.add(new Polygon(new int[]{149, 161, 184, 209, 204, 179, 153, 
            140}, new int[]{198, 222, 238, 249, 257, 245, 228, 202}, 8));
        citiesLinked.add(new String[] { "Waddensilanden", "Sneek" });
        routeColors.add(Route.RouteColor.GRAY);
        routeCars.add(new Polygon(new int[]{214, 224, 223, 214}, new int[]{218,
            218, 244, 244}, 4));
        citiesLinked.add(new String[] { "Leeuwarden", "Sneek" });
        routeColors.add(Route.RouteColor.YELLOW);
        routeCars.add(new Polygon(new int[]{225, 235, 235, 226}, new int[]{219,
            219, 244, 244}, 4));
        citiesLinked.add(new String[] { "Leeuwarden", "Sneek" });
        routeColors.add(Route.RouteColor.BLACK);
        routeCars.add(new Polygon(new int[]{537, 545, 517, 507}, new int[]{254,
            258, 332, 330}, 4));
        citiesLinked.add(new String[] { "Lingen", "Enschede" });
        routeColors.add(Route.RouteColor.PURPLE);
        routeCars.add(new Polygon(new int[]{548, 556, 527, 518}, new int[]{258,
            262, 336, 332}, 4));
        citiesLinked.add(new String[] { "Lingen", "Enschede" });
        routeColors.add(Route.RouteColor.RED);
        routeCars.add(new Polygon(new int[]{198, 205, 119, 113}, new int[]{263,
            270, 340, 333}, 4));
        citiesLinked.add(new String[] { "Sneek", "DenHelder" });
        routeColors.add(Route.RouteColor.WHITE);
        routeCars.add(new Polygon(new int[]{206, 212, 128, 122}, new int[]{272,
            279, 348, 343}, 4));
        citiesLinked.add(new String[] { "Sneek", "DenHelder" });
        routeColors.add(Route.RouteColor.RED);
        routeCars.add(new Polygon(new int[]{231, 239, 278, 269}, new int[]{270,
            267, 366, 369}, 4));
        citiesLinked.add(new String[] { "Sneek", "Lelystad" });
        routeColors.add(Route.RouteColor.BLUE);
        routeCars.add(new Polygon(new int[]{220, 229, 267, 258}, new int[]{274,
            270, 370, 373}, 4));
        citiesLinked.add(new String[] { "Sneek", "Lelystad" });
        routeColors.add(Route.RouteColor.GREEN);
        routeCars.add(new Polygon(new int[]{373,376,428,456,457,511,513,455,428,
            373}, new int[]{820,809,825,828,830,829,837,837,834,820}, 10));
        citiesLinked.add(new String[] { "Liege", "Aarschot" });
        routeColors.add(Route.RouteColor.RED);
        routeCars.add(new Polygon(new int[]{453,460,480,504,501,475},
                new int[]{789,782,798,811,820,805}, 6));
        citiesLinked.add(new String[] { "Liege", "Hasselt" });
        routeColors.add(Route.RouteColor.GRAY);
        routeCars.add(new Polygon(new int[]{451,450,500,503}, 
                new int[]{766,755,739,748}, 4));
        citiesLinked.add(new String[] { "Maastricht", "Hasselt" });
        routeColors.add(Route.RouteColor.RED);
        routeCars.add(new Polygon(new int[]{456,452,504,508},
                new int[]{776,768,749,758}, 4));
        citiesLinked.add(new String[] { "Maastricht", "Hasselt" });
        routeColors.add(Route.RouteColor.GREEN);
        routeCars.add(new Polygon(new int[]{374,369,421,424}, new int[]{797,789,
            771,781}, 4));
        citiesLinked.add(new String[] { "Aarschot", "Hasselt" });        
        routeColors.add(Route.RouteColor.BLACK);
        routeCars.add(new Polygon(new int[]{376,373,424,428}, new int[]{807,798,
            781,789}, 4));
        citiesLinked.add(new String[] { "Aarschot", "Hasselt" });
        routeColors.add(Route.RouteColor.PURPLE);
        routeCars.add(new Polygon(new int[]{356,362,432,426}, new int[]{718,709,
            749,758}, 4));
        citiesLinked.add(new String[] { "Turnhout", "Hasselt" });        
        routeColors.add(Route.RouteColor.YELLOW );
        routeCars.add(new Polygon(new int[]{351,356,427,421}, new int[]{727,718,
            759,767}, 4));
        citiesLinked.add(new String[] { "Turnhout", "Hasselt" });
        routeColors.add(Route.RouteColor.ORANGE);
        routeCars.add(new Polygon(new int[]{304,297,332,340}, new int[]{773,768,
            729,735}, 4));
        citiesLinked.add(new String[] { "Turnhout", "Antwerpen" });
        routeColors.add(Route.RouteColor.PURPLE);
        routeCars.add(new Polygon(new int[]{296,289,325,332}, new int[]{766,760,
            721,727}, 4));
        citiesLinked.add(new String[] { "Turnhout", "Antwerpen" });        
        routeColors.add(Route.RouteColor.RED);
        routeCars.add(new Polygon(new int[]{294,297,349,345}, new int[]{786,779,
            793,802}, 4));
        citiesLinked.add(new String[] { "Aarschot", "Antwerpen" });        
        routeColors.add(Route.RouteColor.YELLOW);
        routeCars.add(new Polygon(new int[]{293,294,345,343}, new int[]{797,789,
            804,812}, 4));
        citiesLinked.add(new String[] { "Aarschot", "Antwerpen" });
        routeColors.add(Route.RouteColor.BLUE);
        routeCars.add(new Polygon(new int[]{128,130,157,184,211,241,266,268,240,
            210,182,153}, new int[]{792,785,795,800,802,798,790,799,807,810,809,
                803}, 12));
        citiesLinked.add(new String[] { "Middelburg", "Antwerpen" });        
        routeColors.add(Route.RouteColor.GREEN);
        routeCars.add(new Polygon(new int[]{127,130,156,184,211,239,265,270,242,
            211,183,154}, new int[]{781,772,782,790,790,788,779,788,796,800,799,
                792}, 12));
        citiesLinked.add(new String[] { "Middelburg", "Antwerpen" });
        routeColors.add(Route.RouteColor.ORANGE);
        routeCars.add(new Polygon(new int[]{511,521,525,515}, new int[]{761,761,
            815,815}, 4));
        citiesLinked.add(new String[] { "Maastricht", "Liege" });
        routeColors.add(Route.RouteColor.WHITE); 
        routeCars.add(new Polygon(new int[]{523,532,536,527}, new int[]{761,761,
            815,815}, 4));
        citiesLinked.add(new String[] { "Maastricht", "Liege" });
        routeColors.add(Route.RouteColor.BLUE); 
        routeCars.add(new Polygon(new int[]{201,210,275,265}, new int[]{645,640,
            760,763}, 4));
        citiesLinked.add(new String[] { "Rotterdam", "Antwerpen" });        
        routeColors.add(Route.RouteColor.BLACK); 
        routeCars.add(new Polygon(new int[]{190,200,266,256}, new int[]{648,644,
            765,768}, 4));
        citiesLinked.add(new String[] { "Rotterdam", "Antwerpen" });
        routeColors.add(Route.RouteColor.WHITE);
        routeCars.add(new Polygon(new int[]{138,148,125,114}, new int[]{596,597,
            761,759}, 4));
        citiesLinked.add(new String[] { "'sGravenhage", "Middelburg" });
        routeColors.add(Route.RouteColor.YELLOW); 
        routeCars.add(new Polygon(new int[]{128,136,113,103}, new int[]{593,596,
            758,755}, 4));
        citiesLinked.add(new String[] { "'sGravenhage", "Middelburg" });
        routeColors.add(Route.RouteColor.RED);
        routeCars.add(new Polygon(new int[]{408,417,430,447,468,492,486,462,438,
            420}, new int[]{662,658,682,704,720,736,744,730,710,687}, 10));
        citiesLinked.add(new String[] { "Eindhoven", "Maastricht" });
        routeColors.add(Route.RouteColor.PURPLE); 
        routeCars.add(new Polygon(new int[]{417, 427,439,457,477,500,495,472,448
                ,428}, new int[]{654,648,674,695,712,725,735,720,702,678}, 10));
        citiesLinked.add(new String[] { "Eindhoven", "Maastricht" });
        routeColors.add(Route.RouteColor.YELLOW);
        routeCars.add(new Polygon(new int[]{522,532,532,519}, new int[]{673,672,
            729,728}, 4));
        citiesLinked.add(new String[] { "Roermond", "Maastricht" });        
        routeColors.add(Route.RouteColor.BLACK);
        routeCars.add(new Polygon(new int[]{511,520,518,509}, new int[]{672,673,
            729,727}, 4));
        citiesLinked.add(new String[] { "Roermond", "Maastricht" });
        routeColors.add(Route.RouteColor.ORANGE);
        routeCars.add(new Polygon(new int[]{364,369,392,386}, new int[]{610,597,
            615,623}, 4));
        citiesLinked.add(new String[] { "Eindhoven", "'sHertogenbosch" });
        routeColors.add(Route.RouteColor.BLUE);        
        routeCars.add(new Polygon(new int[]{357,363,385,379}, new int[]{616,609,
            623,632}, 4));
        citiesLinked.add(new String[] { "Eindhoven", "'sHertogenbosch" });
        routeColors.add(Route.RouteColor.GREEN);
        routeCars.add(new Polygon(new int[]{293,301,342,335}, new int[]{669,659,
            695,704}, 4));
        citiesLinked.add(new String[] { "Breda", "Turnhout" });
        routeColors.add(Route.RouteColor.BLACK);
        routeCars.add(new Polygon(new int[]{285,295,336,328}, new int[]{676,668,
            703,711}, 4));
        citiesLinked.add(new String[] { "Breda", "Turnhout" });
        routeColors.add(Route.RouteColor.BLUE);
        routeCars.add(new Polygon(new int[]{213,219,272,269}, new int[]{629,618,
            638,648}, 4));
        citiesLinked.add(new String[] { "Breda", "Rotterdam" });        
        routeColors.add(Route.RouteColor.YELLOW);
        routeCars.add(new Polygon(new int[]{209,216,269,265}, new int[]{638,628,
            649,658}, 4));
        citiesLinked.add(new String[] { "Breda", "Rotterdam" });
        routeColors.add(Route.RouteColor.PURPLE);
        routeCars.add(new Polygon(new int[]{303,295,335,343}, new int[]{656,648,
            611,618}, 4));
        citiesLinked.add(new String[] { "Breda", "'sHertogenbosch" });        
        routeColors.add(Route.RouteColor.WHITE);
        routeCars.add(new Polygon(new int[]{294,287,329,337}, new int[]{649,641,
            604,610}, 4));
        citiesLinked.add(new String[] { "Breda", "'sHertogenbosch" });
        routeColors.add(Route.RouteColor.ORANGE);
        routeCars.add(new Polygon(new int[]{438,440,553,551}, new int[]{528,515,
            527,539}, 4));
        citiesLinked.add(new String[] { "Nijmegen", "Duisburg" });
        routeColors.add(Route.RouteColor.PURPLE);
        routeCars.add(new Polygon(new int[]{437,438,549,548}, new int[]{537,527,
            538,550}, 4));
        citiesLinked.add(new String[] { "Nijmegen", "Duisburg" });
        routeColors.add(Route.RouteColor.BLUE);
        routeCars.add(new Polygon(new int[]{420,422,504,502}, new int[]{641,632,
            651,662}, 4));
        citiesLinked.add(new String[] { "Eindhoven", "Roermond" });        
        routeColors.add(Route.RouteColor.RED);
        routeCars.add(new Polygon(new int[]{422,426,508,504}, new int[]{631,622,
            641,651}, 4));
        citiesLinked.add(new String[] { "Eindhoven", "Roermond" });
        routeColors.add(Route.RouteColor.WHITE);
        routeCars.add(new Polygon(new int[]{561,570,539,529}, new int[]{559,564,
            642,635}, 4));
        citiesLinked.add(new String[] { "Duisburg", "Roermond" }); 
        routeColors.add(Route.RouteColor.GREEN);            
        routeCars.add(new Polygon(new int[]{549,560,529,519}, new int[]{555,560,
            637,630}, 4));
        citiesLinked.add(new String[] { "Duisburg", "Roermond" });
        routeColors.add(Route.RouteColor.YELLOW);    
        routeCars.add(new Polygon(new int[]{420,432,420,410}, new int[]{539,
            539,621,620}, 4));
        citiesLinked.add(new String[] { "Nijmegen", "Eindhoven" });
        routeColors.add(Route.RouteColor.ORANGE);        
        routeCars.add(new Polygon(new int[]{413,420,409,399}, new int[]{538,539,
            620,618}, 4));
        citiesLinked.add(new String[] { "Nijmegen", "Eindhoven" });
        routeColors.add(Route.RouteColor.BLACK);
        routeCars.add(new Polygon(new int[]{159,165,184,177}, new int[]{592,586,
            604,611}, 4));
        citiesLinked.add(new String[] { "'sGravenhage", "Rotterdam" });
        routeColors.add(Route.RouteColor.GREEN);        
        routeCars.add(new Polygon(new int[]{152,157,176,168}, new int[]{598,592,
            612,617}, 4));
        citiesLinked.add(new String[] { "'sGravenhage", "Rotterdam" });
        routeColors.add(Route.RouteColor.ORANGE);
        routeCars.add(new Polygon(new int[]{267,279,332,324}, new int[]{537,531,
            590,596}, 4));
        citiesLinked.add(new String[] { "Utrecht", "'sHertogenbosch" });
        routeColors.add(Route.RouteColor.BLACK);
        routeCars.add(new Polygon(new int[]{278,283,339,333}, new int[]{532,524,
            582,589}, 4));
        citiesLinked.add(new String[] { "Utrecht", "'sHertogenbosch" });
        routeColors.add(Route.RouteColor.RED);
        routeCars.add(new Polygon(new int[]{404,414,424,415}, new int[]{491,486,
            509,513}, 4));
        citiesLinked.add(new String[] { "Arnhem", "Nijmegen" });
        routeColors.add(Route.RouteColor.RED);        
        routeCars.add(new Polygon(new int[]{393,403,414,404}, new int[]{493,490,
            511,517}, 4));
        citiesLinked.add(new String[] { "Arnhem", "Nijmegen" });
        routeColors.add(Route.RouteColor.YELLOW);
        routeCars.add(new Polygon(new int[]{521,531,547,561,571,577,576,576,566,
            566,565,561,551,538}, new int[]{364,359,382,406,432,463,488,518,516,
                490,463,435,409,386}, 14));
        citiesLinked.add(new String[] { "Enschede", "Duisburg" });
        routeColors.add(Route.RouteColor.WHITE);
        routeCars.add(new Polygon(new int[]{510,518,535,550,561,565,565,565,552,
            555,550,549,540,526}, new int[]{366,361,384,410,436,464,493,521,520,
                494,440,439,412,390}, 14));
        citiesLinked.add(new String[] { "Enschede", "Duisburg" });
        routeColors.add(Route.RouteColor.ORANGE);
        routeCars.add(new Polygon(new int[]{499,507,419,413}, new int[]{364,370,
            477,470}, 4));
        citiesLinked.add(new String[] { "Enschede", "Arnhem" });
        routeColors.add(Route.RouteColor.BLACK);
        routeCars.add(new Polygon(new int[]{491,498,410,403}, new int[]{356,362,
            470,462}, 4));
        citiesLinked.add(new String[] { "Enschede", "Arnhem" });
        routeColors.add(Route.RouteColor.GREEN);
        routeCars.add(new Polygon(new int[]{364,374,399,388}, new int[]{357,355,
            460,463}, 4));
        citiesLinked.add(new String[] { "Zwolle", "Arnhem" });
        routeColors.add(Route.RouteColor.PURPLE);
        routeCars.add(new Polygon(new int[]{354,362,386,376}, new int[]{357,356,
            461,465}, 4));
        citiesLinked.add(new String[] { "Zwolle", "Arnhem" });
        routeColors.add(Route.RouteColor.ORANGE);        
        routeCars.add(new Polygon(new int[]{274,383,384,278}, new int[]{508,486,
            496,518}, 4));
        citiesLinked.add(new String[] { "Utrecht", "Arnhem" });
        routeColors.add(Route.RouteColor.WHITE);        
        routeCars.add(new Polygon(new int[]{273,379,382,275}, new int[]{498,476,
            486,509}, 4));
        citiesLinked.add(new String[] { "Utrecht", "Arnhem" });
        routeColors.add(Route.RouteColor.BLUE);
        routeCars.add(new Polygon(new int[]{247,257,249,236,220,211,226,239}, 
                new int[]{528,532,558,583,608,602,580,554}, 8));
        citiesLinked.add(new String[] { "Utrecht", "Rotterdam" });
        routeColors.add(Route.RouteColor.GRAY);
        routeCars.add(new Polygon(new int[]{206,215,205,196}, new int[]{494,497,
            604,603}, 4));
        citiesLinked.add(new String[] { "Rotterdam", "Amsterdam" });
        routeColors.add(Route.RouteColor.BLUE);
        routeCars.add(new Polygon(new int[]{197, 206,195,185}, new int[]{497,
            497,603,602}, 4));
        citiesLinked.add(new String[] { "Rotterdam", "Amsterdam" });
        routeColors.add(Route.RouteColor.RED);
        routeCars.add(new Polygon(new int[]{154,165,155,146}, new int[]{509,511,
            565,562}, 4));
        citiesLinked.add(new String[] { "Haarlem", "'sGravenhage" });
        routeColors.add(Route.RouteColor.PURPLE);
        routeCars.add(new Polygon(new int[]{144,153,145,134}, new int[]{503,508,
            563,560}, 4));
        citiesLinked.add(new String[] { "Haarlem", "'sGravenhage" });        
        routeColors.add(Route.RouteColor.WHITE);
        routeCars.add(new Polygon(new int[]{218,224,247,240}, new int[]{492,483,
            501,508}, 4));
        citiesLinked.add(new String[] { "Utrecht", "Amsterdam" });
        routeColors.add(Route.RouteColor.ORANGE);        
        routeCars.add(new Polygon(new int[]{227,232,255,247}, new int[]{484,476,
            493,500}, 4));
        citiesLinked.add(new String[] { "Utrecht", "Amsterdam" });
        routeColors.add(Route.RouteColor.PURPLE);
        routeCars.add(new Polygon(new int[]{169,194,197,173}, new int[]{484,476,
            487,493}, 4));
        citiesLinked.add(new String[] { "Haarlem", "Amsterdam" });
        routeColors.add(Route.RouteColor.BLACK);        
        routeCars.add(new Polygon(new int[]{167,192,194,169}, new int[]{473,466,
            477,483}, 4));
        citiesLinked.add(new String[] { "Haarlem", "Amsterdam" });
        routeColors.add(Route.RouteColor.GREEN);
        routeCars.add(new Polygon(new int[]{264,272,225,217}, new int[]{398,403,
            469,465}, 4));
        citiesLinked.add(new String[] { "Lelystad", "Amsterdam" });
        routeColors.add(Route.RouteColor.WHITE);
        routeCars.add(new Polygon(new int[]{256,264,216,208}, new int[]{391,395,
            464,457}, 4));
        citiesLinked.add(new String[] { "Lelystad", "Amsterdam" });
        routeColors.add(Route.RouteColor.YELLOW);
        routeCars.add(new Polygon(new int[]{101,111,146,139}, new int[]{371,369,
            471,474}, 4));
        citiesLinked.add(new String[] { "DenHelder", "Haarlem" });
        routeColors.add(Route.RouteColor.BLUE);
        routeCars.add(new Polygon(new int[]{113,120,157,149}, new int[]{369,365,
            468,471}, 4));        
        citiesLinked.add(new String[] { "DenHelder", "Haarlem" });
        routeColors.add(Route.RouteColor.ORANGE);     
        routeCars.add(new Polygon(new int[]{291,286,335,340}, new int[]{369,361,
            339,346}, 4));  
        citiesLinked.add(new String[] { "Lelystad", "Zwolle" });
        routeColors.add(Route.RouteColor.BLACK);        
        routeCars.add(new Polygon(new int[]{295,292,340,344}, new int[]{380,372,
            348,357}, 4));  
        citiesLinked.add(new String[] { "Lelystad", "Zwolle" });
        routeColors.add(Route.RouteColor.RED);
        routeCars.add(new Polygon(new int[]{379,379,490,490}, new int[]{347,337,
            341,351}, 4));  
        citiesLinked.add(new String[] { "Zwolle", "Enschede" });
        routeColors.add(Route.RouteColor.YELLOW);
        routeCars.add(new Polygon(new int[]{380,379,490,491}, new int[]{336,326,
            330,340}, 4));  
        citiesLinked.add(new String[] { "Zwolle", "Enschede" });
        routeColors.add(Route.RouteColor.BLUE);
    }

    /**
     * Gets the cities that were clicked on
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