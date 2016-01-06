import java.util.Comparator;

/*
Shape property currently allows for 3 different shape variations:
{"diamond", "squiggle", "oval"}
Shape is assigned based on a shape index of:
0 == DIAMOND
1 == SQUIGGLE
2 == OVAL
Also allows for a value > 2, finding the modulus of the amount of colors to choose from. Currently: 3
Ex.
9 % 3 == 0 - Shape index of DIAMOND
10 % 3 == 1 - Shape index of 1 == SQUIGGLE
11 % 3 == 2 - Shape index of 2 == OVAL
 */

public class Shape extends Property {
    public Shape(int shapeIndex) {
        super(new String[]{"diamond", "squiggle", "oval"}, shapeIndex);
    }
}

