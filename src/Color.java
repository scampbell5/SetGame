import java.util.Comparator;
/*
Color property currently allows for 3 different color variations:
{"red", "green", "purple"}
Color is assigned based on a color index of:
0 == RED
1 == GREEN
2 == PURPLE
Also allows for a value > 2, finding the modulus of the amount of colors to choose from. Currently: 3
Ex.
9 % 3 == 0 - Color index of RED
10 % 3 == 1 - Color index of 1 == GREEN
11 % 3 == 2 - Color index of 2 == PURPLE
 */


public class Color extends Property {
    public Color(int colorIndex){
        super(new String[]{"red", "green", "purple"}, colorIndex);
    }
}
