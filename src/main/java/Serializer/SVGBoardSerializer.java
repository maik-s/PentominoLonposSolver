package Serializer;

import Solving.Board;
import Stones.StoneType;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by maiks on 09.11.2015.
 */
public class SVGBoardSerializer extends SVGSerializer implements BoardSerializable{

    private final String NAME = "svg_board";

    @Override
    public void init(String pPath) {
        super.init(pPath);
        super.border(1);
    }

    @Override
    public void serialize(Board pBoard, int pSolutionNumber) {
        super.serialize(pBoard, pSolutionNumber);
    }

    @Override
    public void finish(int pCountSolutions) {
        super.finish(pCountSolutions);
    }

    @Override
    public String readableName() {
        return NAME;
    }

    public Color getColor(StoneType pType) {
        switch (pType) {
            case X:
                return ColorTranslator.getColor(pType);
            default:
                return ColorTranslator.getColor(StoneType._); //Color.decode("#ffffff"); // free field
        }
    }
}
