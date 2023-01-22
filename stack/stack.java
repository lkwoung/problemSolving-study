import java.util.EmptyStackException;

public class stack<E> {
    private int gv_top = 0;
    private int gv_size = 0;
    private E[] gv_array;

    public stack(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        this.gv_array = (E[]) new Object[capacity];
        this.gv_size = capacity;
    }

    public stack() {
        this(10);
    }

    public synchronized E pop() {
        E object = this.peek();
        gv_top--;
        return object;
    }

    public synchronized void push(E item) {
        if (gv_top == gv_size) {
            throw new FullStackException();
        }
        gv_array[gv_top++] = item;
    }

    public synchronized E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return gv_array[gv_top-1];
    }

    public synchronized int search(E item) {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        for (int i = gv_top-1; i > -1; i--) {
            if (item.equals(gv_array[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return gv_top == 0 ? true : false;
    }

    public void checkState(){
        System.out.println("gv_top = " + gv_top);
        System.out.println("gv_size = " + gv_size);
    }

}
