import java.util.Comparator;
/*
Used to sort cards based on shading.
 */
public class SortCardByShading implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.getShading().compare(o1.getShading(), o2.getShading());
    }
}
