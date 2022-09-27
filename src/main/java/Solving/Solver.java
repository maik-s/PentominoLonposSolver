package Solving;

import Boards.Boardable;
import Boards.Calendar;
import Boards.Lonpos;
import Serializer.*;
import Stones.*;

import java.io.File;


/**
 * Created by maiks on 17-Aug-15.
 */
public class Solver {

    private Board board;
    private Stone[] stones;
    private int cntSolutions;
    private boolean stop;
    private String dir;
    private Serializable[] serializer;

    public Solver(Boardable pBoard, Stone[] pStones) {
        board = new Board(pBoard);
        stones = pStones;
        cntSolutions = 0;
        stop = false;
        dir = "/tmp/";
        serializer = new Serializable[]{new SVGSerializer(), new SVGBoardSerializer()};
        String path = dir + "solutions-" + pBoard.getName() + "/";
        for (Serializable ser : serializer) {
            File file = new File(path + "/" + ser.readableName() + "/");
            if (file.mkdirs() == false) {
                System.err.println("could not create path " + path);
                System.exit(-1);
            }
            ser.init(file.getAbsolutePath());
        }
        findSolution();
        for (Serializable ser : serializer) {
            ser.finish(cntSolutions);
        }
    }


    public static void main(String[] args) {
        Stone[] allStones = new Stone[]{
                new A(), new B(), new C(),
                new D(), new E(), new F(),
                new G(), new H(), new I(),
                new J(), new K(), new L()
        };
        
        Boardable[] boards = new Boardable[]{new Lonpos()};
        
        for (Boardable actBoard : boards) {
            Solver solver = new Solver(actBoard, allStones);
        }

    }

    public boolean findSolution() {
        StoneDoner doner = new StoneDoner(stones);
        StoneType[][] stone;
        while (!doner.allStonesPlaced() && (stone = doner.getNextStone()) != null) {
            //System.out.println("try "  + stone);
            int[] xy = board.freeField();
            int x = xy[0];
            int y = xy[1];
            Stone currentStone = doner.getAsStone(); // gets the current stone to count pieces.
            if (board.fits(x, y, stone, currentStone.getCountPieces())) {
                // System.out.println("set on (" + x + "|" + y + ") " + stone);
                boolean setStone = board.setStone(x, y, stone, currentStone.getCountPieces());
                assert setStone;
                doner.setAsSet();
                //System.out.println(board);

                if (doner.allStonesPlaced() || board.isFull()) {
                    // serialize pBoard...
                    cntSolutions++;
                    serialize(board, cntSolutions);
                    if (stop) {
                        return true;
                    } else {
                        Stone toDelete = doner.undo();
                        board.deleteStoneFromBoard(toDelete);
                    }
                } else {
                    if (findSolution()) {
                        return true;
                    } else {
                        Stone toDelete = doner.undo();
                        board.deleteStoneFromBoard(toDelete);
                    }
                }
            }
        }
        return false;
    }


    private void serialize(Board pBoard, int pCntSolutions) {
        for (Serializable ser : serializer) {
            if (ser instanceof BoardSerializable) {
                if (pCntSolutions < 2){
                    ser.serialize(pBoard, pCntSolutions);
                }
            } else {
                ser.serialize(pBoard, pCntSolutions);
            }
        }
    }
}
