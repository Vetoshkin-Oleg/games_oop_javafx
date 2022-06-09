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
    public void way() {
    }

    @Test
    public void isDiagonal() {
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell dest = Cell.F5;
        Figure test = bishopBlack.copy(dest);
        assertThat(dest, is(test.position()));
    }
}