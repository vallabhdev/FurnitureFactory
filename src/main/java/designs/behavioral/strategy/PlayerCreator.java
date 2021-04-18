package designs.behavioral.strategy;

public enum PlayerCreator {
    TENNIS {
        @Override
        public Player createPlayer() {
            return new TennisPlayer();
        }
    },
    FOOTBALL {
        @Override
        public Player createPlayer() {
            return new FootballPlayer();
        }
    },
    SNOOKER {
        @Override
        public Player createPlayer() {
            return new SnookerPlayer();
        }
    };

    public abstract Player createPlayer();
}
