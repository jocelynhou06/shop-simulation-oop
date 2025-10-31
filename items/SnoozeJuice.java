package assignment1.items;

public class SnoozeJuice extends Drink{
    private double celsiusTemp;
    public static int HOT_COLD_BOOST;
    public SnoozeJuice(double p, int h, int numOfBottles, double t){
        super(p, h, numOfBottles, false);
        this.celsiusTemp = t;
    }
    public boolean equals(Object o){
        /*if(o instanceof SnoozeJuice) {
            SnoozeJuice obj = (SnoozeJuice) o;
            if (Math.abs(obj.getPrice() - this.getPrice()) < 0.001) {
                if (obj.getHappinessIndex() == this.getHappinessIndex()) {
                    if(obj.BUZZY_HAPPINESS_BOOST == this.BUZZY_HAPPINESS_BOOST){
                        if (Math.abs(obj.celsiusTemp - this.celsiusTemp) < 0.001) {
                            return true;
                        }
                    }
                }
            }
        }*/
        if(super.equals(o)) {
            if (o instanceof SnoozeJuice) {
                if (Math.abs(((SnoozeJuice) o).celsiusTemp - this.celsiusTemp) < 0.001) {
                    return true;
                }
            }
        }
        return false;
    }
    public int getHappinessIndex(){
        int month = MyDate.today().getMonth();
        if(this.celsiusTemp < 4 || this.celsiusTemp > 65) {
            return 0;
        }
        else if(this.celsiusTemp >= 4 && this.celsiusTemp <= 10){
            for(int i = 0; i < MyDate.SUMMER_MONTHS.length; i++){
                if (month == MyDate.SUMMER_MONTHS[i]){
                    return super.getHappinessIndex() + HOT_COLD_BOOST;
                }
            }
            return super.getHappinessIndex();
        }
        else if(this.celsiusTemp >= 55 && this.celsiusTemp <= 65){
            for(int i = 0; i < MyDate.WINTER_MONTHS.length; i++){
                if (month == MyDate.WINTER_MONTHS[i]){
                    return super.getHappinessIndex() + HOT_COLD_BOOST;
                }
            }
            return super.getHappinessIndex();
        }
        else{
            return super.getHappinessIndex();
        }
    }
    public Drink getPortion(int i){
        if(i <= this.availableBottles){
            SnoozeJuice newSnoozeJuice = new SnoozeJuice(this.getPrice(), this.getHappinessIndex(), i, this.celsiusTemp);
            this.availableBottles = this.availableBottles - i;
            return newSnoozeJuice;
        }
        else{
            return null;
        }
    }
}

//fix all equals method, don't overwrite it each time
