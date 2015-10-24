import java.util.Scanner;
class aout{
    public aout(String... args){
        Scanner s = new Scanner(System.in);
        long number, factor;
        nums: while(s.hasNext()){
            number = s.nextLong();
            for(int i = 1; i <= (number / 4); i++){
                if(number % (4*i+1) == 0){
                    System.out.println(number + " yes");
                    System.out.println(i);
                    continue nums;
                }
            }
            System.out.println(number + " no");
        }
        s.close();
    }
    public static void main(String[] args){
        new aout();
    }
}
