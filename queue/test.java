public class test {
    public static void main(String[] args) {
        ringBuffer<Integer> queue_a = new ringBuffer<>(5);

        queue_a.enqueue(1);
        queue_a.enqueue(2);
        queue_a.enqueue(3);
        queue_a.enqueue(4);
        queue_a.enqueue(5);
        queue_a.checkState();
        System.out.println();

        queue_a.dequeue();
        queue_a.dequeue();
        queue_a.checkState();
        System.out.println();

        queue_a.enqueue(2);
        queue_a.enqueue(1);
        queue_a.checkState();
        System.out.println();

        queue_a.dequeue();
        queue_a.dequeue();
        queue_a.dequeue();
        queue_a.checkState();
        System.out.println();

        System.out.println(queue_a.search(1));
        System.out.println(queue_a.search(6));
    }
}
