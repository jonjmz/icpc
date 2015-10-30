import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
class aout{
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        ArrayList<double[]> coords = new ArrayList<double[]>();
        double AB = s.nextDouble();
        double BC = s.nextDouble();
        double alpha = Math.toRadians(s.nextDouble());
        s.nextLine(); //clean up buffer
        // Get CD
        double AC = Math.sqrt(Math.pow(AB, 2) + Math.pow(BC, 2));
        double CD = Math.tan(alpha) * AC;
        // GET CE
        double phi = alpha + Math.atan(BC / AB);
        double BCE = AB * Math.tan(phi);
        double CE = BCE - BC;
        //Get Ratio
        double scaler = CE / CD;

        double x, y;
        boolean first = true;
        while(s.hasNext()){
            x = s.nextDouble();
            y = s.nextDouble();
            s.nextLine(); //clean up buffer
            if( x == -1 && y == -1){
                first = true;
                System.out.println();
            } else {
                System.out.printf("%.2f %.2f\n", x, y * scaler);
            }
        }
        s.close();
    }
}
