package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.QueenBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void moveBishopTest()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));

        ImpossibleMoveException impossibleMoveException =
                assertThrows(ImpossibleMoveException.class, () -> logic.move(Cell.C1, Cell.H7));

        assertThat(impossibleMoveException.getMessage()).
                isEqualTo("Could not move by diagonal from C1 to H7");
    }

    @Test
    public void freeTest() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new QueenBlack(Cell.E3));

        OccupiedCellException occupiedCellException =
                assertThrows(OccupiedCellException.class, () -> logic.move(Cell.C1, Cell.H6));

        assertThat(occupiedCellException.getMessage()).
                isEqualTo("Ячейка занята");
    }

    @Test
    public void foundFigureTest() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));

        FigureNotFoundException figureNotFoundException =
                assertThrows(FigureNotFoundException.class, () -> logic.move(Cell.D2, Cell.H6));

        assertThat(figureNotFoundException.getMessage()).
                isEqualTo("Фигуры нет на клетке");
    }
}