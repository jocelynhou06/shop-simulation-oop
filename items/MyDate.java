package assignment1.items;

public class MyDate{
    private int day;
    private int month;
    private int year;
    public static int[] SUMMER_MONTHS;
    public static int[] WINTER_MONTHS;
    public MyDate(int d, int m, int y){
        //general filter
        //does this account for BC years O-O
        if(d > 31 || d < 1 || m > 12 || m < 1 || y < 0) {
            throw new IllegalArgumentException("Invalid Date");
        }
        //day filters for month
        if((m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) && d <= 31) {
            this.day = d;
            this.month = m;
            this.year = y;
        }
        else if((m == 2) && d <= 29){
            this.day = d;
            this.month = m;
            this.year = y;
        }
        else if((m == 4 || m == 6 || m == 9 || m == 11) && d <= 30){
            this.day = d;
            this.month = m;
            this.year = y;
        }
        else{
            throw new IllegalArgumentException("Invalid Date");
        }
    }
    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }

    public boolean equals(Object o){
        if(o instanceof MyDate) {
            MyDate obj = (MyDate) o;
            if(obj.getYear() == this.year && obj.getMonth() == this.month && obj.getDay() == this.day){
                return true;
            }
        }
        return false;
    }
    public static MyDate today(){
        java.time.LocalDate now = java.time.LocalDate.now();

        MyDate today = new MyDate(now.getDayOfMonth(), now.getMonthValue(), now.getYear());
        return today;
    }
    public String toString(){
        return String.format("%04d-%02d-%02d", getYear(), getMonth(), getDay());
    }
    /*public static void main(String args[]){
        MyDate test = new MyDate(1,1,2024);
        System.out.println(test.toString());
    }*/
}