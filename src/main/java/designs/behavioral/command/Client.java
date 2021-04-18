package designs.behavioral.command;

import designs.behavioral.strategy.Player;

public class Client {
    public static void main(String[] args) {
        Player tennis = new PlayerCreator().createPlayer("TENNIS");
    }
}
