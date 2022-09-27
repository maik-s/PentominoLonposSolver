package Stones;

/**
 * Created by maiks on 17-Aug-15.
 */
public class A extends Stone {


    public A() {
        super(2, new StoneType[][]{{StoneType.A, StoneType.A, StoneType.A, StoneType.A}});
    }

    @Override
    public StoneType getID() {
        return StoneType.A;
    }
}
