package assignment1.items;

public abstract class StoreItem {
    private double price;
    private int happinessIndex;
    public StoreItem(double price, int happinessIndex){
        if(price < 0 || happinessIndex < 0){
           throw new IllegalArgumentException("At least one of the inputs is negative, please enter a value greater or equal to 0");
        }
        this.price = price;
        this.happinessIndex = happinessIndex;
    }
    public final double getPrice(){
        return price;
    }
    public int getHappinessIndex(){
        return happinessIndex;
    }
    public boolean equals(Object o){
        if(o instanceof StoreItem) {
            StoreItem obj = (StoreItem) o;
            if (Math.abs(obj.getPrice() - this.price) < 0.001) {
                if (obj.getHappinessIndex() == this.getHappinessIndex()) {
                    return true;
                }
            }
        }
        return false;
    }
}
