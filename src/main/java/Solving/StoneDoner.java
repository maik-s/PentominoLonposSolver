package Solving;

import Stones.Stone;
import Stones.StoneType;

import java.util.Stack;

/**
 * Created by maiks on 17-Aug-15.
 */
public class StoneDoner {

    private Stone[] stones;
    private int currentStone;
    private int variant;


    public StoneDoner(Stone[] pStones) {
        currentStone = 0;
        stones = pStones;
        variant = -1;
    }

    public StoneType[][] getNextStone() {
        assert !this.allStonesPlaced();
        if (hasVariants() && !stones[currentStone].isSet()) {
            variant++;
            StoneType[][] nextVar = stones[currentStone].getVariant(variant);
            return nextVar;
        } else {
            variant = 0;
            do {
                currentStone++;
            } while (currentStone < stones.length && stones[currentStone].isSet());
            if (currentStone >= stones.length) {
                return null;
            }
            return stones[currentStone].getVariant(variant);
        }
    }

    public Stone getAsStone() {
        return stones[currentStone];
    }
    public void setAsSet() {
        stones[currentStone].updateSet(true);
    }

    // returns true if the doner can give at least one more stone or variation which was not used previously
    public boolean allStonesPlaced() {
        for (Stone stone : stones) {
            if (stone.isSet() == false) {
                return false;
            }
        }
        return true;
    }

    public Stone undo() {
        stones[currentStone].updateSet(false);
        return stones[currentStone];
    }

    private boolean hasVariants() {
        return variant + 1 < stones[currentStone].getMaxCntVariants();
    }
}
