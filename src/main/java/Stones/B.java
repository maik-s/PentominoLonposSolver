package Stones;

/**
 * Created by maiks on 17-Aug-15.
 */
public class B extends Stone {

    public B() {
        super(4, new StoneType[][]{
                {StoneType.B, StoneType.B, StoneType.B},
                {StoneType._, StoneType._, StoneType.B},
                {StoneType._, StoneType._, StoneType.B}
        });
    }

    @Override
    public StoneType getID() {
        return StoneType.B;
    }
}
