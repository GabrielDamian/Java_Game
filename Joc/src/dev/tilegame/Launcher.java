package dev.tilegame;

import dev.tilegame.SQL.SQL;
import dev.tilegame.display.Dispaly;

import java.sql.SQLException;

public class Launcher { //clasa Launcher are doar responsabilitate de a porni jocul

    public static void main(String[] args) throws SQLException {
        SQL.createNewTable();

        //Game game = new Game("Title here",700,700);
        Game game = Game.singletonLauncher("Title here",700,700);
        game.start();
    }
}
