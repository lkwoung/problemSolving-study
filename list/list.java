public interface list<E> {
    public void add(E item);

    public void add(E item, int index);

    public E remove();

    public E remove(int index);

    public int search(E item);

    public boolean isEmpty();

    public void print();
}
