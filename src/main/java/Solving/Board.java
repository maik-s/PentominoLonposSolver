package Solving;

import Boards.Boardable;
import Stones.Stone;
import Stones.StoneType;

public class Board {

    private StoneType[][] board;
    private int setPieces;
    private int availablePieces;

    public Board(Boardable pBoard) {
        board = pBoard.getBoard();
        setPieces = 0;
        availablePieces = countAvailablePieces();
    }


    private int countAvailablePieces() {
        int p = 0;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == StoneType._) {
                    p++;
                }
            }
        }
        return p;
    }

    public boolean isFull() {
        return setPieces == availablePieces;
    }

    public boolean fits(int pX, int pY, StoneType[][] pStone, int pCountPieces) {
        StoneType[][] stone = pStone;
        int lX = pX;
        int lY = pY;
        int offset = this.stoneOffset(stone);
        if (availablePieces - setPieces < pCountPieces) {
            return false;
        }
        for (int x = 0; x < stone.length; x++) {
            for (int y = 0; y < stone[0].length; y++) {
                if ((stone[x][y] != StoneType._)) {
                    int rX = lX + x;
                    int rY = lY + y - offset;
                    if (rY < 0 || rX >= board.length || rY >= board[x].length) {
                        // its not in the board bounds
                        return false;
                    }
                    if (board[rX][rY] != StoneType._) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public boolean setStone(int pX, int pY, StoneType[][] pStone, int pCountPieces) {
        /*
        assert (fits(pX, pY, pStone));
        if (!fits(pX, pY, pStone)) {
            return false;
        }*/

        StoneType[][] stone = pStone;
        int lX = pX;
        int lY = pY;
        int offset = this.stoneOffset(stone);
        for (int x = 0; x < stone.length; x++) {
            for (int y = 0; y < stone[0].length; y++) {
                if (stone[x][y] != StoneType._) {
                    int rX = lX + x;
                    int rY = lY + y - offset;
                    assert rY >= 0;
                    assert board[rX][rY] == StoneType._;
                    board[rX][rY] = pStone[x][y];
                }
            }
        }
        setPieces += pCountPieces;
        return true;
    }

    public int[] freeField() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == StoneType._) {
                    return new int[]{x, y};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int stoneOffset(StoneType[][] pStone) {
        for (int x = 0; x < pStone[0].length; x++) {
            if (pStone[0][x] != StoneType._) {
                return x;
            }
        }
        return 0;
    }

    public void deleteStoneFromBoard(Stone pStone) {
        if (pStone == null) {
            return;
        }
        int removedPieces = 0;
        for (int x = 0; x < board.length && removedPieces < pStone.getCountPieces(); x++) {
            for (int y = 0; y < board[0].length && removedPieces < pStone.getCountPieces(); y++) {
                if (board[x][y] == pStone.getID()) {
                    board[x][y] = StoneType._;
                    removedPieces++;
                }
            }
        }
        setPieces -= removedPieces;
    }

    public StoneType[][] getBoard() {
        return board;
    }

    public String toString() {
        String out = "";
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                out += board[x][y].toString() + "|";
            }
            out += "\n";
        }
        return out;
    }
}