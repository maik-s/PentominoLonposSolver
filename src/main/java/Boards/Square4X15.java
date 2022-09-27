package Boards;

import Stones.StoneType;

/**
 * Created by maiks on 24.11.2015.
 */
public class Square4X15 extends BoardTemplate  implements Boardable{
    
    public StoneType[][] getBoard() {
        BoardTemplate boardTemplate = new BoardTemplate();
        StoneType[][] field = boardTemplate.initBoard(4,15);
        int[][] placed = {};
        return boardTemplate.getBoard(field, placed);
    }
}
