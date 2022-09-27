package Serializer;


import Solving.Board;

/**
 * Created by maiks on 20-Aug-15.
 */
public interface Serializable {

    public void init(String pPath);

    public void border(int pStroke);

    public void serialize(Solving.Board pBoard, int pSolutionNumber);

    public void finish(int pCountSolutions);

    public String readableName();

}
