import java.util.Comparator;
/*
Used to sort cards based on shape.
 */
public class SortCardByShape implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.getShape().compare(o1.getShape(), o2.getShape());
    }
}
