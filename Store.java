package assignment1;

import assignment1.items.*;

public class Store {
    private ItemList available;
    private double totalRevenue;

    public Store(ItemList i) {
        available = i;
        totalRevenue = 0;
    }

    public double getRevenue() {
        return totalRevenue;
    }

    public ItemList getItems() {
        return available;
    }

    public void cleanUp() {
        StoreItem[] items = available.getAllItems();

        for (int i = 0; i < items.length; i++) {
            if (items[i] instanceof Snack) {
                if (((Snack) items[i]).isExpired()) {
                    available.removeItem(items[i]);
                }
            }
        }
    }

    public int completeSale(ItemList customerList) {
        int returningHappiness = 0;

        for (int i = 0; i < customerList.getSize(); i++) {
            StoreItem item = customerList.getAllItems()[i];
            StoreItem[] itemFound = available.findEqualItems(item);
            if (itemFound.length == 0) {
                continue;
            }
            if (itemFound.length > 0) {
                if (item instanceof Drink) {
                    for (int j = 0; j < itemFound.length; j++) {

                        Drink wantedDrink = (Drink) itemFound[j];
                        int availableAmount = wantedDrink.getNumOfBottles();

                        int bottlesSold = 0;
                        if (availableAmount >= ((Drink) item).getNumOfBottles()) {
                            bottlesSold += ((Drink) item).getNumOfBottles();
                            wantedDrink.getPortion(((Drink) item).getNumOfBottles());
                        } else {
                            bottlesSold += availableAmount;
                            wantedDrink.getPortion(availableAmount);
                        }

                        if (wantedDrink.getNumOfBottles() == 0) {
                            available.removeItem(wantedDrink);
                        }

                        totalRevenue += wantedDrink.getPrice() * bottlesSold;
                        returningHappiness += wantedDrink.getHappinessIndex() * bottlesSold;
                    }
                } else {
                    available.removeItem(itemFound[0]);
                    totalRevenue += itemFound[0].getPrice();
                    returningHappiness += itemFound[0].getHappinessIndex();
                }
            }
        }

        return returningHappiness;
    }

    public void refillDrinkInventory(Drink[] drinks) {
        for (int i = 0; i < drinks.length; i++) {
            Drink target = drinks[i];
            StoreItem[] equalDrinks = available.findEqualItems(target);


            for (int j = 0; j < equalDrinks.length; j++) {
                Drink equal = (Drink) equalDrinks[j];
                equal.combine(target);
            }
            if (target.getNumOfBottles() > 0) {
                available.addItem(target);
            }
            //}

               /* System.out.println("did you ever get here else part");
                 StoreItem[] temp = available.getAllItems();
                    for(int k = 0; k < temp.length; k++){
                        System.out.println(temp[k]);
                    }
                    System.out.println("break");

                System.out.println(d[i]);
                System.out.println(d[i].getPrice() + "  " + d[i].getNumOfBottles() + "  " + d[i].getHappinessIndex());*/
            //available.addItem(drinks[i]);

        }

    }
}
