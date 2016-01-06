import java.util.Comparator;
/*
Used to sort cards based on number.
 */
public class SortCardByNumber implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.getNumber().compare(o1.getNumber(),o2.getNumber());
    }
}
