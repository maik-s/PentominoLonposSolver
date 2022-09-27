package Boards;

import Stones.StoneType;

/**
 * Created by maiks on 24.11.2015.
 */
public class Calendar extends BoardTemplate implements Boardable{

    private int x;
    private int y;
    private int date;

    public Calendar(int pDate) {
        // pDate = 1
        // pDate = 6
        date = pDate;
        int lDate = pDate - 1;
         x = lDate / 7;
         y = lDate % 7;
    }

    public StoneType[][] getBoard() {
        BoardTemplate boardTemplate = new BoardTemplate();
        StoneType[][] field = boardTemplate.initBoard(5,7);
        int[][] placed = {{x,y},{4,3},{4,4},{4,5},{4,6}};
        return boardTemplate.getBoard(field, placed);
    }

    public String getName() {
        return this.getClass().getName() + date;
    }
}
