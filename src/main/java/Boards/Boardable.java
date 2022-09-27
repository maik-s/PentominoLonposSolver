package Boards;

import Stones.StoneType;

/**
 * Created by maiks on 24.11.2015.
 */
public interface Boardable {
    String getName();
    StoneType[][] getBoard();
}
