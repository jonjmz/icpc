import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class aout {
	Map<Integer, Intersection> map;
	Map<Street, String> errors;
	ArrayList<Street> streetOrder;
	int threshhold;
    public aout(){
    	map = new HashMap<Integer, Intersection>();
    	errors = new HashMap<Street, String>();
    	Scanner s = new Scanner(System.in);
    	threshhold = s.nextInt();
    	s.nextLine(); //Last call to s leaves newline
    	
    	parse(s);

    	for(Map.Entry<Integer, Intersection> e : map.entrySet()){
    		if(e.getValue().entrance<2){
    	    	traverse(e.getValue(), 0, 0, 10);
    		}
    	}
    	
    	for(Street street : streetOrder){
    		if(errors.containsKey(street)){
    			
    			System.out.println(street.start + " " + street.end + " " + errors.get(street));
    		}
    	}

    	s.close();
	}
    public void traverse(Intersection inter, int speed, int prev, int depth){
        if(depth == 0)// Too Deap
                return;
        for(Street street : inter.streets){
            if(prev == street.end) continue;// No U-turns
            //There are posted speed limits
            if(street.limits.size() > 0){
                //The first one is past the threshhold and it's different from where we came from
                if(street.limits.get(0).position > threshhold && speed != street.limits.get(0).limit){
                        errors.put(street, "u");
                }
                speed = street.limits.get(street.limits.size()-1).limit;
            }
            //It's the first time we go through here
            if(street.lastSpeed == 0){
                 street.lastSpeed = speed;
            }
            //We are traveling at a different speed this time!
            if (street.lastSpeed != speed){
                errors.put(street, "c");
            }
            //Let's go to the next interesection
            if(map.containsKey(street.end)){
                  traverse(map.get(street.end), speed, inter.name, depth -1);
            }
        }
    }
    public void parse(Scanner s){
    	streetOrder = new ArrayList<Street>();
    	String[] line;
    	Intersection inter;
    	Street street;
    	Limit limit;
    	int start, end, max, position, length;
    	String[] temp;
    	while(s.hasNextLine()){
    		line = s.nextLine().split("\\s+");
    		start = Integer.parseInt(line[0]);
    		end = Integer.parseInt(line[1]);
    		length = Integer.parseInt(line[2]);
    		street = new Street(length, start, end);
    		for(int i = 3; i < line.length; i++){
    			temp = line[i].split(",");
    			position = Integer.parseInt(temp[0]);
    			max = Integer.parseInt(temp[1]);
    			street.limits.add(new Limit(position, max));
    		}
    		if(map.containsKey(start)){
    			map.get(start).streets.add(street);
    		} else {
    			inter = new Intersection(start);
    			inter.streets.add(street);
    			map.put(start, inter);
    		}
    		if(map.containsKey(end))
    			map.get(end).entrance++;
    		else
    			map.put(end, new Intersection(end));
    		streetOrder.add(street);
    	}
    }
    private class Intersection{
    	public int name;
    	public int entrance;
    	public ArrayList<Street> streets;
    	public Intersection(int name) {
			this.name = name;
			streets = new ArrayList<Street>();
			entrance = 1;
		}
    }
    private class Street{
    	public int length;
    	public ArrayList<Limit> limits;
    	public int start;
    	public int end;
    	public int lastSpeed;
    	public Street(int length, int start, int end){
    		this.length = length;
    		this.start = start;
    		this.end = end;
    		limits = new ArrayList<Limit>();
    		lastSpeed = 0;
    	}
    }
    private class Limit{
    	public int position;
    	public int limit;
    	public Limit(int position, int limit){
    		this.position = position;
    		this.limit = limit;
    	}
    }
    public static void main(String[] args) {
    	new Solution();
	}
}
