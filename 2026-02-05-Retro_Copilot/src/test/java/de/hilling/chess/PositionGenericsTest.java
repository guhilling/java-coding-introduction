package de.hilling.chess;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositionGenericsTest {
    static final Position A1 = Position.of("a1");
    static final Position A2 = Position.of("a2");
    static final Position B1 = Position.of("b1");
    static final Position B2 = Position.of("b2");

    List<Position> positionList;
    List<Position> randomPositionList;
    Collection<Position> randomCollection;
    List<Integer> sortedIntegerList;
    List<Integer> unsortedIntegerList;

    @BeforeEach
    void setUp() {
        positionList = Arrays.asList(A1, A2, B1, B2);
        randomPositionList = Arrays.asList(A2, B1, A1, B2, A1);
        randomCollection = Arrays.asList(A1, B1, A2, B2);
        sortedIntegerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        unsortedIntegerList = Arrays.asList(4, 7, 9, 10, 5, 3, 1, 2, 8, 6);
    }

    @Test
    void compareDifferentPositions() {
        Collection<Position> positions = randomPositionList;
        List bareList = randomPositionList;
        List<Object> objectList = bareList;
        // List<Object> objectList = randomPositionList;
    }

    @Test
    void sortIntegerList() {
        Collections.sort(unsortedIntegerList);
        assertEquals(1, unsortedIntegerList.getFirst());
        assertEquals(sortedIntegerList, unsortedIntegerList);
    }
}