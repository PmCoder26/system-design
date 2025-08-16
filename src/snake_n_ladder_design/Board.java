package snake_n_ladder_design;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Board {

    private Cell[][] cells;

    public Board(int boardSize, int snakeCount, int ladderCount) {
        initializeCells(boardSize);
        addSnakesLadders(snakeCount, ladderCount);
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for(int x = 0; x < boardSize; x++) {
            for(int y = 0; y < boardSize; y++) {
                Cell cell = new Cell();
                cells[x][y] = cell;
            }
        }
    }

    private void addSnakesLadders(int snakeCount, int ladderCount) {
        while(snakeCount > 0) {
            // you can also use Random(), the below one is used in multi-threading programs.
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if(snakeHead <= snakeTail) continue;;

            Jump jump = new Jump(snakeHead, snakeTail);      // here, used as a snake.
            Cell cell = getCell(snakeHead);
            cell.setJump(jump);

            snakeCount--;
        }

        while(ladderCount > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if(ladderStart >= ladderEnd) continue;

            Jump jump = new Jump(ladderStart, ladderEnd);      // here, used as a ladder.
            Cell cell = getCell(ladderStart);
            cell.setJump(jump);

            ladderCount--;
        }
    }

    public Cell getCell(int playerPosition) {
        int row = playerPosition / cells.length;
        int column = playerPosition % cells.length;
        return cells[row][column];
    }

}
