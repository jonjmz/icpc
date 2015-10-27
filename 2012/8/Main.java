import java.util.Scanner;
import java.lang.Math;
class aout{
    public aout(String... args){
        Scanner s = new Scanner(System.in);
        long number, factor;
        nums: while(s.hasNext()){
            number = s.nextLong();
            for(int i = 1; i <= Math.sqrt(number); i++){
                if(number % (4*i+1) == 0){
                    if(isPrime(4*i+1)){
                        System.out.println(number + " yes");
                        continue nums;
                    }
                }
            }
            System.out.println(number + " no");
        }
        s.close();
    }
    static boolean isPrime(int num){
        for(int i = 2; i < (int)(0.5 + Math.sqrt(num)); i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        new aout();
    }
}
