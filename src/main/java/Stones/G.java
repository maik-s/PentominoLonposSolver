package Stones;

/**
 * Created by maiks on 17-Aug-15.
 */
public class G extends Stone {

    public G() {
        super(8, new StoneType[][]{
                {StoneType.G, StoneType._, StoneType._},
                {StoneType.G, StoneType.G, StoneType.G}
        });
    }

    @Override
    public StoneType getID() {
        return StoneType.G;
    }
}
