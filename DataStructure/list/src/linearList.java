package src;

import Exception.*;

public class linearList<E> implements list<E> {
    private int size;
    private int capacity;
    private int current;    // 데이터가 들어갈 인덱스를 의미
    private E[] list;

    public linearList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.current = 0;
        this.list = (E[]) new Object[capacity];
    }

    public linearList() {
        this(10);
    }


    @Override
    public void add(E item) {
        if (isFull()) {
            throw new ListFullException();
        }
        list[current] = item;
        current++;
        size++;
    }

    @Override
    public void add(E item, int index) {
        if (isFull()) {
            throw new ListFullException();
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("size = " + size);
        }
        int len = size - index;
        System.arraycopy(list, index, list, index+1, len);
        list[index] = item;
        current++;
        size++;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        E object = list[--current];
        list[current] = null;
        size--;
        return object;
    }

    @Override
    public E remove(int index) {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("size = " + size);
        }
        E object = list[index];
        int len = size - index - 1;
        System.arraycopy(list, index+1, list, index, len);
        size--;
        current--;
        list[current] = null;
        return object;
    }

    @Override
    public int search(E item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public void print() {
        int count = 1;
        for (E e : list) {
            if (count == capacity) {
                System.out.println(e);
            } else {
                System.out.print(e + " => ");
                count++;
            }
        }
    }

    public boolean isFull() {
        return capacity <= size ? true : false;
    }

    // for test
    @Override
    public E get(int index) {
        if (index >= capacity || index < 0) {
            throw new IndexOutOfBoundsException("size : " + size);
        }
        return list[index];
    }
}
