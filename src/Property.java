
/*
Each card will have one definitive property, from Number, Shading, Shape, and Color.
This abstract class is used to help make creating each property easier.
Each property is very similar as they all have an array of properties, and a property index for their unique property.
 */


public abstract class Property {

    private String[] properties;
    private int propertyIndex;
    private String property;

    public Property(String[] properties, int propertyIndex){
        this.properties = properties;
        this.propertyIndex = propertyIndex % properties.length;
        property = properties[propertyIndex];
    }

    public int compare(Property o1, Property o2) {

        if (o1.propertyIndex < o2.propertyIndex) {
            return -1;
        } else if (o1.propertyIndex > o2.propertyIndex) {
            return 1;
        }

        return 0;
    }

    public boolean equals(Object other) {
        return other instanceof Property && this.propertyIndex == ((Property) other).propertyIndex;
    }

    public String getProperty() {
        return property;
    }

    @Override
    public String toString() {
        return property;
    }
}