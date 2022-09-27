package Stones;

/**
 * Created by maiks on 17-Aug-15.
 */
public class I extends Stone {

    public I() {
        super(1, new StoneType[][]{
                {StoneType.I, StoneType.I},
                {StoneType.I, StoneType.I}
        });
    }

    @Override
    public StoneType getID() {
        return StoneType.I;
    }
}
