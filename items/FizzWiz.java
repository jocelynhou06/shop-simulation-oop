package assignment1.items;

public class FizzWiz extends Drink{
    public FizzWiz(double p, int h, int numOfBottles){
        super(p, h, numOfBottles, true);
    }

    public boolean equals(Object o){
        if(super.equals(o)) {
            if (o instanceof FizzWiz) {
                return true;
            }
        }
        return false;
    }

    public Drink getPortion(int i){
        if(i <= this.availableBottles){
            FizzWiz newFizzWiz = new FizzWiz(this.getPrice(), this.getHappinessIndex(), i);
            this.availableBottles = this.availableBottles - i;
            return newFizzWiz;
        }
        else{
            return null;
        }
    }
}