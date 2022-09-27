package Stones;

/**
 * Created by maiks on 17-Aug-15.
 */
public class H extends Stone {


    public H() {
        super(4, new StoneType[][]{
                {StoneType.H, StoneType.H},
                {StoneType.H, StoneType._, StoneType._}
        });
    }

    @Override
    public StoneType getID() {
        return StoneType.H;
    }
}
