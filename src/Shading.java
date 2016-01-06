import java.util.Comparator;

/*
Shading property currently allows for 3 different Shading variations:
{"SOLID", "EMPTY", "STRIPED"}
Shading is assigned based on a Shading index of:
0 == SOLID
1 == EMPTY
2 == STRIPED
Also allows for a value > 2, finding the modulus of the amount of shadings to choose from. Currently: 3
Ex.
9 % 3 == 0 - Shading index of SOLID
10 % 3 == 1 - Shading index of 1 == EMPTY
11 % 3 == 2 - Shading index of 2 == STRIPED
 */


public class Shading extends Property {
    public Shading(int shadingIndex) {
        super(new String[]{"solid", "empty", "striped"}, shadingIndex);
    }
}
