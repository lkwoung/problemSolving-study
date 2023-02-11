package src;

import Exception.*;

public class linkedList<E> implements list<E>{

    class node<E> {
        E data;
        node<E> link;

        protected node(E data, node<E> link) {
            this.data = data;
            this.link = link;
        }
    }

    protected node<E> head;
    protected node<E> tail;
    protected node<E> current;
    protected int size;

    public linkedList() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.size = 0;
    }

    @Override
    public void add(E item) {
        // add to tail default
        node<E> newNode = new node<>(item, null);
        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.link = newNode;
            tail = current = newNode;
        }
        size++;
    }

    @Override
    public void add(E item, int index) {
        // add item between head and tail
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("size : " + size);
        }

        node<E> newNode = new node<>(item, null);

        if (index == 0) { // head
            newNode.link = head;
            head = newNode;
        } else if (index == size) { // tail
            tail.link = newNode;
            tail = newNode;
        } else { // middle
            node<E> ptr = head;
            int cnt = 0;
            while (cnt < index - 1) {
                ptr = ptr.link;
                cnt++;
            }
            newNode.link = ptr.link;
            ptr.link = newNode;
        }

        current = newNode;
        size++;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }

        E object = tail.data;

        if (head.link == null) {
            head = current = tail = null;
        } else {
            node<E> ptr = head;
            node<E> pre = head;
            while (ptr.link != null) {
                pre = ptr;
                ptr = ptr.link;
            }
            pre.link = null;
            tail = current = pre;
        }
        size--;

        return object;
    }

    @Override
    public E remove(int index) {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("size : " + size);
        }

        E object = null;
        if (head.link == null) {
            object = head.data;
            head = tail = current = null;
        } else {
            node<E> ptr = head;
            node<E> pre = head;
            for (int i = 0; i < index; i++) {
                pre = ptr;
                ptr = ptr.link;
            }
            object = ptr.data;
            pre.link = ptr.link;
            current = pre;
            if (index == size - 1) { // if remove tail element
                tail = pre;
            }
        }
        size--;

        return object;
    }

    @Override
    public int search(E item) {
        if (isEmpty()) {
            throw new ListEmptyException();
        }

        node<E> ptr = head;
        int count = 0;
        do {
            if (item.equals(ptr.data)) {
                return count;
            }
            count++;
            ptr = ptr.link;
        } while (ptr.link != null);

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0 ? true : false;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        node<E> ptr = head;
        while (ptr != null) {
            if (ptr == tail) {
                System.out.println(ptr.data);
            } else {
                System.out.print(ptr.data + " => ");
            }
            ptr = ptr.link;
        }
    }

    @Override
    public E get(int index) {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("size : " + size);
        }

        node<E> ptr = head;
        for (int i = 0; i < index; i++) {
            ptr = ptr.link;
        }

        return ptr.data;
    }

    public void status() {
        if (isEmpty()) {
            throw new ListEmptyException();
        } else {
            System.out.println("size = " + size);
            System.out.println("head.data = " + head.data);
            System.out.println("tail.data = " + tail.data);
            System.out.println("current.data = " + current.data);
        }

    }
}
