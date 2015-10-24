import java.util.Scanner;

class aout {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] header = s.nextLine().split(",");              //get the headers seperatly
        String[] order_temp = s.nextLine().split(",");          //get the order information

        int[] order = new int[order_temp.length];               //conversion
        for(int i = 0; i < order_temp.length; i++){
            order[i] = Integer.parseInt(order_temp[i]);
        }

        print(order, header);                                   //print the headers
        s.nextLine();                                           //throw away columns
        while(s.hasNext()){                                     //convert column info to int
            print(order, s.nextLine().split(","));
        }
        s.close();                                              //let's be tidy
    }
    private static void print(int[] order, String[] values){
        int current = 1;
        boolean found = true;
        String prefix = "";                                     //so first item doesnt get comma
        while(current <= order.length && found){                //we havn't checked every column, it's not all zero
            found = false;                                      //so we know if we are out of printer columns
            search: for(int i = 0; i < order.length; i++){
                if(current == order[i]){                        //It's time to output the value from here
                    System.out.print(prefix + values[i]);
                    found = true;                               //we know we can keep looking
                    prefix = ",";                               //at least the first coumn is printed
                    break search;                               //stop searching for the position
                }
            }
            current++;                                          //check for next column
        }
        System.out.println();                                   //finish that line
    }
}
