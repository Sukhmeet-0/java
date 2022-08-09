import java.util.Scanner;

class Time implements Comparable<Time>,Cloneable{
    private int minute,second,hour;
    private long totalSeconds,elapsedTime1;
    private static int h,m,s;
    Time(){
        totalSeconds=System.currentTimeMillis()/1000;
    }
    Time(int hour,int minute,int second ){
        elapsedTime1=(((hour*60*60)+(minute*60)+(second)));
        long totalHours=elapsedTime1/60/60;
        int mhour=(int)((int)totalHours%24);
        long totalMinutes=(elapsedTime1/60)-(hour*60);
        int mminute=(int)((int)totalMinutes%60);
        long totalseconds=elapsedTime1-((hour*60)*60)-(minute*60);
        int msecond=(int) ((int)totalseconds%60);
        System.out.println(mhour+" hours "+mminute+" minutes "+msecond+" seconds");
        System.out.println("Elapsed seconds in time1: "+elapsedTime1);
    }
    Time(long  elapsedTime){
        elapsedTime1=elapsedTime;
        long totalHours=elapsedTime/60/60;
        hour=(int)((int)totalHours%24);
        long totalMinutes=(elapsedTime/60)-(hour*60);
        minute=(int)((int)totalMinutes%60);
        long totalseconds=elapsedTime-((hour*60)*60)-(minute*60);
        second=(int) ((int)totalseconds%60);

        System.out.println(hour+" hours "+minute+" minutes "+second+" seconds");
        System.out.println("Elapsed seconds in time2: "+elapsedTime1);
    }
    public int getHour(){
        return (int)((((System.currentTimeMillis()/1000)/60)/60)%60);
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
        return (int)elapsedTime1-(int)t.elapsedTime1;
    }
    public static void main(String[]args) throws CloneNotSupportedException{
        Scanner sc=new Scanner(System.in);


        Time time=new Time();
        System.out.print("Enter time (Hours Minutes Seconds): ");
        h=sc.nextInt();
        m=sc.nextInt();
        s=sc.nextInt();
        Time time1=new Time(h,m,s);
        System.out.println();


        System.out.print("Enter time(In Seconds)  : ");
        long time2Inseconds=sc.nextLong();
        Time time2=new Time(time2Inseconds);
        System.out.println();

        System.out.print("time1.compareTo(time2)? ");
        System.out.println(time1.compareTo(time2));
        
        Time time3=(Time) time1.clone();
        
        System.out.println("time3 is created as clone of time1");
        System.out.print("time1.compareTo(time3)?  ");
        System.out.println(time1.compareTo(time3));


        sc.close();

    }

}