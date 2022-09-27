package Serializer;

import Solving.Board;
import Stones.StoneType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by maiks on 20-Aug-15.
 */
public class ImageSerializer implements Serializable {

    private String path;
    private String NAME = "image_solutions";
    private int stroke;

    public ImageSerializer() {
        path = null;
    }

    @Override
    public void init(String pPath) {
        path = pPath;
        if (!path.endsWith("/") || !path.endsWith("\\")) {
            path += "/";
        }
        stroke = 0;
    }

    @Override
    public void border(int pStroke) {
        stroke = pStroke;
    }

    @Override
    public void serialize(Board pBoard, int pSolutionNumber) {
        border(1);
        StoneType[][] board = pBoard.getBoard();
        int height = board.length;
        int width = board[0].length;
        int factor = 65;
        int imgWidth = width * factor + (width+1) * stroke;
        int imgHeight = height * factor + (height+1) * stroke;

        BufferedImage img = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        g.setColor(ColorTranslator.getStrokeColor());
        g.fillRect(0,0,imgWidth, imgHeight);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color actColor = ColorTranslator.getColor(board[y][x]);
                int xOffset =  x * factor;
                int yOffset =  y * factor;
                g.setColor(actColor);
                g.fillRect(xOffset + (x+1) * stroke, yOffset + (y+1)*stroke, factor, factor);
            }
        }

        File outputFile = new File(path + "/" + "solution" + pSolutionNumber + ".png");

        try {
            ImageIO.write(img, "png", outputFile);
        } catch (IOException e) {
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

}
