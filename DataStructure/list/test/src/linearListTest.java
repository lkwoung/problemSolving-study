package src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exception.*;

class linearListTest {

    list<Integer> list = new linearList<>(5);

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
        list.remove();
        Assertions.assertEquals(null, list.get(4));

        list.remove(0);
        Assertions.assertEquals(2, list.get(0));
    }

    @Test
    void search() {
        // 찾는 경우
        Assertions.assertEquals(0, list.search(1));
        // 못 찾는 경우
        Assertions.assertEquals(-1, list.search(100));
    }

    @Test
    void emptyException() {
        list.remove();
        list.remove();
        list.remove();
        list.remove();
        list.remove();
        Assertions.assertThrows(ListEmptyException.class, () -> list.remove());
    }

    @Test
    void fullException() {
        Assertions.assertThrows(ListFullException.class, () -> list.add(6));
    }

    @Test
    void indexOutOfBoundsException() {
        list.remove();
        list.remove();
//        1 2 3

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(6, 5));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(4, 4));
    }

    @Test
    void indexOutOfBoundsException2() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(6));

        list.remove();
        list.remove();
//        1 2 3

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(4));
    }

}