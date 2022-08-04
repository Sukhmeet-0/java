
import java.util.Scanner;

public class Time implements Comparable<Time>,Cloneable{
    private int minute,second,hour;
    private long totalSeconds,elapsedTime1,elapsedTime2;
    private static int h,m,s;
    Time(){
        totalSeconds=System.currentTimeMillis()/1000;
    }
    Time(int hour,int minute,int second ){
        System.out.println(hour+" hours "+minute+" minuted "+second+" seconds");
        elapsedTime1=(((hour*60*60)+(minute*60)+(second))*1000);
        System.out.println("Elapsed seconds in time1: "+elapsedTime1);
    }
    Time(long elapsedTime){
        elapsedTime2=elapsedTime;
        long totalseconds=elapsedTime/1000L;
        second=(int) ((int)totalseconds%60L);
        long totalMinutes=totalseconds/60;
        minute=(int)((int)totalMinutes%60L);
        long totalHours=totalMinutes/60;
        hour=(int)((int)totalHours%24);

        System.out.println(hour+" hours "+minute+" minutes "+second+" seconds");
        System.out.println("Elapsed seconds in time1: "+elapsedTime2);
    }
    public int getHour(){
        return (int)((((System.currentTimeMillis()/1000)/60)/60)%24);
    }
    public int getMinute(){
        return (int)(((System.currentTimeMillis()/1000)/60)%60);
    }
    public int getSecond(){
        long sec=System.currentTimeMillis();
        return  (int)((sec/1000L)%60);
    }
    public long getSeconds(){
        return totalSeconds;
    }
    public String toString(){
        return hour+" hours "+minute+" minutes "+second+" seconds and "+getHour()+" hours "+getMinute()+" minutes "+getSecond()+" seconds ";
    }
    public int compareTo(Time t){
        return (int)elapsedTime1-(int)t.elapsedTime2;
    }
    public static void main(String[]args) throws CloneNotSupportedException{
        Time time=new Time();
        System.out.println(time.getSeconds());
        System.out.println();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter time (Hours Minutes Seconds): ");
        h=sc.nextInt();
        m=sc.nextInt();
        s=sc.nextInt();
        Time time1=new Time(h,m,s);
        System.out.println();
        Time time2=new Time(18061000);
        System.out.println();
        System.out.println(time1.compareTo(time2));

        Time time4=(Time) time.clone();
        System.out.println(time4.totalSeconds);
        sc.close();

    }

}



