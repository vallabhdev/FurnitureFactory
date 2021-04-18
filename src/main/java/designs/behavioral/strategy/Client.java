package designs.behavioral.strategy;

public class Client {
    public static void main(String[] args) {
        Player tennisPlayer = PlayerCreator.valueOf("TENNIS").createPlayer();
    }
}
