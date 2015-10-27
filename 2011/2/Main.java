import java.util.Scanner;
import java.util.ArrayList;
class aout{
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> months;
        int sim, mih, hid, count, first, second;
        while(s.hasNext()){
            months = new ArrayList<Integer>();
            sim = s.nextInt();
            if(sim==0) break;//Why would they set it up this way?
            mih = s.nextInt();
            hid = s.nextInt();
            count = s.nextInt();
            for(int i = 0; i < count; i++)
                months.add(s.nextInt());
            first = toSec(s.next(), months, sim, mih, hid);
            second = toSec(s.next(), months, sim, mih, hid);
            s.nextLine();
            System.out.println(second-first);
        }
        s.close();
    }
    public static int toSec(String daytime, ArrayList<Integer> months, int sim, int mih, int hid){
        String[] temp = daytime.split("-");
        String[] date = temp[0].split("/");
        String[] time = temp[1].split(":");

        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);

        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int second = Integer.parseInt(time[2]);

        int daysFromYear = 0;
        int daysFromMonths = 0;
        for(int i = 0; i < months.size(); i++){
            daysFromYear += months.get(i);
        }
        for(int i = 0; i < month-1; i++){
            daysFromMonths += months.get(i);
        }
        int days = day + daysFromYear + daysFromMonths;
        int hours = hour + (days - 1) * hid;
        int minutes = minute + (hours - 1) * mih;
        int seconds = second + (minutes - 1) * sim;
        return seconds;
    }
}
