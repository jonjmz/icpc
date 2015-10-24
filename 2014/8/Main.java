import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

class aout{
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        ArrayList<Player> g = new ArrayList<Player>();
        ArrayList<Player> d = new ArrayList<Player>();
        ArrayList<Player> m = new ArrayList<Player>();
        ArrayList<Player> f = new ArrayList<Player>();
        parse(s, g, d, m, f);
    }
    static void optamize(int available){ 
        int cg, cd, cm, cf;
    }

    static void parse(Scanner s, ArrayList<Player> g, ArrayList<Player> d, ArrayList<Player> m, ArrayList<Player> f){
        int count = Integer.parseInt(s.nextLine());
        String[] vals;
        for(int i = 0; i < count; i++){
            vals = s.nextLine().split(" ");
            switch(vals[0]){
               case "G":
                   g.add(new Player(Integer.parseInt(vals[1]), vals[2]));
                   break;
               case "D":
                   d.add(new Player(Integer.parseInt(vals[1]), vals[2]));
                   break;
               case "M":
                   m.add(new Player(Integer.parseInt(vals[1]), vals[2]));
                   break;
               case "F":
                   f.add(new Player(Integer.parseInt(vals[1]), vals[2]));
                   break;
            }
        }
    }
}
class Player{
    int price;
    String name;
    public Player(int price, String name){
        this.price = price;
        this.name = name;
    }
}
