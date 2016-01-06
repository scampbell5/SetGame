import java.util.Comparator;

/*
Number property currently allows for 3 different Number variations:
{"ONE", "TWO", "THREE"}
Number is assigned based on a Number index of:
0 == ONE
1 == TWO
2 == THREE
Also allows for a value > 2, finding the modulus of the amount of shapes to choose from. Currently: 3
Ex.
9 % 3 == 0 - Number index of ONE
10 % 3 == 1 - Number index of 1 == TWO
11 % 3 == 2 - Number index of 2 == THREE
 */


public class Number extends Property {
    public Number(int numberIndex){
        super(new String[]{"one", "two", "three"}, numberIndex);
    }
}
