package Boards;

import Stones.StoneType;

import java.util.Arrays;

/**
 * Created by maiks on 24.11.2015.
 */
public class BoardTemplate{

    private StoneType[][] board;

    public BoardTemplate() {
        board = null;
    }

    /** Returns a new board with empty and placed fields.
     * @param pFields the board represented as StoneType[][].
     *                all fields need to be empty.
     * @param pPlaced an array with coordinates of boardplaces which
     *                should be marked as placed.
     * @return a new board with the layout of pFields and placed fields
     * specified in pPlaced.
     */
    public StoneType[][] getBoard(StoneType[][] pFields, int[][] pPlaced) {
        board = pFields;
        for (StoneType[] row: board) {
            Arrays.fill(row, StoneType._);
        }
        for(int[] xy : pPlaced) {
            int x = xy[0];
            int y = xy[1];
            pFields[x][y] = StoneType.X;
        }
        return board;
    }

    public StoneType[][] initBoard(int pHeight, int pWidth) {
        StoneType[][] lBoard = new StoneType[pHeight][pWidth];
        for (int i = 0; i < lBoard.length; i++) {
            for (int j = 0; j < lBoard[0].length; j++) {
                lBoard[i][j] = StoneType._;
            }
        }
        return lBoard;
    }

    public String getName() {
        return this.getClass().getName();
    }
}
