import java.util.Comparator;
/*
Used to sort cards based on color.
 */
public class SortCardByColor implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.getColor().compare(o1.getColor(),o2.getColor());
    }
}
