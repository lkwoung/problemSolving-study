public class queue<E> implements queueInterface<E>{
    protected E[] gv_queue;
    protected int gv_front;
    protected int gv_rear;
    protected int gv_size;
    protected int gv_capacity;

    public queue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        this.gv_front = 0;
        this.gv_rear = 0;
        this.gv_size = 0;   // 큐에 들어간 데이터의 개수
        this.gv_capacity = capacity;    // 큐의 크기
        this.gv_queue = (E[]) new Object[capacity];
    }

    public queue() {
        this(10);
    }
    @Override
    public void enqueue(E item) {
        if (this.isFull()) {
            throw new FullQueueException();
        }
        gv_queue[gv_rear] = item;
        gv_rear++;
        gv_size++;
    }
    @Override
    public E dequeue() {
        E item = this.peek();
        int lv_len = gv_size - 1;
        if (lv_len > 0) {
            System.arraycopy(gv_queue, 1, gv_queue, 0, lv_len);
        }
        gv_rear--;
        gv_size--;
        gv_queue[gv_rear] = null;
        return item;
    }
    @Override
    public E peek() {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        return gv_queue[gv_front];
    }
    @Override
    public int search(E target) {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        for (int i = 0; i < gv_rear; i++) {
            if (target.equals(gv_queue[i])) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public void checkState() {
        System.out.println("gv_front = " + gv_front);
        System.out.println("gv_rear = " + gv_rear);
        System.out.println("gv_size = " + gv_size);
        System.out.println("gv_capacity = " + gv_capacity);
        for (E item : gv_queue) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    @Override
    public boolean isEmpty() {
        return gv_size <= 0 ? true : false;
    }
    @Override
    public boolean isFull() {
        return gv_size >= gv_capacity ? true : false;
    }

}
