package Stones;

/**
 * Created by maiks on 19-Aug-15.
 */
public class L extends Stone {

    public L() {
        super(8, new StoneType[][]{
                {StoneType.L, StoneType.L, StoneType.L, StoneType.L},
                {StoneType.L, StoneType._, StoneType._, StoneType._}
        });
    }

    @Override
    public StoneType getID() {
        return StoneType.L;
    }
}
