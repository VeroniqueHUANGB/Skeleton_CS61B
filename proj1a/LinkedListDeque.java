import java.util.InputMismatchException;

public class LinkedListDeque<T>{

    public class IntNode{
        public T item;
        public IntNode next;
        public IntNode prev;

        public IntNode(T item, IntNode prev, IntNode next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    private IntNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel =new IntNode((T) new Object(), null, null);
        size = 0;
    }

    public void addFirst(T item){
        if (size == 0) {
            IntNode p = new IntNode(item, sentinel, sentinel);
            sentinel.prev = p;
            sentinel.next = p;
        }else {
            IntNode temp = sentinel.next;
            IntNode p = new IntNode(item, sentinel, temp);
            sentinel.next = p;
            temp.prev = p;
        }
        size++;
    }
    public void addLast(T item){
        if (size == 0){
            IntNode p = new IntNode(item, sentinel, sentinel);
            sentinel.prev = p;
            sentinel.next = p;
        }else {
            /** previous last is the sentinel.prev*/
            IntNode temp = sentinel.prev;
            IntNode p = new IntNode(item, temp, sentinel);
            sentinel.prev = p;
            temp.next = p;
        }
        size ++;

    }
    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        return (size == 0);
    }

    /** Returns the number of items in the deque. */
    public int size(){
        return size;
    }

    /** Prints the items in the deque from first to last,
     * separated by a space. Once all the items have been printed,
     * print out a new line.
     */
    public void printDeque(){
        IntNode p = sentinel;
        while (p.next != sentinel){
            p = p.next;
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * */
    public T removeFirst(){
        if (size == 0){
            return null;
        }
        if (size == 1) {
            IntNode res = sentinel.next;
            sentinel.next = null;
            sentinel.prev = null;
            size --;
            return res.item;
        }
        IntNode temp = sentinel.next.next;
        IntNode res = sentinel.next;
        sentinel.next = temp;
        temp.prev = sentinel;
        size --;
        return res.item;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     * */
    public T removeLast(){
        if (size == 0){
            return null;
        }
        if (size == 1){
            IntNode res = sentinel.prev;
            sentinel.next = null;
            sentinel.prev = null;
            size --;
            return res.item;
        }
        IntNode temp = sentinel.prev.prev;
        IntNode res = sentinel.prev;
        temp.next = sentinel;
        sentinel.prev = temp;
        size --;
        return res.item;
    }
    /**
     * Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque!
     * */
    public T get(int index){
        if (index < 0 || index > size-1){
            return null;
        }
        IntNode p = sentinel;
        for (int i = 0; i < index; i++){
            p = p.next;
        }
        p = p.next;
        return p.item;
    }
    /** Same as get, but uses recursion.*/
    public T getRecursion(int index){
        if (index == 0 ){
            return sentinel.next.item;
        }
        else{
            return getRecursion(index - 1);
        }
    }
}