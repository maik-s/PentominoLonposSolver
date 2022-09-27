package Boards;

import Stones.StoneType;

/**
 * Created by maiks on 24.11.2015.
 */
public class Orange extends BoardTemplate implements Boardable{
    
    public StoneType[][] getBoard() {
        BoardTemplate boardTemplate = new BoardTemplate();
        StoneType[][] field = boardTemplate.initBoard(8,8);
        int[][] placed = {{1,1},{1,6},{6,1},{6,6}};
        return boardTemplate.getBoard(field, placed);
    }
}
