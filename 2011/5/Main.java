import java.util.Scanner;

class aout{
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        int number;
        int i, result;
        while(s.hasNext()){
            number = s.nextInt();
            i = 1;
            result = 0;
            for(; result < number; i++){
               result += i;
            }
            if(result == number)
                System.out.println(i-1);
            else
                System.out.println("bad");
            s.nextLine();
        }
    }
}
