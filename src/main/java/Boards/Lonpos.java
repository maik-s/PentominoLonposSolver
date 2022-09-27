package Boards;

import Stones.StoneType;

/**
 * Created by maiks on 24.11.2015.
 */
public class Lonpos extends BoardTemplate implements Boardable {

    public StoneType[][] getBoard() {
        BoardTemplate boardTemplate = new BoardTemplate();
        StoneType[][] field = boardTemplate.initBoard(9,9);
        int[][] placed = {{0,6},{0,7},{0,8},{1,7},{1,8},{2,8},{3,2},{5,7},{5,8},{6,0},{6,6},{6,7},{6,8},{7,0},{7,1},{7,5},{7,6},{7,7},{7,8},{8,0},{8,1},{8,2},{8,5},{8,6},{8,7},{8,8}};
        return boardTemplate.getBoard(field, placed);
    }
}
