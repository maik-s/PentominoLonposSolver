package Serializer;

import Stones.StoneType;

import java.awt.*;

/**
 * Created by maiks on 25.11.2015.
 */
public class ColorTranslator {


    public static Color getStrokeColor() {
        return Color.white;
    }


    public static Color getColor(StoneType pType) {
        switch (pType) {
            case _:
                return Color.decode("#ffffff");
            case X:
                return Color.decode("#a5a4a8"); // beige (holz): 88765e
            case A:
                return Color.decode("#660066");
            case B:
                return Color.decode("#b3ecff");
            case C:
                return Color.decode("#ffb3ff");
            case D:
                return Color.decode("#008000");
            case E:
                return Color.decode("#dad9d8");
            case F:
                return Color.decode("#ffff00");
            case G:
                return Color.decode("#ff9900");
            case H:
                return Color.decode("#ffffff");
            case I:
                return Color.decode("#33ff33");
            case J:
                return Color.decode("#e31c26");
            case K:
                return Color.decode("#cc00cc");
            case L:
                return Color.decode("#0000ff");
            default:
                return Color.decode("#036e50");
        }

    }
}
