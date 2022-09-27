package Boards;

import Stones.StoneType;

/**
 * Created by maiks on 24.11.2015.
 */
class Yellow extends BoardTemplate implements Boardable {

    public StoneType[][] getBoard() {
        BoardTemplate boardTemplate = new BoardTemplate();
        StoneType[][] field = boardTemplate.initBoard(8,8);
        int[][] placed = {{0,0},{0,7},{7,0},{7,7}};
        return boardTemplate.getBoard(field, placed);
    }
}
