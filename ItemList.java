package assignment1;

import assignment1.items.StoreItem;

public class ItemList {
    private StoreItem[] items;
    private int size;

    public ItemList() {
        items = new StoreItem[10];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public StoreItem[] getAllItems() {
        StoreItem[] temp = new StoreItem[this.getSize()];
        int tempIndex = 0;

        for(int i = 0; i < items.length; i++) {
            StoreItem curr = items[i];

            if(curr != null) {
                boolean isDuplicate = false;

                for (int j = 0; j < tempIndex; j++) {
                    if (temp[j] ==curr) {
                        isDuplicate = true;
                        break;
                    }
                }

                if(!isDuplicate) {
                    temp[tempIndex] = curr;
                    tempIndex++;
                }

            }
        }

        StoreItem[] returning = new StoreItem[tempIndex];
        for(int i = 0; i < tempIndex; i++){
            returning[i] = temp[i];
        }

        return returning;
    }

    public void addItem(StoreItem add){
        if(size >= items.length) {
            resize();
        }
        items[size] = add;
        size++;
    }
    private void resize(){
        StoreItem[] resizedArray = new StoreItem[items.length *2];
        for(int i = 0; i < items.length; i++){
            resizedArray[i] = items[i];
        }
        items = resizedArray;
    }

    public StoreItem removeItem(StoreItem s){
        for(int i = 0; i < size; i++){
            if(items[i].equals(s)) {
                StoreItem removed = items[i];
                for(int j = i; j < size -1; j++){
                    items[j] = items[j+1];
                }

                items[size - 1] = null;
                size--;
                return removed;
            }
        }
        return null;
    }

    public StoreItem[] findEqualItems(StoreItem s){
        int count = 0;
        for(int i = 0; i < size; i++) {
            if(items[i].equals(s)){
                count++;
            }
        }

        StoreItem[] returning = new StoreItem[count];
        int index = 0;

        for(int i = 0; i < size; i++){
            if(items[i].equals(s)){
                returning[index] = items[i];
                index++;
            }
        }

        return returning;
    }
}
