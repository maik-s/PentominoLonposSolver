package Stones;

/**
 * Created by maiks on 17-Aug-15.
 */
public class E extends Stone {

    public E() {
        super(1, new StoneType[][]{
                {StoneType._, StoneType.E, StoneType._},
                {StoneType.E, StoneType.E, StoneType.E},
                {StoneType._, StoneType.E, StoneType._},
        });
    }

    @Override
    public StoneType getID() {
        return StoneType.E;
    }
}
