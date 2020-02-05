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
      Cell first = C1;
      Cell second = D2;
      Figure bishopBlack = new BishopBlack(C1);
      assertEquals(bishopBlack.position() ,C1);
    }

      @Test (expected= IllegalStateException.class)
    public void whereIsWay( ) {
      Cell f = C1;
      Cell sec = G5;
      Figure bishopBlack = new BishopBlack(f);
      assertThat(bishopBlack.way(f, sec), is(new Cell[]{D2, E3, F4, G5}));
    }

    @Test
    public void whereFigureIsCopy( ) {
      Cell dest = Cell.B2;
      Figure bishopBlack = new BishopBlack(B2);
      assertThat(bishopBlack.copy(dest).position(),is(dest));
    }
}