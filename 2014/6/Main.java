import java.util.Scanner;
import java.math.*;
import java.util.HashMap;
import java.lang.Math;
class aout{
    private static final double radius = 3958.750;
    public static void main(String... args){ 
        HashMap<String,Coord> airmap = new HashMap<String, Coord>();
        Scanner s = new Scanner(System.in);

        parse(s, airmap);

        while(s.hasNextLine())
            route(s, airmap);

        s.close();
    }
    //Traversing
    static void route(Scanner s, HashMap<String, Coord> airmap){
        String[] values = s.nextLine().split(" ");
        double total = 0;
        for(int i = 1; i < values.length; i++){
            total += distance(values[i-1], values[i], airmap);
        }
        System.out.println((int)(total+0.5));
    }
    static double distance(String departure, String arival, HashMap<String, Coord> airmap){ 
        double a, c, deltaLat, deltaLon;

        Coord dep = airmap.get(departure);
        Coord ari = airmap.get(arival);

        deltaLat = ari.lat - dep.lat;
        deltaLon = ari.lon - dep.lon;

        a = Math.pow(Math.sin(deltaLat/2), 2) + Math.pow(Math.sin(deltaLon/2), 2) * Math.cos(ari.lat) * Math.cos(dep.lat);
        c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return radius * c;
    }

    //Parsing
    static void parse(Scanner s, HashMap<String, Coord> airmap){
        String name;
        double lat;
        double lon;
        double deg, hour, min;
        char mod;

        while(!"---".equals(name = s.next())){
            String[] values = s.nextLine().split(" ");
            deg = Double.parseDouble(values[1]);
            hour = Integer.parseInt(values[2]); 
            min = Integer.parseInt(values[3]);
            mod = values[4].toCharArray()[0];
            lat = deg + (hour + min/60)/60;
            if(mod=='S') lat *= -1;

            deg = Double.parseDouble(values[5]);
            hour = Integer.parseInt(values[6]); 
            min = Integer.parseInt(values[7]);
            mod = values[8].toCharArray()[0];
            lon = deg + (hour + min/60)/60;
            if(mod=='E') lon *= -1;

            Coord temp = new Coord(Math.toRadians(lat), Math.toRadians(lon));
            airmap.put(name, temp);
        }
        s.nextLine(); //Cleans up newline
    }
}

class Coord{
    public double lat;
    public double lon;
    public Coord(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
    }
}
