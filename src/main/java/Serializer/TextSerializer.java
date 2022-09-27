package Serializer;

import Solving.Board;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by maiks on 09.11.2015.
 */
public class TextSerializer implements Serializable {

    private String path = null;
    private PrintWriter writer = null;
    private long startTime;
    private long endTime;
    private int solutionNumber = 1;
    private String NAME = "text-solution";
    private int stroke;

    @Override
    public void init(String pPath) {
        path = pPath;
        if (!path.endsWith("/") || !path.endsWith("\\")) {
            path += "/";
        }
        String fileName = "text_solutions" + ".txt";
        File file = new File(path + "/" + fileName);
        try {
            writer = new PrintWriter(file, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        startTime = System.currentTimeMillis();
        writer.println("Started " + startTime);
        stroke = 0;
    }

    @Override
    public void border(int pStroke) {
        stroke = pStroke;
    }

    @Override
    public void serialize(Board pBoard, int pSolutionNumber) {
        writer.println("Solution " + solutionNumber + " found.");
        writer.println(pBoard);
        solutionNumber++;
    }

    @Override
    public void finish(int pCountSolutions) {
        endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        int seconds = (int) (elapsedTime / 1000) % 60;
        writer.println(elapsedTime + " milli seconds needed.");
        writer.close();
    }

    @Override
    public String readableName() {
        return NAME;
    }
}
