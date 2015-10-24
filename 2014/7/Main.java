import java.util.Scanner;
import java.util.HashMap;

class aout{
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        HashMap<Integer, String> inst = new HashMap<Integer, String>();
        int e, a = 0;
        int le = 0, la = 0;
        int pc = 0;
        boolean first = true;
        load(inst);
        while(s.hasNext()){
            e = Integer.parseInt(s.next());
            //Halt command, dont read address
            if(e!=0 && inst.containsKey(e))
                a = Integer.parseInt(s.next());
            // Repeated Command
            if(e == le && (e == 0 || a == la)){
                // First time repeating
                if(first){
                    first = false;
                    System.out.println("same as above");
                }
                pc++;
                continue;
            }
            // New command
            first = true;
            le = e;
            la = a;
            //Wierd command
            if(!inst.containsKey(e)){
                System.out.printf("%04d %04d\n", pc++, e);
                continue;
            }
            //Print Command
            System.out.printf("%04d %04d %s\n", pc++, e, inst.get(e));
            //Print Address
            if(e!=0)
                System.out.printf("%04d %04d\n",    pc++, a);
        }
        if(pc < 997){
            System.out.printf("%04d 0000 halt\n", pc++);
            System.out.println("same as above");
        }
        if(pc < 999){
            System.out.println("0999 0000 halt");
        }
    }
    public static void load(HashMap<Integer, String> inst){
        inst.put(0000, "halt");
        inst.put(1100, "load rega");
        inst.put(1200, "load regb");
        inst.put(1400, "load regc");
        inst.put(1800, "load regd");
        inst.put(2100, "store rega");
        inst.put(2200, "store regb");
        inst.put(2400, "store regc");
        inst.put(2800, "store regd");
        inst.put(4000, "bif never");
        inst.put(4001, "bif az");
        inst.put(4003, "bif anz");
        inst.put(4005, "bif bz");
        inst.put(4007, "bif bnz");
        inst.put(4008, "bif always");
        inst.put(4010, "bif incb never");
        inst.put(4011, "bif incb az");
        inst.put(4013, "bif incb anz");
        inst.put(4015, "bif incb bz");
        inst.put(4017, "bif incb bnz");
        inst.put(4018, "bif incb always");
        inst.put(4020, "bif decb never");
        inst.put(4021, "bif decb az");
        inst.put(4023, "bif decb anz");
        inst.put(4025, "bif decb bz");
        inst.put(4027, "bif decb bnz");
        inst.put(4028, "bif decb always");
        inst.put(4100, "bif inca never");
        inst.put(4101, "bif inca az");
        inst.put(4103, "bif inca anz");
        inst.put(4105, "bif inca bz");
        inst.put(4107, "bif inca bnz");
        inst.put(4108, "bif inca always");
        inst.put(4110, "bif inca incb never");
        inst.put(4111, "bif inca incb az");
        inst.put(4113, "bif inca incb anz");
        inst.put(4115, "bif inca incb bz");
        inst.put(4117, "bif inca incb bnz");
        inst.put(4118, "bif inca incb always");
        inst.put(4120, "bif inca decb never");
        inst.put(4121, "bif inca decb az");
        inst.put(4123, "bif inca decb anz");
        inst.put(4125, "bif inca decb bz");
        inst.put(4127, "bif inca decb bnz");
        inst.put(4128, "bif inca decb always");
        inst.put(4200, "bif deca never");
        inst.put(4201, "bif deca az");
        inst.put(4203, "bif deca anz");
        inst.put(4205, "bif deca bz");
        inst.put(4207, "bif deca bnz");
        inst.put(4208, "bif deca always");
        inst.put(4210, "bif deca incb never");
        inst.put(4211, "bif deca incb az");
        inst.put(4213, "bif deca incb anz");
        inst.put(4215, "bif deca incb bz");
        inst.put(4217, "bif deca incb bnz");
        inst.put(4218, "bif deca incb always");
        inst.put(4220, "bif deca decb never");
        inst.put(4221, "bif deca decb az");
        inst.put(4223, "bif deca decb anz");
        inst.put(4225, "bif deca decb bz");
        inst.put(4227, "bif deca decb bnz");
        inst.put(4228, "bif deca decb always");
    }
}
