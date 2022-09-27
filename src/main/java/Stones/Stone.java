package Stones;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by maiks on 17-Aug-15.
 */
public abstract class Stone {

    private boolean isSet;
    private int maxVariants;
    private StoneType[][] defaultVar;
    private ArrayList<StoneType[][]> variants;
    private int pieces;

    public boolean isSet() {
        return isSet;
    }

    public Stone(int pMaxVariant, StoneType[][] pDefault) {
        maxVariants = pMaxVariant;
        defaultVar = pDefault;
        variants = new ArrayList<StoneType[][]>();
        createVariants();
        removeDuplicates();
        isSet = false;
        pieces = countPieces();
    }

    public int getCountPieces() {
        return pieces;
    }

    private int countPieces() {
        int p = 0;
        for (int x = 0; x < defaultVar.length; x++) {
            for (int y = 0; y < defaultVar[0].length; y++) {
                if (defaultVar[x][y] == this.getID()) {
                    p++;
                }
            }
        }
        return p;
    }
    public void updateSet(boolean pIsSet) {
        isSet = pIsSet;
    }

    public abstract StoneType getID();

    public int getMaxCntVariants() {
        return maxVariants;
    }


    public StoneType[][] getVariant(int pVariant) {
        assert 0 <= pVariant && pVariant < maxVariants;
        return variants.get(pVariant);

    }

    private void createVariants() { //maxVar = maximale Variationen
        int maxVar = this.getMaxCntVariants();
        variants.add(0, defaultVar);
        for (int i = 1; i < maxVar; i++) {
            StoneType[][] newVar;
            if (i == 4) {
                newVar = mirror(variants.get(i - 1));
                //variants.add(i, mirror());
            } else {
                newVar = rotate90(variants.get(i - 1));
                // variants.add(i, );
            }
            variants.add(i, newVar);
        }
    }

    private void removeDuplicates() {
        ArrayList<StoneType[][]> toRemove = new ArrayList<StoneType[][]>();
        for (int i = 0; i < variants.size(); i++) {
            for (int j = i + 1; j < variants.size(); j++) {
                StoneType[][] var = variants.get(i);
                StoneType[][] var2 = variants.get(j);
                if (var != var2 && compareStones(var, var2)) {
                    toRemove.add(var2);
                }
            }
        }

        for (StoneType[][] var2 : toRemove) {
            variants.remove(var2);
            maxVariants--;
        }
    }

    // return false if they are different otherwise true
    private boolean compareStones(StoneType[][] pStone1, StoneType[][] pStone2) {
        if (pStone1.length != pStone2.length || pStone1[0].length != pStone2[0].length) {
            return false;
        } else {
            int xLength = pStone1.length;
            int yLength = pStone1[0].length;
            for (int x = 0; x < xLength; x++) {
                for (int y = 0; y < yLength; y++) {
                    if (pStone1[x][y] != pStone2[x][y]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    private StoneType[][] rotate90(StoneType[][] pStone) {
        int x = pStone.length;
        int y = pStone[0].length;
        StoneType[][] stone = new StoneType[y][x];
        for (int i = 0; i < stone.length; i++) {
            for (int j = 0; j < stone[i].length; j++) {
                stone[i][j] = pStone[j][stone.length - 1 - i];
            }
        }
        return stone;
    }

    private StoneType[][] mirror(StoneType[][] pStone) {
        int x = pStone.length;
        int y = pStone[0].length;
        StoneType[][] stone = new StoneType[x][y];

        for (int i = 0; i < stone.length; i++) {
            for (int j = 0; j < stone[i].length; j++) {
                stone[i][j] = pStone[i][stone[0].length - 1 - j];
            }
        }
        return stone;
    }

    public String toString() {
        return this.getID().name();
    }
}
