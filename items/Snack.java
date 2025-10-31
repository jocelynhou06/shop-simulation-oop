package assignment1.items;

public class Snack extends StoreItem{
    private String snackType;
    private MyDate expirationDate;

    public Snack(double p, int h, String snackType, MyDate date){
        super(p, h);
        this.snackType = snackType;
        this.expirationDate = date;
    }

    public boolean equals(Object o){
        if(super.equals(o)){
            if (o instanceof Snack) {
                Snack obj = (Snack) o;
                if (obj.snackType.equals(this.snackType)) {
                    if(obj.expirationDate.equals(this.expirationDate)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isExpired(){
        MyDate today = MyDate.today();
        if(today.toString().compareTo(expirationDate.toString()) <= 0){
            return false;
        }
        return true;
    }
    public int getHappinessIndex(){
        if(isExpired()){
            return super.getHappinessIndex() / 2;
        }
        else{
            return super.getHappinessIndex();
        }
    }

}