package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void whereCheckPosition( ) {
      Cell first = Cell.C1;
      Cell second = Cell.D2;
      Figure bishopBlack = new BishopBlack(C1);
      assertEquals(bishopBlack.position() ,C1);
    }

    @Test
    public void whereIsWay( ) {
      Cell first = Cell.C1;
      Cell second = Cell.G5;
      Figure bishopBlack = new BishopBlack(first);
      assertThat(bishopBlack.way(first, second), is(new Cell[]{D2, E3, F4, G5}));
    }

    @Test
    public void whereFigureIsCopy( ) {
      Cell dest = Cell.B2;
      Figure bishopBlack = new BishopBlack(B2);
      assertThat(bishopBlack.copy(dest).position(),is(dest));
    }
}