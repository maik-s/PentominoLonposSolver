package Boards;

import Stones.StoneType;

/**
 * Created by maiks on 24.11.2015.
 */
public class Square3X20 extends BoardTemplate  implements Boardable {
    
    public StoneType[][] getBoard() {
        BoardTemplate boardTemplate = new BoardTemplate();
        StoneType[][] field = boardTemplate.initBoard(3,20);
        int[][] placed = {};
        return boardTemplate.getBoard(field, placed);
    }
}
