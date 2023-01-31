public class ringBuffer<E> extends queue<E>{
    public ringBuffer(int capacity) {
        super(capacity);
    }

    public ringBuffer() {
        this(10);
    }
    @Override
    public void enqueue(E item) {
        if (isFull()) {
            throw new FullQueueException();
        }
        gv_queue[gv_rear] = item;
        gv_rear++;
        if (gv_rear >= gv_capacity) {
            gv_rear = gv_rear % gv_capacity;
        }
        gv_size++;
    }

    @Override
    public E dequeue() {
        E item = this.peek();
        gv_queue[gv_front] = null;
        gv_front++;
        if (gv_front >= gv_capacity) {
            gv_front = gv_front % gv_capacity;
        }
        gv_size--;
        return item;
    }

    @Override
    public int search(E target) {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        int min = gv_front <= gv_rear ? gv_front : gv_rear - 1;
        int max = gv_front > gv_rear ? gv_front : gv_rear - 1;
        for (int i = min; i <= max; i++) {
            if (target.equals(gv_queue[i])) {
                return i;
            }
        }
        return -1;
    }
}
