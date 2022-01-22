package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// above
		p.setValue(position.getRow() - 1, position.getColum());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}

		// bellow
		p.setValue(position.getRow() + 1, position.getColum());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}

		// left
		p.setValue(position.getRow(), position.getColum() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}

		// right
		p.setValue(position.getRow(), position.getColum() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}

		// top left diagonal
		p.setValue(position.getRow() - 1, position.getColum() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}

		// top right diagonal
		p.setValue(position.getRow() - 1, position.getColum() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}

		// lower left diagonal
		p.setValue(position.getRow() + 1, position.getColum() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}

		// lower right diagonal
		p.setValue(position.getRow() + 1, position.getColum() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}

		// #special move castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// #special move castling kingside rook
			Position posR1 = new Position(position.getRow(), position.getColum() + 3);
			if (testRookCastling(posR1)) {
				Position p1 = new Position(position.getRow(), position.getColum() + 1);
				Position p2 = new Position(position.getRow(), position.getColum() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColum() + 2] = true;
				}

			}
			// #special move castling queenside rook
			Position posR2 = new Position(position.getRow(), position.getColum() - 4);
			if (testRookCastling(posR2)) {
				Position p1 = new Position(position.getRow(), position.getColum() - 1);
				Position p2 = new Position(position.getRow(), position.getColum() - 2);
				Position p3 = new Position(position.getRow(), position.getColum() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null  && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColum() - 2] = true;
				}

			}

		}

		return mat;
	}

}
