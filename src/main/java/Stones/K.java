package Stones;

/**
 * Created by maiks on 17-Aug-15.
 */
public class K extends Stone {

    public K() {
        super(4, new StoneType[][]{
                {StoneType.K, StoneType._, StoneType._},
                {StoneType.K, StoneType.K, StoneType._},
                {StoneType._, StoneType.K, StoneType.K}
        });
    }

    @Override
    public StoneType getID() {
        return StoneType.K;
    }
}
