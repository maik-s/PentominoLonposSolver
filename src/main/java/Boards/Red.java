package Boards;

import Stones.StoneType;

/**
 * Created by maiks on 24.11.2015.
 */
public class Red extends BoardTemplate  implements Boardable{
    
    public StoneType[][] getBoard() {
        BoardTemplate boardTemplate = new BoardTemplate();
        StoneType[][] field = boardTemplate.initBoard(8,8);
        int[][] placed = {{2,2},{2,5},{5,2},{5,5}};
        return boardTemplate.getBoard(field, placed);
    }
}
