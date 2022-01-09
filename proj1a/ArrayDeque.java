
public class ArrayDeque<T>{
    private T[] items;
    private int size;
//    private int nextLast;
//    private int nextFirst;
    private final int RFACTOR = 2;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
    }
    private void resizeUp(T[]items, int capability, int srcPos, int destPos, int length){
        T[] newItems = (T[]) new Object[capability];
        System.arraycopy(items, srcPos, newItems, destPos, length);
        items = newItems;
    }


    public void addFirst(T item){
        if (items.length == size){
            resizeUp(items,size * RFACTOR, 0, 1, items.length);
        }
        items[0] = item;
        size ++;
    }
    public void addLast(T item){
        if (items.length == size){
            resizeUp(items,size * RFACTOR, 0, 0, items.length);
        }
        items[size] = item;
        size ++;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    public int size(){
        return size;

    }
    public void printDeque(){
        for (int i = 0; i < size; i++){
            System.out.println(items[i] + " ");
        }
        System.out.println();

    }
    public T removeFirst(){
        T res = items[0];
        if(((size - 1)/items.length) < 0.25){
            resizeUp(items, (size-1)*RFACTOR, 1, 0, size-1);
        }
        if (size == 0){
            return null;
        }
        else if (size == 1){
            items[0] = null;
            size --;
            return res;
        }else{
            items[0] = null;
            System.arraycopy(items, 1, items, 0, items.length-1);
            size --;
            return res;
        }
    }
    public T removeLast(){
        T res = items[size-1];
        if(((size - 1)/items.length) < 0.25){
            resizeUp(items, (size-1)*2, 0, 0, items.length-1);
        }
        if (size == 0){
            return null;
        }
        else{
            items[size-1] = null;
            size --;
            return res;
        }

    }

    public T get(int index){
        if (index >= size){
            return null;
        }
       return items[index];
    }
}