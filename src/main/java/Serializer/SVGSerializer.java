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
public class SVGSerializer implements Serializable {
    private String path;
    private String NAME = "svg_solutions";
    private int stroke = 0; // stroke the quadrats in svg in px

    public SVGSerializer() {
        path = null;
    }

    @Override
    public void init(String pPath) {
        path = pPath;
        if (!path.endsWith("/") || !path.endsWith("\\")) {
            path += "/";
        }
    }

    public void border(int pStroke) {
        stroke = pStroke;

    }
    @Override
    public void serialize(Board pBoard, int pSolutionNumber) {
        PrintWriter writer = null;
        StoneType[][] board = pBoard.getBoard();
        int height = board.length;
        int width = board[0].length;
        int factor = 65;
        String svgBoard = "";

        int svgHeight = height * factor;
        int svgWidth = width * factor;
        Color strokeColor = ColorTranslator.getStrokeColor();

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                Color actColor = this.getColor(board[x][y]);
                int red = actColor.getRed();
                int green = actColor.getGreen();
                int blue = actColor.getBlue();
                int strokeRed = strokeColor.getRed();
                int strokeGreen = strokeColor.getGreen();
                int strokeBlue = strokeColor.getBlue();

                svgBoard += "<rect x=\"" + y * factor + "\" y=\"" + x * factor + "\" width=\"" + factor + "\" height=\"" + factor + "\" style=\"fill:rgb(" + red + "," + green + "," + blue + ");stroke-width:" + stroke + ";stroke:rgb(" + strokeRed + "," + strokeGreen + "," + strokeBlue + ")" + "\" />\n";
            }
        }

        String svg =
                "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"" + svgWidth + "\" height=\"" + svgHeight + "\" version=\"1.1\">\n" +
                        svgBoard +
                        "</svg>";
        File outputFile = new File(path + "/" + "solution" + pSolutionNumber + ".svg");
        try {
            writer = new PrintWriter(outputFile);
            writer.print(svg);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void finish(int pCountSolutions) {

    }

    @Override
    public String readableName() {
        return NAME;
    }

    public Color getColor(StoneType pType) {
        return ColorTranslator.getColor(pType);
    }
}
