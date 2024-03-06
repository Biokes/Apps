package assignmentsAndTasks;

import TicTacToe.CellOccupiedException;
import TicTacToe.GameBoard;
import TicTacToe.InvalidCellNumberException;
import TicTacToe.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static TicTacToe.CellDisplays.*;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    private GameBoard game;
    @BeforeEach
    void creatNewGameBoard(){
         game= new GameBoard();
    }
    @Test
    void test_Game_board_cellIsEmptyBeforePlayersPlay(){
        assertEquals(EMPTY, game.checkCell(1));
        assertEquals(EMPTY, game.checkCell(2));
        assertEquals(EMPTY, game.checkCell(3));
        assertEquals(EMPTY, game.checkCell(4));
        assertEquals(EMPTY, game.checkCell(5));
        assertEquals(EMPTY, game.checkCell(6));
        assertEquals(EMPTY, game.checkCell(7));
        assertEquals(EMPTY, game.checkCell(8));
        assertEquals(EMPTY, game.checkCell(9));
    }
    @Test
    void test_invalidCellNumber_throwsExceptions(){
        assertThrows(InvalidCellNumberException.class,()-> game.checkCell(0));
    }
    @Test
    void testGameBoardCellCanChanges(){
        assertEquals(EMPTY, game.checkCell(3));
        game.play(3);
        assertEquals(X, game.checkCell(3));
    }

    @Test
    void playGame_testOtherCellsAreEmpty(){
        assertEquals(EMPTY, game.checkCell(3));
        assertEquals(EMPTY, game.checkCell(4));
        game.play(3);
        game.play(4);
        assertEquals(X, game.checkCell(3));
        assertEquals(O, game.checkCell(4));
        assertEquals(EMPTY, game.checkCell(1));
        assertEquals(EMPTY, game.checkCell(2));
        assertEquals(EMPTY, game.checkCell(5));
        assertEquals(EMPTY, game.checkCell(6));
        assertEquals(EMPTY, game.checkCell(7));
        assertEquals(EMPTY, game.checkCell(8));
        assertEquals(EMPTY, game.checkCell(9));
    }
    @Test
    void test_cellCannotBePlayedIntoTwice(){
        assertEquals(EMPTY, game.checkCell(3));
        game.play(3);
        assertThrows(CellOccupiedException.class,()->game.play(3));
    }
    @Test
    void testInvalidNumbersThrowsException(){
        assertThrows(InvalidCellNumberException.class,()->game.play(10));
        assertThrows(InvalidCellNumberException.class,()->game.play(0));
        assertThrows(InvalidCellNumberException.class,()->game.play(-1289));
        assertThrows(InvalidCellNumberException.class,()->game.play(89));

    }
    @Test
    void test_gameBoardWinnerCanBeDeclared(){
        for(int count =0; ++count <10;){
            game.play(count);
        }
        assertEquals(X, game.checkCell(1));
        assertEquals(O, game.checkCell(2));
        assertEquals(X, game.checkCell(3));
        assertEquals(O, game.checkCell(4));
        assertEquals(X, game.checkCell(5));
        assertEquals(O, game.checkCell(6));
        assertEquals(X, game.checkCell(7));
        assertEquals(O, game.checkCell(8));
        assertEquals(X, game.checkCell(9));
        assertEquals("Draw",game.result());
        for(int count = 0; ++count < 10;) {
            int finalCount = count;
            assertThrows(CellOccupiedException.class, () -> game.play(finalCount));
        }
    }

}
