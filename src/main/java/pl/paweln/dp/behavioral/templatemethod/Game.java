package pl.paweln.dp.behavioral.templatemethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Game {
    private static final Logger logger = LoggerFactory.getLogger(Game.class);

    protected int currentPlayer;
    protected final int totalNumberOfPlayers;

    protected Game(int totalNumberOfPlayers) {
        this.totalNumberOfPlayers = totalNumberOfPlayers;
    }

    public void run() {
        start();
        while (!haveWinner())
            takeTurn();
        logger.info("Player " + getWinningPlayer() + " wins");
    }

    protected abstract int getWinningPlayer();

    protected abstract void takeTurn();

    protected abstract boolean haveWinner();

    protected abstract void start();
}
