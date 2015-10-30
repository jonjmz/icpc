import java.util.Scanner;
class aout{
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext())
            getChange(s);
        s.close();
    }
    public static void getChange(Scanner s){ 
        int cents = s.nextInt();
        int halfDollars = s.nextInt();
        s.nextLine(); // Clean up left over newline
        int[] used = {0,  0,  0, 0, 0};
        int[] dens = {50, 25, 10, 5, 1};
        int current = 0;
        while(cents > 0){
            // If on half dollars, but none left move on
            if(current == 0 && halfDollars < 1){
                current++;
                continue;
            }
            if(cents >= dens[current]){
               cents -= dens[current];
               used[current]++;
            } else {
               current++;
            }
        }
        boolean first = true;
        for(int i = 0; i < 5; i++){
            if(used[i] != 0){
                if(first)
                    System.out.print(used[i] + "x" + dens[i]);
                else
                    System.out.print(" " + used[i] + "x" + dens[i]);
                first = false;
            }
        }
        System.out.println();
    }
}
