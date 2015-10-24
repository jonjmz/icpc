import java.util.Scanner;

class aout {
    public static void main(String[] args) {
        Scanner s = new Scanner(System. in );
        int count = 0; //Contestent count
        int tloc = 0; //highest iterator (used for sorting)
        int tval = 0;
        int floc = 0; //highest iterator from first judge
        int sloc = 0; //highest iterator from second judge
        int place = 0; //used as clerification for i
        int[] first, second;

        while (s.hasNext()) {
            //Get scores, and the indexes of the high values
            count = s.nextInt();
            first = new int[count];
            second = new int[count];
            //get first judges scores, and find index of highest
            //First Judge
            for (int i = 0; i < count; i++) {
                    first[i] = s.nextInt();
                    if (first[i] > first[floc]) {
                            floc = i;
                    }
            }
            //Second Judge
            for (int i = 0; i < count; i++) {
                second[i] = s.nextInt();
                if (second[i] > second[sloc]) {
                    sloc = i;
                }
            }

        for (int i = 0; i < count; i++) {
            //place starts at 1, instead of zero
            place = i + 1;
            //Check if high indexes mach up
            if (floc != sloc) {
                    //if disagree we are done
                    System.out.println(place);
                    break;
            }
            if (place == count) { //No more disagrement possible
                    System.out.println("agree");
                    break;
            }
            //look for next high value under the current high
            tval = 0; //First Judge
            for (int j = 0; j < count; j++)
            if (first[j] < first[floc] && first[j] > tval) tval = first[tloc = j]; //update temp max-es
            floc = tloc; //update actual max

            tval = 0; //Second Judge
            for (int j = 0; j < count; j++)
            if (second[j] < second[sloc] && second[j] > tval) tval = second[tloc = j]; //update temp max-es
            sloc = tloc; //update actual max
            }
        }
        s.close();
    }
}
