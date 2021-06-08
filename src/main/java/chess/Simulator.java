package chess;

import chess.factory.Piece;
import chess.factory.PieceFactory;

import java.util.Set;

public class Simulator {
    private final Board board;
    private final PieceFactory pieceFactory;

    public Simulator() {
        this.board = new Board();
        this.pieceFactory = new PieceFactory();
    }

    public Set<String> moveSuggestions(String pieceOnSpot) {
        String[] splittedQuery = pieceOnSpot.split(" ");
        String pieceType = splittedQuery[0].toLowerCase();
        String spot = splittedQuery[1];

        Piece piece = pieceFactory.getPieceByType(pieceType);
        return piece.suggestions(spot, board);
    }
}
