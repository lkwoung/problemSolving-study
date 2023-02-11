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
        for (int i = 0; i < gv_size; i++) {
            int index = (gv_front + i) % gv_capacity;
            if (target.equals(gv_queue[index])) {
                return index;
            }
        }
        return -1;
    }
}
