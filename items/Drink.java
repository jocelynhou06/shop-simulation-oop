package assignment1.items;

public abstract class Drink extends StoreItem{
    public static int MAX_PACK_SIZE;
    public static int BUZZY_HAPPINESS_BOOST;
    protected int availableBottles;
    private boolean isBuzzy;
    public Drink(double p, int h, int numOfBottles, boolean b){
        super(p, h);
        //price and happiness per bottle, not a pack
        this.availableBottles = numOfBottles;
        this.isBuzzy = b;
    }
    public int getNumOfBottles(){
        return this.availableBottles;
    }
    public int getHappinessIndex(){
        if(isBuzzy){
            return super.getHappinessIndex() + BUZZY_HAPPINESS_BOOST;
        }
        else{
            return super.getHappinessIndex();
        }
    }

    public boolean equals(Object o){
        /*if(super.equals(o)){
            if (o instanceof Drink) {
                Drink obj = (Drink) o;
                if (obj.isBuzzy == this.isBuzzy) {
                    return true;
                }
            }
        }
        return false;*/
        if(!(o instanceof Drink)){
            return false;
        }

        Drink obj = (Drink) o;

        if(!super.equals(o)){
            return false;
        }

        return obj.isBuzzy == this.isBuzzy;
    }
    public boolean combine(Drink d){
    //&& d.getNumOfBottles() > 0

        if(this.equals(d)) {
            if (this.availableBottles < Drink.MAX_PACK_SIZE) {

                int bottlesMoved = Math.min(Drink.MAX_PACK_SIZE - this.availableBottles, d.availableBottles);
                        //Drink.MAX_PACK_SIZE - this.availableBottles;

                this.availableBottles = this.availableBottles + bottlesMoved;
                d.availableBottles = d.availableBottles - bottlesMoved;

                return true;
            }
        }

        return false;
    }
    public abstract Drink getPortion(int i);
}