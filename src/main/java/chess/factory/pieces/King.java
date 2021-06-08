package chess.factory.pieces;

import chess.Board;
import chess.Moves;
import chess.factory.Piece;
import chess.factory.Steps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static chess.Moves.*;
import static chess.factory.Steps.SINGLE;

public class King extends Piece {
    @Override
    public Set<String> suggestions(String spot, Board board) {
        Set<String> suggestions = new HashSet<>();
        possibleMoves().forEach(move -> {
            try {
                suggestions.addAll(getNextPosFor(spot, move, board));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("can't move to :" + move.name());
            }
        });
        return suggestions;
    }

    @Override
    public List<Moves> possibleMoves() {
        return Arrays.asList(VERTICAL, HORIZONTAL, DIAGONAL);
    }

    @Override
    public Steps possibleSteps() {
        return SINGLE;
    }

    private List<String> getNextPosFor(String spot, Moves move, Board board) {
        String[][] spots = board.getSpots();
        switch (move) {
            case HORIZONTAL:
                return Arrays.asList(spots[board.findXIndexOf(spot)][board.findYIndexOf(spot) - 1],
                        spots[board.findXIndexOf(spot)][board.findYIndexOf(spot) + 1]);
            case VERTICAL:
                return Arrays.asList(spots[board.findXIndexOf(spot) + 1][board.findYIndexOf(spot)],
                        spots[board.findXIndexOf(spot) - 1][board.findYIndexOf(spot)]);
            case DIAGONAL:
                return Arrays.asList(spots[board.findXIndexOf(spot) + 1][board.findYIndexOf(spot) - 1],
                        spots[board.findXIndexOf(spot) - 1][board.findYIndexOf(spot) - 1],
                        spots[board.findXIndexOf(spot) + 1][board.findYIndexOf(spot) + 1],
                        spots[board.findXIndexOf(spot) - 1][board.findYIndexOf(spot) + 1]);
            default:
                break;
        }
        return null;
    }
}
