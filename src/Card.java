/*
A card consists of 4 properties
Color {"red", "green", "purple"}
Shape {"diamond", "squiggle", "oval"}
Shading {"solid", "empty", "striped"}
Number {"one", "two", "three"}
*/

public class Card {

    private Color color;
    private Shape shape;
    private Shading shading;
    private Number number;

    public Card (Color color, Shape shape, Shading shading, Number number){
        this.color = color;
        this.shape = shape;
        this.shading = shading;
        this.number = number;
    }

    @Override
    public boolean equals (Object other){
        return other instanceof Card && ((Card) other).color == this.color && ((Card) other).shape == this.shape
                                     && ((Card) other).shading == this.shading && ((Card) other).number == this.number;
    }

    public String toString(){
        return "Color: " + color +" Shape: " + shape + " Shading: " + shading + " Number: " + number;
    }

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }

    public Shading getShading() {
        return shading;
    }

    public Number getNumber() {
        return number;
    }

}
