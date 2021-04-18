package designs.behavioral.command;

import designs.behavioral.strategy.FootballPlayer;
import designs.behavioral.strategy.Player;
import designs.behavioral.strategy.SnookerPlayer;
import designs.behavioral.strategy.TennisPlayer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PlayerCreator {
    private static final Map<String, Command> PLAYERS;

    static {
        final Map<String, Command> players = new HashMap<>();
        players.put("TENNIS", TennisPlayer::new);
        players.put("FOOTBALL", FootballPlayer::new);
        players.put("SNOOKER", SnookerPlayer::new);
        PLAYERS = Collections.unmodifiableMap(players);
    }

    public Player createPlayer(String type) {
        Command command = PLAYERS.get(type);
        if (command == null) {
            throw new IllegalArgumentException("Invalid playerType supplied.." + type);
        }
        return command.create();
    }
}
