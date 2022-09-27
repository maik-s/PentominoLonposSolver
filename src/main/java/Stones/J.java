package Stones;

/**
 * Created by maiks on 17-Aug-15.
 */
public class J extends Stone {

    public J() {
        super(8, new StoneType[][]{
                {StoneType.J, StoneType.J, StoneType.J},
                {StoneType.J, StoneType.J, StoneType._}
        });
    }

    @Override
    public StoneType getID() {
        return StoneType.J;
    }
}
