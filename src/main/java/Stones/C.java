package Stones;

/**
 * Created by maiks on 17-Aug-15.
 */
public class C extends Stone {

    public C() {
        super(8, new StoneType[][]{
                {StoneType.C, StoneType.C, StoneType.C, StoneType.C},
                {StoneType._, StoneType.C, StoneType._, StoneType._},
        });
    }

    @Override
    public StoneType getID() {
        return StoneType.C;
    }
}
