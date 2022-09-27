package Stones;

/**
 * Created by maiks on 17-Aug-15.
 */
public class D extends Stone {

    public D() {
        super(8, new StoneType[][]{
                {StoneType._, StoneType.D, StoneType.D, StoneType.D},
                {StoneType.D, StoneType.D, StoneType._, StoneType._},
        });
    }

    @Override
    public StoneType getID() {
        return StoneType.D;
    }


}
