package snake_n_ladder_design;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    private Board board;
    private Deque<Player> players;
    private Dice dice;
    private Player winningPlayer;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winningPlayer = null;
        addPlayers();
    }

    private void addPlayers() {
        players = new LinkedList<>();
        players.add(new Player("p1", 0));
        players.add(new Player("p2", 0));
    }

    public void startGame() {
        while (winningPlayer == null) {
            System.out.println("************************************************************************************");

            // checking the player's turn.
            Player currentPlayer = findPlayerTurn();
            System.out.println("Current player: " + currentPlayer.getId() + ", current position: " + currentPlayer.getCurrentPosition());

            // roll the dice.
            int newPosition = currentPlayer.getCurrentPosition() + dice.rollDice();

            // checking for jump(snake or ladder).
            newPosition = jumpCheck(newPosition);
            currentPlayer.setCurrentPosition(newPosition);
            System.out.println("Current player: " + currentPlayer.getId() + ", current position: " + currentPlayer.getCurrentPosition());

            // checking winning condition.
            if(newPosition > board.getCells().length * board.getCells().length - 1) winningPlayer = currentPlayer;

            System.out.println("************************************************************************************");
        }

        System.out.println("Winner is: " + winningPlayer.getId());
    }

    private Player findPlayerTurn() {
        Player playerTurn = players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }

    private int jumpCheck(int playerPosition) {
        if(playerPosition > board.getCells().length * board.getCells().length - 1) return playerPosition;

        Cell cell = board.getCell(playerPosition);
        Jump jump = cell.getJump();
        if(jump != null) {
            String jumpBy = (jump.getStart() < jump.getEnd()) ? "ladder" : "snake";
            System.out.println("Jump done by: " + jumpBy);
            return jump.getEnd();
        }

        return playerPosition;
    }

}
