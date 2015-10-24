import java.util.Scanner;
import java.math.*;
public class aout{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int amount = s.nextInt();
		int temp;
		int bandits, min, locks, keys;
		for(int i = 0; i < amount; i++){
			bandits = s.nextInt();
			min = s.nextInt();
			System.out.println(c(bandits, min-1) + " " + c(bandits-1, min-1));
		}
		s.close();
	}
	public static int f(int num){
		switch(num){
		case 0:
		case 1:
			return 1;
		default:
			return num * f(num-1);
		}
	}
	public static int c(int n, int r){
		return f(n)/(f(r)*f(n-r));
	}
}
