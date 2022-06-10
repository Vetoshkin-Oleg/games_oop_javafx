package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell test = bishopBlack.position();
        assertThat(test, is(Cell.C8));
    }

    @Test
    public void wayFromD4ToH8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] way = bishopBlack.way(Cell.H8);
        Cell[] expected = new Cell[] {Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        assertEquals(expected, way);
    }

    @Test
    public void wayFromD4ToA1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] way = bishopBlack.way(Cell.A1);
        Cell[] expected = new Cell[] {Cell.C3, Cell.B2, Cell.A1};
        assertEquals(expected, way);
    }

    @Test
    public void wayFromD4ToA7() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] way = bishopBlack.way(Cell.A7);
        Cell[] expected = new Cell[] {Cell.C5, Cell.B6, Cell.A7};
        assertEquals(expected, way);
    }

    @Test
    public void wayFromD4ToG1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] way = bishopBlack.way(Cell.G1);
        Cell[] expected = new Cell[] {Cell.E3, Cell.F2, Cell.G1};
        assertEquals(expected, way);
    }

    @Test
    public void isDiagonalFromD4ToH8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell source = bishopBlack.position();
        Cell dest = Cell.H8;
        boolean isDiagonal = bishopBlack.isDiagonal(source, dest);
        assertTrue(isDiagonal);
    }

    @Test
    public void isNotDiagonalFromD4ToB7() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell source = bishopBlack.position();
        Cell dest = Cell.B7;
        boolean isDiagonal = bishopBlack.isDiagonal(source, dest);
        assertFalse(isDiagonal);
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell dest = Cell.F5;
        Figure test = bishopBlack.copy(dest);
        assertThat(dest, is(test.position()));
    }
}