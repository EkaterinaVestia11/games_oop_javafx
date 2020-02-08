package ru.job4j.chess;

import org.hamcrest.Matcher;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Cell.*;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void WhereFigureStep( ) {
        Logic logic=new Logic();
        logic.add(new BishopBlack(Cell.C1));
        assertThat(logic.move(Cell.C1 ,Cell.A3) ,is(true));
    }

    @Test
    public void WhereErrorFigureStep( ) {
        Logic logic=new Logic();
        logic.add(new BishopBlack(Cell.C1));
        assertThat(logic.move(Cell.C1 ,Cell.C2) ,is(false));
    }

    @Test
    public void WhereBlockedPath( ) {
        Logic logic=new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.D2));
        assertThat(logic.move(Cell.C1 ,Cell.F4) ,is(true));
    }

    @Test(expected=WhereNoFindFigure.class)
    public void WhereNoFindFigure( ) {
        Logic logic=new Logic();
        logic.add(new BishopBlack(Cell.C1));
        assertThat(logic.move(Cell.C1 ,Cell.G5) ,is(true));
    }

    private class WhereNoFindFigure extends Throwable {
    }
}
