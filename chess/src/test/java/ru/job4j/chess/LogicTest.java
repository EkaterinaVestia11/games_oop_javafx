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
        assertThat(logic.move(Cell.C1 ,Cell.B2) ,is(true));
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
        assertThat(logic.move(Cell.C1 ,Cell.F4) ,is(false));
    }

    @Test
    public void WhereNoFindFigure( ) {
        Logic logic=new Logic();
        logic.add(new BishopBlack(Cell.F1));
        assertThat(logic.move(Cell.F1 ,Cell.H3) ,is(true));
    }
}

