import java.util.Scanner;
class aout{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] values;
        double low, high, fee;
        while(s.hasNext()){
            values = s.nextLine().split(",");
            low = (double)(Integer.parseInt(values[3])) / Integer.parseInt(values[1]);
            high = (double)(Integer.parseInt(values[4])) / Integer.parseInt(values[1]);
            fee = Integer.parseInt(values[2]);
            System.out.print(values[0] + " Fees per Unit: $");
            System.out.print((int)(low + 0.5) + "-$");
            System.out.print((int)(high + 0.5) + " Full Time: $");
            System.out.print((int)(low*fee + 0.5) + "-$");
            System.out.println((int)(high*fee + 0.5));
        }
        s.close();
    }
}
