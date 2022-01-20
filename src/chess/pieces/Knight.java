package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "C";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat =  new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		
		p.setValue(position.getRow() - 2, position.getColum() - 1);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		if (getBoard().positionExists(p) && isThereOpponetPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
		p.setValue(position.getRow() - 2, position.getColum() + 1);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		if (getBoard().positionExists(p) && isThereOpponetPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
		p.setValue(position.getRow() + 2, position.getColum() - 1);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		if (getBoard().positionExists(p) && isThereOpponetPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
		p.setValue(position.getRow() + 2, position.getColum() + 1);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		if (getBoard().positionExists(p) && isThereOpponetPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
		
		p.setValue(position.getRow() - 1, position.getColum() - 2);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		if (getBoard().positionExists(p) && isThereOpponetPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
		p.setValue(position.getRow() + 1, position.getColum() - 2);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		if (getBoard().positionExists(p) && isThereOpponetPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
		p.setValue(position.getRow() - 1, position.getColum() + 2);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		if (getBoard().positionExists(p) && isThereOpponetPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
		p.setValue(position.getRow() + 1, position.getColum() + 2);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		if (getBoard().positionExists(p) && isThereOpponetPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
		return mat;
	}

}
