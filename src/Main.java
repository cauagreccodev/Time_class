import java.util.Arrays;
public class Main{
    public static void main(String args[]) throws Exception{
        Time t1 = new Time((byte) 23, (byte)59,(byte)30);
        Time t2 = new Time((byte) 23, (byte)30,(byte)31);
        Time t3 = new Time((byte) 18, (byte)30,(byte)31);
        Time t4 = new Time((byte) 23, (byte)22,(byte)31);
        Time[] vet_Time = {
            t1,
            t2,
            t3,
            t4
        };

        Arrays.sort(vet_Time);
        System.out.println(t2);
        System.out.println(t2.equals(t1));

        for(Time time: vet_Time){
            System.out.println(time);
        }
        
        t1.advance(30);
        System.out.println(t1);
        t1.goBack(60);
        System.out.println(t1);
    }
}