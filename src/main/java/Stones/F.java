package Stones;

/**
 * Created by maiks on 17-Aug-15.
 */
public class F extends Stone {

    public F() {
        super(4, new StoneType[][]{
                {StoneType.F, StoneType.F, StoneType.F},
                {StoneType.F, StoneType._, StoneType.F}
        });
    }


    @Override
    public StoneType getID() {
        return StoneType.F;
    }
}
