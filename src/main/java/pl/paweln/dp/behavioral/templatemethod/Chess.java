package pl.paweln.dp.behavioral.templatemethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chess extends Game {
    private static final Logger logger = LoggerFactory.getLogger(Chess.class);
    private int maxTurns = 10;
    private int turn = 1;

    public Chess() {
        super(2);
    }

    @Override
    protected int getWinningPlayer() {
        return 0;
    }

    @Override
    protected void takeTurn() {
        logger.info("Turn " + (turn++) + " taken by player " + currentPlayer);
        currentPlayer++;
        if (currentPlayer > totalNumberOfPlayers - 1)
            currentPlayer = 0;
    }

    @Override
    protected boolean haveWinner() {
        return turn == maxTurns;
    }

    @Override
    protected void start() {
        logger.info("Start the chess game");
    }
}
