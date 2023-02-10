package src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exception.*;

class linkedListTest {
    linkedList<Integer> list = new linkedList<>();

    @BeforeEach
    void beforeEach() {
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(3, 2);
    }

    @Test
    void add() {
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(3, list.get(2));
        Assertions.assertEquals(4, list.get(3));
        Assertions.assertEquals(5, list.get(4));
    }

    @Test
    void remove() {
        Assertions.assertEquals(5, list.remove());
        Assertions.assertEquals(3, list.remove(2));
        Assertions.assertEquals(4, list.remove(2));
        Assertions.assertEquals(2, list.remove());
        Assertions.assertEquals(1, list.remove(0));
    }

    @Test
    void search() {
        Assertions.assertEquals(0, list.search(1));
        Assertions.assertEquals(-1, list.search(100));
    }

    @Test
    void get() {
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(3, list.get(2));
        Assertions.assertEquals(4, list.get(3));
        Assertions.assertEquals(5, list.get(4));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
    }

}