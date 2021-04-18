package designs.behavioral.command;

import designs.behavioral.strategy.Player;

public interface Command {
    Player create();
}
