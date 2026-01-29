package de.hilling.chess;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortTest {

    List<Integer> sortedIntegerList;
    List<Integer> unsortedIntegerList;

    @BeforeEach
    void setUp() {
        Sort.setDebug(true);
        sortedIntegerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        unsortedIntegerList = Arrays.asList(4, 7, 9, 10, 5, 3, 1, 2, 8, 6);
    }

    @Test
    void compareDifferentPositionsSort() {
        assertEquals(sortedIntegerList, Sort.sort(unsortedIntegerList));
    }
}